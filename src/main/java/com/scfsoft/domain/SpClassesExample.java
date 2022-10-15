package com.scfsoft.domain;

import java.util.ArrayList;
import java.util.List;

public class SpClassesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpClassesExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andCsIdIsNull() {
            addCriterion("cs_id is null");
            return (Criteria) this;
        }

        public Criteria andCsIdIsNotNull() {
            addCriterion("cs_id is not null");
            return (Criteria) this;
        }

        public Criteria andCsIdEqualTo(String value) {
            addCriterion("cs_id =", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotEqualTo(String value) {
            addCriterion("cs_id <>", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdGreaterThan(String value) {
            addCriterion("cs_id >", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdGreaterThanOrEqualTo(String value) {
            addCriterion("cs_id >=", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLessThan(String value) {
            addCriterion("cs_id <", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLessThanOrEqualTo(String value) {
            addCriterion("cs_id <=", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLike(String value) {
            addCriterion("cs_id like", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotLike(String value) {
            addCriterion("cs_id not like", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdIn(List<String> values) {
            addCriterion("cs_id in", values, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotIn(List<String> values) {
            addCriterion("cs_id not in", values, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdBetween(String value1, String value2) {
            addCriterion("cs_id between", value1, value2, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotBetween(String value1, String value2) {
            addCriterion("cs_id not between", value1, value2, "csId");
            return (Criteria) this;
        }

        public Criteria andCsDateIsNull() {
            addCriterion("cs_date is null");
            return (Criteria) this;
        }

        public Criteria andCsDateIsNotNull() {
            addCriterion("cs_date is not null");
            return (Criteria) this;
        }

        public Criteria andCsDateEqualTo(Integer value) {
            addCriterion("cs_date =", value, "csDate");
            return (Criteria) this;
        }

        public Criteria andCsDateNotEqualTo(Integer value) {
            addCriterion("cs_date <>", value, "csDate");
            return (Criteria) this;
        }

        public Criteria andCsDateGreaterThan(Integer value) {
            addCriterion("cs_date >", value, "csDate");
            return (Criteria) this;
        }

        public Criteria andCsDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("cs_date >=", value, "csDate");
            return (Criteria) this;
        }

        public Criteria andCsDateLessThan(Integer value) {
            addCriterion("cs_date <", value, "csDate");
            return (Criteria) this;
        }

        public Criteria andCsDateLessThanOrEqualTo(Integer value) {
            addCriterion("cs_date <=", value, "csDate");
            return (Criteria) this;
        }

        public Criteria andCsDateIn(List<Integer> values) {
            addCriterion("cs_date in", values, "csDate");
            return (Criteria) this;
        }

        public Criteria andCsDateNotIn(List<Integer> values) {
            addCriterion("cs_date not in", values, "csDate");
            return (Criteria) this;
        }

        public Criteria andCsDateBetween(Integer value1, Integer value2) {
            addCriterion("cs_date between", value1, value2, "csDate");
            return (Criteria) this;
        }

        public Criteria andCsDateNotBetween(Integer value1, Integer value2) {
            addCriterion("cs_date not between", value1, value2, "csDate");
            return (Criteria) this;
        }

        public Criteria andCsClassIsNull() {
            addCriterion("cs_class is null");
            return (Criteria) this;
        }

        public Criteria andCsClassIsNotNull() {
            addCriterion("cs_class is not null");
            return (Criteria) this;
        }

        public Criteria andCsClassEqualTo(Integer value) {
            addCriterion("cs_class =", value, "csClass");
            return (Criteria) this;
        }

        public Criteria andCsClassNotEqualTo(Integer value) {
            addCriterion("cs_class <>", value, "csClass");
            return (Criteria) this;
        }

        public Criteria andCsClassGreaterThan(Integer value) {
            addCriterion("cs_class >", value, "csClass");
            return (Criteria) this;
        }

        public Criteria andCsClassGreaterThanOrEqualTo(Integer value) {
            addCriterion("cs_class >=", value, "csClass");
            return (Criteria) this;
        }

        public Criteria andCsClassLessThan(Integer value) {
            addCriterion("cs_class <", value, "csClass");
            return (Criteria) this;
        }

        public Criteria andCsClassLessThanOrEqualTo(Integer value) {
            addCriterion("cs_class <=", value, "csClass");
            return (Criteria) this;
        }

        public Criteria andCsClassIn(List<Integer> values) {
            addCriterion("cs_class in", values, "csClass");
            return (Criteria) this;
        }

        public Criteria andCsClassNotIn(List<Integer> values) {
            addCriterion("cs_class not in", values, "csClass");
            return (Criteria) this;
        }

        public Criteria andCsClassBetween(Integer value1, Integer value2) {
            addCriterion("cs_class between", value1, value2, "csClass");
            return (Criteria) this;
        }

        public Criteria andCsClassNotBetween(Integer value1, Integer value2) {
            addCriterion("cs_class not between", value1, value2, "csClass");
            return (Criteria) this;
        }

        public Criteria andCsAdviserIsNull() {
            addCriterion("cs_adviser is null");
            return (Criteria) this;
        }

        public Criteria andCsAdviserIsNotNull() {
            addCriterion("cs_adviser is not null");
            return (Criteria) this;
        }

        public Criteria andCsAdviserEqualTo(String value) {
            addCriterion("cs_adviser =", value, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserNotEqualTo(String value) {
            addCriterion("cs_adviser <>", value, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserGreaterThan(String value) {
            addCriterion("cs_adviser >", value, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserGreaterThanOrEqualTo(String value) {
            addCriterion("cs_adviser >=", value, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserLessThan(String value) {
            addCriterion("cs_adviser <", value, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserLessThanOrEqualTo(String value) {
            addCriterion("cs_adviser <=", value, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserLike(String value) {
            addCriterion("cs_adviser like", value, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserNotLike(String value) {
            addCriterion("cs_adviser not like", value, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserIn(List<String> values) {
            addCriterion("cs_adviser in", values, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserNotIn(List<String> values) {
            addCriterion("cs_adviser not in", values, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserBetween(String value1, String value2) {
            addCriterion("cs_adviser between", value1, value2, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andCsAdviserNotBetween(String value1, String value2) {
            addCriterion("cs_adviser not between", value1, value2, "csAdviser");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNull() {
            addCriterion("delflag is null");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNotNull() {
            addCriterion("delflag is not null");
            return (Criteria) this;
        }

        public Criteria andDelflagEqualTo(Boolean value) {
            addCriterion("delflag =", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotEqualTo(Boolean value) {
            addCriterion("delflag <>", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThan(Boolean value) {
            addCriterion("delflag >", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("delflag >=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThan(Boolean value) {
            addCriterion("delflag <", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThanOrEqualTo(Boolean value) {
            addCriterion("delflag <=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagIn(List<Boolean> values) {
            addCriterion("delflag in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotIn(List<Boolean> values) {
            addCriterion("delflag not in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagBetween(Boolean value1, Boolean value2) {
            addCriterion("delflag between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("delflag not between", value1, value2, "delflag");
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