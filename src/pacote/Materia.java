package pacote;

public class Materia {
	String nome;
	String topico;
	private Questao[] questoes = new Questao[10];

//gets e sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public Questao[] getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Questao[] questoes) {
		this.questoes = questoes;
	}
	@Override  
	public String toString() { 
		return " Nome: " + nome + ", Topico: " + topico + ", Questoes: " +  questoes;
	}

}
