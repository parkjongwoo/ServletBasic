package mvc.sql;

public class SQL {
	public static final String MEMO_SEQ_ID = "SEQ_MEMO_ID";

	public static final String MEMO_TABLE_NAME_MEMO = "memo";
	
	public static final String MEMO_COLUMN_NAME_ID = "memoid";
	public static final String MEMO_COLUMN_NAME_NAME = "name";
	public static final String MEMO_COLUMN_NAME_AGE = "age";
	public static final String MEMO_ALL_COUNT_COLUMN_NAME = "CNT";
	
	public static final String MEMO_SELECT_ALL = "SELECT * FROM "+MEMO_TABLE_NAME_MEMO;
	public static final String MEMO_SELECT_ALL_ORDER_BY = "SELECT * FROM "+MEMO_TABLE_NAME_MEMO + " ORDER BY "+MEMO_COLUMN_NAME_ID+" DESC";
	public static final String MEMO_SELECT_BY_ID = MEMO_SELECT_ALL + " WHERE "+MEMO_COLUMN_NAME_ID+"=?";
	public static final String MEMO_SELECT_BY_NAME = MEMO_SELECT_ALL + " WHERE "+MEMO_COLUMN_NAME_NAME+" LIKE ?";
	public static final String MEMO_SELECT_BY_MEMO = MEMO_SELECT_ALL + " WHERE "+MEMO_COLUMN_NAME_AGE+" LIKE ?";
	public static final String MEMO_ALL_COUNT = "SELECT COUNT(*) "+MEMO_ALL_COUNT_COLUMN_NAME+" FROM " + MEMO_TABLE_NAME_MEMO;
	public static final String MEMO_SELECT_BY_COUNT = "SELECT memoid, name, age FROM "
			+ " (SELECT rownum rnum, m.* FROM "
			+ " (SELECT * FROM memo ORDER BY memoid ASC) m) "
			+ " WHERE rnum BETWEEN ? AND ?";
	
	public static final String MEMO_INSERT = "INSERT INTO "+MEMO_TABLE_NAME_MEMO+" VALUES (" + 
												MEMO_SEQ_ID + ".NEXTVAL, " + 
												"?, " + 
												"? )";
	
	public static final String MEMO_UPDATE = "UPDATE "+MEMO_TABLE_NAME_MEMO+" SET " + 
												MEMO_COLUMN_NAME_NAME + "=?, " + 
												MEMO_COLUMN_NAME_AGE + "=? " + 
												" WHERE "+MEMO_COLUMN_NAME_ID+"=?";
	
	public static final String MEMO_DELETE_BY_ID = "DELETE "+MEMO_TABLE_NAME_MEMO+" WHERE "+MEMO_COLUMN_NAME_ID+"=?";
}
