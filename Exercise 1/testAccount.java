/**
 * A class to test an Account.java file
 * @author Timur Garifullin
 */
public class testAccount {
    public static void main(String[] args) {
        Account account1 = new Account();
        System.out.println("account1 id: " + account1.getId());
        System.out.println("account1 balance: $" + account1.getBalance());
        System.out.println("account1 annual interest rate: " + account1.getAnnualInterestRate() + "%");

        Account account2 = new Account(1122, 20000, 4.5);
        System.out.println("account2 id: " + account2.getId());
        System.out.println("account2 balance: $" + account2.getBalance());
        System.out.println("account2 annual interest rate: " + account2.getAnnualInterestRate() + "%");

        account2.withdraw(2000);
        System.out.println("balance: $" + account2.getBalance());

        account2.deposit(3000);
        System.out.println("balance: $" + account2.getBalance());

        System.out.println("id: " + account2.getId());
        System.out.println("balance: $" + account2.getBalance());
        System.out.println("monthly interest rate: " + account2.getMonthlyInterestRate() + "%");
        System.out.println("monthly interest: $" + account2.getMonthlyInterest());
    }
}
