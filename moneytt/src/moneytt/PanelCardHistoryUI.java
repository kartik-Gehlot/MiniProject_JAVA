package moneytt;

import java.awt.*;
import javax.swing.*;




public class PanelCardHistoryUI extends JPanel{
	/**
	 * Declare GUI components
	 */
    public JPanel panelHistory, panelModify;
	public JPanel panelSeperationLine1, panelSeperationLine2;
	public JScrollPane scrollPaneHistory, scrollPaneDetail;
	public JLabel lblTextHistory, lblTextSelectMonth, lblTextSelectYear, lblTextSelectType;
	public JLabel lblTextModify, lblTextModifyCategory, lblTextModifyDate, lblTextModifyAmount, lblTextModifyType, lblTextModifyDetail; 
	
	public JTable tblHistory; 
    public JTextField txtModifyDate, txtModifyAmount;
    public JTextArea txtModifyDetail;
	public JComboBox<Integer> boxSelectYear;
	public JComboBox<String> boxSelectMonth, boxSelectType, boxModifyCategory, boxModifyType;
	public JButton btnSearch, btnCalendar, btnModify, btnDelete, btnRefresh;
      
	/**
	 * Create the panel.
	 */
	public PanelCardHistoryUI() {
		super();
		setBackground(new Color(230, 230, 230));
		setBounds(182, 60, 1102, 653);
		setLayout(null);
		
		

		panelModify = new JPanel();
		panelModify.setBackground(new Color(230, 230, 230));
		panelModify.setBounds(0, 410, 1102, 243);
		panelModify.setLayout(null);
		add(panelModify);
		
		panelSeperationLine1 = new JPanel();
		panelSeperationLine1.setBounds(10, 55, 1082, 4);
		panelSeperationLine1.setBackground(Color.LIGHT_GRAY);
		panelModify.add(panelSeperationLine1);
		
		lblTextModify = new JLabel("Modify");
		lblTextModify.setBounds(20, 0, 123, 55);
		panelModify.add(lblTextModify);
		
		lblTextModifyCategory = new JLabel("category");
		lblTextModifyCategory.setBounds(30, 145, 78, 30);
		panelModify.add(lblTextModifyCategory);
		
		boxModifyCategory = new JComboBox<>();
		boxModifyCategory.setBounds(110, 145, 130, 30);
		boxModifyCategory.setBackground(Color.WHITE);
		panelModify.add(boxModifyCategory);
		
		lblTextModifyDate = new JLabel("date");
		lblTextModifyDate.setBounds(296, 85, 45, 30);
		panelModify.add(lblTextModifyDate);
		
		lblTextModifyType = new JLabel("type");
		lblTextModifyType.setBounds(51, 85, 45, 30);
		panelModify.add(lblTextModifyType);
		
		txtModifyDate = new JTextField();
		txtModifyDate.setBounds(343, 85, 130, 30);
		txtModifyDate.setEditable(false);
		txtModifyDate.setColumns(10);
		txtModifyDate.setBackground(Color.WHITE);
		panelModify.add(txtModifyDate);
		
		boxModifyType = new JComboBox<>();
		boxModifyType.setBounds(110, 85, 130, 30);
		boxModifyType.setBackground(Color.WHITE);
		panelModify.add(boxModifyType);
		
		btnCalendar = new JButton("");
		btnCalendar.setBounds(474, 85, 30, 30);

		panelModify.add(btnCalendar);
		
		
		lblTextModifyAmount = new JLabel("amount");
		lblTextModifyAmount.setBounds(271, 145, 70, 30);
		panelModify.add(lblTextModifyAmount);

		
		txtModifyAmount = new JTextField();
		txtModifyAmount.setBounds(342, 145, 130, 30);
	txtModifyAmount.setColumns(10);
		txtModifyAmount.setBackground(Color.WHITE);
		panelModify.add(txtModifyAmount);
		
		txtModifyDetail = new JTextArea();

		txtModifyDetail.setBounds(630, 570, 130, 71);


		
		btnModify = new JButton("Modify");
		btnModify.setBounds(519, 73, 120, 30);

		panelModify.add(btnModify);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(519, 120, 120, 30);

		panelModify.add(btnDelete);
		
		
		
		panelHistory = new JPanel();
		panelHistory.setBackground(new Color(230, 230, 230));
		panelHistory.setBounds(0, 1, 1102, 410);
		panelHistory.setLayout(null);
		add(panelHistory);
		
		panelSeperationLine2 = new JPanel();
		panelSeperationLine2.setBounds(10, 65, 1082, 4);
		panelSeperationLine2.setBackground(Color.LIGHT_GRAY);
		panelHistory.add(panelSeperationLine2);
		
		lblTextHistory = new JLabel("History");
		lblTextHistory.setBounds(20, 10, 123, 55);
		panelHistory.add(lblTextHistory);
		
		lblTextSelectMonth = new JLabel("Select Month");
		lblTextSelectMonth.setBounds(21, 90, 123, 30);
		panelHistory.add(lblTextSelectMonth);
		
		boxSelectMonth = new JComboBox<>(DBRecordsService.MONTHS);
		boxSelectMonth.setBounds(20, 130, 120, 30);
		boxSelectMonth.setBackground(Color.WHITE);
		panelHistory.add(boxSelectMonth);
		
		
		lblTextSelectYear = new JLabel("Select Year");
		lblTextSelectYear.setBounds(171, 90, 100, 30);
		panelHistory.add(lblTextSelectYear);
		
		boxSelectYear = new JComboBox<>();
		boxSelectYear.setBounds(171, 130, 120, 30);
		boxSelectYear.setBackground(Color.WHITE);
		panelHistory.add(boxSelectYear);
		
		
		lblTextSelectType = new JLabel("Select Type");
		lblTextSelectType.setBounds(317, 90, 123, 30);
		panelHistory.add(lblTextSelectType);
		
		boxSelectType = new JComboBox<>(new String[] {"Expense"});
		boxSelectType.setBounds(317, 130, 120, 30);
		boxSelectType.setBackground(Color.WHITE);
		panelHistory.add(boxSelectType);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(464, 130, 120, 30);
		panelHistory.add(btnSearch);
	}
}
