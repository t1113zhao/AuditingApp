package com.example.administrator.financialauditingapp;
import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Administrator on 5/17/2017.
 */

public class accountsFragment extends Fragment {
    boolean accreditedLogin;
    LinearLayout hide;

    private TextView dateTV;

    private String date;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        accreditedLogin = args.getBoolean("cred",false);

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
        String date = sdf.format(Calendar.getInstance().getTime());
        dateTV = (TextView) getView().findViewById(R.id.dateTV);
        dateTV.setText(date);
        hide = (LinearLayout) getView().findViewById(R.id.hidable);

        hide.setVisibility(View.VISIBLE);
        if(!accreditedLogin)
            hide.setVisibility(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
