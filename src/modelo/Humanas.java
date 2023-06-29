package modelo;

public class Humanas extends Questao {
	// atributo da classe humanas
	String respostaDiscursiva;

	// herança

	public Humanas(String tipo, String enunciado, String alternativa, String materia, String respostaDiscursiva) {
		super(tipo, enunciado, alternativa, materia);
		this.respostaDiscursiva = respostaDiscursiva;
	}

	public String getRespostaDiscursiva() {
		return respostaDiscursiva;
	}

	public void setRespostaDiscursiva(String respostaDiscursiva) {
		this.respostaDiscursiva = respostaDiscursiva;
	}

	public String toString() {
		return "Humanas [Enunciado=" + enunciado + "][respostaDiscursiva=" + respostaDiscursiva + "]";
	}

}
