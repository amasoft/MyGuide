package com.example.myguide.datapkg;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.AlphabeticIndex;
import android.util.Log;
import android.widget.Toast;

import com.example.myguide.R;
import com.example.myguide.util.generalmethods;
import com.example.myguide.util.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private Context context;
    private List<Recordssetget>RecordList;

    String [] prz;
    public DatabaseHandler(Context context) {
        super(context, util.DATABASE_NAME,null,util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String CREATE_CONTACT_TABLE="CREATE TABLE "+util.TABLE_NAME +"("
//                + util.KE_ID + " INTEGER PRIMARY KEY," + util.KEY_PARTICULARS +" Text,"
//                +util.KEY_AMMOUNT+ " INTEGER" + ")";

        String CREATE_CONTACT_TABLE="CREATE TABLE "+util.TABLE_NAME +"("
                + util.KE_ID + " INTEGER PRIMARY KEY," + util.KEY_PARTICULARS +" Text,"
                +util.KEY_AMMOUNT+ " INTEGER," + util.KEY_VENUE+ " Text," + util.KEY_DETAILS +" Text,"+
                util.KEY_DAY+ " Text,"+ util.KEY_MONTH +"  Text," + util.KEY_TIME+"  Text,"+
                util.KEY_USER+" Text,"+ util.KEY_YEAR+"  Text, "+util.KEY_MainDate+"  Text"+  ")";
        db.execSQL(CREATE_CONTACT_TABLE);// create our table contact

        Log.d("DB Handler","table creted succesfully ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROPE_TABLE =String.valueOf(R.string.db_Drop);
        db.execSQL(DROPE_TABLE, new  String[]{util.DATABASE_NAME});

        //create a new table
        onCreate(db);
    }

//    public static final String KE_ID="id";
//    public static final String KEY_PARTICULARS="Particulars";
//    public static final String KEY_AMMOUNT="Ammount";
//    public static final String KEY_VENUE="Venue";
//    public static final String KEY_DETAILS="DETAILS";
//    public static final String KEY_DAY="Day";
//    public static final String KEY_MONTH="Month";
//    public static final String KEY_TIME="Time";
//    public static final String KEY_USER="Username";
    public void AddDailyRecord(String particulers,String ammount,String venue,String details,String day,
                               String month,String time,String username,String year,String maindate){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(util.KEY_PARTICULARS,particulers);
        values.put(util.KEY_AMMOUNT,ammount);
        values.put(util.KEY_VENUE,venue);
        values.put(util.KEY_DETAILS,details);
        values.put(util.KEY_DAY,day);
        values.put(util.KEY_MONTH,month);
        values.put(util.KEY_TIME,time);
        values.put(util.KEY_YEAR,year);
        values.put(util.KEY_MainDate,maindate);
        values.put(util.KEY_USER,username);

        //insert to row
        db.insert(util.TABLE_NAME,null,values);
        Log.d("DB Handler","addcontact "+ "item Added");
        db.close();// closing
    }


    public List<Recordssetget> getAllContacts(){
//        prz=new String[];
        List<Recordssetget> recordssetgets=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();

        //selctr all contacts
        String Selectall="SELECT * FROM "+ util.TABLE_NAME;

        Cursor cursor =db.rawQuery(Selectall,null);

        //loop through our data
        if(cursor.moveToFirst()){
            do{
                String day=cursor.getString((cursor.getColumnIndex(util.KEY_DAY)));
                String mont=cursor.getString((cursor.getColumnIndex(util.KEY_MONTH)));
                String yr=cursor.getString((cursor.getColumnIndex(util.KEY_YEAR)));

                String all=day+"/"+mont+"/"+yr;

                Recordssetget recordoperation=new Recordssetget();
                recordoperation.setTitle(cursor.getString(1));
                recordoperation.setVenue(cursor.getString(cursor.getColumnIndex(util.KEY_VENUE)));
                recordoperation.setAmmount(cursor.getString((cursor.getColumnIndex(util.KEY_AMMOUNT))));
                recordoperation.setMaindate(cursor.getString(cursor.getColumnIndex(util.KEY_MainDate)));

//                contact.setId(Integer.parseInt(cursor.getString(0)));
//                contact.setName(cursor.getString(1));
//                contact.setPhoneNumber(cursor.getString(2));
                recordssetgets.add(recordoperation);


//                System.out.println("myinfor"+"id"+"  "+cursor.getString(cursor.getColumnIndex(util.KEY_MONTH))+""++"");
            }while (cursor.moveToNext());
        }
        return recordssetgets;
//        for(int u=0;u<=count;u+++){
//
//        }
    }
    public List<Recordssetget> getTodaysRecord() {
//        prz=new String[];
    //    try {

//means the type of list is  Recordssetget type
            List<Recordssetget> recordssetgets = new ArrayList<>();

            SQLiteDatabase db = this.getReadableDatabase();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayy = c.get(Calendar.DATE);
        int time = c.get(Calendar.HOUR);
        String striday = Integer.toString(dayy);
int total=0;
        String alldate=Integer.toString(dayy)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
      try {


            String Selectall = "SELECT * FROM " + util.TABLE_NAME + " where" + " " + util.KEY_DAY + "  " +
                    "= " + Integer.toString(dayy) +" "+"AND"+ "  "+util.KEY_MONTH +" "+"= "+ Integer.toString(month) +" "+"AND"+" "        +util.KEY_YEAR+" "+"= "+ Integer.toString(year);
            System.out.println("newquerysir" + " " + Selectall);
            Cursor cursor = db.rawQuery(Selectall, null);

            //loop through our data
            if (cursor.moveToFirst()) {
                do {
                    String day = cursor.getString((cursor.getColumnIndex(util.KEY_DAY)));
                    String mont = cursor.getString((cursor.getColumnIndex(util.KEY_MONTH)));
                    String yr = cursor.getString((cursor.getColumnIndex(util.KEY_YEAR)));

                    String all = day + "/" + mont + "/" + yr;

                    Recordssetget recordoperation = new Recordssetget();
                    //sends the data to Recordesetget class to enaqble other class access it
                    total=total+Integer.parseInt(cursor.getString((cursor.getColumnIndex(util.KEY_AMMOUNT))));
                    recordoperation.setTitle(cursor.getString(1));
                    recordoperation.setTitle(Integer.toString(total));
                    recordoperation.setVenue(cursor.getString(cursor.getColumnIndex(util.KEY_VENUE)));
                    recordoperation.setAmmount(cursor.getString((cursor.getColumnIndex(util.KEY_AMMOUNT))));
                    recordoperation.setMaindate(cursor.getString(cursor.getColumnIndex(util.KEY_MainDate)));
//                contact.setId(Integer.parseInt(cursor.getString(0)));
//                contact.setName(cursor.getString(1));
//                contact.setPhoneNumber(cursor.getString(2));
                    recordssetgets.add(recordoperation);

//                System.out.println("myinfor"+"id"+"  "+cursor.getString(cursor.getColumnIndex(util.KEY_MONTH))+""++"");
                } while (cursor.moveToNext());
            }

      }catch (SQLException er){
          System.out.println("myerror"+er.getMessage());
      }
        generalmethods addmeth=new generalmethods(total);
//        recordssetgets.add(Integer.toString(total));
        System.out.println("allsirp"+total);

        return recordssetgets;

//        for(int u=0;u<=count;u+++){
//
//        }
        }







    public int getTodaytotalRecord() {

        SQLiteDatabase db = this.getReadableDatabase();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayy = c.get(Calendar.DATE);
        int time = c.get(Calendar.HOUR);
        String striday = Integer.toString(dayy);
        int total=0;
        String alldate=Integer.toString(dayy)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
        try {


            String Selectall = "SELECT * FROM " + util.TABLE_NAME + " where" + " " + util.KEY_DAY + "  " +
                    "= " + Integer.toString(dayy) +" "+"AND"+ "  "+util.KEY_MONTH +" "+"= "+ Integer.toString(month) +" "+"AND"+" "        +util.KEY_YEAR+" "+"= "+ Integer.toString(year);
            System.out.println("newquerysir" + " " + Selectall);
            Cursor cursor = db.rawQuery(Selectall, null);

            //loop through our data
            if (cursor.moveToFirst()) {
                do {
                    String day = cursor.getString((cursor.getColumnIndex(util.KEY_DAY)));
                    String mont = cursor.getString((cursor.getColumnIndex(util.KEY_MONTH)));
                    String yr = cursor.getString((cursor.getColumnIndex(util.KEY_YEAR)));

                    String all = day + "/" + mont + "/" + yr;
     //sends the data to Recordesetget class to enaqble other class access it
                    total=total+Integer.parseInt(cursor.getString((cursor.getColumnIndex(util.KEY_AMMOUNT))));
                } while (cursor.moveToNext());
            }

        }catch (SQLException er){
            System.out.println("myerror"+er.getMessage());
        }
        generalmethods addmeth=new generalmethods(total);
//        recordssetgets.add(Integer.toString(total));
        System.out.println("allsirp"+total);

        return total;

//        for(int u=0;u<=count;u+++){
//
//        }
    }




}
