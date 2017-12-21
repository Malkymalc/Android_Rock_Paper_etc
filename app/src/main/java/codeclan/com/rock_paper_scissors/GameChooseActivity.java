package codeclan.com.rock_paper_scissors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class GameChooseActivity extends AppCompatActivity {

    ScoreCard scoreCard;
    TextView playerCount;
    TextView computerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_choose);
        playerCount = findViewById(R.id.playerCount);
        computerCount = findViewById(R.id.computerCount);

        // 1. Create blank scoreCard or use the one from intent if intent is present
        scoreCard = new ScoreCard();

        Intent intent = getIntent();
        if (intent.getSerializableExtra("scoreCard") != null) {
            scoreCard = (ScoreCard) intent.getSerializableExtra("scoreCard");
        }

        // 2. Set the score cards based on scoreCard
            playerCount.setText(String.valueOf(scoreCard.getPlayerScore()));
            computerCount.setText(String.valueOf(scoreCard.getComputerScore()));
    }



    public void onButtonClick(View v){

        // 1. Get Player Input
        String playerChoice = String.valueOf(v.getContentDescription());

        // 2a. Reset Scores if reset button pressed
        if (Objects.equals(playerChoice, "Reset")) {
            Log.d("game", "reset button pressed");
            Log.d("game", String.valueOf(scoreCard.getPlayerScore()));
            scoreCard.resetScores();
            playerCount.setText(String.valueOf(scoreCard.getPlayerScore()));
            computerCount.setText(String.valueOf(scoreCard.getComputerScore()));
            return;
        }

        // 2b. Get result and update scores if selection made
          GameEngine game = new GameEngine(playerChoice);
          String result = game.getResult();
          Log.d("game", result);
          Log.d("game", scoreCard.toString());
          if (Objects.equals(result, "Player Wins")) { scoreCard.playerWin(); }
          else if (Objects.equals(result, "Computer Wins")) { scoreCard.computerWin(); }


        // 3. Pass details to the answer page
        Intent intent = new Intent(this, GameResultActivity.class);
        intent.putExtra("player choice", game.getPlayerChoice());
        intent.putExtra("computer choice", game.getComputerChoice());
        intent.putExtra("result", result);
        intent.putExtra("scoreCard", scoreCard);
        startActivity(intent);
    }

}
