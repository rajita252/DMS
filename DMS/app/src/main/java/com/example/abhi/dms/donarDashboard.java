package com.example.abhi.dms;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import android.support.v7.app.AppCompatActivity;

public class donarDashboard extends Activity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_dashboard);
    }

    public void f8(View view) {
        Intent intent = new Intent(this, DonateNew.class);
        startActivity(intent);
    }

    public void f9(View view) {
        Intent intent = new Intent(this, CurrentItems.class);
        startActivity(intent);

    }

    public void f10(View view) {
        Intent intent = new Intent(this, MyDonations.class);
        startActivity(intent);
    }

    public void view(View view) {
        db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
        Toast.makeText(this, "Data Fetched Successfully", Toast.LENGTH_SHORT).show();
    }

    public void insertRow(View view) {
        final Dialog d = new Dialog(this);
        createDB();
        createTable();
        d.setContentView(R.layout.layout_for_insert_row);
        d.setTitle("Insert Data");
        final EditText title = (EditText) d.findViewById(R.id.title1);
        final EditText category = (EditText) d.findViewById(R.id.category1);
        final EditText condition = (EditText) d.findViewById(R.id.condition1);
        final EditText mob = (EditText) d.findViewById(R.id.mob1);
        final EditText address = (EditText) d.findViewById(R.id.address1);
        Button btInsert = (Button) d.findViewById(R.id.btInsert);
        Button btCancel = (Button) d.findViewById(R.id.btCancel);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title1 = title.getText().toString();
                String category1 = category.getText().toString();
                String condition1 = condition.getText().toString();
                String mob1 = mob.getText().toString();
                String address1 = address.getText().toString();

                String query = "INSERT INTO student1 values('" + title1 + "','" + category1 + "','" + condition1 + "','" + mob1 + "','" + address1 + "')";

                db.execSQL(query);

                Toast.makeText(getBaseContext(), "RECORD INSERTED", Toast.LENGTH_SHORT).show();


                d.dismiss();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });


        d.show();
    }
    private void createDB() {
        db = openOrCreateDatabase("MyDB",MODE_PRIVATE,null);
    }

    private void createTable()
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS student1(title varchar, category varchar, condition varchar, mob varchar, address varchar)");
    }
}