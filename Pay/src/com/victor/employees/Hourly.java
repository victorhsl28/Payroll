package com.victor.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.victor.classes.Address;
import com.victor.classes.TimeCard;

public class Hourly extends Employee {
	
	private ArrayList<TimeCard> timecards;
	
	public Hourly(UUID uuid, String name, Address adress, Double salary, PaymentMethod paymentMethod, boolean onSyndicate, UUID syndicateUUID) {
		super(uuid, name, adress, salary, paymentMethod, onSyndicate, syndicateUUID);
		this.timecards = new ArrayList<>();
	}
	
	public void printTimeCards() {
		for(TimeCard timeCard : timecards) {
			timeCard.print_info();
		}
	}

	public List<TimeCard> getTimecards() {
		return timecards;
	}

	public void setTimecards(ArrayList<TimeCard> timecards) {
		this.timecards = timecards;
	}
}
