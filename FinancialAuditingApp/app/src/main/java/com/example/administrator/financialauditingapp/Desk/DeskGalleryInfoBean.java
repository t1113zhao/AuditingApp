package com.example.administrator.financialauditingapp.Desk;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 5/24/2017.
 */

public class DeskGalleryInfoBean {
//    {"code":"200","msg":"获取预算单统计信息成功","data":{"nocount":"0","waitcountless":0,"waitcountmore":0,"yescount":"0"}}

    @SerializedName("nocount")
    public String nocount;

    @SerializedName("waitcountless")
    public String waitcountless;

    @SerializedName("waitcountmore")
    public String waitcountmore;

    @SerializedName("yescount")
    public String yescount;
}
