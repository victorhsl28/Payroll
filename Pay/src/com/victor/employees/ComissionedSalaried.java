package com.victor.employees;

import java.util.ArrayList;
import java.util.List;

import com.victor.classes.Adress;
import com.victor.classes.SellResult;

public class ComissionedSalaried extends Salaried {
	
	private double comissionedTax;
	private ArrayList<SellResult> sellResults;

	public ComissionedSalaried(int id, String name, Adress adress, SalaryType salaryType, Double comissionedTax, PaymentMethod paymentMethod, boolean onSyndicate, int syndicateId) {
		super(id, name, adress, salaryType, comissionedTax, paymentMethod, onSyndicate, syndicateId);
		this.comissionedTax = comissionedTax;
		this.sellResults = new ArrayList<>();
	}

	public double getComissionedTax() {
		return comissionedTax;
	}

	public void setComissionedTax(double comissionedTax) {
		this.comissionedTax = comissionedTax;
	}

	public List<SellResult> getSellResults() {
		return sellResults;
	}

	public void setSellResults(ArrayList<SellResult> sellResults) {
		this.sellResults = sellResults;
	}
}
