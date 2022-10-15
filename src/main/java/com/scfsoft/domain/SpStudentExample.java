package com.scfsoft.domain;

import java.util.ArrayList;
import java.util.List;

public class SpStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpStudentExample() {
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

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSNameIsNull() {
            addCriterion("s_name is null");
            return (Criteria) this;
        }

        public Criteria andSNameIsNotNull() {
            addCriterion("s_name is not null");
            return (Criteria) this;
        }

        public Criteria andSNameEqualTo(String value) {
            addCriterion("s_name =", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotEqualTo(String value) {
            addCriterion("s_name <>", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThan(String value) {
            addCriterion("s_name >", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThanOrEqualTo(String value) {
            addCriterion("s_name >=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThan(String value) {
            addCriterion("s_name <", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThanOrEqualTo(String value) {
            addCriterion("s_name <=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLike(String value) {
            addCriterion("s_name like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotLike(String value) {
            addCriterion("s_name not like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameIn(List<String> values) {
            addCriterion("s_name in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotIn(List<String> values) {
            addCriterion("s_name not in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameBetween(String value1, String value2) {
            addCriterion("s_name between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotBetween(String value1, String value2) {
            addCriterion("s_name not between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSPassIsNull() {
            addCriterion("s_pass is null");
            return (Criteria) this;
        }

        public Criteria andSPassIsNotNull() {
            addCriterion("s_pass is not null");
            return (Criteria) this;
        }

        public Criteria andSPassEqualTo(String value) {
            addCriterion("s_pass =", value, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassNotEqualTo(String value) {
            addCriterion("s_pass <>", value, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassGreaterThan(String value) {
            addCriterion("s_pass >", value, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassGreaterThanOrEqualTo(String value) {
            addCriterion("s_pass >=", value, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassLessThan(String value) {
            addCriterion("s_pass <", value, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassLessThanOrEqualTo(String value) {
            addCriterion("s_pass <=", value, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassLike(String value) {
            addCriterion("s_pass like", value, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassNotLike(String value) {
            addCriterion("s_pass not like", value, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassIn(List<String> values) {
            addCriterion("s_pass in", values, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassNotIn(List<String> values) {
            addCriterion("s_pass not in", values, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassBetween(String value1, String value2) {
            addCriterion("s_pass between", value1, value2, "sPass");
            return (Criteria) this;
        }

        public Criteria andSPassNotBetween(String value1, String value2) {
            addCriterion("s_pass not between", value1, value2, "sPass");
            return (Criteria) this;
        }

        public Criteria andSSexIsNull() {
            addCriterion("s_sex is null");
            return (Criteria) this;
        }

        public Criteria andSSexIsNotNull() {
            addCriterion("s_sex is not null");
            return (Criteria) this;
        }

        public Criteria andSSexEqualTo(String value) {
            addCriterion("s_sex =", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotEqualTo(String value) {
            addCriterion("s_sex <>", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexGreaterThan(String value) {
            addCriterion("s_sex >", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexGreaterThanOrEqualTo(String value) {
            addCriterion("s_sex >=", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexLessThan(String value) {
            addCriterion("s_sex <", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexLessThanOrEqualTo(String value) {
            addCriterion("s_sex <=", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexLike(String value) {
            addCriterion("s_sex like", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotLike(String value) {
            addCriterion("s_sex not like", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexIn(List<String> values) {
            addCriterion("s_sex in", values, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotIn(List<String> values) {
            addCriterion("s_sex not in", values, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexBetween(String value1, String value2) {
            addCriterion("s_sex between", value1, value2, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotBetween(String value1, String value2) {
            addCriterion("s_sex not between", value1, value2, "sSex");
            return (Criteria) this;
        }

        public Criteria andSIdcardIsNull() {
            addCriterion("s_idcard is null");
            return (Criteria) this;
        }

        public Criteria andSIdcardIsNotNull() {
            addCriterion("s_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andSIdcardEqualTo(String value) {
            addCriterion("s_idcard =", value, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardNotEqualTo(String value) {
            addCriterion("s_idcard <>", value, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardGreaterThan(String value) {
            addCriterion("s_idcard >", value, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("s_idcard >=", value, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardLessThan(String value) {
            addCriterion("s_idcard <", value, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardLessThanOrEqualTo(String value) {
            addCriterion("s_idcard <=", value, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardLike(String value) {
            addCriterion("s_idcard like", value, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardNotLike(String value) {
            addCriterion("s_idcard not like", value, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardIn(List<String> values) {
            addCriterion("s_idcard in", values, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardNotIn(List<String> values) {
            addCriterion("s_idcard not in", values, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardBetween(String value1, String value2) {
            addCriterion("s_idcard between", value1, value2, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSIdcardNotBetween(String value1, String value2) {
            addCriterion("s_idcard not between", value1, value2, "sIdcard");
            return (Criteria) this;
        }

        public Criteria andSAddressIsNull() {
            addCriterion("s_address is null");
            return (Criteria) this;
        }

        public Criteria andSAddressIsNotNull() {
            addCriterion("s_address is not null");
            return (Criteria) this;
        }

        public Criteria andSAddressEqualTo(String value) {
            addCriterion("s_address =", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotEqualTo(String value) {
            addCriterion("s_address <>", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressGreaterThan(String value) {
            addCriterion("s_address >", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressGreaterThanOrEqualTo(String value) {
            addCriterion("s_address >=", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressLessThan(String value) {
            addCriterion("s_address <", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressLessThanOrEqualTo(String value) {
            addCriterion("s_address <=", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressLike(String value) {
            addCriterion("s_address like", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotLike(String value) {
            addCriterion("s_address not like", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressIn(List<String> values) {
            addCriterion("s_address in", values, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotIn(List<String> values) {
            addCriterion("s_address not in", values, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressBetween(String value1, String value2) {
            addCriterion("s_address between", value1, value2, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotBetween(String value1, String value2) {
            addCriterion("s_address not between", value1, value2, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSNationIsNull() {
            addCriterion("s_nation is null");
            return (Criteria) this;
        }

        public Criteria andSNationIsNotNull() {
            addCriterion("s_nation is not null");
            return (Criteria) this;
        }

        public Criteria andSNationEqualTo(String value) {
            addCriterion("s_nation =", value, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationNotEqualTo(String value) {
            addCriterion("s_nation <>", value, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationGreaterThan(String value) {
            addCriterion("s_nation >", value, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationGreaterThanOrEqualTo(String value) {
            addCriterion("s_nation >=", value, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationLessThan(String value) {
            addCriterion("s_nation <", value, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationLessThanOrEqualTo(String value) {
            addCriterion("s_nation <=", value, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationLike(String value) {
            addCriterion("s_nation like", value, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationNotLike(String value) {
            addCriterion("s_nation not like", value, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationIn(List<String> values) {
            addCriterion("s_nation in", values, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationNotIn(List<String> values) {
            addCriterion("s_nation not in", values, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationBetween(String value1, String value2) {
            addCriterion("s_nation between", value1, value2, "sNation");
            return (Criteria) this;
        }

        public Criteria andSNationNotBetween(String value1, String value2) {
            addCriterion("s_nation not between", value1, value2, "sNation");
            return (Criteria) this;
        }

        public Criteria andSPolStatIsNull() {
            addCriterion("s_pol_stat is null");
            return (Criteria) this;
        }

        public Criteria andSPolStatIsNotNull() {
            addCriterion("s_pol_stat is not null");
            return (Criteria) this;
        }

        public Criteria andSPolStatEqualTo(String value) {
            addCriterion("s_pol_stat =", value, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatNotEqualTo(String value) {
            addCriterion("s_pol_stat <>", value, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatGreaterThan(String value) {
            addCriterion("s_pol_stat >", value, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatGreaterThanOrEqualTo(String value) {
            addCriterion("s_pol_stat >=", value, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatLessThan(String value) {
            addCriterion("s_pol_stat <", value, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatLessThanOrEqualTo(String value) {
            addCriterion("s_pol_stat <=", value, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatLike(String value) {
            addCriterion("s_pol_stat like", value, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatNotLike(String value) {
            addCriterion("s_pol_stat not like", value, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatIn(List<String> values) {
            addCriterion("s_pol_stat in", values, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatNotIn(List<String> values) {
            addCriterion("s_pol_stat not in", values, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatBetween(String value1, String value2) {
            addCriterion("s_pol_stat between", value1, value2, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSPolStatNotBetween(String value1, String value2) {
            addCriterion("s_pol_stat not between", value1, value2, "sPolStat");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeIsNull() {
            addCriterion("s_school_time is null");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeIsNotNull() {
            addCriterion("s_school_time is not null");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeEqualTo(String value) {
            addCriterion("s_school_time =", value, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeNotEqualTo(String value) {
            addCriterion("s_school_time <>", value, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeGreaterThan(String value) {
            addCriterion("s_school_time >", value, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeGreaterThanOrEqualTo(String value) {
            addCriterion("s_school_time >=", value, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeLessThan(String value) {
            addCriterion("s_school_time <", value, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeLessThanOrEqualTo(String value) {
            addCriterion("s_school_time <=", value, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeLike(String value) {
            addCriterion("s_school_time like", value, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeNotLike(String value) {
            addCriterion("s_school_time not like", value, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeIn(List<String> values) {
            addCriterion("s_school_time in", values, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeNotIn(List<String> values) {
            addCriterion("s_school_time not in", values, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeBetween(String value1, String value2) {
            addCriterion("s_school_time between", value1, value2, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSSchoolTimeNotBetween(String value1, String value2) {
            addCriterion("s_school_time not between", value1, value2, "sSchoolTime");
            return (Criteria) this;
        }

        public Criteria andSHouseholdIsNull() {
            addCriterion("s_household is null");
            return (Criteria) this;
        }

        public Criteria andSHouseholdIsNotNull() {
            addCriterion("s_household is not null");
            return (Criteria) this;
        }

        public Criteria andSHouseholdEqualTo(String value) {
            addCriterion("s_household =", value, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdNotEqualTo(String value) {
            addCriterion("s_household <>", value, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdGreaterThan(String value) {
            addCriterion("s_household >", value, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdGreaterThanOrEqualTo(String value) {
            addCriterion("s_household >=", value, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdLessThan(String value) {
            addCriterion("s_household <", value, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdLessThanOrEqualTo(String value) {
            addCriterion("s_household <=", value, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdLike(String value) {
            addCriterion("s_household like", value, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdNotLike(String value) {
            addCriterion("s_household not like", value, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdIn(List<String> values) {
            addCriterion("s_household in", values, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdNotIn(List<String> values) {
            addCriterion("s_household not in", values, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdBetween(String value1, String value2) {
            addCriterion("s_household between", value1, value2, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSHouseholdNotBetween(String value1, String value2) {
            addCriterion("s_household not between", value1, value2, "sHousehold");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodIsNull() {
            addCriterion("s_schoolmethod is null");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodIsNotNull() {
            addCriterion("s_schoolmethod is not null");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodEqualTo(String value) {
            addCriterion("s_schoolmethod =", value, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodNotEqualTo(String value) {
            addCriterion("s_schoolmethod <>", value, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodGreaterThan(String value) {
            addCriterion("s_schoolmethod >", value, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodGreaterThanOrEqualTo(String value) {
            addCriterion("s_schoolmethod >=", value, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodLessThan(String value) {
            addCriterion("s_schoolmethod <", value, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodLessThanOrEqualTo(String value) {
            addCriterion("s_schoolmethod <=", value, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodLike(String value) {
            addCriterion("s_schoolmethod like", value, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodNotLike(String value) {
            addCriterion("s_schoolmethod not like", value, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodIn(List<String> values) {
            addCriterion("s_schoolmethod in", values, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodNotIn(List<String> values) {
            addCriterion("s_schoolmethod not in", values, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodBetween(String value1, String value2) {
            addCriterion("s_schoolmethod between", value1, value2, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSSchoolmethodNotBetween(String value1, String value2) {
            addCriterion("s_schoolmethod not between", value1, value2, "sSchoolmethod");
            return (Criteria) this;
        }

        public Criteria andSClassIsNull() {
            addCriterion("s_class is null");
            return (Criteria) this;
        }

        public Criteria andSClassIsNotNull() {
            addCriterion("s_class is not null");
            return (Criteria) this;
        }

        public Criteria andSClassEqualTo(String value) {
            addCriterion("s_class =", value, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassNotEqualTo(String value) {
            addCriterion("s_class <>", value, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassGreaterThan(String value) {
            addCriterion("s_class >", value, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassGreaterThanOrEqualTo(String value) {
            addCriterion("s_class >=", value, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassLessThan(String value) {
            addCriterion("s_class <", value, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassLessThanOrEqualTo(String value) {
            addCriterion("s_class <=", value, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassLike(String value) {
            addCriterion("s_class like", value, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassNotLike(String value) {
            addCriterion("s_class not like", value, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassIn(List<String> values) {
            addCriterion("s_class in", values, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassNotIn(List<String> values) {
            addCriterion("s_class not in", values, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassBetween(String value1, String value2) {
            addCriterion("s_class between", value1, value2, "sClass");
            return (Criteria) this;
        }

        public Criteria andSClassNotBetween(String value1, String value2) {
            addCriterion("s_class not between", value1, value2, "sClass");
            return (Criteria) this;
        }

        public Criteria andSPicPathIsNull() {
            addCriterion("s_pic_path is null");
            return (Criteria) this;
        }

        public Criteria andSPicPathIsNotNull() {
            addCriterion("s_pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andSPicPathEqualTo(String value) {
            addCriterion("s_pic_path =", value, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathNotEqualTo(String value) {
            addCriterion("s_pic_path <>", value, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathGreaterThan(String value) {
            addCriterion("s_pic_path >", value, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("s_pic_path >=", value, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathLessThan(String value) {
            addCriterion("s_pic_path <", value, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathLessThanOrEqualTo(String value) {
            addCriterion("s_pic_path <=", value, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathLike(String value) {
            addCriterion("s_pic_path like", value, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathNotLike(String value) {
            addCriterion("s_pic_path not like", value, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathIn(List<String> values) {
            addCriterion("s_pic_path in", values, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathNotIn(List<String> values) {
            addCriterion("s_pic_path not in", values, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathBetween(String value1, String value2) {
            addCriterion("s_pic_path between", value1, value2, "sPicPath");
            return (Criteria) this;
        }

        public Criteria andSPicPathNotBetween(String value1, String value2) {
            addCriterion("s_pic_path not between", value1, value2, "sPicPath");
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