package entities;

import java.time.LocalDate;

import exceptions.InsufficientBalanceException;

import exceptions.InvalidAmount;

public class BusinessAccount extends Account {
	private double loanLimit;


	public double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public BusinessAccount(String owner, int numberAccount, double balance, LocalDate creationDate, AccountLevels accountLevel) {
		super(owner, numberAccount, balance, creationDate);
		
		if (accountLevel == AccountLevels.BASIC) {
			loanLimit = 5000.00;
		} else if (accountLevel == AccountLevels.SILVER) {
			loanLimit = 10000.00;
		} else if (accountLevel == AccountLevels.GOLD) {
			loanLimit = 25000.00;
		} else if (accountLevel == AccountLevels.PLATINUM) {
			loanLimit = 50000.00;
		}
	}

	
	public double loanBusiness(double amount) throws InvalidAmount {

		if (amount > loanLimit) {

			throw new InvalidAmount("Error: The amount exceeded the limits!");
		}
		
		balance += amount;
		return balance;

	}


	@Override
	public double withdraw(double amount) throws InsufficientBalanceException {

		if (balance < amount) {
			throw new InsufficientBalanceException("Error: Insufficient balance!");

		}
		balance -= amount;
		return balance;
	}

}
