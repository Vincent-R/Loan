package com.loan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * loan_mortgage_checklist
 * @author 
 */
@Table(name="loan_mortgage_checklist")
public class LoanMortgageChecklist implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 客户交接表完成时间
     */
    private Date finishTime;

    /**
     * 客户姓名
     */
    private String clientName;

    /**
     * 客户联系方式
     */
    private String clientPhone;

    /**
     * 客户证件类型
     */
    private String clientIdType;

    /**
     * 客户证件号码
     */
    private String clientIdNumber;

    /**
     * 客户工作种类
     */
    private Integer clientWorkType;

    /**
     * 客户工作单位
     */
    private String clientWorkUnit;

    /**
     * 客户贷款品种
     */
    private Integer loanType;

    /**
     * 客户贷款金额
     */
    private String loanAmount;

    /**
     * 客户贷款期限
     */
    private String loanPeriod;

    /**
     * 单子来源渠道
     */
    private Integer checklistSource;

    /**
     * 中介名称
     */
    private String agentName;

    /**
     * 其他备注事项
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientIdType() {
        return clientIdType;
    }

    public void setClientIdType(String clientIdType) {
        this.clientIdType = clientIdType;
    }

    public String getClientIdNumber() {
        return clientIdNumber;
    }

    public void setClientIdNumber(String clientIdNumber) {
        this.clientIdNumber = clientIdNumber;
    }

    public Integer getClientWorkType() {
        return clientWorkType;
    }

    public void setClientWorkType(Integer clientWorkType) {
        this.clientWorkType = clientWorkType;
    }

    public String getClientWorkUnit() {
        return clientWorkUnit;
    }

    public void setClientWorkUnit(String clientWorkUnit) {
        this.clientWorkUnit = clientWorkUnit;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public Integer getChecklistSource() {
        return checklistSource;
    }

    public void setChecklistSource(Integer checklistSource) {
        this.checklistSource = checklistSource;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LoanMortgageChecklist other = (LoanMortgageChecklist) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getClientName() == null ? other.getClientName() == null : this.getClientName().equals(other.getClientName()))
            && (this.getClientPhone() == null ? other.getClientPhone() == null : this.getClientPhone().equals(other.getClientPhone()))
            && (this.getClientIdType() == null ? other.getClientIdType() == null : this.getClientIdType().equals(other.getClientIdType()))
            && (this.getClientIdNumber() == null ? other.getClientIdNumber() == null : this.getClientIdNumber().equals(other.getClientIdNumber()))
            && (this.getClientWorkType() == null ? other.getClientWorkType() == null : this.getClientWorkType().equals(other.getClientWorkType()))
            && (this.getClientWorkUnit() == null ? other.getClientWorkUnit() == null : this.getClientWorkUnit().equals(other.getClientWorkUnit()))
            && (this.getLoanType() == null ? other.getLoanType() == null : this.getLoanType().equals(other.getLoanType()))
            && (this.getLoanAmount() == null ? other.getLoanAmount() == null : this.getLoanAmount().equals(other.getLoanAmount()))
            && (this.getLoanPeriod() == null ? other.getLoanPeriod() == null : this.getLoanPeriod().equals(other.getLoanPeriod()))
            && (this.getChecklistSource() == null ? other.getChecklistSource() == null : this.getChecklistSource().equals(other.getChecklistSource()))
            && (this.getAgentName() == null ? other.getAgentName() == null : this.getAgentName().equals(other.getAgentName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getClientName() == null) ? 0 : getClientName().hashCode());
        result = prime * result + ((getClientPhone() == null) ? 0 : getClientPhone().hashCode());
        result = prime * result + ((getClientIdType() == null) ? 0 : getClientIdType().hashCode());
        result = prime * result + ((getClientIdNumber() == null) ? 0 : getClientIdNumber().hashCode());
        result = prime * result + ((getClientWorkType() == null) ? 0 : getClientWorkType().hashCode());
        result = prime * result + ((getClientWorkUnit() == null) ? 0 : getClientWorkUnit().hashCode());
        result = prime * result + ((getLoanType() == null) ? 0 : getLoanType().hashCode());
        result = prime * result + ((getLoanAmount() == null) ? 0 : getLoanAmount().hashCode());
        result = prime * result + ((getLoanPeriod() == null) ? 0 : getLoanPeriod().hashCode());
        result = prime * result + ((getChecklistSource() == null) ? 0 : getChecklistSource().hashCode());
        result = prime * result + ((getAgentName() == null) ? 0 : getAgentName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", clientName=").append(clientName);
        sb.append(", clientPhone=").append(clientPhone);
        sb.append(", clientIdType=").append(clientIdType);
        sb.append(", clientIdNumber=").append(clientIdNumber);
        sb.append(", clientWorkType=").append(clientWorkType);
        sb.append(", clientWorkUnit=").append(clientWorkUnit);
        sb.append(", loanType=").append(loanType);
        sb.append(", loanAmount=").append(loanAmount);
        sb.append(", loanPeriod=").append(loanPeriod);
        sb.append(", checklistSource=").append(checklistSource);
        sb.append(", agentName=").append(agentName);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}