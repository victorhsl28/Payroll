package com.victor.main;

import java.util.HashMap;

import com.victor.classes.Syndicate;
import com.victor.employees.Employee;
import com.victor.gui.MainGUI;

public class Main {
	public static HashMap<Integer, Employee> employees;
	public static HashMap<Integer, Syndicate> syndicate;

	public static void main(String[] args) {
		employees = new HashMap<>();
		syndicate = new HashMap<>();
		new MainGUI();
	}

}
