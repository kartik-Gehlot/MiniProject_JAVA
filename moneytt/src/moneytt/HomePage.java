package moneytt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class HomePage extends JFrame {
	
	private User user;
	public JPanel panelTop;
	public JLabel lblTextAppName, lblTextWelcome;
	public JPanel panelMenu, panelMenuDashBoard, panelMenuHistory, panelMenuAddExpense, panelMenuLogOut;
	public JLabel lblTextMenuDashBoard, lblTextMenuHistory, lblTextMenuAddExpense, lblTextMenuLogOut;
	public JPanel panelCard;
	
	private JPanel cardDashBoard, cardHistory, cardAddExpense ;

	


	
	public HomePage(User user) {
		
		
		setTitle("APPLICATION");	
		setBounds(100, 25, 1300, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		

		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 0, 0));
		panelMenu.setBounds(0, 00, 182, 653);
		panelMenu.setLayout(null);
		getContentPane().add(panelMenu);
		
		panelMenuDashBoard = new JPanel();
		panelMenuDashBoard.setForeground(Color.BLACK);
		panelMenuDashBoard.setBackground(Color.BLACK);
		panelMenuDashBoard.setBounds(0, 0, 182, 40);
		panelMenuDashBoard.setLayout(null);
		panelMenu.add(panelMenuDashBoard);
		
		lblTextMenuDashBoard = new JLabel("Dash Board");
		lblTextMenuDashBoard.setBounds(0, 0, 138, 40);
		lblTextMenuDashBoard.setBackground(Color.WHITE);
		lblTextMenuDashBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMenuDashBoard.setForeground(Color.WHITE);
		lblTextMenuDashBoard.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelMenuDashBoard.add(lblTextMenuDashBoard);
		
		panelMenuHistory = new JPanel();
		panelMenuHistory.setForeground(Color.BLACK);
		panelMenuHistory.setBackground(Color.BLACK);
		panelMenuHistory.setBounds(0, 50, 182, 60);
		panelMenu.add(panelMenuHistory);
		panelMenuHistory.setLayout(null);
		
		lblTextMenuHistory = new JLabel("History");
		lblTextMenuHistory.setBounds(20, 0, 138, 40);
		panelMenuHistory.add(lblTextMenuHistory);
		lblTextMenuHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMenuHistory.setForeground(Color.WHITE);
		lblTextMenuHistory.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextMenuHistory.setBackground(Color.WHITE);
		
		panelMenuAddExpense = new JPanel();
		panelMenuAddExpense.setForeground(Color.BLACK);
		panelMenuAddExpense.setLayout(null);
		panelMenuAddExpense.setBackground(Color.BLACK);
		panelMenuAddExpense.setBounds(0, 100, 182, 40);
		panelMenu.add(panelMenuAddExpense);
		
		lblTextMenuAddExpense = new JLabel("Add Expense");
		lblTextMenuAddExpense.setBounds(20, 0, 138, 40);
		panelMenuAddExpense.add(lblTextMenuAddExpense);
		lblTextMenuAddExpense.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMenuAddExpense.setForeground(Color.WHITE);
		lblTextMenuAddExpense.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextMenuAddExpense.setBackground(Color.WHITE);
		

		panelMenuLogOut = new JPanel();
		panelMenuLogOut.setForeground(Color.BLACK);
		panelMenuLogOut.setLayout(null);
		panelMenuLogOut.setBackground(Color.BLACK);
		panelMenuLogOut.setBounds(0, 150, 182, 60);
		panelMenu.add(panelMenuLogOut);
		
		lblTextMenuLogOut = new JLabel("Log out");
		lblTextMenuLogOut.setBounds(20, 0, 138, 40);
		panelMenuLogOut.add(lblTextMenuLogOut);
		lblTextMenuLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMenuLogOut.setForeground(Color.WHITE);
		lblTextMenuLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextMenuLogOut.setBackground(Color.WHITE);
		
		
		panelCard = new JPanel();
		panelCard.setBounds(182, 60, 1300, 653);
		panelCard.setLayout(new CardLayout(0, 0));
		getContentPane().add(panelCard);
		
		
		
		this.user = user;


		cardDashBoard = new PanelCardDashBoard(this.user.getUserID());
		cardHistory = new PanelCardHistory(this.user.getUserID());
		cardAddExpense = new PanelCardAddExpense(this.user.getUserID());

		panelCard.add(cardDashBoard, "cardDashBoard");
		panelCard.add(cardHistory, "cardHistory");
		panelCard.add(cardAddExpense, "cardAddExpense");

		this.setActionPerformed();
	}
	
	
	private void setActionPerformed() {
		panelMenuDashBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeMenuColor(panelMenuDashBoard);
				((PanelCardDashBoard) cardDashBoard).loadStatistic();
				CardLayout cl = (CardLayout)(panelCard.getLayout());
	            cl.show(panelCard, "cardDashBoard");
			}
		});
		panelMenuHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeMenuColor(panelMenuHistory);
				((PanelCardHistory) cardHistory).loadRecords();
				((PanelCardHistory) cardHistory).refreshRecord();
				CardLayout cl = (CardLayout)(panelCard.getLayout());
	            cl.show(panelCard, "cardHistory");
			}
		});
		panelMenuAddExpense.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeMenuColor(panelMenuAddExpense);
				((PanelCardAddExpense) cardAddExpense).clearInput();
				CardLayout cl = (CardLayout)(panelCard.getLayout());
	            cl.show(panelCard, "cardAddExpense");
			}
		});

		panelMenuLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage login = new LoginPage();
				login.setVisible(true);	// redirect to login page
				dispose();	
			}
		});
	}

	
	private void changeMenuColor(JPanel panelSelect) {
		
		panelSelect.setBackground(Color.PINK);
	}
}

