package com.victor.employees;

import java.util.UUID;

import com.victor.classes.Address;

public class Salaried extends Employee {

	public Salaried(UUID uuid, String name, Address adress, Double salary, PaymentMethod paymentMethod, boolean onSyndicate, UUID syndicateUUID) {
		super(uuid, name, adress, salary, paymentMethod, onSyndicate, syndicateUUID);
	}
	
}
