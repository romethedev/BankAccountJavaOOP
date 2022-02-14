package com.romethedev.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount bankaccount1 = new BankAccount();
		BankAccount bankaccount2 = new BankAccount(2000, 7500);
		BankAccount bankaccount3 = new BankAccount(850, 237);
		
		//Total customers
		System.out.println("Currently we have a total of " + BankAccount.numberOfAccounts + " customer accounts");
		
		//Show current balance
		bankaccount1.accountBalance();
		bankaccount2.accountBalance();
		bankaccount3.accountBalance();
		
		//Lets make some transactions
		bankaccount1.depositMoney(1700, "checking");
		bankaccount2.withdrawMoney(271.78, "checking");
		bankaccount3.withdrawMoney(120, "savings");
		
		//Show new balances
		bankaccount1.accountBalance();
		bankaccount2.accountBalance();
		bankaccount3.accountBalance();
		
	}

}
