package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compra {
	
	private int id_compra;
	private LocalDate check_in;
	private LocalDate  check_out;
	
	private Cliente_contato cliente_contato;
	private Viagem_Destinos viagem_destinos;
	private Viagem_Promocoes viagem_promocoes;
	
	
	
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Compra() {
		
	}

	

	
	public Compra(int id_compra, String check_in, String check_out, Cliente_contato cliente_contato, Viagem_Destinos viagem_destinos, Viagem_Promocoes viagem_promocoes) {
		this.id_compra = id_compra;
		this.check_in = LocalDate.parse(check_in, formatter);
		this.check_out = LocalDate.parse(check_out, formatter);
		this.cliente_contato = cliente_contato;
		this.viagem_destinos = viagem_destinos;
		this.viagem_promocoes = viagem_promocoes;
}



	
	public int getId_compra() {
		return id_compra;
	}




	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}




	public String getCheck_in() {
		return formatter.format(check_in);
	}




	public void setCheck_in(String check_in) {
		this.check_in = LocalDate.parse(check_in, formatter);
	}




	public String getCheck_out() {
		return formatter.format(check_out);
	}




	public void setCheck_out(String check_out) {
		this.check_out = LocalDate.parse(check_out, formatter);
	}




	public Cliente_contato getCliente_contato() {
		return cliente_contato;
	}




	public void setCliente_contato(Cliente_contato cliente_contato) {
		this.cliente_contato = cliente_contato;
	}




	public Viagem_Destinos getViagem_destinos() {
		return viagem_destinos;
	}




	public void setViagem_destinos(Viagem_Destinos viagem_destinos) {
		this.viagem_destinos = viagem_destinos;
	}




	public Viagem_Promocoes getViagem_promocoes() {
		return viagem_promocoes;
	}




	public void setViagem_promocoes(Viagem_Promocoes viagem_promocoes) {
		this.viagem_promocoes = viagem_promocoes;
	}




	@Override
	public String toString() {
		return "Compra [id_compra=" + id_compra + ", check_in (dd/mm/aaaa)=" + check_in + ", check_out (dd/mm/aaaa)=" + check_out
				+ ", cliente_contato=" + cliente_contato + ", viagem_destinos=" + viagem_destinos
				+ ", viagem_promocoes=" + viagem_promocoes + "]";
	}
	
	
	


}
