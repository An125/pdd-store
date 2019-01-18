package com.pdd.orderMgr.service.mapper;

import com.pdd.orderMgr.common.po.StoreGoods;
import com.pdd.orderMgr.common.po.StoreGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreGoodsMapper {
    int countByExample(StoreGoodsExample example);

    int deleteByExample(StoreGoodsExample example);

    int deleteByPrimaryKey(String id);

    int insert(StoreGoods record);

    int insertSelective(StoreGoods record);

    List<StoreGoods> selectByExampleWithBLOBs(StoreGoodsExample example);

    List<StoreGoods> selectByExample(StoreGoodsExample example);

    StoreGoods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StoreGoods record, @Param("example") StoreGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") StoreGoods record, @Param("example") StoreGoodsExample example);

    int updateByExample(@Param("record") StoreGoods record, @Param("example") StoreGoodsExample example);

    int updateByPrimaryKeySelective(StoreGoods record);

    int updateByPrimaryKeyWithBLOBs(StoreGoods record);

    int updateByPrimaryKey(StoreGoods record);
}