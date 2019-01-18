package com.pdd.manage.api.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdd.manage.api.service.UpmsSystemService;
import com.pdd.manage.common.params.SystemParams;
import com.pdd.manage.common.po.UpmsSystem;
import com.pdd.manage.common.vo.SystemVo;
import com.pdd.manage.service.mapper.UpmsSystemMapper;
/**
 * 
 * @作者： zhaoxin
 * @日期：2018年3月21日
 * @描述：系统管理
 */
@Service("upmsSystemService")
public class UpmsSystemServiceImpl implements UpmsSystemService {

	@Autowired
	private UpmsSystemMapper upmsSystemMapper;
	/**
	 * 新增系统
	 */
	@Override
	public SystemVo addSystem(SystemParams systemParams) throws Exception {
		UpmsSystem upmsSystem = new UpmsSystem();
		upmsSystem.setTitle(systemParams.getTitle());
		upmsSystem.setName(systemParams.getName());
		upmsSystem.setBasepath(systemParams.getBasepath());
		upmsSystem.setIcon(systemParams.getIcon());
		upmsSystem.setBanner(null);
		upmsSystem.setTheme(systemParams.getTheme());
		upmsSystem.setStatus(systemParams.getStatus());
		upmsSystem.setDescription(systemParams.getDescription());
		upmsSystem.setOrders(null);
		upmsSystem.setCreateBy(systemParams.getCreateBy());
		upmsSystem.setUpdateBy(systemParams.getUpdateBy());
		upmsSystem.setRemarks(systemParams.getRemarks());
		Date date = new Date();
		upmsSystem.setCreateDate(date);
		upmsSystem.setUpdateDate(date);
		int count = upmsSystemMapper.insertSelective(upmsSystem);
		if(count>0) {
			SystemVo systemVo = new SystemVo();
			BeanUtils.copyProperties(upmsSystem, systemVo);
			return systemVo;
		}else {
			
			return null;
		}
	}



}
