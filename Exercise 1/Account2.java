public class Account {
    private int id;    
    private double balance;
    // c. A private double data field named annualInterestRate that
    // stores the current interest rate.
    private double annualInterestRate;
   
    public Account(){
        id = 0;
        balance = 100;
        annualInterestRate = 0;
    }
    // e. Another constructor that creates an account with id, initial balance,
    // and annual interest rate as parameters. Set the data fields in the
    // class to the corresponding values of the parameters.
    public Account(int initId, double initialBalance, double initAnnualInterestRate){
        id = initId;
        balance = initialBalance;
        annualInterestRate = initAnnualInterestRate;
    }
    public
    // f. The accessor and mutator methods for id, balance, and
    // annualInterestRate.
    // g. A method named getMonthlyInterestRate() that returns the
    // monthly interest rate.
    // h. A method named getMonthlyInterest() that returns the
    // monthly interest.
    // i. A void method named withdraw that withdraws a specified amount
    // from the account.
    // j. A void method named deposit that deposits a specified amount to
    // the account.

}
