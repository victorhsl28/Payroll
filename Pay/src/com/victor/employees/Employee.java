package com.victor.employees;

import com.victor.classes.Adress;

public class Employee {
	
	private int id;
	private String name;
	private Adress adress;
	private SalaryType salaryType;
	private PaymentMethod paymentMethod;
	private boolean onSyndicate;
	private int syndicateId;
	
	public Employee(int id, String name, Adress adress, SalaryType salaryType, Double salary, PaymentMethod paymentMethod, boolean onSyndicate, int syndicateId) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.salaryType = salaryType;
		this.paymentMethod = paymentMethod;
		this.onSyndicate = onSyndicate;
		this.syndicateId = syndicateId;
	}
	
	public void print_info() {
		System.out.println("==========Employee Info==========\n" + 
							"Name: " + this.name + "\n" + 
							"Adress: \n" + 
							">City: " + this.adress.getCity() + "\n" +
							">State: " + this.adress.getState() + "\n" +
							">Country: " + this.adress.getCountry() + "\n" +
							"Salary Type: " + this.salaryType.toString() + "\n" +
							"Payment Method: " + this.paymentMethod.toString() + "\n" +
							"Is on syndicate: " + this.onSyndicate + "\n");	
		System.out.println("\n=================================");
	}
	
	public static enum SalaryType {
	    HOURLY, SALARIED, COMISSIONED;
	}
	
	public static enum PaymentMethod {
	    MAIL_CHECK, HAND_CHECK, DEPOSIT_BANK_ACCOUNT;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public SalaryType getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(SalaryType salaryType) {
		this.salaryType = salaryType;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public boolean isOnSyndicate() {
		return onSyndicate;
	}

	public void setOnSyndicate(boolean onSyndicate) {		
		this.onSyndicate = onSyndicate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSyndicateId() {
		return syndicateId;
	}

	public void setSyndicateId(int syndicateId) {
		this.syndicateId = syndicateId;
	}
}
