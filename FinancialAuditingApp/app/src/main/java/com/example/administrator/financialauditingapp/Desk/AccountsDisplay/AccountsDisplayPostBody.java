package com.example.administrator.financialauditingapp.Desk.AccountsDisplay;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 5/25/2017.
 */

public class AccountsDisplayPostBody {
    static final int DEFAULT_PAGE_SIZE =20;

//    budgetstate":1,"getprofit":1,"profittype":1,"employeeid":"e620695b-7537-46d9-8bef-a09900acabd0","cityid":"","pageindex":1,"pagesize":10,"keyword":""}
    @SerializedName("budgetstate")
    public int budgetstate;

    @SerializedName("getprofit")
    public int getprofit;

    @SerializedName("profittype")
    public int profittype;

    @SerializedName("employeeid")
    public String employeeid;

    @SerializedName("cityid")
    public String cityid;

    @SerializedName("pageindex")
    public int pageindex;

    @SerializedName("pagesize")
    public int pagesize;

    @SerializedName("keyword")
    public String keyword;

    public AccountsDisplayPostBody(int budgetstate, int getprofit, int profittype, String employeeid, String cityid, int pageindex, int pagesize, String keyword){
        this.budgetstate = budgetstate;
        this.getprofit = getprofit;
        this.profittype = profittype;
        this.employeeid = employeeid;
        this.cityid = cityid;
        this.pageindex = pageindex;
        this.pagesize = pagesize;
        this.keyword = keyword;
    }

    public AccountsDisplayPostBody(int setBudgetstate, int setProfittype, String setEmployeeid, int setPageIndex){
        this(setBudgetstate,1,setProfittype,setEmployeeid,"",setPageIndex,DEFAULT_PAGE_SIZE,"");
    }

    public AccountsDisplayPostBody(int setBudgetstate, int setProfittype, String setEmployeeid,int setPageIndex, String setKeyword){
        this(setBudgetstate,1,setProfittype,setEmployeeid,"",setPageIndex,DEFAULT_PAGE_SIZE,setKeyword);
    }


}
