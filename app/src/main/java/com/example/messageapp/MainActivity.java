package com.example.messageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phone,sms;
    Button button;
    ImageView imageView; //calling feature
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone=findViewById(R.id.editTextTextPersonName);
        sms=findViewById(R.id.editTextTextPersonName2);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView); //calling feature

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phone.getText().toString(), null, sms.getText().toString(), null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent", Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Sending Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //calling feature
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phone.getText().toString().length()==10){
                String dial="tel:"+phone.getText().toString();
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
                else{
                    Toast.makeText(getApplicationContext(), "Enter 10-digit number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}