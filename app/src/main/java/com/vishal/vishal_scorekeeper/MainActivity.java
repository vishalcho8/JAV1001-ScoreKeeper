/*
Author: Vishal Upendra Chavda
App: Score keeper app
Description: Update and display Score for the two teams.

History:
28/10/2021 -    v1.0    -   Added onCreate() and onClick()  -   Initial version
*/
package com.vishal.vishal_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find and store required fields from the layout
        Button decreaseTeamRedButton = findViewById(R.id.btnTeamRedScoreDec);
        Button increaseTeamRedButton = findViewById(R.id.btnTeamRedScoreInc);

        Button decreaseTeamBlueButton = findViewById(R.id.btnTeamBlueScoreDec);
        Button increaseTeamBlueButton = findViewById(R.id.btnTeamBlueScoreInc);

        //Setting score decrease button for both the team disable initially as score will be zero when the app will start.
        decreaseTeamRedButton.setEnabled(false);
        decreaseTeamBlueButton.setEnabled(false);

        //Passing current instance to the onclick listener based on the button clicked.
        decreaseTeamRedButton.setOnClickListener(this);
        increaseTeamRedButton.setOnClickListener(this);
        decreaseTeamBlueButton.setOnClickListener(this);
        increaseTeamBlueButton.setOnClickListener(this);

    }

    public void onClick(View view) {
        //depending on which Button is clicked, increase or decrease the score for the team red or blue.

        //Initialize score variables to zero
        int teamBlueScore = 0;
        int teamRedScore = 0;


        //Find required fields from the layout
        TextView teamRedScoreTextView = findViewById(R.id.teamRedScore);
        TextView teamBlueScoreTextView = findViewById(R.id.teamBlueScore);
        Button decreaseTeamRedButton = findViewById(R.id.btnTeamRedScoreDec);
        Button decreaseTeamBlueButton = findViewById(R.id.btnTeamBlueScoreDec);
        RadioGroup pointsRedGroup = findViewById(R.id.numScoreGroupRed);
        RadioGroup pointsBlueGroup = findViewById(R.id.numScoreGroupBlue);

        //Get the current score of the team red and blue
        String teamRedCurrentScore = String.valueOf(teamRedScoreTextView.getText());
        String teamBlueCurrentScore = String.valueOf(teamBlueScoreTextView.getText());

        /* Based on the radio button selection store the points to increase or decrease
            in the variable teamRedScore. (For team RED) */
        switch(pointsRedGroup.getCheckedRadioButtonId()){
            case R.id.scoreSixRbRed: //if(checkedButton == R.id.scoreSixRbRed)
                teamRedScore = 6;
                break;
            case R.id.scoreThreeRbRed: //else if(checkedButton == R.id.scoreThreeRbRed)
                teamRedScore = 3;
                break;
            case R.id.scoreTwoRbRed: //else if(checkedButton == R.id.scoreTwoRbRed)
                teamRedScore = 2;
                break;
            case R.id.scoreOneRbRed: //else if(checkedButton == R.id.scoreOneRbRed)
            default: // else
                teamRedScore = 1;
                break;
        }

        /* Based on the radio button selection store the points to increase or decrease
            in the variable teamBlueScore. (For team BLUE) */
        switch(pointsBlueGroup.getCheckedRadioButtonId()){
            case R.id.scoreSixRbBlue: //if(checkedButton == R.id.scoreSixRbBlue)
                teamBlueScore = 6;
                break;
            case R.id.scoreThreeRbBlue: //else if(checkedButton == R.id.scoreThreeRbBlue)
                teamBlueScore = 3;
                break;
            case R.id.scoreTwoRbBlue: //else if(checkedButton == R.id.scoreTwoRbBlue)
                teamBlueScore = 2;
                break;
            case R.id.scoreOneRbBlue: //else if(checkedButton == R.id.scoreOneRbBlue)
            default: // else
                teamBlueScore = 1;
                break;
        }

        /*  1. Update the TextViews to show the score.
            2. Enable or disable the score decrease button if score goes  or negative for the particular team.
            3. Based on the button clicked either increase or decrease the score for the particular team. */
        switch (view.getId()){
            case R.id.btnTeamRedScoreDec: //if(clickedButton == R.id.btnTeamRedScoreDec)
                teamRedScore = Integer.parseInt(teamRedCurrentScore) - teamRedScore;
                if(teamRedScore <= 0){
                    teamRedScore = 0;
                    decreaseTeamRedButton.setEnabled(false);
                }
                else{
                    decreaseTeamRedButton.setEnabled(true);
                }
                teamRedScoreTextView.setText(String.valueOf(teamRedScore));
                break;
            case R.id.btnTeamRedScoreInc: //else if(clickedButton == R.id.btnTeamRedScoreInc)
                teamRedScore = Integer.parseInt(teamRedCurrentScore) + teamRedScore;
                if(teamRedScore <= 0){
                    teamRedScore = 0;
                    decreaseTeamRedButton.setEnabled(false);
                }
                else{
                    decreaseTeamRedButton.setEnabled(true);
                }
                teamRedScoreTextView.setText(String.valueOf(teamRedScore));
                break;
            case R.id.btnTeamBlueScoreDec: //else if(clickedButton == R.id.btnTeamBlueScoreDec)
                teamBlueScore = Integer.parseInt(teamBlueCurrentScore) - teamBlueScore;
                if(teamBlueScore <= 0){
                    teamBlueScore = 0;
                    decreaseTeamBlueButton.setEnabled(false);
                }
                else{
                    decreaseTeamBlueButton.setEnabled(true);
                }
                teamBlueScoreTextView.setText(String.valueOf(teamBlueScore));
                break;
            case R.id.btnTeamBlueScoreInc: //else if(clickedButton == R.id.btnTeamBlueScoreInc)
                teamBlueScore = Integer.parseInt(teamBlueCurrentScore) + teamBlueScore;
                if(teamBlueScore <= 0){
                    teamBlueScore = 0;
                    decreaseTeamBlueButton.setEnabled(false);
                }
                else{
                    decreaseTeamBlueButton.setEnabled(true);
                }
                teamBlueScoreTextView.setText(String.valueOf(teamBlueScore));
                break;
            default: //else
                Log.e("ClickEvent", "You clicked the wrong button");
                break;
        }

    }

}