package modelo;

public class Exatas extends Questao {
	// atributo da classe exatas
	int respostaNumerica;

	public Exatas(String tipo, String enunciado, String alternativa, String materia, int respostaNumerica) {
		super(tipo, enunciado, alternativa, materia);
		this.respostaNumerica = respostaNumerica;
	}

	public int getRespostaNumerica() {
		return respostaNumerica;
	}

	public void setRespostaNumerica(int respostaNumerica) {
		this.respostaNumerica = respostaNumerica;
	}

	@Override
	public String toString() {
		return "Exatas [Enunciado =" + enunciado + "][respostaNumerica=" + respostaNumerica + "]";
	}

}
