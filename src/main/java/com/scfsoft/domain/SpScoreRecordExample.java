package com.scfsoft.domain;

import java.util.ArrayList;
import java.util.List;

public class SpScoreRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpScoreRecordExample() {
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

        public Criteria andSrStuidIsNull() {
            addCriterion("sr_stuid is null");
            return (Criteria) this;
        }

        public Criteria andSrStuidIsNotNull() {
            addCriterion("sr_stuid is not null");
            return (Criteria) this;
        }

        public Criteria andSrStuidEqualTo(Integer value) {
            addCriterion("sr_stuid =", value, "srStuid");
            return (Criteria) this;
        }

        public Criteria andSrStuidNotEqualTo(Integer value) {
            addCriterion("sr_stuid <>", value, "srStuid");
            return (Criteria) this;
        }

        public Criteria andSrStuidGreaterThan(Integer value) {
            addCriterion("sr_stuid >", value, "srStuid");
            return (Criteria) this;
        }

        public Criteria andSrStuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sr_stuid >=", value, "srStuid");
            return (Criteria) this;
        }

        public Criteria andSrStuidLessThan(Integer value) {
            addCriterion("sr_stuid <", value, "srStuid");
            return (Criteria) this;
        }

        public Criteria andSrStuidLessThanOrEqualTo(Integer value) {
            addCriterion("sr_stuid <=", value, "srStuid");
            return (Criteria) this;
        }

        public Criteria andSrStuidIn(List<Integer> values) {
            addCriterion("sr_stuid in", values, "srStuid");
            return (Criteria) this;
        }

        public Criteria andSrStuidNotIn(List<Integer> values) {
            addCriterion("sr_stuid not in", values, "srStuid");
            return (Criteria) this;
        }

        public Criteria andSrStuidBetween(Integer value1, Integer value2) {
            addCriterion("sr_stuid between", value1, value2, "srStuid");
            return (Criteria) this;
        }

        public Criteria andSrStuidNotBetween(Integer value1, Integer value2) {
            addCriterion("sr_stuid not between", value1, value2, "srStuid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidIsNull() {
            addCriterion("sr_courseid is null");
            return (Criteria) this;
        }

        public Criteria andSrCourseidIsNotNull() {
            addCriterion("sr_courseid is not null");
            return (Criteria) this;
        }

        public Criteria andSrCourseidEqualTo(String value) {
            addCriterion("sr_courseid =", value, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidNotEqualTo(String value) {
            addCriterion("sr_courseid <>", value, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidGreaterThan(String value) {
            addCriterion("sr_courseid >", value, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidGreaterThanOrEqualTo(String value) {
            addCriterion("sr_courseid >=", value, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidLessThan(String value) {
            addCriterion("sr_courseid <", value, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidLessThanOrEqualTo(String value) {
            addCriterion("sr_courseid <=", value, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidLike(String value) {
            addCriterion("sr_courseid like", value, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidNotLike(String value) {
            addCriterion("sr_courseid not like", value, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidIn(List<String> values) {
            addCriterion("sr_courseid in", values, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidNotIn(List<String> values) {
            addCriterion("sr_courseid not in", values, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidBetween(String value1, String value2) {
            addCriterion("sr_courseid between", value1, value2, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrCourseidNotBetween(String value1, String value2) {
            addCriterion("sr_courseid not between", value1, value2, "srCourseid");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeIsNull() {
            addCriterion("sr_examtime is null");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeIsNotNull() {
            addCriterion("sr_examtime is not null");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeEqualTo(String value) {
            addCriterion("sr_examtime =", value, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeNotEqualTo(String value) {
            addCriterion("sr_examtime <>", value, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeGreaterThan(String value) {
            addCriterion("sr_examtime >", value, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeGreaterThanOrEqualTo(String value) {
            addCriterion("sr_examtime >=", value, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeLessThan(String value) {
            addCriterion("sr_examtime <", value, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeLessThanOrEqualTo(String value) {
            addCriterion("sr_examtime <=", value, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeLike(String value) {
            addCriterion("sr_examtime like", value, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeNotLike(String value) {
            addCriterion("sr_examtime not like", value, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeIn(List<String> values) {
            addCriterion("sr_examtime in", values, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeNotIn(List<String> values) {
            addCriterion("sr_examtime not in", values, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeBetween(String value1, String value2) {
            addCriterion("sr_examtime between", value1, value2, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrExamtimeNotBetween(String value1, String value2) {
            addCriterion("sr_examtime not between", value1, value2, "srExamtime");
            return (Criteria) this;
        }

        public Criteria andSrGradeidIsNull() {
            addCriterion("sr_gradeid is null");
            return (Criteria) this;
        }

        public Criteria andSrGradeidIsNotNull() {
            addCriterion("sr_gradeid is not null");
            return (Criteria) this;
        }

        public Criteria andSrGradeidEqualTo(String value) {
            addCriterion("sr_gradeid =", value, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidNotEqualTo(String value) {
            addCriterion("sr_gradeid <>", value, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidGreaterThan(String value) {
            addCriterion("sr_gradeid >", value, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidGreaterThanOrEqualTo(String value) {
            addCriterion("sr_gradeid >=", value, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidLessThan(String value) {
            addCriterion("sr_gradeid <", value, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidLessThanOrEqualTo(String value) {
            addCriterion("sr_gradeid <=", value, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidLike(String value) {
            addCriterion("sr_gradeid like", value, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidNotLike(String value) {
            addCriterion("sr_gradeid not like", value, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidIn(List<String> values) {
            addCriterion("sr_gradeid in", values, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidNotIn(List<String> values) {
            addCriterion("sr_gradeid not in", values, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidBetween(String value1, String value2) {
            addCriterion("sr_gradeid between", value1, value2, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrGradeidNotBetween(String value1, String value2) {
            addCriterion("sr_gradeid not between", value1, value2, "srGradeid");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeIsNull() {
            addCriterion("sr_examtype is null");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeIsNotNull() {
            addCriterion("sr_examtype is not null");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeEqualTo(String value) {
            addCriterion("sr_examtype =", value, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeNotEqualTo(String value) {
            addCriterion("sr_examtype <>", value, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeGreaterThan(String value) {
            addCriterion("sr_examtype >", value, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeGreaterThanOrEqualTo(String value) {
            addCriterion("sr_examtype >=", value, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeLessThan(String value) {
            addCriterion("sr_examtype <", value, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeLessThanOrEqualTo(String value) {
            addCriterion("sr_examtype <=", value, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeLike(String value) {
            addCriterion("sr_examtype like", value, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeNotLike(String value) {
            addCriterion("sr_examtype not like", value, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeIn(List<String> values) {
            addCriterion("sr_examtype in", values, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeNotIn(List<String> values) {
            addCriterion("sr_examtype not in", values, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeBetween(String value1, String value2) {
            addCriterion("sr_examtype between", value1, value2, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrExamtypeNotBetween(String value1, String value2) {
            addCriterion("sr_examtype not between", value1, value2, "srExamtype");
            return (Criteria) this;
        }

        public Criteria andSrXueqiIsNull() {
            addCriterion("sr_xueqi is null");
            return (Criteria) this;
        }

        public Criteria andSrXueqiIsNotNull() {
            addCriterion("sr_xueqi is not null");
            return (Criteria) this;
        }

        public Criteria andSrXueqiEqualTo(Integer value) {
            addCriterion("sr_xueqi =", value, "srXueqi");
            return (Criteria) this;
        }

        public Criteria andSrXueqiNotEqualTo(Integer value) {
            addCriterion("sr_xueqi <>", value, "srXueqi");
            return (Criteria) this;
        }

        public Criteria andSrXueqiGreaterThan(Integer value) {
            addCriterion("sr_xueqi >", value, "srXueqi");
            return (Criteria) this;
        }

        public Criteria andSrXueqiGreaterThanOrEqualTo(Integer value) {
            addCriterion("sr_xueqi >=", value, "srXueqi");
            return (Criteria) this;
        }

        public Criteria andSrXueqiLessThan(Integer value) {
            addCriterion("sr_xueqi <", value, "srXueqi");
            return (Criteria) this;
        }

        public Criteria andSrXueqiLessThanOrEqualTo(Integer value) {
            addCriterion("sr_xueqi <=", value, "srXueqi");
            return (Criteria) this;
        }

        public Criteria andSrXueqiIn(List<Integer> values) {
            addCriterion("sr_xueqi in", values, "srXueqi");
            return (Criteria) this;
        }

        public Criteria andSrXueqiNotIn(List<Integer> values) {
            addCriterion("sr_xueqi not in", values, "srXueqi");
            return (Criteria) this;
        }

        public Criteria andSrXueqiBetween(Integer value1, Integer value2) {
            addCriterion("sr_xueqi between", value1, value2, "srXueqi");
            return (Criteria) this;
        }

        public Criteria andSrXueqiNotBetween(Integer value1, Integer value2) {
            addCriterion("sr_xueqi not between", value1, value2, "srXueqi");
            return (Criteria) this;
        }

        public Criteria andSrScoreIsNull() {
            addCriterion("sr_score is null");
            return (Criteria) this;
        }

        public Criteria andSrScoreIsNotNull() {
            addCriterion("sr_score is not null");
            return (Criteria) this;
        }

        public Criteria andSrScoreEqualTo(Double value) {
            addCriterion("sr_score =", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreNotEqualTo(Double value) {
            addCriterion("sr_score <>", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreGreaterThan(Double value) {
            addCriterion("sr_score >", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("sr_score >=", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreLessThan(Double value) {
            addCriterion("sr_score <", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreLessThanOrEqualTo(Double value) {
            addCriterion("sr_score <=", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreIn(List<Double> values) {
            addCriterion("sr_score in", values, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreNotIn(List<Double> values) {
            addCriterion("sr_score not in", values, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreBetween(Double value1, Double value2) {
            addCriterion("sr_score between", value1, value2, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreNotBetween(Double value1, Double value2) {
            addCriterion("sr_score not between", value1, value2, "srScore");
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