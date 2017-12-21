package codeclan.com.rock_paper_scissors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 20/12/2017.*
 *  1. [Fixed] Referee is not working
 *  2. [Done] Record wins
 *  3. [Done] Expand game to ... Lizard, Spock
 *  4. Front screen with rules
 *  5. Images for buttons
 *  6. Announce what happens + result
 */

public class TestGameEngine {

    private String playerChoice1;
    private String playerChoice2;
    private String playerChoice3;
    private GameEngine gameEngine1;
    private GameEngine gameEngine2;
    private GameEngine gameEngine3;

    @Before
    public void before(){
        playerChoice1 = "Rock";
        playerChoice2 = "Paper";
        playerChoice3 = "Scissors";
        gameEngine1 = new GameEngine(playerChoice1);
        gameEngine2 = new GameEngine(playerChoice2);
        gameEngine3 = new GameEngine(playerChoice3);
    }

    @Test
    public void canGetPlayerChoice(){
        assertEquals("Rock", gameEngine1.getPlayerChoice());
        assertEquals("Paper", gameEngine2.getPlayerChoice());
        assertEquals("Scissors", gameEngine3.getPlayerChoice());
    }

    @Test
    public void canGetComputerChoice(){
        System.out.println(gameEngine1.getComputerChoice());
    }

    @Test
    public void canGetResult(){
        System.out.println(gameEngine1.getReferee());
        System.out.println("The player chooses " + gameEngine1.getPlayerChoice());
        System.out.println("The computer chooses " + gameEngine1.getComputerChoice());
        System.out.println("The result is " + gameEngine1.getResult());
    }

    @Test
    public void printReferee(){
        System.out.println(gameEngine2.getReferee());
    }
}
