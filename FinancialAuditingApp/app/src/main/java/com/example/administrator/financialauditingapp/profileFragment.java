package com.example.administrator.financialauditingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.financialauditingapp.loginPage.LoginActivity;
import com.example.administrator.financialauditingapp.net.SharedPreferencesUtil;

/**
 * Created by Administrator on 5/17/2017.
 */

public class profileFragment extends Fragment{

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init(){
        TextView settings = (TextView) getView().findViewById(R.id.settingsTV);
        TextView signOut = (TextView) getView().findViewById(R.id.signOutTV);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtil.saveUserLoginState(getContext(),false);
                Intent intent = new Intent(getContext(), LoginActivity.class);
                SharedPreferencesUtil.clearSp(getContext());
                startActivity(intent);
                getActivity().finish();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "WOLO WOLO WOLO", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_profile_fragment,null);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
