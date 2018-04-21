package com.example.abhi.dms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DonorSignIn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_sign_in);
    }

    public void f2(View view) {
        Intent intent= new Intent(this,donarDashboard.class);
        startActivity(intent);
    }

    public void f3(View view) {
        Intent intent= new Intent(this,DonarSignup.class);
        startActivity(intent);

    }

    public void f4(View view) {
    }
}
