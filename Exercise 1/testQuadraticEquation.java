import java.util.Scanner;
/**
 * A class to test an QuadraticEquation.java file
 * @author Timur Garifullin
 */
public class testQuadraticEquation {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = keyboard.nextDouble();
        System.out.print("Enter b: ");
        double b = keyboard.nextDouble();
        System.out.print("Enter c: ");
        double c = keyboard.nextDouble();

        QuadraticEquation equation1 = new QuadraticEquation(a, b, c);
        double discriminant = equation1.getDiscriminant();

        if (discriminant > 0){
            System.out.println("the roots are " + equation1.getRoot1() + " and " + equation1.getRoot2());
        }
        else if(discriminant == 0){
            System.out.println("the equation has one root " + equation1.getRoot1());
        }
        else {
            System.out.println("The equation has no roots");
        }
    }
}
