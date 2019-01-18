package com.oxygen.shop.common.po;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIsNull() {
            addCriterion("Privilege is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIsNotNull() {
            addCriterion("Privilege is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeEqualTo(String value) {
            addCriterion("Privilege =", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNotEqualTo(String value) {
            addCriterion("Privilege <>", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeGreaterThan(String value) {
            addCriterion("Privilege >", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeGreaterThanOrEqualTo(String value) {
            addCriterion("Privilege >=", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLessThan(String value) {
            addCriterion("Privilege <", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLessThanOrEqualTo(String value) {
            addCriterion("Privilege <=", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLike(String value) {
            addCriterion("Privilege like", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNotLike(String value) {
            addCriterion("Privilege not like", value, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeIn(List<String> values) {
            addCriterion("Privilege in", values, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNotIn(List<String> values) {
            addCriterion("Privilege not in", values, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeBetween(String value1, String value2) {
            addCriterion("Privilege between", value1, value2, "privilege");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNotBetween(String value1, String value2) {
            addCriterion("Privilege not between", value1, value2, "privilege");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andSuperiorIsNull() {
            addCriterion("superior is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorIsNotNull() {
            addCriterion("superior is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorEqualTo(String value) {
            addCriterion("superior =", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotEqualTo(String value) {
            addCriterion("superior <>", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorGreaterThan(String value) {
            addCriterion("superior >", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorGreaterThanOrEqualTo(String value) {
            addCriterion("superior >=", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorLessThan(String value) {
            addCriterion("superior <", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorLessThanOrEqualTo(String value) {
            addCriterion("superior <=", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorLike(String value) {
            addCriterion("superior like", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotLike(String value) {
            addCriterion("superior not like", value, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorIn(List<String> values) {
            addCriterion("superior in", values, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotIn(List<String> values) {
            addCriterion("superior not in", values, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorBetween(String value1, String value2) {
            addCriterion("superior between", value1, value2, "superior");
            return (Criteria) this;
        }

        public Criteria andSuperiorNotBetween(String value1, String value2) {
            addCriterion("superior not between", value1, value2, "superior");
            return (Criteria) this;
        }

        public Criteria andDepthIsNull() {
            addCriterion("Depth is null");
            return (Criteria) this;
        }

        public Criteria andDepthIsNotNull() {
            addCriterion("Depth is not null");
            return (Criteria) this;
        }

        public Criteria andDepthEqualTo(String value) {
            addCriterion("Depth =", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotEqualTo(String value) {
            addCriterion("Depth <>", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthGreaterThan(String value) {
            addCriterion("Depth >", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthGreaterThanOrEqualTo(String value) {
            addCriterion("Depth >=", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLessThan(String value) {
            addCriterion("Depth <", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLessThanOrEqualTo(String value) {
            addCriterion("Depth <=", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLike(String value) {
            addCriterion("Depth like", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotLike(String value) {
            addCriterion("Depth not like", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthIn(List<String> values) {
            addCriterion("Depth in", values, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotIn(List<String> values) {
            addCriterion("Depth not in", values, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthBetween(String value1, String value2) {
            addCriterion("Depth between", value1, value2, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotBetween(String value1, String value2) {
            addCriterion("Depth not between", value1, value2, "depth");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("Path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("Path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("Path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("Path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("Path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("Path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("Path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("Path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("Path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("Path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("Path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("Path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("Path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("Path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNull() {
            addCriterion("revenue is null");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNotNull() {
            addCriterion("revenue is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueEqualTo(String value) {
            addCriterion("revenue =", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotEqualTo(String value) {
            addCriterion("revenue <>", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThan(String value) {
            addCriterion("revenue >", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThanOrEqualTo(String value) {
            addCriterion("revenue >=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThan(String value) {
            addCriterion("revenue <", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThanOrEqualTo(String value) {
            addCriterion("revenue <=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLike(String value) {
            addCriterion("revenue like", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotLike(String value) {
            addCriterion("revenue not like", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueIn(List<String> values) {
            addCriterion("revenue in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotIn(List<String> values) {
            addCriterion("revenue not in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueBetween(String value1, String value2) {
            addCriterion("revenue between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotBetween(String value1, String value2) {
            addCriterion("revenue not between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andConsumeIsNull() {
            addCriterion("consume is null");
            return (Criteria) this;
        }

        public Criteria andConsumeIsNotNull() {
            addCriterion("consume is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeEqualTo(String value) {
            addCriterion("consume =", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotEqualTo(String value) {
            addCriterion("consume <>", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeGreaterThan(String value) {
            addCriterion("consume >", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeGreaterThanOrEqualTo(String value) {
            addCriterion("consume >=", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLessThan(String value) {
            addCriterion("consume <", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLessThanOrEqualTo(String value) {
            addCriterion("consume <=", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLike(String value) {
            addCriterion("consume like", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotLike(String value) {
            addCriterion("consume not like", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeIn(List<String> values) {
            addCriterion("consume in", values, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotIn(List<String> values) {
            addCriterion("consume not in", values, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeBetween(String value1, String value2) {
            addCriterion("consume between", value1, value2, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotBetween(String value1, String value2) {
            addCriterion("consume not between", value1, value2, "consume");
            return (Criteria) this;
        }

        public Criteria andGeneratedIsNull() {
            addCriterion("Generated is null");
            return (Criteria) this;
        }

        public Criteria andGeneratedIsNotNull() {
            addCriterion("Generated is not null");
            return (Criteria) this;
        }

        public Criteria andGeneratedEqualTo(String value) {
            addCriterion("Generated =", value, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedNotEqualTo(String value) {
            addCriterion("Generated <>", value, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedGreaterThan(String value) {
            addCriterion("Generated >", value, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedGreaterThanOrEqualTo(String value) {
            addCriterion("Generated >=", value, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedLessThan(String value) {
            addCriterion("Generated <", value, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedLessThanOrEqualTo(String value) {
            addCriterion("Generated <=", value, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedLike(String value) {
            addCriterion("Generated like", value, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedNotLike(String value) {
            addCriterion("Generated not like", value, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedIn(List<String> values) {
            addCriterion("Generated in", values, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedNotIn(List<String> values) {
            addCriterion("Generated not in", values, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedBetween(String value1, String value2) {
            addCriterion("Generated between", value1, value2, "generated");
            return (Criteria) this;
        }

        public Criteria andGeneratedNotBetween(String value1, String value2) {
            addCriterion("Generated not between", value1, value2, "generated");
            return (Criteria) this;
        }

        public Criteria andInvitationIsNull() {
            addCriterion("invitation is null");
            return (Criteria) this;
        }

        public Criteria andInvitationIsNotNull() {
            addCriterion("invitation is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationEqualTo(String value) {
            addCriterion("invitation =", value, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationNotEqualTo(String value) {
            addCriterion("invitation <>", value, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationGreaterThan(String value) {
            addCriterion("invitation >", value, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationGreaterThanOrEqualTo(String value) {
            addCriterion("invitation >=", value, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationLessThan(String value) {
            addCriterion("invitation <", value, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationLessThanOrEqualTo(String value) {
            addCriterion("invitation <=", value, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationLike(String value) {
            addCriterion("invitation like", value, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationNotLike(String value) {
            addCriterion("invitation not like", value, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationIn(List<String> values) {
            addCriterion("invitation in", values, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationNotIn(List<String> values) {
            addCriterion("invitation not in", values, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationBetween(String value1, String value2) {
            addCriterion("invitation between", value1, value2, "invitation");
            return (Criteria) this;
        }

        public Criteria andInvitationNotBetween(String value1, String value2) {
            addCriterion("invitation not between", value1, value2, "invitation");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNull() {
            addCriterion("credits is null");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNotNull() {
            addCriterion("credits is not null");
            return (Criteria) this;
        }

        public Criteria andCreditsEqualTo(String value) {
            addCriterion("credits =", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotEqualTo(String value) {
            addCriterion("credits <>", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThan(String value) {
            addCriterion("credits >", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThanOrEqualTo(String value) {
            addCriterion("credits >=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThan(String value) {
            addCriterion("credits <", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThanOrEqualTo(String value) {
            addCriterion("credits <=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLike(String value) {
            addCriterion("credits like", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotLike(String value) {
            addCriterion("credits not like", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsIn(List<String> values) {
            addCriterion("credits in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotIn(List<String> values) {
            addCriterion("credits not in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsBetween(String value1, String value2) {
            addCriterion("credits between", value1, value2, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotBetween(String value1, String value2) {
            addCriterion("credits not between", value1, value2, "credits");
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

        public Criteria andTxpathIsNull() {
            addCriterion("txpath is null");
            return (Criteria) this;
        }

        public Criteria andTxpathIsNotNull() {
            addCriterion("txpath is not null");
            return (Criteria) this;
        }

        public Criteria andTxpathEqualTo(String value) {
            addCriterion("txpath =", value, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathNotEqualTo(String value) {
            addCriterion("txpath <>", value, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathGreaterThan(String value) {
            addCriterion("txpath >", value, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathGreaterThanOrEqualTo(String value) {
            addCriterion("txpath >=", value, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathLessThan(String value) {
            addCriterion("txpath <", value, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathLessThanOrEqualTo(String value) {
            addCriterion("txpath <=", value, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathLike(String value) {
            addCriterion("txpath like", value, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathNotLike(String value) {
            addCriterion("txpath not like", value, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathIn(List<String> values) {
            addCriterion("txpath in", values, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathNotIn(List<String> values) {
            addCriterion("txpath not in", values, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathBetween(String value1, String value2) {
            addCriterion("txpath between", value1, value2, "txpath");
            return (Criteria) this;
        }

        public Criteria andTxpathNotBetween(String value1, String value2) {
            addCriterion("txpath not between", value1, value2, "txpath");
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