package modelo;

public class Aluno {

	String nome;
	int idade;
	String inscricoes;

	public Aluno(String nome, int idade, String inscricoes) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.inscricoes = inscricoes;
	}

	// gets e sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(String inscricoes) {
		this.inscricoes = inscricoes;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", inscricoes=" + inscricoes + "]";
	}

}
