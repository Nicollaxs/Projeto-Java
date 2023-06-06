package modelo;

import java.util.ArrayList;

public class Prova {

	private String horarioInicio;
	private String horarioTermino;
	private ArrayList<Questao> questoes;


	public Prova(String horarioInicio, String horarioTermino, ArrayList<Questao> questoes) {
		super();
		this.horarioInicio = horarioInicio;
		this.horarioTermino = horarioTermino;
		this.questoes = questoes;
	}

	// gets e sets

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioTermino() {
		return horarioTermino;
	}

	public void setHorarioTermino(String horarioTermino) {
		this.horarioTermino = horarioTermino;
	}

	public ArrayList<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(ArrayList<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
	public String toString() {
		return "Prova [horarioInicio=" + horarioInicio + ", horarioTermino=" + horarioTermino + ", questoes=" + questoes
				+ "]";
	}

}
