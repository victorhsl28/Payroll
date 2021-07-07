package com.victor.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.victor.classes.Adress;
import com.victor.classes.Syndicate;
import com.victor.employees.ComissionedSalaried;
import com.victor.employees.Employee;
import com.victor.employees.Employee.PaymentMethod;
import com.victor.employees.Employee.SalaryType;
import com.victor.employees.Hourly;
import com.victor.employees.Salaried;
import com.victor.main.Main;

public class ChangeInfoGUI implements ActionListener {
	
	private JFrame frame;
	private JPanel panel;
	private JFormattedTextField idField;
	private JFormattedTextField newIdField;
	private JTextField nameField;
	private JTextField adressCityField;
	private JTextField adressStateField;
	private JTextField adressCountryField;
	private ButtonGroup salaryTypeGroup;
	private JRadioButton salaryTypeButtonHourly;
	private JRadioButton salaryTypeButtonSalaried;
	private JRadioButton salaryTypeButtonComissioned;
	private JFormattedTextField salary_taxField;
	private ButtonGroup paymentMethodGroup;
	private JRadioButton paymentMethodButtonMail;
	private JRadioButton paymentMethodButtonHand;
	private JRadioButton paymentMethodButtonDeposit;
	private ButtonGroup syndicateGroup;
	private JRadioButton syndicateYesButton;
	private JRadioButton syndicateNoButton;
	private JFormattedTextField syndicateIdField;
	private JFormattedTextField syndicateTaxField;
	private JButton concludeButton;
	private JLabel result;
	private JButton searchButton;
	
	public ChangeInfoGUI() {
		frame = new JFrame("Change employee info");
		panel = new JPanel();
		
		result = new JLabel("");
		
		panel.setBorder(BorderFactory.createEmptyBorder(5, 50, 20, 50));
		panel.setLayout(new GridLayout(0, 1));
		
		panel.add(result);
		
		JLabel idText = new JLabel("ID:");
		idField = new JFormattedTextField();
		panel.add(idText);
		panel.add(idField);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		panel.add(searchButton);
		
		JLabel newIdText = new JLabel("New ID:");
		newIdField = new JFormattedTextField();
		panel.add(newIdText);
		panel.add(newIdField);
		
		JLabel nameText = new JLabel("Name:");
		nameField = new JTextField(20);
		panel.add(nameText);
		panel.add(nameField);
		
		JLabel adressCity = new JLabel("City:");
		adressCityField = new JTextField(20);
		panel.add(adressCity);
		panel.add(adressCityField);
		
		JLabel adressState = new JLabel("State:");
		adressStateField = new JTextField(20);
		panel.add(adressState);
		panel.add(adressStateField);
		
		JLabel adressCountry = new JLabel("Country:");
		adressCountryField = new JTextField(20);
		panel.add(adressCountry);
		panel.add(adressCountryField);
		
		JLabel salaryType = new JLabel("Salary type:");
		panel.add(salaryType);
		
		salaryTypeGroup = new ButtonGroup();
		
		salaryTypeButtonHourly = new JRadioButton("Hourly");
		salaryTypeGroup.add(salaryTypeButtonHourly);
		salaryTypeButtonSalaried = new JRadioButton("Salaried");
		salaryTypeGroup.add(salaryTypeButtonSalaried);
		salaryTypeButtonComissioned = new JRadioButton("Comissioned");
		salaryTypeGroup.add(salaryTypeButtonComissioned);
		
		panel.add(salaryTypeButtonHourly);
		panel.add(salaryTypeButtonSalaried);
		panel.add(salaryTypeButtonComissioned);
		
		JLabel salary_tax = new JLabel("Salary/Tax:");
		salary_taxField = new JFormattedTextField();
		panel.add(salary_tax);
		panel.add(salary_taxField);
		
		JLabel paymentMethodLabel = new JLabel("Payment method:");
		panel.add(paymentMethodLabel);
		
		paymentMethodGroup = new ButtonGroup();
		
		paymentMethodButtonMail = new JRadioButton("Mail");
		paymentMethodGroup.add(paymentMethodButtonMail);
		paymentMethodButtonHand = new JRadioButton("Hand check");
		paymentMethodGroup.add(paymentMethodButtonHand);
		paymentMethodButtonDeposit = new JRadioButton("Bank account deposit");
		paymentMethodGroup.add(paymentMethodButtonDeposit);
		
		panel.add(paymentMethodButtonMail);
		panel.add(paymentMethodButtonHand);
		panel.add(paymentMethodButtonDeposit);
		
		JLabel syndicateLabel = new JLabel("Is on the syndicate:");
		panel.add(syndicateLabel);
		
		syndicateGroup = new ButtonGroup();
		syndicateYesButton = new JRadioButton("Yes");
		syndicateGroup.add(syndicateYesButton);
		syndicateNoButton = new JRadioButton("No");
		syndicateGroup.add(syndicateNoButton);
		
		panel.add(syndicateYesButton);
		panel.add(syndicateNoButton);
		
		JLabel syndicateId = new JLabel("Syndicate ID");
		syndicateIdField = new JFormattedTextField();
		panel.add(syndicateId);
		panel.add(syndicateIdField);
		
		JLabel syndicateTax = new JLabel("Syndicate tax");
		syndicateTaxField = new JFormattedTextField();
		panel.add(syndicateTax);
		panel.add(syndicateTaxField);
		
		
		concludeButton = new JButton("Save changes");
		concludeButton.addActionListener(this);
		panel.add(concludeButton);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.pack();
		
		frame.setVisible(true);
	}
	
	private void searchEmployee() {
		if(idField.getText().isBlank()) {
			result.setText("The ID field cannot de blank!");
			return;
		}
		
		try {
			int id = Integer.valueOf(idField.getText());
			if(Main.employees.containsKey(id)) {
				Employee employee = Main.employees.get(id);
				newIdField.setText(String.valueOf(employee.getId()));
				nameField.setText(employee.getName());
				adressCityField.setText(employee.getAdress().getCity());
				adressStateField.setText(employee.getAdress().getState());
				adressCountryField.setText(employee.getAdress().getCountry());
				if(employee.getSalaryType() == SalaryType.HOURLY) {
					salaryTypeButtonHourly.setSelected(true);
					salary_taxField.setText(String.valueOf(((Hourly)employee).getSalary()));
				} else if(employee.getSalaryType() == SalaryType.SALARIED) {
					salaryTypeButtonSalaried.setSelected(true);
					salary_taxField.setText(String.valueOf(((Salaried)employee).getSalary()));
				} else if(employee.getSalaryType() == SalaryType.COMISSIONED) {
					salaryTypeButtonComissioned.setSelected(true);
					salary_taxField.setText(String.valueOf(((ComissionedSalaried)employee).getComissionedTax()));
				}
				
				if(employee.getPaymentMethod() == PaymentMethod.MAIL_CHECK) {
					paymentMethodButtonMail.setSelected(true);
				} else if(employee.getPaymentMethod() == PaymentMethod.HAND_CHECK) {
					paymentMethodButtonHand.setSelected(true);
				} else if(employee.getPaymentMethod() == PaymentMethod.DEPOSIT_BANK_ACCOUNT) {
					paymentMethodButtonDeposit.setSelected(true);
				}
				
				if(employee.isOnSyndicate()) {
					syndicateYesButton.setSelected(true);
					if(Main.syndicate.containsKey(employee.getSyndicateId())) {
						syndicateIdField.setText(String.valueOf(employee.getSyndicateId()));
						syndicateTaxField.setText(String.valueOf(Main.syndicate.get(employee.getSyndicateId()).getSyndicateTax()));
					}
				} else {
					syndicateNoButton.setSelected(true);
					syndicateIdField.setText("-1");
					syndicateTaxField.setText("-1");
				}
				
			} else {
				result.setText("ID not founded!");
			}
		} catch (Exception e) {
			result.setText("The ID field cannot de blank!");
		}
	}
	
	private void changeEmployeeInfo() {
		if(newIdField.getText().isBlank()) {
			result.setText("The ID field cannot de blank!");
			return;
		}
		
		if(nameField.getText().isBlank()) {
			result.setText("The name field cannot de blank!");
			return;
		}
		
		if(adressCityField.getText().isBlank()) {
			result.setText("The city field cannot de blank!");
			return;
		}
		
		if(adressStateField.getText().isBlank()) {
			result.setText("The state field cannot de blank!");
			return;
		}
		
		if(adressCountryField.getText().isBlank()) {
			result.setText("The country field cannot de blank!");
			return;
		}
		
		if(salaryTypeGroup.getSelection() == null) {
			result.setText("The salary type is not selected!");
			return;
		}
		
		if(salary_taxField.getText().isBlank()) {
			result.setText("The salary field cannot de blank!");
			return;
		}
		
		if(paymentMethodGroup.getSelection() == null) {
			result.setText("The payment method is not selected!");
			return;
		}
		
		if(syndicateGroup.getSelection() == null) {
			result.setText("The syndicate option is not selected!");
			return;
		}
		
		if(syndicateYesButton.isSelected() && syndicateIdField.getText().isBlank()) {
			result.setText("The syndicate ID field cannot de blank!");
			return;
		}
		
		if(syndicateYesButton.isSelected() && syndicateTaxField.getText().isBlank()) {
			result.setText("The syndicate tax field cannot de blank!");
			return;
		}
		
		try {
			int oldID = Integer.valueOf(idField.getText());
			int newID = Integer.valueOf(newIdField.getText());
			
			if(newID < 0) {
				result.setText("The new ID must be greater than 0!");
				return;
			}
			
			PaymentMethod paymentMethod = null;
			if(paymentMethodButtonMail.isSelected()) {
				paymentMethod = PaymentMethod.MAIL_CHECK;
			} else if(paymentMethodButtonDeposit.isSelected()) {
				paymentMethod = PaymentMethod.DEPOSIT_BANK_ACCOUNT;
			} else if(paymentMethodButtonHand.isSelected()) {
				paymentMethod = PaymentMethod.HAND_CHECK;
			}
			
			if(Main.employees.containsKey(oldID)) {
				
				boolean onSyndicate = false;
				int oldSyndicateID = Main.employees.get(oldID).getSyndicateId();
				int newSyndicateID = Integer.valueOf(syndicateIdField.getText());
				int syndicateId = -1;
				
				if(syndicateYesButton.isSelected()) {
					
					if(newSyndicateID < 0) {
						result.setText("The new syndicate ID must be greater than 0!");
						return;
					}
					
					if(Main.syndicate.containsKey(newSyndicateID) && (syndicateId != oldSyndicateID)) {
						result.setText("The syndicate ID is already in use!");
						return;
					}
					
					onSyndicate = true;
					if(Main.syndicate.containsKey(oldSyndicateID)) {
						Main.syndicate.remove(oldSyndicateID);
						syndicateId = newSyndicateID;
					} else {					
						syndicateId = Main.syndicate.size();
						if(Main.syndicate.containsKey(syndicateId)) {
							while(Main.syndicate.containsKey(syndicateId))
								syndicateId++;
						}
					}
				} else if(syndicateNoButton.isSelected()) {
					onSyndicate = false;
					syndicateId = -1;
					
					if(Main.syndicate.containsKey(oldSyndicateID)) {
						Main.syndicate.remove(oldSyndicateID);
					}
				}
				
				if(Main.employees.containsKey(newID)) {	
					if(newID == oldID) {
						Main.employees.remove(oldID);
						if(salaryTypeButtonHourly.isSelected()) {
							Main.employees.put(newID, new Hourly(newID, nameField.getText(), new Adress(adressCityField.getText(), adressStateField.getText(), adressCountryField.getText()), SalaryType.HOURLY, Double.valueOf(salary_taxField.getText()), paymentMethod, onSyndicate, syndicateId));
						} else if(salaryTypeButtonSalaried.isSelected()) {
							Main.employees.put(newID, new Salaried(newID, nameField.getText(), new Adress(adressCityField.getText(), adressStateField.getText(), adressCountryField.getText()), SalaryType.SALARIED, Double.valueOf(salary_taxField.getText()), paymentMethod, onSyndicate, syndicateId));
						} else if(salaryTypeButtonComissioned.isSelected()) {
							Main.employees.put(newID, new ComissionedSalaried(newID, nameField.getText(), new Adress(adressCityField.getText(), adressStateField.getText(), adressCountryField.getText()), SalaryType.COMISSIONED, Double.valueOf(salary_taxField.getText()), paymentMethod, onSyndicate, syndicateId));
						} else {
							result.setText("Error while creating new employee!");
						}
						if(onSyndicate) {
							Main.syndicate.put(newSyndicateID, new Syndicate(newSyndicateID, Double.valueOf(syndicateTaxField.getText())));
						}
						JOptionPane.showMessageDialog(null, "Employee " + oldID + " info has been saved!", "Success!", JOptionPane.INFORMATION_MESSAGE);
						WindowEvent closingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
						Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
					} else {
						result.setText("This ID is already in use!");
					}
				} else {
					Main.employees.remove(oldID);
					if(salaryTypeButtonHourly.isSelected()) {
						Main.employees.put(newID, new Hourly(newID, nameField.getText(), new Adress(adressCityField.getText(), adressStateField.getText(), adressCountryField.getText()), SalaryType.HOURLY, Double.valueOf(salary_taxField.getText()), paymentMethod, onSyndicate, syndicateId));
					} else if(salaryTypeButtonSalaried.isSelected()) {
						Main.employees.put(newID, new Salaried(newID, nameField.getText(), new Adress(adressCityField.getText(), adressStateField.getText(), adressCountryField.getText()), SalaryType.SALARIED, Double.valueOf(salary_taxField.getText()), paymentMethod, onSyndicate, syndicateId));
					} else if(salaryTypeButtonComissioned.isSelected()) {
						Main.employees.put(newID, new ComissionedSalaried(newID, nameField.getText(), new Adress(adressCityField.getText(), adressStateField.getText(), adressCountryField.getText()), SalaryType.COMISSIONED, Double.valueOf(salary_taxField.getText()), paymentMethod, onSyndicate, syndicateId));
					} else {
						result.setText("Error while creating new employee!");
					}
					if(onSyndicate) {
						Main.syndicate.put(newSyndicateID, new Syndicate(newSyndicateID, Double.valueOf(syndicateTaxField.getText())));
					}
					JOptionPane.showMessageDialog(null, "Employee " + oldID + " info has been saved!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					WindowEvent closingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
					Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
				}
			} else {
				result.setText("ID not founded!");
			}
		} catch (Exception e) {
			result.setText("The ID or salary is not valid!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchButton) {
			searchEmployee();
		}
		
		if(e.getSource() == concludeButton) {
			changeEmployeeInfo();
		}
	}

}
