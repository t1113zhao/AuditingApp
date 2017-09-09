package com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AuditRecord;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 5/27/2017.
 */

public class AuditRecordPostBody {

//    {"budgetid":"","employeeid":"e620695b-7537-46d9-8bef-a09900acabd0","infoid":185830,"pageindex":1,"pagesize":2147483647}
    static final String DEFAULTBUDGETID = "";

    @SerializedName("budgetid")
    public String budgetid;

    @SerializedName("employeeid")
    public String employeeid;

    @SerializedName("infoid")
    public int infoid;

    @SerializedName("pageindex")
    public int pageindex;

    @SerializedName("pagesize")
    public int pagesize;

    public AuditRecordPostBody(String employeeid, int infoid){
        this(DEFAULTBUDGETID, employeeid,infoid,1,Integer.MAX_VALUE);
    }

    public AuditRecordPostBody(String budgetid, String employeeid, int infoid, int pageindex, int pagesize){
        this.budgetid=budgetid;
        this.employeeid=employeeid;
        this.infoid=infoid;
        this.pageindex=pageindex;
        this.pagesize=pagesize;
    }
}
