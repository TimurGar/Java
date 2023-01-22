/**
 * A class to solve a quadratic equation
 * @author Timur Garifullin
 */
public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    /**
     * Default constructor that sets
     * the coefficients to 0
     * 
     */
    public QuadraticEquation(){
        a = 0;
        b = 0;
        c = 0;
    }
    /**
     * Another constructor for the quadratic equation class
     * @param a is the coefficient of x^2
     * @param b is the coefficient of x
     * @param is the constant term
     */
    public QuadraticEquation(double a, double b, double c){
        // private vars = double var
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // getters give you access to private variables
    /** 
     * An accessor for the data field a
     * @return returns the coefficient of x^2
     */
    public double getA(){
        // we can write this.a as well but the it's not necessary 
        // this.a is usually written where there are local variables with the same names
        // to avoid confussion this.a can be written
        return a;
    }
    /** 
     * An accessor for the data field b
     * @return returns the coefficient of x
     */
    public double getB(){
        return b;
    }
    /** 
     * An accessor for the data field c
     * @return returns the constant term
     */
    public double getC(){
        return c;
    }
    /**
     * Computes the discriminant of the quadratic equation
     * @return the discriminant of the quadratic equation
     */
    public double getDiscriminant(){
        return b * b - 4 * a * c;
    }
    /**
     * Computes the first root of the quadratic equation
     * @return the first root of the equation
     */
    public double getRoot1(){
        double discriminant = getDiscriminant();
        double root1 = 0;
        if (discriminant >= 0)
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        return root1;
    }
    /**
     * Computers the second root of the quadratic equation
     * @return the second root of the equation
     */
    public double getRoot2(){
        double discriminant = getDiscriminant();
        double root2 = 0;
        if (discriminant >= 0)
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        return root2;
    }    

    public static void main(String[] args) {
        QuadraticEquation qe = new QuadraticEquation();
        QuadraticEquation qe2 = new QuadraticEquation(10, -1, -2);

        System.out.println("a: " + qe2.getA());
        System.out.println("b: " + qe2.getB());
        System.out.println("c: " + qe2.getC());

        System.out.println("b: " + qe.getB());
        System.out.println("a: " + qe.getA());
        System.out.println("c: " + qe.getC());

        System.out.println(qe.getDiscriminant());
        System.out.println(qe2.getDiscriminant());

        System.out.println(qe2.getRoot1());
        System.out.println(qe2.getRoot2());
    }
}
