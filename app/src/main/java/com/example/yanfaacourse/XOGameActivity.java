package com.example.yanfaacourse;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class XOGameActivity extends AppCompatActivity {

    boolean gameIsActive, someoneHasWon, gameIsOver;
    int player = 0; // 0 == O and 1==X

    int winningPosition[][] = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };
    // another writing methos of this 2d array int winningPositions [][]={{0,1,2},{3,4,5},{6,7,8},{0,3,7},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2}; // 2 = the place is free (unplayed yet)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xogame);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void dropXO(View view) {   // generated when making the onclick in the xml
        ImageView xoImage = (ImageView) view;/* this is casting
        (You tell Java: "This View is really an ImageView, so let me use it like one.")
         {view is the object that was clicked and you want it as an imageview not just view} */

        int tappedXO = Integer.parseInt(xoImage.getTag().toString());/* to know which image is tapped (we get the tag from the tapped xoImage
         and save it as int in another variable. */

        if (gameState[tappedXO] == 2) { // just if the tapped image is free not occupied
            gameState[tappedXO] = player; // start will be with the O
            xoImage.setTranslationY(-1000f);
            if (player == 0) {
                xoImage.setImageResource(R.drawable.o);
                player = 1;
            } else {
                xoImage.setImageResource(R.drawable.x);
                player = 0;
            }
            xoImage.animate().translationYBy(1000f).rotation(360).setDuration(1000);

        }
        for (int[] winningPositions : winningPosition) {
            if (gameState[winningPositions[0]] == gameState[winningPositions[1]]
                    && gameState[winningPositions[1]] == gameState[winningPositions[2]]
                    && gameState[winningPositions[0]] != 2) {
                gameIsActive = false;
                someoneHasWon = true;
                String winner = "X";
                if (gameState[winningPositions[0]] == 0) {
                    winner = "O";
                }
                TextView tv_winner = findViewById(R.id.tv_winner);
                tv_winner.setText("The Winner is " + winner);
                LinearLayout winnerLayout = findViewById(R.id.winner_layout);
                winnerLayout.setVisibility(View.VISIBLE);

            } else {
                gameIsOver = true;
                for (int state : gameState) {
                    if (state == 2) {
                        gameIsOver = false;
                    }
                }
                if (gameIsOver && !someoneHasWon) {
                    TextView tv_winner = findViewById(R.id.tv_winner);
                    tv_winner.setText("No Winner");
                    LinearLayout winnerLayout = findViewById(R.id.winner_layout);
                    winnerLayout.setVisibility(View.VISIBLE);
                }


            }
        }


    }

    public void playAgain(View view) {
        gameIsActive = true;
        someoneHasWon = false;
        LinearLayout winnerLayout = findViewById(R.id.winner_layout);
        winnerLayout.setVisibility(View.INVISIBLE);
        player = 0;
        Arrays.fill(gameState, 2);  //or the coming for loop , why we didnt use enhanced for loop? see end of the page
//        for (int i =0 ; i< gameState.length ; i++){
//            gameState[i]=2;
//        }
        GridLayout gridLayout = findViewById(R.id.gridLayout_board);
        //to remove all images in the board
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }
}

/*Use enhanced for-loop ONLY when you DO NOT modify the array
✔ Good for:

comparing values

checking values

printing values

reading values

searching for something*/