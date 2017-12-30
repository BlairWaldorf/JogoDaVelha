package com.example.jeffersonmendes.jogodavelha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //1:PhiPhi piece(white) 2: Sharon Piece (black)

    int[] gameState = {2,2,2,2,2,2,2,2,2}; //2 == Vazio. Não foi clicada a casa.
    int[][] winner    = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}}; //combinações possível para vitória
    int player = 0;
    boolean endGame = true;

    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString()); //verificar cliques nos campos do jogo

        if(gameState[tappedCounter] == 2 && endGame) {

            gameState[tappedCounter] = player;//seta no gameState se foi clicado com 1 ou 0

            counter.setTranslationY(-1500);

            if (player == 0) {
                counter.setImageResource(R.drawable.sharon); //seta a imagem que sera colocada no jogo
                player = 1;
            } else {
                counter.setImageResource(R.drawable.phiphi); //seta a imagem que sera colocada no jogo
                player = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            //verifica vencedor
            for (int[] winnerPosition : winner) {
                if (gameState[winnerPosition[0]] == gameState[winnerPosition[1]] &&
                    gameState[winnerPosition[1]] == gameState[winnerPosition[2]] &&
                    gameState[winnerPosition[0]] != 2) { //vitoria

                    endGame = false;

                    String w;
                    if (player == 1) {
                        w = "Sharon Needles (Black)";
                    } else {
                        w = "PhiPhi O'Hara (White)";
                    }
                    Button restart = (Button)findViewById(R.id.restart);
                    TextView winnerTextView = (TextView)findViewById(R.id.winnerTextView);
                    winnerTextView.setText(w + " Venceu!!!");
                    restart.setVisibility(View.VISIBLE);
                    winnerTextView.setVisibility(View.VISIBLE);
                }
            }
        }

    }

    public void restart(View view){
        Button restart = (Button)findViewById(R.id.restart);
        TextView winnerTextView = (TextView)findViewById(R.id.winnerTextView);
        restart.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
