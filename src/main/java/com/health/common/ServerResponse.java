package com.health.common;

//import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServerResponse<T> implements Serializable {

    private int code ;
    private String message;
    private T data;
    private Boolean result;

    public int getCode () {
        return code ;
    }

    public void setCode(int code) {
        this.code  = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }


    public ServerResponse(int code ){
        this.code  = code ;
    }
    public ServerResponse(int code , T data){
        this.code  = code ;
        this.data = data;
    }

    public ServerResponse(int status, String message, T data){
        this.code  = status;
        this.message = message;
        this.data = data;
    }


    public ServerResponse(int code , String message){
        this.code  = code ;
        this.message = message;
    }

    public ServerResponse(String message){
//        this.code  = code ;
        this.message = message;
    }


}
