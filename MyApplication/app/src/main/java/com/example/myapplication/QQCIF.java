package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;

import android.app.Activity;
import android.util.Log;


public class QQCIF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqcif);
        WebView webView=(WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://192.168.1.1");
        WebSettings webSettings = webView.getSettings();

    }
    private Socket socket;

    /**
     * 建立服务端连接
     */
    public void conn(View v) {
        //实例化后进行新建立运行状态
        new Thread() {

            @Override
            public void run() {  //线程运行时所执行的代码

                try {  //捕捉异常，使得程序出现异常不会立即跳出程序，可以经过处理后让程序继续运行或者跳出
                    socket = new Socket("192.168.1.100", 8080);
                    Log.e("JAVA", "建立连接：" + socket);   //使用java代码把显示错误的东西写入日记
                } catch (UnknownHostException e) {
                    e.printStackTrace();   //DNS异常，解析不了网址
                } catch (IOException e) {
                    e.printStackTrace();  //输入输出异常
                }
            }
        }.start();
    }

    /**
     * 发送消息
     */
    public void send(View v) {
        new Thread() {
            @Override
            public void run() {

                try {
                    // socket.getInputStream()：得到一个输入流，从服务器端发回的数据
                    // socket.getOutputStream():得到一个输出流，发送给服务器端的数据
                    DataOutputStream writer = new DataOutputStream(socket.getOutputStream());  //得到请求的输出流对象
                    writer.writeUTF("QQCIF"); // 写一个UTF-8的信息

                    System.out.println("发送消息");  //输出字符串
                } catch (IOException e) {
                    e.printStackTrace();  //输出输入异常
                }
            }
        }.start();
    }

}



