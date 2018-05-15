package com.loan.util;

public class Constant {
    public static final int RESULT_OK = 1;
    public static final int RESULT_ERROR = 0;
    public static final int AUTHORIZE_FAILED = -1;
    public static final long AUTHORIZE_TTLMILLIS = 18000000;//30分钟
    public static final long AUTHORIZE_NOTIME = 0;//0分钟
    public static final String stringKey = "loan";

    //order环节
    public static final int ORDER_REPORT_STATE_UNCOMPLETE = 0;
    public static final int ORDER_REPORT_STATE_COMPLETE = 1;

    public static final int ORDER_REPORT_TYPE_CEPING = 0;
    public static final int ORDER_REPORT_TYPE_ZHENGPING = 1;

    public static final String VIEWOFFICER = "viewOfficer";
    public static final String VISAOFFICER = "visaOfficer";
    public static final String ORDEROFFICER = "orderOfficer";
    public static final String APPROVEOFFICER = "approveOfficer";
    public static final String MORTGAGEOFFICER = "mortgageOfficer";
    public static final String CHARGEOFFICER = "chargeOfficer";
    public static final String LOANOFFICER = "loanOfficer";

    public static final String LOANID = "loanId";
}
