package com.pdd.shopMgr.service.mapper;

import com.pdd.shopMgr.service.po.StoreGoodsPrice;
import com.pdd.shopMgr.service.po.StoreGoodsPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreGoodsPriceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    int countByExample(StoreGoodsPriceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    int deleteByExample(StoreGoodsPriceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    int insert(StoreGoodsPrice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    int insertSelective(StoreGoodsPrice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    List<StoreGoodsPrice> selectByExample(StoreGoodsPriceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    StoreGoodsPrice selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    int updateByExampleSelective(@Param("record") StoreGoodsPrice record, @Param("example") StoreGoodsPriceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    int updateByExample(@Param("record") StoreGoodsPrice record, @Param("example") StoreGoodsPriceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    int updateByPrimaryKeySelective(StoreGoodsPrice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store_goods_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    int updateByPrimaryKey(StoreGoodsPrice record);
}