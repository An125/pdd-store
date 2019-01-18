package com.pdd.manage.service.mapper;

import com.pdd.manage.common.po.UpmsSystem;
import com.pdd.manage.common.po.UpmsSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsSystemMapper {
    int countByExample(UpmsSystemExample example);

    int deleteByExample(UpmsSystemExample example);

    int deleteByPrimaryKey(String systemId);

    int insert(UpmsSystem record);

    int insertSelective(UpmsSystem record);

    List<UpmsSystem> selectByExample(UpmsSystemExample example);

    UpmsSystem selectByPrimaryKey(String systemId);

    int updateByExampleSelective(@Param("record") UpmsSystem record, @Param("example") UpmsSystemExample example);

    int updateByExample(@Param("record") UpmsSystem record, @Param("example") UpmsSystemExample example);

    int updateByPrimaryKeySelective(UpmsSystem record);

    int updateByPrimaryKey(UpmsSystem record);
}