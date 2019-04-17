package com.jonas.constant;


/**
 * 【功能描述】
 *
 * @author yangjh  21/08/2018.
 */
public class BizException extends RuntimeException {

    private CodeStatus codeStatus;

    private String message;

    public BizException() {
    }

    public BizException(CodeStatus codeStatus, Throwable cause) {
        super(codeStatus.getMessage());
        this.codeStatus = codeStatus;
        this.message = "BizException:" + codeStatus.getCode() + ":" + codeStatus.getMessage();
    }

    public BizException(CodeStatus codeStatus) {
        super("BizException:" + codeStatus.getCode() + ":" + codeStatus.getMessage());
        this.codeStatus = codeStatus;
        this.message = "BizException:" + codeStatus.getCode() + ":" + codeStatus.getMessage();
    }

    public BizException(final String code, final String message) {
        super("BizException:" + code + ":" + message);
        this.codeStatus = new CodeStatus() {
            @Override
            public String getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
        this.message = "BizException:" + code + ":" + message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public CodeStatus getCodeStatus() {
        return codeStatus;
    }
}
