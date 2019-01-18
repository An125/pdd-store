package com.pdd.shopMgr.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdd.common.core.params.page.Page;
import com.pdd.shopMgr.api.service.StoreCollectionService;
import com.pdd.shopMgr.common.params.CollectionParams;
import com.pdd.shopMgr.common.vo.CollectionVo;
import com.pdd.shopMgr.service.operator.StoreCollectionOperator;

/**
 * 
 * @作者： ppx
 * @日期：2018年9月13日
 * @描述：收藏夹Dubbo服务接口实现
 */
@Service("storeCollectionService")
public class StoreCollectionServiceImpl implements StoreCollectionService {

	@Autowired
	private StoreCollectionOperator storeCollectionOperator;
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月12日
	 * @描述：收藏和取消收藏共用
	 */
	@Override
	public CollectionVo addOrRemoveCollection(CollectionParams collectionParams) throws Exception {
		
		return storeCollectionOperator.addOrRemoveCollection(collectionParams);
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月13日
	 * @描述：分页查询收藏夹，也可按类别查询（降价、低库存、失效）
	 */
	@Override
	public Page<CollectionVo> getCollectionPaging(CollectionParams collectionParams) throws Exception {
		
		return storeCollectionOperator.getCollectionPaging(collectionParams);
	}
}
