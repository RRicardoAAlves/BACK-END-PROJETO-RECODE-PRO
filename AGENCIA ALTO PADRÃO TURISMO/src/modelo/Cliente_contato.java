package modelo;

public class Cliente_contato {
	
	private int id_cliente_contato;
	private String tipo_pessoa;
	private String nome;
	private String cpf_cnpj;
	private String endereco;
	private String cidade;
	private String uf_estado;
	private String telefone;
	private String email;
	private String mensagem;
	
	public Cliente_contato() {
		
	}

	
	

	public Cliente_contato(int id_cliente_contato, String tipo_pessoa, String nome, String cpf_cnpj, String endereco,
			String cidade, String uf_estado, String telefone, String email, String mensagem) {
		super();
		this.id_cliente_contato = id_cliente_contato;
		this.tipo_pessoa = tipo_pessoa;
		this.nome = nome;
		this.cpf_cnpj = cpf_cnpj;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf_estado = uf_estado;
		this.telefone = telefone;
		this.email = email;
		this.mensagem = mensagem;
	}




	public int getId_cliente_contato() {
		return id_cliente_contato;
	}




	public void setId_cliente_contato(int id_cliente_contato) {
		this.id_cliente_contato = id_cliente_contato;
	}




	public String getTipo_pessoa() {
		return tipo_pessoa;
	}




	public void setTipo_pessoa(String tipo_pessoa) {
		this.tipo_pessoa = tipo_pessoa;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getCpf_cnpj() {
		return cpf_cnpj;
	}




	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}




	public String getEndereco() {
		return endereco;
	}




	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}




	public String getCidade() {
		return cidade;
	}




	public void setCidade(String cidade) {
		this.cidade = cidade;
	}




	public String getUf_estado() {
		return uf_estado;
	}




	public void setUf_estado(String uf_estado) {
		this.uf_estado = uf_estado;
	}




	public String getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getMensagem() {
		return mensagem;
	}




	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}




	@Override
	public String toString() {
		return "Cliente_contato [id_cliente_contato=" + id_cliente_contato + ", tipo_pessoa=" + tipo_pessoa + ", nome="
				+ nome + ", cpf_cnpj=" + cpf_cnpj + ", endereco=" + endereco + ", cidade=" + cidade + ", uf_estado="
				+ uf_estado + ", telefone=" + telefone + ", email=" + email + ", mensagem=" + mensagem + "]";
	}




	
}
