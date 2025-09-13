package entities;

import java.time.LocalDate;

import exceptions.InsufficientBalanceException;


public class SavingsAccount extends Account {
	private double yieldRate;

	public SavingsAccount(String owner, int numberAccount, double balance, LocalDate creationDate) {
		super(owner, numberAccount, balance, creationDate);
		this.yieldRate = 0.02;
	}

	public double getYieldRate() {
		return yieldRate;
	}

	public void setYieldRate(double yieldRate) {
		this.yieldRate = yieldRate;
	}
	
	public double addMonthlyInterest() {
		balance += getBalance() * yieldRate;

		return balance;
	}

	@Override
	public double withdraw(double amount) throws InsufficientBalanceException {
		if ((balance - amount) < 0) {
			throw new InsufficientBalanceException("Error: Insufficient balance! ");
		}
		balance -= amount;
		return balance;
	}
	
}
