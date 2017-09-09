package com.example.administrator.financialauditingapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.financialauditingapp.Desk.DeskFragment;

import org.json.JSONObject;

public class MainActivity extends FragmentActivity implements  RadioButtonListeners{


    Fragment accountsFragment;
    Fragment profileFragment;
    public Fragment currentFragment;

    RadioButton accountsButton;
    RadioButton profileButton;
    RadioGroup group;
    FragmentContainer container;
    public boolean accreditedLogin=false;
    boolean radioButtonClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Intent sentHere = getIntent();

        accountsButton = (RadioButton) findViewById(R.id.accounts);
        profileButton = (RadioButton) findViewById(R.id.profile);
        group = (RadioGroup) findViewById(R.id.radioGroup);

        JSONObject jsonObject = null;


        setClickListeners();
        accountsButton.setChecked(true);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void setClickListeners() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                int background = Color.argb(255,210,69,61);
                if (currentFragment != null){
                    transaction.hide(currentFragment);
                }
                switch (checkedId){
                    case R.id.accounts:
                        profileFragment = null;
                        if (accountsFragment == null){
                            accountsFragment = new DeskFragment();
                            Bundle args = new Bundle();
                            args.putBoolean("cred",accreditedLogin);
                            accountsFragment.setArguments(args);
                            transaction.add(R.id.container,accountsFragment);
                        } else {
                            transaction.show(accountsFragment);
                        }

                        currentFragment = accountsFragment;

                        accountsButton.setBackgroundColor(background);
                        profileButton.setBackgroundColor(Color.WHITE);
                        break;
                    case R.id.profile:
                        accountsFragment = null;

                        if (profileFragment == null){
                            profileFragment = new profileFragment();
                            transaction.add(R.id.container,profileFragment);
                        } else {
                            transaction.show(profileFragment);
                        }
                        currentFragment = profileFragment;

                        profileButton.setBackgroundColor(background);
                        accountsButton.setBackgroundColor(Color.WHITE);
                        break;
                }
                transaction.commit();
            }
        });
    }
}
