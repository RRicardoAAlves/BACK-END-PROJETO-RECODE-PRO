package dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Cliente_contato;
import modelo.Compra;
import modelo.Viagem_Destinos;
import modelo.Viagem_Promocoes;

public class CompraDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// METODO SAVE
	public void save(Compra compras) {

		String sql = "INSERT INTO compra" + "(Check_in, Check_out, ID_cliente_contato, ID_viagem_destinos, ID_viagem_promocoes)" + "VALUES (?, ?, ?, ?, ?);";

		
		try {
			
			
			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			
			// pstm.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
			// pstm.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			

			pstm.setDate(1, new Date(formatter.parse(compras.getCheck_in()).getTime()));
			pstm.setDate(2, new Date(formatter.parse(compras.getCheck_out()).getTime()));

			pstm.setInt(3, compras.getCliente_contato().getId_cliente_contato());
			pstm.setInt(4, compras.getViagem_destinos().getId_viagem_destinos());
			pstm.setInt(5, compras.getViagem_promocoes().getId_viagem_promocoes());

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

	// METODO READ
	public List<Compra> getCompra() {
		
		
		String sql = "SELECT *\n" + "FROM compra AS c\n"
				+ "JOIN cliente_contato AS t ON c.ID_cliente_contato = t.ID_cliente_contato\n" 
				+ "JOIN viagem_destinos AS d ON c.ID_viagem_destinos = d.ID_viagem_destinos\n" 
				+ "JOIN viagem_promocoes AS p ON c.ID_viagem_promocoes = p.ID_viagem_promocoes;";


		
		List<Compra> compras = new ArrayList<Compra>();

		
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Compra compra = new Compra();
				Cliente_contato cliente_contato = new Cliente_contato();
				Viagem_Destinos viagem_destinos = new Viagem_Destinos();
				Viagem_Promocoes viagem_promocoes = new Viagem_Promocoes();
				

				compra.setId_compra(rset.getInt("id_compra"));

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

				compra.setCheck_in(dateFormat.format(rset.getDate("Check_in")));
				compra.setCheck_out(dateFormat.format(rset.getDate("Check_out")));

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
				compra.setCliente_contato(cliente_contato);

				viagem_destinos.setId_viagem_destinos(rset.getInt("ID_viagem_destinos"));
				viagem_destinos.setDestino(rset.getString("Destino"));
				viagem_destinos.setPreco(rset.getDouble("Preco"));
				compra.setViagem_destinos(viagem_destinos);

				viagem_promocoes.setId_viagem_promocoes(rset.getInt("ID_viagem_promocoes"));
				viagem_promocoes.setDestino_promocional(rset.getString("Destino_Promocional"));
				viagem_promocoes.setPreco_promocional(rset.getDouble("Preco_Promocional"));
				
				compra.setViagem_promocoes(viagem_promocoes);

				compras.add(compra);
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

		return compras;

	}

	// METODO UPDATE

	public void update(Compra compras1) {

		String sql = "UPDATE compra SET Check_in = ?, Check_out = ?, ID_cliente_contato = ?, ID_viagem_destinos = ?, ID_viagem_promocoes = ?  WHERE ID_compra = ?;";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnetionMySQL();
			pstm = conn.prepareStatement(sql);

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setDate(1, new Date(formatter.parse(compras1.getCheck_in()).getTime()));
			pstm.setDate(2, new Date(formatter.parse(compras1.getCheck_out()).getTime()));
			pstm.setInt(3, compras1.getCliente_contato().getId_cliente_contato());
			pstm.setInt(4, compras1.getViagem_destinos().getId_viagem_destinos());
			pstm.setInt(5, compras1.getViagem_promocoes().getId_viagem_promocoes());
			pstm.setInt(6, compras1.getId_compra());

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

	// METODO DELETE
	public void deleteById(int id_compra) {

		String sql = "DELETE FROM compra WHERE ID_compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_compra);

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

	public Compra getCompraById(int id_compra) {
		String sql = "SELECT *\n" + "FROM compra AS c\n"
				+ "JOIN cliente_contato AS t ON c.ID_cliente_contato = t.ID_cliente_contato\n" 
				+ "JOIN viagem_destinos AS d ON c.ID_viagem_destinos = d.ID_viagem_destinos\n" 
				+ "JOIN viagem_promocoes AS p ON c.ID_viagem_promocoes = p.ID_viagem_promocoes \n" + "WHERE ID_compra = ?;";

		Compra compra = new Compra();
		Cliente_contato cliente_contato = new Cliente_contato();
		Viagem_Destinos viagem_destinos = new Viagem_Destinos();
		Viagem_Promocoes viagem_promocoes = new Viagem_Promocoes();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_compra);
			rset = pstm.executeQuery();
			rset.next();

			compra.setId_compra(rset.getInt("id_compra"));

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			compra.setCheck_in(dateFormat.format(rset.getDate("Check_in")));
			compra.setCheck_out(dateFormat.format(rset.getDate("Check_out")));

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
			compra.setCliente_contato(cliente_contato);
			
			viagem_destinos.setId_viagem_destinos(rset.getInt("ID_viagem_destinos"));
			viagem_destinos.setDestino(rset.getString("Destino"));
			viagem_destinos.setPreco(rset.getDouble("Preco"));
			compra.setViagem_destinos(viagem_destinos);
			
			viagem_promocoes.setId_viagem_promocoes(rset.getInt("ID_viagem_promocoes"));
			viagem_promocoes.setDestino_promocional(rset.getString("Destino_Promocional"));
			viagem_promocoes.setPreco_promocional(rset.getDouble("Preco_Promocional"));
			compra.setViagem_promocoes(viagem_promocoes);
			
			
			
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

		return compra;
	}

}
