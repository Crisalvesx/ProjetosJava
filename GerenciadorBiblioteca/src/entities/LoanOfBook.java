package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoanOfBook {

	private int idLoan;
	private LocalDateTime loanDate;
	private LocalDateTime deliveryDate;

	DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public LoanOfBook(int idLoan, LocalDateTime loanDate, LocalDateTime deliveryDate) {
	
		this.idLoan = idLoan;
		this.loanDate = loanDate;
		this.deliveryDate = deliveryDate;
	}

	public int getIdLoan() {
		return idLoan;
	}

	public void setIdLoan(int idLoan) {
		this.idLoan = idLoan;
	}

	public LocalDateTime getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDateTime loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public String printLoan() {
		return "Id: " + getIdLoan() + 
			   "\nLoan date: " + getLoanDate().format(dft) +
			   "\nDelivery date: " + getDeliveryDate().format(dft);
				
	}
	
}
