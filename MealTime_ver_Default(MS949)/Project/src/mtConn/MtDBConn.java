package mtConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MtDBConn {
	private Connection con;		//立加按眉
		
		public Connection getConnection() {// 立加按眉 getter 累己
			return con;
		}	
		
		public MtDBConn() throws ClassNotFoundException, SQLException {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");	
		}
}
