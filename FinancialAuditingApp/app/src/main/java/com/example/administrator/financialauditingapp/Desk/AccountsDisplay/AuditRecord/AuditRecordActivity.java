package com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AuditRecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AccountAuditAdapter;
import com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AccountDisplayAccount;
import com.example.administrator.financialauditingapp.Desk.AccountsDisplay.PageBean;
import com.example.administrator.financialauditingapp.R;
import com.example.administrator.financialauditingapp.net.BaseBean;
import com.example.administrator.financialauditingapp.net.EmployeeBean;
import com.example.administrator.financialauditingapp.net.SharedPreferencesUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import static com.example.administrator.financialauditingapp.R.id.accountsDisplay;

public class AuditRecordActivity extends AppCompatActivity {
    AccountDisplayAccount account;
    List<AuditRecord> recordList;
    RecyclerView auditList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_audit_record);

        Intent sentHere = getIntent();
        account = (AccountDisplayAccount)sentHere.getExtras().getSerializable("AUDIT_RECORD");

        grabInfo();
    }

    private void grabInfo() {
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                BaseBean<PageBean<AuditRecord>> bean = new Gson().fromJson(response,new TypeToken< BaseBean<PageBean<AuditRecord>>>(){}.getType());

                if (bean != null){

                    if ("200".equals(bean.code)){
                        PageBean pageBean = bean.data;

                        String pgbn = new Gson().toJson(pageBean);
                        if(pageBean!= null){
                            Log.d("VARBEAN",pgbn);
                            recordList = pageBean.pagedata;

                            paginate();
                        }
                    }
                    else{
                        Toast.makeText(AuditRecordActivity.this, ""+ bean.msg, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

//        String employeeID;
        EmployeeBean employeeBean=new Gson().fromJson(SharedPreferencesUtil.getJsonString(this, SharedPreferencesUtil.EMPLOYEE_INFO),EmployeeBean.class);
//        employeeID = employeeBean.id;

        AuditRecordPostBody postBody = new AuditRecordPostBody(employeeBean.id,account.infoid);

        AuditRecordRequest recordRequest = new AuditRecordRequest(postBody, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(recordRequest);

    }

    private void paginate() {
        auditList = (RecyclerView) findViewById(R.id.aRAuditInfo);
        auditList.setAdapter(new AuditRecordAdapter(this, recordList));
        auditList.setLayoutManager(new LinearLayoutManager(this));
    }


}
