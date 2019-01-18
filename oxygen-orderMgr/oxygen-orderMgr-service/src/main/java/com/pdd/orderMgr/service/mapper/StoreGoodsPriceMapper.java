package com.pdd.orderMgr.service.mapper;

import com.pdd.orderMgr.common.po.StoreGoodsPrice;
import com.pdd.orderMgr.common.po.StoreGoodsPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreGoodsPriceMapper {
    int countByExample(StoreGoodsPriceExample example);

    int deleteByExample(StoreGoodsPriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreGoodsPrice record);

    int insertSelective(StoreGoodsPrice record);

    List<StoreGoodsPrice> selectByExample(StoreGoodsPriceExample example);

    StoreGoodsPrice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreGoodsPrice record, @Param("example") StoreGoodsPriceExample example);

    int updateByExample(@Param("record") StoreGoodsPrice record, @Param("example") StoreGoodsPriceExample example);

    int updateByPrimaryKeySelective(StoreGoodsPrice record);

    int updateByPrimaryKey(StoreGoodsPrice record);
}