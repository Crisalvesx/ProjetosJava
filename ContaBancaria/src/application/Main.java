package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.AccountLevels;
import entities.BusinessAccount;
import entities.CheckingAccount;
import entities.SavingsAccount;
import exceptions.InsufficientIncomeLoanException;
import exceptions.InvalidAmount;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String accountType = null;
		String makeLoan = null;
		double loanValue = 0.0;

		System.out.println("Insert user's data: ");
		System.out.println("Saving account(s), Checking account(c), Business account(b)");
		System.out.print("Insert the type of account: ");

		char choice = sc.next().toLowerCase().charAt(0);

		System.out.print("Name: ");
		sc.nextLine();
		String name = sc.nextLine();

		System.out.print("Number account: ");
		int number = sc.nextInt();

		System.out.print("Balance: ");
		double value = sc.nextDouble();

		DateTimeFormatter dtw = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.now();
		System.out.println();

		System.out.println("Basic(b), Silver(s), Gold(g), Platinum(p)");
		System.out.print("What's level of account? ");

		char level = sc.next().toLowerCase().charAt(0);
		AccountLevels accountLevel = null;

		if (level == 'b') {
			accountLevel = AccountLevels.BASIC;
		} else if (level == 's') {
			accountLevel = AccountLevels.SILVER;
		} else if (level == 'g') {
			accountLevel = AccountLevels.GOLD;
		} else if (level == 'p') {
			accountLevel = AccountLevels.PLATINUM;
		} else {
			System.out.println("Error: Invalid digit!");

		}

		if (choice == 's') {
			SavingsAccount s1 = new SavingsAccount(name, number, value, date);
			System.out.println("Your balance in " + s1.getCreationDate().plusMonths(1).format(dtw) + " is: "
					+ s1.addMonthlyInterest());

			System.out.println("============Report============");
			System.out.println("Name: " + s1.getOwner());
			System.out.println("Number Account: " + s1.getNumberAccount());
			System.out.println("Balance: " + s1.getBalance());
			System.out.println("Your balance in " + s1.getCreationDate().plusMonths(1).format(dtw) + " will be: "+ String.format("%.2f",s1.addMonthlyInterest()));
			System.out.println("Report of the day " + date.format(dtw));
			System.out.println("Thank you for using our service!");

		} else if (choice == 'c') {
			CheckingAccount c1 = new CheckingAccount(name, number, value, date, accountLevel);

			System.out.print("You want to take out a loan?(y/n) ");
			char decision = sc.next().toLowerCase().charAt(0);

			if (decision == 'y') {

				try {
					makeLoan = "yes";
					System.out.print("What's your month income? ");
					double income = sc.nextDouble();
					System.out.println("How much loan do you want?");
					double amount = sc.nextDouble();
					loanValue = amount;
					c1.loanChecking(income, amount);
					System.out.println("Your new balance is: " + c1.getBalance());

				} catch (InvalidAmount e) {
					System.out.println(e.getMessage());

				} catch (InsufficientIncomeLoanException e) {
					System.out.println(e.getMessage());
				}
			} else if (decision == 'n') {
				makeLoan = "no";
				System.out.println("Your balance is: " + c1.getBalance());
			} else {
				System.out.println("Error: Invalid digit!");
			}
			System.out.println();
			System.out.println("============Report============");
			System.out.println("Name: " + c1.getOwner());
			System.out.println("Number Account: " + c1.getNumberAccount());
			System.out.println("Balance: " + c1.getBalance());
			System.out.println("Level account: " + accountLevel);
			System.out.println("Limit: " + c1.getLimit());
			System.out.println("Loan taken: " + makeLoan);
			System.out.println("Loan value: " + loanValue);
			System.out.println("Report of the day " + date.format(dtw));
			System.out.println("Thank you for using our service!");

		} else if (choice == 'b') {
			BusinessAccount b1 = new BusinessAccount(name, number, value, date, accountLevel);

			System.out.print("You want to take out a loan?(y/n) ");
			char decision = sc.next().toLowerCase().charAt(0);

			if (decision == 'y') {

				try {
					makeLoan = "yes";
					System.out.println("How much loan do you want?");
					double amount = sc.nextDouble();
					b1.loanBusiness(amount);
					loanValue = amount;
					System.out.println("Your new balance is: " + b1.getBalance());

				} catch (InvalidAmount e) {
					System.out.println(e.getMessage());

				}
			} else if (decision == 'n') {
				makeLoan = "no";
				System.out.println("Your balance is: " + b1.getBalance());
			} else {
				System.out.println("Error: Invalid digit!");
			}
			
			System.out.println();
			System.out.println("============Report============");
			System.out.println("Name: " + b1.getOwner());
			System.out.println("Number Account: " + b1.getNumberAccount());
			System.out.println("Balance: " + b1.getBalance());
			System.out.println("Level account: " + accountLevel);
			System.out.println("Limit: " + b1.getLoanLimit());
			System.out.println("Loan taken: " + makeLoan);
			System.out.println("Loan value: " + loanValue);
			System.out.println("Report of the day " + date.format(dtw));
			System.out.println("Thank you for using our service!");
			
		} else {
			System.out.println("Error: Invalid digit!");
		}

		sc.close();
	}

}
