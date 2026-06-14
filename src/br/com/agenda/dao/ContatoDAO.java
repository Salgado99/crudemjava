package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	public void save(Contato contato) {
		String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setObject(3, new Date(contato.getDataCadastro().getTime()));
			pstm.execute();
			System.out.println("Contato salvo com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public List<Contato> getContatos() {
		String sql = "SELECT * FROM contatos";

		List<Contato> contatos = new ArrayList<Contato>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Contato contato = new Contato();

				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));
				contato.setDataCadastro(rset.getDate("dataCadastro"));
				contatos.add(contato);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
		        if (rset != null) {
		            rset.close(); 
		        }
		        
		        if (pstm != null) {
					pstm.close();
				}
		        
		        if (conn != null) {
		        	conn.close();
				}
		    } catch (SQLException e) {
		        System.out.println("Erro ao fechar o ResultSet: " + e.getMessage());
		    }
		}
		return contatos;
	}
	
	public void update(Contato contato) {
		String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ? WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new java.sql.Date(contato.getDataCadastro().getTime()));
			pstm.setInt(4, contato.getId());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
		        if (pstm != null) {
					pstm.close();
				}
		        
		        if (conn != null) {
		        	conn.close();
				}
		    } catch (SQLException e) {
		        System.out.println("Erro ao fechar o ResultSet: " + e.getMessage());
		    }
		}
		
		
	}
	
	public void deleteByID(int id) {
		String sql = "DELETE FROM contatos WHERE id = ? ";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
		        if (pstm != null) {
					pstm.close();
				}
		        
		        if (conn != null) {
		        	conn.close();
				}
		    } catch (SQLException e) {
		        System.out.println("Erro ao fechar o ResultSet: " + e.getMessage());
		    }
		}
		
	}
}
