/**
 * A class to create an Account
 * @author Timur Garifullin
 */
public class Account {
    private int id;    
    private double balance;
    private double annualInterestRate;

    /**
     * Default constructor that sets
     * the variables to 0
     * 
     */
    public Account(){
        id = 0;
        balance = 100;
        annualInterestRate = 0;
    }

    /**
     * Another constructor for the account class
     * @param id is the id of an account
     * @param balance is the balance of an account
     * @param annualInterstRate is the current interest rate of an account
     */
    public Account(int id, double balance, double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }
    /** 
     * An accessor for the data field id
     * @return returns the id of an account
     */
    public int getId(){
        return id;
    }
    /** 
     * An accessor for the data field balance
     * @return returns the balance of an account
     */
    public double getBalance(){
        return balance;
    }
    /** 
     * An accessor for the data field annualInterestRate
     * @return returns the current interest rate of an account
     */
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    /** 
     * A mutator for the data field id 
     * @param id is the id of an account
     */
    public void changeId(int id){
        this.id = id;
    }
    /** 
     * A mutator for the data field balance
     * @param balance is the balance of an account
     */
    public void changeBalance(double balance){
        this.balance = balance;
    }
    /** 
     * A mutator for the data field annualInterestRate
     * @param annualInterstRate is the current interest rate of an account
     */
    public void changeAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    /**
     * Computes and returns monthly interest rate
     * @return monthly interest rate
     */
    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }
    /**
     * Computes and returns monthly interest 
     * @return monthly interest 
     */
    public double getMonthlyInterest(){
        return balance * (getAnnualInterestRate() / 100);
    }
    /**
     * Withdraws a specified amount from the account 
     * @param withdrawAmount amount to be withdrawed from the account
     */
    public void withdraw(double withdrawAmount){
        balance = balance - withdrawAmount;
    }
    /**
     * Deposits a specified amount to the account 
     * @param depositAmount amount to be deposited to the account
     */
    public void deposit(double depositAmount){
        balance = balance + depositAmount;
    }

}

