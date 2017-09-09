package com.example.administrator.financialauditingapp.Desk;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 5/23/2017.
 */

public class DeskGalleryRequest extends StringRequest {

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


    private static final String ACCOUNT_REQUEST_URL = " http://test9.525j.com.cn/finance/financeapi/v1.0/finance.budget.counttoday/e620695b-7537-46d9-8bef-a09900acabd0";
    private String params = "a";

    public DeskGalleryRequest(Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.GET, ACCOUNT_REQUEST_URL, listener, errorListener);
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
