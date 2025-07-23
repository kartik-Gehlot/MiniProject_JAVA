package moneytt;

public class Record {
    private int record_id;   
    private int user_id;
    private String category;
    private String date;
    private int amount;
    private String type;
    private String detail;
    public static final String TABLE_NAME = "records";
    
    public static final String COLUMN_RECORDID = "record_id";
    public static final String COLUMN_USERID = "user_id";
	public static final String COLUMN_CATEGORY = "category";
	public static final String COLUMN_DATE = "date";
	public static final String COLUMN_AMOUNT = "amount";
	public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_DETAIL = "detail";

    public static final String TYPEEXPENSE = "Expense";
   
    
    public static final String[] TABLECOLUMNNAMES = {"record_id", "type", "category", "date", "amount", "detail"};
    public static final String[] LISTEXPENSE = {"Food", "Clothing", "Housing", "Transport", "Education", "Recreation", "Healthcare", "Others","Misc"};

    public static final String[] LISTTYPE = {"Expense"};

    public Record(int record_id, int user_id, String category, String date, int amount, String type, String detail) {
        setRecord_ID(record_id);
        setUser_ID(user_id);
        setCategory(category);
        setDate(date);
        setAmount(amount);
        setType(type);
        setDetail(detail);
    }

    private void setRecord_ID(int record_id) {
        this.record_id = record_id;
    }

    private void setUser_ID(int user_id) {
        this.user_id = user_id;
    }

    private void setCategory(String category) {
        this.category = category;
    }

    private void setDate(String date) {
        this.date = date;
    }

    private void setAmount(int amount) {
        this.amount = amount;
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setDetail(String detail) {
        this.detail = detail;
    }

    public int getRecordID() {
        return record_id;
    }

    public int getUserID() {
        return user_id;
    }
    
    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return String.format("Record{record_id=%d, user_id=%d, category='%s', date='%s', amount='%d', type='%s', detail='%s'}",
                        getRecordID(), getUserID(), getCategory(), getDate(), getAmount(), getType(), getDetail());
    }
    
      
    }

