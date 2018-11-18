package com.example.krzychu_x.restfulpostrequest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class StoreLocation2 extends AppCompatActivity {

    RequestQueue rq;
    TextView priceText, productIDText, productNameText, quantityText;
    String price, productid, productname, quantity;

    TextView priceText1, productIDText1, productNameText1, quantityText1;
    String price1, productid1, productname1, quantity1;

    TextView priceText2, productIDText2, productNameText2, quantityText2;
    String price2, productid2, productname2, quantity2;

    TextView priceText3, productIDText3, productNameText3, quantityText3;
    String price3, productid3, productname3, quantity3;

    TextView priceText4, productIDText4, productNameText4, quantityText4;
    String price4, productid4, productname4, quantity4;

    TextView storeIDText, addressline1Text, addressline2Text, postcodeText;
    String storeID, addressline1, addressline2, postCode;

    String url = "http://10.0.2.2:8080/AndroidRestfulServer/webresources/web.grocerie2/1";
    String url1 = "http://10.0.2.2:8080/AndroidRestfulServer/webresources/web.grocerie2/2";
    String url2 = "http://10.0.2.2:8080/AndroidRestfulServer/webresources/web.store/2";
    String url3 = "http://10.0.2.2:8080/AndroidRestfulServer/webresources/web.grocerie2/3";
    String url4 = "http://10.0.2.2:8080/AndroidRestfulServer/webresources/web.grocerie2/4";
    String url5 = "http://10.0.2.2:8080/AndroidRestfulServer/webresources/web.grocerie2/5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_location_2);

        rq = Volley.newRequestQueue(this);
        addressline1Text = (TextView) findViewById(R.id.address1);
        addressline2Text = (TextView) findViewById(R.id.address2);
        postcodeText = (TextView) findViewById(R.id.postcode);

        priceText = (TextView) findViewById(R.id.price1);
        productIDText = (TextView) findViewById(R.id.id1);
        productNameText = (TextView) findViewById(R.id.product1);
        quantityText = (TextView) findViewById(R.id.qu1);

        priceText1 = (TextView) findViewById(R.id.price2);
        productIDText1 = (TextView) findViewById(R.id.id2);
        productNameText1 = (TextView) findViewById(R.id.product2);
        quantityText1 = (TextView) findViewById(R.id.qu2);

        priceText2 = (TextView) findViewById(R.id.price3);
        productIDText2 = (TextView) findViewById(R.id.id3);
        productNameText2 = (TextView) findViewById(R.id.product3);
        quantityText2 = (TextView) findViewById(R.id.qu3);

        priceText3 = (TextView) findViewById(R.id.price4);
        productIDText3 = (TextView) findViewById(R.id.id4);
        productNameText3 = (TextView) findViewById(R.id.product4);
        quantityText3 = (TextView) findViewById(R.id.qu4);

        priceText4 = (TextView) findViewById(R.id.price5);
        productIDText4 = (TextView) findViewById(R.id.id5);
        productNameText4 = (TextView) findViewById(R.id.product5);
        quantityText4 = (TextView) findViewById(R.id.qu5);

        Button edit = (Button)findViewById(R.id.editBtn);
        Button create = (Button)findViewById(R.id.createBtn);
        Button delete = (Button)findViewById(R.id.deleteBtn);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Edit2.class);
                startActivity(startIntent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Delete2.class);
                startActivity(startIntent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Create2.class);
                startActivity(startIntent);
            }
        });

        getProduct1();
        getProduct2();
        getProduct3();
        getProduct4();
        getProduct5();
        getStore();
    }

    public void getStore(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    addressline1 = response.getString("addressline1");
                    addressline2 = response.getString("addressline2");
                    postCode = response.getString("postcode");


                    addressline1Text.setText(addressline1);
                    addressline2Text.setText(addressline2);
                    postcodeText.setText(postCode);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        rq.add(jsonObjectRequest);
    }

    public void getProduct1(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    price = response.getString("price");
                    productid = response.getString("productid");
                    productname = response.getString("productname");
                    quantity = response.getString("quantity");

                    priceText.setText(price);
                    productIDText.setText(productid);
                    productNameText.setText(productname);
                    quantityText.setText(quantity);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        rq.add(jsonObjectRequest);
    }

    public void getProduct2(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    price1 = response.getString("price");
                    productid1 = response.getString("productid");
                    productname1 = response.getString("productname");
                    quantity1 = response.getString("quantity");

                    priceText1.setText(price1);
                    productIDText1.setText(productid1);
                    productNameText1.setText(productname1);
                    quantityText1.setText(quantity1);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        rq.add(jsonObjectRequest);
    }

    public void getProduct3(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url3, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    price2 = response.getString("price");
                    productid2 = response.getString("productid");
                    productname2 = response.getString("productname");
                    quantity2 = response.getString("quantity");

                    priceText2.setText(price2);
                    productIDText2.setText(productid2);
                    productNameText2.setText(productname2);
                    quantityText2.setText(quantity2);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        rq.add(jsonObjectRequest);
    }

    public void getProduct4(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url4, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    price3 = response.getString("price");
                    productid3 = response.getString("productid");
                    productname3 = response.getString("productname");
                    quantity3 = response.getString("quantity");

                    priceText3.setText(price3);
                    productIDText3.setText(productid3);
                    productNameText3.setText(productname3);
                    quantityText3.setText(quantity3);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        rq.add(jsonObjectRequest);
    }

    public void getProduct5(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url5, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    price4 = response.getString("price");
                    productid4 = response.getString("productid");
                    productname4 = response.getString("productname");
                    quantity4 = response.getString("quantity");

                    priceText4.setText(price4);
                    productIDText4.setText(productid4);
                    productNameText4.setText(productname4);
                    quantityText4.setText(quantity4);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(jsonObjectRequest);
    }

}
