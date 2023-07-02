package modelo;

import java.util.ArrayList;

import dao.EditalDAO;
import dao.ExceptionDAO;
import dao.QuestaoDAO;

/**
 * Classe que representa uma questao do tipo Exatas, que herda da classe
 * Questao.
 * 
 * <p>
 * Esta classe representa uma questao do tipo Exatas que pode ser associada a um
 * edital.
 * A classe herda da classe Questao e possui metodos para manipulacao de editais
 * e questoes no banco de dados.
 * </p>
 * 
 * 
 * @see Questao
 * @see Edital
 * @see EditalDAO
 * @see QuestaoDAO
 * 
 * @author Samuel
 */
public class Exatas extends Questao {
	// atributo da classe exatas
	/**
	 * Construtor padrao da classe Exatas.
	 * 
	 * <p>
	 * Inicializa uma questao do tipo Exatas com valores padrao.
	 * </p>
	 */
	public Exatas() {
		super("", "", "", "");
		// this.respostaNumerica = "";
	}

	/**
	 * Construtor da classe Exatas com parametros.
	 * 
	 * <p>
	 * Constroi uma questão do tipo Exatas com os valores especificados.
	 * </p>
	 * 
	 * @param tipo        O tipo da questao (Exatas, Humanas, etc.).
	 * @param enunciado   O enunciado da questao.
	 * @param materia     A materia da questao.
	 * @param alternativa A alternativa correta da questao.
	 */
	public Exatas(String tipo, String enunciado, String materia, String alternativa) {
		super(tipo, enunciado, alternativa, materia);
		// this.respostaNumerica = respostaNumerica;
	}

	/**
	 * Altera o edital associado a esta questao.
	 * 
	 * @param edital O novo edital a ser associado a questao.
	 * @throws ExceptionDAO Se ocorrer algum erro durante a operacao de alteracao do
	 *                      edital.
	 */
	public void mudarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().mudarEdital(edital);
	}

	/**
	 * Deleta o edital associado a esta questao.
	 * 
	 * @param edital O edital a ser deletado.
	 * @throws ExceptionDAO Se ocorrer algum erro durante a operacao de exclusao do
	 *                      edital.
	 */
	public void deletarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().deletarEdital(edital);
	}

	/**
	 * Cadastra um novo edital no banco de dados.
	 * 
	 * @param edital O novo edital a ser cadastrado.
	 * @throws ExceptionDAO Se ocorrer algum erro durante a operacao de cadastro do
	 *                      edital.
	 */
	public void CadastrarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().CadastrarEdital(edital);
	}

	/**
	 * Retorna uma representacao em forma de String da questao.
	 * 
	 * @return Uma representacao da questao em formato de String.
	 */
	public String toString() {
		return "Exatas [Enunciado =" + enunciado + "][respostaNumerica=" + "]";
	}

	/**
	 * Lista todas as questoes de Exatas que correspondem a uma determinada materia.
	 * 
	 * @param materia A materia a ser pesquisada.
	 * @return Uma lista contendo todas as questoes de Exatas que correspondem a
	 *         materia pesquisada.
	 * @throws ExceptionDAO Se ocorrer algum erro durante a operacao de listagem das
	 *                      questoes.
	 */
	public ArrayList<Questao> listarQuestao(String materia) throws ExceptionDAO {
		return new QuestaoDAO().listarQuestao(materia);

	}

	/**
	 * Altera uma questao de Exatas no banco de dados.
	 * 
	 * @param questao A questao de Exatas a ser alterada.
	 * @throws ExceptionDAO Se ocorrer algum erro durante a operacao de alteracao da
	 *                      questao.
	 */
	public void mudarQuestao(Exatas questao) throws ExceptionDAO {
		new QuestaoDAO().mudarQuestao(questao);
	}

	/**
	 * Deleta uma questao de Exatas do banco de dados.
	 * 
	 * @param questao A questao de Exatas a ser deletada.
	 * @throws ExceptionDAO Se ocorrer algum erro durante a operacao de exclusao da
	 *                      questao.
	 */
	public void deletarQuestao(Exatas questao) throws ExceptionDAO {
		new QuestaoDAO().deletarQuestao(questao);
	}
}
