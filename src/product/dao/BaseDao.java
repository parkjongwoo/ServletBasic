package product.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao implements Dao {

	@Override
	public Connection getConnection() {
		
//		JNDI에 DB등록
//		server.xml의 context 요소에 다음 resource요소 추가
		
//		<Resource name="jdbc/myoracle" auth="Container"
//        type="javax.sql.DataSource" driverClassName="oracle.jdbc.driver.OracleDriver"
//        url="jdbc:oracle:thin:@127.0.0.1:1521:orcl"
//        username="scott" password="tiger" maxTotal="20" maxIdle="10"
//        maxWaitMillis="-1"/>
		
//		web.xml에 <resource-ref> 요소추가
		
//		<resource-ref>
//		<description>local Oracle DB</description>
//		<res-ref-name>jdbc/oracledb</res-ref-name>
//		<res-type>javax.sql.DataSource</res-type>
//		<res-auth>Container</res-auth>
//		</resource-ref>
		
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			System.out.println("DB connected.");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeDBObject(ResultSet rs,Statement st, Connection con) {
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
			
			if(st != null && !st.isClosed()) {
				st.close();
			}
			
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
