package com.newsportal;

/**
 * @author sankalpa on 3/7/21
 */
public class ResponseWrapper {
    private String code;
    private String status;
    private Object payload;

    public ResponseWrapper(String code, String status, Object payload) {
        this.code = code;
        this.status = status;
        this.payload = payload;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public static ResponseWrapper getSuccessResponse(Object payload){
        return new ResponseWrapper(RestConstants.SUCCESS_CODE,RestConstants.SUCCESS_STATUS,payload);
    }
}
