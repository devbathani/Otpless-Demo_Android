package com.example.andriod.otplessdemoandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parseOtplessIntent(getIntent());
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button_open_auth_link);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gauge.authlink.me"));
                startActivity(browserIntent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // Get the Intent that started this activity
        parseOtplessIntent(intent);
    }

    private void parseOtplessIntent(Intent intent){
        // Checking intent contains value and otpless intent only
        if (intent != null && intent.getData() != null && intent.getData().getHost().contains("otpless")){
            Uri redirectUri = intent.getData();
            Log.d("url",redirectUri.toString());
            String urlString = redirectUri.toString();
            String waId = redirectUri.getQueryParameter("waId");
            Log.d("waId", waId);
        }
    }


}