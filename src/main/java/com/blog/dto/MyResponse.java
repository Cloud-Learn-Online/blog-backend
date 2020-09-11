package com.blog.dto;

import java.util.Date;

public class MyResponse<T> {
    public Date timeStmamp;
    public String status;
    public T data;

    public MyResponse(Date timeStmamp, String status, T data) {
        this.timeStmamp = timeStmamp;
        this.status = status;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Responce [timeStmamp=" + timeStmamp + ", status=" + status + ", data=" + data + "]";
    }
}
