package com.pdd.shoppingCart.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.pdd.common.core.exceptions.BizException;
import com.pdd.common.core.params.page.Page;
import com.pdd.shoppingCart.api.service.StoreUserShoppingCartService;
import com.pdd.shoppingCart.common.constants.Constants;
import com.pdd.shoppingCart.common.params.StoreUserShoppingCartParams;
import com.pdd.shoppingCart.common.po.StoreGoods;
import com.pdd.shoppingCart.common.po.StoreGoodsPrice;
import com.pdd.shoppingCart.common.po.StoreGoodsPriceExample;
import com.pdd.shoppingCart.common.po.StoreUser;
import com.pdd.shoppingCart.common.po.StoreUserShoppingCart;
import com.pdd.shoppingCart.common.po.StoreUserShoppingCartExample;
import com.pdd.shoppingCart.service.mapper.StoreGoodsMapper;
import com.pdd.shoppingCart.service.mapper.StoreGoodsPriceMapper;
import com.pdd.shoppingCart.service.mapper.StoreUserMapper;
import com.pdd.shoppingCart.service.mapper.StoreUserShoppingCartMapper;
import com.pdd.userMgr.common.vo.StoreUserShoppingCartVo;

@Service("storeUserShoppingCartService")
public class StoreUserShoppingCartServiceImpl implements StoreUserShoppingCartService {

	@Autowired
	private StoreUserShoppingCartMapper storeUserShoppingCartMapper;

	@Autowired
	private StoreGoodsMapper storeGoodsMapper;

	@Autowired
	private StoreUserMapper storeUserMapper;
	
	@Autowired
	private StoreGoodsPriceMapper storeGoodsPriceMapper;

	/**
	 * 添加到购物车
	 */
	@Override
	public StoreUserShoppingCartVo cartAppend(StoreUserShoppingCartParams storeUserShoppingCartParams)
			throws Exception {
		// 1.查找是否有用户和商品
		StoreUser storeUser = storeUserMapper.selectByPrimaryKey(storeUserShoppingCartParams.getUserId());
		StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(storeUserShoppingCartParams.getGoodsId());
		// 2.判断用户输入的数量是否有效，不能大于库存
		if (storeUserShoppingCartParams.getQuantity() > 0
				&& storeUserShoppingCartParams.getQuantity() <= storeGoods.getInventory()) {

			if (storeUser != null && storeGoods != null) {
				// 3.查询购物车是否有该商品
				StoreUserShoppingCart shoppingCart = new StoreUserShoppingCart();
				//复制属性值
				BeanUtils.copyProperties(storeUserShoppingCartParams, shoppingCart);
				
				StoreUserShoppingCartExample example = new StoreUserShoppingCartExample();
				example.createCriteria().andGoodsIdEqualTo(storeUserShoppingCartParams.getGoodsId())
						.andUserIdEqualTo(storeUserShoppingCartParams.getUserId());
				List<StoreUserShoppingCart> cartList = storeUserShoppingCartMapper.selectByExample(example);
				// 1).该商品不存在购物车的情况下：
				if (cartList == null || cartList.isEmpty()) {
					shoppingCart.setUserId(storeUserShoppingCartParams.getUserId());
					shoppingCart.setGoodsId(storeUserShoppingCartParams.getGoodsId());
					shoppingCart.setQuantity(storeUserShoppingCartParams.getQuantity());
					shoppingCart.setStatus(Constants.DB_STOREUSERSHOPPINGCART_STATUS_ENABLED);
					shoppingCart.setCreateDate(new Date());
					int result = storeUserShoppingCartMapper.insertSelective(shoppingCart);
					if (result > 0) {
						StoreUserShoppingCartVo cartVo = new StoreUserShoppingCartVo();
						BeanUtils.copyProperties(shoppingCart, cartVo);
						return cartVo;
					} else {
						throw BizException.DB_INSERT_RESULT_0;
					}
					// 2).该商品已存在购物车的情况
				} else {
					int newQuantity = 0;
					for (StoreUserShoppingCart cart : cartList) {
						shoppingCart.setId(cart.getId());
						newQuantity = cart.getQuantity() + storeUserShoppingCartParams.getQuantity();
					}
					// 数量不能大于库存
					if (newQuantity <= storeGoods.getInventory()) {
						shoppingCart.setQuantity(newQuantity);
						shoppingCart.setUpdateDate(new Date());
						int result = storeUserShoppingCartMapper.updateByExampleSelective(shoppingCart,
								example);
						if (result > 0) {
							StoreUserShoppingCartVo cartVo = new StoreUserShoppingCartVo();
							BeanUtils.copyProperties(shoppingCart, cartVo);
							return cartVo;

						} else {
							throw BizException.DB_UPDATE_RESULT_0;
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * 删除购物车（不是物理上的删除，只是修改状态）
	 */
	@Override
	public StoreUserShoppingCartVo cartRemove(StoreUserShoppingCartParams storeUserShoppingCartParams)
			throws Exception {

		StoreUserShoppingCart shoppingCart = new StoreUserShoppingCart();
		StoreUserShoppingCartExample example = new StoreUserShoppingCartExample();
		example.createCriteria().andUserIdEqualTo(storeUserShoppingCartParams.getUserId())
				.andGoodsIdEqualTo(storeUserShoppingCartParams.getGoodsId());
		shoppingCart.setStatus(Constants.DB_STOREUSERSHOPPINGCART_STATUS_DISABLED);
		shoppingCart.setUpdateDate(new Date());
		int result = storeUserShoppingCartMapper.updateByExampleSelective(shoppingCart, example);
		if (result > 0) {
			StoreUserShoppingCartVo cartVo = new StoreUserShoppingCartVo();
			BeanUtils.copyProperties(shoppingCart, cartVo);
			return cartVo;
		} else {
			throw BizException.DB_UPDATE_RESULT_0;
		}
	}

	/**
	 * 修改购物车
	 */
	@Override
	public StoreUserShoppingCartVo cartModify(StoreUserShoppingCartParams storeUserShoppingCartParams)
			throws Exception {
		// 查找是否有用户和商品
		StoreUser storeUser = storeUserMapper.selectByPrimaryKey(storeUserShoppingCartParams.getUserId());
		StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(storeUserShoppingCartParams.getGoodsId());

		if (storeUser != null && storeGoods != null) {
			// 判断用户输入的数量是否有效
			if (storeUserShoppingCartParams.getQuantity() <= storeGoods.getInventory()
					&& storeUserShoppingCartParams.getQuantity() > 0) {
				StoreUserShoppingCart shoppingCart = new StoreUserShoppingCart();
				StoreUserShoppingCartExample cartExample = new StoreUserShoppingCartExample();
				cartExample.createCriteria().andUserIdEqualTo(storeUserShoppingCartParams.getUserId())
						.andGoodsIdEqualTo(storeUserShoppingCartParams.getGoodsId());
				shoppingCart.setQuantity(storeUserShoppingCartParams.getQuantity());
				shoppingCart.setUpdateDate(new Date());
				int result = storeUserShoppingCartMapper.updateByExampleSelective(shoppingCart, cartExample);
				if (result > 0) {
					StoreUserShoppingCartVo cartVo = new StoreUserShoppingCartVo();
					BeanUtils.copyProperties(shoppingCart, cartVo);
					return cartVo;
				} else {

					throw BizException.DB_UPDATE_RESULT_0;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 查询购物车所有商品--分页
	 */
	@Override
	public Page<StoreUserShoppingCartVo> cartPageSelect(StoreUserShoppingCartParams storeUserShoppingCartParams)
			throws Exception {
		// 查找是否有该用户
		StoreUser storeUser = storeUserMapper.selectByPrimaryKey(storeUserShoppingCartParams.getUserId());
		if (storeUser != null) {
			StoreUserShoppingCartExample example = new StoreUserShoppingCartExample();
			example.createCriteria().andUserIdEqualTo(storeUserShoppingCartParams.getUserId())
					.andStatusEqualTo(Constants.DB_STOREUSERSHOPPINGCART_STATUS_ENABLED);
			// 查询该用户有效的总数（状态为1的）
			int count = storeUserShoppingCartMapper.countByExample(example);
			if (count > 0) {
				PageHelper.startPage(storeUserShoppingCartParams.getPageNo(),
						storeUserShoppingCartParams.getPageSize());
				
				example.createCriteria().andUserIdEqualTo(storeUserShoppingCartParams.getUserId());
				List<StoreUserShoppingCart> cartList = storeUserShoppingCartMapper.selectByExample(example);
				Iterator<StoreUserShoppingCart> iterator = cartList.iterator();
				List<StoreUserShoppingCartVo> list = new ArrayList<StoreUserShoppingCartVo>(cartList.size());
				StoreUserShoppingCart storeUserShoppingCart;
				while (iterator.hasNext()) {
					StoreUserShoppingCartVo cartVo = new StoreUserShoppingCartVo();
					storeUserShoppingCart = iterator.next();
					BeanUtils.copyProperties(storeUserShoppingCart, cartVo);
					
					//根据遍历得到的goodsId查询商品信息
					StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(storeUserShoppingCart.getGoodsId());
					cartVo.setGoodName(storeGoods.getGoodName());
					cartVo.setGoodIntroduce(storeGoods.getGoodIntroduce());
					cartVo.setPicUrl(storeGoods.getPicUrl());
					//根据该用户绑定的商铺id和遍历到的goodsId查询商品报价（推荐价格）
					StoreGoodsPriceExample priceExample = new StoreGoodsPriceExample();
					priceExample.createCriteria().andGoodIdEqualTo(storeUserShoppingCart.getGoodsId()).andShopIdEqualTo(storeUser.getShopId());
					List<StoreGoodsPrice> priceList = storeGoodsPriceMapper.selectByExample(priceExample);
					for(StoreGoodsPrice price : priceList) {
						cartVo.setQuotePrice(price.getQuotePrice());
					}
					
					list.add(cartVo);
				}
				
				Page<StoreUserShoppingCartVo> page = new Page<StoreUserShoppingCartVo>(
						storeUserShoppingCartParams.getPageNo(), storeUserShoppingCartParams.getPageSize(), count,
						list);
				return page;
			} else {
				return null;
			}
		} else {
			throw BizException.DB_SELECTONE_IS_NULL;
		}
	}

}
