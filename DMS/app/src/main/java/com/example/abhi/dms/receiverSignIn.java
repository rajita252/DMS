package com.example.abhi.dms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class receiverSignIn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_sign_in);
    }

    public void f5(View view) {
        Intent intent= new Intent(this,ReceiverSignUp.class);
        startActivity(intent);
    }

    public void f6(View view) {
        Intent intent= new Intent(this,ReceiverDashboard.class);
        startActivity(intent);
    }
}
