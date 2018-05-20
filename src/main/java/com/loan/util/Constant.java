package com.loan.util;

public class Constant {
    public static final int RESULT_OK = 1;
    public static final int RESULT_ERROR = 0;
    public static final int AUTHORIZE_FAILED = -1;
    public static final long AUTHORIZE_TTLMILLIS = 18000000;//30分钟
    public static final long AUTHORIZE_NOTIME = 0;//0分钟
    public static final String stringKey = "loan";

    //order
    public static final int ORDER_REPORT_TYPE_CEPING = 0;
    public static final int ORDER_REPORT_TYPE_ZHENGPING = 1;

    //Approve
    public static final int APPROVE_FAIL = 0;
    public static final int APPROVE_PASS = 1;

    public static final int APPROVE_ACTION_RETRY = 0;
    public static final int APPROVE_ACTION_CHANGEBANK = 1;
    public static final int APPROVE_ACTION_GIVEUP = 2;

    public static final String APPROVE_RESULT_PASS = "0";
    public static final String APPROVE_RESULT_REAPPLY = "1";
    public static final String APPROVE_RESULT_CHANGEBANK = "2";
    public static final String APPROVE_RESULT_ABANDON = "3";

    //Charge
    public static final String CHARGE_YES = "yes";
    public static final String CHARGE_NO = "no";

    public static final int LOANRECORD_INPROCESS = 0;//贷款单子正在进行中
    public static final int LOANRECORD_COMPLETE = 1;//贷款单子完成
    public static final int LOANRECORD_ABANDON = 2;//贷款单子废单

    public static final String VIEWOFFICER = "viewOfficer";
    public static final String VISAOFFICER = "visaOfficer";
    public static final String ORDEROFFICER = "orderOfficer";
    public static final String APPROVEOFFICER = "approveOfficer";
    public static final String MORTGAGEOFFICER = "mortgageOfficer";
    public static final String CHARGEOFFICER = "chargeOfficer";
    public static final String LOANOFFICER = "loanOfficer";

    public static final String VIEWTASK = "ViewTask";
    public static final String VISATASK = "VisaTask";
    public static final String ORDERTASK = "OrderTask";
    public static final String APPROVETASK = "ApproveTask";
    public static final String MORTGAGETASK = "MortgageTask";
    public static final String CHARGETASK = "ChargeTask";
    public static final String LOANTASK = "LoanTask";

    public static final String LOANID = "loanId";
    public static final String MORTGAGELOAN = "mortgageLoan";
    public static final String HOUSELOAN = "houseLoan";
}
