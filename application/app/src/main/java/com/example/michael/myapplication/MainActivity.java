package com.example.michael.myapplication;

import android.graphics.Color;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.OnFocusChangeListener;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private EditText pushup, situp, jj, jogging;
    private TextView calories, modetext;
    private Button resetButton, modeButton;
    private int mode;
    private RelativeLayout top;
    private EditText currfocus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mode = 0; //0 for count; 1 for convert
        pushup = (EditText) findViewById(R.id.pushUp);
        situp = (EditText) findViewById(R.id.sitUp);
        jj = (EditText) findViewById(R.id.jj);
        jogging = (EditText) findViewById(R.id.jogging);
        calories = (TextView) findViewById(R.id.burned);
        resetButton = (Button) findViewById(R.id.reset);
        modeButton = (Button) findViewById(R.id.changeMode);
        top = (RelativeLayout) findViewById(R.id.modeLayout);
        modetext = (TextView) findViewById(R.id.mode);
        currfocus = pushup;

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushup.setText("0");
                situp.setText("0");
                jj.setText("0");
                jogging.setText("0");
            }
        });

        modeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushup.setText("0");
                situp.setText("0");
                jj.setText("0");
                jogging.setText("0");
                if(mode==0){
                    mode = 1;
                    top.setBackgroundColor(Color.argb(255,0,0,146));
                    modetext.setText("Convert Mode");
                    findViewById(R.id.topLabel1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.topLabel2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.burned).setVisibility(View.INVISIBLE);
                    findViewById(R.id.convertText).setVisibility(View.VISIBLE);
                    findViewById(R.id.convertText2).setVisibility(View.VISIBLE);
                }else if(mode==1){
                    mode = 0;
                    top.setBackgroundColor(Color.argb(255, 0, 0, 0));
                    modetext.setText("Count Mode");
                    findViewById(R.id.topLabel1).setVisibility(View.VISIBLE);
                    findViewById(R.id.topLabel2).setVisibility(View.VISIBLE);
                    findViewById(R.id.burned).setVisibility(View.VISIBLE);
                    findViewById(R.id.convertText).setVisibility(View.INVISIBLE);
                    findViewById(R.id.convertText2).setVisibility(View.INVISIBLE);
                }
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
                if (str.length() > 1 && str.charAt(0) == '0') {
                    pushup.setText(str.substring(1, str.length()));
                    str = pushup.getText().toString();
                    pushup.setSelection(1);
                }
                if (!str.equals("")) {
                    if(mode==0){
                        updateCalories();
                    }else if(mode==1){
                        if(currfocus==pushup) {
                            updateOtherVals(pushup);
                        }
                    }
                }

            }
        });

        pushup.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    currfocus = pushup;
                }

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
                    if(mode==0){
                        updateCalories();
                    }else if(mode==1){
                        if(currfocus==situp){
                            updateOtherVals(situp);
                        }
                    }
                }
            }
        });

        situp.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    currfocus = situp;
                }
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
                    if(mode==0){
                        updateCalories();
                    }else if(mode==1){
                        if(currfocus==jj){
                            updateOtherVals(jj);
                        }
                    }
                }
            }
        });

        jj.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    currfocus = jj;
                }
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
                    if(mode==0){
                        updateCalories();
                    }else if(mode==1){
                        if(currfocus==jogging){
                            updateOtherVals(jogging);
                        }
                    }
                }
            }
        });

        jogging.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    currfocus = jogging;
                }
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

    protected void updateOtherVals(TextView changed){
        int p = Integer.parseInt(changed.getText().toString());
        TextView txt = (TextView)(findViewById(R.id.convertText2));
        double f;
        if(changed==pushup){
            txt.setText(String.valueOf(p)+" Pushup(s)");
            f = 100.0/350.0;
            if(!String.valueOf(Math.round(p * f * 2)).equals(situp.getText().toString())){
                situp.setText(String.valueOf(Math.round(p * f * 2)));
            }
            if(!String.valueOf(Math.round(p * f / 10)).equals(jj.getText().toString())){
                jj.setText(String.valueOf(Math.round(p * f / 10)));
            }
            if(!String.valueOf(Math.round(p * f * 12.0/100.0)).equals(jogging.getText().toString())){
                jogging.setText(String.valueOf(Math.round(p * f * 12.0/100.0)));
            }
        }else if(changed==situp){
            txt.setText(String.valueOf(p)+" Situp(s)");
            f = 100.0/200.0;
            if(!String.valueOf(Math.round(p * f * 350.0/100.0)).equals(pushup.getText().toString())){
                pushup.setText(String.valueOf(Math.round(p * f * 350.0/100.0)));
            }
            if(!String.valueOf(Math.round(p * f / 10)).equals(jj.getText().toString())){
                jj.setText(String.valueOf(Math.round(p * f / 10)));
            }
            if(!String.valueOf(Math.round(p * f * 12.0/100.0)).equals(jogging.getText().toString())){
                jogging.setText(String.valueOf(Math.round(p * f * 12.0/100.0)));
            }
        }else if(changed==jj){
            txt.setText(String.valueOf(p)+" minute(s) of jumping jacks");
            f = 100.0/10.0;
            if(!String.valueOf(Math.round(p * f * 350.0/100.0)).equals(pushup.getText().toString())){
                pushup.setText(String.valueOf(Math.round(p * f * 350.0/100.0)));
            }
            if(!String.valueOf(Math.round(p * f * 2)).equals(situp.getText().toString())){
                situp.setText(String.valueOf(Math.round(p * f * 2)));
            }
            if(!String.valueOf(Math.round(p * f * 12.0/100.0)).equals(jogging.getText().toString())){
                jogging.setText(String.valueOf(Math.round(p * f * 12.0/100.0)));
            }
        }else if(changed==jogging){
            txt.setText(String.valueOf(p)+" minute(s) of jogging");
            f = 100.0/12.0;
            if(!String.valueOf(Math.round(p * f * 350.0/100.0)).equals(pushup.getText().toString())){
                pushup.setText(String.valueOf(Math.round(p * f * 350.0/100.0)));
            }
            if(!String.valueOf(Math.round(p * f * 2)).equals(situp.getText().toString())){
                situp.setText(String.valueOf(Math.round(p * f * 2)));
            }
            if(!String.valueOf(Math.round(p * f / 10)).equals(jj.getText().toString())){
                jj.setText(String.valueOf(Math.round(p * f / 10)));
            }
        }
    }

}
