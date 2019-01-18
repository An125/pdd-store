package com.pdd.orderMgr.service.mapper;

import com.pdd.orderMgr.common.po.StoreOrderForm;
import com.pdd.orderMgr.common.po.StoreOrderFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreOrderFormMapper {
    int countByExample(StoreOrderFormExample example);

    int deleteByExample(StoreOrderFormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreOrderForm record);

    int insertSelective(StoreOrderForm record);

    List<StoreOrderForm> selectByExample(StoreOrderFormExample example);

    StoreOrderForm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreOrderForm record, @Param("example") StoreOrderFormExample example);

    int updateByExample(@Param("record") StoreOrderForm record, @Param("example") StoreOrderFormExample example);

    int updateByPrimaryKeySelective(StoreOrderForm record);

    int updateByPrimaryKey(StoreOrderForm record);
}