package com.example.alumno_1.lunchbassols;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://148.204.6.250/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String nombre, int boleta, String correo, String password, String direccion, int telefono,   Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("nombre", nombre);
        params.put("boleta", boleta + "");
        params.put("correo", correo);
        params.put("direccion", direccion);
        params.put("telefono", telefono + "");
    }

    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}
