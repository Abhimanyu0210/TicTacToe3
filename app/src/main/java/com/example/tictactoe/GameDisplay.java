package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button playAgainBTN = findViewById(R.id.play_again);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button homeBTN = findViewById(R.id.home_button);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView playerTurn = findViewById(R.id.player_display);

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if (playerNames != null){
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard2);

        ticTacToeBoard.setUpGame(playAgainBTN, homeBTN, playerTurn,playerNames);
    }
    public void playAgainButtonClick(View view){
       ticTacToeBoard.resetGame();
       ticTacToeBoard.invalidate();
    }
    public void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}