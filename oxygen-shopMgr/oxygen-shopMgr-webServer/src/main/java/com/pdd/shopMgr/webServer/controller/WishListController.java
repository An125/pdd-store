package com.pdd.shopMgr.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.params.page.Page;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.shopMgr.api.service.StoreGoodsService;
import com.pdd.shopMgr.api.service.StoreCollectionService;
import com.pdd.shopMgr.common.params.CollectionParams;
import com.pdd.shopMgr.common.params.GoodsParams;
import com.pdd.shopMgr.common.vo.CollectionVo;
import com.pdd.shopMgr.common.vo.GoodsVo;

/**
 * 
 * @作者： ppx
 * @日期：2018年9月11日
 * @描述：用户收藏夹管理
 */

@RestController
@RequestMapping("/shopMgr")
public class WishListController {
	private static Logger LOG = Logger.getLogger(WishListController.class);
	
	@Autowired
	private StoreCollectionService storeCollectionService;
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月11日
	 * @描述：收藏和取消收藏共用
	 */
	@PostMapping("/goodsCollect")
	public MsgReturn<CollectionVo> goodsCollect(CollectionParams collectionParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是收藏 VO）
		MsgReturn<CollectionVo> msg = new MsgReturn<CollectionVo>();
		
		try {
			// 2、处理业务逻辑
			CollectionVo vo = storeCollectionService.addOrRemoveCollection(collectionParams);
			// 3、把对象设置进返回消息中
			if(vo!=null) {
				msg.success("success");
				msg.setReturnObj(vo);
			}else {
				msg.failed("failure");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}
		// 4、将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月13日
	 * @描述：分页查询收藏夹，也可按类别查询（降价、低库存、失效）
	 */
	@PostMapping("/collectionPagingQuery")
	public MsgReturn<Page<CollectionVo>> collectionPagingQuery(CollectionParams collectionParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是收藏 VO）
		MsgReturn<Page<CollectionVo>> msg = new MsgReturn<Page<CollectionVo>>();
		
		try {
			// 2、处理业务逻辑
			Page<CollectionVo> page = storeCollectionService.getCollectionPaging(collectionParams);
			// 3、把对象设置进返回消息中
			if(page==null) {
				msg.failed("failure");
			}else {
				msg.success("success");
				msg.setReturnObj(page);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}
		// 4、将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
	}
}
