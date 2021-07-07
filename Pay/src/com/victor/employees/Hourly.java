package com.victor.employees;

import java.util.ArrayList;
import java.util.List;

import com.victor.classes.Adress;
import com.victor.classes.TimeCard;

public class Hourly extends Employee {
	
	private double salary;
	private ArrayList<TimeCard> timecards;
	public final double extraHourTax = 1.5D;
	
	public Hourly(int id, String name, Adress adress, SalaryType salaryType, Double salary, PaymentMethod paymentMethod, boolean onSyndicate, int syndicateId) {
		super(id, name, adress, salaryType, salary, paymentMethod, onSyndicate, syndicateId);
		this.salary = salary;
		this.timecards = new ArrayList<>();
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double hourlySalary) {
		this.salary = hourlySalary;
	}

	public List<TimeCard> getTimecards() {
		return timecards;
	}

	public void setTimecards(ArrayList<TimeCard> timecards) {
		this.timecards = timecards;
	}

	public double getExtraHourTax() {
		return extraHourTax;
	}

}
