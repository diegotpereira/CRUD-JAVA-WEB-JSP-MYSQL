package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.DTO.LivroDTO;

public class LivroDAO {
	
	Connection con;
	PreparedStatement pstm;

	public void CadastrarLivro(LivroDTO ObjLivroDTO) throws ClassNotFoundException {
		
		String SQL = "INSERT INTO livro (nome_livro) VALUES (?)";
		con = new ConexaoDAO().conexaoBD();
		
		try {
			
			pstm = con.prepareStatement(SQL);
			pstm.setString(1, ObjLivroDTO.getNome_livro());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
