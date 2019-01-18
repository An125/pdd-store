package com.pdd.shopMgr.service.mapper;

import com.pdd.shopMgr.service.po.StoreCollection;
import com.pdd.shopMgr.service.po.StoreCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreCollectionMapper {
    int countByExample(StoreCollectionExample example);

    int deleteByExample(StoreCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreCollection record);

    int insertSelective(StoreCollection record);

    List<StoreCollection> selectByExample(StoreCollectionExample example);

    StoreCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreCollection record, @Param("example") StoreCollectionExample example);

    int updateByExample(@Param("record") StoreCollection record, @Param("example") StoreCollectionExample example);

    int updateByPrimaryKeySelective(StoreCollection record);

    int updateByPrimaryKey(StoreCollection record);
}