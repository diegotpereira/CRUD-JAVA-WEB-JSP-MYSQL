package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.DTO.LivroDTO;

public class LivroDAO {
	
	Connection con;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<LivroDTO> lista = new ArrayList<>();

	public void CadastrarLivro(LivroDTO livroDTO) throws ClassNotFoundException {
		
		String SQL = "INSERT INTO livro (nome_livro) VALUES (?)";
		con = new ConexaoDAO().conexaoBD();
		
		try {
			
			pstm = con.prepareStatement(SQL);
			pstm.setString(1, livroDTO.getNome_livro());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<LivroDTO> PesquisarLivro() throws ClassNotFoundException {
		
		String SQL = "SELECT * FROM livro";
		con = new ConexaoDAO().conexaoBD();
		
		try {
			
			pstm = con.prepareStatement(SQL);
			rs = pstm.executeQuery(SQL);
			
			while(rs.next()) {
				LivroDTO livroDTO = new LivroDTO();
				livroDTO.setId_livro(rs.getInt("id_livro"));
				livroDTO.setNome_livro(rs.getString("nome_livro"));
				
				lista.add(livroDTO);
			}
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return lista;
	}
	
public void ExcluirLivro(LivroDTO livroDTO) throws ClassNotFoundException {
		
		String SQL = "DELETE FROM livro WHERE id_livro = ?";
		con = new ConexaoDAO().conexaoBD();
		
		try {
			
			pstm = con.prepareStatement(SQL);
			pstm.setInt(1, livroDTO.getId_livro());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

public void AlterarLivro(LivroDTO livroDTO) throws ClassNotFoundException {
	
	String SQL = "UPDATE livro SET nome_livro = ? WHERE id_livro = ?";
	con = new ConexaoDAO().conexaoBD();
	
	try {
		
		pstm = con.prepareStatement(SQL);
		pstm.setString(1, livroDTO.getNome_livro());
		pstm.setInt(2, livroDTO.getId_livro());
		
		pstm.execute();
		pstm.close();
		
	} catch (SQLException e) {
		// TODO: handle exception
	}
}
}
