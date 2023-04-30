package modelo;

import java.util.ArrayList;

public class Materia {
	String nome;
	String topico;
	private ArrayList<Questao> questoes;

	
	public Materia(String nome, String topico) {
		super();
		this.nome = nome;
		this.topico = topico;
	}

	// gets e sets
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

	@Override
	public String toString() {
		return "Materia [nome=" + nome + ", topico=" + topico + "]";
	}
}
