package br.edu.univas.options;

import java.util.Scanner;

import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.Times;

public class OptionsJogo {

	Jogo jogo;
	Scanner entrada = new Scanner(System.in);
	Times[] time;

	public OptionsJogo(String optionChoosed, Jogo[] jogos, Times[] times) {
		time = times;
		switch (optionChoosed) {
		case "cadastrar":
			this.CadastraJogo(jogos);
			break;
		case "editar":
			this.EditarJogo(jogos);
			break;
		case "excluir":
			this.ExcluirJogo(jogos);
			break;
		default:
			break;
		}
	}

	private void CadastraJogo(Jogo[] jogos) {
		boolean sair = false;
		int val = 0;
		for (int i = 0; i < jogos.length; i++) {
			if (jogos[i] != null) {
				val++;
			}
		}
		do {
			Jogo jogo = new Jogo();
			System.out.println("Informe o time mandante:");
			for (int i = 0; i < time.length; i++) {
				if (time[i] != null) {
					System.out.println(i + ". " + time[i].nome.toString());
				}
			}
			System.out.print(">");
			int timeMandante = entrada.nextInt();
			jogo.timeMandante = time[timeMandante].nome;

			System.out.print("Informe os gols do mandante:");
			jogo.golsTimeMandante = entrada.nextInt();

			System.out.println("Informe o time visitante:");
			for (int i = 0; i < time.length; i++) {
				if (time[i] != null && time[i].nome != time[timeMandante].nome) {
					System.out.println(i + ". " + time[i].nome.toString());
				}
			}
			System.out.print(">");
			int timeVisitante = entrada.nextInt();
			jogo.timeVisitante = time[timeVisitante].nome;

			System.out.print("Informe os gols do visitante:");
			jogo.golsTimeVisitante = entrada.nextInt();

			jogos[val] = jogo;

			System.out.println(" +-+-+-+-+-+ +-+-+-+-+-+-+-+ +-+-+\r\n" + " " + jogo.timeMandante + " "
					+ jogo.golsTimeMandante + " X " + jogo.golsTimeVisitante + " " + jogo.timeVisitante + "\r\n"
					+ " +-+-+-+-+-+ +-+-+-+-+-+-+-+ +-+-+");

			System.out.println("1. Cadastrar outro jogo ?");
			System.out.println("2. Voltar");

			System.out.print(">");
			int option = entrada.nextInt();

			if (option == 1) {
				val++;
				System.out.flush();
				continue;
			} else {
				sair = true;
				System.out.flush();
			}

		} while (!sair);
	}

	private void EditarJogo(Jogo[] jogos) {
		boolean sair = false;
		do {
			System.out.println("Qual jogo deseja editar?");
			int choosed = 0;

			System.out.println("99. Sair");
			for (int i = 0; i < jogos.length; i++) {
				if (jogos[i] != null) {
					System.out.println(i + ". " + jogos[i].timeMandante.toString() + " " + jogos[i].golsTimeMandante + " X " + jogos[i].golsTimeVisitante + " " + jogos[i].timeVisitante.toString());
				}
			}

			System.out.print(">");
			choosed = Integer.parseInt(entrada.nextLine().trim());

			if (choosed == 99) {
				sair = true;
				break;
			} else {
				System.out.println("Editar o time mandante:");
				jogos[choosed].timeMandante = entrada.nextLine();
				System.out.println("Editar o placar do time mandante:");
				jogos[choosed].golsTimeMandante = Integer.parseInt(entrada.nextLine());
				System.out.println("Editar o time visitante");
				jogos[choosed].timeVisitante = entrada.nextLine();
				System.out.println("Editar o placar do time visitante:");
				jogos[choosed].golsTimeVisitante = Integer.parseInt(entrada.nextLine());

				System.out.println("1. Editar outro jogo ?");
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

	private void ExcluirJogo(Jogo[] jogos) {
		System.out.println("Qual jogo deseja excluir ?");
		int choosed = 0;
		System.out.println("99. Sair");
		for (int i = 0; i < jogos.length; i++) {
			if (jogos[i] != null) {
				System.out.println(i + ". " + jogos[i].timeMandante.toString() + " " + jogos[i].golsTimeMandante + " X " + jogos[i].golsTimeVisitante + " " + jogos[i].timeVisitante.toString());
			}
		}

		System.out.print(">");
		choosed = Integer.parseInt(entrada.nextLine());

		if (choosed == 99) {
			System.out.flush();
			return;
		} else {
			jogos[choosed] = null;
			System.out.flush();
		}
	}
}
