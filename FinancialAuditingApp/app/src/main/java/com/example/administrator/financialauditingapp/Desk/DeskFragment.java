package com.example.administrator.financialauditingapp.Desk;
import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.administrator.financialauditingapp.R;
import com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AccountDisplayActivity;
import com.example.administrator.financialauditingapp.net.BaseBean;
import com.example.administrator.financialauditingapp.net.EmployeeBean;
import com.example.administrator.financialauditingapp.net.SharedPreferencesUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Administrator on 5/17/2017.
 */

public class DeskFragment extends Fragment {
    LinearLayout hide;
    LinearLayout deskTextViewGallery;


    private TextView dateTV;

    private String date;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String cityStr = SharedPreferencesUtil.getJsonString(getContext(), "cur-City");

        return inflater.inflate(R.layout.layout_account_fragment,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

    }

    @TargetApi(Build.VERSION_CODES.N)
    private void init() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        final String date = sdf.format(Calendar.getInstance().getTime());
        dateTV = (TextView) getView().findViewById(R.id.dateTV);
        dateTV.setText(date);
        hide = (LinearLayout) getView().findViewById(R.id.hidable);
        deskTextViewGallery = (LinearLayout) getView().findViewById(R.id.deskTextViewGallery);

        String employeeID;
        EmployeeBean bean=new Gson().fromJson(SharedPreferencesUtil.getJsonString(getContext(), SharedPreferencesUtil.EMPLOYEE_INFO),EmployeeBean.class);
        employeeID = bean.id;

        String budgetURL = "http://test9.525j.com.cn/finance/financeapi/v1.0/finance.budget.counttoday/";

        budgetURL = budgetURL + employeeID;

        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                BaseBean<DeskGalleryInfoBean> deskInfo =new Gson().fromJson(response,new TypeToken< BaseBean<DeskGalleryInfoBean>>(){}.getType());
                final ArrayList<String> topTextGalleryString = new ArrayList<>();
                if (deskInfo != null ){
                    if("200" .equals(deskInfo.code)){
                        DeskGalleryInfoBean deskGalleryInfoBean = deskInfo.data;
                        topTextGalleryString.add(deskGalleryInfoBean.waitcountless);
                        topTextGalleryString.add(deskGalleryInfoBean.waitcountmore);
                        topTextGalleryString.add(deskGalleryInfoBean.nocount);
                        topTextGalleryString.add(deskGalleryInfoBean.yescount);
                        if (deskGalleryInfoBean != null){
                            for (int i =0; i<topTextGalleryString.size();i++){
                                ((DeskTextView) deskTextViewGallery.getChildAt(i)).topTextView.setText(topTextGalleryString.get(i));
                            }

                        }
                    } else {
                        Toast.makeText(getContext(), ""+ deskInfo.msg, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        };

        DeskGalleryRequest deskGalleryRequest = new DeskGalleryRequest(listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(deskGalleryRequest);

        String cityID =bean.responsiblecity.get(0).cityid;

        Response.Listener<String> employeeListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                BaseBean<EmployeeBean> employeeInfoBean = new Gson().fromJson(response,new TypeToken< BaseBean<EmployeeBean>>(){}.getType());
                if (employeeInfoBean != null ){
                    if("200" .equals(employeeInfoBean.code)){
                        EmployeeBean employeeBean = employeeInfoBean.data;
                        if(employeeBean.menus != null){
                            EmployeeBean.MenusBean menusBean = employeeBean.menus.get(0);

                            int groupID = menusBean.groupid;
                            if (groupID==0)
                                hide.setVisibility(View.VISIBLE);
                            else
                                hide.setVisibility(View.GONE);
                        }
                    }
                }

            }
        };

        String employeeCityRequestURL = EmployeeGetInfoURL + cityID+"?employeeid="+employeeID;

        EmployeeBadgeRequest badgeRequest = new EmployeeBadgeRequest(employeeCityRequestURL, employeeListener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(badgeRequest);

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AccountDisplayActivity.class);
//                Toast.makeText(getContext(), "WOLOLOLOLOLO", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    private static final String EmployeeGetInfoURL = " http://test9.525j.com.cn/common/passportapi/v1.3/passport.employee.getinfo/";

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
