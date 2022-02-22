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
		
		
		for(int i=1; i<=months; i++) {
			Double value = contract.getTotalValue() / months;
			cal.add(Calendar.MONTH, 1);
			value += ops.interest(value, i);
			value += ops.paymentFee(value);
			contract.addInstallment(new Installment(cal.getTime(), value));
					
		}
		
	     
	      			
		}
}
