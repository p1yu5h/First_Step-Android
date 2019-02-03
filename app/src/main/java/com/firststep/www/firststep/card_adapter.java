package com.firststep.www.firststep;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class card_adapter  extends RecyclerView.Adapter<card_adapter.RecyclerVH> {
    Context c;
    int card_layout;
    public ArrayList<Notification> persons_list=new ArrayList<>();
    // public MyAdapter(Context c, String[] servicemen_names,String[] servicemen_number,Float[] servicemen_rating,Integer[]servicemen_images) {
    public card_adapter(Context c, List<Notification> l, int lay ) {
        this.c = c;
        card_layout=lay;
        persons_list.addAll(l);
    }
    public RecyclerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(card_layout,parent,false);
        return new RecyclerVH(v);
    }

    @Override
    public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
        // Log.d("bhavyammm","working");
    }
    public void updateReceiptsList(List<Notification> newlist) {
        persons_list.clear();
        persons_list.addAll(newlist);
        this.notifyDataSetChanged();
    }
    @Override
    public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
        super.unregisterAdapterDataObserver(observer);
    }

    @Override
    public void onBindViewHolder(RecyclerVH holder, int position) {
        Notification con=persons_list.get(position);
        holder.topictxt.setText(con.getTopic());
        holder.desctxt.setText(( con.getDescription()));
        holder.datetxt.setText(con.getEvent_date().toString());
    }
        //holder.book_b.setText(servicemen_bu[position]);


    @Override
    public int getItemCount() {
        return persons_list.size();
    }
    /*
    VIEWHOLDER CLASS
     */
    public class RecyclerVH extends RecyclerView.ViewHolder  implements View.OnClickListener
    {
        TextView desctxt;
        TextView topictxt;
        TextView datetxt;

        public RecyclerVH(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            topictxt=(TextView) itemView.findViewById(R.id.topic_txt);
            datetxt=(TextView) itemView.findViewById(R.id.date_txt);
            desctxt= (TextView) itemView.findViewById(R.id.desc_txt);

            //book_b=(Button) itemView.findViewById(R.id.book_rqst);
        }
        @Override
        public void onClick(View view){
        }
    }
}