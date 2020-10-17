package com.example.myguide;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databasedesign.ShowsAllRecords;
import com.example.databasedesign.TodaysRecordShw;
import com.example.myguide.datapkg.DatabaseHandler;
import com.example.myguide.datapkg.Recordssetget;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText TheParticulars, TheAmmount, TheVenue, TheDetails;
    ProgressBar Recordprogress;
    Button AddRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        TheParticulars = (EditText) findViewById(R.id.Particularsin);
        TheAmmount = (EditText) findViewById(R.id.Ammountin);
        TheVenue = (EditText) findViewById(R.id.Venuein);
        TheDetails = (EditText) findViewById(R.id.Detailsin);
        AddRecord = (Button) findViewById(R.id.AddRecordBtn);
        Recordprogress=(ProgressBar)findViewById(R.id.recordprogressbar);
        Recordprogress.setVisibility(View.INVISIBLE);

        AddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Recordprogress.setVisibility(View.VISIBLE);
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int dayy = c.get(Calendar.DATE);
                int time = c.get(Calendar.HOUR);
                String striday = Integer.toString(dayy);

                String alldate=Integer.toString(dayy)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
//    int mname=c.get(Calendar.getInstance().getDisplayName())
                int finalyre = (month + 1);
                System.out.println("year" + year + " " + "month" + "  " + finalyre + " date" + dayy);
//                System.out.println("Recieved" + dayy + "/" + finalyre + "/" + year);
                System.out.println("Recieved" +alldate);
//String
                if (TextUtils.isEmpty(TheParticulars.getText().toString()) ||
                        TextUtils.isEmpty(TheAmmount.getText().toString())
                        || TextUtils.isEmpty(TheVenue.getText().toString()) || TextUtils.isEmpty(TheDetails.getText().toString())) {
                    ShowMessage("Pleas Fill All Details");
                } else {
                    Recordprogress.setVisibility(View.VISIBLE);

                    String PARTICULARS = TheParticulars.getText().toString().trim();
                    String AMMOUNT = TheAmmount.getText().toString().trim();
                    String VENUE = TheVenue.getText().toString().trim();
                    String DETAILS = TheDetails.getText().toString().trim();
                    db.AddDailyRecord(PARTICULARS, AMMOUNT, VENUE, DETAILS, Integer.toString(dayy), Integer.toString(month), Integer.toString(time),
                            "sirp",Integer.toString(year),alldate);
                    Recordprogress.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), " " + "Record Added successfully", Toast.LENGTH_LONG).show();
                    TheParticulars.setText("");
                    TheAmmount.setText("");
                    TheVenue.setText("");
                    TheDetails.setText("");

                }

            }
        });

    }

    public void addrecord() {
//        Calendar.getInstance().get(Calendar.getInstance().getTime());
//    System.out.println("my yeat"+
//    Calendar.getInstance().get(Calendar.MONTH)+
//    Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
//    String dayOfTheWeek = (String) DateFormat.format("EEEE", date); // Thursday
//    String day          = (String) DateFormat.format("dd"); // 20
//    String monthString  = (String) DateFormat.format("MMM",  date); // Jun
//    String monthNumber  = (String) DateFormat.format("MM",   date); // 06
//    String year         = (String) DateFormat.format("yyyy", date); // 2013

    }

    private void ShowMessage(String Message) {
        Toast.makeText(getApplicationContext(), " " + Message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_AllRecord:
                startActivity(new Intent(MainActivity.this, ShowsAllRecords.class));
       break;
            case  R.id.action_TodaysRecord:
                startActivity(new Intent(MainActivity.this, TodaysRecordShw.class));
        break;
        default:
        }

        return super.onOptionsItemSelected(item);

    }

    }




//
//package com.example.databasedesign;
//
//        import android.content.Context;
//        import android.support.annotation.NonNull;
//        import android.support.v7.widget.RecyclerView;
//        import android.text.format.DateUtils;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.ImageView;
//        import android.widget.TextView;
//
//        import com.example.myguide.R;
//        import com.example.myguide.datapkg.Recordssetget;
//        import com.example.selfapp.R;
//        import com.squareup.picasso.Picasso;
//
//        import java.util.List;
//
//        import model.Journal;
//
//class RecordRecyclerAdapter extends RecyclerView.Adapter<com.example.databasedesign.RecordRecyclerAdapter.ViewHolder> {
//    private Context context;
//    private List<Recordssetget> RecordList;
//
//    public RecordRecyclerAdapter(Context context, List<Recordssetget> RecordList) {
//        this.context = context;
//        this.RecordList = RecordList;
//    }
//
//    @NonNull
//    @Override
//    public com.example.databasedesign.RecordRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view= LayoutInflater.from(context).
//                inflate(R.layout.records_row,viewGroup,false);
//        return new com.example.databasedesign.RecordRecyclerAdapter.ViewHolder(view,context);
//    }
//
//
//    @Override
//    public void onBindViewHolder(@NonNull com.example.databasedesign.RecordRecyclerAdapter.ViewHolder viewHolder, int position) {
//        Recordssetget recordssetget=RecordList.get(position);
//
//// journal=journalList.get(position);
//        String imageurl;
//        viewHolder.title.setText(recordssetget.getTitle());
//        viewHolder.thought.setText(recordssetget.getVenue());
//
////    viewHolder.name.setText(journal.getUsername());
//        /*
//         * usw picasso library to download and show images
//         *
//         * https://medium.com/@shaktisinh/time-a-go-in-android-8bad8b171f87----for time ago
//         * */
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return RecordList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        public TextView title,thought,dateadded,name;
//        public ImageView image;
//        String userid,username;
//        public ViewHolder(@NonNull View itemView,Context ctx) {
//            super(itemView);
//            context=ctx;
//            title= itemView.findViewById(R.id.journal_title_list);
//            thought=itemView.findViewById(R.id.journal_thought_list);
//            dateadded=itemView.findViewById(R.id.journal_timestamp_list);
//            System.out.println("allrin");
//            name=itemView.findViewById(R.id.journal_row_username);
//
//
//        }
//    }
//}
