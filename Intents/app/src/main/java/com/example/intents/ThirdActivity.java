package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void backButton(View view) {
        Intent data = new Intent();
        EditText returnMessage = (EditText) findViewById(R.id.editText);
        data.setData(Uri.parse(returnMessage.getText().toString()));
        setResult(RESULT_OK, data);
        finish();
    }
}