package db.connectionpoolbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 커넥션 풀 구현 연습
 * @author goott3-4
 *
 */
public class ConnectionPoolBean {
	
	/**
	 * oracle 로그인 정보
	 */
	private String url, user, pw;
	
	/**
	 * Connection Pool 정보 저장.
	 */
	private Hashtable<Connection, Boolean> h;
	
	/**
	 * 최대 Pool 사이즈
	 */
	private int maxIdle = 5;
	
	/**
	 * Connection 증감 단위 사이즈
	 */
	private int increment = 3;
	
	/**
	 * Connection Pool 관리 Class
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public ConnectionPoolBean() throws ClassNotFoundException, SQLException {		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		user = "scott";
		pw = "tiger";
		
		h = new Hashtable<Connection, Boolean>();
		
		initPool();
	}
	
	/**
	 * 최초 Pool 생성
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	private void initPool() throws SQLException{
		swellConnectionPool(maxIdle);
	}
	
	/**
	 * idle상태인 연결이 너무 많은지 판단.
	 * @return 많으면 true, 아니면 false
	 */
	private boolean isToManyIdleConnection() {
		return idlePoolSize()>maxIdle+increment;
	}
	
	/**
	 * Pool 크기 감소
	 * @param cnt 축소할 갯수
	 * @throws SQLException
	 */
	private synchronized void shrinkConnectionPool(int cnt) throws SQLException{
		System.out.println("shrinkConnectionPool : "+cnt);
		Connection con = null;
		for(int i=0;i<cnt;i++) {
			con = getConnection();
			h.remove(con);
			con.close();
		}
		System.out.println("pool : "+this.toString());
	}
	
	/**
	 * Pool 크기 증가
	 * @param cnt 증가할 갯수 
	 * @throws SQLException
	 */
	private synchronized void swellConnectionPool(int cnt) throws SQLException {
		System.out.println("swellConnectionPool : "+cnt);
		Connection con = null;
		for(int i=0;i<cnt;i++) {
			con = creatConnection(url, user, pw);	
			h.put(con,false);
		}
		System.out.println("pool : "+this.toString());		
	}	
	
	/**
	 * 접속 정보로 oracle db 연결 생성
	 * @param url 
	 * @param user
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	private Connection creatConnection(String url, String user, String password) throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * 사용한 Connection 회수
	 * @param con 회수할 Connection
	 * @return 회수 여부
	 * @throws SQLException
	 */
	public synchronized boolean returnConnection(Connection con) throws SQLException {
		boolean result = h.put(con, false);
		System.out.println("returnConnection:"+this);
		if(isToManyIdleConnection())
			shrinkConnectionPool(increment);
		return result;
	}
	
	/**
	 * Connection Pool 에서 Connection 추출.
	 * idle Connection이 없는 경우 증가 시킨 후 추출.
	 * @return Connection 객체
	 * @throws SQLException
	 */
	public synchronized Connection getConnection() throws SQLException {
		Enumeration<Connection> cons = h.keys();
		Connection con = null;
		while(cons.hasMoreElements()) {
			con = cons.nextElement();
			if(!h.get(con)) {
				h.put(con, true);
				System.out.println("getConnection:"+this);
				return con;
			}			
		}
		System.out.println("No connection available swell pool:");
		swellConnectionPool(increment);
		return getConnection();
	}
	
	/**
	 * 모든 연결 종료
	 * @throws SQLException
	 */
	public synchronized void close() throws SQLException {
		Enumeration<Connection> cons = h.keys();
		Connection con = null;
		while(cons.hasMoreElements()) {
			con = cons.nextElement();
			System.out.println("close:"+this);
			h.remove(con);
			if(!con.isClosed())
				con.close();
		}
	}
	/**
	 * Pool의 Connection 전체 갯수
	 * @return
	 */
	public int poolSize() {
		return h.size();
	}
	
	/**
	 * Pool 의 사용중인 Connection 갯수
	 * @return
	 */
	public int activePoolSize() {
		int size = 0;		
		Enumeration<Connection> cons = h.keys();
		
		while(cons.hasMoreElements()) {
			if(h.get(cons.nextElement()))
				size++;
		}
		
		return size;
	}
	
	/**
	 * Pool 의 휴식중인 Connection 갯수
	 * @return
	 */
	public int idlePoolSize() {
		return poolSize() - activePoolSize();
	}
	
	@Override
	public String toString() {
		return "poolSize: "+ poolSize() + " activePoolSize:"+activePoolSize();
	}
}
