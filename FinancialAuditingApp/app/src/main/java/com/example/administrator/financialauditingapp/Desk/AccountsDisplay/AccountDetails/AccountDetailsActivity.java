package com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AccountDetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AccountDisplayAccount;
import com.example.administrator.financialauditingapp.R;
import com.example.administrator.financialauditingapp.net.BaseBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AccountDetailsActivity extends AppCompatActivity {
    AccountDisplayAccount account;

    final String DETAILURL = "http://test9.525j.com.cn/finance/financeapi/v1.0/finance.budget.detailinfo/";

    String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);


        Intent sentHere = getIntent();
        account = (AccountDisplayAccount)sentHere.getExtras().getSerializable("ACCOUNT_DETAILS");

        URL = DETAILURL + account.budgetid + "";

        getInfo();
    }

    private void getInfo(){
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                BaseBean<AccountDetailsBean> bean = new Gson().fromJson(response,new TypeToken< BaseBean<AccountDetailsBean>>(){}.getType());

                if (bean != null){

                    if ("200".equals(bean.code)){
                        AccountDetailsBean detailsBean = bean.data;

                        String dbn = new Gson().toJson(detailsBean);
                        if(detailsBean!= null){
                            Log.d("VDBEAN",dbn);
                        }
                    }
                    else{
                        Toast.makeText(AccountDetailsActivity.this, ""+ bean.msg, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        AccountDetailsRequest detailsRequest = new AccountDetailsRequest(URL, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(detailsRequest);

    }
}
