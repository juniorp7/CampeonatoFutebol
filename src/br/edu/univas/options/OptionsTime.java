package br.edu.univas.options;

import java.io.IOException;
import java.util.Scanner;

import br.edu.univas.vo.Times;

public class OptionsTime {

	Times time;
	Scanner entrada = new Scanner(System.in).useDelimiter("\n");;

	public OptionsTime(String optionChoosed, Times[] times) {
		switch (optionChoosed) {
		case "cadastrar":
			this.CadastraTime(times);
			break;
		case "excluir":
			this.ExcluirTime(times);
			break;
		case "editar":
			this.EditarTime(times);
			break;
		default:
			break;
		}
	}

	public void CadastraTime(Times[] times) {
		boolean sair = false;
		int val = 0;
		for (int i = 0; i < times.length; i++) {
			if (times[i] != null) {
				val++;
			}
		}
		do {
			Times time = new Times();
			System.out.print("Informe o nome do time:");
			time.nome = entrada.nextLine();

			System.out.print("Informe o estado de origem do time:");
			time.estadoOrigem = entrada.nextLine();

			System.out.println();

			times[val] = time;

			System.out.println("1. Cadastrar outro time ?");
			System.out.println("2. Voltar");

			System.out.print(">");
			int option = Integer.parseInt(entrada.nextLine());

			if (option == 1) {
				val++;
				continue;
			} else {
				sair = true;
			}
		} while (!sair);
	}

	public void ExcluirTime(Times[] times) {
		System.out.println("Qual time deseja excluir ?");

		for (int i = 0; i < times.length; i++) {
			if (times[i] != null) {
				System.out.println(i + ". " + times[i].nome.toString());
			}
		}

		System.out.println("99. Voltar");

		System.out.print(">");
		int choosed = Integer.parseInt(entrada.nextLine());

		if (choosed == 99) {
			return;
		} else {
			times[choosed] = null;
		}
	}

	public void EditarTime(Times[] times) {
		boolean sair = false;
		do {
			System.out.println("Qual time deseja editar?");
			
			for (int i = 0; i < times.length; i++) {
				if (times[i] != null) {
					System.out.println(i + ". " + times[i].nome.toString());
				}
			}

			System.out.println("99. Sair");
			
			System.out.print(">");
			int choosed = Integer.parseInt(entrada.nextLine());

			if (choosed == 99) {
				sair = true;
				return;
			} else {
				System.out.println("Editar o nome:");
				times[choosed].nome = entrada.nextLine();
				System.out.println("Editar o estado de origem");
				times[choosed].estadoOrigem = entrada.nextLine();
				
				System.out.println("1. Editar outro time ?");
				System.out.println("2. Voltar");

				System.out.print(">");
				int option = Integer.parseInt(entrada.nextLine());

				if (option == 1) {
					continue;
				} else {
					sair = true;
					break;
				}
			}

		} while (!sair);
	}

}
