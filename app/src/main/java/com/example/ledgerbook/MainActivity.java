package com.example.ledgerbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaDrm;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.Console;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void toupdate(View view) {
        Intent intent = new Intent(this,home.class);
        this.startActivity(intent);
    }

    public void showTransaction(View view) {
        Intent intent = new Intent(this,showTransactions.class);
        this.startActivity(intent);
    }



}