package com.jonas.constant;

/**
 * 【 系统状态码 】
 *
 * @author shenjy 2018/08/13
 */
public enum SystemCode implements CodeStatus {

    SUCCESS("2000", "成功"),
    NEED_LOGIN("2001", "未登录"),
    ACCOUNT_ERROR("2002", "账户异常"),
    NEED_AUTH("2003", "权限不足"),
    PARAM_ERROR("2005", "参数异常"),
    SERVER_ERROR("2006", "服务器异常"),
    ;

    private String code;

    private String message;

    SystemCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
