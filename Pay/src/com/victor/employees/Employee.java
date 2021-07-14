package com.victor.employees;

import java.util.UUID;

import com.victor.classes.Address;

public class Employee {
	
	private UUID uuid;
	private String name;
	private Address adress;
	private double salary;
	private PaymentMethod paymentMethod;
	private boolean onSyndicate;
	private UUID syndicateUUID;
	
	public Employee(UUID uuid, String name, Address adress, Double salary, PaymentMethod paymentMethod, boolean onSyndicate, UUID syndicateUUID) {
		this.uuid = uuid;
		this.name = name;
		this.adress = adress;
		this.salary = salary;
		this.paymentMethod = paymentMethod;
		this.onSyndicate = onSyndicate;
		this.syndicateUUID = syndicateUUID;
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

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
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

	public UUID getUUID() {
		return uuid;
	}

	public void setUUID(UUID uuid) {
		this.uuid = uuid;
	}

	public UUID getSyndicateUUID() {
		return syndicateUUID;
	}

	public void setSyndicateUUID(UUID syndicateUUID) {
		this.syndicateUUID = syndicateUUID;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
