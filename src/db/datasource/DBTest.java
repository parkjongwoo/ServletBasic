package db.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.connectionpoolbean.ConnectionPoolBean;

/**
 * db 연결 테스트용 클래스
 * @author goott3-4
 *
 */
public class DBTest implements Runnable {
	
	ConnectionPoolBean connectionPool;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		ArrayList<DBTest> runList = new ArrayList<DBTest>();
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		
		for(int i=0;i<10;i++) {
			DBTest run = new DBTest();
			runList.add(run);
			
			Thread t = new Thread(run);
			threadList.add(t);
			t.start();
		}
		
	}
	
	DBTest() throws ClassNotFoundException, SQLException{
		connectionPool = new ConnectionPoolBean();
		
	}
	
	@Override
	public void run()  {
		try {
			List<Connection> list = new ArrayList<Connection>();
			for(int i=0;i<10;i++) {
				list.add(connectionPool.getConnection());
				System.out.println(this.toString()+ " connection up: " + list.size());
			}
			for(int i=0;i<10;i++) {
				connectionPool.returnConnection(list.remove(0));
				System.out.println(this.toString()+ " connection down: " + list.size());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
