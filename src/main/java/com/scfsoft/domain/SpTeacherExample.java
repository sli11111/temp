package com.scfsoft.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SpTeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpTeacherExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(String value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(String value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(String value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(String value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(String value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(String value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLike(String value) {
            addCriterion("t_id like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotLike(String value) {
            addCriterion("t_id not like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<String> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<String> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(String value1, String value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(String value1, String value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTNameIsNull() {
            addCriterion("t_name is null");
            return (Criteria) this;
        }

        public Criteria andTNameIsNotNull() {
            addCriterion("t_name is not null");
            return (Criteria) this;
        }

        public Criteria andTNameEqualTo(String value) {
            addCriterion("t_name =", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotEqualTo(String value) {
            addCriterion("t_name <>", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThan(String value) {
            addCriterion("t_name >", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_name >=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThan(String value) {
            addCriterion("t_name <", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThanOrEqualTo(String value) {
            addCriterion("t_name <=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLike(String value) {
            addCriterion("t_name like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotLike(String value) {
            addCriterion("t_name not like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameIn(List<String> values) {
            addCriterion("t_name in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotIn(List<String> values) {
            addCriterion("t_name not in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameBetween(String value1, String value2) {
            addCriterion("t_name between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotBetween(String value1, String value2) {
            addCriterion("t_name not between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTPassIsNull() {
            addCriterion("t_pass is null");
            return (Criteria) this;
        }

        public Criteria andTPassIsNotNull() {
            addCriterion("t_pass is not null");
            return (Criteria) this;
        }

        public Criteria andTPassEqualTo(String value) {
            addCriterion("t_pass =", value, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassNotEqualTo(String value) {
            addCriterion("t_pass <>", value, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassGreaterThan(String value) {
            addCriterion("t_pass >", value, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassGreaterThanOrEqualTo(String value) {
            addCriterion("t_pass >=", value, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassLessThan(String value) {
            addCriterion("t_pass <", value, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassLessThanOrEqualTo(String value) {
            addCriterion("t_pass <=", value, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassLike(String value) {
            addCriterion("t_pass like", value, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassNotLike(String value) {
            addCriterion("t_pass not like", value, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassIn(List<String> values) {
            addCriterion("t_pass in", values, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassNotIn(List<String> values) {
            addCriterion("t_pass not in", values, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassBetween(String value1, String value2) {
            addCriterion("t_pass between", value1, value2, "tPass");
            return (Criteria) this;
        }

        public Criteria andTPassNotBetween(String value1, String value2) {
            addCriterion("t_pass not between", value1, value2, "tPass");
            return (Criteria) this;
        }

        public Criteria andTSexIsNull() {
            addCriterion("t_sex is null");
            return (Criteria) this;
        }

        public Criteria andTSexIsNotNull() {
            addCriterion("t_sex is not null");
            return (Criteria) this;
        }

        public Criteria andTSexEqualTo(String value) {
            addCriterion("t_sex =", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotEqualTo(String value) {
            addCriterion("t_sex <>", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexGreaterThan(String value) {
            addCriterion("t_sex >", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexGreaterThanOrEqualTo(String value) {
            addCriterion("t_sex >=", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexLessThan(String value) {
            addCriterion("t_sex <", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexLessThanOrEqualTo(String value) {
            addCriterion("t_sex <=", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexLike(String value) {
            addCriterion("t_sex like", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotLike(String value) {
            addCriterion("t_sex not like", value, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexIn(List<String> values) {
            addCriterion("t_sex in", values, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotIn(List<String> values) {
            addCriterion("t_sex not in", values, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexBetween(String value1, String value2) {
            addCriterion("t_sex between", value1, value2, "tSex");
            return (Criteria) this;
        }

        public Criteria andTSexNotBetween(String value1, String value2) {
            addCriterion("t_sex not between", value1, value2, "tSex");
            return (Criteria) this;
        }

        public Criteria andTNationIsNull() {
            addCriterion("t_nation is null");
            return (Criteria) this;
        }

        public Criteria andTNationIsNotNull() {
            addCriterion("t_nation is not null");
            return (Criteria) this;
        }

        public Criteria andTNationEqualTo(String value) {
            addCriterion("t_nation =", value, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationNotEqualTo(String value) {
            addCriterion("t_nation <>", value, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationGreaterThan(String value) {
            addCriterion("t_nation >", value, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationGreaterThanOrEqualTo(String value) {
            addCriterion("t_nation >=", value, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationLessThan(String value) {
            addCriterion("t_nation <", value, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationLessThanOrEqualTo(String value) {
            addCriterion("t_nation <=", value, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationLike(String value) {
            addCriterion("t_nation like", value, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationNotLike(String value) {
            addCriterion("t_nation not like", value, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationIn(List<String> values) {
            addCriterion("t_nation in", values, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationNotIn(List<String> values) {
            addCriterion("t_nation not in", values, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationBetween(String value1, String value2) {
            addCriterion("t_nation between", value1, value2, "tNation");
            return (Criteria) this;
        }

        public Criteria andTNationNotBetween(String value1, String value2) {
            addCriterion("t_nation not between", value1, value2, "tNation");
            return (Criteria) this;
        }

        public Criteria andTPolStatIsNull() {
            addCriterion("t_pol_stat is null");
            return (Criteria) this;
        }

        public Criteria andTPolStatIsNotNull() {
            addCriterion("t_pol_stat is not null");
            return (Criteria) this;
        }

        public Criteria andTPolStatEqualTo(String value) {
            addCriterion("t_pol_stat =", value, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatNotEqualTo(String value) {
            addCriterion("t_pol_stat <>", value, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatGreaterThan(String value) {
            addCriterion("t_pol_stat >", value, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatGreaterThanOrEqualTo(String value) {
            addCriterion("t_pol_stat >=", value, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatLessThan(String value) {
            addCriterion("t_pol_stat <", value, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatLessThanOrEqualTo(String value) {
            addCriterion("t_pol_stat <=", value, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatLike(String value) {
            addCriterion("t_pol_stat like", value, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatNotLike(String value) {
            addCriterion("t_pol_stat not like", value, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatIn(List<String> values) {
            addCriterion("t_pol_stat in", values, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatNotIn(List<String> values) {
            addCriterion("t_pol_stat not in", values, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatBetween(String value1, String value2) {
            addCriterion("t_pol_stat between", value1, value2, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTPolStatNotBetween(String value1, String value2) {
            addCriterion("t_pol_stat not between", value1, value2, "tPolStat");
            return (Criteria) this;
        }

        public Criteria andTIdcardIsNull() {
            addCriterion("t_idcard is null");
            return (Criteria) this;
        }

        public Criteria andTIdcardIsNotNull() {
            addCriterion("t_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andTIdcardEqualTo(String value) {
            addCriterion("t_idcard =", value, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardNotEqualTo(String value) {
            addCriterion("t_idcard <>", value, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardGreaterThan(String value) {
            addCriterion("t_idcard >", value, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("t_idcard >=", value, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardLessThan(String value) {
            addCriterion("t_idcard <", value, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardLessThanOrEqualTo(String value) {
            addCriterion("t_idcard <=", value, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardLike(String value) {
            addCriterion("t_idcard like", value, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardNotLike(String value) {
            addCriterion("t_idcard not like", value, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardIn(List<String> values) {
            addCriterion("t_idcard in", values, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardNotIn(List<String> values) {
            addCriterion("t_idcard not in", values, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardBetween(String value1, String value2) {
            addCriterion("t_idcard between", value1, value2, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTIdcardNotBetween(String value1, String value2) {
            addCriterion("t_idcard not between", value1, value2, "tIdcard");
            return (Criteria) this;
        }

        public Criteria andTAddressIsNull() {
            addCriterion("t_address is null");
            return (Criteria) this;
        }

        public Criteria andTAddressIsNotNull() {
            addCriterion("t_address is not null");
            return (Criteria) this;
        }

        public Criteria andTAddressEqualTo(String value) {
            addCriterion("t_address =", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressNotEqualTo(String value) {
            addCriterion("t_address <>", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressGreaterThan(String value) {
            addCriterion("t_address >", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressGreaterThanOrEqualTo(String value) {
            addCriterion("t_address >=", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressLessThan(String value) {
            addCriterion("t_address <", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressLessThanOrEqualTo(String value) {
            addCriterion("t_address <=", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressLike(String value) {
            addCriterion("t_address like", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressNotLike(String value) {
            addCriterion("t_address not like", value, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressIn(List<String> values) {
            addCriterion("t_address in", values, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressNotIn(List<String> values) {
            addCriterion("t_address not in", values, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressBetween(String value1, String value2) {
            addCriterion("t_address between", value1, value2, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTAddressNotBetween(String value1, String value2) {
            addCriterion("t_address not between", value1, value2, "tAddress");
            return (Criteria) this;
        }

        public Criteria andTJobTimeIsNull() {
            addCriterion("t_job_time is null");
            return (Criteria) this;
        }

        public Criteria andTJobTimeIsNotNull() {
            addCriterion("t_job_time is not null");
            return (Criteria) this;
        }

        public Criteria andTJobTimeEqualTo(Date value) {
            addCriterionForJDBCDate("t_job_time =", value, "tJobTime");
            return (Criteria) this;
        }

        public Criteria andTJobTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("t_job_time <>", value, "tJobTime");
            return (Criteria) this;
        }

        public Criteria andTJobTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("t_job_time >", value, "tJobTime");
            return (Criteria) this;
        }

        public Criteria andTJobTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("t_job_time >=", value, "tJobTime");
            return (Criteria) this;
        }

        public Criteria andTJobTimeLessThan(Date value) {
            addCriterionForJDBCDate("t_job_time <", value, "tJobTime");
            return (Criteria) this;
        }

        public Criteria andTJobTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("t_job_time <=", value, "tJobTime");
            return (Criteria) this;
        }

        public Criteria andTJobTimeIn(List<Date> values) {
            addCriterionForJDBCDate("t_job_time in", values, "tJobTime");
            return (Criteria) this;
        }

        public Criteria andTJobTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("t_job_time not in", values, "tJobTime");
            return (Criteria) this;
        }

        public Criteria andTJobTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("t_job_time between", value1, value2, "tJobTime");
            return (Criteria) this;
        }

        public Criteria andTJobTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("t_job_time not between", value1, value2, "tJobTime");
            return (Criteria) this;
        }

        public Criteria andTEduBgIsNull() {
            addCriterion("t_edu_bg is null");
            return (Criteria) this;
        }

        public Criteria andTEduBgIsNotNull() {
            addCriterion("t_edu_bg is not null");
            return (Criteria) this;
        }

        public Criteria andTEduBgEqualTo(String value) {
            addCriterion("t_edu_bg =", value, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgNotEqualTo(String value) {
            addCriterion("t_edu_bg <>", value, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgGreaterThan(String value) {
            addCriterion("t_edu_bg >", value, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgGreaterThanOrEqualTo(String value) {
            addCriterion("t_edu_bg >=", value, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgLessThan(String value) {
            addCriterion("t_edu_bg <", value, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgLessThanOrEqualTo(String value) {
            addCriterion("t_edu_bg <=", value, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgLike(String value) {
            addCriterion("t_edu_bg like", value, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgNotLike(String value) {
            addCriterion("t_edu_bg not like", value, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgIn(List<String> values) {
            addCriterion("t_edu_bg in", values, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgNotIn(List<String> values) {
            addCriterion("t_edu_bg not in", values, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgBetween(String value1, String value2) {
            addCriterion("t_edu_bg between", value1, value2, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTEduBgNotBetween(String value1, String value2) {
            addCriterion("t_edu_bg not between", value1, value2, "tEduBg");
            return (Criteria) this;
        }

        public Criteria andTGraInsIsNull() {
            addCriterion("t_gra_ins is null");
            return (Criteria) this;
        }

        public Criteria andTGraInsIsNotNull() {
            addCriterion("t_gra_ins is not null");
            return (Criteria) this;
        }

        public Criteria andTGraInsEqualTo(String value) {
            addCriterion("t_gra_ins =", value, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsNotEqualTo(String value) {
            addCriterion("t_gra_ins <>", value, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsGreaterThan(String value) {
            addCriterion("t_gra_ins >", value, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsGreaterThanOrEqualTo(String value) {
            addCriterion("t_gra_ins >=", value, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsLessThan(String value) {
            addCriterion("t_gra_ins <", value, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsLessThanOrEqualTo(String value) {
            addCriterion("t_gra_ins <=", value, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsLike(String value) {
            addCriterion("t_gra_ins like", value, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsNotLike(String value) {
            addCriterion("t_gra_ins not like", value, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsIn(List<String> values) {
            addCriterion("t_gra_ins in", values, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsNotIn(List<String> values) {
            addCriterion("t_gra_ins not in", values, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsBetween(String value1, String value2) {
            addCriterion("t_gra_ins between", value1, value2, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTGraInsNotBetween(String value1, String value2) {
            addCriterion("t_gra_ins not between", value1, value2, "tGraIns");
            return (Criteria) this;
        }

        public Criteria andTPhoneIsNull() {
            addCriterion("t_phone is null");
            return (Criteria) this;
        }

        public Criteria andTPhoneIsNotNull() {
            addCriterion("t_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTPhoneEqualTo(String value) {
            addCriterion("t_phone =", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneNotEqualTo(String value) {
            addCriterion("t_phone <>", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneGreaterThan(String value) {
            addCriterion("t_phone >", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("t_phone >=", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneLessThan(String value) {
            addCriterion("t_phone <", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneLessThanOrEqualTo(String value) {
            addCriterion("t_phone <=", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneLike(String value) {
            addCriterion("t_phone like", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneNotLike(String value) {
            addCriterion("t_phone not like", value, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneIn(List<String> values) {
            addCriterion("t_phone in", values, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneNotIn(List<String> values) {
            addCriterion("t_phone not in", values, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneBetween(String value1, String value2) {
            addCriterion("t_phone between", value1, value2, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTPhoneNotBetween(String value1, String value2) {
            addCriterion("t_phone not between", value1, value2, "tPhone");
            return (Criteria) this;
        }

        public Criteria andTCourseIsNull() {
            addCriterion("t_course is null");
            return (Criteria) this;
        }

        public Criteria andTCourseIsNotNull() {
            addCriterion("t_course is not null");
            return (Criteria) this;
        }

        public Criteria andTCourseEqualTo(String value) {
            addCriterion("t_course =", value, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseNotEqualTo(String value) {
            addCriterion("t_course <>", value, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseGreaterThan(String value) {
            addCriterion("t_course >", value, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseGreaterThanOrEqualTo(String value) {
            addCriterion("t_course >=", value, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseLessThan(String value) {
            addCriterion("t_course <", value, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseLessThanOrEqualTo(String value) {
            addCriterion("t_course <=", value, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseLike(String value) {
            addCriterion("t_course like", value, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseNotLike(String value) {
            addCriterion("t_course not like", value, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseIn(List<String> values) {
            addCriterion("t_course in", values, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseNotIn(List<String> values) {
            addCriterion("t_course not in", values, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseBetween(String value1, String value2) {
            addCriterion("t_course between", value1, value2, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTCourseNotBetween(String value1, String value2) {
            addCriterion("t_course not between", value1, value2, "tCourse");
            return (Criteria) this;
        }

        public Criteria andTPicPathIsNull() {
            addCriterion("t_pic_path is null");
            return (Criteria) this;
        }

        public Criteria andTPicPathIsNotNull() {
            addCriterion("t_pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andTPicPathEqualTo(String value) {
            addCriterion("t_pic_path =", value, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathNotEqualTo(String value) {
            addCriterion("t_pic_path <>", value, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathGreaterThan(String value) {
            addCriterion("t_pic_path >", value, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("t_pic_path >=", value, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathLessThan(String value) {
            addCriterion("t_pic_path <", value, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathLessThanOrEqualTo(String value) {
            addCriterion("t_pic_path <=", value, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathLike(String value) {
            addCriterion("t_pic_path like", value, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathNotLike(String value) {
            addCriterion("t_pic_path not like", value, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathIn(List<String> values) {
            addCriterion("t_pic_path in", values, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathNotIn(List<String> values) {
            addCriterion("t_pic_path not in", values, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathBetween(String value1, String value2) {
            addCriterion("t_pic_path between", value1, value2, "tPicPath");
            return (Criteria) this;
        }

        public Criteria andTPicPathNotBetween(String value1, String value2) {
            addCriterion("t_pic_path not between", value1, value2, "tPicPath");
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