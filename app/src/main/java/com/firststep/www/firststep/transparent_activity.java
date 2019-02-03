package com.firststep.www.firststep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class transparent_activity extends Activity {

    card_adapter2 adapter;
    String[] val=new String[]{"",""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent_activity);
        int[] imageid={};
        int clickable=1;
        ScrollView sc=(ScrollView)findViewById(R.id.fee_structure);
        RecyclerView rv=(RecyclerView)findViewById(R.id.recyclerview_transparent);
        rv.setLayoutManager(new LinearLayoutManager(this));
        int pos=getIntent().getIntExtra("position",0);
        TextView topic=(TextView)findViewById(R.id.transparent_heading);
        RecyclerView.LayoutManager layoutManager;
        switch (pos){
            case 0:val = new String[]{"Play Group", "Pre Nursery", "Nursery", "First Half Day Care", "Second Half Day Care", "Full Day Care"};
                topic.setText("Our Programs");
                clickable=0;
                break;
            case 1:val = new String[]{"Our Programs", "Curriculum","Events", "Fee Structure","Rhythm n Blues", "Psychological Tools","Salient Features"};
                clickable=3;
                break;
            case 2:val=new String[]{"Republic Day","Christmas Carnival","Annual Day","Grand Parents Day","Birthday Celebration","Lohri","Holi","Janmashtmi","Gandhi Jayanti","Mother's Day","Friendship's Day","Halloween","Dusshera","Diwali","Children's Day","Guru Nanak Jayanti","Rakhi","Independence Day","Teacher's Day","Sport's Day"};
                topic.setText("Events");
                clickable=0;
                break;
            case 3:val = new String[]{"Our Programs", "Curriculum","Events", "Fee Structure","Rhythm n Blues", "Psychological Tools","Salient Features"};
                topic.setText("Default");
                clickable=4;
                break;
            case 4:val=new String[]{"Guitar","Singing","Violin","Piano","Dance","Drum","Theater","Chess","Vocab And Language","Abacus","Kids Aerobics","Robotics"};
                topic.setText("Thythm And Blues");
                clickable=0;
                break;
            case 5:val=new String[]{"Communication","Gross Motor","Fine Motor","Cognitive","Sensory","Social","Logical Reasoning","Balance","Imagination","Thinking And Problem Solving","Academic","Confidence"};
                topic.setText("Psycological Tools");
                break;
        }
        if(clickable==0||clickable==1) {
            adapter = new card_adapter2(this, 1,clickable, val, imageid);
            rv.setAdapter(adapter);
            sc.setVisibility(View.GONE);
        }else if(clickable==4)
        {
            topic.setVisibility(View.GONE);
            rv.setVisibility(View.GONE);
        }
        else{
            adapter = new card_adapter2(this, 1, clickable, val, imageid);
            rv.setAdapter(adapter);
            sc.setVisibility(View.GONE);
        }
    }

    public void openPopUp(int pos){
        Intent i =new Intent(this,PopUp2.class);
        i.putExtra("topic",val[pos]);
        startActivity(i);
    }
}
