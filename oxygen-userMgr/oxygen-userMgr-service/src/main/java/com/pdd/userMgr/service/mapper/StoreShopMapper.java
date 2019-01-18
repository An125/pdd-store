package com.pdd.userMgr.service.mapper;

import com.pdd.userMgr.service.po.StoreShop;
import com.pdd.userMgr.service.po.StoreShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreShopMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    int countByExample(StoreShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    int deleteByExample(StoreShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    int insert(StoreShop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    int insertSelective(StoreShop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    List<StoreShop> selectByExample(StoreShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    StoreShop selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") StoreShop record, @Param("example") StoreShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") StoreShop record, @Param("example") StoreShopExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(StoreShop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(StoreShop record);
}