package com.pdd.manage.service.mapper;

import com.pdd.manage.common.po.UpmsUser;
import com.pdd.manage.common.po.UpmsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsUserMapper {
    int countByExample(UpmsUserExample example);

    int deleteByExample(UpmsUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UpmsUser record);

    int insertSelective(UpmsUser record);

    List<UpmsUser> selectByExample(UpmsUserExample example);

    UpmsUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UpmsUser record, @Param("example") UpmsUserExample example);

    int updateByExample(@Param("record") UpmsUser record, @Param("example") UpmsUserExample example);

    int updateByPrimaryKeySelective(UpmsUser record);

    int updateByPrimaryKey(UpmsUser record);
}