package com.example.vuminhduc.duoihinhbatchu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.vuminhduc.duoihinhbatchu.MainActivity.diem;
import static com.example.vuminhduc.duoihinhbatchu.MainActivity.tim;

/**
 * Created by vuminhduc on 04/03/2017.
 */

public class actFirst extends AppCompatActivity implements View.OnClickListener {

    ImageView imgAva, heart ;
    TextView score, live, play ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first);
        initsControls() ;
        initsEvents() ;
    }


    private void initsControls() {
        //imgAva = (ImageView) findViewById(R.id.ava) ;
        heart = (ImageView) findViewById(R.id.heart) ;

        score = (TextView) findViewById(R.id.score) ;
        live = (TextView) findViewById(R.id.tim) ;
        play = (TextView) findViewById(R.id.play) ;
    }

    private void initsEvents() {

        play.setOnClickListener(this);
        score.setText("" + diem);
        live.setText("" + tim );

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class) ;
        this.startActivity(intent);

    }
}
