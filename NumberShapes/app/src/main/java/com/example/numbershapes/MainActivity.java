package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    Button button;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.usersNumber);
        text = (TextView) findViewById(R.id.result);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberString = edit.getText().toString();
                if(numberString.length() == 0){
                    text.setText("Please enter a number in the above text field.");
                }
                else{
                    Number number = new Number(Integer.parseInt(numberString));
                    if(number.isSquare()){
                        if(number.isTriangular()){
                            text.setText(numberString + " is both triangular and square");
                        }
                        else{
                            text.setText(numberString + " is square, but not triangular");
                        }
                    }
                    else{
                        if(number.isTriangular()){
                            text.setText(numberString + " is triangular, but not square");
                        }
                        else{
                            text.setText(numberString + " either a triangular nor a square");
                        }
                    }
                }
            }

        });
    }
}