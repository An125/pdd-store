package com.pdd.userMgr.service.mapper;

import com.pdd.userMgr.service.po.StoreShopUser;
import com.pdd.userMgr.service.po.StoreShopUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreShopUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    int countByExample(StoreShopUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    int deleteByExample(StoreShopUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    int insert(StoreShopUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    int insertSelective(StoreShopUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    List<StoreShopUser> selectByExample(StoreShopUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    StoreShopUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") StoreShopUser record, @Param("example") StoreShopUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") StoreShopUser record, @Param("example") StoreShopUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(StoreShopUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_shop_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(StoreShopUser record);
}