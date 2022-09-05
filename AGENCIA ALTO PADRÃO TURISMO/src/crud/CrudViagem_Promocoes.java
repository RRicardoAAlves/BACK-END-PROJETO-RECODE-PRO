package crud;


import java.util.Scanner;

import dao.Viagem_PromocoesDAO;
import modelo.Viagem_Promocoes;

public class CrudViagem_Promocoes {

	public static void main(String[] args) {

		Viagem_PromocoesDAO viagem_promocoesDAO = new Viagem_PromocoesDAO();

		Scanner s = new Scanner(System.in);

		int opcao = 0;
		int id_viagem_promocoes = 0;
		int posicao = 0;
		String destino_promocional = "";
		double preco_promocional  = 0;
		
		
				
		do {
			System.out.println("");
			System.out.println("=== CRUD VIAGEM-PROMOCIONAL ===");
			System.out.println("1 - Cadastrar Destino Promocional");
			System.out.println("2 - Consultar Destino Promocional");
			System.out.println("3 - Atualizar Destino Promocional");
			System.out.println("4 - Deletar Destino Promocional");
			System.out.println("5 - Buscar por ID");
			System.out.println("0 - Sair");

			opcao = s.nextInt();

			switch (opcao) {
			case 1:
				// CREATE
				
				System.out.println("Cadastrar Cliente: ");
				System.out.println("Informe o DESTINO PROMOCIONAL desejado: ");
				s.nextLine();
				destino_promocional = s.nextLine();
				System.out.println("Informe o valor da viagem: ");
				preco_promocional = s.nextDouble();

				Viagem_Promocoes viagem_promocao = new Viagem_Promocoes();
				
                viagem_promocao.setDestino_promocional(destino_promocional);
				
				viagem_promocao.setPreco_promocional(preco_promocional);
				
				

				viagem_promocoesDAO.save(viagem_promocao);

				System.out.println("\nCADASTRO EFETUADO COM SUCESSO\n");
				break;
			case 2:
				// READ
				System.out.println("Consultar Destinos promocionais");
				for (Viagem_Promocoes vp : viagem_promocoesDAO.getViagem_Promocoes()) {
					System.out.println("\nID: " + vp.getId_viagem_promocoes() + "\nDestino Promocional: " + vp.getDestino_promocional() + "\nPreço: " + vp.getPreco_promocional());
				}
				System.out.println("");
				System.out.println("*** FIM DA CONSULTA ***\n\n");
				break;
				
			case 3:
				// UPDATE
				System.out.println("Informe o ID do Destino Promocional: ");
				id_viagem_promocoes = s.nextInt();
				s.nextLine();
				System.out.println("Informe o novo Destino Promocional: ");
				destino_promocional = s.nextLine();
				System.out.println("Informe preço: ");
				preco_promocional = s.nextDouble();

				Viagem_Promocoes viagem_promocao1 = new Viagem_Promocoes(id_viagem_promocoes,destino_promocional,preco_promocional);
				viagem_promocoesDAO.update(viagem_promocao1);
				
				System.out.println("\nCADASTRO ATUALIZADO COM SUCESSO\n");
				break;
				
			case 4:
				// DELETE
				System.out.println("Informe o ID do Destino Promocional: ");
				posicao = s.nextInt();

				viagem_promocoesDAO.deleteById(posicao);
				
				System.out.println("\nDESTINO PROMOCIONAL EXCLUIDO COM SUCESSO\n");
				break;
				
			case 5:
				// BUSCAR POR ID
				System.out.println("Digite o ID do Destino Promocional: ");
				posicao = s.nextInt();
				Viagem_Promocoes vp = viagem_promocoesDAO.getViagem_PromocoesById(posicao);
				System.out.println("ID: " + vp.getId_viagem_promocoes() + " Destino Promocional: " + vp.getDestino_promocional() + " Preço: " + vp.getPreco_promocional());
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
