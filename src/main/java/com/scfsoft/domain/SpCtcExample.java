package com.scfsoft.domain;

import java.util.ArrayList;
import java.util.List;

public class SpCtcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpCtcExample() {
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

        public Criteria andCtcClassidIsNull() {
            addCriterion("ctc_classid is null");
            return (Criteria) this;
        }

        public Criteria andCtcClassidIsNotNull() {
            addCriterion("ctc_classid is not null");
            return (Criteria) this;
        }

        public Criteria andCtcClassidEqualTo(String value) {
            addCriterion("ctc_classid =", value, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidNotEqualTo(String value) {
            addCriterion("ctc_classid <>", value, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidGreaterThan(String value) {
            addCriterion("ctc_classid >", value, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidGreaterThanOrEqualTo(String value) {
            addCriterion("ctc_classid >=", value, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidLessThan(String value) {
            addCriterion("ctc_classid <", value, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidLessThanOrEqualTo(String value) {
            addCriterion("ctc_classid <=", value, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidLike(String value) {
            addCriterion("ctc_classid like", value, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidNotLike(String value) {
            addCriterion("ctc_classid not like", value, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidIn(List<String> values) {
            addCriterion("ctc_classid in", values, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidNotIn(List<String> values) {
            addCriterion("ctc_classid not in", values, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidBetween(String value1, String value2) {
            addCriterion("ctc_classid between", value1, value2, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcClassidNotBetween(String value1, String value2) {
            addCriterion("ctc_classid not between", value1, value2, "ctcClassid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridIsNull() {
            addCriterion("ctc_teacherid is null");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridIsNotNull() {
            addCriterion("ctc_teacherid is not null");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridEqualTo(String value) {
            addCriterion("ctc_teacherid =", value, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridNotEqualTo(String value) {
            addCriterion("ctc_teacherid <>", value, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridGreaterThan(String value) {
            addCriterion("ctc_teacherid >", value, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridGreaterThanOrEqualTo(String value) {
            addCriterion("ctc_teacherid >=", value, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridLessThan(String value) {
            addCriterion("ctc_teacherid <", value, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridLessThanOrEqualTo(String value) {
            addCriterion("ctc_teacherid <=", value, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridLike(String value) {
            addCriterion("ctc_teacherid like", value, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridNotLike(String value) {
            addCriterion("ctc_teacherid not like", value, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridIn(List<String> values) {
            addCriterion("ctc_teacherid in", values, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridNotIn(List<String> values) {
            addCriterion("ctc_teacherid not in", values, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridBetween(String value1, String value2) {
            addCriterion("ctc_teacherid between", value1, value2, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcTeacheridNotBetween(String value1, String value2) {
            addCriterion("ctc_teacherid not between", value1, value2, "ctcTeacherid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidIsNull() {
            addCriterion("ctc_courseid is null");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidIsNotNull() {
            addCriterion("ctc_courseid is not null");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidEqualTo(String value) {
            addCriterion("ctc_courseid =", value, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidNotEqualTo(String value) {
            addCriterion("ctc_courseid <>", value, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidGreaterThan(String value) {
            addCriterion("ctc_courseid >", value, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidGreaterThanOrEqualTo(String value) {
            addCriterion("ctc_courseid >=", value, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidLessThan(String value) {
            addCriterion("ctc_courseid <", value, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidLessThanOrEqualTo(String value) {
            addCriterion("ctc_courseid <=", value, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidLike(String value) {
            addCriterion("ctc_courseid like", value, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidNotLike(String value) {
            addCriterion("ctc_courseid not like", value, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidIn(List<String> values) {
            addCriterion("ctc_courseid in", values, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidNotIn(List<String> values) {
            addCriterion("ctc_courseid not in", values, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidBetween(String value1, String value2) {
            addCriterion("ctc_courseid between", value1, value2, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcCourseidNotBetween(String value1, String value2) {
            addCriterion("ctc_courseid not between", value1, value2, "ctcCourseid");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiIsNull() {
            addCriterion("ctc_xueqi is null");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiIsNotNull() {
            addCriterion("ctc_xueqi is not null");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiEqualTo(Integer value) {
            addCriterion("ctc_xueqi =", value, "ctcXueqi");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiNotEqualTo(Integer value) {
            addCriterion("ctc_xueqi <>", value, "ctcXueqi");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiGreaterThan(Integer value) {
            addCriterion("ctc_xueqi >", value, "ctcXueqi");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiGreaterThanOrEqualTo(Integer value) {
            addCriterion("ctc_xueqi >=", value, "ctcXueqi");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiLessThan(Integer value) {
            addCriterion("ctc_xueqi <", value, "ctcXueqi");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiLessThanOrEqualTo(Integer value) {
            addCriterion("ctc_xueqi <=", value, "ctcXueqi");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiIn(List<Integer> values) {
            addCriterion("ctc_xueqi in", values, "ctcXueqi");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiNotIn(List<Integer> values) {
            addCriterion("ctc_xueqi not in", values, "ctcXueqi");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiBetween(Integer value1, Integer value2) {
            addCriterion("ctc_xueqi between", value1, value2, "ctcXueqi");
            return (Criteria) this;
        }

        public Criteria andCtcXueqiNotBetween(Integer value1, Integer value2) {
            addCriterion("ctc_xueqi not between", value1, value2, "ctcXueqi");
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