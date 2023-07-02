package modelo;

import java.util.ArrayList;

import dao.QuestaoDAO;
import dao.ExceptionDAO;

/**
 * Pacote que contem as classes de modelo para o sistema de provas.
 * 
 * <p>
 * O pacote "modelo" cotem as classes de modelo utilizadas no sistema de provas.
 * Essas classes representam as entidades principais do sistema e sao
 * responsaveis por armazenar
 * e manipular informacoes relacionadas as questoes da prova.
 * 
 * <p>
 * Essa e uma classe abstrata "Questao" que serve como base para as questoes que
 * serao utilizadas no sistema.
 * Ela contem atributos comuns a todas as questoes, como tipo, materia,
 * enunciado e resposta.
 * 
 * @version 1.0
 */
public abstract class Questao {
	private String tipo;
	private String materia;
	protected String enunciado;
	private String resposta;

	private int codQuestao;

	/**
	 * Construtor vazio da classe "Questao".
	 * 
	 * <p>
	 * Cria uma instancia de "Questao" sem atribuir valores aos seus atributos.
	 */
	public Questao() {

	}

	/**
	 * Construtor da classe "Questao".
	 *
	 * <p>
	 * Cria uma instancia de "Questao" com os parametros fornecidos.
	 * 
	 * @param tipo      O tipo da questao.
	 * @param materia   A materia da questao.
	 * @param enunciado O enunciado da questao.
	 * @param resposta  A resposta da questao.
	 */
	public Questao(String tipo, String materia, String enunciado, String resposta) {
		this.tipo = tipo;
		this.materia = materia;
		this.enunciado = enunciado;
		this.resposta = resposta;

	}

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

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public int getCodQuestao() {
		return codQuestao;
	}

	public void setCodQuestao(int codQuestao) {
		this.codQuestao = codQuestao;
	}

	/**
	 * Metodo para cadastrar uma nova questao no sistema.
	 * 
	 * @param questao A questao a ser cadastrada.
	 * @throws ExceptionDAO Caso ocorra algum erro durante o cadastro da questao no
	 *                      banco de dados.
	 */
	public void CadastrarQuestao(Questao questao) throws ExceptionDAO {
		new QuestaoDAO().CadastrarQuestao(questao);

	}

	/**
	 * Metodo para listar questoes com base em uma materia.
	 * 
	 * @param materia A materia das questoes a serem listadas.
	 * @return Uma lista de questoes relacionadas a materia especificada.
	 * @throws ExceptionDAO Caso ocorra algum erro ao listar as questoes no banco de
	 *                      dados.
	 */
	public ArrayList<Questao> listarQuestao(String materia) throws ExceptionDAO {
		return new QuestaoDAO().listarQuestao(materia);

	}

	/**
	 * Metodo para mudar uma questao existente no sistema.
	 * 
	 * @param questao A questao a ser alterada.
	 * @throws ExceptionDAO Caso ocorra algum erro durante a alteracao da questao no
	 *                      banco de dados.
	 */
	public void mudarQuestao(Exatas questao) throws ExceptionDAO {
		new QuestaoDAO().mudarQuestao(questao);
	}

	/**
	 * Metodo para deletar uma questao do sistema.
	 * 
	 * @param questao A questao a ser deletada.
	 * @throws ExceptionDAO Caso ocorra algum erro durante a exclusao da questao no
	 *                      banco de dados.
	 */
	public void deletarQuestao(Exatas questao) throws ExceptionDAO {
		new QuestaoDAO().deletarQuestao(questao);
	}
}