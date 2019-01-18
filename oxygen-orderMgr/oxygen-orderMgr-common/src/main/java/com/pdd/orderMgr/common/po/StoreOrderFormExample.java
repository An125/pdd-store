package com.pdd.orderMgr.common.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreOrderFormExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreOrderFormExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNull() {
            addCriterion("good_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNotNull() {
            addCriterion("good_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodIdEqualTo(String value) {
            addCriterion("good_id =", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotEqualTo(String value) {
            addCriterion("good_id <>", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThan(String value) {
            addCriterion("good_id >", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThanOrEqualTo(String value) {
            addCriterion("good_id >=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThan(String value) {
            addCriterion("good_id <", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThanOrEqualTo(String value) {
            addCriterion("good_id <=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLike(String value) {
            addCriterion("good_id like", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotLike(String value) {
            addCriterion("good_id not like", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIn(List<String> values) {
            addCriterion("good_id in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotIn(List<String> values) {
            addCriterion("good_id not in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdBetween(String value1, String value2) {
            addCriterion("good_id between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotBetween(String value1, String value2) {
            addCriterion("good_id not between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(String value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(String value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(String value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(String value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(String value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLike(String value) {
            addCriterion("shop_id like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotLike(String value) {
            addCriterion("shop_id not like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<String> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<String> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(String value1, String value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(String value1, String value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdIsNull() {
            addCriterion("user_address_id is null");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdIsNotNull() {
            addCriterion("user_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdEqualTo(Integer value) {
            addCriterion("user_address_id =", value, "userAddressId");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdNotEqualTo(Integer value) {
            addCriterion("user_address_id <>", value, "userAddressId");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdGreaterThan(Integer value) {
            addCriterion("user_address_id >", value, "userAddressId");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_address_id >=", value, "userAddressId");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdLessThan(Integer value) {
            addCriterion("user_address_id <", value, "userAddressId");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_address_id <=", value, "userAddressId");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdIn(List<Integer> values) {
            addCriterion("user_address_id in", values, "userAddressId");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdNotIn(List<Integer> values) {
            addCriterion("user_address_id not in", values, "userAddressId");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("user_address_id between", value1, value2, "userAddressId");
            return (Criteria) this;
        }

        public Criteria andUserAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_address_id not between", value1, value2, "userAddressId");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdIsNull() {
            addCriterion("shop_goods_relation_id is null");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdIsNotNull() {
            addCriterion("shop_goods_relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdEqualTo(Integer value) {
            addCriterion("shop_goods_relation_id =", value, "shopGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdNotEqualTo(Integer value) {
            addCriterion("shop_goods_relation_id <>", value, "shopGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdGreaterThan(Integer value) {
            addCriterion("shop_goods_relation_id >", value, "shopGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_goods_relation_id >=", value, "shopGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdLessThan(Integer value) {
            addCriterion("shop_goods_relation_id <", value, "shopGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_goods_relation_id <=", value, "shopGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdIn(List<Integer> values) {
            addCriterion("shop_goods_relation_id in", values, "shopGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdNotIn(List<Integer> values) {
            addCriterion("shop_goods_relation_id not in", values, "shopGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_goods_relation_id between", value1, value2, "shopGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andShopGoodsRelationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_goods_relation_id not between", value1, value2, "shopGoodsRelationId");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxIsNull() {
            addCriterion("order_form_wx is null");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxIsNotNull() {
            addCriterion("order_form_wx is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxEqualTo(String value) {
            addCriterion("order_form_wx =", value, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxNotEqualTo(String value) {
            addCriterion("order_form_wx <>", value, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxGreaterThan(String value) {
            addCriterion("order_form_wx >", value, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxGreaterThanOrEqualTo(String value) {
            addCriterion("order_form_wx >=", value, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxLessThan(String value) {
            addCriterion("order_form_wx <", value, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxLessThanOrEqualTo(String value) {
            addCriterion("order_form_wx <=", value, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxLike(String value) {
            addCriterion("order_form_wx like", value, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxNotLike(String value) {
            addCriterion("order_form_wx not like", value, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxIn(List<String> values) {
            addCriterion("order_form_wx in", values, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxNotIn(List<String> values) {
            addCriterion("order_form_wx not in", values, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxBetween(String value1, String value2) {
            addCriterion("order_form_wx between", value1, value2, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormWxNotBetween(String value1, String value2) {
            addCriterion("order_form_wx not between", value1, value2, "orderFormWx");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlIsNull() {
            addCriterion("order_form_al is null");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlIsNotNull() {
            addCriterion("order_form_al is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlEqualTo(String value) {
            addCriterion("order_form_al =", value, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlNotEqualTo(String value) {
            addCriterion("order_form_al <>", value, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlGreaterThan(String value) {
            addCriterion("order_form_al >", value, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlGreaterThanOrEqualTo(String value) {
            addCriterion("order_form_al >=", value, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlLessThan(String value) {
            addCriterion("order_form_al <", value, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlLessThanOrEqualTo(String value) {
            addCriterion("order_form_al <=", value, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlLike(String value) {
            addCriterion("order_form_al like", value, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlNotLike(String value) {
            addCriterion("order_form_al not like", value, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlIn(List<String> values) {
            addCriterion("order_form_al in", values, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlNotIn(List<String> values) {
            addCriterion("order_form_al not in", values, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlBetween(String value1, String value2) {
            addCriterion("order_form_al between", value1, value2, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andOrderFormAlNotBetween(String value1, String value2) {
            addCriterion("order_form_al not between", value1, value2, "orderFormAl");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNull() {
            addCriterion("pay_method is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("pay_method is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(Integer value) {
            addCriterion("pay_method =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(Integer value) {
            addCriterion("pay_method <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(Integer value) {
            addCriterion("pay_method >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_method >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(Integer value) {
            addCriterion("pay_method <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(Integer value) {
            addCriterion("pay_method <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<Integer> values) {
            addCriterion("pay_method in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<Integer> values) {
            addCriterion("pay_method not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(Integer value1, Integer value2) {
            addCriterion("pay_method between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_method not between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(BigDecimal value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(BigDecimal value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(BigDecimal value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<BigDecimal> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}