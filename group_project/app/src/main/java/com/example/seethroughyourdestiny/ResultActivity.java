package com.example.seethroughyourdestiny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        backBtn = (Button) findViewById(R.id.button7);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        double result1 = Double.parseDouble(bundle.getString("result1"));
        double result2 = Double.parseDouble(bundle.getString("result2"));
        double result3 = Double.parseDouble(bundle.getString("result3"));
        double result4 = Double.parseDouble(bundle.getString("result4"));
        double result = result1+result2+result3+result4;
        TextView vresult = (TextView) findViewById(R.id.textView2);
        vresult.setText("result about " + result);
    }
}