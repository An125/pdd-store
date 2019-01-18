package com.pdd.userMgr.service.mapper;

import com.pdd.userMgr.service.po.StoreUserAddress;
import com.pdd.userMgr.service.po.StoreUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreUserAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    int countByExample(StoreUserAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    int deleteByExample(StoreUserAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    int insert(StoreUserAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    int insertSelective(StoreUserAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    List<StoreUserAddress> selectByExample(StoreUserAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    StoreUserAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") StoreUserAddress record, @Param("example") StoreUserAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") StoreUserAddress record, @Param("example") StoreUserAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(StoreUserAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_user_address
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(StoreUserAddress record);
}