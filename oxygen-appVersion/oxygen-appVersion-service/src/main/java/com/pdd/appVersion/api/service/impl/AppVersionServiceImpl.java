package com.pdd.appVersion.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdd.appVersion.api.service.AppVersionService;
import com.pdd.appVersion.common.params.AppVersionParams;
import com.pdd.appVersion.common.po.AppVersion;
import com.pdd.appVersion.common.po.AppVersionExample;
import com.pdd.appVersion.common.vo.AppVersionVo;
import com.pdd.appVersion.service.mapper.AppVersionMapper;
import com.pdd.common.core.exceptions.BizException;
/**
 * 
 * @作者： zhaoxin
 * @日期：2018年7月6日
 * @描述：查询版本号
 */
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService{

	@Autowired
	private AppVersionMapper appVersionMapper;
	@Override
	public AppVersionVo selectVersion(AppVersionParams appVersionParams) throws Exception {
		AppVersionExample example = new AppVersionExample();
		example.createCriteria().andNumberEqualTo(appVersionParams.getNumber());
		List<AppVersion> list = appVersionMapper.selectByExample(example);
		//查询不到时，说明是新版本号 ，并把新版本号存入数据库
		if(list == null || list.isEmpty()) {
			AppVersion appVersion = new AppVersion();
			appVersion.setNumber(appVersionParams.getNumber());
			appVersion.setRemarks(appVersionParams.getRemarks());
			appVersion.setCreateDate(new Date());
			int result = appVersionMapper.insertSelective(appVersion);
			if(result>0) {
				AppVersionVo vo = new AppVersionVo();
				BeanUtils.copyProperties(appVersion, vo);
				return null;
			}else {
				throw BizException.DB_INSERT_RESULT_0;
			}
		}else {
			AppVersionVo vo = new AppVersionVo();
			BeanUtils.copyProperties(list.get(0), vo);
			return vo;
		}
	}

}
