package com.example.myapplication;

//import android.app.Activity;
//import android.content.Intent;
//import android.webkit.WebSettings;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button_ratio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,video.class);
                startActivity(intent);
            }
        });

        button_ratio=(Button)findViewById(R.id.button4);
        button_ratio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,ratio.class);
                startActivity(intent);
            }
        });

    }
}
