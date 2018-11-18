package com.example.krzychu_x.restfulpostrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Delete2 extends AppCompatActivity {

    EditText idText;
    String id;
    String url = "http://10.0.2.2:8080/AndroidRestfulServer/webresources/web.grocerie2/";
    RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete2);

        rq = Volley.newRequestQueue(this);
        Button delBtn = (Button) findViewById(R.id.delBtn);
        idText = (EditText) findViewById(R.id.delID);


        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = idText.getText().toString();
                url = url+id;
                DeleteSV();
            }
        });
    }

    public void DeleteSV(){
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplication(),response,Toast.LENGTH_SHORT).show();
                Log.i("LOG_VOLLEY", response);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(Delete1.this, error+"", Toast.LENGTH_SHORT).show();
                Log.i("LOG_VOLLEY", error.toString());
            }
        }){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String responseString= "";
                if(response != null){
                    responseString = String.valueOf(response.statusCode);
                }

                return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
            }
        };
        rq.add(stringRequest);
    }
}
