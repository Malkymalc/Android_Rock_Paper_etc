package codeclan.com.rock_paper_scissors;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 20/12/2017.
 */

public class TestScoreCard {

    ScoreCard scoreCard = new ScoreCard();

    @Test
    public void canGetScoresAtStart(){
        System.out.println(scoreCard.getPlayerScore());
        System.out.println(scoreCard.getComputerScore());
    }

    @Test
    public void canIncrementScores(){
        scoreCard.playerWin();
        scoreCard.computerWin();
        System.out.println(scoreCard.getPlayerScore());
        System.out.println(scoreCard.getComputerScore());
    }

    @Test
    public void canResetScores(){
        scoreCard.playerWin();
        scoreCard.computerWin();
        System.out.println(scoreCard.getPlayerScore());
        System.out.println(scoreCard.getComputerScore());
        scoreCard.resetScores();
        System.out.println(scoreCard.getPlayerScore());
        System.out.println(scoreCard.getComputerScore());
    }

}
