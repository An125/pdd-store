package com.pdd.shopMgr.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdd.common.core.params.page.Page;
import com.pdd.shopMgr.api.service.StoreGoodsService;
import com.pdd.shopMgr.common.params.CollectionParams;
import com.pdd.shopMgr.common.params.GoodsParams;
import com.pdd.shopMgr.common.vo.CollectionVo;
import com.pdd.shopMgr.common.vo.GoodsVo;
import com.pdd.shopMgr.service.operator.StoreGoodsOperator;

/**
 * @描述：商品 Dubbo服务接口实现
 * @作者： wu.liang
 * @日期：Feb 7, 2018
 */
@Service("storeGoodsService")
public class StoreGoodsServiceImpl implements StoreGoodsService {
	
	@Autowired
	private StoreGoodsOperator storeGoodsOperator;

	@Override
	public Page<GoodsVo> getGoodsByParams(GoodsParams goodsParams) throws Exception {
		return storeGoodsOperator.getGoodsByParams(goodsParams);
	}

	@Override
	public GoodsVo goodsSelectOne(GoodsParams goodsParams) throws Exception {
		return storeGoodsOperator.goodsSelectOne(goodsParams);
	}

	/**
	 * 图片上传
	 * @param fastDFS_Id 图片存储在服务器的路径
	 */
	@Override
	public GoodsVo pictureUpload(String id, String fastDFS_Id) throws Exception {
		return storeGoodsOperator.pictureUpload(id,fastDFS_Id);
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月4日
	 * @描述：模糊查询商品
	 */
	@Override
	public Page<GoodsVo> getGoodsByKeywords(GoodsParams goodsParams) throws Exception {
		return storeGoodsOperator.getGoodsByKeywords(goodsParams);
	}


	


	
}
