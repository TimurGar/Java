import java.util.Scanner;

/**
 * A class that rearranges the data in descending order 
 * and calculates the mean for the data set
 * @author Timur Garifullin
 */
public class Average{
    int[] data = new int[5];
    double mean;
    Scanner keyboard = new Scanner(System.in);

    /**
     * Default constructor that asks user to enter 5 score numbers,
     * sorts the data, and calculates mean of entered scores
     */ 
    public Average(){
        int userIndex;
        for(int i = 0; i < 5; i++){
            userIndex = i + 1;
            System.out.print(" enter score number " + userIndex + ": ");
            data[i] = keyboard.nextInt();
        } 
        System.out.println();

        selectionSort(); 
        calculateMean();
        System.out.println("mean: " + mean);
    }

    /**
     * constructor that initializes data, accepts array of integers,
     * sorts the data, and calculates mean
     * @param data array of scores
     */
    public Average(int [] data){
        this.data = data;
        selectionSort();
        calculateMean();
        System.out.println("mean: " + mean);
    }

    /**
     * Method  to rearrange 
     * the data set from highest to lowest,
     * uses selections sort algorithm 
     */
    public void selectionSort(){
        for(int i = 0; i < data.length-1; i++){
            int max = i;
            for(int j = i; j < data.length; j++){
                if(data[j] > data[max]){
                    max = j;
                }
            }
            int temp = data[i];
            data[i] = data[max];
            data[max] = temp;
        }
    }   

    /**
     * Method to calculate the mean of scores
     */
    public void calculateMean(){
        double total = 0;
        for(int num : data){
            total += num;
        }
        mean = total / data.length;
    }

    /**
     * Method for displaying a string containing 
     * scores in descending order and the mean of scores
     * @return result string containing data (scores) and the mean
     */

    public String toString(){
        String result = "Array contains data: ";
        for(int i = 0; i < data.length; i++){
            result += data[i] + " ";
        }
        result += "and the mean is " + mean;
        return result;
    }
}