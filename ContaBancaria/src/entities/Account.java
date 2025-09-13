package entities;

import java.time.LocalDate;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmount;

public abstract class Account {
	private String owner;
	private int numberAccount;
	protected double balance;
	protected LocalDate creationDate;

	public Account(String owner, int numberAccount, double balance, LocalDate creationDate) {
		
		this.owner = owner;
		this.numberAccount = numberAccount;
		this.balance = balance;
		this.creationDate = creationDate;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(int numberAccount) {
		this.numberAccount = numberAccount;
	}

	public double getBalance() {
		return balance;
	}

	public double deposit(double amount) throws InvalidAmount {
		
		if(amount <= 0) {
			throw new InvalidAmount("Error: Insert an amount valid!");
		}
		
		return balance += amount;
	}

	public abstract double withdraw(double amount) throws InsufficientBalanceException;
	
}
