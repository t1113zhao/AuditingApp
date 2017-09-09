package com.example.administrator.financialauditingapp.Desk.AccountsDisplay;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 5/25/2017.
 */

public class AccountsDisplayRequest extends StringRequest{

    /**
     * Default charset for JSON request.
     */
    protected static final String PROTOCOL_CHARSET = "utf-8";

    /**
     * Content type for request.
     */
    private static final String PROTOCOL_CONTENT_TYPE =
            String.format("application/json; charset=%s", PROTOCOL_CHARSET);


    @Override
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    private static final String ACCOUNT_DISPLAY_URL = "http://test9.525j.com.cn/finance/financeapi/v1.0/finance.budget.getpagelist";

    String params;


    public AccountsDisplayRequest(AccountsDisplayPostBody postBody, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, ACCOUNT_DISPLAY_URL, listener, errorListener);
        params = new Gson().toJson(postBody);
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> maps = new HashMap<>();
        maps.put("Authorization", "94408bb23d874ed98da73263eee9499a");
        return maps;
    }

    public byte[] getBody() throws AuthFailureError {
        try {
            return params.getBytes(getParamsEncoding());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
        }
        return null;

    }
}
