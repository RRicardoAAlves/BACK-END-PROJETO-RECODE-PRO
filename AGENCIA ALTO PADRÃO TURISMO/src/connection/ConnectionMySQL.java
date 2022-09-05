package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	public static Connection createConnetionMySQL() throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/agencia_turismo?user=root&password=Dgjlrsa@01");
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		
		Connection con = createConnetionMySQL();
		
		
		if (con != null) {
			
			System.out.println(con + "\n***CONEXÃO REALIZADA COM SUCESSO***\n");
			con.close();
		}
		
	
	}

}
