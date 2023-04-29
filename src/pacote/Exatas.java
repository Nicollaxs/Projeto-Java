package pacote;

public class Exatas extends Questao {
	// atributo da classe exatas
	int respostaNumerica;

	// herança
	public Exatas(String tipo, String enunciado, String alternativa, int respostaNumerica) {

		super(tipo, enunciado, alternativa);
		this.respostaNumerica = respostaNumerica;

	}

	// gets e sets
	public int getRespostaNumerica() {
		return respostaNumerica;
	}

	public void setRespostaNumerica(int respostaNumerica) {
		this.respostaNumerica = respostaNumerica;
	}

	// metodo da classe
	public void imprime() {
		super.imprime();
		System.out.println("Resposta : " + respostaNumerica);
	}
	
	@Override
	public String toString() { 
		return "RespostaNumerica: " + respostaNumerica; 
	}
}
