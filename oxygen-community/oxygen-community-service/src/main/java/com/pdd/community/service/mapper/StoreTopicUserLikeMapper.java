package com.pdd.community.service.mapper;

import com.pdd.community.common.po.StoreTopicUserLike;
import com.pdd.community.common.po.StoreTopicUserLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreTopicUserLikeMapper {
    int countByExample(StoreTopicUserLikeExample example);

    int deleteByExample(StoreTopicUserLikeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreTopicUserLike record);

    int insertSelective(StoreTopicUserLike record);

    List<StoreTopicUserLike> selectByExample(StoreTopicUserLikeExample example);

    StoreTopicUserLike selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreTopicUserLike record, @Param("example") StoreTopicUserLikeExample example);

    int updateByExample(@Param("record") StoreTopicUserLike record, @Param("example") StoreTopicUserLikeExample example);

    int updateByPrimaryKeySelective(StoreTopicUserLike record);

    int updateByPrimaryKey(StoreTopicUserLike record);
}