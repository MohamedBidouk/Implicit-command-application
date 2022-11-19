package com.example.implisit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button call, dial, web, appM, wifi;
    EditText in;
    String input;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, 123);
            }

            call = findViewById(R.id.call);
            dial = findViewById(R.id.dial);
            web = findViewById(R.id.web);
            appM = findViewById(R.id.AppM);
            wifi = findViewById(R.id.wifi);
            in = findViewById(R.id.input);


            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input = in.getText().toString();
                    if(input.isEmpty()){
                        Intent appel = new Intent(Intent.ACTION_CALL, Uri.parse("tel:23483701"));
                        startActivity(appel);
                    }else{
                        Intent appel = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+input));
                        startActivity(appel);
                    }

                }
            });

            dial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input = in.getText().toString();
                    if(input.isEmpty()){
                        Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:23483701"));
                        startActivity(dialPhone);
                    }else{
                        Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+input));
                        startActivity(dialPhone);
                    }

                }
            });

            web.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input = in.getText().toString();
                    if(input.isEmpty()){
                        Intent toWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http:https://www.javatpoint.com"));
                        startActivity(toWeb);
                    }else{
                        Intent toWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http:"+input));
                        startActivity(toWeb);
                    }

                }
            });

            appM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent toAppM = new Intent(Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS);
                    startActivity(toAppM);
                }
            });

            wifi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent toWifiSettings = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    startActivity(toWifiSettings);
                }
            });
    }
}