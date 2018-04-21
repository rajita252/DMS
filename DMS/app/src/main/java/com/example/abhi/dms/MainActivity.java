package com.example.abhi.dms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donate(View view) {
        Intent intent= new Intent(this,DonorSignIn.class);
        startActivity(intent);
    }

    public void receive(View view) {
        Intent intent= new Intent(this,receiverSignIn.class);
        startActivity(intent);

    }
}
