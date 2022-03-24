package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Represents the internal state of the game
    private TicTacToeGame mGame;
    // Buttons making up the board
    private Button mBoardButtons[];
    // Various text displayed
    private TextView mInfoTextView;
    // Restart Button
    private Button startButton,backMusic, stopMusic,clearAndRestart;
    // Game Over
    Boolean mGameOver;

    // show current level
    private TextView currentLevel,yourWinTime,androidWinTime,tieTime;

    private MediaPlayer mediaPlayer;
    private int winner;
    private String lastBboard;
    private int lastLevel;
    private int lastTieTime;
    private int lastComputerWinTime;
    private int lastYourWinTime;
    private int lastWinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGame = new TicTacToeGame();
        mBoardButtons = new Button[mGame.BOARD_SIZE];
        mBoardButtons[0] = (Button) findViewById(R.id.button0);
        mBoardButtons[1] = (Button) findViewById(R.id.button1);
        mBoardButtons[2] = (Button) findViewById(R.id.button2);
        mBoardButtons[3] = (Button) findViewById(R.id.button3);
        mBoardButtons[4] = (Button) findViewById(R.id.button4);
        mBoardButtons[5] = (Button) findViewById(R.id.button5);
        mBoardButtons[6] = (Button) findViewById(R.id.button6);
        mBoardButtons[7] = (Button) findViewById(R.id.button7);
        mBoardButtons[8] = (Button) findViewById(R.id.button8);
        mInfoTextView = (TextView) findViewById(R.id.information);
        currentLevel = (TextView) findViewById(R.id.levelShow);
        yourWinTime = (TextView) findViewById(R.id.yourWinTime);
        androidWinTime = (TextView) findViewById(R.id.androidWinTime);
        tieTime = (TextView) findViewById(R.id.tieTime);
        startButton = (Button) findViewById(R.id.button_restart);
        backMusic = (Button) findViewById(R.id.backMusic);
        stopMusic = (Button) findViewById(R.id.stopMusic);
        clearAndRestart = (Button)findViewById(R.id.clear);
        //start button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewGame();
                // get a random start
                Random random = new Random();
                if(random.nextInt(2)==1){
                    mInfoTextView.setText(R.string.Androids_turn);
                    int move = mGame.getComputerMove();
                    setMove(TicTacToeGame.COMPUTER_PLAYER, move);
                    mInfoTextView.setTextColor(Color.rgb(0, 0, 0));
                    mInfoTextView.setText(R.string.your_turn);
                    savePreferences();
                }
            }


        });
        //start back music
        backMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer == null) {
                    Uri uri = Uri.parse("android.resource://"
                            + getPackageName() + "/" + R.raw.backmusic);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
                    mediaPlayer.start();
                }else{
                    mediaPlayer.start();
                }
            }

        });
        // stop back music
        stopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }

        });

        // clear all record
        clearAndRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGame.level = 0;
                currentLevel.setText(mGame.getLevel());
                yourWinTime.setText(Integer.valueOf(0).toString());
                mGame.yourWinTime = 0;
                tieTime.setText(Integer.valueOf(0).toString());
                mGame.tieTime = 0;
                androidWinTime.setText(Integer.valueOf(0).toString());
                mGame.computerWinTime = 0;
                startNewGame();
                savePreferences();
            }

        });
        startNewGame();

    }

    // here I load data and if there is a continuing game, it will change the UI
    @Override
    protected void onStart() {
        super.onStart();
        loadPreferences();
        mGame.level = lastLevel;
        currentLevel.setText(mGame.getLevel());
        yourWinTime.setText(Integer.valueOf(lastYourWinTime).toString());
        mGame.yourWinTime = lastYourWinTime;
        tieTime.setText(Integer.valueOf(lastTieTime).toString());
        mGame.tieTime = lastTieTime;
        androidWinTime.setText(Integer.valueOf(lastComputerWinTime).toString());
        mGame.computerWinTime = lastComputerWinTime;
        if(lastWinner == 0){
            mGame.mBoard = lastBboard.toCharArray();
            for (int i = 0; i < mBoardButtons.length; i++) {
                if(lastBboard.charAt(i)==TicTacToeGame.HUMAN_PLAYER){
                    mBoardButtons[i].setText(String.valueOf(TicTacToeGame.HUMAN_PLAYER));
                    mBoardButtons[i].setEnabled(false);
                    mBoardButtons[i].setTextColor(Color.rgb(0, 200, 0));
                }else if(lastBboard.charAt(i)==TicTacToeGame.COMPUTER_PLAYER){
                    mBoardButtons[i].setText(String.valueOf(TicTacToeGame.COMPUTER_PLAYER));
                    mBoardButtons[i].setEnabled(false);
                    mBoardButtons[i].setTextColor(Color.rgb(200, 0, 0));
                }
            }
        }else{

        }


    }

    // When you turn the device, it will close the back music if it has.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }

    }

    //define the option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the aaction bar if it is present
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true; }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.level0:
                mGame.setLevel(0);
                startNewGame();
                return true;
            case R.id.level1:
                mGame.setLevel(1);
                startNewGame();
                return true;
            case R.id.level2:
                mGame.setLevel(2);
                startNewGame();
                return true;
            case R.id.menu_exit:
                finish();
                return true;
        }
        return false; }



    //--- Set up the game board.
    private void startNewGame() {
        mGameOver = false;
        mGame.clearBoard();
        currentLevel.setText(mGame.getLevel());
        //---Reset all buttons
        for (int i = 0; i < mBoardButtons.length; i++) {
            mBoardButtons[i].setText("");
            mBoardButtons[i].setEnabled(true);
            mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));

        }
        //---Human goes first
        mInfoTextView.setText(R.string.You_go_first);

    }
    //---Handles clicks on the game board buttons
    private class ButtonClickListener implements View.OnClickListener {
        int location;
        public ButtonClickListener(int location) {
            this.location = location;
        }
        @Override
        public void onClick(View v) {
            if (mGameOver == false) {
                if (mBoardButtons[location].isEnabled()) {
                    setMove(TicTacToeGame.HUMAN_PLAYER, location);
                    //--- If no winner yet, let the computer make a move
                    winner = mGame.checkForWinner();
                    if (winner == 0) {
                        mInfoTextView.setText(R.string.Androids_turn);
                        int move = mGame.getComputerMove();
                        setMove(TicTacToeGame.COMPUTER_PLAYER, move);
                        winner = mGame.checkForWinner();
                    }
                    if (winner == 0) {
                        mInfoTextView.setTextColor(Color.rgb(0, 0, 0));
                        mInfoTextView.setText(R.string.your_turn);
                        savePreferences();
                    } else if (winner == 1) {
                        mInfoTextView.setTextColor(Color.rgb(0, 0, 200));
                        mInfoTextView.setText(R.string.tie);
                        mGame.setTieTime();
                        tieTime.setText(mGame.getTieTime());
                        mGameOver = true;
                        savePreferences();
                    } else if (winner == 2) {
                        mInfoTextView.setTextColor(Color.rgb(0, 200, 0));
                        mInfoTextView.setText(R.string.You_won);
                        mInfoTextView.animate().scaleX(1.5f).scaleY(1.5f).setDuration(2000);
                        mGame.setYourWinTime();
                        yourWinTime.setText(mGame.getYourWinTime());
                        mGameOver = true;
                        savePreferences();
                    } else {
                        mInfoTextView.setTextColor(Color.rgb(200, 0, 0));
                        mInfoTextView.setText(R.string.Android_won);
                        mInfoTextView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
                        mGame.setComputerWinTime();
                        androidWinTime.setText(mGame.getComputerWinTime());
                        mGameOver = true;
                        savePreferences();
                    }
                }
            }
        } }
    private void setMove(char player, int location) {
        mGame.setMove(player, location);
        mBoardButtons[location].setEnabled(false);
        mBoardButtons[location].setText(String.valueOf(player));
        if (player == TicTacToeGame.HUMAN_PLAYER)
            mBoardButtons[location].setTextColor(Color.rgb(0, 200, 0));
        else
            mBoardButtons[location].setTextColor(Color.rgb(200, 0, 0));
    }
    // save data
    public void savePreferences() {
        SharedPreferences pref = getSharedPreferences("Data", MODE_PRIVATE);
        pref.edit().putString("mBoard", String.valueOf(mGame.mBoard)).apply();
        pref.edit().putInt("level", mGame.level).apply();
        pref.edit().putInt("tieTime", mGame.tieTime).apply();
        pref.edit().putInt("computerWinTime", mGame.computerWinTime).apply();
        pref.edit().putInt("yourWinTime", mGame.yourWinTime).apply();
        pref.edit().putInt("winner", winner).apply();
    }
    //load data
    public void loadPreferences() {
        SharedPreferences pref = getSharedPreferences("Data", MODE_PRIVATE);
        lastBboard          = pref.getString("mBoard", "[ , , , , , , , , ]");
        lastLevel           = pref.getInt("level",0);
        lastTieTime         = pref.getInt("tieTime",0);
        lastComputerWinTime = pref.getInt("computerWinTime",0);
        lastYourWinTime     = pref.getInt("yourWinTime",0);
        lastWinner          = pref.getInt("winner",0);
    }




}