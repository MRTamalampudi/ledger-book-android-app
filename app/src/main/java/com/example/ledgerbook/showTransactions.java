package com.example.ledgerbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class showTransactions extends AppCompatActivity {

    private ArrayList<transactions> transactionsArrayList;
    RecyclerView recyclerView;
    TextView sdate;
    String datee;
    String dataa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_transactions);
        sdate = findViewById(R.id.searchDate);
        recyclerView = findViewById(R.id.rview);
        transactionsArrayList = new ArrayList<>();

    }

//    public void fetchdata(View view) {
//
//
//    }


    private void setadapter() {
        recycleAdapter adapter = new recycleAdapter(transactionsArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void settinfo() {
        String p = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id tincidunt nunc. Morbi et accumsan ipsum. Ut a metus mauris. Cras rhoncus auctor felis, quis sodales est. Vestibulum aliquet dignissim.";
        transactionsArrayList.add(new transactions("1", p, "2000"));
        transactionsArrayList.add(new transactions("2", p, "2000"));
        transactionsArrayList.add(new transactions("3", p, "2000"));
        transactionsArrayList.add(new transactions("4", p, "2000"));
        transactionsArrayList.add(new transactions("5", p, "2000"));
        transactionsArrayList.add(new transactions("6", p, "2000"));
        transactionsArrayList.add(new transactions("7", p, "2000"));
        transactionsArrayList.add(new transactions("8", p, "2000"));
        transactionsArrayList.add(new transactions("9", p, "2000"));
        transactionsArrayList.add(new transactions("10", p, "2000"));
        transactionsArrayList.add(new transactions("11", p, "2000"));
        transactionsArrayList.add(new transactions("12", p, "2000"));
        transactionsArrayList.add(new transactions("13", p, "2000"));
        transactionsArrayList.add(new transactions("14", p, "2000"));
        transactionsArrayList.add(new transactions("15", p, "2000"));
        transactionsArrayList.add(new transactions("16", p, "2000"));
        transactionsArrayList.add(new transactions("17", p, "2000"));
        transactionsArrayList.add(new transactions("18", p, "2000"));
        transactionsArrayList.add(new transactions("19", p, "2000"));
        transactionsArrayList.add(new transactions("20", p, "2000"));
        transactionsArrayList.add(new transactions("21", p, "2000"));
        transactionsArrayList.add(new transactions("22", p, "2000"));
        transactionsArrayList.add(new transactions("23", p, "2000"));
        transactionsArrayList.add(new transactions("24", p, "2000"));
        transactionsArrayList.add(new transactions("25", p, "2000"));
        transactionsArrayList.add(new transactions("26", p, "2000"));
        transactionsArrayList.add(new transactions("27", p, "2000"));
    }

    public void fetchdata(View view) {
        datee=sdate.getText().toString();
        estconn();
        setadapter();
    }

    private void estconn() {

        new Thread(new Runnable() {
            public void run() {
                String body = null;
                try {
                    Document document = Jsoup.connect("http://10.0.2.2:5000/filter?date="+datee).get();
                    body=document.body().text();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String finalBody = body;
                jss(finalBody);
            }
        }).start();
    }

    public void jss(String json){
        try {
            JSONObject jsonObject= new JSONObject(json);
            for(int i=0;i<jsonObject.length()+1;i++){
                JSONObject jsonObject1= jsonObject.getJSONObject(String.valueOf(i));
                String id=jsonObject1.getString("id");
                String purpose=jsonObject1.getString("purpose");
                String amount=jsonObject1.getString("amount");
                transactionsArrayList.add(new transactions(id,purpose,amount));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
