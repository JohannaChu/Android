package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class video extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //获取视频
        WebView webView=(WebView)findViewById(R.id.webview);  //获得WebView组件
        webView.getSettings().setJavaScriptEnabled(true);  ////设置WebView是否允许执行JavaScript脚本，默认ture，允许
        webView.setWebViewClient(new WebViewClient());  //设置是否在WebView中处理url请求，若不重新，默认会调用浏览器打开
        webView.loadUrl("http://192.168.1.1:8080");  //加载指定的Url
        WebSettings webSettings = webView.getSettings();

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件;若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(true);  //设置是否显示缩放按钮
        //设置自适应屏幕宽度
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(video.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
