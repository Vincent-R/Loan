package com.loan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

public class LoanMortgageRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoanMortgageRecordExample() {
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChecklistIsNull() {
            addCriterion("checklist is null");
            return (Criteria) this;
        }

        public Criteria andChecklistIsNotNull() {
            addCriterion("checklist is not null");
            return (Criteria) this;
        }

        public Criteria andChecklistEqualTo(String value) {
            addCriterion("checklist =", value, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistNotEqualTo(String value) {
            addCriterion("checklist <>", value, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistGreaterThan(String value) {
            addCriterion("checklist >", value, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistGreaterThanOrEqualTo(String value) {
            addCriterion("checklist >=", value, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistLessThan(String value) {
            addCriterion("checklist <", value, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistLessThanOrEqualTo(String value) {
            addCriterion("checklist <=", value, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistLike(String value) {
            addCriterion("checklist like", value, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistNotLike(String value) {
            addCriterion("checklist not like", value, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistIn(List<String> values) {
            addCriterion("checklist in", values, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistNotIn(List<String> values) {
            addCriterion("checklist not in", values, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistBetween(String value1, String value2) {
            addCriterion("checklist between", value1, value2, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistNotBetween(String value1, String value2) {
            addCriterion("checklist not between", value1, value2, "checklist");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorIsNull() {
            addCriterion("checklist_operator is null");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorIsNotNull() {
            addCriterion("checklist_operator is not null");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorEqualTo(String value) {
            addCriterion("checklist_operator =", value, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorNotEqualTo(String value) {
            addCriterion("checklist_operator <>", value, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorGreaterThan(String value) {
            addCriterion("checklist_operator >", value, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("checklist_operator >=", value, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorLessThan(String value) {
            addCriterion("checklist_operator <", value, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorLessThanOrEqualTo(String value) {
            addCriterion("checklist_operator <=", value, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorLike(String value) {
            addCriterion("checklist_operator like", value, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorNotLike(String value) {
            addCriterion("checklist_operator not like", value, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorIn(List<String> values) {
            addCriterion("checklist_operator in", values, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorNotIn(List<String> values) {
            addCriterion("checklist_operator not in", values, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorBetween(String value1, String value2) {
            addCriterion("checklist_operator between", value1, value2, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andChecklistOperatorNotBetween(String value1, String value2) {
            addCriterion("checklist_operator not between", value1, value2, "checklistOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNull() {
            addCriterion("advice is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNotNull() {
            addCriterion("advice is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceEqualTo(String value) {
            addCriterion("advice =", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotEqualTo(String value) {
            addCriterion("advice <>", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThan(String value) {
            addCriterion("advice >", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("advice >=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThan(String value) {
            addCriterion("advice <", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThanOrEqualTo(String value) {
            addCriterion("advice <=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLike(String value) {
            addCriterion("advice like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotLike(String value) {
            addCriterion("advice not like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceIn(List<String> values) {
            addCriterion("advice in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotIn(List<String> values) {
            addCriterion("advice not in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceBetween(String value1, String value2) {
            addCriterion("advice between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotBetween(String value1, String value2) {
            addCriterion("advice not between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorIsNull() {
            addCriterion("advice_operator is null");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorIsNotNull() {
            addCriterion("advice_operator is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorEqualTo(String value) {
            addCriterion("advice_operator =", value, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorNotEqualTo(String value) {
            addCriterion("advice_operator <>", value, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorGreaterThan(String value) {
            addCriterion("advice_operator >", value, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("advice_operator >=", value, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorLessThan(String value) {
            addCriterion("advice_operator <", value, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorLessThanOrEqualTo(String value) {
            addCriterion("advice_operator <=", value, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorLike(String value) {
            addCriterion("advice_operator like", value, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorNotLike(String value) {
            addCriterion("advice_operator not like", value, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorIn(List<String> values) {
            addCriterion("advice_operator in", values, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorNotIn(List<String> values) {
            addCriterion("advice_operator not in", values, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorBetween(String value1, String value2) {
            addCriterion("advice_operator between", value1, value2, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andAdviceOperatorNotBetween(String value1, String value2) {
            addCriterion("advice_operator not between", value1, value2, "adviceOperator");
            return (Criteria) this;
        }

        public Criteria andCatalogIsNull() {
            addCriterion("`catalog` is null");
            return (Criteria) this;
        }

        public Criteria andCatalogIsNotNull() {
            addCriterion("`catalog` is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogEqualTo(String value) {
            addCriterion("`catalog` =", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotEqualTo(String value) {
            addCriterion("`catalog` <>", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogGreaterThan(String value) {
            addCriterion("`catalog` >", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("`catalog` >=", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogLessThan(String value) {
            addCriterion("`catalog` <", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogLessThanOrEqualTo(String value) {
            addCriterion("`catalog` <=", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogLike(String value) {
            addCriterion("`catalog` like", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotLike(String value) {
            addCriterion("`catalog` not like", value, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogIn(List<String> values) {
            addCriterion("`catalog` in", values, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotIn(List<String> values) {
            addCriterion("`catalog` not in", values, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogBetween(String value1, String value2) {
            addCriterion("`catalog` between", value1, value2, "catalog");
            return (Criteria) this;
        }

        public Criteria andCatalogNotBetween(String value1, String value2) {
            addCriterion("`catalog` not between", value1, value2, "catalog");
            return (Criteria) this;
        }

        public Criteria andFormIsNull() {
            addCriterion("form is null");
            return (Criteria) this;
        }

        public Criteria andFormIsNotNull() {
            addCriterion("form is not null");
            return (Criteria) this;
        }

        public Criteria andFormEqualTo(String value) {
            addCriterion("form =", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormNotEqualTo(String value) {
            addCriterion("form <>", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormGreaterThan(String value) {
            addCriterion("form >", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormGreaterThanOrEqualTo(String value) {
            addCriterion("form >=", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormLessThan(String value) {
            addCriterion("form <", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormLessThanOrEqualTo(String value) {
            addCriterion("form <=", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormLike(String value) {
            addCriterion("form like", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormNotLike(String value) {
            addCriterion("form not like", value, "form");
            return (Criteria) this;
        }

        public Criteria andFormIn(List<String> values) {
            addCriterion("form in", values, "form");
            return (Criteria) this;
        }

        public Criteria andFormNotIn(List<String> values) {
            addCriterion("form not in", values, "form");
            return (Criteria) this;
        }

        public Criteria andFormBetween(String value1, String value2) {
            addCriterion("form between", value1, value2, "form");
            return (Criteria) this;
        }

        public Criteria andFormNotBetween(String value1, String value2) {
            addCriterion("form not between", value1, value2, "form");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeIsNull() {
            addCriterion("visa_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeIsNotNull() {
            addCriterion("visa_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("visa_finish_time =", value, "visaFinishTime");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("visa_finish_time <>", value, "visaFinishTime");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("visa_finish_time >", value, "visaFinishTime");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("visa_finish_time >=", value, "visaFinishTime");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeLessThan(Date value) {
            addCriterionForJDBCDate("visa_finish_time <", value, "visaFinishTime");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("visa_finish_time <=", value, "visaFinishTime");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("visa_finish_time in", values, "visaFinishTime");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("visa_finish_time not in", values, "visaFinishTime");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("visa_finish_time between", value1, value2, "visaFinishTime");
            return (Criteria) this;
        }

        public Criteria andVisaFinishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("visa_finish_time not between", value1, value2, "visaFinishTime");
            return (Criteria) this;
        }

        public Criteria andVisaAddressIsNull() {
            addCriterion("visa_address is null");
            return (Criteria) this;
        }

        public Criteria andVisaAddressIsNotNull() {
            addCriterion("visa_address is not null");
            return (Criteria) this;
        }

        public Criteria andVisaAddressEqualTo(String value) {
            addCriterion("visa_address =", value, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressNotEqualTo(String value) {
            addCriterion("visa_address <>", value, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressGreaterThan(String value) {
            addCriterion("visa_address >", value, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressGreaterThanOrEqualTo(String value) {
            addCriterion("visa_address >=", value, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressLessThan(String value) {
            addCriterion("visa_address <", value, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressLessThanOrEqualTo(String value) {
            addCriterion("visa_address <=", value, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressLike(String value) {
            addCriterion("visa_address like", value, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressNotLike(String value) {
            addCriterion("visa_address not like", value, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressIn(List<String> values) {
            addCriterion("visa_address in", values, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressNotIn(List<String> values) {
            addCriterion("visa_address not in", values, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressBetween(String value1, String value2) {
            addCriterion("visa_address between", value1, value2, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaAddressNotBetween(String value1, String value2) {
            addCriterion("visa_address not between", value1, value2, "visaAddress");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorIsNull() {
            addCriterion("visa_operator is null");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorIsNotNull() {
            addCriterion("visa_operator is not null");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorEqualTo(String value) {
            addCriterion("visa_operator =", value, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorNotEqualTo(String value) {
            addCriterion("visa_operator <>", value, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorGreaterThan(String value) {
            addCriterion("visa_operator >", value, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("visa_operator >=", value, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorLessThan(String value) {
            addCriterion("visa_operator <", value, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorLessThanOrEqualTo(String value) {
            addCriterion("visa_operator <=", value, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorLike(String value) {
            addCriterion("visa_operator like", value, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorNotLike(String value) {
            addCriterion("visa_operator not like", value, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorIn(List<String> values) {
            addCriterion("visa_operator in", values, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorNotIn(List<String> values) {
            addCriterion("visa_operator not in", values, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorBetween(String value1, String value2) {
            addCriterion("visa_operator between", value1, value2, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andVisaOperatorNotBetween(String value1, String value2) {
            addCriterion("visa_operator not between", value1, value2, "visaOperator");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeIsNull() {
            addCriterion("order_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeIsNotNull() {
            addCriterion("order_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("order_finish_time =", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_finish_time <>", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("order_finish_time >", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_finish_time >=", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeLessThan(Date value) {
            addCriterionForJDBCDate("order_finish_time <", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_finish_time <=", value, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("order_finish_time in", values, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_finish_time not in", values, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_finish_time between", value1, value2, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderFinishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_finish_time not between", value1, value2, "orderFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyIsNull() {
            addCriterion("order_evaluate_company is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyIsNotNull() {
            addCriterion("order_evaluate_company is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyEqualTo(String value) {
            addCriterion("order_evaluate_company =", value, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyNotEqualTo(String value) {
            addCriterion("order_evaluate_company <>", value, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyGreaterThan(String value) {
            addCriterion("order_evaluate_company >", value, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("order_evaluate_company >=", value, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyLessThan(String value) {
            addCriterion("order_evaluate_company <", value, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyLessThanOrEqualTo(String value) {
            addCriterion("order_evaluate_company <=", value, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyLike(String value) {
            addCriterion("order_evaluate_company like", value, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyNotLike(String value) {
            addCriterion("order_evaluate_company not like", value, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyIn(List<String> values) {
            addCriterion("order_evaluate_company in", values, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyNotIn(List<String> values) {
            addCriterion("order_evaluate_company not in", values, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyBetween(String value1, String value2) {
            addCriterion("order_evaluate_company between", value1, value2, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCompanyNotBetween(String value1, String value2) {
            addCriterion("order_evaluate_company not between", value1, value2, "orderEvaluateCompany");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeIsNull() {
            addCriterion("order_report_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeIsNotNull() {
            addCriterion("order_report_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("order_report_finish_time =", value, "orderReportFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_report_finish_time <>", value, "orderReportFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("order_report_finish_time >", value, "orderReportFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_report_finish_time >=", value, "orderReportFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeLessThan(Date value) {
            addCriterionForJDBCDate("order_report_finish_time <", value, "orderReportFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_report_finish_time <=", value, "orderReportFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("order_report_finish_time in", values, "orderReportFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_report_finish_time not in", values, "orderReportFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_report_finish_time between", value1, value2, "orderReportFinishTime");
            return (Criteria) this;
        }

        public Criteria andOrderReportFinishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_report_finish_time not between", value1, value2, "orderReportFinishTime");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteIsNull() {
            addCriterion("approve_data_complete is null");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteIsNotNull() {
            addCriterion("approve_data_complete is not null");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteEqualTo(Byte value) {
            addCriterion("approve_data_complete =", value, "approveDataComplete");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteNotEqualTo(Byte value) {
            addCriterion("approve_data_complete <>", value, "approveDataComplete");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteGreaterThan(Byte value) {
            addCriterion("approve_data_complete >", value, "approveDataComplete");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("approve_data_complete >=", value, "approveDataComplete");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteLessThan(Byte value) {
            addCriterion("approve_data_complete <", value, "approveDataComplete");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteLessThanOrEqualTo(Byte value) {
            addCriterion("approve_data_complete <=", value, "approveDataComplete");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteIn(List<Byte> values) {
            addCriterion("approve_data_complete in", values, "approveDataComplete");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteNotIn(List<Byte> values) {
            addCriterion("approve_data_complete not in", values, "approveDataComplete");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteBetween(Byte value1, Byte value2) {
            addCriterion("approve_data_complete between", value1, value2, "approveDataComplete");
            return (Criteria) this;
        }

        public Criteria andApproveDataCompleteNotBetween(Byte value1, Byte value2) {
            addCriterion("approve_data_complete not between", value1, value2, "approveDataComplete");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNull() {
            addCriterion("approve_time is null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNotNull() {
            addCriterion("approve_time is not null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeEqualTo(Date value) {
            addCriterionForJDBCDate("approve_time =", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("approve_time <>", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("approve_time >", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("approve_time >=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThan(Date value) {
            addCriterionForJDBCDate("approve_time <", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("approve_time <=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIn(List<Date> values) {
            addCriterionForJDBCDate("approve_time in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("approve_time not in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("approve_time between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("approve_time not between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApprovePassIsNull() {
            addCriterion("approve_pass is null");
            return (Criteria) this;
        }

        public Criteria andApprovePassIsNotNull() {
            addCriterion("approve_pass is not null");
            return (Criteria) this;
        }

        public Criteria andApprovePassEqualTo(Byte value) {
            addCriterion("approve_pass =", value, "approvePass");
            return (Criteria) this;
        }

        public Criteria andApprovePassNotEqualTo(Byte value) {
            addCriterion("approve_pass <>", value, "approvePass");
            return (Criteria) this;
        }

        public Criteria andApprovePassGreaterThan(Byte value) {
            addCriterion("approve_pass >", value, "approvePass");
            return (Criteria) this;
        }

        public Criteria andApprovePassGreaterThanOrEqualTo(Byte value) {
            addCriterion("approve_pass >=", value, "approvePass");
            return (Criteria) this;
        }

        public Criteria andApprovePassLessThan(Byte value) {
            addCriterion("approve_pass <", value, "approvePass");
            return (Criteria) this;
        }

        public Criteria andApprovePassLessThanOrEqualTo(Byte value) {
            addCriterion("approve_pass <=", value, "approvePass");
            return (Criteria) this;
        }

        public Criteria andApprovePassIn(List<Byte> values) {
            addCriterion("approve_pass in", values, "approvePass");
            return (Criteria) this;
        }

        public Criteria andApprovePassNotIn(List<Byte> values) {
            addCriterion("approve_pass not in", values, "approvePass");
            return (Criteria) this;
        }

        public Criteria andApprovePassBetween(Byte value1, Byte value2) {
            addCriterion("approve_pass between", value1, value2, "approvePass");
            return (Criteria) this;
        }

        public Criteria andApprovePassNotBetween(Byte value1, Byte value2) {
            addCriterion("approve_pass not between", value1, value2, "approvePass");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeIsNull() {
            addCriterion("approve_zp_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeIsNotNull() {
            addCriterion("approve_zp_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("approve_zp_finish_time =", value, "approveZpFinishTime");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("approve_zp_finish_time <>", value, "approveZpFinishTime");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("approve_zp_finish_time >", value, "approveZpFinishTime");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("approve_zp_finish_time >=", value, "approveZpFinishTime");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeLessThan(Date value) {
            addCriterionForJDBCDate("approve_zp_finish_time <", value, "approveZpFinishTime");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("approve_zp_finish_time <=", value, "approveZpFinishTime");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("approve_zp_finish_time in", values, "approveZpFinishTime");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("approve_zp_finish_time not in", values, "approveZpFinishTime");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("approve_zp_finish_time between", value1, value2, "approveZpFinishTime");
            return (Criteria) this;
        }

        public Criteria andApproveZpFinishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("approve_zp_finish_time not between", value1, value2, "approveZpFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeIsNull() {
            addCriterion("mortgage_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeIsNotNull() {
            addCriterion("mortgage_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_finish_time =", value, "mortgageFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_finish_time <>", value, "mortgageFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("mortgage_finish_time >", value, "mortgageFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_finish_time >=", value, "mortgageFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeLessThan(Date value) {
            addCriterionForJDBCDate("mortgage_finish_time <", value, "mortgageFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_finish_time <=", value, "mortgageFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("mortgage_finish_time in", values, "mortgageFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("mortgage_finish_time not in", values, "mortgageFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mortgage_finish_time between", value1, value2, "mortgageFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageFinishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mortgage_finish_time not between", value1, value2, "mortgageFinishTime");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeIsNull() {
            addCriterion("mortgage_need_guarantee is null");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeIsNotNull() {
            addCriterion("mortgage_need_guarantee is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeEqualTo(Byte value) {
            addCriterion("mortgage_need_guarantee =", value, "mortgageNeedGuarantee");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeNotEqualTo(Byte value) {
            addCriterion("mortgage_need_guarantee <>", value, "mortgageNeedGuarantee");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeGreaterThan(Byte value) {
            addCriterion("mortgage_need_guarantee >", value, "mortgageNeedGuarantee");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeGreaterThanOrEqualTo(Byte value) {
            addCriterion("mortgage_need_guarantee >=", value, "mortgageNeedGuarantee");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeLessThan(Byte value) {
            addCriterion("mortgage_need_guarantee <", value, "mortgageNeedGuarantee");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeLessThanOrEqualTo(Byte value) {
            addCriterion("mortgage_need_guarantee <=", value, "mortgageNeedGuarantee");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeIn(List<Byte> values) {
            addCriterion("mortgage_need_guarantee in", values, "mortgageNeedGuarantee");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeNotIn(List<Byte> values) {
            addCriterion("mortgage_need_guarantee not in", values, "mortgageNeedGuarantee");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeBetween(Byte value1, Byte value2) {
            addCriterion("mortgage_need_guarantee between", value1, value2, "mortgageNeedGuarantee");
            return (Criteria) this;
        }

        public Criteria andMortgageNeedGuaranteeNotBetween(Byte value1, Byte value2) {
            addCriterion("mortgage_need_guarantee not between", value1, value2, "mortgageNeedGuarantee");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampIsNull() {
            addCriterion("mortgage_g_stamp is null");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampIsNotNull() {
            addCriterion("mortgage_g_stamp is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampEqualTo(Byte value) {
            addCriterion("mortgage_g_stamp =", value, "mortgageGStamp");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampNotEqualTo(Byte value) {
            addCriterion("mortgage_g_stamp <>", value, "mortgageGStamp");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampGreaterThan(Byte value) {
            addCriterion("mortgage_g_stamp >", value, "mortgageGStamp");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampGreaterThanOrEqualTo(Byte value) {
            addCriterion("mortgage_g_stamp >=", value, "mortgageGStamp");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampLessThan(Byte value) {
            addCriterion("mortgage_g_stamp <", value, "mortgageGStamp");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampLessThanOrEqualTo(Byte value) {
            addCriterion("mortgage_g_stamp <=", value, "mortgageGStamp");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampIn(List<Byte> values) {
            addCriterion("mortgage_g_stamp in", values, "mortgageGStamp");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampNotIn(List<Byte> values) {
            addCriterion("mortgage_g_stamp not in", values, "mortgageGStamp");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampBetween(Byte value1, Byte value2) {
            addCriterion("mortgage_g_stamp between", value1, value2, "mortgageGStamp");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampNotBetween(Byte value1, Byte value2) {
            addCriterion("mortgage_g_stamp not between", value1, value2, "mortgageGStamp");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeIsNull() {
            addCriterion("mortgage_g_stamp_time is null");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeIsNotNull() {
            addCriterion("mortgage_g_stamp_time is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_g_stamp_time =", value, "mortgageGStampTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_g_stamp_time <>", value, "mortgageGStampTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("mortgage_g_stamp_time >", value, "mortgageGStampTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_g_stamp_time >=", value, "mortgageGStampTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeLessThan(Date value) {
            addCriterionForJDBCDate("mortgage_g_stamp_time <", value, "mortgageGStampTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_g_stamp_time <=", value, "mortgageGStampTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeIn(List<Date> values) {
            addCriterionForJDBCDate("mortgage_g_stamp_time in", values, "mortgageGStampTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("mortgage_g_stamp_time not in", values, "mortgageGStampTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mortgage_g_stamp_time between", value1, value2, "mortgageGStampTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGStampTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mortgage_g_stamp_time not between", value1, value2, "mortgageGStampTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeIsNull() {
            addCriterion("mortgage_g_time is null");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeIsNotNull() {
            addCriterion("mortgage_g_time is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_g_time =", value, "mortgageGTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_g_time <>", value, "mortgageGTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("mortgage_g_time >", value, "mortgageGTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_g_time >=", value, "mortgageGTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeLessThan(Date value) {
            addCriterionForJDBCDate("mortgage_g_time <", value, "mortgageGTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mortgage_g_time <=", value, "mortgageGTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeIn(List<Date> values) {
            addCriterionForJDBCDate("mortgage_g_time in", values, "mortgageGTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("mortgage_g_time not in", values, "mortgageGTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mortgage_g_time between", value1, value2, "mortgageGTime");
            return (Criteria) this;
        }

        public Criteria andMortgageGTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mortgage_g_time not between", value1, value2, "mortgageGTime");
            return (Criteria) this;
        }

        public Criteria andChargeSkipIsNull() {
            addCriterion("charge_skip is null");
            return (Criteria) this;
        }

        public Criteria andChargeSkipIsNotNull() {
            addCriterion("charge_skip is not null");
            return (Criteria) this;
        }

        public Criteria andChargeSkipEqualTo(Byte value) {
            addCriterion("charge_skip =", value, "chargeSkip");
            return (Criteria) this;
        }

        public Criteria andChargeSkipNotEqualTo(Byte value) {
            addCriterion("charge_skip <>", value, "chargeSkip");
            return (Criteria) this;
        }

        public Criteria andChargeSkipGreaterThan(Byte value) {
            addCriterion("charge_skip >", value, "chargeSkip");
            return (Criteria) this;
        }

        public Criteria andChargeSkipGreaterThanOrEqualTo(Byte value) {
            addCriterion("charge_skip >=", value, "chargeSkip");
            return (Criteria) this;
        }

        public Criteria andChargeSkipLessThan(Byte value) {
            addCriterion("charge_skip <", value, "chargeSkip");
            return (Criteria) this;
        }

        public Criteria andChargeSkipLessThanOrEqualTo(Byte value) {
            addCriterion("charge_skip <=", value, "chargeSkip");
            return (Criteria) this;
        }

        public Criteria andChargeSkipIn(List<Byte> values) {
            addCriterion("charge_skip in", values, "chargeSkip");
            return (Criteria) this;
        }

        public Criteria andChargeSkipNotIn(List<Byte> values) {
            addCriterion("charge_skip not in", values, "chargeSkip");
            return (Criteria) this;
        }

        public Criteria andChargeSkipBetween(Byte value1, Byte value2) {
            addCriterion("charge_skip between", value1, value2, "chargeSkip");
            return (Criteria) this;
        }

        public Criteria andChargeSkipNotBetween(Byte value1, Byte value2) {
            addCriterion("charge_skip not between", value1, value2, "chargeSkip");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeIsNull() {
            addCriterion("charge_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeIsNotNull() {
            addCriterion("charge_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("charge_finish_time =", value, "chargeFinishTime");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("charge_finish_time <>", value, "chargeFinishTime");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("charge_finish_time >", value, "chargeFinishTime");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("charge_finish_time >=", value, "chargeFinishTime");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeLessThan(Date value) {
            addCriterionForJDBCDate("charge_finish_time <", value, "chargeFinishTime");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("charge_finish_time <=", value, "chargeFinishTime");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("charge_finish_time in", values, "chargeFinishTime");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("charge_finish_time not in", values, "chargeFinishTime");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("charge_finish_time between", value1, value2, "chargeFinishTime");
            return (Criteria) this;
        }

        public Criteria andChargeFinishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("charge_finish_time not between", value1, value2, "chargeFinishTime");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNull() {
            addCriterion("process_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(String value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(String value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(String value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(String value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(String value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLike(String value) {
            addCriterion("process_id like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotLike(String value) {
            addCriterion("process_id not like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<String> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<String> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(String value1, String value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(String value1, String value2) {
            addCriterion("process_id not between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andRecordStateIsNull() {
            addCriterion("record_state is null");
            return (Criteria) this;
        }

        public Criteria andRecordStateIsNotNull() {
            addCriterion("record_state is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStateEqualTo(Integer value) {
            addCriterion("record_state =", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotEqualTo(Integer value) {
            addCriterion("record_state <>", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateGreaterThan(Integer value) {
            addCriterion("record_state >", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_state >=", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLessThan(Integer value) {
            addCriterion("record_state <", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLessThanOrEqualTo(Integer value) {
            addCriterion("record_state <=", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateIn(List<Integer> values) {
            addCriterion("record_state in", values, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotIn(List<Integer> values) {
            addCriterion("record_state not in", values, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateBetween(Integer value1, Integer value2) {
            addCriterion("record_state between", value1, value2, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotBetween(Integer value1, Integer value2) {
            addCriterion("record_state not between", value1, value2, "recordState");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeIsNull() {
            addCriterion("abandon_time is null");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeIsNotNull() {
            addCriterion("abandon_time is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeEqualTo(Date value) {
            addCriterionForJDBCDate("abandon_time =", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("abandon_time <>", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("abandon_time >", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("abandon_time >=", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeLessThan(Date value) {
            addCriterionForJDBCDate("abandon_time <", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("abandon_time <=", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeIn(List<Date> values) {
            addCriterionForJDBCDate("abandon_time in", values, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("abandon_time not in", values, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("abandon_time between", value1, value2, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("abandon_time not between", value1, value2, "abandonTime");
            return (Criteria) this;
        }
    }

    /**
     */
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