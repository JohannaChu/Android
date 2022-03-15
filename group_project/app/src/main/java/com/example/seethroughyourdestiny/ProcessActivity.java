package com.example.seethroughyourdestiny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProcessActivity extends AppCompatActivity {

    Button resultBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        resultBtn = (Button) findViewById(R.id.button6);
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProcessActivity.this,ExchangeActivity.class);
                startActivity(intent);
            }
        });
    }
}