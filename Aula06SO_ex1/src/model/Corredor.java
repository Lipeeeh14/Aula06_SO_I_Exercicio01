package model;

import java.util.concurrent.Semaphore;

public class Corredor {

	private int numCorredor;
	private String nomeCorredor;
	private String nomeEscuderia;
	private double melhorTempo;
	public Semaphore escuderia;
	
	public Corredor() {
		this.escuderia = new Semaphore(1);
	}
	
	public int getNumCorredor() {
		return numCorredor;
	}
	
	public void setNumCorredor(int numCorredor) {
		this.numCorredor = numCorredor;
	}
	
	public String getNomeCorredor() {
		return nomeCorredor;
	}
	
	public void setNomeCorredor(String nomeCorredor) {
		this.nomeCorredor = nomeCorredor;
	}
	
	public String getNomeEscuderia() {
		return nomeEscuderia;
	}
	
	public void setNomeEscuderia(String nomeEscuderia) {
		this.nomeEscuderia = nomeEscuderia;
	}
	
	public double getMelhorTempo() {
		return melhorTempo;
	}
	
	public void setMelhorTempo(double melhorTempo) {
		this.melhorTempo = melhorTempo;
	}
	
	public void exibeCorredor() {
		System.out.println(this.getNomeCorredor() + " da " + this.nomeEscuderia + " melhor tempo: " + this.getMelhorTempo());
	}
}
