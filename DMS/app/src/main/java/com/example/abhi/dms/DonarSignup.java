package com.example.abhi.dms;

import android.app.Activity;
import android.app.Dialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DonarSignup extends Activity {
    ListView lv1;
    SQLiteDatabase db;
    ArrayList<receivedItems.Student> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_signup);
    }

    public void SignUp(View view) {

        final Dialog d = new Dialog(this);
        createDB();
        createTable();
        d.setContentView(R.layout.activity_donar_signup);
        d.setTitle("Insert Data");
        EditText fname1 = (EditText)findViewById(R.id.ifRoom);
        final EditText category = (EditText) d.findViewById(R.id.ifRoom);
        final EditText condition = (EditText) d.findViewById(R.id.condition1);
        final EditText mob = (EditText) d.findViewById(R.id.mob1);
        final EditText address = (EditText) d.findViewById(R.id.address1);
        Button btInsert = (Button) d.findViewById(R.id.btInsert);

        btInsert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                EditText firstName = (EditText)findViewById(R.id.title1);
                if( firstName.getText().toString().length() == 0 ) {
                    firstName.setError("First name is required!");
                }
                else
                {
                    //String title1 = title.getText().toString();
                    String category1 = category.getText().toString();
                    String condition1 = condition.getText().toString();
                    String mob1 = mob.getText().toString();
                    String address1 = address.getText().toString();

                    //String query = "INSERT INTO Donors values('" + title1 + "','" + category1 + "','" + condition1 + "','" + mob1 + "','" + address1 + "')";

                    //db.execSQL(query);

                    Toast.makeText(getBaseContext(), "RECORD INSERTED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createDB() {
        db = openOrCreateDatabase("MyDB",MODE_PRIVATE,null);
    }
    private void createTable() {
        db.execSQL("CREATE TABLE IF NOT EXISTS Donors(id INTEGER PRIMARY KEY AUTOINCREMENT,title varchar not null, category varchar, condition varchar, mob varchar, address varchar)");

    }
}
