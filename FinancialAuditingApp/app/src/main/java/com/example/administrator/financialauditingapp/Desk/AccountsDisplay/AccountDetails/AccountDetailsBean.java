package com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AccountDetails;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 5/27/2017.
 */

public class AccountDetailsBean {
//    {"code":"200","msg":"获取查看审核明细信息成功

//        "address":"上海上海宝山区h",


    @SerializedName("address")
    public String address;
//                "budgetid":"2f945727-fb88-49bb-807c-d0383d391930",
    /**{"code":"200","msg":"获取查看审核明细信息成功",
     * "data":{
     * "address":"上海上海宝山区h",
     * "budgetid":"0a2a5a19-a7ee-476a-9c8d-2f2aabe76f7a",
     * "budgetmoney":
     * {"grossmargin":"0.2780",
     * "laborcostincreasemoney":"0.0000",
     * "laborcostmoney":"14700.0000",
     * "logisticsmoney":"1217.7300",
     * "lovehomemoney":"13649.9700",
     * "materialincreasemoney":"165.0000",
     * "materialmoney":"12177.3000",
     * "profitmargins":"0.55",
     * "substationmoney":"7350.0000",
     * "totalmoney":"49095.0000"},
     *
     * "budgetremark":"12345678910",
     * "buildingarea":"70.00",
     * "cityname":"上海",
     * "corproom":"1房1厅1厨1卫0阳台",
     * "housearea":"10.00",
     * "infoid":185690,
     * "isauditing":0,
     * "isvalid":false,
     * "m2price":699,
     * "materialadd":0,
     * "memo":null,
     * "name":"中转仓验收测试",
     * "pgname":"全国平台家装套餐 666元\/㎡(老)",
     * "price":0,
     * "profitmargins":"0.55",
     * "projectadd":0,
     * "recordstate":null,
     * "statistics":
     * {"bommoney":null,
     * "budgetid":"0a2a5a19-a7ee-476a-9c8d-2f2aabe76f7a",
     * "packagemoney":48930,
     * "selectedcounts":13,
     * "totaladdmoney":0,
     * "totalincreasemoney":165,
     * "totallaborcostincreasemoney":0,"totalmaterialcounts":13,"totalmaterialincreasemoney":165,"totalmoney":49095},"type":"0","valuationtype":null,"verno":0,"yangtaiarea":null}}
     * */

    @SerializedName("budgetid")
    public String budgetid;

    @SerializedName("budgetmoney")
    public budgetMoneyBean budgetmoney;

    public class budgetMoneyBean{
        @SerializedName("grossmargin")
        public double grossmargin;

        @SerializedName("laborcostincreasemoney")
        public double laborcostincreasemoney;

        @SerializedName("laborcostmoney")
        public double laborcostmoney;

        @SerializedName("logisticsmoney")
        public double logisticsmoney;

        @SerializedName("lovehomemoney")
        public double lovehomemoney;

        @SerializedName("materialincreasemoney")
        public double materialincreasemoney;

        @SerializedName("materialmoney")
        public double materialmoney;

        @SerializedName("profitmargins")
        public double profitmargins;

        @SerializedName("substationmoney")
        public double substationmoney;

        @SerializedName("totalmoney")
        public double totalmoney;
    }

    @SerializedName("budgetremark")
    public String budgetremark;

    @SerializedName("buildingarea")
    public double buildingarea;

    @SerializedName("cityname")
    public String cityname;

    @SerializedName("corproom")
    public String corproom;

    @SerializedName("housearea")
    public double housearea;

    @SerializedName("infoid")
    public int infoid;

    @SerializedName("isauditing")
    public int isauditing;

    @SerializedName("isvalid")
    public boolean isvalid;

    @SerializedName("m2price")
    public double m2price;

    @SerializedName("materialadd")
    public int materialadd;

    @SerializedName("memo")
    public int memo;

    @SerializedName("name")
    public String name;

    @SerializedName("pgname")
    public String pgname;

    @SerializedName("price")
    public double price;

    @SerializedName("profitmargins")
    public double profitmargins;

    @SerializedName("projectadd")
    public int projectadd;

    @SerializedName("recordstate")
    public String recordstate;

    @SerializedName("statistics")
    public statisticsBean statistics;

    public class statisticsBean {
        @SerializedName("bommoney")
        public Object bommoney;

        @SerializedName("budgetid")
        public String budgetid;

        @SerializedName("packagemoney")
        public double packagemoney;

        @SerializedName("selectedcounts")
        public int selectedcounts;

        @SerializedName("totaladdmoney")
        public double totaladdmoney;

        @SerializedName("totalincreasemoney")
        public double totalincreasemoney;

        @SerializedName("totallaborcostincreasemoney")
        public double totallaborcostincreasemoney;

        @SerializedName("totalmaterialcounts")
        public double totalmaterialcounts;

        @SerializedName("totalmaterialincreasemoney")
        public double totalmaterialincreasemoney;

        @SerializedName("totalmoney")
        public double totalmoney;
    }

    @SerializedName("type")
    public String type;

    @SerializedName("valuationtype")
    public String valuationtype;

    @SerializedName("verno")
    public int verno;

    @SerializedName("yangtaiarea")
    public double yangtaiarea;
//                "statistics":
//        {"bommoney":null,
//                "budgetid":"2f945727-fb88-49bb-807c-d0383d391930",
//                "packagemoney":81552,
//                "selectedcounts":7,
//                "totaladdmoney":0,
//                "totalincreasemoney":893,
//                "totallaborcostincreasemoney":0,
//                "totalmaterialcounts":13,
//                "totalmaterialincreasemoney":893,
//                "totalmoney":82445},
//
//        "type":"0",
//                "valuationtype":null,
//                "verno":0,
//                "yangtaiarea":"20.00"}}

}
