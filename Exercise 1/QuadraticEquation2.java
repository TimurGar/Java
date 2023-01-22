
import java.util.Scanner;
import java.lang.Math;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    // creating a default constructor
    //  set variables to 0
    public QuadraticEquation(){

    }
    public QuadraticEquation(double a, double b, double c){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a:");
        a = keyboard.nextInt();
        System.out.print("Enter b:");
        b = keyboard.nextInt();
        System.out.print("Enter c:");
        c = keyboard.nextInt();
    }
    // method that returns the discriminant
    public double getDiscriminant(double a, double b, double c){
        double discriminant = Math.pow(b, 2) - 4*a*c;
        return discriminant;
    }
    // method that returns first root of the equation
    public double getRoot1(double a, double b, double discriminant){
        double root1 = 0;
        if (discriminant > 0){
            root1 = (-b + Math.sqrt(discriminant)) / 2*a;
        }
        return root1;
    }
    // method that returns second root of the equation
    public double getRoot2(double a, double b, double discriminant){
        double root2 = 0;
        if (discriminant > 0){
            root2 = (-b - Math.sqrt(discriminant)) / 2*a;
        }
        return root2;
    }

    public static void main(String[] args) {
        QuadraticEquation equation1 = new QuadraticEquation()
    }
}