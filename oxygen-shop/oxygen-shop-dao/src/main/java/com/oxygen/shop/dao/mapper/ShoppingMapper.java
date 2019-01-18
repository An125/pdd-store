package com.oxygen.shop.dao.mapper;

import com.oxygen.shop.common.po.Shopping;
import com.oxygen.shop.common.po.ShoppingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoppingMapper {
    int countByExample(ShoppingExample example);

    int deleteByExample(ShoppingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shopping record);

    int insertSelective(Shopping record);

    List<Shopping> selectByExample(ShoppingExample example);

    Shopping selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shopping record, @Param("example") ShoppingExample example);

    int updateByExample(@Param("record") Shopping record, @Param("example") ShoppingExample example);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKey(Shopping record);
}