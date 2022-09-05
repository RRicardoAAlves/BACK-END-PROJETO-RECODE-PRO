package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Cliente_contato;


public class Cliente_contatoDAO {

	// CREATE
	public void save(Cliente_contato cliente_contato) {

		String sql = "INSERT INTO cliente_contato"
				+ "(Tipo_Pessoa, Nome, CPF_CNPJ, Endereco, Cidade, UF_Estado, Telefone, Email, Mensagem)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente_contato.getTipo_pessoa());
			pstm.setString(2, cliente_contato.getNome());
			pstm.setString(3, cliente_contato.getCpf_cnpj());
			pstm.setString(4, cliente_contato.getEndereco());
			pstm.setString(5, cliente_contato.getCidade());
			pstm.setString(6, cliente_contato.getUf_estado());
			pstm.setString(7, cliente_contato.getTelefone());
			pstm.setString(8, cliente_contato.getEmail());
			pstm.setString(9, cliente_contato.getMensagem());

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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// READ
	public List<Cliente_contato> getCliente_contato() {

		String sql = "SELECT * FROM cliente_contato";

		List<Cliente_contato> cliente_contatos = new ArrayList<Cliente_contato>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente_contato cliente_contato = new Cliente_contato();
				
				cliente_contato.setId_cliente_contato(rset.getInt("ID_cliente_contato"));
				cliente_contato.setTipo_pessoa(rset.getString("Tipo_Pessoa"));
				cliente_contato.setNome(rset.getString("Nome"));
				cliente_contato.setCpf_cnpj(rset.getString("CPF_CNPJ"));
				cliente_contato.setEndereco(rset.getString("Endereco"));
				cliente_contato.setCidade(rset.getString("Cidade"));
				cliente_contato.setUf_estado(rset.getString("UF_Estado"));
				cliente_contato.setTelefone(rset.getString("Telefone"));
				cliente_contato.setEmail(rset.getString("Email"));
				cliente_contato.setMensagem(rset.getString("Mensagem"));

				cliente_contatos.add(cliente_contato);
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

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return cliente_contatos;

	}

	// UPDATE

	public void update(Cliente_contato cliente_contato) {

		String sql = "UPDATE cliente_contato SET Tipo_Pessoa = ?, Nome = ?, CPF_CNPJ = ?, Endereco = ?, Cidade = ?, UF_Estado = ?, Telefone = ?, Email = ?, Mensagem = ? WHERE id_cliente_contato = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente_contato.getTipo_pessoa());
			pstm.setString(2, cliente_contato.getNome());
			pstm.setString(3, cliente_contato.getCpf_cnpj());
			pstm.setString(4, cliente_contato.getEndereco());
			pstm.setString(5, cliente_contato.getCidade());
			pstm.setString(6, cliente_contato.getUf_estado());
			pstm.setString(7, cliente_contato.getTelefone());
			pstm.setString(8, cliente_contato.getEmail());
			pstm.setString(9, cliente_contato.getMensagem());
			pstm.setInt(10, cliente_contato.getId_cliente_contato());

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

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

	// DELETE
	public void deleteById(int id_cliente_contato) {

		String sql = "DELETE FROM cliente_contato WHERE id_cliente_contato = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_cliente_contato);

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

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}
	
	public Cliente_contato getCliente_contatoById(int id_cliente_contato) {
		String sql = "SELECT * FROM cliente_contato WHERE ID_cliente_contato = ?;";

		Cliente_contato cliente_contato = new Cliente_contato();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_cliente_contato);

			rset = pstm.executeQuery();

			rset.next();

			cliente_contato.setId_cliente_contato(rset.getInt("ID_cliente_contato"));
			cliente_contato.setTipo_pessoa(rset.getString("Tipo_Pessoa"));
			cliente_contato.setNome(rset.getString("Nome"));
			cliente_contato.setCpf_cnpj(rset.getString("CPF_CNPJ"));
			cliente_contato.setEndereco(rset.getString("Endereco"));
			cliente_contato.setCidade(rset.getString("Cidade"));
			cliente_contato.setUf_estado(rset.getString("UF_estado"));
			cliente_contato.setTelefone(rset.getString("Telefone"));
			cliente_contato.setEmail(rset.getString("Email"));
			cliente_contato.setMensagem(rset.getString("Mensagem"));
			

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

		return cliente_contato;
	}


}
