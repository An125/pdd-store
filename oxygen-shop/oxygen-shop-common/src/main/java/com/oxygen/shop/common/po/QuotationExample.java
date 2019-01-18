package com.oxygen.shop.common.po;

import java.util.ArrayList;
import java.util.List;

public class QuotationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuotationExample() {
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

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andOfferIsNull() {
            addCriterion("offer is null");
            return (Criteria) this;
        }

        public Criteria andOfferIsNotNull() {
            addCriterion("offer is not null");
            return (Criteria) this;
        }

        public Criteria andOfferEqualTo(String value) {
            addCriterion("offer =", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferNotEqualTo(String value) {
            addCriterion("offer <>", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferGreaterThan(String value) {
            addCriterion("offer >", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferGreaterThanOrEqualTo(String value) {
            addCriterion("offer >=", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferLessThan(String value) {
            addCriterion("offer <", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferLessThanOrEqualTo(String value) {
            addCriterion("offer <=", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferLike(String value) {
            addCriterion("offer like", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferNotLike(String value) {
            addCriterion("offer not like", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferIn(List<String> values) {
            addCriterion("offer in", values, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferNotIn(List<String> values) {
            addCriterion("offer not in", values, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferBetween(String value1, String value2) {
            addCriterion("offer between", value1, value2, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferNotBetween(String value1, String value2) {
            addCriterion("offer not between", value1, value2, "offer");
            return (Criteria) this;
        }

        public Criteria andTopPriceIsNull() {
            addCriterion("top_Price is null");
            return (Criteria) this;
        }

        public Criteria andTopPriceIsNotNull() {
            addCriterion("top_Price is not null");
            return (Criteria) this;
        }

        public Criteria andTopPriceEqualTo(String value) {
            addCriterion("top_Price =", value, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceNotEqualTo(String value) {
            addCriterion("top_Price <>", value, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceGreaterThan(String value) {
            addCriterion("top_Price >", value, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceGreaterThanOrEqualTo(String value) {
            addCriterion("top_Price >=", value, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceLessThan(String value) {
            addCriterion("top_Price <", value, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceLessThanOrEqualTo(String value) {
            addCriterion("top_Price <=", value, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceLike(String value) {
            addCriterion("top_Price like", value, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceNotLike(String value) {
            addCriterion("top_Price not like", value, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceIn(List<String> values) {
            addCriterion("top_Price in", values, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceNotIn(List<String> values) {
            addCriterion("top_Price not in", values, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceBetween(String value1, String value2) {
            addCriterion("top_Price between", value1, value2, "topPrice");
            return (Criteria) this;
        }

        public Criteria andTopPriceNotBetween(String value1, String value2) {
            addCriterion("top_Price not between", value1, value2, "topPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceIsNull() {
            addCriterion("floor_Price is null");
            return (Criteria) this;
        }

        public Criteria andFloorPriceIsNotNull() {
            addCriterion("floor_Price is not null");
            return (Criteria) this;
        }

        public Criteria andFloorPriceEqualTo(String value) {
            addCriterion("floor_Price =", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceNotEqualTo(String value) {
            addCriterion("floor_Price <>", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceGreaterThan(String value) {
            addCriterion("floor_Price >", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceGreaterThanOrEqualTo(String value) {
            addCriterion("floor_Price >=", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceLessThan(String value) {
            addCriterion("floor_Price <", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceLessThanOrEqualTo(String value) {
            addCriterion("floor_Price <=", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceLike(String value) {
            addCriterion("floor_Price like", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceNotLike(String value) {
            addCriterion("floor_Price not like", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceIn(List<String> values) {
            addCriterion("floor_Price in", values, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceNotIn(List<String> values) {
            addCriterion("floor_Price not in", values, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceBetween(String value1, String value2) {
            addCriterion("floor_Price between", value1, value2, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceNotBetween(String value1, String value2) {
            addCriterion("floor_Price not between", value1, value2, "floorPrice");
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

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(String value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(String value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(String value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(String value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(String value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(String value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLike(String value) {
            addCriterion("stock like", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotLike(String value) {
            addCriterion("stock not like", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<String> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<String> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(String value1, String value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(String value1, String value2) {
            addCriterion("stock not between", value1, value2, "stock");
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