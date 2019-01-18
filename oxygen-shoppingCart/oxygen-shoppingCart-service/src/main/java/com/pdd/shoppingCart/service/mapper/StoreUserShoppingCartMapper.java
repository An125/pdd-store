package com.pdd.shoppingCart.service.mapper;

import com.pdd.shoppingCart.common.po.StoreUserShoppingCart;
import com.pdd.shoppingCart.common.po.StoreUserShoppingCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreUserShoppingCartMapper {
    int countByExample(StoreUserShoppingCartExample example);

    int deleteByExample(StoreUserShoppingCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreUserShoppingCart record);

    int insertSelective(StoreUserShoppingCart record);

    List<StoreUserShoppingCart> selectByExample(StoreUserShoppingCartExample example);

    StoreUserShoppingCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreUserShoppingCart record, @Param("example") StoreUserShoppingCartExample example);

    int updateByExample(@Param("record") StoreUserShoppingCart record, @Param("example") StoreUserShoppingCartExample example);

    int updateByPrimaryKeySelective(StoreUserShoppingCart record);

    int updateByPrimaryKey(StoreUserShoppingCart record);
}