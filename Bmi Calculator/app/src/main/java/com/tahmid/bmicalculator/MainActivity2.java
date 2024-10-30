package com.tahmid.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity2 extends AppCompatActivity {

    WebView view;
    public static String collect="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        view=findViewById(R.id.view);

        view.getSettings().setJavaScriptEnabled(true);

        view.loadUrl(""+collect);
    }
}