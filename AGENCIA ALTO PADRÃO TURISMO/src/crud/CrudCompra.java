package crud;


import java.util.Scanner;

import dao.CompraDAO;
import dao.Viagem_DestinosDAO;
import dao.Viagem_PromocoesDAO;
import dao.Cliente_contatoDAO;
import modelo.Viagem_Promocoes;
import modelo.Viagem_Destinos;
import modelo.Compra;
import modelo.Cliente_contato;

public class CrudCompra {

	public static void main(String[] args) {
	
		CompraDAO compraDAO = new CompraDAO();
		Cliente_contatoDAO cliente_contatoDAO = new Cliente_contatoDAO();
		Viagem_DestinosDAO viagem_destinoDAO = new Viagem_DestinosDAO();
		Viagem_PromocoesDAO viagem_promocoesDAO = new Viagem_PromocoesDAO();
		
		Scanner s = new Scanner(System.in);

		int opcao = 0;
		int id_compra = 0;
		int posicao = 0;
		String check_in = "";
		String check_out  = "";
		int id_cliente_contato = 0;
		int id_viagem_destinos = 0;
		int id_viagem_promocoes = 0;
		
		
		do {
			System.out.println("");
			System.out.println("=== CRUD COMPRA ===");
			System.out.println("1 - Cadastrar compra");
			System.out.println("2 - Consultar compra");
			System.out.println("3 - Atualizar compra");
			System.out.println("4 - Deletar compra");
			System.out.println("5 - Buscar por ID");
			System.out.println("0 - Sair");

			opcao = s.nextInt();
			s.nextLine();


			switch (opcao) {
			case 1:
				// CREATE
				
				
				System.out.println("Informe a data CHECK-IN: ");
				check_in = s.nextLine();
				System.out.println("Informe a data CHECK-OUT: ");
				check_out = s.nextLine();
				System.out.println("Informe o ID do cliente: ");
				id_cliente_contato = s.nextInt();
				
				System.out.println("Informe o ID do DESTINO: ");
				id_viagem_destinos = s.nextInt();
				
				System.out.println("Informe o ID do DESTINO PROMOCIONAL: ");
				id_viagem_promocoes = s.nextInt();
				
				
				
				
				Cliente_contato cliente_contato = cliente_contatoDAO.getCliente_contatoById(id_cliente_contato);
				Viagem_Destinos viagem_destino = viagem_destinoDAO.getViagem_DestinosById(id_viagem_destinos);
				Viagem_Promocoes viagem_promocoes = viagem_promocoesDAO.getViagem_PromocoesById(id_viagem_promocoes);
				
				
				Compra c1 = new Compra (id_compra, check_in, check_out, cliente_contato, viagem_destino, viagem_promocoes);		
				compraDAO.save(c1);
				
				
				System.out.println("\nCADASTRO EFETUADO COM SUCESSO\n");
				break;
				
			case 2:
				// READ
				System.out.println("Consultar Compras");
				for (Compra c : compraDAO.getCompra()) {
					System.out.println("\nID: " + c.getId_compra()  + "\nCHECK-IN: " + c.getCheck_in() + "\nCHECK-OUT: " + c.getCheck_out() + "\nCLIENTE: " + "\nTipo Pessoa: " + c.getCliente_contato().getTipo_pessoa() + "\nNome: " + c.getCliente_contato().getNome() + "\nCPF/CNPJ: " + c.getCliente_contato().getCpf_cnpj() + "\nEndereço: " + c.getCliente_contato().getEndereco() + "\nCidade: " + c.getCliente_contato().getCidade() + "\nUF-Estado: " + c.getCliente_contato().getUf_estado() + "\nTelefone: " + c.getCliente_contato().getTelefone() + "\nEmail: " + c.getCliente_contato().getEmail() + "\nMensagem: " + c.getCliente_contato().getMensagem() + "\nDESTINO: " + c.getViagem_destinos().getDestino() + "\nPreço: " + c.getViagem_destinos().getPreco() + "\nDESTINO PROMOCIONAL: " + c.getViagem_promocoes().getDestino_promocional() + "\nPreço Promocional: " + c.getViagem_promocoes().getPreco_promocional());
				}
				System.out.println("");
				System.out.println("*** FIM DA CONSULTA ***\n\n");
				break;
				
			case 3:
				// UPDATE
				System.out.println("Informe o ID da Compra: ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Informe o novo Check-in: ");
				check_in = s.nextLine();
				System.out.println("Informe o novo Check-out: ");
				check_out = s.nextLine();
				
				System.out.println("Informe o ID do Cliente: ");
				id_cliente_contato = s.nextInt();
				
				System.out.println("Informe o ID do Destino: ");
				id_viagem_destinos = s.nextInt();
				
				System.out.println("Informe o ID do Destino Promocional: ");
				id_viagem_promocoes = s.nextInt();
				
				Cliente_contato cliente_contato1 = cliente_contatoDAO.getCliente_contatoById(id_cliente_contato);
				Viagem_Destinos viagem_destino1 = viagem_destinoDAO.getViagem_DestinosById(id_viagem_destinos);
				Viagem_Promocoes viagem_promocoes1 = viagem_promocoesDAO.getViagem_PromocoesById(id_viagem_promocoes);
	
				
				Compra c2 = new Compra (posicao, check_in, check_out, cliente_contato1, viagem_destino1, viagem_promocoes1);		
				
				
				compraDAO.update(c2);


				System.out.println("Cadastro atualizado com sucesso \n");
				break;
				
			case 4:
				// DELETE
				System.out.println("Informe o ID da Compra: ");
				posicao = s.nextInt();
				compraDAO.deleteById(posicao);
				System.out.println("\nCOMPRA EXCLUIDA COM SUCESSO\n");
				break;
				
			case 5:
				// BUSCAR POR ID
				System.out.println("Digite o id da Compra: ");
				posicao = s.nextInt();
				Compra c3 = compraDAO.getCompraById(posicao);

				
				System.out.println("\nID: " + c3.getId_compra()  + "\nCHECK-IN: " + c3.getCheck_in() + "\nCHECK-OUT: " 
				+ c3.getCheck_out() + " \nCLIENTE: " + "\nTipo Pessoa: " + c3.getCliente_contato().getTipo_pessoa() + "\nNome: " + c3.getCliente_contato().getNome() + "\nCPF/CNPJ: " + c3.getCliente_contato().getCpf_cnpj() + "\nEndereço: " + c3.getCliente_contato().getEndereco() + "\nCidade: " + c3.getCliente_contato().getCidade() + "\nUF-Estado: " + c3.getCliente_contato().getUf_estado() 
				+ "\nTelefone: " + c3.getCliente_contato().getTelefone() + "\nEmail: " + c3.getCliente_contato().getEmail() + "\nMensagem: " + c3.getCliente_contato().getMensagem() + "\nDESTINO: " + c3.getViagem_destinos().getDestino() + "\nPreço: " + c3.getViagem_destinos().getPreco() + "\nDESTINOS PROMOCIONAIS: " + c3.getViagem_promocoes().getDestino_promocional() 
				+ "\nPreço: " + c3.getViagem_promocoes().getPreco_promocional());
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
