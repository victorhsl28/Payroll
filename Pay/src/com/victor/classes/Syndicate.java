package com.victor.classes;

import java.util.ArrayList;
import java.util.List;

public class Syndicate {
	
	private int syndicateId;
	private double syndicateTax;
	private ArrayList<Double> extraTaxes;
	
	public Syndicate(int id, double syndicateTax) {
		this.syndicateId = id;
		this.syndicateTax = syndicateTax;
		this.extraTaxes = new ArrayList<>();
	}
	
	public void print_info() {
		System.out.println("ID: " + this.getSyndicateId() + "\n" +
							"Tax: " + this.getSyndicateTax() + "\n");
		System.out.println("=Extras Taxes=");
		for(Double extrataxes : extraTaxes) {
			System.out.println(String.valueOf(extrataxes));
		}
		System.out.println("==============");
	}

	public int getSyndicateId() {
		return syndicateId;
	}
	
	public void setSyndicateId(int syndicateId) {
		this.syndicateId = syndicateId;
	}
	
	public double getSyndicateTax() {
		return syndicateTax;
	}
	
	public void setSyndicateTax(double syndicateTax) {
		this.syndicateTax = syndicateTax;
	}
	
	public List<Double> getExtraTaxes() {
		return extraTaxes;
	}
	
	public void setExtraTaxes(ArrayList<Double> extraTaxes) {
		this.extraTaxes = extraTaxes;
	}

}
