package com.example.michael.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnFocusChangeListener;


public class MainActivity extends AppCompatActivity {

    private EditText pushup, situp, jj, jogging;
    private TextView calories;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pushup = (EditText) findViewById(R.id.pushUp);
        situp = (EditText) findViewById(R.id.sitUp);
        jj = (EditText) findViewById(R.id.jj);
        jogging = (EditText) findViewById(R.id.jogging);
        calories = (TextView) findViewById(R.id.burned);
        resetButton = (Button) findViewById(R.id.reset);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushup.setText("0");
                situp.setText("0");
                jj.setText("0");
                jogging.setText("0");
            }
        });
        pushup.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                String str = pushup.getText().toString();
                if(str.length() > 1 && str.charAt(0)=='0'){
                    pushup.setText(str.substring(1, str.length()));
                    str = pushup.getText().toString();
                    pushup.setSelection(1);
                }
                if(!str.equals("")){
                    updateCalories();
                }
            }
        });

        pushup.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && pushup.getText().toString().equals("")) {
                    pushup.setText("0");
                }
            }
        });

        situp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = situp.getText().toString();
                if(str.length() > 1 && str.charAt(0)=='0'){
                    situp.setText(str.substring(1, str.length()));
                    str = situp.getText().toString();
                    situp.setSelection(1);
                }
                if(!str.equals("")){
                    updateCalories();
                }
            }
        });

        situp.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && situp.getText().toString().equals("")) {
                    situp.setText("0");
                }
            }
        });

        jj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = jj.getText().toString();
                if(str.length() > 1 && str.charAt(0)=='0'){
                    jj.setText(str.substring(1, str.length()));
                    str = jj.getText().toString();
                    jj.setSelection(1);
                }
                if(!str.equals("")){
                    updateCalories();
                }
            }
        });

        jj.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && jj.getText().toString().equals("")) {
                    jj.setText("0");
                }
            }
        });

        jogging.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = jogging.getText().toString();
                if(str.length() > 1 && str.charAt(0)=='0'){
                    jogging.setText(str.substring(1, str.length()));
                    str = jogging.getText().toString();
                    jogging.setSelection(1);
                }
                if(!str.equals("")){
                    updateCalories();
                }
            }
        });

        jogging.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && jogging.getText().toString().equals("")) {
                    jogging.setText("0");
                }
            }
        });
    }

    protected void updateCalories(){
        double pushupConv = 100.0/350.0;
        double situpConv = 100.0/200.0;
        double jjConv = 100.0/10.0;
        double joggingConv = 100.0/12.0;

        double pushUpBurned = Double.parseDouble(pushup.getText().toString())*pushupConv;
        double sitUpBurned = Double.parseDouble(situp.getText().toString())*situpConv;
        double jjBurned = Double.parseDouble(jj.getText().toString())*jjConv;
        double joggingBurned = Double.parseDouble(jogging.getText().toString())*joggingConv;

        double result = pushUpBurned + sitUpBurned + jjBurned + joggingBurned;
        double display = Math.round(result*100.0)/100.0;
        if(display==0.0){
            calories.setText("0");
        }else{
            calories.setText(String.valueOf(display));
        }
    }

}
