package codeclan.com.rock_paper_scissors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by user on 20/12/2017.
 */

public class GameEngine {

    private String playerChoice;
    private String computerChoice;
    private ArrayList<String> computerOptions;
    private HashMap< String, HashMap<String, String> > referee;

    public GameEngine(String playerChoice) {
        this.playerChoice = playerChoice;
        this.computerOptions = new ArrayList<>();
        computerOptions.add("Rock");
        computerOptions.add("Paper");
        computerOptions.add("Scissors");
        computerOptions.add("Lizard");
        computerOptions.add("Spock");
        this.computerChoice = computerChoose();
        this.referee = new HashMap<>();



        //Rock crushes lizard, Spock vaporizes rock

        HashMap<String, String> rock = new HashMap<>();
        rock.put("Rock","Draw");
        rock.put("Paper", "Computer Wins");
        rock.put("Scissors", "Player Wins");
        rock.put("Lizard", "Player Wins");
        rock.put("Spock", "Computer Wins");
        referee.put("Rock", rock);

        //Lizard eats paper, paper disproves spock

        HashMap<String, String> paper = new HashMap<>();
        paper.put("Rock","Player Wins");
        paper.put("Paper", "Draw");
        paper.put("Scissors", "Computer Wins");
        paper.put("Lizard", "Computer Wins");
        paper.put("Spock", "Player Wins");
        referee.put("Paper", paper);

        //Scissors decapitates lizard, spock smashes scissors

        HashMap<String, String> scissors = new HashMap<>();
        scissors.put("Rock","Computer Wins");
        scissors.put("Paper", "Player Wins");
        scissors.put("Scissors", "Draw");
        scissors.put("Lizard", "Player Wins");
        scissors.put("Spock", "Computer Wins");
        referee.put("Scissors", scissors);

        // Spock
        HashMap<String, String> lizard = new HashMap<>();
        lizard.put("Rock","Computer Wins");
        lizard.put("Paper", "Player Wins");
        lizard.put("Scissors", "Computer Wins");
        lizard.put("Lizard", "Draw");
        lizard.put("Spock", "Player Wins");
        referee.put("Lizard", lizard);

        // Lizard
        HashMap<String, String> spock = new HashMap<>();
        spock.put("Rock","Player Wins");
        spock.put("Paper", "Computer Wins");
        spock.put("Scissors", "Player Wins");
        spock.put("Lizard", "Computer Wins");
        spock.put("Spock", "Draw");
        referee.put("Spock", spock);
    }

    public HashMap getReferee(){
        return referee;
    }


    public String getPlayerChoice() {
        return playerChoice;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public String computerChoose(){
        Collections.shuffle(computerOptions);
        return computerOptions.get(0);
    }

    public String getResult(){
        return referee.get(playerChoice).get(computerChoice);
    }

}
