package com.example.myguide.datapkg;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myguide.R;
import com.example.myguide.util.generalmethods;

import java.util.List;
import java.util.Objects;

public class RecordRecyclerAdapter extends RecyclerView.Adapter<RecordRecyclerAdapter.ViewHolder> {
 private Context context;
 private List<Recordssetget>RecordList;
    generalmethods addmeth=new generalmethods();


    public RecordRecyclerAdapter(Context context, List<Recordssetget> RecordList) {
        this.context = context;
        this.RecordList = RecordList;
    }

    @NonNull
    @Override
    public RecordRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).
               inflate(R.layout.records_row,viewGroup,false);
        return new ViewHolder(view,context);
    }


    @Override
    public void onBindViewHolder(@NonNull RecordRecyclerAdapter.ViewHolder viewHolder, int position) {
Recordssetget recordssetget=RecordList.get(position);

// journal=journalList.get(position);
String imageurl;
viewHolder.titletv.setText(recordssetget.getTitle());
viewHolder.venuetv.setText(recordssetget.getVenue());
        viewHolder.pricetv.setText("#"+recordssetget.getAmmount());
        viewHolder.datetv.setText(recordssetget.getMaindate());
//        Objects.requireNonNull(viewHolder).amountperdayshw.setText(Integer.toString(1300));

//    viewHolder.name.setText(journal.getUsername());
    /*
    * usw picasso library to download and show images
    *
    * https://medium.com/@shaktisinh/time-a-go-in-android-8bad8b171f87----for time ago
    * */

        }

    @Override
    public int getItemCount() {
        return RecordList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView titletv,venuetv,datetv,pricetv,tota,amountperdayshw,totalammount;
public ImageView image;
String userid,username;
        public ViewHolder(@NonNull View itemView,Context ctx) {
            super(itemView);
            context=ctx;
            titletv= itemView.findViewById(R.id.titleshw);
            venuetv=itemView.findViewById(R.id.venueshw);
            datetv=itemView.findViewById(R.id.dateshw);
            pricetv=itemView.findViewById(R.id.priceshw);
            totalammount=itemView.findViewById(R.id.Todaystotal);
            System.out.println("allrin");
         amountperdayshw=itemView.findViewById(R.id.TotalAmmountSpentshw);


        }
    }
}
