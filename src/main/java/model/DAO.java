package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/fivestar?useTimezone=true&serverTimezone=UTC";
	private String login = "root";
	private String senha = "rtY63c@444";
	
	//MÉTODO DE CONEXÃO
	public  Connection conectar() {
		Connection con = null;
		try {
			//LER O DRIVER DO DB
			Class.forName(driver);
			con = DriverManager.getConnection(url, login, senha);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
