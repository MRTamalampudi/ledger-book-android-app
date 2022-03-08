package com.example.ledgerbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class home extends AppCompatActivity {

    EditText purpose,amount;
    Button b1;
    JSONObject dataa=  new JSONObject();
    String p;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        purpose=findViewById(R.id.purpose);
        amount= findViewById(R.id.amount);
        b1= findViewById(R.id.button);
    }

    public void postData(View view) {
        p=purpose.getText().toString();
        a=Integer.parseInt(amount.getText().toString());
        try {
            dataa.put("p",p);
            dataa.put("a",a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        postt();
        Toast.makeText(this,"Transaction Added",Toast.LENGTH_LONG).show();
    }

    public void postt(){
        Toast.makeText(this,"workinggg",Toast.LENGTH_LONG).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document =Jsoup.connect("http://10.0.2.2:5000/add?p="+p+"&a="+a).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }
}