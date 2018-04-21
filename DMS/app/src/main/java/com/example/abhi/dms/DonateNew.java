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

//import android.support.v7.app.AppCompatActivity;

public class DonateNew extends Activity
{
    ListView lv1;
    SQLiteDatabase db;
    ArrayList<Student1> al = new ArrayList<>();
    private EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_new);
        lv1 = (ListView) findViewById(R.id.lv1);
        editText1 = (EditText)findViewById(R.id.title1);

    }
    public void view(View view)
    {
        db = openOrCreateDatabase("MyDB",MODE_PRIVATE,null);
    }
    public void insertRow(View view)
    {
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
                    String title1 = title.getText().toString();
                    String category1 = category.getText().toString();
                    String condition1 = condition.getText().toString();
                    String mob1 = mob.getText().toString();
                    String address1 = address.getText().toString();

                    String query = "INSERT INTO student1 values('" + title1 + "','" + category1 + "','" + condition1 + "','" + mob1 + "','" + address1 + "')";

                    db.execSQL(query);

                    Toast.makeText(getBaseContext(), "RECORD INSERTED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createDB() {
        db = openOrCreateDatabase("MyDB",MODE_PRIVATE,null);
    }

    private void createTable()
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS student1(id INTEGER PRIMARY KEY AUTOINCREMENT,title varchar not null, category varchar, condition varchar, mob varchar, address varchar)");
    }

    class Student1
    {
        int rollno;
        String name;
        double marks;

        public Student1(int rollno, String name, double marks)
        {
            this.rollno = rollno;
            this.name = name;
            this.marks = marks;
        }
    }


}