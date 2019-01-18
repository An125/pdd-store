package com.pdd.community.common.po;

import java.util.ArrayList;
import java.util.List;

public class StoreTopicUserLikeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreTopicUserLikeExample() {
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

        public Criteria andTopicPostIdIsNull() {
            addCriterion("topic_post_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdIsNotNull() {
            addCriterion("topic_post_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdEqualTo(Integer value) {
            addCriterion("topic_post_id =", value, "topicPostId");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdNotEqualTo(Integer value) {
            addCriterion("topic_post_id <>", value, "topicPostId");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdGreaterThan(Integer value) {
            addCriterion("topic_post_id >", value, "topicPostId");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_post_id >=", value, "topicPostId");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdLessThan(Integer value) {
            addCriterion("topic_post_id <", value, "topicPostId");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_post_id <=", value, "topicPostId");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdIn(List<Integer> values) {
            addCriterion("topic_post_id in", values, "topicPostId");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdNotIn(List<Integer> values) {
            addCriterion("topic_post_id not in", values, "topicPostId");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_post_id between", value1, value2, "topicPostId");
            return (Criteria) this;
        }

        public Criteria andTopicPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_post_id not between", value1, value2, "topicPostId");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBackupfield1IsNull() {
            addCriterion("backupField1 is null");
            return (Criteria) this;
        }

        public Criteria andBackupfield1IsNotNull() {
            addCriterion("backupField1 is not null");
            return (Criteria) this;
        }

        public Criteria andBackupfield1EqualTo(String value) {
            addCriterion("backupField1 =", value, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1NotEqualTo(String value) {
            addCriterion("backupField1 <>", value, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1GreaterThan(String value) {
            addCriterion("backupField1 >", value, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1GreaterThanOrEqualTo(String value) {
            addCriterion("backupField1 >=", value, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1LessThan(String value) {
            addCriterion("backupField1 <", value, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1LessThanOrEqualTo(String value) {
            addCriterion("backupField1 <=", value, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1Like(String value) {
            addCriterion("backupField1 like", value, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1NotLike(String value) {
            addCriterion("backupField1 not like", value, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1In(List<String> values) {
            addCriterion("backupField1 in", values, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1NotIn(List<String> values) {
            addCriterion("backupField1 not in", values, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1Between(String value1, String value2) {
            addCriterion("backupField1 between", value1, value2, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield1NotBetween(String value1, String value2) {
            addCriterion("backupField1 not between", value1, value2, "backupfield1");
            return (Criteria) this;
        }

        public Criteria andBackupfield2IsNull() {
            addCriterion("backupField2 is null");
            return (Criteria) this;
        }

        public Criteria andBackupfield2IsNotNull() {
            addCriterion("backupField2 is not null");
            return (Criteria) this;
        }

        public Criteria andBackupfield2EqualTo(String value) {
            addCriterion("backupField2 =", value, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2NotEqualTo(String value) {
            addCriterion("backupField2 <>", value, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2GreaterThan(String value) {
            addCriterion("backupField2 >", value, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2GreaterThanOrEqualTo(String value) {
            addCriterion("backupField2 >=", value, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2LessThan(String value) {
            addCriterion("backupField2 <", value, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2LessThanOrEqualTo(String value) {
            addCriterion("backupField2 <=", value, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2Like(String value) {
            addCriterion("backupField2 like", value, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2NotLike(String value) {
            addCriterion("backupField2 not like", value, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2In(List<String> values) {
            addCriterion("backupField2 in", values, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2NotIn(List<String> values) {
            addCriterion("backupField2 not in", values, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2Between(String value1, String value2) {
            addCriterion("backupField2 between", value1, value2, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield2NotBetween(String value1, String value2) {
            addCriterion("backupField2 not between", value1, value2, "backupfield2");
            return (Criteria) this;
        }

        public Criteria andBackupfield3IsNull() {
            addCriterion("backupField3 is null");
            return (Criteria) this;
        }

        public Criteria andBackupfield3IsNotNull() {
            addCriterion("backupField3 is not null");
            return (Criteria) this;
        }

        public Criteria andBackupfield3EqualTo(String value) {
            addCriterion("backupField3 =", value, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3NotEqualTo(String value) {
            addCriterion("backupField3 <>", value, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3GreaterThan(String value) {
            addCriterion("backupField3 >", value, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3GreaterThanOrEqualTo(String value) {
            addCriterion("backupField3 >=", value, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3LessThan(String value) {
            addCriterion("backupField3 <", value, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3LessThanOrEqualTo(String value) {
            addCriterion("backupField3 <=", value, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3Like(String value) {
            addCriterion("backupField3 like", value, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3NotLike(String value) {
            addCriterion("backupField3 not like", value, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3In(List<String> values) {
            addCriterion("backupField3 in", values, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3NotIn(List<String> values) {
            addCriterion("backupField3 not in", values, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3Between(String value1, String value2) {
            addCriterion("backupField3 between", value1, value2, "backupfield3");
            return (Criteria) this;
        }

        public Criteria andBackupfield3NotBetween(String value1, String value2) {
            addCriterion("backupField3 not between", value1, value2, "backupfield3");
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