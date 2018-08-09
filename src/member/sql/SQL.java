package member.sql;

public class SQL {
	public static final String MEMBER_TABLE_NAME_MEMBER = "member";
	
	public static final String MEMBER_COLUMN_NAME_ID = "memberid";
	public static final String MEMBER_COLUMN_NAME_PW = "password";
	public static final String MEMBER_COLUMN_NAME_NAME = "name";
	public static final String MEMBER_COLUMN_NAME_ZENDER = "gender";
	public static final String MEMBER_COLUMN_NAME_EMAIL = "email";
	public static final String MEMBER_ALL_COUNT_COLUMN_NAME = "cnt";
	
	public static final String MALE = "남자";
	public static final String FEMALE = "여자";
	
	public static final String MEMBER_SELECT_ALL = "SELECT * FROM "+MEMBER_TABLE_NAME_MEMBER;
	public static final String MEMBER_SELECT_ALL_ORDER_BY = "SELECT * FROM "+MEMBER_TABLE_NAME_MEMBER + " ORDER BY "+MEMBER_COLUMN_NAME_ID+" DESC";
	public static final String MEMBER_SELECT_BY_ID = MEMBER_SELECT_ALL + " WHERE "+MEMBER_COLUMN_NAME_ID+"=?";
	public static final String MEMBER_SELECT_BY_NAME = MEMBER_SELECT_ALL + " WHERE "+MEMBER_COLUMN_NAME_NAME+" LIKE ?";
	public static final String MEMBER_ALL_COUNT = "SELECT COUNT(*) "+MEMBER_ALL_COUNT_COLUMN_NAME+" FROM " + MEMBER_TABLE_NAME_MEMBER;
	public static final String MEMBER_SELECT_BY_COUNT = "SELECT memberid, name, age FROM "
			+ " (SELECT rownum rnum, m.* FROM "
			+ " (SELECT * FROM MEMBER ORDER BY MEMBERid ASC) m) "
			+ " WHERE rnum BETWEEN ? AND ?";
	
	public static final String MEMBER_INSERT = "INSERT INTO member values(?,?,?,?,?)";
	
	public static final String MEMBER_UPDATE = "UPDATE "+ MEMBER_TABLE_NAME_MEMBER +" SET "+ 
			MEMBER_COLUMN_NAME_PW+" = ?, " + 
			MEMBER_COLUMN_NAME_NAME+" = ?, " + 
			MEMBER_COLUMN_NAME_ZENDER+" = ? " +
			MEMBER_COLUMN_NAME_EMAIL+" = ? " +
			" WHERE "+MEMBER_COLUMN_NAME_ID+"=?";
	
	public static final String MEMBER_DELETE_BY_ID = "DELETE "+MEMBER_TABLE_NAME_MEMBER+" WHERE "+MEMBER_COLUMN_NAME_ID+"=?";
}
