package com.pdd.orderMgr.service.mapper;

import com.pdd.orderMgr.common.po.StoreShopGoodsRelation;
import com.pdd.orderMgr.common.po.StoreShopGoodsRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreShopGoodsRelationMapper {
    int countByExample(StoreShopGoodsRelationExample example);

    int deleteByExample(StoreShopGoodsRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreShopGoodsRelation record);

    int insertSelective(StoreShopGoodsRelation record);

    List<StoreShopGoodsRelation> selectByExample(StoreShopGoodsRelationExample example);

    StoreShopGoodsRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreShopGoodsRelation record, @Param("example") StoreShopGoodsRelationExample example);

    int updateByExample(@Param("record") StoreShopGoodsRelation record, @Param("example") StoreShopGoodsRelationExample example);

    int updateByPrimaryKeySelective(StoreShopGoodsRelation record);

    int updateByPrimaryKey(StoreShopGoodsRelation record);
}