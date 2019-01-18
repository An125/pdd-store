package com.pdd.shopMgr.api.service;

import com.pdd.common.core.params.page.Page;
import com.pdd.shopMgr.common.params.CollectionParams;
import com.pdd.shopMgr.common.params.GoodsParams;
import com.pdd.shopMgr.common.vo.CollectionVo;
import com.pdd.shopMgr.common.vo.GoodsVo;

/**
 * 
 * @描述：商品 Dubbo 服务接口 
 * @作者： wu.liang
 * @日期：Feb 6, 2018
 */
public interface StoreGoodsService {

	/**
	 * 分页查询
	 * @param goodsParams
	 * @return
	 * @throws Exception
	 */
	public Page<GoodsVo> getGoodsByParams(GoodsParams goodsParams) throws Exception;

	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月16日
	 * @描述：查询商品详情
	 */
	public GoodsVo goodsSelectOne(GoodsParams goodsParams) throws Exception;


	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年8月2日
	 * @描述：图片上传
	 * @param id 商品id
	 *        fastDFS_Id 图片存储在服务器的路径
	 */
	public GoodsVo pictureUpload(String id,String fastDFS_Id) throws Exception;

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月4日
	 * @描述：模糊查询商品
	 */
	public Page<GoodsVo> getGoodsByKeywords(GoodsParams goodsParams) throws Exception;


	
	
}
