package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

import br.edu.fateczl.lipe.PilhaString.Pilha;
import model.Corredor;

public class ThreadCorridaController extends Thread {
	
	private Semaphore corrida;
	private Corredor corredor;
	private List<Corredor> corredores = new ArrayList<Corredor>();
	private static String aux;
	
	public ThreadCorridaController(Semaphore corrida, Corredor corredor) {
		this.corrida = corrida;
		this.corredor = corredor;
	}
	
	@Override
	public void run() {
		corrida();
	}

	private void corredorFinalizou() {
		corredores.add(corredor);
		if (corredores.size() == 14)
			colocacao();
	}

	private void colocacao() {
		int index;
		Pilha p = new Pilha();
		
		for (Corredor c : corredores) {
			aux = c.getNomeCorredor() + "-" + c.getMelhorTempo();
			index = corredores.indexOf(c);
			for (Corredor cc : corredores) {
				if (c.getMelhorTempo() > cc.getMelhorTempo()) {
					aux = cc.getNomeCorredor() + "-" + cc.getMelhorTempo();
					index = corredores.indexOf(cc);
				}										
			}
			p.push(aux);
			corredores.remove(index);
		}
		
		try {
			System.out.println("Melhores tempos:");
			int i = 1;
			while(!p.isEmpty()) {
				i++;
				System.out.println(i + "º " + p.pop());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

	private void corrida() {
		try {
			Random volta = new Random();
			int tempo, melhorTempo = 0;
			corrida.acquire();
			for(int i = 1; i <= 3; i++) {
				tempo = volta.nextInt(5000) + 1000;
				Thread.sleep(tempo);
				if (melhorTempo > tempo || melhorTempo == 0)
					melhorTempo = tempo;
				System.out.println(corredor.getNomeCorredor() + " deu a " + i + "ª volta, tempo " + ((double) tempo / 1000) + "s.");
			}
			
			corredores.add(corredor);
			corredor.setMelhorTempo(melhorTempo / 1000);
			corredorFinalizou();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			corrida.release();
		}	
	}
}
