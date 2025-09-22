package aplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Author;
import entities.Book;
import entities.LoanOfBook;
import entities.StatusBook;
import entities.TypeOfUser;
import entities.User;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Book> listBook = new ArrayList<>();
		List<Author> listAuthor = new ArrayList<>();
		List<User> listUser = new ArrayList<>();
		List<LoanOfBook> listLoan = new ArrayList<>();

		String path = "C:\\Users\\cnlun\\OneDrive\\Documentos\\ArquivosUdemy\\finalReport.txt";

		while (true) {

			try {

				System.out.println("[1] Register user    [2] Register book ");
				System.out.println("[3] Register author  [4] Make Loan");
				System.out.println("[5] Exit ");
				System.out.print("Choose an option: ");
				int choice = sc.nextInt();

				if (choice == 1) {

					System.out.print("Enter user name: ");
					sc.nextLine();
					String nameUser = sc.nextLine();

					System.out.print("Enter user id: ");
					int idUser = sc.nextInt();

					System.out.println();
					System.out.print("[s]Studant  [e]Employee ");
					System.out.print("Enter user type: ");
					char digitTypeUser = sc.next().toLowerCase().charAt(0);

					TypeOfUser typeUser = null;

					if (digitTypeUser == 's') {
						typeUser = TypeOfUser.STUDENT;

					} else if (digitTypeUser == 'e') {
						typeUser = TypeOfUser.EMPLOYEE;

					} else {

						System.out.println("Error: Invalid digit, try again!");
						continue;
					}

					User u = new User(nameUser, idUser, typeUser);
					listUser.add(u);
					System.out.println("Successful register!");
					System.out.println();

				} else if (choice == 2) {
					sc.nextLine();

					System.out.print("Enter book name: ");
					String nameBook = sc.nextLine();

					System.out.print("Enter book id: ");
					int idBook = sc.nextInt();

					sc.nextLine();
					System.out.print("Enter author name: ");
					String authorBook = sc.nextLine();

					System.out.println();
					System.out.print("[a] Available  [u] Unavailable ");
					System.out.print("Enter status of book: ");
					char digitStatus = sc.next().toLowerCase().charAt(0);
					StatusBook statusBook = null;

					if (digitStatus == 'a') {
						statusBook = StatusBook.AVAILABLE;

					} else if (digitStatus == 'u') {
						statusBook = StatusBook.UNAVAILABLE;

					} else {

						System.out.println("Error: Invalid digit, try again!");
						continue;
					}

					Book b = new Book(nameBook, idBook, authorBook, statusBook);

					listBook.add(b);
					System.out.println("Successful register!");
					System.out.println();

				} else if (choice == 3) {
					sc.nextLine();

					System.out.print("Enter author name: ");
					String nameAuthor = sc.nextLine();

					System.out.print("Enter author id: ");
					int idAuthor = sc.nextInt();

					sc.nextLine();
					System.out.print("Enter author nacionality's: ");
					String nationalityAuthor = sc.nextLine();

					Author a = new Author(nameAuthor, idAuthor, nationalityAuthor);
					listAuthor.add(a);
					System.out.println("Successful register!");
					System.out.println();

				} else if (choice == 4) {

					System.out.print("Enter the id of the desired book: ");
					int id = sc.nextInt();

					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
					LocalDateTime dateNow = LocalDateTime.now();

					System.out.println("Loan Date: " + dateNow.format(dtf));

					LocalDateTime dateDelivery = dateNow.plusMonths(1);
					System.out.println("Delivery date: " + dateDelivery.format(dtf));

					LoanOfBook ml = new LoanOfBook(id, dateNow, dateDelivery);
					listLoan.add(ml);

					System.out.println("Successful Loan!");
					System.out.println();

				} else if (choice == 5) {

					System.out.println("The report is in: " + path);
					System.out.println("End of program, thanks for using!");
					break;

				} else {
					System.out.println("Error: Invalid digit, try again!");
					continue;

				}

			} catch (InputMismatchException e) {
				System.out.println("Error: Incorrect input!");
				break;
			}
		}

		int cont = 1;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("============ Report ============");
			bw.newLine();
			bw.newLine();

			for (Book i : listBook) {
				bw.write("Book #" + cont + ":");
				bw.newLine();
				bw.write(i.printBook());
				bw.newLine();
				bw.newLine();
				cont++;
			}

			cont = 1;
			for (Author i : listAuthor) {

				bw.write("Author #" + cont + ":");
				bw.newLine();
				bw.write(i.printAuthor());
				bw.newLine();
				bw.newLine();
				cont++;
			}
			cont = 1;
			for (User i : listUser) {

				bw.write("User #" + cont + ":");
				bw.newLine();
				bw.write(i.printUser());
				bw.newLine();
				bw.newLine();
				cont++;
			}
			cont = 1;
			for (LoanOfBook i : listLoan) {
				cont = 1;
				bw.write("Loan #" + cont + ":");
				bw.newLine();
				bw.write(i.printLoan());
				bw.newLine();
				bw.newLine();
				cont++;
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}
}
