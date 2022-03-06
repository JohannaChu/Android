package com.example.chineselocalizations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //string resource from your app's Resources
        String hello = getResources().getString(R.string.hello_world);
        // Or supply a string resource to a method that requires a string
        TextView textView = new TextView(this);
        textView.setText(R.string.hello_world);
    }
}