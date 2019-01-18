package com.pdd.shopMgr.service.operator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.relation.Relation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.pdd.common.core.exceptions.BizException;
import com.pdd.common.core.params.page.Page;
import com.pdd.shopMgr.common.constants.Constants;
import com.pdd.shopMgr.common.params.CollectionParams;
import com.pdd.shopMgr.common.params.GoodsParams;
import com.pdd.shopMgr.common.vo.CollectionVo;
import com.pdd.shopMgr.common.vo.GoodsVo;
import com.pdd.shopMgr.service.mapper.StoreCollectionMapper;
import com.pdd.shopMgr.service.mapper.StoreGoodsMapper;
import com.pdd.shopMgr.service.mapper.StoreShopGoodsRelationMapper;
import com.pdd.shopMgr.service.mapper.StoreUserMapper;
import com.pdd.shopMgr.service.po.StoreCollection;
import com.pdd.shopMgr.service.po.StoreCollectionExample;
import com.pdd.shopMgr.service.po.StoreGoods;
import com.pdd.shopMgr.service.po.StoreGoodsExample;
import com.pdd.shopMgr.service.po.StoreShopGoodsRelation;
import com.pdd.shopMgr.service.po.StoreShopGoodsRelationExample;
import com.pdd.shopMgr.service.po.StoreShopGoodsRelationExample.Criteria;
import com.pdd.shopMgr.service.po.StoreUser;
import com.pdd.shopMgr.service.po.StoreUserExample;

/**
 * 
 * @描述：商品相关业务 ---- 服务层 @作者： wu.liang
 * @日期：Feb 7, 2018
 */
@Service("storeGoodsOperator")
public class StoreGoodsOperator {

	@Autowired
	private StoreGoodsMapper storeGoodsMapper;
	
	@Autowired
	private StoreShopGoodsRelationMapper storeShopGoodsRelationMapper;


	/**
	 * @描述：分页查找店铺产品（有效产品，状态“isEnable”==1）
	 * @作者：Wu.Liang
	 * @param goodsParams
	 * @return
	 */
	public Page<GoodsVo> getGoodsByParams(GoodsParams goodsParams) {
		/*
		 * 这段代码的业务环境：平台所有商品，对于每个店铺并不是全部展示，店铺可选择部分商品展示在本店铺。 此时首先要查找
		 * 店铺和商品的中间关联表，根据关联表状态判断哪些产品是该店铺展示的产品，然后再查出这些产品详情。 暂时不用此业务逻辑，以后要用时打开注释并格式化它。
		 */

		StoreShopGoodsRelationExample example = new StoreShopGoodsRelationExample();
		StoreShopGoodsRelationExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andShopIdEqualTo(goodsParams.getShopId());
		createCriteria.andIsEnableEqualTo((byte)1);
		
		// 总记录数
		int rowCount = storeShopGoodsRelationMapper.countByExample(example); 
		
		// 分页插件处理
		PageHelper.startPage(goodsParams.getPageNo(), goodsParams.getPageSize());
		List<StoreShopGoodsRelation> shop_goods = storeShopGoodsRelationMapper.selectByExample(example);
		if (shop_goods == null || shop_goods.isEmpty()) {
			return null;
		}

		Iterator<StoreShopGoodsRelation> iterator = shop_goods.iterator();
		StoreShopGoodsRelation s_g;
		StoreGoods goods;
		GoodsVo goodsVo;
		List<GoodsVo> list = new ArrayList<GoodsVo>(goodsParams.getPageSize());
		while (iterator.hasNext()) {
			s_g = iterator.next();
			goods = storeGoodsMapper.selectByPrimaryKey(s_g.getGoodId());
			
			goodsVo = new GoodsVo();
			BeanUtils.copyProperties(goods, goodsVo);
			goodsVo.setPrice(s_g.getPrice());
			list.add(goodsVo);
		}
		Page<GoodsVo> page = new Page<GoodsVo>(goodsParams.getPageNo(), goodsParams.getPageSize(), rowCount, list);
		
		return page;
	}

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月16日
	 * @描述：查询店铺商品详情
	 */
	public GoodsVo goodsSelectOne(GoodsParams goodsParams) {
		StoreShopGoodsRelationExample example = new StoreShopGoodsRelationExample();
		example.createCriteria().andShopIdEqualTo(goodsParams.getShopId()).andGoodIdEqualTo(goodsParams.getGoodId());
		List<StoreShopGoodsRelation> list = storeShopGoodsRelationMapper.selectByExample(example);
		if(list!=null&&!list.isEmpty()) {
			StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(goodsParams.getGoodId());
			GoodsVo goodsVo = new GoodsVo();
			BeanUtils.copyProperties(storeGoods, goodsVo);
			for(StoreShopGoodsRelation relation:list) {
				goodsVo.setPrice(relation.getPrice());
			}
			return goodsVo;
		}
		return null;
	}

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年8月2日
	 * @描述：图片上传
	 * @param fastDFS_Id 图片存储在服务器的路径
	 */
	public GoodsVo pictureUpload(String id, String fastDFS_Id) {
		StoreGoods storeGoods = new StoreGoods();
		StoreGoodsExample example = new StoreGoodsExample();
		example.createCriteria().andIdEqualTo(id);
		List<StoreGoods> list = storeGoodsMapper.selectByExample(example);
		if(list==null||list.isEmpty()) {
			return null;
		}else {
			storeGoods.setPicUrl(fastDFS_Id);
			int result = storeGoodsMapper.updateByExampleSelective(storeGoods, example);
			if(result>0) {
				GoodsVo vo = new GoodsVo();
				BeanUtils.copyProperties(storeGoods, vo);
				return vo;
			}else {
			throw BizException.DB_UPDATE_RESULT_0;
			}
		}
	}

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月4日
	 * @描述：模糊查询商品（根据关键词匹配商品名称、商品描述；并对结果按条件进行排序：综合、价格、销量）
	 * 		 用户只能搜索绑定的商铺下的商品
	 * ========================该接口有问题，再调试==============================
	 */
	public Page<GoodsVo> getGoodsByKeywords(GoodsParams goodsParams) {
		/*// 分页插件处理
		PageHelper.startPage(goodsParams.getPageNo(), goodsParams.getPageSize());
		StoreGoodsExample goodsExample = new StoreGoodsExample();
		//添加模糊查询条件
		goodsExample.createCriteria().andGoodNameLike("%" + goodsParams.getKeyWords() + "%");
		//模糊查询商品
		List<StoreGoods> goodsList = storeGoodsMapper.selectByExample(goodsExample);
		List<StoreShopGoodsRelation> relationList = null;
		int rowCount = 0;
		StoreShopGoodsRelationExample relationExample;
		for(StoreGoods goods : goodsList) {
			relationExample = new StoreShopGoodsRelationExample();
			//添加条件：商品id和上架
			relationExample.createCriteria().andGoodIdEqualTo(goods.getId()).andIsEnableEqualTo((byte)1);
			//有效总条数
			rowCount += storeShopGoodsRelationMapper.countByExample(relationExample);
			//根据遍历到的商品id 查询商铺商品关联表上架的商品
			relationList = storeShopGoodsRelationMapper.selectByExample(relationExample);
			if (relationList.isEmpty()) 
				continue;
			
		}
		Iterator<StoreShopGoodsRelation> iterator = relationList.iterator();
		StoreShopGoodsRelation relation;
		GoodsVo vo;
		List<GoodsVo> list = new ArrayList<GoodsVo>(goodsParams.getPageSize());
		while (iterator.hasNext()) {
			relation = iterator.next();
			vo = new GoodsVo();
			
			vo.setShopId(relation.getShopId());
			vo.setPrice(relation.getPrice());
			list.add(vo);
		}
		
		Page<GoodsVo> page = new Page<GoodsVo>(goodsParams.getPageNo(), goodsParams.getPageSize(), rowCount, list);
		return page;*/
		
		
		// 分页插件处理
		/*PageHelper.startPage(goodsParams.getPageNo(), goodsParams.getPageSize());
		StoreShopGoodsRelationExample relationExample = new StoreShopGoodsRelationExample();
		relationExample.createCriteria().andIsEnableEqualTo((byte)1);
		//查询所有商铺上架的商品
		List<StoreShopGoodsRelation> relationList = storeShopGoodsRelationMapper.selectByExample(relationExample);
		List<GoodsVo> list = new ArrayList<GoodsVo>(goodsParams.getPageSize());
		GoodsVo vo ;
		for(StoreShopGoodsRelation relation : relationList) {
			StoreGoodsExample goodsExample = new StoreGoodsExample();
			goodsExample.createCriteria().andIdEqualTo(relation.getGoodId());
			//根据goodId查询商品
			List<StoreGoods> goodsList = storeGoodsMapper.selectByExample(goodsExample);
			vo = new GoodsVo();
			Pattern pattern = Pattern.compile(goodsParams.getKeyWords(),Pattern.CASE_INSENSITIVE);
			for(StoreGoods goods : goodsList) {
				Matcher matcher = pattern.matcher(goods.getGoodName());
				if(matcher.find()) {   // 另一种方法遍历list后直接判断：if(goods.getGoodName().contains(goodsParams.getKeyWords())){}
					BeanUtils.copyProperties(goods, vo);
					list.add(vo);
				}
			}
		}
		//取出总记录数 
		int rowCount = list.size();
		Page<GoodsVo> page = new Page<GoodsVo>(goodsParams.getPageNo(), goodsParams.getPageSize(), rowCount, list);
		return page;*/
		
		
		StoreGoodsExample goodsExample = new StoreGoodsExample();
		goodsExample.createCriteria().andGoodNameLike("%" + goodsParams.getKeyWords() + "%");
		//不传，则按默认排序
		if(goodsParams.getSortType()==null) {
			
		//按销量
		}else if(goodsParams.getSortType().equals(Constants.SORTTYPE_SALESVOLUME)) {
			goodsExample.setOrderByClause(Constants.ORDERSTRING_SALESVOLUME + " " + Constants.ORDERDIRECTION_DESC);
		//价格升序
		}else if(goodsParams.getSortType().equals(Constants.SORTTYPE_PRICE_ASC)) {
			goodsExample.setOrderByClause(Constants.ORDERSTRING_PRICE+ " " + Constants.ORDERDIRECTION_ASC);
		//价格降序
		}else if(goodsParams.getSortType().equals(Constants.SORTTYPE_PRICE_DESC)) {
			goodsExample.setOrderByClause(Constants.ORDERSTRING_PRICE+ " " + Constants.ORDERDIRECTION_DESC);
		}
		int rowCount = storeGoodsMapper.countByExample(goodsExample);
		// 分页插件处理
		PageHelper.startPage(goodsParams.getPageNo(), goodsParams.getPageSize());
		List<StoreGoods> goodsList = storeGoodsMapper.selectByExample(goodsExample);
		if (goodsList == null || goodsList.isEmpty()) 
			return null;
		Iterator<StoreGoods> iterator = goodsList.iterator();
		StoreGoods storeGoods;
		GoodsVo vo;
		List<GoodsVo> list = new ArrayList<GoodsVo>(goodsParams.getPageSize());
		while (iterator.hasNext()) {
			storeGoods = iterator.next();
			vo = new GoodsVo();
			BeanUtils.copyProperties(storeGoods, vo);
			list.add(vo);
		}
		
		Page<GoodsVo> page = new Page<GoodsVo>(goodsParams.getPageNo(), goodsParams.getPageSize(), rowCount, list);
		return page;
		
	
	}

	
}
