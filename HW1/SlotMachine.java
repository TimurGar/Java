// By Timur Garifullin

import java.util.Random;
import java.util.Scanner;
public class SlotMachine {
    public static void main(String [] args){
        // creating a string array with all possible word options to optimize the code
        String[] images = {"Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"};
        boolean playAgain = true;
        Random rand = new Random(1);
        String gameStatus;
        float totalAmountWon = 0;
        float totalAmountSpent = 0;

        // checking if the user wants to play again 
        while (playAgain == true){
            System.out.print("How much do you want to play for? ");
            Scanner keyboard = new Scanner(System.in);
            int moneyInp = keyboard.nextInt();
            float currentWin = 0;

            // generating three random word options
            String fruit1 = images[rand.nextInt(5)];
            String fruit2 = images[rand.nextInt(5)];
            String fruit3 = images[rand.nextInt(5)];
            System.out.print(fruit1 + " ");
            System.out.print(fruit2 + " ");
            System.out.println(fruit3);

            // checking if all 3 fruits are the same
            if (fruit1 == fruit2 && fruit1 == fruit3){
                currentWin = moneyInp * 3;
            }
            // checking if none of 3 fruits are the same
            if (fruit1 != fruit2 && fruit1 != fruit3 && fruit2 != fruit3){
                currentWin = moneyInp * 2;
            }

            // adding current win & spendings to total wins & spendings 
            totalAmountWon += currentWin;
            totalAmountSpent += moneyInp;

            System.out.println("current win: " + currentWin);

            // checking if the user wants to play again
            System.out.print("play again? ");
            gameStatus = keyboard.next();
            if (gameStatus.equalsIgnoreCase("no")){
                playAgain = false;
            }
            System.out.println();
        
        }
        System.out.println("total amount spent: " + totalAmountSpent);
        System.out.println("total amount won: " + totalAmountWon);
    }
}