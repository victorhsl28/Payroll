package com.victor.employees;

import com.victor.classes.Adress;

public class Salaried extends Employee {

	private double salary;

	public Salaried(int id, String name, Adress adress, SalaryType salaryType, Double salary, PaymentMethod paymentMethod, boolean onSyndicate, int syndicateId) {
		super(id, name, adress, salaryType, salary, paymentMethod, onSyndicate, syndicateId);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
