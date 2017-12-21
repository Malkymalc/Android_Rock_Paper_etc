package codeclan.com.rock_paper_scissors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GameResultActivity extends AppCompatActivity {

    ScoreCard scoreCard;
    TextView playerCount;
    TextView computerCount;

    TextView playerChoice;
    TextView computerChoice;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        playerCount = findViewById(R.id.playerCount);
        computerCount = findViewById(R.id.computerCount);
        playerChoice = findViewById(R.id.playerChoice);
        computerChoice = findViewById(R.id.computerChoice);
        result = findViewById(R.id.result);

        // 1. Get extras
        Bundle extras = getIntent().getExtras();
            String playerIntent = extras.getString("player choice");
            String computerIntent = extras.getString("computer choice");
            String resultIntent = extras.getString("result");
            scoreCard = (ScoreCard) extras.getSerializable("scoreCard");

        // 2. Set Extras
        playerChoice.setText(String.format("Player chose: %s", playerIntent));
        computerChoice.setText(String.format("Computer chose: %s", computerIntent));
        result.setText(String.format("Result: %s", resultIntent));

        //3. Set scores
            playerCount.setText(String.valueOf(scoreCard.getPlayerScore()));
            computerCount.setText(String.valueOf(scoreCard.getComputerScore()));
    }

    public void onPlayAgainClick(View v){
        Intent intent = new Intent(this, GameChooseActivity.class);
        intent.putExtra("scoreCard", scoreCard);
        startActivity(intent);
    }

    public void onReset(View v){
        scoreCard.resetScores();
        playerCount.setText(String.valueOf(scoreCard.getPlayerScore()));
        computerCount.setText(String.valueOf(scoreCard.getComputerScore()));
    }
}
