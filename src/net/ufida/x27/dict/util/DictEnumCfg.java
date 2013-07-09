package net.ufida.x27.dict.util;

public interface DictEnumCfg {
    /** 用户状态-正常:1 */
    String USER_STATUS_normal = "1";

    /** 用户状态-冻结:0 */
    String USER_STATUS_frozen = "0";

    /** 预警类型:1010 */
    String ALARM_TYPE_CODE = "1010";

    /** 预警类型-ATM预警:1010-1010 */
    String ALARM_TYPE_CODE_ATM = "1010-1010";

    /** 预警类型-网点预警:1010-1020 */
    String ALARM_TYPE_CODE_ORG = "1010-1020";

    /** 预警类型-账户预警:1010-1030 */
    String ALARM_TYPE_CODE_ACC = "1010-1030";

    /** 预警类型-科目预警:1010-1040 */
    String ALARM_TYPE_CODE_SUB = "1010-1040";

    /** 预警类型-交易预警:1010-1050 */
    String ALARM_TYPE_CODE_TRADE = "1010-1050";

    /** 风险等级:1020 */
    String VENTURE_LEVEL_CODE = "1020";

    /** 风险等级-一级:1020-1010 */
    String VENTURE_LEVEL_CODE_ONE = "1020-1010";

    /** 风险等级-二级:1020-1020 */
    String VENTURE_LEVEL_CODE_TWO = "1020-1020";

    /** 风险等级-三级:1020-1030 */
    String VENTURE_LEVEL_CODE_THR = "1020-1030";

    /** 处理状态：1030 * */
    String DEAL_STATUS = "1030";

    /** 处理状态-预警待核查：1030-1010 * */
    String DEAL_STATUS_CHECK_WATING_CHECK = "1030-1010";

    /** 处理状态-核查待判定：1030-1020 * */
    String DEAL_STATUS_CHECK_WATING_CONFIRM = "1030-1020";

    /** 处理状态-判定待确认：1030-1030 * */
    String DEAL_STATUS_JUDGE_WATING_CONFIRM = "1030-1030";

    /** 处理状态-拒绝待判定：1030-1040 * */
    String DEAL_STATUS_REFUSE_WATING_JUDGE = "1030-1040";

    /** 处理状态-重发待确认：1030-1050 * */
    String DEAL_STATUS_REPEAT_WATING_CONFIRM = "1030-1050";

    /** 处理状态-接受待确认：1030-1060 * */
    String DEAL_STATUS_ACCEPT_WATING_CONFIRM = "1030-1060";

    /** 处理状态-已确认：1030-1070 * */
    String DEAL_STATUS_CONFIRM = "1030-1070";

    /*
     * 事后处理状态
     */
    String AFTER_DEAL_STATUS = "1107";

    /** 事后处理状态-待复核：1107-1090 * */
    String AFTER_DEAL_STATUS_WATING_CHECK = "1107-1090";

    /** 事后处理状态-稽核待复核：1107-1010 * */
    String AFTER_DEAL_STATUS_AUDIT_WATING_CHECK = "1107-1010";

    /** 事后处理状态-复核待回复：1107-1020 * */
    String AFTER_DEAL_STATUS_CHECK_WATING_REVERT = "1107-1020";

    /** 事后处理状态-接收待核销：1107-1030 * */
    String AFTER_DEAL_STATUS_ACCEPT_WATING_DEL = "1107-1030";

    /** 事后处理状态-拒绝待稽核：1107-1040 * */
    String AFTER_DEAL_STATUS_REFUSE_WATING_AUDIT = "1107-1040";

    /** 事后处理状态-重发待复核：1107-1050 * */
    String AFTER_DEAL_STATUS_REPEAT_WATING_CHECK = "1107-1050";

    /** 事后处理状态-已抹帐：1107-1060 * */
    String AFTER_DEAL_STATUS_ERASUREED = "1107-1060";

    /** 事后处理状态-已核销：1107-1070 * */
    String AFTER_DEAL_STATUS_DELED = "1107-1070";

    /** 事后处理状态-已完成：1107-1080 * */
    String AFTER_DEAL_STATUS_COMPLETE = "1107-1080";

    /** 入账标志:1040 */
    String IN_CODE = "1040";

    /** 入账标志-已入账:1040-1010 */
    String IN_CODE_T = "1040-1010";

    /** 入账标志-未入账:1040-1020 */
    String IN_CODE_F = "1040-1020";

    /** 复核状态标志:1050 */
    String CHECK_CODE = "1050";

    /** 复核状态标志-已复核:1050-1010 */
    String CHECK_CODE_T = "1050-1010";

    /** 复核状态标志-未复核:1050-1020 */
    String CHECK_CODE_F = "1050-1020";

    /** 差错等级:1060 */
    String ERROR_LEVEL_CODE = "1060";

    /** 差错等级-默认等级:1060-1010 */
    String ERROR_LEVEL_CODE_DEF = "1060-1000";

    /** 差错等级-一级差错:1060-1010 */
    String ERROR_LEVEL_CODE_ONE = "1060-1010";

    /** 差错等级-二级差错:1060-1020 */
    String ERROR_LEVEL_CODE_TWO = "1060-1020";

    /** 差错等级-三级差错:1060-1030 */
    String ERROR_LEVEL_CODE_THREE = "1060-1030";

    /** 差错等级-正常:1060-1040 */
    String ERROR_LEVEL_CODE_OK = "1060-1040";

    /** 差错等级-异常未改正:1060-1050 */
    String ERROR_LEVEL_CODE_NO_CURE = "1060-1050";

    /** 差错等级-异常已改正:1060-1060 */
    String ERROR_LEVEL_CODE_CURE = "1060-1060";

    /** 差错等级-更正确认:1060-1070 */
    String ERROR_LEVEL_CODE_RIGHT = "1060-1070";

    /** 差错等级-接受:1060-1080 */
    String ERROR_LEVEL_ACCEPT = "1060-1080";

    /** 差错等级-差错改正常:1060-1080 */
    String ERROR_CHANGE_RIGHT = "1060-1090";

    /** 预警内容码:0110 */
    String ALARM_CONTENT_CODE = "0110";

    /** 预警内容码-账户日累计转账200万以上:0110-9001 */
    String ALARM_CONTENT_CODE_ACC_SUM_AMT = "0110-9001";

    /** 预警内容码-客户日累计转账200万以上:0110-9002 */
    String ALARM_CONTENT_CODE_CLIENT_SUM_AMT = "0110-9002";

    /** 预警内容码-账户日累计存款超过100万元:0110-9003 */
    String ALARM_CONTENT_CODE_ACC_SAVE_SUM_AMT = "0110-9003";

    /** 预警内容码-验资账户只收不付:0110-9004 */
    String ALARM_CONTENT_CODE_CHECK_ACC_CREDIT = "0110-9004";

    /** 预警内容码-单位定期（通知）存款开户转入监控:0110-9005 */
    String ALARM_CONTENT_CODE_UNIT_TERMLY_SAVE_OPEN_SHIFT = "0110-9005";

    /** 预警内容码-单位定期（通知）存款支取没有转入指定账户 =（传出账号同开户时候转入账号）:0110-9006 */
    String ALARM_CONTENT_CODE_UNIT_TERMLY_SAVE_TAKE_ACC = "0110-9006";

    /** 预警内容码-客户营业执照的期限、组织机构号码期限监控:0110-9007 */
    String ALARM_CONTENT_CODE_CERTIFICATE_MATURE = "0110-9007";

    /** 预警内容码-手工记账借方发生:0110-9008 */
    String ALARM_CONTENT_CODE_HAND_KEEP_ACC_CREDIT = "0110-9008";

    /** 预警内容码-手工记账发生对方账户为非1290:0110-9009 */
    String ALARM_CONTENT_CODE_HAND_KEEP_ACC_OPP_ACC = "0110-9009";

    /** 预警内容码-除1521和1531对转外预警:0110-9010 */
    String ALARM_CONTENT_CODE_1521_1531_TRANSFER = "0110-9010";

    /** 预警内容码-除5341、1511、1531对转外的预警:0110-9011 */
    String ALARM_CONTENT_CODE_5341_1511_1531_TRANSFER = "0110-9011";

    /** 预警内容码-除1511、1521、5361、5151对转外的预警:0110-9012 */
    String ALARM_CONTENT_CODE_1511_1521_5361_5151_TRANSFER = "0110-9012";

    /** 预警内容码-支行发生预警:0110-9013 */
    String ALARM_CONTENT_CODE_BRANCH_BANK_ALARM = "0110-9013";

    /** 预警内容码-监控人工记账借方:0110-9014 */
    String ALARM_CONTENT_CODE_HAND_KEEP_ACC_CREDIT_MONITOR = "0110-9014";

    /** 预警内容码-代扣利息税金与7066400011194641202720以外的帐户发生交易:0110-9015 */
    String ALARM_CONTENT_CODE_DESIGNATE_TRADE = "0110-9015";

    /** 预警内容码-除年终结算日监控人工记账借方金额:0110-9016 */
    String ALARM_CONTENT_CODE_YEAR_END_SUBJECT_BALANCE_CREDIT = "0110-9016";

    /** 预警内容码-该科目与应付利息以外科目转帐发生预警:0110-9017 */
    String ALARM_CONTENT_CODE_2611_TRANSFER = "0110-9017";

    /** 预警内容码-使用指定交易码操作时,只能与指定账户预警:0110-9018 */
    String ALARM_CONTENT_CODE_DESIGNATE_ACC_TRADE = "0110-9018";

    /** 预警内容码-手工记账预警:0110-9019 */
    String ALARM_CONTENT_CODE_HAND_KEEP_ACC_ALARM = "0110-9019";

    /** 预警内容码-除使用7909交易外预警:0110-9020 */
    String ALARM_CONTENT_CODE_7909_TRADE_ALARM = "0110-9020";

    /** 预警内容码-内部帐户共同类记账预警:0110-9021 */
    String ALARM_CONTENT_CODE_INN_ACC_KEEP_ACC_ALARM = "0110-9021";

    /** 预警内容码-对方科目非46416,46415:0110-9022 */
    String ALARM_CONTENT_CODE_OPP_46416_46416 = "0110-9022";

    /** 预警内容码-每天日终后,该科目本日余额不为0预警:0110-9023 */
    String ALARM_CONTENT_CODE_SUBJECT_BALANCE_DAY_END_ALARM = "0110-9023";

    /** 预警内容码-每天日终前,该科目昨日余额不为0预警:0110-9024 */
    String ALARM_CONTENT_CODE_SUBJECT_BALANCE_DAY_END_PRE_ALARM = "0110-9024";

    /** 预警内容码-1、11、21、31日，日终后，科目本日余额不为0预警:0110-9025 */
    String ALARM_CONTENT_CODE_SUBJECT_BALANCE_DAY_END_ESPECIAL_ALARM = "0110-9025";

    /** 预警内容码-年终结算日，日终后科目余额不为0预警:0110-9026 */
    String ALARM_CONTENT_CODE_SUBJECT_BALANCE_YEAR_END_ALARM = "0110-9026";

    /** 预警内容码-每季末最后一天日终后，该科目余额不为0预警:0110-9027 */
    String ALARM_CONTENT_CODE_SUBJECT_BALANCE_SEASON_END_ALARM = "0110-9027";

    /** 预警内容码-该科目余额发生变化即预警:0110-9028 */
    String ALARM_CONTENT_CODE_SUBJECT_BALANCE_CHANGE_ALARM = "0110-9028";

    /** 预警内容码-雷同交易笔数监测预警:0110-9029 */
    String ALARM_CONTENT_CODE_SIMILAR_DEBIT_TRADE_ALARM = "0110-9029";

    /** 预警内容码-同一个人帐户（存折、储蓄卡）同一天在同一柜员处办理（5）笔以上存款业务:0110-9031 */
    String ALARM_CONTENT_CODE_SIMILAR_SAVE_TRADE_ALARM = "0110-9031";

    /** 预警内容码-同一个人账户（存折、储蓄卡）同一天在同一柜员处办理（3）笔以上支取业务:0110-9032 */
    String ALARM_CONTENT_CODE_SIMILAR_TAKE_TRADE_ALARM = "0110-9032";

    /** 预警内容码-个人账户累计支取金额监测预警:0110-9033 */
    String ALARM_CONTENT_CODE_ACC_TAKE_SUM_AMT_ALARM = "0110-9033";

    /** 预警内容码-口头解挂24小时内有大额存（取）款业务预警:0110-9034 */
    String ALARM_CONTENT_CODE_ACC_LOSS_ACTION_ALARM = "0110-9034";

    /** 预警内容码-同一柜员同一日累计抹账超过5笔(各种抹账)预警:0110-9035 */
    String ALARM_CONTENT_CODE_CANCEL_BY_DAY_ALARM = "0110-9035";

    /** 预警内容码-同一柜员同一类型抹账超过3笔预警:0110-9036 */
    String ALARM_CONTENT_CODE_CANCEL_BY_TYPE_ALARM = "0110-9036";

    /** 预警内容码-同一网点同一日累计冲正超过3笔预警:0110-9037 */
    String ALARM_CONTENT_CODE_CANCEL_BY_ORG_ALARM = "0110-9037";

    /** 预警内容码-助学贷款科目人工记账借方发生预警:0110-9038 */
    String ALARM_CONTENT_CODE_ZXDK = "0110-9038";

    /** 预警内容码-委托放款科目在支行业务中发生则预警:0110-9039 */
    String ALARM_CONTENT_CODE_WTFD = "0110-9039";

    /** 预警内容码-县联社管理费收入科目非年终结算日手工记帐发生预警:0110-9040 */
    String ALARM_CONTENT_CODE_XLSGLFSR = "0110-9040";

    /** 预警内容码-同业存放款利息支出科目手工记帐预警:0110-9041 */
    String ALARM_CONTENT_CODE_TYCFKLXZC = "0110-9041";

    /** 预警内容码-转贴现利息支出科目使用7909以外交易码交易时预警:0110-9042 */
    String ALARM_CONTENT_CODE_ZTXLXZC = "0110-9042";

    /** ... */
    /** 预警内容码-日终存放联社清算资金与上存联社清算资金两科目余额不等预警:0110-9047 */
    String ALARM_CONTENT_CODE_NOT_EQ = "0110-9047";

    /** 预警内容码-该科目非年终结算日借方发生预警 */
    String ALARM_CONTENT_CODE_9055 = "0110-9055";

    /** 预警内容码-该科目非年终结算日借方发生预警 */
    String ALARM_CONTENT_CODE_9056 = "0110-9056";

    /** 预警内容码-该科目非年终结算日，支行借方发生业务的中出现 */
    String ALARM_CONTENT_CODE_9057 = "0110-9057";

    /** 预警内容码-县联社管理费收入科目非年终结算日借方发生预警 */
    String ALARM_CONTENT_CODE_9058 = "0110-9058";

    /** 预警内容码-该科目非规定交易发生预警 */
    String ALARM_CONTENT_CODE_9052 = "0110-9052";

    /** 预警内容码-该科目，在支行借方发生预警 */
    String ALARM_CONTENT_CODE_9053 = "0110-9053";

    /** 预警内容码-营业税科目与7066400011194641202720,2621以外帐号发生转帐时预警 */
    String ALARM_CONTENT_CODE_9054 = "0110-9054";

    /** 借贷标志:1070 */
    String CREDIT_CODE = "1070";

    /** 借贷标志-两性:1070-1010 */
    String CREDIT_CODE_ALL = "1070-1010";

    /** 借贷标志-借:1070-1020 */
    String CREDIT_CODE_DEBIT = "1070-1020";

    /** 借贷标志-贷:1070-1030 */
    String CREDIT_CODE_CREDIT = "1070-1030";

    /** 借贷标志-无借贷:1070-1040 */
    String CREDIT_CODE_NO_FLAG = "1070-1040";

    /** 借贷标志-无法计算:1070-1000 */
    String CREDIT_CODE_NO_CACULATE = "1070-1000";

    /** 账户对公对私标志:1080 */
    String ACC_PUB_PRI_TYPE_CODE = "1080";

    /** 账号类型-对公:1080-1010 */
    String ACC_PUB_PRI_TYPE_CODE_PUB = "1080-1010";

    /** 账号类型-对私:1080-1020 */
    String ACC_PUB_PRI_TYPE_CODE_PRI = "1080-1020";

    /** 账号类型-内部账户:1080-1030 */
    String ACC_PUB_PRI_TYPE_CODE_NB = "1080-1030";

    /** 挂失解挂标志:1090 */
    String LOSS_FLG_CODE = "1090";

    /** 挂失解挂标志-默认标志:1090-1000 */
    String LOSS_FLG_CODE_DEF = "1090-1000";

    /** 挂失解挂标志-口头解挂:1090-1010 */
    String LOSS_FLG_CODE_TAG = "1090-1010";

    /** 挂失解挂标志-书面解挂:1090-1020 */
    String LOSS_FLG_CODE_WRITTEN = "1090-1020";

    /** 挂失解挂标志-口头挂失:1090-1030 */
    String LOSS_FLG_CODE_TAG_LOSS = "1090-1030";

    /** 挂失解挂标志-书面挂失:1090-1040 */
    String LOSS_FLG_CODE_WRITTEN_LOSS = "1090-1040";

    /** ATM状态标志:1100 */
    String ATM_STATUS_CODE = "1100";

    /** ATM状态标志-运行:1100-1010 */
    String ATM_STATUS_CODE_RUN = "1100-1010";

    /** ATM状态标志-停机:1100-1020 */
    String ATM_STATUS_CODE_STOP = "1100-1020";

    /** 账户状态:1102 */
    String ACC_STATUS_CODE = "1102";

    /** 账户状态-正常:1102-1010 */
    String ACC_STATUS_CODE_NATURAL = "1102-1010";

    /** 账户状态-已销户:1102-1020 */
    String ACC_STATUS_CODE_LOGOUT = "1102-1020";

    /** 账户状态-已结转:1102-1030 */
    String ACC_STATUS_CODE_BAL_TRANSFER = "1102-1030";

    /** 账户状态-已移户:1102-1040 */
    String ACC_STATUS_CODE_TRANSFER_LOGOUT = "1102-1040";

    /** 账户状态-已冻结:1102-1050 */
    String ACC_STATUS_CODE_FREEZE = "1102-1050";

    /** 帐户类别:1103 */
    String ACC_STYLE_TYPE_CODE = "1103";

    /** 帐户类别-临时存款户:1103-1010 */
    String ACC_STYLE_TYPE_CODE_TEMP = "1103-1010";

    /** 帐户类别-基本存款户:1103-1020 */
    String ACC_STYLE_TYPE_CODE_BASE = "1103-1020";

    /** 帐户类别-一般存款户:1103-1030 */
    String ACC_STYLE_TYPE_CODE_POP = "1103-1030";

    /** 帐户类别-专用存款户:1103-1040 */
    String ACC_STYLE_TYPE_CODE_APP = "1103-1040";

    /** 帐户类别-单位定期存款户:1103-1050 */
    String ACC_STYLE_TYPE_CODE_TERMLY_SAVE = "1103-1050";

    /** 入账标志：1104 */
    String IN_ACC_FLG_CODE = "1104";

    /** 入账标志-手工记账：1104-1010 */
    String IN_ACC_FLG_CODE_HAND = "1104-1010";

    /** 入账标志-系统记账：1104-1020 */
    String IN_ACC_FLG_CODE_SYSTEM = "1104-1020";

    /** 记账复核标志:1105 */
    String IN_CHECK_FLG_CODE = "1105";

    /** 记账复核标志-记账:1105-1010 */
    String IN_CHECK_FLG_CODE_IN = "1105-1010";

    /** 记账复核标志-复核:1105-1020 */
    String IN_CHECK_FLG_CODE_CHECK = "1105-1020";

    /** 结算日类型:1106 */
    String BALANCE_DAY_STYLE_CODE = "1106";

    /** 结算日类型-日终:1106-1010 */
    String BALANCE_DAY_STYLE_CODE_DAY_END = "1106-1010";

    /** 结算日类型-日终前:1106-1020 */
    String BALANCE_DAY_STYLE_CODE_DAY_END_PRE = "1106-1020";

    /** 结算日类型-1/11/21/31日终:1106-1030 */
    String BALANCE_DAY_STYLE_CODE_DAY_END_ESPECIAL = "1106-1030";

    /** 结算日类型-年终结算日:1106-1040 */
    String BALANCE_DAY_STYLE_CODE_YEAR_END = "1106-1040";

    /** 结算日类型-每季末日终:1106-1050 */
    String BALANCE_DAY_STYLE_CODE_SEASON_END = "1106-1050";

    /**
     * 答复类型 1201
     */
    String REVERT_TYPE = "1201";

    /** 答复类型-接受,更新凭证:1201-1010 */
    String REVERT_TYPE_ACCEPT_CHANGER = "1201-1010";

    /** 答复类型-接受,无需更新凭证:1201-1020 */
    String REVERT_TYPE_ACCEPT_NO_CHANGER = "1201-1020";

    /** 答复类型-拒绝,无需更新凭证:1201-1030 */
    String REVERT_TYPE_REFUSE_NO_CHANGER = "1201-1030";

    /** 答复类型-拒绝,更新凭证:1201-1040 */
    String REVERT_TYPE_REFUSE_CHANGER = "1201-1040";

    /**
     * 业务处理标志
     */
    String SEQ_DEAL_STATUS_YES_OR_NO = "1301";

    /** 业务处理标志-未处理:1301-1301 */
    String SEQ_DEAL_STATUS_NO = "1301-1301";

    /** 业务处理标志-已处理成功:1301-1302 */
    String SEQ_DEAL_STATUS_YES_RIGHT = "1301-1302";

    /** 业务处理标志-已处理失败:1301-1303 */
    String SEQ_DEAL_STATUS_YES_ERR = "1301-1303";

    /**
     * 勾兑标志-1302
     */
    String TX_FLAG = "1302";

    /* 勾兑标志-已勾兑-1302-1300 */
    String TX_FLAG_TRUE = "1302-1300";

    /* 勾兑标志-未勾兑-1302-1301 */
    String TX_FLAG_FALSE = "1302-1301";

    /*
     * 冲正标志-1303
     */
    String CANCEL_FLAG = "1303";

    /* 冲正标志-已冲正 1303-1300 */
    String TRUE_CANCEL_FLAG = "1303-1300";

    /* 冲正标志-未冲正 1303-1301 */
    String FALSE_CANCEL_FLAG = "1303-1301";

    /*
     * 交易判断 1002
     */
    String TRADE_JUDGE = "1002";

    /* 交易判断-经核实符合业务流程 1002-1001 */
    String TRADE_JUDGE_ACCORD_FLOW = "1002-1001";

    /* 交易判断-经核实业务处理正确 1002-1002 */
    String TRADE_JUDGE_RIGHT = "1002-1002";

    /* 交易判断-经核实业务经办资料符合规定 1002-1003 */
    String TRADE_JUDGE_DATUM_RIGHT = "1002-1003";

    /* 交易判断-操作人员错误 1002-1004 */
    String TRADE_JUDGE_OPER_WRONG = "1002-1004";

    /* 交易判断-系统错误 1002-1005 */
    String TRADE_JUDGE_SYS_WRONG = "1002-1005";

    /* 交易判断-已抹账更正 1002-1006 */
    String TRADE_JUDGE_CHANGE_RIGHT = "1002-1006";

    /* 交易判断-已经核实，但是需要客户（对方行）配合更正 1002-1007 */
    String TRADE_JUDGE_NEED_CHECK = "1002-1007";

    /**
     * 交易类型-1003
     */
    String TRADE_CLASS_CODE = "1003";

    /** 交易类型-默认交易种类 1003-1000 */
    String TRADE_CLASS_CODE_DEFAULT = "1003-1000";

    /** 交易类型-红字冲正 1003-1001 */
    String TRADE_CLASS_CODE_HZCZ = "1003-1001";

    /*
     * 状态
     */
    String STATUS = "1004";

    /** 状态-完成 1004-1001 */
    String STATUS_Y = "1004-1001";

    /** 状态-未完成 1004-1002 */
    String STATUS_N = "1004-1002";

    /** 网点签到签退标志 */
    String ORG_LOGON_FLG = "1005";

    /** 网点签到签退标志-网点签到 */
    String ORG_LOGON_FLG_LOGIN = "1005-1001";

    /** 网点签到签退标志-网点签退 */
    String ORG_LOGON_FLG_LOGOUT = "1005-1002";
    
    String TOTAL_BANK = "706640124";
    
    /** 交易预警关系表-是否使用: 是 */
    String ALARM_REL_TRADE_IS_USE_YES = "1";
    
    /** 交易预警关系表-是否使用: 否 */
    String ALARM_REL_TRADE_IS_USE_NO = "0";
    
    /** 任务类型 */
    String TASK_TYPE = "1006";
    
    /** 任务类型：帐户 */
    String TASK_TYPE_ACCOUNT = "1006-1001";
    
    /** 任务类型：勾兑流水 */
    String TASK_TYPE_BLEND = "1006-1002";
    
    /** 任务类型：事后交易 */
    String TASK_TYPE_OFF_TRADE = "1006-1003";
    
    /** 任务类型：网点上午 */
    String TASK_TYPE_ORG_AM = "1006-1004";
    
    /** 任务类型：网点下午 */
    String TASK_TYPE_ORG_PM = "1006-1005";
    
    /** 任务类型：网点通用 */
    String TASK_TYPE_ORG_COMMON = "1006-1006";
    
    /** 任务类型：科目 */
    String TASK_TYPE_SUBJECT = "1006-1007";
}