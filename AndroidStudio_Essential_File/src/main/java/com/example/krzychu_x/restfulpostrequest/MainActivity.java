package com.example.krzychu_x.restfulpostrequest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button location1 = (Button)findViewById(R.id.location1);
        Button location2 = (Button)findViewById(R.id.location2);
        Button location3 = (Button)findViewById(R.id.location3);

       location1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent(getApplicationContext(), StoreLocation1.class);
                startActivity(startIntent);
            }
        });

        location2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent(getApplicationContext(), StoreLocation2.class);
                startActivity(startIntent);
            }
        });

        location3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent(getApplicationContext(), StoreLocation3.class);
                startActivity(startIntent);
            }
        });
    }


}
