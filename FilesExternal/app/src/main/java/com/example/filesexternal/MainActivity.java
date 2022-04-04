package com.example.filesexternal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.filesexternal.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    static final int READ_BLOCK_SIZE = 100;
    private static final int REQUEST_CODE = 1;
    private static final int REQUEST_CODE_PERMISSION = 2;
    private static String[] PERMISSIONS_REQ = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyPermissions(this);
        mEditText = (EditText) findViewById(R.id.editText1);
        InputStream is = this.getResources().openRawResource(R.raw.testfiles);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = null;
        try {
            while ((str = br.readLine()) != null) {
                Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
            }
            is.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean verifyPermissions(Activity activity) {
        // Check if we have write permission
        int read_permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        int write_permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (read_permission != PackageManager.PERMISSION_GRANTED && write_permission !=
                PackageManager.PERMISSION_GRANTED ) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_REQ,
                    REQUEST_CODE_PERMISSION
            );
            return false;
        } else {
            return true;
        }
    }
    public void onClickSave(View v) {
        String str = mEditText.getText().toString();
        try {
            //--- SD Card Storage ---
            String sdCard = this.getExternalFilesDir(null).getAbsolutePath();
            File directory = new File (sdCard + "/FilesExternal");
            directory.mkdirs();
            File file = new File(directory, "textfile.txt");
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            // --- Write the string to the file ---
            osw.write(str);
            osw.flush();
            osw.close();
            // --- Display file saved message ---
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_LONG).show();
                    //--- Clears the EditText ---
                    mEditText.setText("");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } }
    public void onClickLoad(View v) {
        try {
            //--- SD Storage ---
            String sdCard = this.getExternalFilesDir(null).getAbsolutePath();
            File directory = new File (sdCard + "/FilesExternal");
            File file = new File(directory, "textfile.txt");
            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                //--- Convert the chars to a String ---
                String readString = String
                        .copyValueOf(inputBuffer, 0, charRead);
                s += readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
            //--- Set the EditText to the text that has been read ---
            mEditText.setText(s);
            Toast.makeText(getBaseContext(), "File loaded successfully!",
                    Toast.LENGTH_LONG).show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } } }