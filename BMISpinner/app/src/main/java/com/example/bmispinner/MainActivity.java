package com.example.bmispinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText vWeight;
    Button submitButton;
    ImageView mImageView;
    String[] feetArray, inchesArray;
    int feet, inches;
    Spinner spinnerFeet, spinnerInches;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vWeight = (EditText) findViewById(R.id.weight);
        feetArray = getResources().getStringArray(R.array.feet);
        inchesArray = getResources().getStringArray(R.array.inches);
        spinnerFeet = (Spinner) findViewById(R.id.spinner_feet);
        ArrayAdapter<String> adapterFeet = new ArrayAdapter<String>(this, R.layout.dropdown_item, feetArray);
        spinnerFeet.setAdapter(adapterFeet);
        spinnerInches = (Spinner) findViewById(R.id.spinner_inches);
        ArrayAdapter<String> adapterInches = new ArrayAdapter<String>(this, R.layout.dropdown_item, inchesArray);
        spinnerInches.setAdapter(adapterInches);
        spinnerFeet.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                feet = arg0.getSelectedItemPosition() + 1;
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        spinnerInches.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                inches = arg0.getSelectedItemPosition();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        loadPreferences();
    }
    public void calcBMI(View view) {
        String weight = vWeight.getText().toString();
        savePreferences(feet-1, inches, weight);
        Intent intent = new Intent(this, ReportActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("feet", feet);
        bundle.putInt("inches", inches);
        bundle.putString("weight", weight);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void savePreferences(int f, int i, String w) {
        SharedPreferences pref = getSharedPreferences("BMI", MODE_PRIVATE);
        pref.edit().putInt("feet", f).commit();
        pref.edit().putInt("inches", i).commit();
        pref.edit().putString("weight", w).commit();
    }
    public void loadPreferences() {
        SharedPreferences pref = getSharedPreferences("BMI", MODE_PRIVATE);
        spinnerFeet.setSelection(pref.getInt("feet", 0));
        spinnerInches.setSelection(pref.getInt("inches", 0));
        vWeight.setText(pref.getString("weight", "0"));
    }
}