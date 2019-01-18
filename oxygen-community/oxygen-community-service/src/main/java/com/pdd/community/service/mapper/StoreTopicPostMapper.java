package com.pdd.community.service.mapper;

import com.pdd.community.common.po.StoreTopicPost;
import com.pdd.community.common.po.StoreTopicPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreTopicPostMapper {
    int countByExample(StoreTopicPostExample example);

    int deleteByExample(StoreTopicPostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreTopicPost record);

    int insertSelective(StoreTopicPost record);

    List<StoreTopicPost> selectByExample(StoreTopicPostExample example);

    StoreTopicPost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreTopicPost record, @Param("example") StoreTopicPostExample example);

    int updateByExample(@Param("record") StoreTopicPost record, @Param("example") StoreTopicPostExample example);

    int updateByPrimaryKeySelective(StoreTopicPost record);

    int updateByPrimaryKey(StoreTopicPost record);
}