package com.victor.main;

import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;

import com.victor.actions.Action;
import com.victor.classes.SellResult;
import com.victor.classes.Syndicate;
import com.victor.classes.TimeCard;
import com.victor.employees.Comissioned;
import com.victor.employees.Employee;
import com.victor.employees.Hourly;
import com.victor.employees.Salaried;
import com.victor.gui.MainGUI;

public class Main {
	
	public static HashMap<UUID, Employee> employees;
	public static HashMap<UUID, Syndicate> syndicate;
	public static Action lastAction;

	public static void main(String[] args) {
		employees = new HashMap<>();
		syndicate = new HashMap<>();
		new MainGUI();
	}
	
	public static void roll() { //considerando a semana com 5 dias
		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == 5) {
			for(Employee employee : employees.values()) {
				if(employee instanceof Hourly ) {
					Hourly hourly = ((Hourly)employee);
					double salary = 0;
					for(TimeCard timecard : hourly.getTimecards()) {
						if(timecard.isCompleted()) {
							if(timecard.getWorkedHours() > 8) {
								int extra_hours = timecard.getWorkedHours() - 8;
								salary += 8 * hourly.getSalary();
								salary += extra_hours * hourly.getSalary() + (extra_hours * hourly.getSalary() * 0.5);
							} else {
								salary += timecard.getWorkedHours() * hourly.getSalary();
							}
						}
					}
					if(hourly.isOnSyndicate()) {
						Syndicate syndicateHourly = syndicate.get(hourly.getSyndicateUUID());
						salary -= syndicateHourly.getSyndicateTax();
						for(Double tax : syndicateHourly.getExtraTaxes()) {
							salary -= tax;
						}
					}
					hourly.getTimecards().clear();
					System.out.println("Payed " + salary + " via " + hourly.getPaymentMethod().toString() + " to employee " + hourly.getUUID().toString());
				} else if(employee instanceof Comissioned) {
					Comissioned comissioned = ((Comissioned)employee);
					if(comissioned.getFridayCounter() == 0) {
						comissioned.setFridayCounter(comissioned.getFridayCounter() + 1);
					} else {
						double salary = comissioned.getSalary();
						comissioned.setFridayCounter(0);
						for(SellResult sellResult : comissioned.getSellResults()) {
							salary += sellResult.getValue() * comissioned.getComissionedTax();
						}
						if(comissioned.isOnSyndicate()) {
							Syndicate syndicateComissioned = syndicate.get(comissioned.getSyndicateUUID());
							salary -= syndicateComissioned.getSyndicateTax();
							for(Double tax : syndicateComissioned.getExtraTaxes()) {
								salary -= tax;
							}
						}
						comissioned.getSellResults().clear();
						System.out.println("Payed " + salary + " via " + comissioned.getPaymentMethod().toString() + " to employee " + comissioned.getUUID().toString());
					}
				}
			}
		}
		
		if(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)) {
			for(Employee employee : employees.values()) {
				if(employee instanceof Salaried) {
					double salary = employee.getSalary();
					if(employee.isOnSyndicate()) {
						Syndicate syndicateSalaried = syndicate.get(employee.getSyndicateUUID());
						salary -= syndicateSalaried.getSyndicateTax();
						for(Double tax : syndicateSalaried.getExtraTaxes()) {
							salary -= tax;
						}
					}
					System.out.println("Payed " + salary + " via " + employee.getPaymentMethod().toString() + " to employee " + employee.getUUID().toString());
				}
			}
		}
		
	}

}
