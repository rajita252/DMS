package com.example.abhi.dms;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//import android.support.v7.app.AppCompatActivity;

public class receivedItems extends Activity {
    ListView lv1;
    SQLiteDatabase db;
    ArrayList<Student> al = new ArrayList<>();
    StudentAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_items);
        lv1 = (ListView) findViewById(R.id.lv1);
        ad = new StudentAdapter();
        lv1.setAdapter(ad);
        db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
        fetchDataFromDataBase();
    }

    void fetchDataFromDataBase() {
        al.clear();

        //Cursor c = db.query("student1", null, null, null, null, null, "rollno desc");
        Cursor c = db.rawQuery("SELECT * FROM received1", null);

        while (c.moveToNext()) {
            // int r = c.getInt(0);
            String n = c.getString(c.getColumnIndex("title"));
            String n1 = c.getString(c.getColumnIndex("category"));
            String n2 = c.getString(c.getColumnIndex("condition"));
            String n3 = c.getString(c.getColumnIndex("mob"));
            String n4 = c.getString(c.getColumnIndex("address"));
            // al.add(new Student(r));
            al.add(new Student(n, n1, n2, n3, n4));
        }

        ad.notifyDataSetChanged();
    }

    class Student
    {
        String title;
        String category;
        String condition;
        String mob;
        String address;

        public Student(String title, String category, String condition, String mob, String address)
        {
            this.title = title;
            this.category = category;
            this.condition = condition;
            this.mob = mob;
            this.address = address;
        }
    }

    class StudentAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return al.size();
        }

        @Override
        public Object getItem(int position) {
            return al.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View singleView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            singleView = inflater.inflate(R.layout.layout_received_items,
                    parent, false);
            TextView title = (TextView) singleView.findViewById(R.id.title1);
            TextView category = (TextView) singleView.findViewById(R.id.category1);
            TextView condition = (TextView) singleView.findViewById(R.id.condition1);
            TextView mob = (TextView) singleView.findViewById(R.id.mob1);
            TextView address = (TextView) singleView.findViewById(R.id.address1);
            title.setText(al.get(position).title);
            category.setText(al.get(position).category + "");
            condition.setText(al.get(position).condition);
            mob.setText(al.get(position).mob);
            address.setText(al.get(position).address);
            return singleView;
        }
    }
    public void deleteRow()
    {
        db.execSQL("DELETE FROM received1");
        Toast.makeText(this, "RECORD DELETED", Toast.LENGTH_SHORT).show();
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