package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import models.entitites.Contract;
import models.services.ContractService;
import models.services.PaypalService;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		Double value = sc.nextDouble();
		Contract contract = new Contract(number, date, value);
		System.out.print("Enter number of installments: ");
		int installments = sc.nextInt();
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, installments);
		contract.getInstallments().stream().forEach(c -> System.out.println(c.toString()));
		sc.close();
	}
}
