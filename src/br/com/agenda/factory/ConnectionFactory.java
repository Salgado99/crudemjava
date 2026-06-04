package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory{
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1224";
	private static final String URL = "jdbc:mysql://localhost:3306/agenda";
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;	
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		
		if(con != null ) {
			System.out.println("Conexao criada" + con);
			con.close();
		}
		
	}

}
