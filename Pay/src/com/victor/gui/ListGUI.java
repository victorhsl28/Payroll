package com.victor.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.victor.employees.ComissionedSalaried;
import com.victor.employees.Employee;
import com.victor.employees.Employee.SalaryType;
import com.victor.employees.Hourly;
import com.victor.employees.Salaried;
import com.victor.main.Main;

public class ListGUI {
	
	private JFrame frame;
	private JTable table;
	private JScrollPane scroll;
	
	public ListGUI() {
		frame = new JFrame("Employees");
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		String[][] data = new String[Main.employees.size()][10];
		int i = 0;
		for(Employee employee : Main.employees.values()) {
			data[i][0] = String.valueOf(employee.getId());
			data[i][1] = employee.getName();
			data[i][2] = employee.getAdress().getCity();
			data[i][3] = employee.getAdress().getState();
			data[i][4] = employee.getAdress().getCountry();
			data[i][5] = String.valueOf(employee.getSalaryType().toString());
			if(employee.getSalaryType() == SalaryType.HOURLY) {
				data[i][6] = String.valueOf(((Hourly)employee).getSalary());
			} else if(employee.getSalaryType() == SalaryType.SALARIED) {
				data[i][6] = String.valueOf(((Salaried)employee).getSalary());
			} else if(employee.getSalaryType() == SalaryType.COMISSIONED) {
				data[i][6] = String.valueOf(((ComissionedSalaried)employee).getSalary());
			}
			data[i][7] = String.valueOf(employee.getPaymentMethod().toString());
			data[i][8] = String.valueOf(employee.isOnSyndicate());
			data[i][9] = String.valueOf(employee.getSyndicateId());
			i++;
		}
		String[] columnNames = { "ID", "Name", "City", "State", "Country", "Salary Type", "Salary/Tax", "Payment Method", "On Syndicate", "Syndicate ID" };
		table = new JTable(data, columnNames);
		table.setBounds(50, 50, 200, 300);
		scroll = new JScrollPane(table);
		frame.add(scroll);
		frame.setVisible(true);
	}
}
