package com.romethedev.bankaccount;

import java.util.Random;

public class BankAccount {
	//Users should not be able to set any of the attributes from the class.
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	private static Random random = new Random();
	public static int numberOfAccounts;
	public static int totalMoney;
	
	//In the constructor, call the private random number generator method so that each user has a random ten digit account.
	public BankAccount() {
		this.accountNumber = BankAccount.randomNumberGenerator();
		this.checkingBalance = 0;
		this.savingsBalance = 0;
		numberOfAccounts++;
	}
	
	public BankAccount (double checkingBalance, double savingsBalance) {
		this.accountNumber = BankAccount.randomNumberGenerator();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		//In the constructor, be sure to increment the account count.
		numberOfAccounts++;
		//Create a class member (static) that tracks the total amount of money stored in every account created.
		totalMoney += (this.checkingBalance + this.savingsBalance);
	}
	
	//Create a private method that returns a random ten digit account number.
	private static String randomNumberGenerator() {
		return Integer.toString(random.nextInt((1000000000)+1000000000));
	}
	
	//Create a class member (static) that has the number of accounts created thus far
	public static int countAccounts() {
		return numberOfAccounts;
	}
	
	//Create a getter method for the user's checking account balance.
	public double getCheckingBalance() {
		return checkingBalance;
	}
	//setter
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	
	//Create a getter method for the user's saving account balance.
	public double getSavingsBalance() {
		return checkingBalance;
	}
	//setter
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	//Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
	//This bitwise inclusive OR operator is |
	public void depositMoney(double depositAmount, String accountType) {
		if (accountType == "checkingBalance" || accountType == "checking") {
			this.checkingBalance += depositAmount;
			totalMoney += depositAmount;
			System.out.println("$" + depositAmount + " was deposited into checking account #" + this.accountNumber);
		} else if (accountType == "savingsAccount" || accountType == "savings") {
			this.savingsBalance += depositAmount;
			totalMoney += depositAmount;
			System.out.println("$" + depositAmount + " was deposited into savings account #" + this.accountNumber);
		} else {
			System.out.println("Not a valid account");
		}
	}
	
	//Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
	public void withdrawMoney(double withdrawAmount, String accountType) {	//withdraw method with params of amount and account type
		//Start of Checking Account Portion
		if (accountType == "checkingBalance" || accountType == "checking") {	//if account type is checking Balance or checking proceed
			if (withdrawAmount <= this.checkingBalance) {	//check for sufficient funds
				this.checkingBalance -= withdrawAmount; //withdraw the money and reduce balance
				totalMoney -= withdrawAmount; //reduce our total account balance as well
				System.out.println("$" + withdrawAmount + " was withdrawn from checking account #" + this.accountNumber);
			} else {
				System.out.println("Account #: " + this.accountNumber + " has insufficient funds to proceed.");
				System.out.println("Please try again with an amount less than " + this.getCheckingBalance());
			}
			//End of CheckingAccount Portion
			//Start of SavingAccount Portion
		} else if (accountType == "savingsBalance" || accountType == "savings") {
			if (withdrawAmount <= this.savingsBalance) {
				this.savingsBalance -= withdrawAmount;
				totalMoney -= withdrawAmount;
				System.out.println("$" + withdrawAmount + " was withdrawn from savings account #" + this.accountNumber);
			} else {
				System.out.println("Account #: " + this.accountNumber + " has insufficient funds to proceed.");
				System.out.println("Please try again with an amount less than " + this.getSavingsBalance());
			}
			//End of SavingAccount Portion
		} else {
			System.out.println("Error. Cancelling Transaction.");
		}
	}
	
	//Create a method to see the total money from the checking and saving.
	public void accountBalance() {
		System.out.println("Total balance for Account # " + this.accountNumber + " is: $" + (this.getCheckingBalance() + this.getSavingsBalance()));
	}
	
}
