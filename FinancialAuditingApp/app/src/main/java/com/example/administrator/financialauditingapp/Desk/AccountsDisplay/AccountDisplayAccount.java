package com.example.administrator.financialauditingapp.Desk.AccountsDisplay;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 5/26/2017.
 */

public class AccountDisplayAccount implements Serializable {

//    {"address":"上海上海虹口区随便自助烤肉,豆捞1203",
//            "auditstate":3,
//            "budgetid":"9cda6f37-73b2-4b4b-a83e-7c9e63f71b9d",
//            "contractstate":-1,
//            "corpid":"",
//            "corpname":"",
//            "designerid":"727B94B8-73A3-486D-B797-F91E377DC4FC",
//            "designername":"签约设计师6",
//            "gender":"女",
//            "infoid":185745,
//            "isauditing":0,
//            "name":"测试tml",
//            "phone":"15252421236",
//            "pkgid":1052,
//            "pkgname":"上海438主材包hss",
//            "pkgtype":"4",
//            "profit":1,
//            "projectpendingreviewstatus":"-1"},

    @SerializedName("address")
    public String address;

    @SerializedName("auditState")
    public int auditState;

    @SerializedName("budgetid")
    public String budgetid;

    @SerializedName("contractstate")
    public int contractstate;

    @SerializedName("corpid")
    public String corpid;

    @SerializedName("corpname")
    public String corpname;

    @SerializedName("designerid")
    public String designerid;

    @SerializedName("designername")
    public String designername;

    @SerializedName("gender")
    public String gender;

    @SerializedName("infoid")
    public int infoid;

    @SerializedName("isauditing")
    public int isauditing;

    @SerializedName("name")
    public String name;

    @SerializedName("phone")
    public String phone;

    @SerializedName("pkgid")
    public int pkgid;

    @SerializedName("profit")
    public int profit;

    @SerializedName("projectpendingreviewstatus")
    public String projectpendingreviewstatus;
}
