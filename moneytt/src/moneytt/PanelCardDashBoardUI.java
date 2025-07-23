package moneytt;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;



public class PanelCardDashBoardUI extends JPanel {
	
	public JPanel panelSelectDate, panelAllExpense  ; 
	public JPanel panelExpense, panelFood, panelTransport, panelClothing, panelHousing, 
					panelEducation, panelRecreation, panelHealthcare, panelExpenseOthers,  panelmisc;

	public JLabel lblTextStatistic, lblTextSelectMonth, lblTextSelectYear;
	public JComboBox<String> boxSelectMonth;
	public JComboBox<Integer> boxSelectYear;
	public JButton btnSearch;
	public JLabel  lblAmountExpense, lblAmountFood, lblAmountTransport, 
					lblAmountClothing, lblAmountHousing, lblAmountEducation, lblAmountRecreation, 
					lblAmountHealthcare, lblAmountExpenseOthers,lblamoumisc; 
	public JLabel lblTextExpense, lblTextFood, lblTextTransport, lblTextClothing, lblmisc,
					lblTextHousing, lblTextEducation, lblTextRecreation, 
					lblTextHealthcare, lblTextExpenseOthers;
	 
	

	

	
	public PanelCardDashBoardUI() {
		super();	
		setBackground(new Color(230, 230, 230));
		setBounds(182, 60, 1102, 1153);
		setLayout(null);

		
		
		lblTextStatistic = new JLabel("Statistics");
		lblTextStatistic.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTextStatistic.setBounds(20, 10, 311, 55);
		add(lblTextStatistic);
		
		
		

		// start panelSelectDate section
		panelSelectDate = new JPanel();
		panelSelectDate.setBackground(new Color(230, 230, 230));
		panelSelectDate.setBounds(10, 75, 1072, 93);
		add(panelSelectDate);
		panelSelectDate.setLayout(null);
		
		lblTextSelectMonth = new JLabel("Select Month");
		lblTextSelectMonth.setBounds(11, 10, 123, 30);
		panelSelectDate.add(lblTextSelectMonth);
		
		boxSelectMonth = new JComboBox<>(DBRecordsService.MONTHS);
		boxSelectMonth.setBackground(Color.WHITE);
		boxSelectMonth.setBounds(10, 50, 120, 30);
		panelSelectDate.add(boxSelectMonth);
		
		lblTextSelectYear = new JLabel("Select Year");
		lblTextSelectYear.setBounds(201, 10, 100, 30);
		panelSelectDate.add(lblTextSelectYear);
		
		boxSelectYear = new JComboBox<>();
			boxSelectYear.setBackground(Color.WHITE);
		boxSelectYear.setBounds(201, 50, 120, 30);
		panelSelectDate.add(boxSelectYear);
		
		btnSearch = new JButton("Search");
				btnSearch.setBounds(401, 50, 120, 30);
		panelSelectDate.add(btnSearch);
		

		// start panelAllExpense section
		panelAllExpense = new JPanel();
		panelAllExpense.setBackground(new Color(230, 230, 230));
		panelAllExpense.setBounds(10, 182, 1082, 665);
		add(panelAllExpense);
		panelAllExpense.setLayout(null);

		panelExpense = new JPanel();
		panelExpense.setBounds(0, 42, 188, 85);
		panelExpense.setLayout(null);
		panelAllExpense.add(panelExpense);

		

		lblTextExpense = new JLabel(Record.TYPEEXPENSE);
		lblTextExpense.setHorizontalAlignment(SwingConstants.TRAILING);
				lblTextExpense.setBounds(87, 10, 91, 40);
		panelExpense.add(lblTextExpense);

		lblAmountExpense = new JLabel("1000");
		lblAmountExpense.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountExpense.setForeground(Color.RED);
				lblAmountExpense.setBounds(93, 50, 85, 30);
		panelExpense.add(lblAmountExpense);
		
		panelFood = new JPanel();
		panelFood.setBounds(212, 20, 200, 60);
		panelFood.setLayout(null);
	
		panelAllExpense.add(panelFood);
		
		lblTextFood = new JLabel("Food");
		lblTextFood.setHorizontalAlignment(SwingConstants.LEFT);
				lblTextFood.setBounds(10, 10, 73, 40);
		panelFood.add(lblTextFood);
		
		lblAmountFood = new JLabel("1000");
		lblAmountFood.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountFood.setForeground(Color.RED);
				lblAmountFood.setBounds(122, 10, 73, 40);
		panelFood.add(lblAmountFood);
		
		panelTransport = new JPanel();
		panelTransport.setBounds(212, 90, 200, 60);
		panelTransport.setLayout(null);
	
		panelAllExpense.add(panelTransport);
		
		lblTextTransport = new JLabel("Transport");
		lblTextTransport.setHorizontalAlignment(SwingConstants.LEFT);
				lblTextTransport.setBounds(10, 10, 102, 40);
		panelTransport.add(lblTextTransport);
		
		lblAmountTransport = new JLabel("1000");
		lblAmountTransport.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountTransport.setForeground(Color.RED);
				lblAmountTransport.setBounds(122, 10, 73, 40);
		panelTransport.add(lblAmountTransport);

		panelClothing = new JPanel();
		panelClothing.setBounds(432, 20, 200, 60);
		panelClothing.setLayout(null);
	
		panelAllExpense.add(panelClothing);
		
		lblTextClothing = new JLabel("Clothing");
		lblTextClothing.setHorizontalAlignment(SwingConstants.LEFT);
				lblTextClothing.setBounds(10, 10, 115, 40);
		panelClothing.add(lblTextClothing);
		
		lblAmountClothing = new JLabel("1000");
		lblAmountClothing.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountClothing.setForeground(Color.RED);
				lblAmountClothing.setBounds(122, 10, 73, 40);
		panelClothing.add(lblAmountClothing);
		
		panelHousing = new JPanel();
		panelHousing.setBounds(432, 90, 200, 60);
		panelHousing.setLayout(null);
	
		panelAllExpense.add(panelHousing);
		
		lblTextHousing = new JLabel("Housing");
		lblTextHousing.setHorizontalAlignment(SwingConstants.LEFT);
				lblTextHousing.setBounds(10, 10, 115, 40);
		panelHousing.add(lblTextHousing);
		
		lblAmountHousing = new JLabel("1000");
		lblAmountHousing.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountHousing.setForeground(Color.RED);
				lblAmountHousing.setBounds(122, 10, 73, 40);
		panelHousing.add(lblAmountHousing);
		
		panelEducation = new JPanel();
		panelEducation.setBounds(652, 20, 200, 60);
		panelEducation.setLayout(null);

		panelAllExpense.add(panelEducation);
		
		lblTextEducation = new JLabel("Education");
		lblTextEducation.setHorizontalAlignment(SwingConstants.LEFT);
				lblTextEducation.setBounds(10, 10, 115, 40);
		panelEducation.add(lblTextEducation);
		
		lblAmountEducation = new JLabel("1000");
		lblAmountEducation.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountEducation.setForeground(Color.RED);
				lblAmountEducation.setBounds(122, 10, 73, 40);
		panelEducation.add(lblAmountEducation);
		
		panelRecreation = new JPanel();
		panelRecreation.setBounds(652, 90, 200, 60);
		panelRecreation.setLayout(null);
		
		panelAllExpense.add(panelRecreation);
		
		lblTextRecreation = new JLabel("Recreation");
		lblTextRecreation.setHorizontalAlignment(SwingConstants.LEFT);
				lblTextRecreation.setBounds(10, 10, 115, 40);
		panelRecreation.add(lblTextRecreation);
		
		lblAmountRecreation = new JLabel("1000");
		lblAmountRecreation.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountRecreation.setForeground(Color.RED);
				lblAmountRecreation.setBounds(122, 10, 73, 40);
		panelRecreation.add(lblAmountRecreation);
		
		panelHealthcare = new JPanel();
		panelHealthcare.setBounds(872, 20, 200, 60);
		panelHealthcare.setLayout(null);
	
		panelAllExpense.add(panelHealthcare);
		
		lblTextHealthcare = new JLabel("Healthcare");
		lblTextHealthcare.setHorizontalAlignment(SwingConstants.LEFT);
				lblTextHealthcare.setBounds(10, 10, 115, 40);
		panelHealthcare.add(lblTextHealthcare);
		
		lblAmountHealthcare = new JLabel("1000");
		lblAmountHealthcare.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountHealthcare.setForeground(Color.RED);
				lblAmountHealthcare.setBounds(122, 10, 73, 40);
		panelHealthcare.add(lblAmountHealthcare);
		
		panelExpenseOthers = new JPanel();
		panelExpenseOthers.setBounds(872, 90, 200, 60);
		panelExpenseOthers.setLayout(null);

		panelAllExpense.add(panelExpenseOthers);

		lblTextExpenseOthers = new JLabel("Others");
		
	
		lblTextExpenseOthers.setBounds(10, 10, 73, 40);
		panelExpenseOthers.add(lblTextExpenseOthers);
		
		lblAmountExpenseOthers = new JLabel("1000");

		lblAmountExpenseOthers.setForeground(Color.RED);
				lblAmountExpenseOthers.setBounds(122, 10, 73, 40);
		panelExpenseOthers.add(lblAmountExpenseOthers);
	//new
		panelmisc = new JPanel();
		panelmisc.setBounds(212, 160, 200, 60);
		panelmisc.setLayout(null);
	
		panelAllExpense.add(panelmisc);
		
		lblmisc = new JLabel("Misc");
		lblmisc.setHorizontalAlignment(SwingConstants.LEFT);
		lblmisc.setBounds(10, 10, 133, 40);
		panelmisc.add(lblmisc);
		
		lblamoumisc = new JLabel("1000");
		lblamoumisc.setHorizontalAlignment(SwingConstants.TRAILING);
		lblamoumisc.setForeground(Color.RED);
		lblamoumisc.setBounds(122, 10, 73, 40);
		panelmisc.add(lblamoumisc);

		
//	panelFood = new JPanel();
//		panelFood.setBounds(212, 20, 200, 60);
//		panelFood.setLayout(null);
//	
//		panelAllExpense.add(panelFood);
//		
//		lblTextFood = new JLabel("Food");
//		lblTextFood.setHorizontalAlignment(SwingConstants.LEFT);
//				lblTextFood.setBounds(10, 10, 73, 40);
//		panelFood.add(lblTextFood);
//		
//		lblAmountFood = new JLabel("1000");
//		lblAmountFood.setHorizontalAlignment(SwingConstants.TRAILING);
//		lblAmountFood.setForeground(Color.RED);
//				lblAmountFood.setBounds(122, 10, 73, 40);
//		panelFood.add(lblAmountFood);

	}
}
