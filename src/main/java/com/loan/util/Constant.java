package com.loan.util;

public class Constant {
    public static final int RESULT_OK = 1;
    public static final int RESULT_ERROR = 0;
    public static final int AUTHORIZE_FAILED = -1;
    public static final long AUTHORIZE_TTLMILLIS = 18000000;//30分钟
    public static final long AUTHORIZE_NOTIME = 0;//0分钟
    public static final String stringKey = "loan";

    //order
    public static final int ORDER_REPORT_STATE_UNCOMPLETE = 0;
    public static final int ORDER_REPORT_STATE_COMPLETE = 1;

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

    //Mortgage
    public static final String MORTGAGE_CHARGE_YES = "yes";
    public static final String MORTGAGE_CHARGE_NO = "no";

    public static final int LOANRECORD_COMPLETE = 1;
    public static final int LOANRECORD_ABANDON = 2;

    public static final String VIEWOFFICER = "viewOfficer";
    public static final String VISAOFFICER = "visaOfficer";
    public static final String ORDEROFFICER = "orderOfficer";
    public static final String APPROVEOFFICER = "approveOfficer";
    public static final String MORTGAGEOFFICER = "mortgageOfficer";
    public static final String CHARGEOFFICER = "chargeOfficer";
    public static final String LOANOFFICER = "loanOfficer";

    public static final String LOANID = "loanId";
}
