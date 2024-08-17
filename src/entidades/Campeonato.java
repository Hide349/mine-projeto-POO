package entidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Campeonato {
	List<Clube> clubes = new ArrayList<>();
	
	
	public Campeonato(List<Clube> clubes) {
		this.clubes = clubes;
	}
	
	public int sortearGols(int max, int min) {
		return (int)(Math.random() * (max - min + 1)+min);
	}
	
	public void jogaCampeonato() {
		for(int i = 0; i< clubes.size();i++) {
			for(int j = 0; j< clubes.size();j++) {
				if(i != j) {
					jogarPartida(clubes.get(i),clubes.get(j));
				}
			}
		}
		System.out.printf(getClassificacao());
		getCampeao();
		
		
	}
	
	private void jogarPartida(Clube clubeA, Clube clubeB) {
			int golA = sortearGols(5,0);
			int golB = sortearGols(5,0);
			System.out.printf("A partida entre %s e %s está rolando...%n",clubeA.getNome(),clubeB.getNome());
			try {
				Thread.sleep(2000);

			}catch (Exception e) {
				e.printStackTrace();
			}
			if(golA > golB) {
				clubeA.ganhar(golA - golB);
				clubeB.perder(golB - golA);
				System.out.printf("O time %s ganhou de %d x %d do %s%n",clubeA.getNome(),golA,golB,clubeB.getNome());
			}else if( golA == golB) {
				System.out.printf("%s empatou com o %s%n",clubeA.getNome(),clubeB.getNome());
				clubeA.empate();
				clubeB.empate();
			}else {
				System.out.printf("O time %s ganhou de %d x %d do %s%n",clubeB.getNome(),golB,golA,clubeA.getNome());
				clubeB.ganhar(golB - golA);
				clubeA.perder(golA -golB);
			}
	}
	
	private String getClassificacao() {
		int i = 1;
		String frase = "Pos | Nome | Pontos | Saldo Gols  | Vitórias %n";
		clubes.sort(Comparator.comparing(Clube::getPontos).thenComparing(Clube::getSaldoGols).thenComparing(Clube::getNumeroVitorias).reversed());
		for(Clube obj : clubes) {
			frase += String.format("%dº "+obj.toString(), i);
			i++;
		}
		return frase;
	}
	
	private void getCampeao() {
		System.out.printf("----------PARABÉNS PELA VITÓRIA-------------%n %s", clubes.get(0).getNome());
	}
	
}
