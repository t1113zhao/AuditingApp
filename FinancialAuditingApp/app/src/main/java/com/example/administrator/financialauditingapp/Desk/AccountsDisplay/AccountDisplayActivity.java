package com.example.administrator.financialauditingapp.Desk.AccountsDisplay;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.administrator.financialauditingapp.R;
import com.example.administrator.financialauditingapp.RadioButtonListeners;
import com.example.administrator.financialauditingapp.net.BaseBean;
import com.example.administrator.financialauditingapp.net.EmployeeBean;
import com.example.administrator.financialauditingapp.net.SharedPreferencesUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Administrator on 5/25/2017.
 */

public class AccountDisplayActivity extends AppCompatActivity implements  View.OnClickListener, RadioButtonListeners, RadioGroup.OnCheckedChangeListener{

    RadioGroup rgTop;
    RadioGroup rgBottom;
    RadioButton rbTopLeft;
    RadioButton rbTopCenter;
    RadioButton rbTopRight;
    RadioButton rbBottomRight;
    RadioButton rbBottomLeft;

    ImageView back;
    ImageView search;

    EmployeeBean bean;
    int mBudgetState;
    int mProfitType;
    List<AccountDisplayAccount> accountDisplayAccountList;

    RecyclerView accountsDisplay;

    final int DEFAULT_SETTINGS = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_display);

        mBudgetState = DEFAULT_SETTINGS;
        mProfitType = DEFAULT_SETTINGS;


        setIds();
        setClickListeners();
        bean=new Gson().fromJson(SharedPreferencesUtil.getJsonString(this, SharedPreferencesUtil.EMPLOYEE_INFO),EmployeeBean.class);

        setDefaultRadioButtons();

    }

    private void setDefaultRadioButtons(){
        rbTopLeft.setChecked(true);
        rbBottomLeft.setChecked(true);
    }

    private void setIds(){
        rgTop = (RadioGroup) findViewById(R.id.rgTop);
        rgBottom = (RadioGroup) findViewById(R.id.rgBottom);

        rbTopLeft =(RadioButton) findViewById(R.id.rbTopLeft);
        rbTopCenter =(RadioButton) findViewById(R.id.rbTopCenter);
        rbTopRight =(RadioButton) findViewById(R.id.rbTopRight);

        rbBottomLeft =(RadioButton) findViewById(R.id.rbBottomLeft);
        rbBottomRight =(RadioButton) findViewById(R.id.rbBottomRight);

        back = (ImageView) findViewById(R.id.iVTopBack);
        search = (ImageView) findViewById(R.id.iVSearch);


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iVTopBack:
                back();
                break;
            case R.id.iVSearch:
                search();
                break;
        }
    }

    private void back(){
        finish();
    }

    private void search(){
        Toast.makeText(this, "this button doesnt do anything yet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setClickListeners() {
        rgTop.setOnCheckedChangeListener(this);
        rgBottom .setOnCheckedChangeListener(this);
        back.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        int background = Color.argb(255,210,69,61);
        switch (checkedId){
            case R.id.rbTopLeft:
                mBudgetState =1;
                rbTopLeft.setBackgroundColor(background);
                rbTopCenter.setBackgroundColor(Color.WHITE);
                rbTopRight.setBackgroundColor(Color.WHITE);
                break;
            case R.id.rbTopCenter:
                mBudgetState =2;
                rbTopLeft.setBackgroundColor(Color.WHITE);
                rbTopCenter.setBackgroundColor(background);
                rbTopRight.setBackgroundColor(Color.WHITE);
                break;
            case R.id.rbTopRight:
                mBudgetState =3;
                rbTopLeft.setBackgroundColor(Color.WHITE);
                rbTopCenter.setBackgroundColor(Color.WHITE);
                rbTopRight.setBackgroundColor(background);
                break;
            case R.id.rbBottomLeft:
                mProfitType =1;
                rbBottomLeft.setBackgroundColor(background);
                rbBottomRight.setBackgroundColor(Color.WHITE);
                break;
            case R.id.rbBottomRight:
                mProfitType = 0;
                rbBottomLeft.setBackgroundColor(Color.WHITE);
                rbBottomRight.setBackgroundColor(background);
                break;
        }

        refreshListings(mBudgetState,mProfitType,1);
    }

    final String URL = "http://test9.525j.com.cn/finance/financeapi/v1.0/finance.budget.getpagelist";

    private void refreshListings (int budgetState, int profitType, int pageIndex){
        refreshListings(budgetState,profitType,pageIndex,"");
    }

    public void refreshListings (int budgetState, int profitType, int pageIndex, String keyword){
        AccountsDisplayPostBody postBody = new AccountsDisplayPostBody(budgetState,profitType,bean.id,pageIndex,keyword);

        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                BaseBean<PageBean<AccountDisplayAccount>> pageBeanBaseBean=new Gson().fromJson(response,new TypeToken< BaseBean<PageBean<AccountDisplayAccount>>>(){}.getType());
                String pgbnbn = new Gson().toJson(pageBeanBaseBean);
//                Log.d("HTTP REQUEST PGBNBN", pgbnbn);
                if (pageBeanBaseBean != null){
                    if ("200".equals(pageBeanBaseBean.code)){
                        PageBean pageBean = pageBeanBaseBean.data;

                        String pgbn = new Gson().toJson(pageBean);
//                        Log.d("HTTP REQUEST PGBN", pgbn);
                        if (pageBean!= null){

//                            Log.d("HTTP REQUEST STAT", "EMPTY LIST");
                            accountDisplayAccountList =  pageBean.pagedata;
//                            String meme = accountDisplayAccountList.get(0)
//                            for(Object obj: accountDisplayAccountList){
//
//                            }
                            repaginate();
                        }

                    }
                    else {
                        Toast.makeText(AccountDisplayActivity.this, ""+ pageBeanBaseBean.msg, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        AccountsDisplayRequest displayRequest = new AccountsDisplayRequest(postBody, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(AccountDisplayActivity.this);
        queue.add(displayRequest);
//        Log.d("ACCOUNTS",postBody.toString());

    }

    private void repaginate() {

        Log.d("ACCOUNTS", "will it paginaten   "+ mBudgetState + ":"+ mProfitType);
        accountsDisplay =(RecyclerView) findViewById(R.id.accountsDisplay);
        accountsDisplay.setAdapter(new AccountAuditAdapter(this, accountDisplayAccountList));
        accountsDisplay.setLayoutManager(new LinearLayoutManager(this));
    }
}



