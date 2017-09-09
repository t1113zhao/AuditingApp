package com.example.administrator.financialauditingapp.loginPage;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 5/23/2017.
 */

public class LoginPostBody {
    /**
     *
     {"loginname":"qianlt","password":"1111","logintype":0,"source":"android"}
     */
    @SerializedName("loginname")
    public String loginname;

    @SerializedName("password")
    public String password;

    @SerializedName("logintype")
    public int logintype=0;

    @SerializedName("source")
    public String source="android";

    public LoginPostBody(String loginname, String password) {
        this.loginname = loginname;
        this.password = password;
    }
}
