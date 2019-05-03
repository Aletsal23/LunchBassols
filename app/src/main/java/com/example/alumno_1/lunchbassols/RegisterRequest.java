package com.example.alumno_1.lunchbassols;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL="http://148.204.6.250/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String correo, String password, Response.Listener<String>listener)
    {
        super (Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
    }

}
