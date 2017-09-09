package com.example.administrator.financialauditingapp.Desk;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 5/24/2017.
 */

public class EmployeeBadgeRequest extends StringRequest {

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


//    private static final String BASE_URL = " http://test9.525j.com.cn/common/passportapi/v1.3/passport.employee.getinfo/";
    private String params = "a";

//    030AA052-A05F-46BD-8CAC-3E3F37F6DDB7?employeeid=e620695b-7537-46d9-8bef-a09900acabd0
    public EmployeeBadgeRequest(String EMPLOYEE_AND_CITY_REQUEST_URL , Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.GET, EMPLOYEE_AND_CITY_REQUEST_URL, listener, errorListener);
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
