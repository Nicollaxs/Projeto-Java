package modelo;

public abstract class Questao {
	private String tipo;
	private String enunciado;
	private String alternativa;

	public Questao(String tipo, String enunciado, String alternativa) {
		this.tipo = tipo;
		this.enunciado = enunciado;
		this.alternativa = alternativa;
	}

//gets e sets
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}

//metodos
	public void imprime() {
		System.out.println("Tipo : " + getTipo());
		System.out.println("Enunciado : " + getEnunciado());
		System.out.println("Alternativa : " + getAlternativa());
	}

	@Override
	public String toString() {
		return "Questao [tipo=" + tipo + ", enunciado=" + enunciado + ", alternativa=" + alternativa + "]";
	}

}
