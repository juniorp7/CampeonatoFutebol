package br.edu.univas.options;

import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.Times;

public class Classification {

	int pontos;
	int saldoDeGols;

	public Classification(Jogo[] jogos, Times[] times) {
		Times temp = new Times();
		for (int i = 0; i < times.length; i++) {
			for (int j = i + 1; j < times.length; j++) {
				if (times[i] != null) {
					if (times[j] != null) {
						if (Pontos(times[i].nome, jogos) < Pontos(times[j].nome, jogos)) {
							temp = times[i];
							times[i] = times[j];
							times[j] = temp;
						}else if (Pontos(times[i].nome, jogos) == Pontos(times[j].nome, jogos)) {
							if(SaldoDeGols(times[i].nome, jogos) < SaldoDeGols(times[j].nome, jogos)) {
								temp = times[i];
								times[i] = times[j];
								times[j] = temp;
							}
						}
					}
				}
			}
		}

		String align = "| %-15s | %-4d   | %-4d |%n";
		System.out.format("+-----------------+--------+------+%n");
		System.out.format("| Time            | Pontos | SG   |%n");
		System.out.format("+-----------------+--------+------+%n");

		for (int i = 0; i < times.length; i++) {
			if (times[i] != null) {
				System.out.format(align, times[i].nome.toString().toUpperCase(), Pontos(times[i].nome, jogos),
						SaldoDeGols(times[i].nome, jogos));
			}
		}
		System.out.format("+-----------------+--------+------%n");
	}

	private int Pontos(String nome, Jogo[] jogos) {
		int pontosTotal = 0;
		for (int i = 0; i < jogos.length; i++) {
			if (jogos[i] != null) {
				if (nome == jogos[i].timeMandante) {
					if (jogos[i].golsTimeMandante > jogos[i].golsTimeVisitante) {
						pontosTotal += 3;
					} else if (jogos[i].golsTimeMandante == jogos[i].golsTimeVisitante) {
						pontosTotal += 1;
					}
				} else if (nome == jogos[i].timeVisitante) {
					if (jogos[i].golsTimeVisitante > jogos[i].golsTimeMandante) {
						pontosTotal += 3;
					} else if (jogos[i].golsTimeVisitante == jogos[i].golsTimeMandante) {
						pontosTotal += 1;
					}
				}
			}
		}

		return pontosTotal;
	}

	private int SaldoDeGols(String nome, Jogo[] jogos) {
		int saldoTotal = 0;
		int golsProprios = 0;
		int golsSofridos = 0;
		for (int i = 0; i < jogos.length; i++) {
			if (jogos[i] != null) {
				if (nome == jogos[i].timeMandante) {
					golsProprios += jogos[i].golsTimeMandante;
					golsSofridos += jogos[i].golsTimeVisitante;
				} else if (nome == jogos[i].timeVisitante) {
					golsSofridos += jogos[i].golsTimeMandante;
					golsProprios += jogos[i].golsTimeVisitante;
				}
			}
		}

		saldoTotal = golsProprios - golsSofridos;
		return saldoTotal;
	}
}
