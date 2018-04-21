package com.example.abhi.dms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDonations extends Activity {


    ListView lv1;
    ArrayList<String> al = new ArrayList<String>();
    ArrayAdapter<String> ad;
    String gt;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv1= (TextView) findViewById(R.id.textView60);
        setContentView(R.layout.activity_received_items);
        lv1 = (ListView) findViewById(R.id.lv1);
        al.add("Android");
        al.add("Java");
        al.add("Python");
        al.add("Swift");
        al.add("Objective C");
        ad = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, al);
        lv1.setAdapter(ad);
        lv1.setOnItemClickListener (new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                Toast.makeText(getBaseContext(),"Item Selected:"+al.get(position),Toast.LENGTH_SHORT).show();
                gt=al.get(position);
            }
        });

    }

    public void checknow(View view) {
        if(gt=="Android")
        {
            Intent intent= new Intent(this,donarDashboard.class);
            startActivity(intent);
        }
        else
        {
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}




