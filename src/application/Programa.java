package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				//TaxPayer tp = new Individual(name, anualIncome, healthExpenditures);
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployers = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployers));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		double sum = 0.0;
		for (TaxPayer tp : list) {
			sum += tp.taxIncome();	
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.taxIncome()));
		}
		
		System.out.println();
		
		System.out.println("TOTAL TAXES: $ " + String.format(".2f", sum));
		
		sc.close();
	}

}
