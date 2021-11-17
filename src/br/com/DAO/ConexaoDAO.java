package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDAO {
	
	public static Connection con = null;
	
	
	public Connection conexaoBD() throws ClassNotFoundException {

		Connection con = null;
		
		try {
			String servidorNome= "localhost";
			String bancoDeDadosNome = "crud_java_web_jsp_mysql?serverTimezone=UTC";
			String usuario = "root";
			String senha = "root";
			String driverNome = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverNome);
			
			String url = "jdbc:mysql://" + servidorNome + "/" + bancoDeDadosNome;
			
			con = DriverManager.getConnection(url, usuario, senha);
			
			System.out.println("Conexão realizada com sucesso!.");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Driver não encontrado" + e.toString());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao conectar o banco de dados " + e.toString());
		}
		
		return con;
		
	}
}
