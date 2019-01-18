package com.pdd.orderMgr.service.mapper;

import com.pdd.orderMgr.common.po.StoreUserAddress;
import com.pdd.orderMgr.common.po.StoreUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreUserAddressMapper {
    int countByExample(StoreUserAddressExample example);

    int deleteByExample(StoreUserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreUserAddress record);

    int insertSelective(StoreUserAddress record);

    List<StoreUserAddress> selectByExample(StoreUserAddressExample example);

    StoreUserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreUserAddress record, @Param("example") StoreUserAddressExample example);

    int updateByExample(@Param("record") StoreUserAddress record, @Param("example") StoreUserAddressExample example);

    int updateByPrimaryKeySelective(StoreUserAddress record);

    int updateByPrimaryKey(StoreUserAddress record);
}