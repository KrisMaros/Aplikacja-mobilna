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

public class Create2 extends AppCompatActivity {

    Button btn;
    RequestQueue rq;
    EditText productIdText ,priceText, productNameText, quantityText;
    String url = "http://10.0.2.2:8080/AndroidRestfulServer/webresources/web.grocerie2/";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create2);

        //productIdText = (EditText) findViewById(R.id.textProductId);
        priceText = (EditText) findViewById(R.id.textprice);
        productNameText = (EditText) findViewById(R.id.textProductName);
        quantityText = (EditText) findViewById(R.id.textQuantity);

        btn = (Button) findViewById(R.id.postBtn);
        rq = Volley.newRequestQueue(this);

        builder = new AlertDialog.Builder(Create2.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InsertSV();
            }
        });
    }

    public void InsertSV(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplication(),response,Toast.LENGTH_SHORT).show();
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
                Toast.makeText(Create2.this, error+"", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                //String productId = productIdText.getText().toString();
                String price = priceText .getText().toString();
                String productname = productNameText.getText().toString();
                String quantity =  quantityText.getText().toString();

                //params.put("PRODUCTID",productId);
                params.put("productname",productname);
                params.put("quantity",quantity);
                params.put("price",price);

                return params;
            }
        };
        rq.add(stringRequest);
    }
}
