package com.example.mysx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends Activity {
    int Year;
    int month;
    int day;
    DatePicker datePicker;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker=(DatePicker) findViewById(R.id.datepicker1);
        Year=datePicker.getYear();
        month=datePicker.getMonth();
        day=datePicker.getDayOfMonth();
        datePicker.init(Year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.Year=year;
                MainActivity.this.month=monthOfYear;
                MainActivity.this.day=dayOfMonth;
            }
        });
        submitButton = (Button) findViewById(R.id.reportBtn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ex_tra", Year);
                intent.putExtras(bundle);
//                intent.putExtra("ex_tra",Year);
                startActivity(intent);
            }
        });
    }

}
