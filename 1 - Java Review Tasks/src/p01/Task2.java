// Ben Bollinger, Task2.java, 9/12/2019 

/* DESCRIPTION:
 * This program contains a class called Account, which keeps track of a user's ID, balance, annual interest rate, and the date their
 * account was created. It has getter and setter methods for all the variables, a method that get's the monthly interest rate by dividing
 * the annual one by 12, a method for depositing money (which just adds to the balance), a method for withdrawing money (which subtracts
 * from the balance), and a method that prints the balance, monthly interest rate, and creation date. */

package p01;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task2 {
    public static void main(String[] args){
    	
    	// instantiate class:
        Account myAccount = new Account(1122, 20000);
        myAccount.setAnnualInterestRate(0.045);
        myAccount.withdraw(2500);
        myAccount.deposit(3000);
        myAccount.printInfo();
    }
}

// account class
class Account{

	// needed variables:
    private int id;
    private double balance;
    private double annualInterestRate;
    String dateCreated;

    Account(){
    }

    Account(int ID, double bal){
        id = ID;
        balance = bal;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        dateCreated = dtf.format(now).toString();
    }

    public void setID(int ID){
        id = ID;
    }

    public void setBalance(double bal){
        balance = bal;
    }

    public void setAnnualInterestRate(double annual){
        annualInterestRate = annual;
    }

    public int getID(){
        return id;
    }

    public double getBalance(){
        return balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(int amount){
        balance -= amount;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void printInfo(){
        System.out.println("Balance is " + balance + "\nMonthly interest is " + getMonthlyInterest()
        + "\nAccount " + id + " was created on " + dateCreated);
    }
}