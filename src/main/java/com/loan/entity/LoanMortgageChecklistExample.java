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

public class LoanMortgageChecklistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoanMortgageChecklistExample() {
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

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterionForJDBCDate("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterionForJDBCDate("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterionForJDBCDate("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNull() {
            addCriterion("client_name is null");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNotNull() {
            addCriterion("client_name is not null");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("client_name =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("client_name <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("client_name >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("client_name >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("client_name <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("client_name <=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLike(String value) {
            addCriterion("client_name like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("client_name not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("client_name in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("client_name not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("client_name between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("client_name not between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientPhoneIsNull() {
            addCriterion("client_phone is null");
            return (Criteria) this;
        }

        public Criteria andClientPhoneIsNotNull() {
            addCriterion("client_phone is not null");
            return (Criteria) this;
        }

        public Criteria andClientPhoneEqualTo(String value) {
            addCriterion("client_phone =", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotEqualTo(String value) {
            addCriterion("client_phone <>", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneGreaterThan(String value) {
            addCriterion("client_phone >", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("client_phone >=", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneLessThan(String value) {
            addCriterion("client_phone <", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneLessThanOrEqualTo(String value) {
            addCriterion("client_phone <=", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneLike(String value) {
            addCriterion("client_phone like", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotLike(String value) {
            addCriterion("client_phone not like", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneIn(List<String> values) {
            addCriterion("client_phone in", values, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotIn(List<String> values) {
            addCriterion("client_phone not in", values, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneBetween(String value1, String value2) {
            addCriterion("client_phone between", value1, value2, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotBetween(String value1, String value2) {
            addCriterion("client_phone not between", value1, value2, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeIsNull() {
            addCriterion("client_id_type is null");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeIsNotNull() {
            addCriterion("client_id_type is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeEqualTo(String value) {
            addCriterion("client_id_type =", value, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeNotEqualTo(String value) {
            addCriterion("client_id_type <>", value, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeGreaterThan(String value) {
            addCriterion("client_id_type >", value, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("client_id_type >=", value, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeLessThan(String value) {
            addCriterion("client_id_type <", value, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeLessThanOrEqualTo(String value) {
            addCriterion("client_id_type <=", value, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeLike(String value) {
            addCriterion("client_id_type like", value, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeNotLike(String value) {
            addCriterion("client_id_type not like", value, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeIn(List<String> values) {
            addCriterion("client_id_type in", values, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeNotIn(List<String> values) {
            addCriterion("client_id_type not in", values, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeBetween(String value1, String value2) {
            addCriterion("client_id_type between", value1, value2, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdTypeNotBetween(String value1, String value2) {
            addCriterion("client_id_type not between", value1, value2, "clientIdType");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberIsNull() {
            addCriterion("client_id_number is null");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberIsNotNull() {
            addCriterion("client_id_number is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberEqualTo(String value) {
            addCriterion("client_id_number =", value, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberNotEqualTo(String value) {
            addCriterion("client_id_number <>", value, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberGreaterThan(String value) {
            addCriterion("client_id_number >", value, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("client_id_number >=", value, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberLessThan(String value) {
            addCriterion("client_id_number <", value, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberLessThanOrEqualTo(String value) {
            addCriterion("client_id_number <=", value, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberLike(String value) {
            addCriterion("client_id_number like", value, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberNotLike(String value) {
            addCriterion("client_id_number not like", value, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberIn(List<String> values) {
            addCriterion("client_id_number in", values, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberNotIn(List<String> values) {
            addCriterion("client_id_number not in", values, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberBetween(String value1, String value2) {
            addCriterion("client_id_number between", value1, value2, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientIdNumberNotBetween(String value1, String value2) {
            addCriterion("client_id_number not between", value1, value2, "clientIdNumber");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeIsNull() {
            addCriterion("client_work_type is null");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeIsNotNull() {
            addCriterion("client_work_type is not null");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeEqualTo(Integer value) {
            addCriterion("client_work_type =", value, "clientWorkType");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeNotEqualTo(Integer value) {
            addCriterion("client_work_type <>", value, "clientWorkType");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeGreaterThan(Integer value) {
            addCriterion("client_work_type >", value, "clientWorkType");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_work_type >=", value, "clientWorkType");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeLessThan(Integer value) {
            addCriterion("client_work_type <", value, "clientWorkType");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeLessThanOrEqualTo(Integer value) {
            addCriterion("client_work_type <=", value, "clientWorkType");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeIn(List<Integer> values) {
            addCriterion("client_work_type in", values, "clientWorkType");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeNotIn(List<Integer> values) {
            addCriterion("client_work_type not in", values, "clientWorkType");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeBetween(Integer value1, Integer value2) {
            addCriterion("client_work_type between", value1, value2, "clientWorkType");
            return (Criteria) this;
        }

        public Criteria andClientWorkTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("client_work_type not between", value1, value2, "clientWorkType");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitIsNull() {
            addCriterion("client_work_unit is null");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitIsNotNull() {
            addCriterion("client_work_unit is not null");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitEqualTo(String value) {
            addCriterion("client_work_unit =", value, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitNotEqualTo(String value) {
            addCriterion("client_work_unit <>", value, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitGreaterThan(String value) {
            addCriterion("client_work_unit >", value, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitGreaterThanOrEqualTo(String value) {
            addCriterion("client_work_unit >=", value, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitLessThan(String value) {
            addCriterion("client_work_unit <", value, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitLessThanOrEqualTo(String value) {
            addCriterion("client_work_unit <=", value, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitLike(String value) {
            addCriterion("client_work_unit like", value, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitNotLike(String value) {
            addCriterion("client_work_unit not like", value, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitIn(List<String> values) {
            addCriterion("client_work_unit in", values, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitNotIn(List<String> values) {
            addCriterion("client_work_unit not in", values, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitBetween(String value1, String value2) {
            addCriterion("client_work_unit between", value1, value2, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andClientWorkUnitNotBetween(String value1, String value2) {
            addCriterion("client_work_unit not between", value1, value2, "clientWorkUnit");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNull() {
            addCriterion("loan_type is null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNotNull() {
            addCriterion("loan_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeEqualTo(Integer value) {
            addCriterion("loan_type =", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotEqualTo(Integer value) {
            addCriterion("loan_type <>", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThan(Integer value) {
            addCriterion("loan_type >", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_type >=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThan(Integer value) {
            addCriterion("loan_type <", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThanOrEqualTo(Integer value) {
            addCriterion("loan_type <=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIn(List<Integer> values) {
            addCriterion("loan_type in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotIn(List<Integer> values) {
            addCriterion("loan_type not in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeBetween(Integer value1, Integer value2) {
            addCriterion("loan_type between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_type not between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNull() {
            addCriterion("loan_amount is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNotNull() {
            addCriterion("loan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountEqualTo(String value) {
            addCriterion("loan_amount =", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotEqualTo(String value) {
            addCriterion("loan_amount <>", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThan(String value) {
            addCriterion("loan_amount >", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThanOrEqualTo(String value) {
            addCriterion("loan_amount >=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThan(String value) {
            addCriterion("loan_amount <", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThanOrEqualTo(String value) {
            addCriterion("loan_amount <=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLike(String value) {
            addCriterion("loan_amount like", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotLike(String value) {
            addCriterion("loan_amount not like", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIn(List<String> values) {
            addCriterion("loan_amount in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotIn(List<String> values) {
            addCriterion("loan_amount not in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountBetween(String value1, String value2) {
            addCriterion("loan_amount between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotBetween(String value1, String value2) {
            addCriterion("loan_amount not between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodIsNull() {
            addCriterion("loan_period is null");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodIsNotNull() {
            addCriterion("loan_period is not null");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodEqualTo(String value) {
            addCriterion("loan_period =", value, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodNotEqualTo(String value) {
            addCriterion("loan_period <>", value, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodGreaterThan(String value) {
            addCriterion("loan_period >", value, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("loan_period >=", value, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodLessThan(String value) {
            addCriterion("loan_period <", value, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodLessThanOrEqualTo(String value) {
            addCriterion("loan_period <=", value, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodLike(String value) {
            addCriterion("loan_period like", value, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodNotLike(String value) {
            addCriterion("loan_period not like", value, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodIn(List<String> values) {
            addCriterion("loan_period in", values, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodNotIn(List<String> values) {
            addCriterion("loan_period not in", values, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodBetween(String value1, String value2) {
            addCriterion("loan_period between", value1, value2, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andLoanPeriodNotBetween(String value1, String value2) {
            addCriterion("loan_period not between", value1, value2, "loanPeriod");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceIsNull() {
            addCriterion("checklist_source is null");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceIsNotNull() {
            addCriterion("checklist_source is not null");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceEqualTo(Integer value) {
            addCriterion("checklist_source =", value, "checklistSource");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceNotEqualTo(Integer value) {
            addCriterion("checklist_source <>", value, "checklistSource");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceGreaterThan(Integer value) {
            addCriterion("checklist_source >", value, "checklistSource");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("checklist_source >=", value, "checklistSource");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceLessThan(Integer value) {
            addCriterion("checklist_source <", value, "checklistSource");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceLessThanOrEqualTo(Integer value) {
            addCriterion("checklist_source <=", value, "checklistSource");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceIn(List<Integer> values) {
            addCriterion("checklist_source in", values, "checklistSource");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceNotIn(List<Integer> values) {
            addCriterion("checklist_source not in", values, "checklistSource");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceBetween(Integer value1, Integer value2) {
            addCriterion("checklist_source between", value1, value2, "checklistSource");
            return (Criteria) this;
        }

        public Criteria andChecklistSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("checklist_source not between", value1, value2, "checklistSource");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNull() {
            addCriterion("agent_name is null");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNotNull() {
            addCriterion("agent_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgentNameEqualTo(String value) {
            addCriterion("agent_name =", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotEqualTo(String value) {
            addCriterion("agent_name <>", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThan(String value) {
            addCriterion("agent_name >", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThanOrEqualTo(String value) {
            addCriterion("agent_name >=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThan(String value) {
            addCriterion("agent_name <", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThanOrEqualTo(String value) {
            addCriterion("agent_name <=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLike(String value) {
            addCriterion("agent_name like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotLike(String value) {
            addCriterion("agent_name not like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameIn(List<String> values) {
            addCriterion("agent_name in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotIn(List<String> values) {
            addCriterion("agent_name not in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameBetween(String value1, String value2) {
            addCriterion("agent_name between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotBetween(String value1, String value2) {
            addCriterion("agent_name not between", value1, value2, "agentName");
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