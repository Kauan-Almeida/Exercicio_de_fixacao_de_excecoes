package application;

import java.util.Locale;
import java.util.Scanner;

import exception.DomainException;
import entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			double limit = sc.nextDouble();
			
			Account account = new Account(number, name, balance, limit);
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			
			account.withdraw(amount);
			System.out.printf("New balance: %.2f", account.getBalance());
		}
		catch(IllegalArgumentException e) {
			System.out.println("Wthdraw error: " + e.getMessage());
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}

		sc.close();
	}
}