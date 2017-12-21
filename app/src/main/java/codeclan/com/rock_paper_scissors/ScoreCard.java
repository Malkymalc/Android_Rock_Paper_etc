package codeclan.com.rock_paper_scissors;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by user on 20/12/2017.
 */

public class ScoreCard implements Serializable {

    private int playerScore;
    private int computerScore;

    public ScoreCard() {
        this.playerScore = 10;
        this.computerScore = 10;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public void playerWin(){
        playerScore++;
    }

    public void computerWin(){
        computerScore++;
    }

    public void resetScores(){
        Log.d("game", "resetScores has been invoked");
        setPlayerScore(0);
        setComputerScore(0);
    }

}
