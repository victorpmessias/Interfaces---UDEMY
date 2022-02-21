package models.services;

import java.util.Calendar;

import models.entitites.Contract;
import models.entitites.Installment;

public class ContractService {
	OnlinePaymentService ops;
	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}
	
	
	
	public void processContract(Contract contract, Integer months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(contract.getDate());
		Double value = contract.getTotalValue() / months;
		
		
		for(int i=1; i<=months; i++) {
			cal.add(Calendar.MONTH, 1);
			Double simpleInterest = ops.interest(value, i);
			Double paymentFee = ops.paymentFee(simpleInterest);
			contract.getInstallments().add(new Installment(cal.getTime(), paymentFee));
					
		}
		
	     
	      			
		}
}
