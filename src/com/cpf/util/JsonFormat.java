package com.cpf.util;

/**
 * Created by jll on 2017/10/27.
 */
public class JsonFormat {
    public String code;
    public String message;
    public Object data;
    public int totalCount;

    public JsonFormat(String code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonFormat(String code, String message,int totalCount, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
        this.totalCount = totalCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
