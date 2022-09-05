package crud;



import java.util.Scanner;

import dao.Viagem_DestinosDAO;
import modelo.Viagem_Destinos;

public class CrudViagem_Destinos {

	public static void main(String[] args) {

		Viagem_DestinosDAO viagem_destinoDAO = new Viagem_DestinosDAO();

		Scanner s = new Scanner(System.in);

		int opcao = 0;
		int id_viagem_destinos = 0;
		int posicao = 0;
		String destino = "";
		double preco = 0 ;

		

		do {
			System.out.println("");
			System.out.println("=== CRUD VIAGEM-DESTINO ===");
			System.out.println("1 - Cadastrar destino");
			System.out.println("2 - Consultar destino");
			System.out.println("3 - Atualizar destino");
			System.out.println("4 - Deletar destino");
			System.out.println("5 - Buscar por ID");
			System.out.println("0 - Sair");

			opcao = s.nextInt();

			switch (opcao) {
			case 1:
				// CREATE
				
				System.out.println("Cadastrar Cliente: ");
				System.out.println("Informe o DESTINO desejado: ");
				s.nextLine();
				destino = s.nextLine();
				System.out.println("Informe o valor da viagem: ");
				preco = s.nextDouble();

				Viagem_Destinos viagem_destino = new Viagem_Destinos();

				viagem_destino.setDestino(destino);
				
				viagem_destino.setPreco(preco);

				viagem_destinoDAO.save(viagem_destino);

				System.out.println("\nCADASTRO EFETUADO COM SUCESSO\n");
				break;
				
			case 2:
				// READ
				System.out.println("Consultar Destinos: ");
				for (Viagem_Destinos vd : viagem_destinoDAO.getViagem_Destinos()) {
					System.out.println("\nID: " + vd.getId_viagem_destinos() + "\nDestino: " + vd.getDestino() + "\nPreço: " + vd.getPreco());
				}
				System.out.println("");
				System.out.println("*** FIM DA CONSULTA ***\n\n");
				break;
				
			case 3:
				// UPDATE
				System.out.println("Informe o ID do Destino: ");
				id_viagem_destinos = s.nextInt();
				s.nextLine();
				System.out.println("Informe o novo Destino: ");
				destino = s.nextLine();
				System.out.println("Informe preço: ");
				preco = s.nextDouble();

				Viagem_Destinos viagem_destino1 = new Viagem_Destinos(id_viagem_destinos,destino,preco);
				viagem_destinoDAO.update(viagem_destino1);
				
				System.out.println("\nCADASTRO ATUALIZADO COM SUCESSO\n");
				break;
												
			case 4:
				// DELETE
				System.out.println("Informe o ID do Destino Promocional: ");
				posicao = s.nextInt();

				viagem_destinoDAO.deleteById(posicao);
				
				System.out.println("\nDESTINO EXCLUIDO COM SUCESSO\n");
				break;
				
			case 5:
				// BUSCAR POR ID
				System.out.println("Digite o ID do Destino: ");
				posicao = s.nextInt();
				Viagem_Destinos vd = viagem_destinoDAO.getViagem_DestinosById(posicao);
				System.out.println("ID: " + vd.getId_viagem_destinos() + " Destino Promocional: " + vd.getDestino() + " Preço: " + vd.getPreco());
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
