package entities;

import java.time.LocalDate;

import exceptions.InsufficientBalanceException;
import exceptions.InsufficientIncomeLoanException;
import exceptions.InvalidAmount;

public class CheckingAccount extends Account {

	private double limit;
	

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public CheckingAccount(String owner, int numberAccount, double balance, LocalDate creationDate, AccountLevels accountLevel) {
		super(owner, numberAccount, balance, creationDate);

		if (accountLevel == AccountLevels.BASIC) {
			limit = 500.00;
		} else if (accountLevel == AccountLevels.SILVER) {
			limit = 1000.00;
		} else if (accountLevel == AccountLevels.GOLD) {
			limit = 2500.00;
		} else if (accountLevel == AccountLevels.PLATINUM) {
			limit = 5000.00;
		}
	}

	public double loanChecking(double income, double amount) throws InsufficientIncomeLoanException, InvalidAmount {

		if (amount > limit) {

			throw new InvalidAmount("Error: The amount exceeded the limits!");
		}
		if (income < 0.25 * amount) {

			throw new InsufficientIncomeLoanException("Error: The income is smaller than expected ");
		}
		balance += amount;
		return balance;

	}

	@Override
	public double withdraw(double amount) throws InsufficientBalanceException {
		if (balance < amount) {
			throw new InsufficientBalanceException("Error: The balance exceeded the limits!");
		}
		balance -= amount;
		return balance;
	}

}
