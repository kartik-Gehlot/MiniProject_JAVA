package moneytt;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;



public class PanelCardAddExpense extends PanelCardAddExpenseUI implements ActionListener{
	/**
	 * Receive userid
	 */
	private int userID;
	
	/**
	 * InnerClass : SwingCalendar(extends JFrame) 
	 */
	private class innerCalendar extends SwingCalendar{
		public innerCalendar(){
			super();
		}
		
		@Override
		public void getSelectDate() {
		    super.getSelectDate();
		    txtDate.setText(SELECTDATE);
		    this.dispose();  // dispose after choose date
		}
	}
	
	/**
	 * Create the panel.
	 */
	public PanelCardAddExpense(int uid) {
		super();
		this.userID = uid;
		// add actionListener
		btnClear.addActionListener(this);
		btnAdd.addActionListener(this);
		btnCalendar.addActionListener(this);

		
	}
	
	/**
	 * Override actionListener's method.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			this.clearInput();
		}
		else if (e.getSource() == btnAdd) {
			if (this.checkAddExpense() == true)
				this.insertExpense();
	        else
	        	return;
		}
		else if (e.getSource() == btnCalendar) {
			innerCalendar calendar = new innerCalendar();
			calendar.setVisible(true);
		}		
	}
	
	/**
	 * Clear user input of expense
	 */
	public void clearInput() {
		this.boxCategory.setSelectedItem(null);
		this.txtDate.setText("");
		this.txtAmount.setText("");
		this.txtDetail.setText("");
	}
	
	/**
	 * Method to check expense data
	 */ 
	private boolean checkAddExpense(){
		String date = txtDate.getText();
		String amount = txtAmount.getText();
        
		if(boxCategory.getSelectedItem() == null) {
        	JOptionPane.showMessageDialog(this, "Please select category.");
        	return false;
        }
        if(date.equals("")) {
        	JOptionPane.showMessageDialog(this, "Please select date.");
        	return false;
        }
        if(amount.equals("") ) {
        	JOptionPane.showMessageDialog(this, "Please enter amount.");
        	return false;
        }
        if ( !(amount.matches("[-+]?\\d+")) ){		
        	JOptionPane.showMessageDialog(this, "Please enter only integers.");
        	return false;
        }
        if(Integer.parseInt(amount) <= 0 ) {
        	JOptionPane.showMessageDialog(this, "Please enter positive amount.");
        	return false;
        }
        return true;
	}
	
	
	private void insertExpense() {
		String category = (String)boxCategory.getSelectedItem();
		String date = txtDate.getText();
		int amount = Integer.parseInt(txtAmount.getText());
        String detail = txtDetail.getText();
        
        int updatedRowCount = DBRecordsService.createRecord(new Record(-1, this.userID, category, date, amount, Record.TYPEEXPENSE, detail));
        if(updatedRowCount == 1) {
	    	JOptionPane.showMessageDialog(this, "Record expense information successfully.");
	    	this.clearInput();
        }
        else if(updatedRowCount == -1 || updatedRowCount == -2) { 
        	JOptionPane.showMessageDialog(this, "Something wrong. \nUnable to record expense information.");
        }
	}
}
