package pacote;

import java.util.ArrayList;

public class Materia {
	String nome;
	String topico;
	private ArrayList<Questao>questoes;

	@Override  
	public String toString() { 
		return " Nome: " + nome + ", Topico: " + topico + ", Questoes: " +  questoes;
	}

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

	public ArrayList<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(ArrayList<Questao> questoes) {
		this.questoes = questoes;
	}

}
