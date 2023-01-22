// By Timur Garifullin

import java.util.Scanner;
public class Pentagon{
    // method for calculating the area 
    /*
    computeArea method calculates the area of a pentagon
    Parameters: length of a side of a pentagon (integer)
    Returns: area (double)
    */
    public double computeArea(double s){
        double area = 1.0/4.0 * Math.sqrt(5.0 * (5.0 + 2.0 * Math.sqrt(5.0))) * Math.pow(s, 2);
        return area;
    }

    public static void main(String [] args){
    // Creating Pentagon object
    Pentagon myPentagon = new Pentagon();

    System.out.println("Enter the length of the side of your pentagon");
    Scanner keyboard = new Scanner(System.in);
    Double s = keyboard.nextDouble();

    // Calling computeArea method
    Double area = myPentagon.computeArea(s);
    System.out.println(area);
    }
}
