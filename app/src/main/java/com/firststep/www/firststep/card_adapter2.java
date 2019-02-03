package com.firststep.www.firststep;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
public class card_adapter2 extends RecyclerView.Adapter<card_adapter2.RecyclerVH> {
    private Context mcontext;
    private final String[] values;
    private final int[] imageid;
    private int type,clickable;
    int[] images={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    String[] color={"#00CCFF","#F3D430","#F36E27","#ED1683","#E912D4"};
    public card_adapter2(Context m, int t,int cl, String[] values,int[] img) {
        type = t;
        clickable=cl;
        imageid=img;
        mcontext = m;
        this.values = values;
    }


    @Override
    public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
        // Log.d("bhavyammm","working");
    }

    @Override
    public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
        super.unregisterAdapterDataObserver(observer);
    }

    @NonNull
    @Override
    public RecyclerVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(mcontext).inflate(R.layout.pop_item, viewGroup,false);
            return new card_adapter2.RecyclerVH(v);

    }
    int pe=-1;
    @Override
    public void onBindViewHolder(RecyclerVH holder, int position) {
        if (type == 1) {
            Random r=new Random();
            int x=r.nextInt(5);
            while(pe==x){
                x=r.nextInt(5);
            }
            pe=x;
            holder.background.setCardBackgroundColor(Color.parseColor(color[x]));
            holder.textView.setText(values[position]);
            holder.imageView.setImageResource(images[x%4]);
        }
    }
    //holder.book_b.setText(servicemen_bu[position]);


    @Override
    public int getItemCount() {
        return values.length;
    }

    public class RecyclerVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        ImageView imageView,next;
        CardView background;

        public RecyclerVH(View itemView) {
            super(itemView);
            next=(ImageView)itemView.findViewById(R.id.next_button);
            if(clickable==0){
                next.setVisibility(View.GONE);
            }
            background=(CardView)itemView.findViewById(R.id.bachground_pop_item);
            textView = (TextView)itemView.findViewById(R.id.topic_transparent);
            imageView = (ImageView)itemView.findViewById(R.id.image_icon_transparent);
            itemView.setOnClickListener(this);
            //book_b=(Button) itemView.findViewById(R.id.book_rqst);
        }

        @Override
        public void onClick(View view) {
            if(clickable==1){
                ((transparent_activity) mcontext).openPopUp(getAdapterPosition());
            }
        }
    }
}