package com.victor.actions;

import javax.swing.JOptionPane;

import com.victor.classes.SellResult;
import com.victor.classes.Syndicate;
import com.victor.classes.TimeCard;
import com.victor.employees.Comissioned;
import com.victor.employees.Employee;
import com.victor.employees.Hourly;
import com.victor.employees.Salaried;
import com.victor.main.Main;

public class Undo {
	
	public static void undo() {
		Action action = Main.lastAction;
		if(action != null) {
			Employee employee = action.getEmployee();
			switch (action.getEvent()) {
			case ADD_EMPLOYEE:
				if(employee.isOnSyndicate()) {
					Main.syndicate.remove(employee.getSyndicateUUID());
				}
				Main.employees.remove(employee.getUUID());
				JOptionPane.showMessageDialog(null, "Employee " + employee.getUUID().toString() + " has been removed!", "Success!", JOptionPane.INFORMATION_MESSAGE);
				Main.lastAction = null;
				break;
				
			case REMOVE_EMPLOYEE:
				if(employee instanceof Hourly) {
					Main.employees.put(employee.getUUID(), new Hourly(employee.getUUID(), employee.getName(), employee.getAdress(), employee.getSalary(), employee.getPaymentMethod(), employee.isOnSyndicate(), employee.getSyndicateUUID()));
					for(TimeCard timecard : ((Hourly) employee).getTimecards()) {
						((Hourly)Main.employees.get(employee.getUUID())).getTimecards().add(timecard);
					}
				} else if(employee instanceof Salaried) {
					Main.employees.put(employee.getUUID(), new Salaried(employee.getUUID(), employee.getName(), employee.getAdress(), employee.getSalary(), employee.getPaymentMethod(), employee.isOnSyndicate(), employee.getSyndicateUUID()));
				} else if(employee instanceof Comissioned) {
					Main.employees.put(employee.getUUID(), new Comissioned(employee.getUUID(), employee.getName(), employee.getAdress(), employee.getSalary(), employee.getPaymentMethod(), employee.isOnSyndicate(), employee.getSyndicateUUID(), ((Comissioned)employee).getComissionedTax()));
					for(SellResult sellResult : ((Comissioned) employee).getSellResults()) {
						((Comissioned)Main.employees.get(employee.getUUID())).getSellResults().add(sellResult);
					}
				}
				if(employee.isOnSyndicate()) {
					Main.syndicate.put(employee.getSyndicateUUID(), new Syndicate(employee.getSyndicateUUID(), action.getSyndicate().getSyndicateTax()));
					for(Double tax : action.getSyndicate().getExtraTaxes()) {
						Main.syndicate.get(employee.getSyndicateUUID()).getExtraTaxes().add(tax);
					}
				}
				JOptionPane.showMessageDialog(null, "Employee " + employee.getName() + " has been created with the ID: " + employee.getUUID().toString() + "!", "Success!", JOptionPane.INFORMATION_MESSAGE);
				Main.lastAction = null;
				break;
				
			case CREATE_TIMECARD:
				if(employee instanceof Hourly) {
					Hourly hourly = ((Hourly)employee);
					hourly.getTimecards().remove(hourly.getTimecards().get(hourly.getTimecards().size() - 1));
					System.out.println("Last timecard removed!");
					Main.lastAction = null;
					hourly.printTimeCards();
				} else {
					System.out.println("Last employee was not hourly! Could not undo the action");
					Main.lastAction = null;
				}
				break;
				
			case CREATE_SELL_RESULT:
				if(employee instanceof Comissioned) {
					Comissioned comissioned = ((Comissioned)employee);
					comissioned.getSellResults().remove(comissioned.getSellResults().get(comissioned.getSellResults().size() - 1));
					System.out.println("Last sell result removed!");
					Main.lastAction = null;
					comissioned.printSellResults();
				} else {
					System.out.println("Last employee was not comissioned! Could not undo the action");
					Main.lastAction = null;
				}
				break;
			
			case CREATE_SERVICE_TAX:
				if(Main.syndicate.containsValue(action.getSyndicate())) {
					Syndicate syndicate = action.getSyndicate();
					syndicate.getExtraTaxes().remove(syndicate.getExtraTaxes().get(syndicate.getExtraTaxes().size() - 1));
					System.out.println("Last service tax removed!");
					Main.lastAction = null;
					syndicate.print_info();
				} else {
					System.out.println("Last employee was not on syndicate! Could not undo the action");
					Main.lastAction = null;
				}
				break;
			
			case CHANGE_EMPLOYEE_INFO:
				Employee oldEmployee = action.getOldEmployee();
				if(employee.isOnSyndicate()) {
					Main.syndicate.remove(employee.getSyndicateUUID());
				}
				Main.employees.remove(employee.getUUID());
				if(oldEmployee instanceof Hourly) {
					Main.employees.put(oldEmployee.getUUID(), new Hourly(oldEmployee.getUUID(), oldEmployee.getName(), oldEmployee.getAdress(), oldEmployee.getSalary(), oldEmployee.getPaymentMethod(), oldEmployee.isOnSyndicate(), oldEmployee.getSyndicateUUID()));
					for(TimeCard timecard : ((Hourly) oldEmployee).getTimecards()) {
						((Hourly)Main.employees.get(employee.getUUID())).getTimecards().add(timecard);
					}
				} else if(oldEmployee instanceof Salaried) {
					Main.employees.put(oldEmployee.getUUID(), new Salaried(oldEmployee.getUUID(), oldEmployee.getName(), oldEmployee.getAdress(), oldEmployee.getSalary(), oldEmployee.getPaymentMethod(), oldEmployee.isOnSyndicate(), oldEmployee.getSyndicateUUID()));
				} else if(oldEmployee instanceof Comissioned) {
					Main.employees.put(oldEmployee.getUUID(), new Comissioned(oldEmployee.getUUID(), oldEmployee.getName(), oldEmployee.getAdress(), oldEmployee.getSalary(), oldEmployee.getPaymentMethod(), oldEmployee.isOnSyndicate(), oldEmployee.getSyndicateUUID(), ((Comissioned)oldEmployee).getComissionedTax()));
					for(SellResult sellResult : ((Comissioned) oldEmployee).getSellResults()) {
						((Comissioned)Main.employees.get(oldEmployee.getUUID())).getSellResults().add(sellResult);
					}
				}
				if(oldEmployee.isOnSyndicate()) {
					Main.syndicate.put(oldEmployee.getSyndicateUUID(), new Syndicate(oldEmployee.getSyndicateUUID(), action.getSyndicate().getSyndicateTax()));
					for(Double tax : action.getSyndicate().getExtraTaxes()) {
						Main.syndicate.get(oldEmployee.getSyndicateUUID()).getExtraTaxes().add(tax);
					}
				}
				System.out.println("Employee was rolled back!");
				Main.lastAction = null;
				break;
			
			case ROLL:
				break;
				
			default:
				break;
			}
		} else {
			System.out.println("There is not last action!");
		}
	}

}
