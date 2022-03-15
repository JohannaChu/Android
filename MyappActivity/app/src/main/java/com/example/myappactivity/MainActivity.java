package com.example.myappactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button button;
    private Button b_end;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView=(WebView)findViewById(R.id.webview);
        button= (Button) findViewById(R.id.button);
        b_end= (Button) findViewById(R.id.b_end);

        button.setOnClickListener(v -> {
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("http://192.168.1.1:8080/");
            WebSettings settings = webView.getSettings();
            settings.setUseWideViewPort(true);//设定支持viewpor
            settings.setLoadWithOverviewMode(true);   //自适应屏幕
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setSupportZoom(true);//设定支持缩放

        });

        b_end.setOnClickListener(v -> {
            webView.stopLoading();
        });


    }}
