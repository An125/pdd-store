package com.pdd.orderMgr.api.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.oxygen.common.util.StringUtil;
import com.pdd.common.core.exceptions.BizException;
import com.pdd.common.core.params.page.Page;
import com.pdd.orderMgr.api.service.StoreOrderFormService;
import com.pdd.orderMgr.common.constants.Constants;
import com.pdd.orderMgr.common.params.OrderFormParams;
import com.pdd.orderMgr.common.po.StoreGoods;
import com.pdd.orderMgr.common.po.StoreGoodsExample;
import com.pdd.orderMgr.common.po.StoreGoodsPrice;
import com.pdd.orderMgr.common.po.StoreGoodsPriceExample;
import com.pdd.orderMgr.common.po.StoreOrderForm;
import com.pdd.orderMgr.common.po.StoreOrderFormExample;
import com.pdd.orderMgr.common.po.StoreShopGoodsRelation;
import com.pdd.orderMgr.common.po.StoreShopGoodsRelationExample;
import com.pdd.orderMgr.common.po.StoreUser;
import com.pdd.orderMgr.common.po.StoreUserAddress;
import com.pdd.orderMgr.common.vo.OrderFormVo;
import com.pdd.orderMgr.service.mapper.StoreGoodsMapper;
import com.pdd.orderMgr.service.mapper.StoreGoodsPriceMapper;
import com.pdd.orderMgr.service.mapper.StoreOrderFormMapper;
import com.pdd.orderMgr.service.mapper.StoreShopGoodsRelationMapper;
import com.pdd.orderMgr.service.mapper.StoreUserAddressMapper;
import com.pdd.orderMgr.service.mapper.StoreUserMapper;

/**
 * 
 * @作者： zhaoxin
 * 
 * @日期：2018年3月5日
 * 
 *  @描述：
 */
@Service("storeOrderFormService")
public class StoreOrderFormServiceImpl implements StoreOrderFormService {

	@Autowired
	private StoreOrderFormMapper storeOrderFormMapper;
	@Autowired
	private StoreUserMapper storeUserMapper;
	@Autowired
	private StoreUserAddressMapper storeUserAddressMapper;
	@Autowired
	private StoreShopGoodsRelationMapper storeShopGoodsRelationMapper;
	@Autowired
	private StoreGoodsMapper storeGoodsMapper;
	@Autowired
	private StoreGoodsPriceMapper storeGoodsPriceMapper;

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月22日
	 * @描述：生成订单（一种商品对应一条订单）：状态是待付款，同时扣减库存
	 * 
	 */
	@Override
	public OrderFormVo orderAdd(OrderFormParams orderFormParams) throws Exception {
		// 查询用户信息
		StoreUser storeUser = storeUserMapper.selectByPrimaryKey(orderFormParams.getUserId());
		// 判断该用户是否绑定在该商铺下
		if (storeUser.getShopId().equals(orderFormParams.getShopId())) {
			// 查询收货地址
			StoreUserAddress userAddress = storeUserAddressMapper
					.selectByPrimaryKey(orderFormParams.getUserAddressId());
			// 判断收货地址是否属于该用户
			if (userAddress.getUserId().equals(orderFormParams.getUserId())) {
				StoreShopGoodsRelationExample relationExample = new StoreShopGoodsRelationExample();
				relationExample.createCriteria().andShopIdEqualTo(orderFormParams.getShopId())
						.andGoodIdEqualTo(orderFormParams.getGoodId());
				// 查询商铺商品关联表
				List<StoreShopGoodsRelation> relationList = storeShopGoodsRelationMapper
						.selectByExample(relationExample);
				for (StoreShopGoodsRelation relation : relationList) {
					// 判断isEnable是否为1（0不可用，1可用）
					if (relation.getIsEnable().equals(Constants.DB_STORESHOPGOODSRELATION_ISENABLE_YES)) {
						// 查询商品信息
						StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(orderFormParams.getGoodId());
						// 判断购买数量是否小于库存
						if (storeGoods.getInventory() >= orderFormParams.getQuantity()) {

							StoreOrderForm orderForm = new StoreOrderForm();
							// 复制属性值，替代了部分set
							BeanUtils.copyProperties(orderFormParams, orderForm);
							// 商铺商品中间表id
							orderForm.setShopGoodsRelationId(relation.getId());
							// 微信支付订单号UUID
							orderForm.setOrderFormWx(StringUtil.generateUUID());
							// 支付宝支付订单号为公司简称+时间戳+uuid
							orderForm.setOrderFormAl(StringUtil
									.generateUUIDByPrefix(Constants.DB_ORDERFORM_FLAG + System.currentTimeMillis()));
							//状态设为待付款
							orderForm.setState(Constants.DB_STOREORDERFORM_STATE_UNPAID);
							//支付方式默认支付宝余额
							orderForm.setPayMethod(Constants.DB_STOREORDERFORM_PAYMETHOD_BALANCE);
							//产品图片路径
							orderForm.setPath(storeGoods.getPicUrl());
							
							//订单价格（商铺商品关联表的价格乘以数量）
							//java关于BigDecimal 和一个 int类型相乘：BigDecimal 本身封装了运算方法，基础的运算符都无效
							BigDecimal price = relation.getPrice();
							int quantity = orderFormParams.getQuantity();
							BigDecimal orderPrice = price.multiply(new BigDecimal(quantity));
							orderForm.setOrderPrice(orderPrice);
							
							orderForm.setCreateDate(new Date());
							int count = storeOrderFormMapper.insertSelective(orderForm);
							if(count>0) {
								OrderFormVo vo = new OrderFormVo();
								BeanUtils.copyProperties(orderForm, vo);
								//减库存
								StoreGoods goods = new StoreGoods();
								StoreGoodsExample example = new StoreGoodsExample();
								example.createCriteria().andIdEqualTo(orderFormParams.getGoodId());
								goods.setInventory(storeGoods.getInventory()-orderFormParams.getQuantity());
								//更新数据库
								storeGoodsMapper.updateByExampleSelective(goods, example);
								return vo;
							}else {
								throw BizException.DB_INSERT_RESULT_0;
							}
						}
					}
				}
			}
		}
		return null;
	}

	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月22日
	 * @描述：生成订单（购物车多件商品生成一条订单）：状态是待付款，同时扣减库存
	 */
	@Override
	public int orderBatchAdd(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm orderForm = new StoreOrderForm();
		
		//微信支付订单号UUID
		String orderIdForWX = StringUtil.generateUUID();
		//支付宝支付订单号为公司简称+时间戳+uuid
		String orderIdForAL = StringUtil.generateUUIDByPrefix(Constants.DB_ORDERFORM_FLAG + System.currentTimeMillis());
		int count = 0;
		// 遍历接受对象
		//for (OrderFormParams params : orderFormParams) {
			// 查询用户信息
			StoreUser storeUser = storeUserMapper.selectByPrimaryKey(orderFormParams.getUserId());
			// 判断该用户是否绑定在该商铺下
			if (storeUser.getShopId().equals(orderFormParams.getShopId())) {
				// 查询收货地址
				StoreUserAddress userAddress = storeUserAddressMapper.selectByPrimaryKey(orderFormParams.getUserAddressId());
				// 判断收货地址是否属于该用户
				if (userAddress.getUserId().equals(orderFormParams.getUserId())) {
					StoreShopGoodsRelationExample relationExample = new StoreShopGoodsRelationExample();
					relationExample.createCriteria().andShopIdEqualTo(orderFormParams.getShopId())
							.andGoodIdEqualTo(orderFormParams.getGoodId());
					// 查询商铺商品关联表
					List<StoreShopGoodsRelation> relationList = storeShopGoodsRelationMapper
							.selectByExample(relationExample);
					for (StoreShopGoodsRelation relation : relationList) {
						// 判断isEnable是否为1（0不可用，1可用）
						if (relation.getIsEnable().equals(Constants.DB_STORESHOPGOODSRELATION_ISENABLE_YES)) {
							// 查询商品信息
							StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(orderFormParams.getGoodId());
							// 判断购买数量是否小于库存
							if (storeGoods.getInventory() >= orderFormParams.getQuantity()) {
								// 复制属性值，替代了部分set
								BeanUtils.copyProperties(orderFormParams, orderForm);
								// 商铺商品中间表id
								orderForm.setShopGoodsRelationId(relation.getId());

								// 状态设为待付款
								orderForm.setState(Constants.DB_STOREORDERFORM_STATE_UNPAID);
								// 支付方式默认支付宝余额
								orderForm.setPayMethod(Constants.DB_STOREORDERFORM_PAYMETHOD_BALANCE);
								// 产品图片路径
								orderForm.setPath(storeGoods.getPicUrl());
								
								//订单价格（商铺商品关联表的价格乘以数量）
								//java关于BigDecimal 和一个 int类型相乘：BigDecimal 本身封装了运算方法，基础的运算符都无效
								BigDecimal price = relation.getPrice();
								int quantity = orderFormParams.getQuantity();
								BigDecimal orderPrice = price.multiply(new BigDecimal(quantity));
								orderForm.setOrderPrice(orderPrice);
								
								orderForm.setCreateDate(new Date());
								// 微信支付订单号UUID
								orderForm.setOrderFormWx(orderIdForWX);
								// 支付宝支付订单号为公司简称+时间戳+uuid
								orderForm.setOrderFormAl(orderIdForAL);
								count = storeOrderFormMapper.insertSelective(orderForm);
								if (count > 0) {
									//减库存
									StoreGoods goods = new StoreGoods();
									StoreGoodsExample example = new StoreGoodsExample();
									example.createCriteria().andIdEqualTo(orderFormParams.getGoodId());
									goods.setInventory(storeGoods.getInventory()-orderFormParams.getQuantity());
									//更新数据库
									storeGoodsMapper.updateByExampleSelective(goods, example);
								}else {
									throw BizException.DB_INSERT_RESULT_0;
								} 
								
							}
						}
					}
				}
			}
	//}
		return count;
	}
	
	
	/**
	 * 取消订单：状态是失效，同时库存回退
	 */
	@Override
	public int orderDelete(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		int count = 0;
		//判断状态是否为待付款
		if(storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_UNPAID)) {
		StoreOrderForm orderForm = new StoreOrderForm();
		//复制id属性值
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setState(Constants.DB_STOREORDERFORM_STATE_INVALID);
		count = storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		if(count>0) {
			//查询库存
			StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(storeOrderForm.getGoodId());
			StoreGoods goods = new StoreGoods();
			StoreGoodsExample example = new StoreGoodsExample();
			example.createCriteria().andIdEqualTo(storeOrderForm.getGoodId());
			goods.setInventory(storeGoods.getInventory()+storeOrderForm.getQuantity());
			//库存回退
			storeGoodsMapper.updateByExampleSelective(goods, example);
		}
		}
		return count;
	}

	/**
	 * 订单结算（成交）：状态是待发货，同时将购物车中的数据删除
	 * 
	 */
	@Override
	public int orderSubmit(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		//判断订单状态是否为待付款
		if(storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_UNPAID)) {
		StoreOrderForm orderForm = new StoreOrderForm();
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setId(orderFormParams.getId());
		orderForm.setState(Constants.DB_STOREORDERFORM_STATE_UNDELIVERY);
		return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		}
		return 0;
	}

	/**
	 * 修改订单
	 */
	@Override
	public int orderModify(OrderFormParams orderFormParams) throws Exception {
		StoreUserAddress userAddress = storeUserAddressMapper.selectByPrimaryKey(orderFormParams.getUserAddressId());
		StoreOrderForm orderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		if (userAddress != null&&orderForm.getUserId().equals(userAddress.getUserId())) {
			StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(orderForm.getGoodId());
			if (storeGoods.getInventory() >= orderFormParams.getQuantity()) {
				StoreOrderForm storeOrderForm = new StoreOrderForm();
				BeanUtils.copyProperties(orderFormParams, storeOrderForm);
				storeOrderForm.setId(orderFormParams.getId());
				storeOrderForm.setUserAddressId(orderFormParams.getUserAddressId());
				storeOrderForm.setQuantity(orderFormParams.getQuantity());
				 
				return storeOrderFormMapper.updateByPrimaryKeySelective(storeOrderForm);
			}
		}
		return 0; 
	}

	/**
	 * 修改订单价格（实付款）---后台
	 */
	@Override
	public int orderPriceModify(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm orderForm = new StoreOrderForm();
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setId(orderFormParams.getId());
		orderForm.setOrderPrice(orderFormParams.getOrderPrice());
		return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
	}

	/**
	 * 查询一条订单
	 */
	@Override
	public OrderFormVo orderSelectOne(OrderFormParams orderFormParams) throws Exception {
		StoreOrderFormExample example = new StoreOrderFormExample();
		example.createCriteria().andUserIdEqualTo(orderFormParams.getUserId()).andIdEqualTo(orderFormParams.getId());
		// 根据用户id和订单id查询订单信息
		List<StoreOrderForm> list = storeOrderFormMapper.selectByExample(example);
		for (StoreOrderForm orderForm : list) {
			OrderFormVo vo = new OrderFormVo();
			// 复制属性值
			BeanUtils.copyProperties(orderForm, vo);
			// 根据遍历得到的商品id查询商品信息
			StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(orderForm.getGoodId());
			vo.setGoodName(storeGoods.getGoodName());
			vo.setGoodIntroduce(storeGoods.getGoodIntroduce());
			// 根据遍历得到的商品id和商铺id查询商品的报价（推荐价格）
			StoreGoodsPriceExample priceExample = new StoreGoodsPriceExample();
			priceExample.createCriteria().andGoodIdEqualTo(orderForm.getGoodId())
					.andShopIdEqualTo(orderForm.getShopId());
			List<StoreGoodsPrice> priceList = storeGoodsPriceMapper.selectByExample(priceExample);
			for (StoreGoodsPrice goodsPrice : priceList) {
				vo.setQuotePrice(goodsPrice.getQuotePrice());
			}
			// 根据遍历得到的收货地址id查询详细收货地址
			StoreUserAddress userAddress = storeUserAddressMapper.selectByPrimaryKey(orderForm.getUserAddressId());
			vo.setAddress(userAddress.getAddress());

			return vo;
		}
		throw BizException.DB_SELECTONE_IS_NULL;
	}

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月21日
	 * @描述：分页查询或者按类别分页查询（待付、待发、待收、待评）
	 */
	@Override
	public Page<OrderFormVo> orderSelectPaging(OrderFormParams orderFormParams) throws Exception {
		StoreOrderFormExample example = new StoreOrderFormExample();
		//没有传入state参数表示查询全部
		if(orderFormParams.getState()==null) {
			example.createCriteria().andUserIdEqualTo(orderFormParams.getUserId());
		//否则按类别查询
		}else {
			example.createCriteria().andUserIdEqualTo(orderFormParams.getUserId()).andStateEqualTo(orderFormParams.getState());
		}
		//计算有效总条数
		int count = storeOrderFormMapper.countByExample(example);
		//分页插件处理
		PageHelper.startPage(orderFormParams.getPageNo(), orderFormParams.getPageSize());
		
		List<StoreOrderForm> orderList = storeOrderFormMapper.selectByExample(example);
		if (orderList == null || orderList.isEmpty()) {
			return null;
		}
		Iterator<StoreOrderForm> iterator = orderList.iterator();
		List<OrderFormVo> list = new ArrayList<OrderFormVo>(orderFormParams.getPageSize());
		StoreOrderForm storeOrderForm;
		OrderFormVo orderFormVo;
		//迭代器遍历list
		while (iterator.hasNext()) {
			storeOrderForm = iterator.next();
			orderFormVo = new OrderFormVo();
			BeanUtils.copyProperties(storeOrderForm, orderFormVo);
			
			//根据遍历得到的商品id查询商品信息
			StoreGoodsExample goodsExample = new StoreGoodsExample();
			goodsExample.createCriteria().andIdEqualTo(storeOrderForm.getGoodId());
			List<StoreGoods> goodsList = storeGoodsMapper.selectByExample(goodsExample);
			for(StoreGoods goods : goodsList) {
				orderFormVo.setGoodName(goods.getGoodName());
				orderFormVo.setGoodIntroduce(goods.getGoodIntroduce());
			}
			//根据遍历得到的商品id和商铺id查询商品价格表中的报价（推荐价格）
			StoreGoodsPriceExample priceExample = new StoreGoodsPriceExample();
			priceExample.createCriteria().andGoodIdEqualTo(storeOrderForm.getGoodId()).andShopIdEqualTo(storeOrderForm.getShopId());
			List<StoreGoodsPrice> priceList = storeGoodsPriceMapper.selectByExample(priceExample);
			for(StoreGoodsPrice goodsPrice : priceList) {
				orderFormVo.setQuotePrice(goodsPrice.getQuotePrice());
			}
			//根据遍历得到的收货地址id查询详细收货地址
			StoreUserAddress userAddress = storeUserAddressMapper.selectByPrimaryKey(storeOrderForm.getUserAddressId());
			orderFormVo.setAddress(userAddress.getAddress());
			list.add(orderFormVo);
		}
		
		//当PageParam里接收参数没有设默认值时，导致pageNo、pageSize为0，把Page对象里的值覆盖，报“by zero”错
		Page<OrderFormVo> page = new Page<OrderFormVo>(orderFormParams.getPageNo(), orderFormParams.getPageSize(),
				count, list);
		return page;
	}
	


	/**
	 * 商家发货---后台操作
	 * 修改订单状态为待收货
	 */
	@Override
	public int orderDeliver(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		//判断订单状态是否为待发货，是则改成待收货
		if(storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_UNDELIVERY)) {
		StoreOrderForm orderForm = new StoreOrderForm();
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setId(orderFormParams.getId());
		orderForm.setState(Constants.DB_STOREORDERFORM_STATE_UNCOLLECTED);
		return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		}
		return 0;
	}

	/**
	 * 用户确认收货
	 */
	@Override
	public int orderReceipt(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		//判断订单状态是否为待收货，是则改成待评价
		if(storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_UNCOLLECTED)) {
		StoreOrderForm orderForm = new StoreOrderForm();
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setId(orderFormParams.getId());
		orderForm.setState(Constants.DB_STOREORDERFORM_STATE_UNEVALUATE);
		return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		}
		return 0;
	}

	/**
	 * 商品评价
	 * 这里只是改状态，没有实际的评价操作，需要加字段，后期需要再加
	 */
	@Override
	public int orderEvaluate(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		//判断订单状态是否为待评价，是则改成已评价
		if(storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_UNEVALUATE)) {
		StoreOrderForm orderForm = new StoreOrderForm();
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setId(orderFormParams.getId());
		orderForm.setState(Constants.DB_STOREORDERFORM_STATE_BEENEVALUATE);
		return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		}
		return 0;
	}

	/**
	 * 申请退货
	 */
	@Override
	public int orderReturnApply(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		//判断订单状态是否为待评价或已评价，是则改成退货审核
		if(storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_UNEVALUATE)||storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_BEENEVALUATE)) {
		StoreOrderForm orderForm = new StoreOrderForm();
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setId(orderFormParams.getId());
		orderForm.setState(Constants.DB_STOREORDERFORM_STATE_RETURNREVIEW);
		return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		}
		return 0;
	}
	/**
	 * 取消退货
	 */
	@Override
	public int orderReturnCancel(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		//判断订单状态是否为退货审核，是则改成退货审核之前的状态
		if(storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_RETURNREVIEW)||storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_BEENEVALUATE)) {
		StoreOrderForm orderForm = new StoreOrderForm();
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setId(orderFormParams.getId());
		orderForm.setState(Constants.DB_STOREORDERFORM_STATE_UNEVALUATE);
		return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		}
		return 0;
	}

	/**
	 * 商家同意退货---后台操作
	 */
	@Override
	public int orderReturnAgree(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		//判断订单状态是否为退货审核，是则改成退货中
		if(storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_RETURNREVIEW)) {
		StoreOrderForm orderForm = new StoreOrderForm();
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setId(orderFormParams.getId());
		orderForm.setState(Constants.DB_STOREORDERFORM_STATE_INRETURN);
		return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		}
		return 0;
	}

	/**
	 * 商家确认收到退货---后台操作
	 */
	@Override
	public int orderReturnReceive(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		//判断订单状态是否为退货中，是则改成已退货
		if(storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_INRETURN)) {
		StoreOrderForm orderForm = new StoreOrderForm();
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setId(orderFormParams.getId());
		orderForm.setState(Constants.DB_STOREORDERFORM_STATE_BEENRETURN);
		return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		}
		return 0;
	}

	/**
	 * 商家退款---后台操作
	 */
	@Override
	public int orderMerchantRefund(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		//判断订单状态是否为已退货，是则改成已退款
		if(storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_BEENRETURN)) {
		StoreOrderForm orderForm = new StoreOrderForm();
		BeanUtils.copyProperties(orderFormParams, orderForm);
		orderForm.setId(orderFormParams.getId());
		orderForm.setState(Constants.DB_STOREORDERFORM_STATE_REFUNDED);
		return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		}
		return 0;
	}

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月22日
	 * @描述：删除订单即更改状态为-1（状态为0失效、4待评价、5已评价、9已退款才能删除）
	 */
	@Override
	public int orderRemove(OrderFormParams orderFormParams) throws Exception {
		StoreOrderForm storeOrderForm = storeOrderFormMapper.selectByPrimaryKey(orderFormParams.getId());
		// 判断订单状态是否为能被删除的状态
		if (storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_INVALID)
				|| storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_UNEVALUATE)
				|| storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_BEENEVALUATE)
				|| storeOrderForm.getState().equals(Constants.DB_STOREORDERFORM_STATE_REFUNDED)) {
			StoreOrderForm orderForm = new StoreOrderForm();
			orderForm.setId(orderFormParams.getId());
			orderForm.setState(Constants.DB_STOREORDERFORM_STATE_DELETED);
			return storeOrderFormMapper.updateByPrimaryKeySelective(orderForm);
		}
		return 0;
	}


	


}
