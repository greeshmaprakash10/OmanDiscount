package com.app.omandiscount.SqliteDatabase;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by NyesteVenture3 on 3/30/2018.
 */

public class ApiCalls
{
    public Context context;
    public String jsonResponse;
    public  static ArrayList arrayList3=new ArrayList();

    public ApiCalls(Context context)
    {
        this.context=context;
    }

}


