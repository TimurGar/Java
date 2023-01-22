// By Timur Garifullin

import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {
    public static final int UPPERBOUND = 3;
    public static final int SCISSORS = 0;
    public static final int ROCK = 1;
    public static final int PAPER = 2;

    /*
    play method simulates the scissors-rock-paper game
    Parameters: number entered by user (interger)
    Returns: result (outcome) of the game (string)
     */
    public String play(int userMove){
        Random rand = new Random();
        int computerMove = rand.nextInt(UPPERBOUND);

        String result;
        /*  
        Variable difference allows to reduce the number of comparisons 
        needed to determine who wins. 
        Because the inputs can only be 0,1,2 the difference between computer's score
        and user's score can either be from -2 to 2.
        */
        int difference = computerMove - userMove;

        System.out.print("Computer's Move is ");
        System.out.println(computerMove);

        // Checking if the user entered numbers other than 0,1,2
        if (userMove > PAPER || userMove < SCISSORS){
            result = "invalid entry";
        }
        
        /*
        Because constants SCISSORS, ROCK, & PAPER are defined as 0,1 & 2 (respectively)
        and the rules of this game, the pattern can be observed.
        By knowing the result of the difference (substraction) between computer's and user's 
        moves the outcome of the game be determined (see below).

        +------------+---+----+----+----+----+
        | Difference | 2 | 1  | 0  | -1 | -2 |
        +------------+---+----+----+----+----+
        | Outcome    | U | PC | DW | U  | PC |
        +------------+---+----+----+----+----+
        U: User wins; PC: Computer wins; DW: draw

         */
        else{
            /* Because the preconditions of this task required the use of variable such as ROCK
            expression -ROCK substitutes value -1. */
            if (difference == PAPER || difference == -ROCK){
                result = "User wins";
            }
            // expression -PAPER substitutes value -2
            else if (difference == ROCK || difference == -PAPER){
                result = "Computer wins";
            }
            else{
                result = "It's a draw";
            }
        }
        return result;
    }

    public static void main(String [] args){
        // Creating the RockPaperScissors object 
        RockPaperScissors newGame = new RockPaperScissors();

        System.out.println("Enter the move");
        Scanner keyboard = new Scanner(System.in);
        int userMove = keyboard.nextInt();
        
        // Calling play method
        String result = newGame.play(userMove);
        System.out.println(result);
    }
}
