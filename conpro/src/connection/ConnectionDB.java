package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {

private static String DRIVER = "com.mysql.cj.jdbc.Driver";
private static String URL = "jdbc:mysql://localhost:3306/conpro?useTimezone=true&serverTimezone=UTC";
private static String USER = "root";
private static String PASS = "dba4599C";
	
public static Connection getConnection() {
    try {
	Class.forName(DRIVER);
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	return DriverManager.getConnection(URL, USER, PASS);
    } catch (ClassNotFoundException | SQLException e) {
        System.out.printf("Erro de Conexao");
	throw new RuntimeException("Erro de Conexao", e);
    } 
		
}
    
}
