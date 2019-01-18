package com.pdd.manage.service.mapper;

import com.pdd.manage.common.po.UpmsRole;
import com.pdd.manage.common.po.UpmsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsRoleMapper {
    int countByExample(UpmsRoleExample example);

    int deleteByExample(UpmsRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(UpmsRole record);

    int insertSelective(UpmsRole record);

    List<UpmsRole> selectByExample(UpmsRoleExample example);

    UpmsRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") UpmsRole record, @Param("example") UpmsRoleExample example);

    int updateByExample(@Param("record") UpmsRole record, @Param("example") UpmsRoleExample example);

    int updateByPrimaryKeySelective(UpmsRole record);

    int updateByPrimaryKey(UpmsRole record);
}