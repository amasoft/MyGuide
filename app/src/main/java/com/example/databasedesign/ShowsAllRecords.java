package com.example.databasedesign;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myguide.MainActivity;
import com.example.myguide.R;
import com.example.myguide.datapkg.DatabaseHandler;
import com.example.myguide.datapkg.RecordRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShowsAllRecords extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows_all_records);
        recyclerView=(RecyclerView)findViewById(R.id.recyview);
      //  recyclerView=findViewById(R.id.recyview);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final DatabaseHandler db=new DatabaseHandler( ShowsAllRecords.this);

        db.getAllContacts();
        System.out.println("ALL INFOR"+" "+db.getAllContacts());
        RecordRecyclerAdapter  recordRecyclerAdapter=new RecordRecyclerAdapter(ShowsAllRecords.this,db.getAllContacts());
//        RecordR =new JournalRecyclerAdapter(JournalListActivity.this,journalList);
        recyclerView.setAdapter(recordRecyclerAdapter);
        recordRecyclerAdapter.notifyDataSetChanged();

        System.out.println("Total data is"+"  "+recordRecyclerAdapter.getItemCount());


        //public List<Contact> getAllContacts(){
//            List<> contactList=new ArrayList<>();
//            SQLiteDatabase db=this.getReadableDatabase();
//
//            //selctr all contacts
//            String Selectall="SELECT * FROM "+ Util.TABLE_NAME;
//
//            Cursor cursor =db.rawQuery(Selectall,null);
//
//            //loop through our data
//            if(cursor.moveToFirst()){
//                do{
//                    Contact contact=new Contact();
//                    contact.setId(Integer.parseInt(cursor.getString(0)));
//                    contact.setName(cursor.getString(1));
//                    contact.setPhoneNumber(cursor.getString(2));
//                    contactList.add(contact);
//                }while (cursor.moveToNext());
//            }
//            return contactList;
//        }

    }
}
