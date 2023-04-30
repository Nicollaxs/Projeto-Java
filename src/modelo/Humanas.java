package modelo;

public class Humanas extends Questao {
	// atributo da classe humanas
	String respostaDiscursiva;

	// herança
	public Humanas(String tipo, String enunciado, String alternativa, String respostaDiscursiva) {

		super(tipo, enunciado, alternativa);
		this.respostaDiscursiva = respostaDiscursiva;

	}

	public void imprime() {
		// herança de metodo
		super.imprime();
		System.out.println("Resposta : " + respostaDiscursiva);
	}

	@Override
	public String toString() {
		return "Humanas [respostaDiscursiva=" + respostaDiscursiva + "]";
	}

}
