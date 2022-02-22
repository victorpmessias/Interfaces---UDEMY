package models.entitites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private Integer number;
	private Date date;
	private double totalValue;
	private List<Installment> installments = new ArrayList<>();
	
	public Contract() {
	}

	public Contract(Integer number, Date date, double totalValue) {
		super();
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void addInstallment(Installment installment){
		this.installments.add(installment);
	}
	
	
}
