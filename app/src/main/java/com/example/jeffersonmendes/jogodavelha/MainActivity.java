package com.example.jeffersonmendes.jogodavelha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1:PhiPhi piece(white) 2: Sharon Piece (black)

    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winner    = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
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

        for(int[] winnerPosition: winner)
        {
            if(gameState[winnerPosition[0]] == gameState[winnerPosition[1]] && gameState[winnerPosition[1]] ==gameState[winnerPosition[2]] && gameState[winnerPosition[0]] != 2){
               //vitoria
                String w;
                if(player == 1){
                    w = "Black";
                }else{
                    w = "White";
                }
                Toast.makeText(this, w + "venceu!!! " ,Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
