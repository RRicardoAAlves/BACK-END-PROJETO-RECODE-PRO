package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Viagem_Promocoes;


public class Viagem_PromocoesDAO {

	// CREATE
	public void save(Viagem_Promocoes viagem_promocoes) {

		String sql = "INSERT INTO viagem_promocoes" + "(Destino_Promocional, Preco_Promocional)" + "VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			
			pstm.setString(1, viagem_promocoes.getDestino_promocional());
			pstm.setDouble(2, viagem_promocoes.getPreco_promocional());
			
			

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
		public List<Viagem_Promocoes> getViagem_Promocoes() {

			String sql = "SELECT * FROM viagem_promocoes";

			List<Viagem_Promocoes> viagem_promocoes = new ArrayList<Viagem_Promocoes>();

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {
				conn = ConnectionMySQL.createConnetionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();

				while (rset.next()) {
					Viagem_Promocoes viagem_promocao = new Viagem_Promocoes();
					
					
					
					viagem_promocao.setId_viagem_promocoes(rset.getInt("ID_viagem_promocoes"));
					viagem_promocao.setDestino_promocional(rset.getString("Destino_Promocional"));
					viagem_promocao.setPreco_promocional(rset.getDouble("Preco_Promocional"));

					viagem_promocoes.add(viagem_promocao);
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

			return viagem_promocoes;

		}

	
	// UPDATE

		public void update(Viagem_Promocoes viagem_promocoes) {

			String sql = "UPDATE viagem_promocoes SET Destino_Promocional = ?, Preco_Promocional = ? WHERE id_viagem_promocoes = ?";
			Connection conn = null;
			PreparedStatement pstm = null;

			try {

				conn = ConnectionMySQL.createConnetionMySQL();
				pstm = conn.prepareStatement(sql);

				pstm.setString(1, viagem_promocoes.getDestino_promocional());
				pstm.setDouble(2, viagem_promocoes.getPreco_promocional());
				pstm.setInt(3, viagem_promocoes.getId_viagem_promocoes());

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
		public void deleteById(int id_viagem_promocoes) {
			
			String sql = "DELETE FROM viagem_promocoes WHERE ID_viagem_promocoes = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {

				conn = ConnectionMySQL.createConnetionMySQL();

				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id_viagem_promocoes);
				
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
		
		public Viagem_Promocoes getViagem_PromocoesById(int id_viagem_promocoes) {
			String sql = "SELECT * FROM viagem_promocoes WHERE ID_viagem_promocoes = ?;";

			Viagem_Promocoes viagem_promocoes = new Viagem_Promocoes();

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {
				conn = ConnectionMySQL.createConnetionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id_viagem_promocoes);

				rset = pstm.executeQuery();

				rset.next();

				viagem_promocoes.setId_viagem_promocoes(rset.getInt("ID_viagem_promocoes"));
				viagem_promocoes.setDestino_promocional(rset.getString("Destino_Promocional"));
				viagem_promocoes.setPreco_promocional(rset.getDouble("Preco_promocional"));

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

			return viagem_promocoes;
		}

}
