package moneytt;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class SignupPageUI extends JFrame {
	
	public JPanel panelWelocme, panelSignup; 
	public JLabel lblTextSignup, lblTextUsername, lblTextEmail, lblTextPhone, lblTextPassword;
	public JLabel lblIconWelcome, lblIconUsername, lblIconEmail, lblIconPhone, lblIconPassword;

	public JTextField txtUsername, txtEmail, txtPhone;
	public JPasswordField txtPassword;
	public JCheckBox btnPasswordShow;
	public JButton btnSignUp, btnLogIn;
	
	
	public static void main(String[] args) {
		SignupPageUI window = new SignupPageUI();
		window.setVisible(true);
	}
	
	
	public SignupPageUI() {
		setTitle("Signup Page");
		setBackground(Color.PINK);
		setBounds(200, 100, 1100, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panelWelocme = new JPanel();
		panelWelocme.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		panelWelocme.setBackground(Color.WHITE);
		panelWelocme.setBounds(0, 0, 700, 563);
		panelWelocme.setLayout(null);
		getContentPane().add(panelWelocme);
		
		lblIconWelcome = new JLabel("New label");
		lblIconWelcome.setBounds(93, 31, 512, 512);

		lblIconWelcome.setIcon(new ImageIcon(SignupPageUI.class.getResource("/icon/signup_background.png")));
		panelWelocme.add(lblIconWelcome);
		
		panelSignup = new JPanel();
		panelSignup.setBackground(new Color(255, 102, 102));


		panelSignup.setBounds(700, 0, 386, 563);
		panelSignup.setLayout(null);
		getContentPane().add(panelSignup);
		
		lblTextSignup = new JLabel("Signup");
		lblTextSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextSignup.setForeground(Color.WHITE);
		lblTextSignup.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTextSignup.setBounds(100, 20, 195, 40);
		panelSignup.add(lblTextSignup);
		
		lblTextUsername = new JLabel("Username");
		lblTextUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextUsername.setForeground(Color.BLACK);
		lblTextUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextUsername.setBounds(90, 78, 195, 30);
		panelSignup.add(lblTextUsername);
		
		txtUsername = new JTextField(15);
		txtUsername.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.setFont(new Font("Serif", Font.PLAIN, 20));
		txtUsername.setBounds(90, 108, 254, 30);
		panelSignup.add(txtUsername);
		

		
		lblTextPassword = new JLabel("Password");
		lblTextPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextPassword.setForeground(Color.BLACK);
		lblTextPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextPassword.setBounds(90, 318, 195, 30);
		panelSignup.add(lblTextPassword);
		
		txtEmail = new JTextField(15);
		txtEmail.setFont(new Font("Serif", Font.PLAIN, 20));
		txtEmail.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		txtEmail.setBackground(new Color(255, 255, 255));
		txtEmail.setBounds(90, 188, 254, 30);
		panelSignup.add(txtEmail);
		
		lblTextEmail = new JLabel("Email");
		lblTextEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextEmail.setForeground(Color.BLACK);
		lblTextEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextEmail.setBounds(90, 158, 195, 30);
		panelSignup.add(lblTextEmail);
		

		
		txtPhone = new JTextField(15);
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPhone.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		txtPhone.setBackground(new Color(255, 255, 255));
		txtPhone.setBounds(90, 268, 254, 30);
		panelSignup.add(txtPhone);
		
		lblTextPhone = new JLabel("Phone");
		lblTextPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextPhone.setForeground(Color.BLACK);
		lblTextPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextPhone.setBounds(90, 238, 195, 30);
		panelSignup.add(lblTextPhone);
		

		txtPassword = new JPasswordField(15);
		txtPassword.setBackground(new Color(255, 255, 255));
		txtPassword.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPassword.setBounds(90, 348, 254, 30);
		panelSignup.add(txtPassword);
		
		btnPasswordShow = new JCheckBox("Show Password");
		btnPasswordShow.setForeground(Color.BLACK);
		btnPasswordShow.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnPasswordShow.setBackground(new Color(255, 255, 255));
		btnPasswordShow.setBounds(90, 394, 254, 20);
		panelSignup.add(btnPasswordShow);
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSignUp.setBackground(new Color(255, 255, 255));
		btnSignUp.setBounds(90, 442, 254, 40);
		panelSignup.add(btnSignUp);
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogIn.setBackground(new Color(60, 60, 255));
		btnLogIn.setBounds(128, 500, 182, 40);
		panelSignup.add(btnLogIn);
		
		
	}
}
