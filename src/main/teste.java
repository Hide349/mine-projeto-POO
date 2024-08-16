package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Campeonato;
import entidades.Clube;

public class teste {
	public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
	}
	
	public static void main(String[] args) {
		List<Clube> clubes = new ArrayList<>();
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		int opcao;
		String nome;
		while(!exit){
			System.out.println("------1 Adicionar time-------");
			System.out.println("------2 Começar campeonato----");
			opcao = sc.nextInt();
			clear();
			switch(opcao){
				case 1:{
					System.out.println("Digite o nome do time: ");
					sc.nextLine();
					nome =sc.next();
					clubes.add(new Clube(nome));
					break;
				}
				case 2:{
					if(clubes.size() >1) {
						Campeonato brasileirao = new Campeonato(clubes);
						brasileirao.jogaCampeonato();
						exit = true;
					}else {
						System.out.println("Quantidade de times insuficiente para começar o campeonato!");
					}
					break;
				}
				default:{
					System.out.println("Digite uma opção válida!");
					break;
				}
			}
		}
		sc.close();
	}
}
