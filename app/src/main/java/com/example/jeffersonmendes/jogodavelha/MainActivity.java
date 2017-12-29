package com.example.jeffersonmendes.jogodavelha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //1:PhiPhi piece(white) 2: Sharon Piece (black
    int player = 0;

    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);

        if(player == 0)
        {
            counter.setImageResource(R.drawable.sharon);
            player = 1;
        }
        else
        {
            counter.setImageResource(R.drawable.phiphi);
            player = 0;
        }
        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
