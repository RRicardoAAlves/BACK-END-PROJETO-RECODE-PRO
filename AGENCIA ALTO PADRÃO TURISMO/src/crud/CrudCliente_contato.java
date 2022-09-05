package crud;


import java.util.Scanner;

import dao.Cliente_contatoDAO;
import modelo.Cliente_contato;


public class CrudCliente_contato {

	public static void main(String[] args) {

		Cliente_contatoDAO cliente_contatoDAO = new Cliente_contatoDAO();

		Scanner s = new Scanner(System.in);

		int opcao = 0;
		int id_cliente_contato = 0;
		int posicao = 0;
		String tipo_pessoa = "";
		String nome = "";
		String cpf_cnpj = "";
		String endereco = "";
		String cidade = "";
		String uf_estado = "";
		String telefone = "";
		String email = "";
		String mensagem = "";
		
		

		do {
			System.out.println("=== CRUD CLIENTE ===");
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Consultar Cliente");
			System.out.println("3 - Atualizar Cliente");
			System.out.println("4 - Deletar Cliente");
			System.out.println("5 - Buscar por ID");
			System.out.println("0 - Sair");

			opcao = s.nextInt();

			switch (opcao) {
			case 1:
				// CREATE

				System.out.println("Cadastrar Cliente: ");
				System.out.println("Informe Pessoa Fisica ou Pessoa Juridica: ");
				s.nextLine();
				tipo_pessoa = s.nextLine();
				System.out.println("Digite seu nome: ");
				nome = s.nextLine();
				System.out.println("Informe CPF ou CNPJ: ");
				cpf_cnpj = s.nextLine();
				System.out.println("Informe endereço: ");
				endereco = s.nextLine();
				System.out.println("Informe cidade: ");
				cidade = s.nextLine();
				System.out.println("Informe UF-Estado: ");
				uf_estado = s.nextLine();
				System.out.println("Informe telefone: ");
				telefone = s.nextLine();
				System.out.println("Informe email: ");
				email = s.nextLine();
				System.out.println("Deixe sua mensagem: ");
				mensagem = s.nextLine();

				Cliente_contato cliente_contato = new Cliente_contato();
				
				cliente_contato.setTipo_pessoa(tipo_pessoa);
				cliente_contato.setNome(nome);;
				cliente_contato.setCpf_cnpj(cpf_cnpj);
				cliente_contato.setEndereco(endereco);
				cliente_contato.setCidade(cidade);
				cliente_contato.setUf_estado(uf_estado);
				cliente_contato.setTelefone(telefone);
				cliente_contato.setEmail(email);
				cliente_contato.setMensagem(mensagem);
				
				cliente_contatoDAO.save(cliente_contato);

				System.out.println("\nCADASTRO EFETUADO COM SUCESSO\n");
				break;
			case 2:
				// READ
				System.out.println("Consultar dados do cliente: ");
				for (Cliente_contato vp : cliente_contatoDAO.getCliente_contato()) {
					System.out.println("\nID: " + vp.getId_cliente_contato() + "\nTipo de Pessoa: " + vp.getTipo_pessoa() + "\nNome: "
							+ vp.getNome() + "\nCPF/CNPJ: " + vp.getCpf_cnpj() + "\nEndereço: " + vp.getEndereco()
							+ "\nCidade: " + vp.getCidade() + "\nUF-Estado: " + vp.getUf_estado() + "\nTelefone: "
							+ vp.getTelefone() + "\nEmail: " + vp.getEmail() + "\nMensagem: " + vp.getMensagem());
				}
				System.out.println("");
				System.out.println("*** FIM DA CONSULTA ***\n\n");
				break;

			case 3:
				// UPDATE
				System.out.println("Informe o ID do Cliente: ");
				id_cliente_contato = s.nextInt();
				s.nextLine();
				System.out.println("Informe Pessoa Fisica ou Juridica: ");
				tipo_pessoa = s.nextLine();
				System.out.println("Digite o nome: ");
				nome = s.nextLine();
				System.out.println("Informe CPF ou CNPJ: ");
				cpf_cnpj = s.nextLine();
				System.out.println("Informe endereço: ");
				endereco = s.nextLine();
				System.out.println("Informe cidade: ");
				cidade = s.nextLine();
				System.out.println("Informe UF-Estado: ");
				uf_estado = s.nextLine();
				System.out.println("Informe telefone: ");
				telefone = s.nextLine();
				System.out.println("Informe email: ");
				email = s.nextLine();
				System.out.println("Deixe sua mensagem: ");
				mensagem = s.nextLine();

				Cliente_contato cliente_contato1 = new Cliente_contato(id_cliente_contato,tipo_pessoa,nome,cpf_cnpj,endereco,cidade,uf_estado,telefone,email,mensagem);
				cliente_contatoDAO.update(cliente_contato1);
				
				System.out.println("\nCADASTRO ATUALIZADO COM SUCESSO\n");
				break;
				

			case 4:
				// DELETE
				System.out.println("Informe o ID do cliente: ");
				posicao = s.nextInt();

				cliente_contatoDAO.deleteById(posicao);

				System.out.println("\nCADASTRO DO CLIENTE EXCLUIDO COM SUCESSO\n");
				break;
				
			case 5:
				// BUSCAR POR ID
				System.out.println("Digite o ID do Cliente: ");
				posicao = s.nextInt();
				Cliente_contato cc = cliente_contatoDAO.getCliente_contatoById(posicao);
				System.out.println("ID: " + cc.getId_cliente_contato() + " Tipo_Pessoa: " + cc.getTipo_pessoa() + " Nome: " + cc.getNome() + " CPF/CNPJ: " + cc.getCpf_cnpj() + " Endereco: " + cc.getEndereco() + " Cidade: " + cc.getCidade() + " UF_Estado: " + cc.getUf_estado() + " Telefone: " + cc.getTelefone() + " Email: " + cc.getEmail() + " Mensagem: " + cc.getMensagem());
				break;

			default:
				System.out.println(opcao != 0 ? " \n Opção invalida, tente novamente.\n" : "");
				break;

			}

		} while (opcao != 0);
		s.close();

		System.out.println("Fim do programa");

	}

}
