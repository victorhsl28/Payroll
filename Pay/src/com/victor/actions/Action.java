package com.victor.actions;

import com.victor.classes.Syndicate;
import com.victor.employees.Employee;
import com.victor.main.Main;

public class Action {
	
	private Employee employee;
	private Employee oldEmployee;
	private Event event;
	private Syndicate syndicate;
	
	public Action (Employee employee, Employee oldEmployee, Syndicate syndicate, Event event) {
		this.employee = employee;
		this.oldEmployee = oldEmployee;
		this.syndicate = syndicate;
		this.event = event;
		Main.lastAction = this;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Syndicate getSyndicate() {
		return syndicate;
	}

	public void setSyndicate(Syndicate syndicate) {
		this.syndicate = syndicate;
	}

	public Employee getOldEmployee() {
		return oldEmployee;
	}

	public void setOldEmployee(Employee oldEmployee) {
		this.oldEmployee = oldEmployee;
	}

	public static enum Event {
	    ADD_EMPLOYEE, REMOVE_EMPLOYEE, CREATE_TIMECARD, CREATE_SELL_RESULT, CREATE_SERVICE_TAX, CHANGE_EMPLOYEE_INFO, ROLL;
	}

}
