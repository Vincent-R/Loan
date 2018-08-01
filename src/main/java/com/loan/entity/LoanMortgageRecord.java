package com.loan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * loan_mortgage_record
 * @author 
 */
@Table(name="loan_mortgage_record")
public class LoanMortgageRecord implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 客户交接表
     */
    private String checklist;

    /**
     * 客户交接表业务员
     */
    private String checklistOperator;

    /**
     * 面谈建议表
     */
    private String advice;

    /**
     * 面谈业务员
     */
    private String adviceOperator;

    /**
     * 资料目录表
     */
    private String catalog;

    /**
     * 个人申请表
     */
    private String form;

    /**
     * 面签完成时间
     */
    private Date visaFinishTime;

    /**
     * 面签地点
     */
    private String visaAddress;

    /**
     * 面签业务员
     */
    private String visaOperator;

    /**
     * 下单完成时间
     */
    private Date orderFinishTime;

    /**
     * 下单评估公司
     */
    private String orderEvaluateCompany;

    /**
     * 出报告完成时间
     */
    private Date orderReportFinishTime;

    /**
     * 审批资料是否收齐
     */
    private Byte approveDataComplete;

    /**
     * 审批上报时间
     */
    private Date approveTime;

    /**
     * 审批是否通过
     */
    private Byte approvePass;

    /**
     * 审批出正评时间
     */
    private Date approveZpFinishTime;

    /**
     * 抵押完成时间
     */
    private Date mortgageFinishTime;

    /**
     * 抵押是否需要担保
     */
    private Byte mortgageNeedGuarantee;

    /**
     * 抵押担保是否需要盖章
     */
    private Byte mortgageGStamp;

    /**
     * 抵押担保盖章通过时间
     */
    private Date mortgageGStampTime;

    /**
     * 抵押担保出担保函时间
     */
    private Date mortgageGTime;

    /**
     * 是否跳过收费
     */
    private Byte chargeSkip;

    /**
     * 收费完成时间
     */
    private Date chargeFinishTime;

    /**
     * 流程id
     */
    private String processId;

    /**
     * 贷款单子状态
     */
    private Integer recordState;

    /**
     * 废单时间
     */
    private Date abandonTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChecklist() {
        return checklist;
    }

    public void setChecklist(String checklist) {
        this.checklist = checklist;
    }

    public String getChecklistOperator() {
        return checklistOperator;
    }

    public void setChecklistOperator(String checklistOperator) {
        this.checklistOperator = checklistOperator;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getAdviceOperator() {
        return adviceOperator;
    }

    public void setAdviceOperator(String adviceOperator) {
        this.adviceOperator = adviceOperator;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Date getVisaFinishTime() {
        return visaFinishTime;
    }

    public void setVisaFinishTime(Date visaFinishTime) {
        this.visaFinishTime = visaFinishTime;
    }

    public String getVisaAddress() {
        return visaAddress;
    }

    public void setVisaAddress(String visaAddress) {
        this.visaAddress = visaAddress;
    }

    public String getVisaOperator() {
        return visaOperator;
    }

    public void setVisaOperator(String visaOperator) {
        this.visaOperator = visaOperator;
    }

    public Date getOrderFinishTime() {
        return orderFinishTime;
    }

    public void setOrderFinishTime(Date orderFinishTime) {
        this.orderFinishTime = orderFinishTime;
    }

    public String getOrderEvaluateCompany() {
        return orderEvaluateCompany;
    }

    public void setOrderEvaluateCompany(String orderEvaluateCompany) {
        this.orderEvaluateCompany = orderEvaluateCompany;
    }

    public Date getOrderReportFinishTime() {
        return orderReportFinishTime;
    }

    public void setOrderReportFinishTime(Date orderReportFinishTime) {
        this.orderReportFinishTime = orderReportFinishTime;
    }

    public Byte getApproveDataComplete() {
        return approveDataComplete;
    }

    public void setApproveDataComplete(Byte approveDataComplete) {
        this.approveDataComplete = approveDataComplete;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public Byte getApprovePass() {
        return approvePass;
    }

    public void setApprovePass(Byte approvePass) {
        this.approvePass = approvePass;
    }

    public Date getApproveZpFinishTime() {
        return approveZpFinishTime;
    }

    public void setApproveZpFinishTime(Date approveZpFinishTime) {
        this.approveZpFinishTime = approveZpFinishTime;
    }

    public Date getMortgageFinishTime() {
        return mortgageFinishTime;
    }

    public void setMortgageFinishTime(Date mortgageFinishTime) {
        this.mortgageFinishTime = mortgageFinishTime;
    }

    public Byte getMortgageNeedGuarantee() {
        return mortgageNeedGuarantee;
    }

    public void setMortgageNeedGuarantee(Byte mortgageNeedGuarantee) {
        this.mortgageNeedGuarantee = mortgageNeedGuarantee;
    }

    public Byte getMortgageGStamp() {
        return mortgageGStamp;
    }

    public void setMortgageGStamp(Byte mortgageGStamp) {
        this.mortgageGStamp = mortgageGStamp;
    }

    public Date getMortgageGStampTime() {
        return mortgageGStampTime;
    }

    public void setMortgageGStampTime(Date mortgageGStampTime) {
        this.mortgageGStampTime = mortgageGStampTime;
    }

    public Date getMortgageGTime() {
        return mortgageGTime;
    }

    public void setMortgageGTime(Date mortgageGTime) {
        this.mortgageGTime = mortgageGTime;
    }

    public Byte getChargeSkip() {
        return chargeSkip;
    }

    public void setChargeSkip(Byte chargeSkip) {
        this.chargeSkip = chargeSkip;
    }

    public Date getChargeFinishTime() {
        return chargeFinishTime;
    }

    public void setChargeFinishTime(Date chargeFinishTime) {
        this.chargeFinishTime = chargeFinishTime;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public Integer getRecordState() {
        return recordState;
    }

    public void setRecordState(Integer recordState) {
        this.recordState = recordState;
    }

    public Date getAbandonTime() {
        return abandonTime;
    }

    public void setAbandonTime(Date abandonTime) {
        this.abandonTime = abandonTime;
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
        LoanMortgageRecord other = (LoanMortgageRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChecklist() == null ? other.getChecklist() == null : this.getChecklist().equals(other.getChecklist()))
            && (this.getChecklistOperator() == null ? other.getChecklistOperator() == null : this.getChecklistOperator().equals(other.getChecklistOperator()))
            && (this.getAdvice() == null ? other.getAdvice() == null : this.getAdvice().equals(other.getAdvice()))
            && (this.getAdviceOperator() == null ? other.getAdviceOperator() == null : this.getAdviceOperator().equals(other.getAdviceOperator()))
            && (this.getCatalog() == null ? other.getCatalog() == null : this.getCatalog().equals(other.getCatalog()))
            && (this.getForm() == null ? other.getForm() == null : this.getForm().equals(other.getForm()))
            && (this.getVisaFinishTime() == null ? other.getVisaFinishTime() == null : this.getVisaFinishTime().equals(other.getVisaFinishTime()))
            && (this.getVisaAddress() == null ? other.getVisaAddress() == null : this.getVisaAddress().equals(other.getVisaAddress()))
            && (this.getVisaOperator() == null ? other.getVisaOperator() == null : this.getVisaOperator().equals(other.getVisaOperator()))
            && (this.getOrderFinishTime() == null ? other.getOrderFinishTime() == null : this.getOrderFinishTime().equals(other.getOrderFinishTime()))
            && (this.getOrderEvaluateCompany() == null ? other.getOrderEvaluateCompany() == null : this.getOrderEvaluateCompany().equals(other.getOrderEvaluateCompany()))
            && (this.getOrderReportFinishTime() == null ? other.getOrderReportFinishTime() == null : this.getOrderReportFinishTime().equals(other.getOrderReportFinishTime()))
            && (this.getApproveDataComplete() == null ? other.getApproveDataComplete() == null : this.getApproveDataComplete().equals(other.getApproveDataComplete()))
            && (this.getApproveTime() == null ? other.getApproveTime() == null : this.getApproveTime().equals(other.getApproveTime()))
            && (this.getApprovePass() == null ? other.getApprovePass() == null : this.getApprovePass().equals(other.getApprovePass()))
            && (this.getApproveZpFinishTime() == null ? other.getApproveZpFinishTime() == null : this.getApproveZpFinishTime().equals(other.getApproveZpFinishTime()))
            && (this.getMortgageFinishTime() == null ? other.getMortgageFinishTime() == null : this.getMortgageFinishTime().equals(other.getMortgageFinishTime()))
            && (this.getMortgageNeedGuarantee() == null ? other.getMortgageNeedGuarantee() == null : this.getMortgageNeedGuarantee().equals(other.getMortgageNeedGuarantee()))
            && (this.getMortgageGStamp() == null ? other.getMortgageGStamp() == null : this.getMortgageGStamp().equals(other.getMortgageGStamp()))
            && (this.getMortgageGStampTime() == null ? other.getMortgageGStampTime() == null : this.getMortgageGStampTime().equals(other.getMortgageGStampTime()))
            && (this.getMortgageGTime() == null ? other.getMortgageGTime() == null : this.getMortgageGTime().equals(other.getMortgageGTime()))
            && (this.getChargeSkip() == null ? other.getChargeSkip() == null : this.getChargeSkip().equals(other.getChargeSkip()))
            && (this.getChargeFinishTime() == null ? other.getChargeFinishTime() == null : this.getChargeFinishTime().equals(other.getChargeFinishTime()))
            && (this.getProcessId() == null ? other.getProcessId() == null : this.getProcessId().equals(other.getProcessId()))
            && (this.getRecordState() == null ? other.getRecordState() == null : this.getRecordState().equals(other.getRecordState()))
            && (this.getAbandonTime() == null ? other.getAbandonTime() == null : this.getAbandonTime().equals(other.getAbandonTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChecklist() == null) ? 0 : getChecklist().hashCode());
        result = prime * result + ((getChecklistOperator() == null) ? 0 : getChecklistOperator().hashCode());
        result = prime * result + ((getAdvice() == null) ? 0 : getAdvice().hashCode());
        result = prime * result + ((getAdviceOperator() == null) ? 0 : getAdviceOperator().hashCode());
        result = prime * result + ((getCatalog() == null) ? 0 : getCatalog().hashCode());
        result = prime * result + ((getForm() == null) ? 0 : getForm().hashCode());
        result = prime * result + ((getVisaFinishTime() == null) ? 0 : getVisaFinishTime().hashCode());
        result = prime * result + ((getVisaAddress() == null) ? 0 : getVisaAddress().hashCode());
        result = prime * result + ((getVisaOperator() == null) ? 0 : getVisaOperator().hashCode());
        result = prime * result + ((getOrderFinishTime() == null) ? 0 : getOrderFinishTime().hashCode());
        result = prime * result + ((getOrderEvaluateCompany() == null) ? 0 : getOrderEvaluateCompany().hashCode());
        result = prime * result + ((getOrderReportFinishTime() == null) ? 0 : getOrderReportFinishTime().hashCode());
        result = prime * result + ((getApproveDataComplete() == null) ? 0 : getApproveDataComplete().hashCode());
        result = prime * result + ((getApproveTime() == null) ? 0 : getApproveTime().hashCode());
        result = prime * result + ((getApprovePass() == null) ? 0 : getApprovePass().hashCode());
        result = prime * result + ((getApproveZpFinishTime() == null) ? 0 : getApproveZpFinishTime().hashCode());
        result = prime * result + ((getMortgageFinishTime() == null) ? 0 : getMortgageFinishTime().hashCode());
        result = prime * result + ((getMortgageNeedGuarantee() == null) ? 0 : getMortgageNeedGuarantee().hashCode());
        result = prime * result + ((getMortgageGStamp() == null) ? 0 : getMortgageGStamp().hashCode());
        result = prime * result + ((getMortgageGStampTime() == null) ? 0 : getMortgageGStampTime().hashCode());
        result = prime * result + ((getMortgageGTime() == null) ? 0 : getMortgageGTime().hashCode());
        result = prime * result + ((getChargeSkip() == null) ? 0 : getChargeSkip().hashCode());
        result = prime * result + ((getChargeFinishTime() == null) ? 0 : getChargeFinishTime().hashCode());
        result = prime * result + ((getProcessId() == null) ? 0 : getProcessId().hashCode());
        result = prime * result + ((getRecordState() == null) ? 0 : getRecordState().hashCode());
        result = prime * result + ((getAbandonTime() == null) ? 0 : getAbandonTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", checklist=").append(checklist);
        sb.append(", checklistOperator=").append(checklistOperator);
        sb.append(", advice=").append(advice);
        sb.append(", adviceOperator=").append(adviceOperator);
        sb.append(", catalog=").append(catalog);
        sb.append(", form=").append(form);
        sb.append(", visaFinishTime=").append(visaFinishTime);
        sb.append(", visaAddress=").append(visaAddress);
        sb.append(", visaOperator=").append(visaOperator);
        sb.append(", orderFinishTime=").append(orderFinishTime);
        sb.append(", orderEvaluateCompany=").append(orderEvaluateCompany);
        sb.append(", orderReportFinishTime=").append(orderReportFinishTime);
        sb.append(", approveDataComplete=").append(approveDataComplete);
        sb.append(", approveTime=").append(approveTime);
        sb.append(", approvePass=").append(approvePass);
        sb.append(", approveZpFinishTime=").append(approveZpFinishTime);
        sb.append(", mortgageFinishTime=").append(mortgageFinishTime);
        sb.append(", mortgageNeedGuarantee=").append(mortgageNeedGuarantee);
        sb.append(", mortgageGStamp=").append(mortgageGStamp);
        sb.append(", mortgageGStampTime=").append(mortgageGStampTime);
        sb.append(", mortgageGTime=").append(mortgageGTime);
        sb.append(", chargeSkip=").append(chargeSkip);
        sb.append(", chargeFinishTime=").append(chargeFinishTime);
        sb.append(", processId=").append(processId);
        sb.append(", recordState=").append(recordState);
        sb.append(", abandonTime=").append(abandonTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}