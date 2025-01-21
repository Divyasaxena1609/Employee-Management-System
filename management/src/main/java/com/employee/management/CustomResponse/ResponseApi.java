package com.employee.management.CustomResponse;

public class ResponseApi<T> {
    private String message;
    private T data;

    public ResponseApi(String message , T data){
        this.message = message;
        this.data = data;
    }

    public String getmessage(){
        return message;
    }

    public void setmessage(String message){
        this.message = message;
    }

    public T getdata(){
        return data;
    }

    public void setdata(T data){
        this.data = data;
    }
}
 
