package com.example.restaurantlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddressLocator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_locator);


        final EditText e=(EditText)findViewById(R.id.editText);
        Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity2();
                String s=e.getText().toString();
                Toast.makeText(getApplicationContext(),"location: "+s,Toast.LENGTH_SHORT).show();
            }
        });






    }

    public void openactivity2()
    {
        Intent i=new Intent(this,MapsActivity.class);
        startActivity(i);
    }


    }
