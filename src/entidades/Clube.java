package entidades;

public class Clube {
	private String nome;
	private int pontos;
	private int saldoGols;
	private int numeroVitorias;
	
	
	public Clube(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return String.format("%s    %d      %d                %d   %n",nome,pontos,saldoGols,numeroVitorias);
	}
	public String getNome(){
		return nome;
	}
	
	public int getPontos() {
		return pontos;
	}
	public int getSaldoGols() {
		return saldoGols;
	}
	public int getNumeroVitorias() {
		return numeroVitorias;
	}
	public void ganhar(int saldoGols){
		this.saldoGols += saldoGols;
		pontos += 3;
		numeroVitorias ++;
	}
	
	public void perder(int saldoGols) {
		this.saldoGols += saldoGols;
	}
	
	public void empate(){
		pontos++;
	}
	

	
	
}
