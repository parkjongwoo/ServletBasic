package db.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Connection Pool 사용 테스트.기본 제공 커넥션 풀
 * @author goott3-4
 *
 */
public class DBCP {

	public static void main(String[] args)  {
		String driverClassName = "oracle.jdbc.driver.OracleDriver";
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "tiger";
		
		int initialSize = 5;
		int maxIdle = 5;
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pw);
		ds.setInitialSize(initialSize);
		ds.setMaxIdle(maxIdle);
		
		List<Connection> conList = new ArrayList<Connection>();
		for(int i=0;i<1000;i++) {
			try {
				conList.add(ds.getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println(ds.toString());
		}
		for(int i=0;i<1000;i++) {
			conList.remove(0);
			System.out.println(ds.toString());
		}		
		
	}

}
