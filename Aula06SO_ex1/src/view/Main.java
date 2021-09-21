package view;

import java.util.List;
import java.util.concurrent.Semaphore;

import controller.ThreadCorridaController;
import model.Corredor;

public class Main {

	public static List<Semaphore> escuderia;
	public static Semaphore corrida;
	public static Semaphore ferrari;
	
	public static void main(String[] args) {
		corrida = new Semaphore(5);

		for (int i = 1; i <= 14; i++) {		
			Thread formula1 = new ThreadCorridaController(corrida, definirCorredor(i));
			formula1.start();
		}
	}

	private static Corredor definirCorredor(int id) {
		Corredor corredor = new Corredor();
		String nome;
		
		switch(id) {
			case 1: case 2:
				nome = id % 2 == 0 ? "Mario Bros" : "Luigi";
				corredor.setNomeCorredor(nome);
				corredor.setNumCorredor(id);
				corredor.setNomeEscuderia("Ferrari");
				break;
			case 3: case 4:
				nome = id % 2 == 0 ? "Yoshi" : "Bowser";
				corredor.setNumCorredor(id);
				corredor.setNomeCorredor(nome);
				corredor.setNomeEscuderia("McLaren");
				break;
			case 5: case 6:
				nome = id % 2 == 0 ? "Wario" : "Waluigi";
				corredor.setNomeCorredor(nome);
				corredor.setNumCorredor(id);
				corredor.setNomeEscuderia("Red Bull");
				break;
			case 7: case 8:
				nome = id % 2 == 0 ? "Princesa Peach" : "Rosalinda";
				corredor.setNomeCorredor(nome);
				corredor.setNumCorredor(id);
				corredor.setNomeEscuderia("Mercedes");
				break;
			case 9: case 10:
				nome = id % 2 == 0 ? "Diddy kong" : "Rei Bu";
				corredor.setNomeCorredor(nome);
				corredor.setNumCorredor(id);
				corredor.setNomeEscuderia("Williams");
				break;
			case 11: case 12:
				nome = id % 2 == 0 ? "Toad" : "Bowser Jr";
				corredor.setNomeCorredor(nome);
				corredor.setNumCorredor(id);
				corredor.setNomeEscuderia("RBR");
				break;
			case 13: case 14:
				nome = id % 2 == 0 ? "Donkey Kong" : "Toadette";
				corredor.setNomeCorredor(nome);
				corredor.setNumCorredor(id);
				corredor.setNomeEscuderia("Alfa Romeo");
				break;
		}
		
		return corredor;
	}

}
