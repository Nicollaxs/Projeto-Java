package modelo;

import java.util.ArrayList;

/**
 * Pacote que contem as classes de modelo para o sistema de provas.
 * 
 * <p>
 * O pacote "modelo" contem as classes de modelo utilizadas no sistema de
 * provas.
 * Essas classes representam as entidades principais do sistema e sao
 * responsaveis por armazenar
 * e manipular informacoes relacionadas às provas e suas questoes.
 * 
 * <p>
 * Essa classe "Prova" representa uma prova que sera aplicada em um determinado
 * horario
 * e contem uma lista de questoes associadas a ela.
 * 
 * @version 1.0
 */
public class Prova {

	private String horarioInicio;
	private String horarioTermino;
	private ArrayList<Questao> questoes;

	/**
	 * Construtor da classe "Prova".
	 * 
	 * <p>
	 * Cria uma instancia de "Prova" com os parametros fornecidos.
	 * 
	 * @param horarioInicio  O horario de inicio da prova.
	 * @param horarioTermino O horario de termino da prova.
	 * @param questoes       A lista de questoes associadas a prova.
	 */
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

	/**
	 * Metodo para obter a lista de questoes da prova.
	 * 
	 * @return A lista de questoes da prova.
	 */
	public ArrayList<Questao> getQuestoes() {
		return questoes;
	}

	/**
	 * Metodo para definir a lista de questoes da prova.
	 * 
	 * @param questoes A lista de questoes a ser definida.
	 */
	public void setQuestoes(ArrayList<Questao> questoes) {
		this.questoes = questoes;
	}

	/**
	 * Representacao em formato de string do objeto "Prova".
	 * 
	 * @return Uma string contendo informacoes relevantes sobre a instancia de
	 *         "Prova".
	 */
	@Override
	public String toString() {
		return "Prova [horarioInicio=" + horarioInicio + ", horarioTermino=" + horarioTermino + ", questoes=" + questoes
				+ "]";
	}

}
