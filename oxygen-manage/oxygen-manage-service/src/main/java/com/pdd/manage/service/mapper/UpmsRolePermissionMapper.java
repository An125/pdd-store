package com.pdd.manage.service.mapper;

import com.pdd.manage.common.po.UpmsRolePermission;
import com.pdd.manage.common.po.UpmsRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsRolePermissionMapper {
    int countByExample(UpmsRolePermissionExample example);

    int deleteByExample(UpmsRolePermissionExample example);

    int deleteByPrimaryKey(String rolePermissionId);

    int insert(UpmsRolePermission record);

    int insertSelective(UpmsRolePermission record);

    List<UpmsRolePermission> selectByExample(UpmsRolePermissionExample example);

    UpmsRolePermission selectByPrimaryKey(String rolePermissionId);

    int updateByExampleSelective(@Param("record") UpmsRolePermission record, @Param("example") UpmsRolePermissionExample example);

    int updateByExample(@Param("record") UpmsRolePermission record, @Param("example") UpmsRolePermissionExample example);

    int updateByPrimaryKeySelective(UpmsRolePermission record);

    int updateByPrimaryKey(UpmsRolePermission record);
}