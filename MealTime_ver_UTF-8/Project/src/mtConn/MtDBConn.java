package mtConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MtDBConn {
	private Connection con;		//접속객체
		
		public Connection getConnection() {// 접속객체 getter 작성
			return con;
		}	
		
		public MtDBConn() throws ClassNotFoundException, SQLException {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");	
		}
}
