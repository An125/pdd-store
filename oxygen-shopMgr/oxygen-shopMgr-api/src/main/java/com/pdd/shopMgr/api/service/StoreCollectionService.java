package com.pdd.shopMgr.api.service;

import com.pdd.common.core.params.page.Page;
import com.pdd.shopMgr.common.params.CollectionParams;
import com.pdd.shopMgr.common.vo.CollectionVo;

/**
 * 
 * @作者： ppx
 * @日期：2018年9月13日
 * @描述：收藏夹 Dubbo 服务接口 
 */
public interface StoreCollectionService {

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月12日
	 * @描述：收藏和取消收藏共用
	 */
	public CollectionVo addOrRemoveCollection(CollectionParams collectionParams) throws Exception;

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月13日
	 * @描述：分页查询收藏夹，也可按类别查询（降价、低库存、失效）
	 */
	public Page<CollectionVo> getCollectionPaging(CollectionParams collectionParams) throws Exception;
}
