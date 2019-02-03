package com.firststep.www.firststep;


import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Customadapter extends RecyclerView.Adapter<Customadapter.RecyclerVH> {
    private Context mcontext;
    private final String[] values;
    private final int[] imageid;
    private int lay,type;
    public  Customadapter(Context m, int l, int t, String[] values, int[] imageid)
    {
        type=t;
        lay=l;
        mcontext = m;
        this.imageid = imageid;
        this.values = values;
    }
    public RecyclerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(lay,parent,false);
        return new Customadapter.RecyclerVH(v);
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
    @Override
    public void onBindViewHolder(RecyclerVH holder, int position) {
        if(type==1) {
            holder.textView.setText(values[position]);
            holder.imageView.setImageResource(imageid[position]);
        }else{
           holder.imageView2.setImageBitmap(loadImageFromStorage(position));
        }
    }
    //holder.book_b.setText(servicemen_bu[position]);
    @Override
    public int getItemCount() {
        return imageid.length;
    }
    public class RecyclerVH extends RecyclerView.ViewHolder  implements View.OnClickListener
    {
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        public RecyclerVH(View itemView) {
            super(itemView);
            if(type==1){
                 textView = (TextView) itemView.findViewById(R.id.option_text);
                 imageView = (ImageView)itemView.findViewById(R.id.circle_option_image);
            }else{
                imageView2 = (ImageView)itemView.findViewById(R.id.gallery_card);
            }
            itemView.setOnClickListener(this);
            //book_b=(Button) itemView.findViewById(R.id.book_rqst);
        }
        @Override
        public void onClick(View view){
            if(type==1){
                if(getAdapterPosition()!=1){
                    ((MainActivity) mcontext).openTransparentActivity(getAdapterPosition());
                }else{
                    ((MainActivity) mcontext).openPopUp("Curriculum");
                }

            }
        }
    }
    private Bitmap loadImageFromStorage(int i)
    { Bitmap b = null;
        ContextWrapper cw = new ContextWrapper(mcontext);
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
            File mypath = new File(directory, "image"+i+".jpg");
            try {
                b = BitmapFactory.decodeStream(new FileInputStream(mypath));
                return b;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        return b;
    }
}
