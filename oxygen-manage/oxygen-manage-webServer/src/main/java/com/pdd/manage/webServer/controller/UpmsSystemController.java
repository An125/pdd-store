package com.pdd.manage.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.manage.api.service.UpmsSystemService;
import com.pdd.manage.common.params.SystemParams;
import com.pdd.manage.common.vo.SystemVo;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年3月21日
 * @描述：系统管理
 */
@RestController
@RequestMapping("/manage")
public class UpmsSystemController {
	private static Logger LOG = Logger.getLogger(UpmsSystemController.class);
	
	@Autowired
	private UpmsSystemService upmsSystemService;
	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月22日
	 * @描述：新增系统
	 */
	@PostMapping("/systemCreate")
	public MsgReturn<SystemVo> systemCreate(SystemParams systemParams){
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是系统 VO）
		MsgReturn<SystemVo> msg = new MsgReturn<SystemVo>();
		try {
			// 2、处理业务逻辑
			SystemVo vo = upmsSystemService.addSystem(systemParams);
			// 3、把对象设置进返回消息中
			if(vo!=null) {
				msg.setReturnObj(vo);
				msg.success();
			}else {
				msg.failed();
			}
		} catch (Exception e) {
				LOG.error(e.getMessage());
				msg.exception();
		}
		// 4、将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
	}
}
