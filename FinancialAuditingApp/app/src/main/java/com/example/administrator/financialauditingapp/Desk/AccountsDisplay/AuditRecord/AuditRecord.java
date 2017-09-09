package com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AuditRecord;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 5/27/2017.
 */

public class AuditRecord {
//    "budgetid":"2f945727-fb88-49bb-807c-d0383d391930",
//            "id":2437,
//            "ip":"101.95.152.246",
//            "operationtime":"2017-5-22 15:39:28",
//            "operationtype":2,
//            "operatorid":"2010979e-63c6-4140-b8d1-a1b900e5f753",
//            "operatorname":"谭印青",
//            "products":null,
//            "remark":"",
//            "state":1},

    @SerializedName("budgetid")
    public String budgetid;

    @SerializedName("id")
    public int id;

    @SerializedName("ip")
    public String ip;

    @SerializedName("operationtime")
    public String operationtime;

    @SerializedName("operationtype")
    public int operationtype;

    @SerializedName("operatorid")
    public String operatorid;

    @SerializedName("operatorname")
    public String operatorname;

    @SerializedName("products")
    public Object products;

    @SerializedName("remark")
    public String remark;

    @SerializedName("state")
    public int state;

}
