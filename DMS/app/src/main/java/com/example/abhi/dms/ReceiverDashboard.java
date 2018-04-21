package com.example.abhi.dms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReceiverDashboard extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_dashboard);

    }


    public void f7(View view) {
        Intent intent = new Intent(this, SearchNewItem.class);
        startActivity(intent);
    }
    public void f12(View view) {
        Intent intent = new Intent(this, SearchNewItem.class);
        startActivity(intent);
    }
    public void f13(View view) {
        Intent intent = new Intent(this, CurrentItems.class);
        startActivity(intent);
    }

    public void f14(View view) {
        Intent intent = new Intent(this, receivedItems.class);
        startActivity(intent);
    }
}
