package moneytt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;



public class SignupPage extends SignupPageUI implements ActionListener{
	
	public static void main(String[] args) {
		SignupPage window = new SignupPage();
		window.setVisible(true);
	}
	
	/**
	 * Create the frame
	 */
	public SignupPage() {
		super();
		btnPasswordShow.addActionListener(this);
		btnSignUp.addActionListener(this);
		btnLogIn.addActionListener(this);

	}
	
	/**
	 * Override actionListener's method.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
    {
		if (e.getSource() == btnPasswordShow) {
        	if(btnPasswordShow.isSelected()) 
        		txtPassword.setEchoChar((char)0);
        	else 
        		txtPassword.setEchoChar('*');
        }
		else if (e.getSource() == btnSignUp) {
	        if (this.checkSignup() == true) {
	        	this.insertSignup();
	        }
	        else
	        	return;
		}
		else if (e.getSource() == btnLogIn) {
			LoginPage login = new LoginPage();
			login.setVisible(true);
			this.dispose();
		}
    }

	
	private boolean checkSignup(){
		String username = txtUsername.getText();
		String email = txtEmail.getText();
		String phone = txtPhone.getText();
        String password = new String(txtPassword.getPassword());
        
        if(username.equals("")) {
        	JOptionPane.showMessageDialog(this, "Please enter username.");
        	return false;
        }
        if(email.equals("") || !email.matches("^.+@.+\\..+$")) {
        	JOptionPane.showMessageDialog(this, "Please enter valid email.");
        	return false;
        }
        if(phone.equals("") ) {		
        	JOptionPane.showMessageDialog(this, "Please enter phone.");
        	return false;
        }
        if ( !(phone.matches("[0-9]+")) ){	
        	JOptionPane.showMessageDialog(this, "Please enter only numbers at phone field.");
        	return false;
        }
        if(password.equals("")) {
        	JOptionPane.showMessageDialog(this, "Please enter password.");
        	return false;
        }
        if ( !(password.matches("[a-z0-9A-Z]+")) ){	
        	JOptionPane.showMessageDialog(this, "Please enter only numbers and letters at password field.");
        	return false;
        }
        return true;
	}
	

	//new user 
	private void insertSignup() {
		String username = txtUsername.getText();
		String email = txtEmail.getText();
		String phone = txtPhone.getText();
	    String password = new String(txtPassword.getPassword());
	    
	    int updatedRowCount = DBUserService.createUser(new User(-1, username, email, phone, password));
	    if(updatedRowCount == 1) {
	    	JOptionPane.showMessageDialog(this, "Registration successful. \nYou will be redirected to the login page.");
	    	LoginPage login = new LoginPage();	
			login.setVisible(true);
	    	this.dispose();
		}
		else if(updatedRowCount == -1) { 
			JOptionPane.showMessageDialog(this, "Registration failed. \nThe username, email, or phone number had been already registered.");
		}
		else if(updatedRowCount == -2) {
			JOptionPane.showMessageDialog(this, "Something wrong. \nRegistration failed. \n Please re-register.");
		}	    	
	}
}
