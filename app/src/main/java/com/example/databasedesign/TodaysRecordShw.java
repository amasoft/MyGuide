package com.example.databasedesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.myguide.R;
import com.example.myguide.datapkg.DatabaseHandler;
import com.example.myguide.datapkg.RecordRecyclerAdapter;
import com.example.myguide.util.generalmethods;

public class TodaysRecordShw extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView Todaystotaltv;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_todays_record_shw);
        recyclerView=(RecyclerView)findViewById(R.id.recyview);
        Todaystotaltv=(TextView)findViewById(R.id.Todaystotal);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final DatabaseHandler db=new DatabaseHandler( TodaysRecordShw.this);
        generalmethods ad=new generalmethods();
        db.getTodaysRecord();
        System.out.println("ALL INFOR"+" "+db.getAllContacts());
        RecordRecyclerAdapter recordRecyclerAdapter
                =new RecordRecyclerAdapter(TodaysRecordShw.this,db.getTodaysRecord());
//        RecordR =new JournalRecyclerAdapter(JournalListActivity.this,journalList);
        recyclerView.setAdapter(recordRecyclerAdapter);
        recordRecyclerAdapter.notifyDataSetChanged();
        Todaystotaltv.setText("Total :"+" "+"#"+Integer.toString(db.getTodaytotalRecord()));

        System.out.println("Total data is"+"  "+recordRecyclerAdapter.getItemCount());

    }
    public void gett(int num){
        this.num=num;
    }
}
