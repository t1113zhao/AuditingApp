package com.example.administrator.financialauditingapp.net;


import com.google.gson.annotations.SerializedName;

/**
 * 封装从服务器获取的json数据，包括code，msg，data信息
 * @param <T>
 */
public class BaseBean<T> {

    @SerializedName("code")
    public String code;

    @SerializedName("msg")
    public String msg;

    @SerializedName("data")
    public T data;
}
