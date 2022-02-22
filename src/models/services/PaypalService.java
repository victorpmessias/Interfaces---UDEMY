package models.services;

public class PaypalService implements OnlinePaymentService{

	@Override
	public Double interest(Double amount, Integer months) {
		return (double) amount * 0.01 * months  ;
	}

	@Override
	public Double paymentFee(Double amount) {
		return (double) amount * 0.02;
	}

	
	
}
