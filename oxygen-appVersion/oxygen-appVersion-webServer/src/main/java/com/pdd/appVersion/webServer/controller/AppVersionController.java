package com.pdd.appVersion.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.appVersion.api.service.AppVersionService;
import com.pdd.appVersion.common.params.AppVersionParams;
import com.pdd.appVersion.common.vo.AppVersionVo;
import com.pdd.common.core.params.returns.MsgReturn;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 
 * @作者： zhaoxin
 * @日期：2018年7月9日
 * @描述：app动态更新
 */
@RestController
@RequestMapping("/appVersion")
@Api(value="app更新Controller",tags= {"app更新接口"})
public class AppVersionController {
	private static Logger LOG = Logger.getLogger(AppVersionController.class);
	
	@Autowired
	private AppVersionService appVersionService;
	
	 /*
     * @ApiOperation(value = "接口说明", httpMethod ="接口请求方式", response ="接口返回参数类型", notes ="接口发布说明"
     *
     * @ApiParam(required = "是否必须参数", name ="参数名称", value ="参数具体描述"
     * 
     * @ApiImplicitParam(name="参数名",value="参数说明",dataType="数据类型 ",paramType="参数类型 ",required="是否必须参数")
     */
	@PostMapping("/checkVersion")
	@ApiOperation(value="查询版本号",notes="查询版本号", httpMethod = "POST")
	
	// @ApiImplicitParam用于方法 ，表示单独的请求参数 
	@ApiImplicitParam(name="token",value="令牌",dataType="String",paramType="query",required=true)
	public MsgReturn<AppVersionVo>  checkVersion(@RequestBody @ApiParam(name="app更新参数对象",value="传入json格式",required=true) AppVersionParams appVersionParams) throws Exception{
		MsgReturn<AppVersionVo> msg = new MsgReturn<AppVersionVo>();
		AppVersionVo vo = appVersionService.selectVersion(appVersionParams);
		if(vo==null) {
			msg.success("这是新的版本号！");
		}else {
//			msg.setReturnObj(vo);
			msg.failed("没有需要更新的了！");
		}
		return msg;
		
	}
}
