package com.example.administrator.financialauditingapp.loginPage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.administrator.financialauditingapp.MainActivity;
import com.example.administrator.financialauditingapp.R;
import com.example.administrator.financialauditingapp.net.BaseBean;
import com.example.administrator.financialauditingapp.net.EmployeeBean;
import com.example.administrator.financialauditingapp.net.SharedPreferencesUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Set;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends FragmentActivity implements View.OnClickListener {

    /**
     * Id to identity READ_CONTACTS permission request.
     */

    private AutoCompleteTextView userNameView;
    private EditText passwordView;

    Button signInButton;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean loggedIn = SharedPreferencesUtil.getUserLoginState(this);
        if(loggedIn)
            openMainActivity();
        else
            initView();
    }

    private void initView() {
        setContentView(R.layout.activity_login);
        userNameView = (AutoCompleteTextView) findViewById(R.id.username);
        passwordView = (EditText) findViewById(R.id.password);
        passwordView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (inputMethodManager.isActive()) {
                        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
                    }
                    return true;
                }
                return false;
            }
        });

        signInButton = (Button) findViewById(R.id.SIGN_IN_BUTTON);
        signInButton.setOnClickListener(this);
    }

    private void checkLoginStrings() {
        String usernameString = userNameView.getText().toString().trim();
        String passwordString = passwordView.getText().toString().trim();

        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                BaseBean<EmployeeBean> resulte=new Gson().fromJson(response,new TypeToken< BaseBean<EmployeeBean>>(){}.getType());

                if (resulte != null ){
                    if("200" .equals(resulte.code)){
                        EmployeeBean employeeBean = resulte.data;

                        if (employeeBean != null){
                            boolean saveSuccess = SharedPreferencesUtil.saveInSharedPreferences(getApplicationContext(),employeeBean,SharedPreferencesUtil.EMPLOYEE_INFO);
                            SharedPreferencesUtil.saveUserLoginState(getApplicationContext(),true);

                            if (saveSuccess){
                                openMainActivity();
                            }
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, ""+ resulte.msg, Toast.LENGTH_SHORT).show();
                    }
                }

                Log.d("LOGIN Response", response);
                Log.d("LOGIN Response", resulte.data.id);
                SharedPreferences.Editor editor = new SharedPreferences.Editor() {
                    @Override
                    public SharedPreferences.Editor putString(String key, @Nullable String value) {
                        return null;
                    }

                    @Override
                    public SharedPreferences.Editor putStringSet(String key, @Nullable Set<String> values) {
                        return null;
                    }

                    @Override
                    public SharedPreferences.Editor putInt(String key, int value) {
                        return null;
                    }

                    @Override
                    public SharedPreferences.Editor putLong(String key, long value) {
                        return null;
                    }

                    @Override
                    public SharedPreferences.Editor putFloat(String key, float value) {
                        return null;
                    }

                    @Override
                    public SharedPreferences.Editor putBoolean(String key, boolean value) {
                        return null;
                    }

                    @Override
                    public SharedPreferences.Editor remove(String key) {
                        return null;
                    }

                    @Override
                    public SharedPreferences.Editor clear() {
                        return null;
                    }

                    @Override
                    public boolean commit() {
                        return false;
                    }

                    @Override
                    public void apply() {

                    }
                };

//                JSONObject jsonObject = null;
//                try {
//                     jsonObject = new JSONObject(response);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    boolean success = jsonObject.getBoolean("success");
//
//                    if (success) {
//                        boolean authorized = jsonObject.getBoolean("authorized");
//
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        intent.putExtra("AUTHORIZATION", authorized);
//
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(LoginActivity.this, "FAILURE TO ACCESS SERVER", Toast.LENGTH_SHORT).show();
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }
        };

        LoginRequest loginRequest = new LoginRequest(new LoginPostBody(usernameString, passwordString), listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("LOGIN Response", error.getMessage());
                error.printStackTrace();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        queue.add(loginRequest);
    }
    private void openMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SIGN_IN_BUTTON:
                checkLoginStrings();
                break;
        }
    }

}
