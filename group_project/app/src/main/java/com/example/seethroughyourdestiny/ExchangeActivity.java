package com.example.seethroughyourdestiny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExchangeActivity extends AppCompatActivity {
    EditText vresult1, vresult2,vresult3,vresult4;
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        vresult1 = (EditText) findViewById(R.id.result1);
        vresult2 = (EditText) findViewById(R.id.result2);
        vresult3 = (EditText) findViewById(R.id.result3);
        vresult4 = (EditText) findViewById(R.id.result4);
        nextButton = (Button) findViewById(R.id.button8);
        registerForContextMenu(vresult1);
        registerForContextMenu(vresult2);
        registerForContextMenu(vresult3);
        registerForContextMenu(vresult4);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result1 = vresult1.getText().toString();
                String result2 = vresult2.getText().toString();
                String result3 = vresult3.getText().toString();
                String result4 = vresult4.getText().toString();
                Intent intent = new Intent(getApplicationContext(),
                        ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("result1", result1);
                bundle.putString("result2", result2);
                bundle.putString("result3", result3);
                bundle.putString("result4", result4);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuResult1:
                vresult1.setText( this.getResources().getText( R.string.result1)
                );
                return true;
            case R.id.menuResult2:
                vresult1.setText( this.getResources().getText( R.string.result2) );
                return true;
            default:
                return super.onContextItemSelected(item);
        } }
}