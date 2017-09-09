package com.example.administrator.financialauditingapp.Desk.AccountsDisplay;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 5/26/2017.
 */

public class PageBean<T> {

    @SerializedName("currentpageindex")
    public int currentpageindex;

    @SerializedName("endrecordindex")
    public int endrecordindex;

    @SerializedName("hasnextpage")
    public boolean hasnextpage;

    @SerializedName("haspreviouspage")
    public boolean haspreviouspage;

    @SerializedName("pagesize")
    public int pagesize;

    @SerializedName("startrecordindex")
    public int startrecordindex;

    @SerializedName("totalitemcount")
    public int totalitemcount;

    @SerializedName("totalpagecount")
    public int totalpagecount;

    @SerializedName("pagedata")
    public List<T> pagedata;

}
