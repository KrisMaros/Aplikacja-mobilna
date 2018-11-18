package com.example.krzychu_x.restfulpostrequest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Edit1 extends AppCompatActivity {

    Button btn;
    RequestQueue rq;
    EditText productIdText ,priceText, productNameText, quantityText;
    String id;
    String url = "http://10.0.2.2:8080/AndroidRestfulServer/webresources/web.grocerie1/";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit1);

        productIdText = (EditText) findViewById(R.id.textProductId1);
        priceText = (EditText) findViewById(R.id.textprice1);
        productNameText = (EditText) findViewById(R.id.textProductName1);
        quantityText = (EditText) findViewById(R.id.textQuantity1);

        btn = (Button) findViewById(R.id.editBtn);
        rq = Volley.newRequestQueue(this);

        builder = new AlertDialog.Builder(Edit1.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = productIdText.getText().toString();
                url = url+id;
                InsertSV();
            }
        });
    }

    public void InsertSV(){
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                builder.setTitle("Server Response");
                builder.setMessage("Response :"+response);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        priceText.setText("");
                        productNameText.setText("");
                        quantityText.setText("");
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Edit1.this, error+"", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                String price = priceText .getText().toString();
                String productname = productNameText.getText().toString();
                String quantity =  quantityText.getText().toString();
                params.put("productname",productname);
                params.put("quantity",quantity);
                params.put("price",price);
                return params;
            }
        };
        rq.add(stringRequest);
    }
}
