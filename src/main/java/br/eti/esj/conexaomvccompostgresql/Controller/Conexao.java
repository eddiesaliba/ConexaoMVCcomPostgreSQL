package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
	// Design Pattern - Singleton
	private static Connection conn = null;

	public static Connection getConexao() throws SQLException{
		if((conn == null) || (conn.isClosed())) {
			conn = fabricaDeConexoes();
		}
		
		return conn;
	}
		
	// Fábrica de Conexões
	public static Connection fabricaDeConexoes() {
		try{
			Class.forName("org.postgresql.Driver");
			
			Properties prop = new Properties();
			prop.put("user","postgres");
			prop.put("password", "123456");
			prop.put("charset", "UTF-8");
			prop.put("lc_ctype", "ISO8859_1");
			
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/ExemploConexao", prop);
		}
		catch(Exception e){
			System.err.println("Erro: " + e.getMessage());
		}
		
		return null;
	}
}
