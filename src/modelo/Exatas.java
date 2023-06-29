package modelo;

public class Exatas extends Questao {
	// atributo da classe exatas
	String respostaNumerica;

	public Exatas(String tipo, String enunciado, String alternativa, String materia, String respostaNumerica) {
		super(tipo, enunciado, alternativa, materia);
		this.respostaNumerica = respostaNumerica;
	}

	public String getRespostaNumerica() {
		return respostaNumerica;
	}

	public void setRespostaNumerica(String respostaNumerica) {
		this.respostaNumerica = respostaNumerica;
	}

	public void CadastrarQuestaoExatas(Questao questao) {
	}

	public String toString() {
		return "Exatas [Enunciado =" + enunciado + "][respostaNumerica=" + respostaNumerica + "]";
	}

}
