package com.pdd.shopMgr.webServer.controller;


import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.params.page.Page;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.shopMgr.api.service.StoreGoodsService;
import com.pdd.shopMgr.common.params.GoodsParams;
import com.pdd.shopMgr.common.vo.GoodsVo;


/**
 * 商品管理
 * 
 * @描述：商品控制器 @作者： wu.liang
 * @日期：Feb 6, 2018
 */
@RestController
@RequestMapping("/shopMgr")
public class GoodsController{
	private static Logger LOG = Logger.getLogger(GoodsController.class);

	@Autowired
	private StoreGoodsService storeGoodsService;

	/**
	 * 查询商品
	 * @param goodsParams
	 */
	@RequestMapping("/goodsQuery")
	public MsgReturn<Page<GoodsVo>> goodsQuery(GoodsParams goodsParams, HttpServletResponse response) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<Page<GoodsVo>> msg = new MsgReturn<Page<GoodsVo>>();
		try {
			
			// 2、参数校验
			if(goodsParams.getPageNo() == 0) {
				goodsParams.setPageNo(1);
			}else if(goodsParams.getPageSize() == 0) {
				goodsParams.setPageSize(10);
			}
			
			// 3、处理业务逻辑
			Page<GoodsVo> goodsPage = storeGoodsService.getGoodsByParams(goodsParams);
			
			// 4、把对象设置进返回消息中
			if(goodsPage == null) {
				msg.failed();
			}else {
				msg.setReturnObj(goodsPage);
				msg.success();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}
		
		// 5、将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
	}
	
	/**
	 * 
	 * @作者：ppx
	 * @日期：2018年3月16日
	 * @描述：查询店铺一个商品详情
	 */
	@RequestMapping("/goodsQueryOne")
	public MsgReturn<GoodsVo> goodsQueryOne(GoodsParams goodsParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<GoodsVo> msg = new MsgReturn<GoodsVo>();

		try {
			// 2、处理业务逻辑
			GoodsVo goodsVo = storeGoodsService.goodsSelectOne(goodsParams);
			// 3、把对象设置进返回消息中
			if (goodsVo != null) {
				msg.setReturnObj(goodsVo);
				msg.success();
			} else {
				msg.failed();
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
	 * @日期：2018年9月4日
	 * @描述：模糊查询商品
	 */
	@RequestMapping("/goodsFuzzySearch")
	public MsgReturn<Page<GoodsVo>> goodsFuzzySearch(GoodsParams goodsParams, HttpServletResponse response) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<Page<GoodsVo>> msg = new MsgReturn<Page<GoodsVo>>();
		try {

			// 2、处理业务逻辑
			Page<GoodsVo> goodsPage = storeGoodsService.getGoodsByKeywords(goodsParams);

			// 3、把对象设置进返回消息中
			if (goodsPage == null) {
				msg.failed();
			} else {
				msg.setReturnObj(goodsPage);
				msg.success();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}

		// 4、将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
	}
}
