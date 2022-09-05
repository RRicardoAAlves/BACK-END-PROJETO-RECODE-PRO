package modelo;

public class Viagem_Promocoes {
	
	private int id_viagem_promocoes;
	private String destino_promocional;
	private double preco_promocional;
	
	
	public Viagem_Promocoes() {
		
	}

	

	public Viagem_Promocoes(int id_viagem_promocoes, String destino_promocional, double preco_promocional) {
		this.id_viagem_promocoes = id_viagem_promocoes;
		this.destino_promocional = destino_promocional;
		this.preco_promocional = preco_promocional;
		
	}



	public int getId_viagem_promocoes() {
		return id_viagem_promocoes;
	}



	public void setId_viagem_promocoes(int id_viagem_promocoes) {
		this.id_viagem_promocoes = id_viagem_promocoes;
	}



	public String getDestino_promocional() {
		return destino_promocional;
	}



	public void setDestino_promocional(String destino_promocional) {
		this.destino_promocional = destino_promocional;
	}




	public double getPreco_promocional() {
		return preco_promocional;
	}



	public void setPreco_promocional(double preco_promocional) {
		this.preco_promocional = preco_promocional;
	}



	@Override
	public String toString() {
		return "Viagem_Promocoes [id_viagem_promocoes=" + id_viagem_promocoes + ", destino_promocional="
				+ destino_promocional + ", preco_promocional=" + preco_promocional + "]";
	}



	
	

	
	
}
	
	