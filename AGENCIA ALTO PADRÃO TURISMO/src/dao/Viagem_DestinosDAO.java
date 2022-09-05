package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Viagem_Destinos;


public class Viagem_DestinosDAO {

	// CREATE
	public void save(Viagem_Destinos viagem_destino) {

		String sql = "INSERT INTO viagem_destinos" + "(Destino, Preco)" + "VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, viagem_destino.getDestino());
			
			pstm.setDouble(2, viagem_destino.getPreco());

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
	public List<Viagem_Destinos> getViagem_Destinos() {

		String sql = "SELECT * FROM viagem_destinos";

		List<Viagem_Destinos> viagem_destinos = new ArrayList<Viagem_Destinos>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Viagem_Destinos viagem_destino = new Viagem_Destinos();

				
				viagem_destino.setId_viagem_destinos(rset.getInt("ID_viagem_destinos"));
				viagem_destino.setDestino(rset.getString("Destino"));
				viagem_destino.setPreco(rset.getDouble("preco"));

				viagem_destinos.add(viagem_destino);
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

		return viagem_destinos;

	}

	// UPDATE

	public void update(Viagem_Destinos viagem_destino) {

		String sql = "UPDATE viagem_destinos SET Destino = ?, Preco = ? WHERE id_viagem_destinos = ? ";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, viagem_destino.getDestino());
			pstm.setDouble(2, viagem_destino.getPreco() );
			pstm.setInt(3, viagem_destino.getId_viagem_destinos());
			

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
	public void deleteById(int id_viagem_destinos) {
		
		String sql = "DELETE FROM viagem_destinos WHERE ID_viagem_destinos = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {

			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_viagem_destinos);
			
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
	
	public Viagem_Destinos getViagem_DestinosById(int id_viagem_destinos) {
		String sql = "SELECT * FROM viagem_destinos WHERE ID_viagem_destinos = ?;";

		Viagem_Destinos viagem_destinos = new Viagem_Destinos();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnetionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_viagem_destinos);

			rset = pstm.executeQuery();

			rset.next();

			viagem_destinos.setId_viagem_destinos(rset.getInt("ID_viagem_destinos"));
			viagem_destinos.setDestino(rset.getString("Destino"));
			viagem_destinos.setPreco(rset.getDouble("Preco"));

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

		return viagem_destinos;
	}

}
