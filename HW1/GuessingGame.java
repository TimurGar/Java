// By Timur Garifullin

import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
    /*
    play method simulates guessing a number game
    Parameters: max number up to which the computer will generate random number (interger)
    Returns: none
     */
    public void play(int n){
        
        Random rand = new Random();
        Scanner keyboard = new Scanner(System.in);
        int computerNumber;
        int userGuess;

        /* checking if n is 1
        this avoids the error with Random class generating number from 0 to 0 */
        if(n != 1){
            // generating random number that's between 1 and n
            computerNumber = (rand.nextInt(n - 1) + 1);
        }else{
            computerNumber = 1;
        }
    
        do{
            System.out.println("Enter your guess");
            userGuess = keyboard.nextInt();

            // Checking that user has entered number between 1 and n
            if(userGuess > n || userGuess < 1){                    
                System.out.println("Invalid number");
            }
            else{
                if(userGuess > computerNumber){
                    System.out.println("User's guess is greater than computer's");
                }
                if(userGuess < computerNumber){
                    System.out.println("User's guess is smaller than computer's");
                }
            }
        } while(userGuess != computerNumber);
        System.out.println("user's guess is equal to the computer's number");
        System.out.print("Computer's number was ");
        System.out.print(computerNumber);
    }
    
    public static void main(String [] args){
        // Creating GuessingGame object
        GuessingGame newGame = new GuessingGame();
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the limit. Max number");
        int n = keyboard.nextInt();

        // Checking whether a user has entered a number equal or less than 1
        while(n < 1){
            System.out.println("Max number should be equal or greater than 1");
            System.out.println("Enter the limit. Max number");
            n = keyboard.nextInt();
        }
        // calling play method
        newGame.play(n);

    }
}
