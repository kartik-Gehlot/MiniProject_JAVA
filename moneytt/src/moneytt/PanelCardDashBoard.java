package moneytt;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class PanelCardDashBoard extends PanelCardDashBoardUI implements ActionListener{

	private int userID;

	private Calendar cal = new GregorianCalendar();

	public PanelCardDashBoard(int uid) {
		super();
		this.userID = uid;
		btnSearch.addActionListener(this);
		// set range of year to select
		for(int i=cal.get(Calendar.YEAR)-10; i<=cal.get(Calendar.YEAR); i++){
			boxSelectYear.addItem(i);
        }
		// show current month and year
		boxSelectMonth.setSelectedIndex(cal.get(Calendar.MONTH));	
		boxSelectYear.setSelectedItem(cal.get(Calendar.YEAR));	
//		this.setActionPerformed();	
		this.loadStatistic();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			this.loadStatistic();
        }
	}
	
	public void loadStatistic() {
		int month = boxSelectMonth.getSelectedIndex()+1;	
		int year = (int)boxSelectYear.getSelectedItem();
		Object sum = 0;
		    
		try {
			sum = DBRecordsService.searchStatictic(userID, month, year, Record.TYPEEXPENSE);
			lblAmountExpense.setText(sum.toString());
			int expense = Integer.parseInt(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, Record.TYPEEXPENSE, "Food");
			lblAmountFood.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, Record.TYPEEXPENSE, "Transport");
			lblAmountTransport.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, Record.TYPEEXPENSE, "Clothing");
			lblAmountClothing.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, Record.TYPEEXPENSE, "Housing");
			lblAmountHousing.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, Record.TYPEEXPENSE, "Education");
			lblAmountEducation.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, Record.TYPEEXPENSE, "Recreation");
			lblAmountRecreation.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, Record.TYPEEXPENSE, "Healthcare");
			lblAmountHealthcare.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, Record.TYPEEXPENSE, "Others");
			lblAmountExpenseOthers.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, Record.TYPEEXPENSE, "Misc");
			lblamoumisc.setText(sum.toString());
			

		} catch(Exception e) {
		    e.printStackTrace();
		}
	}
}
