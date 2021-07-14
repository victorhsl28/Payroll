package com.victor.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.victor.classes.Address;
import com.victor.classes.SellResult;

public class Comissioned extends Employee {
	
	private double comissionedTax;
	private ArrayList<SellResult> sellResults;
	private int fridayCounter;

	public Comissioned(UUID uuid, String name, Address adress, Double salary, PaymentMethod paymentMethod, boolean onSyndicate, UUID syndicateUUID, Double comissionedTax) {
		super(uuid, name, adress, salary, paymentMethod, onSyndicate, syndicateUUID);
		this.comissionedTax = comissionedTax;
		this.sellResults = new ArrayList<>();
		this.fridayCounter = 0;
	}
	
	public void printSellResults() {
		for(SellResult sellResult : sellResults) {
			sellResult.print_info();
		}
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

	public int getFridayCounter() {
		return fridayCounter;
	}

	public void setFridayCounter(int fridayCounter) {
		this.fridayCounter = fridayCounter;
	}
}
