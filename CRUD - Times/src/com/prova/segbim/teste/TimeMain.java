package com.prova.segbim.teste;

import java.util.Optional;
import java.util.Scanner;

import org.omg.CORBA.ExceptionList;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.prova.segbim.dao.Dao;
import com.prova.segbim.dao.TimeDao;
import com.prova.segbim.entidade.Time;

public class TimeMain {

	private static Dao<Time> timeDao;

	public static void main(String[] args) {

		timeDao = new TimeDao();

		while (true) {
			System.out.println("_____________________________________________");
			System.out.println("| Opção |               Ação                |");
			System.out.println("|   1   |      Cadastrar um novo time       |");
			System.out.println("|   2   |    Alterar algum time já criado   |");
			System.out.println("|   3   |    Remover algum time já criado   |");
			System.out.println("|   4   |     Listar times cadastrados      |");
			System.out.println("|   5   |               Sair                |");
			System.out.println("---------------------------------------------");
			System.out.println("- Olá, qual opção o senhor(a) deseja? ");

			int opcao = 0;
			Scanner valorInserido = new Scanner(System.in);
			Scanner valorInseridoChar = new Scanner(System.in);
			Scanner valorInseridoRemove = new Scanner(System.in);
			Scanner valorInseridoQtdJogadores = new Scanner(System.in);
			Scanner valorInseridoNomeTime = new Scanner(System.in);
			Scanner valorInseridoTecnico = new Scanner(System.in);
			Scanner valorInseridoSite = new Scanner(System.in);
			Scanner valorInseridoEstadio = new Scanner(System.in);
			Scanner valorInseridoQtdJogadores2 = new Scanner(System.in);
			Scanner valorInseridoNomeTime2 = new Scanner(System.in);
			Scanner valorInseridoTecnico2 = new Scanner(System.in);
			Scanner valorInseridoSite2 = new Scanner(System.in);
			Scanner valorInseridoEstadio2 = new Scanner(System.in);

			try {
				opcao = valorInserido.nextInt();
			} catch (Exception erro) {
				System.out.println("Escolha uma opção de 1 a 5");
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.printf("Digite o nome do time: ");
				String nome = valorInseridoNomeTime.nextLine();

				if (nome.isEmpty()) {
					System.out.println("O nome não pode ser nulo");
				} else {

					System.out.printf("Digite o nome do técnico do time: ");
					String tecnico = valorInseridoTecnico.nextLine();

					if (tecnico.isEmpty()) {
						System.out.println("O nome do técnico não pode ser nulo");
					} else {

						System.out.printf("Digite a quantidade de jogadores do time: ");
						Integer qtdJogadores = valorInseridoQtdJogadores.nextInt();

						if (qtdJogadores <= 0) {
							System.out.println("A quantidade de jogadores não pode ser nulo");
						} else {

							System.out.printf("Digite o site do time: ");
							String site = valorInseridoSite.nextLine();

							if (site.isEmpty()) {
								System.out.println("O site não pode ser nulo");
							} else {

								System.out.printf("Digite o nome do estádio do time: ");
								String estadio = valorInseridoEstadio.nextLine();

								if (estadio.isEmpty()) {
									System.out.println("O estádio não pode ser nulo");
								} else {

									int id = timeDao.getAll().size();

									Time time = new Time(id + 1, nome, tecnico, qtdJogadores, site, estadio);

									timeDao.save(time);

									System.out.println("O time foi cadastrado com sucesso!");
								}
							}
						}
					}
				}
				break;
			case 2:
				if (timeDao.getAll().isEmpty()) {
					System.out.println("Lista vazia");
				} else {

					try {
						timeDao.getAll().forEach(
								item -> System.out.println("ID: " + item.getId() + " TIME: " + item.getNome()));
						System.out.println("Qual o ID do Time você deseja alterar? ");
						long id3 = valorInserido.nextLong();
						Optional<Time> time3 = timeDao.get(id3 - 1);

						System.out.printf("Digite o nome do time que você deseja alterar: ");
						String nome2 = valorInseridoNomeTime2.nextLine();

						if (nome2.isEmpty()) {
							System.out.println("O nome não pode ser nulo");
						} else {

							System.out.printf("Digite o técnico do time que você deseja alterar: ");
							String tecnico2 = valorInseridoTecnico2.nextLine();

							if (tecnico2.isEmpty()) {
								System.out.println("O nome do técnico não pode ser nulo");
							} else {

								System.out.printf("Digite a quantidade de jogadores do time que você deseja alterar: ");
								Integer qtdJogadores2 = valorInseridoQtdJogadores2.nextInt();

								if (qtdJogadores2 <= 0) {
									System.out.println("A quantidade de jogadores não pode ser negativa ou nula");
								} else {

									System.out.printf("Digite o site do time que você deseja alterar: ");
									String site2 = valorInseridoSite2.nextLine();

									if (site2.isEmpty()) {
										System.out.println("O site não pode ser nulo");
									} else {

										System.out.printf("Digite o estádio do time que você deseja alterar: ");
										String estadio2 = valorInseridoEstadio2.nextLine();

										if (estadio2.isEmpty()) {
											System.out.println("O estádio não pode ser nulo");
										} else {

											timeDao.update(time3.get(),
													new String[] { nome2, tecnico2, site2, estadio2 });
											timeDao.update(time3.get(), new Integer[] { qtdJogadores2 });

											System.out.println("O time foi alterado com sucesso!");

										}
									}
								}
							}
						}
					} catch (InputMismatchException erro) {
						System.out.println("Digite um número inteiro");
					} catch (Exception erro2) {
						System.out.println("O id inserido não existe, tente novamente!");
					}
				}

				break;
			case 3:
				if (timeDao.getAll().isEmpty()) {
					System.out.println("Lista vazia");
				} else {
					try {
						timeDao.getAll().forEach(
								item -> System.out.println("ID: " + item.getId() + " TIME: " + item.getNome()));
						System.out.println("Qual time você deseja remover? ");
						long id2 = valorInseridoRemove.nextLong();
						Optional<Time> time3 = timeDao.get(id2 - 1);
						timeDao.remove(time3.get());

						System.out.println("O time foi removido com sucesso!");

					} catch (InputMismatchException erro3) {
						System.out.println("Digite um número inteiro");
					} catch (Exception erro4) {
						System.out.println("O id inserido não existe, tente novamente!");
					}
				}
				break;
			case 4:
				timeDao.getAll()
						.forEach(item -> System.out.println("ID: " + item.getId() + " TIME: " + item.getNome()
								+ " TÉCNICO: " + item.getTecnico() + " QUANTIDADE DE JOGADORES: " + item.getQtdJogador()
								+ " SITE: " + item.getSite() + " ESTÁDIO: " + item.getEstadio()));
				if (timeDao.getAll().isEmpty()) {
					System.out.println("Lista vazia");
				}
				break;
			case 5:
				System.out.println("Sistema Finalizado");
				System.exit(0);
				break;
			default:
				System.out.println("Opção inexistente, tente novamente!");
			}
			System.out.println("Deseja continuar? [S] ou [N]");
			String opcao2 = valorInserido.next();

			if (opcao2.equals("N") || opcao2.equals("n")) {
				System.out.println("Sistema Finalizado");
				System.exit(0);
			} else if (opcao2.equals("S") || opcao2.equals("s")) {

			} else {
				System.out.println("Caracter inválido, tente novamente!");
				System.out.println("Sistema Finalizado");
				System.exit(0);
			}

		}

	}

}
