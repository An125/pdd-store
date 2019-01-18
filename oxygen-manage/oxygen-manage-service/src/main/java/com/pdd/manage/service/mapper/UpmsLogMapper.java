package com.pdd.manage.service.mapper;

import com.pdd.manage.common.po.UpmsLog;
import com.pdd.manage.common.po.UpmsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsLogMapper {
    int countByExample(UpmsLogExample example);

    int deleteByExample(UpmsLogExample example);

    int deleteByPrimaryKey(String logId);

    int insert(UpmsLog record);

    int insertSelective(UpmsLog record);

    List<UpmsLog> selectByExample(UpmsLogExample example);

    UpmsLog selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") UpmsLog record, @Param("example") UpmsLogExample example);

    int updateByExample(@Param("record") UpmsLog record, @Param("example") UpmsLogExample example);

    int updateByPrimaryKeySelective(UpmsLog record);

    int updateByPrimaryKey(UpmsLog record);
}