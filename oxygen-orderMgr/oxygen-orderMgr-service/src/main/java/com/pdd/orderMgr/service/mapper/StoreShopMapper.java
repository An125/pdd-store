package com.pdd.orderMgr.service.mapper;

import com.pdd.orderMgr.common.po.StoreShop;
import com.pdd.orderMgr.common.po.StoreShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreShopMapper {
    int countByExample(StoreShopExample example);

    int deleteByExample(StoreShopExample example);

    int deleteByPrimaryKey(String id);

    int insert(StoreShop record);

    int insertSelective(StoreShop record);

    List<StoreShop> selectByExample(StoreShopExample example);

    StoreShop selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StoreShop record, @Param("example") StoreShopExample example);

    int updateByExample(@Param("record") StoreShop record, @Param("example") StoreShopExample example);

    int updateByPrimaryKeySelective(StoreShop record);

    int updateByPrimaryKey(StoreShop record);
}