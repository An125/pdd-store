package com.pdd.manage.service.mapper;

import com.pdd.manage.common.po.UpmsUserPermission;
import com.pdd.manage.common.po.UpmsUserPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsUserPermissionMapper {
    int countByExample(UpmsUserPermissionExample example);

    int deleteByExample(UpmsUserPermissionExample example);

    int deleteByPrimaryKey(String userPermissionId);

    int insert(UpmsUserPermission record);

    int insertSelective(UpmsUserPermission record);

    List<UpmsUserPermission> selectByExample(UpmsUserPermissionExample example);

    UpmsUserPermission selectByPrimaryKey(String userPermissionId);

    int updateByExampleSelective(@Param("record") UpmsUserPermission record, @Param("example") UpmsUserPermissionExample example);

    int updateByExample(@Param("record") UpmsUserPermission record, @Param("example") UpmsUserPermissionExample example);

    int updateByPrimaryKeySelective(UpmsUserPermission record);

    int updateByPrimaryKey(UpmsUserPermission record);
}