package modelo;

public abstract class Questao {
	private String tipo;
	protected String enunciado;
	private String alternativa;
	private String materia;

	public Questao(String tipo, String enunciado, String alternativa, String materia) {
		this.tipo = tipo;
		this.enunciado = enunciado;
		this.alternativa = alternativa;
		this.setMateria(materia);
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
	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}


	@Override
	public String toString() {
		return "Questao [tipo=" + tipo + ", enunciado=" + enunciado + ", alternativa=" + alternativa + "]";
	}


}
