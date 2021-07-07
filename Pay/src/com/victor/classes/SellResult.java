package com.victor.classes;

import java.util.Calendar;

public class SellResult {
	
	private Calendar date;
	private int value;
	
	public SellResult(int value) {
		this.date = Calendar.getInstance();
		this.value = value;
	}
	
	public void print_info() {
		int day = this.date.get(Calendar.DAY_OF_MONTH);
		int month = this.date.get(Calendar.MONTH);
		int year = this.date.get(Calendar.YEAR);
		
		System.out.println("======SellResult======\n" +
							">Date: " + day + "/" + month + "/" + year + "\n" + 
							">Value: " + this.value + 
							"\n======================");
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

}
