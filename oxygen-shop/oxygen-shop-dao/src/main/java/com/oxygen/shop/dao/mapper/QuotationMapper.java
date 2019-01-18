package com.oxygen.shop.dao.mapper;

import com.oxygen.shop.common.po.Quotation;
import com.oxygen.shop.common.po.QuotationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuotationMapper {
    int countByExample(QuotationExample example);

    int deleteByExample(QuotationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Quotation record);

    int insertSelective(Quotation record);

    List<Quotation> selectByExample(QuotationExample example);

    Quotation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Quotation record, @Param("example") QuotationExample example);

    int updateByExample(@Param("record") Quotation record, @Param("example") QuotationExample example);

    int updateByPrimaryKeySelective(Quotation record);

    int updateByPrimaryKey(Quotation record);
}