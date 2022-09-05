package modelo;

public class Viagem_Destinos {
	
	private int id_viagem_destinos;
	private String destino;
	private double preco;
	
	
	public Viagem_Destinos() {
		
	}

	

	public Viagem_Destinos(int id_viagem_destinos, String destino, double preco) {
		this.id_viagem_destinos = id_viagem_destinos;
		this.destino = destino;
		this.preco = preco;
	}



	public int getId_viagem_destinos() {
		return id_viagem_destinos;
	}



	public void setId_viagem_destinos(int id_viagem_destinos) {
		this.id_viagem_destinos = id_viagem_destinos;
	}



	public String getDestino() {
		return destino;
	}



	public void setDestino(String destino) {
		this.destino = destino;
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}



	@Override
	public String toString() {
		return "Viagem_Destinos [id_viagem_destinos=" + id_viagem_destinos + ", destino=" + destino + ", preco=" + preco
				+ "]";
	}



	
	

	
		
}
