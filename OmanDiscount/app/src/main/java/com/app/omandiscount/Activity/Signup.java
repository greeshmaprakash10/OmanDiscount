package com.app.omandiscount.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.omandiscount.R;

import java.util.HashMap;
import java.util.Map;

public class Signup extends Activity
{
    TextView login;
    Button signup;
    EditText signup_username,signup_email,signup_phone,signup_password;
    String username,email,phone,password;
    String url="http://www.omandiscount.com/omandiscount/index.php/api/products/sign_up";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        login=(TextView) findViewById(R.id.tv_login);
        signup=(Button)findViewById(R.id.btn_signup);
        signup_username=(EditText) findViewById(R.id.signup_username);
        signup_email=(EditText)findViewById(R.id.signup_email);
        signup_phone=(EditText)findViewById(R.id.signup_phone);
        signup_password=(EditText)findViewById(R.id.signup_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                username=signup_username.getText().toString();
                email=signup_email.getText().toString();
                phone=signup_phone.getText().toString();
                password=signup_password.getText().toString();

                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {

                    }
                },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(Signup.this, "my error :"+error, Toast.LENGTH_LONG).show();
                        Log.i("My error",""+error);
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String> map = new HashMap<String, String>();
                        map.put("Site_user_name",username);
                        map.put("site_user_email",email);
                        map.put("Site_user_phone",phone);
                        map.put("site_user_password",password);
                        map.put("device_type","");
                        map.put("device_token","");

                        return map;
                    }
                };
                requestQueue.add(request);

                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }
}
