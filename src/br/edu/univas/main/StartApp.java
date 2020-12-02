package br.edu.univas.main;

import java.util.Scanner;

import br.edu.univas.options.Classification;
import br.edu.univas.options.OptionsJogo;
import br.edu.univas.options.OptionsTime;
import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.Times;

public class StartApp {

	public static void main(String[] args) {
		Times[] times = new Times[50];
		Jogo[] jogos = new Jogo[50];
		boolean sair = false;
		System.out.println("   ____                    ____     __      __        __  ___  ____\r\n" + 
				"  / __/_ _____  ___ ____  / __/_ __/ /____ / /  ___  / / / _ \\/ __/\r\n" + 
				" _\\ \\/ // / _ \\/ -_) __/ / _// // / __/ -_) _ \\/ _ \\/ /  \\_, / _ \\ \r\n" + 
				"/___/\\_,_/ .__/\\__/_/   /_/  \\_,_/\\__/\\__/_.__/\\___/_/  /___/\\___/ \r\n" + 
				"        /_/");
		System.out.println("********************************************************************");
		System.out.println("*                                           ___                    *");
		System.out.println("*                       o__        o__     |   |\\                  *");
		System.out.println("*                      /|          /\\      |   |X\\                 *");
		System.out.println("*                      / > o        <\\     |   |XX\\                *");
		System.out.println("********************************************************************");
		System.out.println("\n");
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Escolha uma das opções abaixo: 1 a 9");
			System.out.println("1 – Cadastrar Time");
			System.out.println("2 – Editar Time");
			System.out.println("3 – Excluir Time");
			System.out.println("4 – Cadastrar Jogo");
			System.out.println("5 – Editar Jogo");
			System.out.println("6 – Excluir Jogo");
			System.out.println("7 – Listar Classificação do Campeonato");
			System.out.println("9 - Sair");
			int choosed = input.nextInt();
			
			switch (choosed) {
			case 1:
				new OptionsTime("cadastrar", times);
				break;
			case 2:
				new OptionsTime("editar", times);
				break;
			case 3:
				new OptionsTime("excluir", times);
				break;
			case 4:
				new OptionsJogo("cadastrar", jogos, times);
				break;
			case 5:
				new OptionsJogo("editar", jogos, times);
				break;
			case 6:
				new OptionsJogo("excluir", jogos, times);
				break;
			case 7:
				new Classification(jogos, times);
				break;
			case 9:
				input.close();
				sair = true;
				break;
			default:
				break;
			}
		} while (!sair);
	}
}
