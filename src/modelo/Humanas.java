package modelo;

import java.util.ArrayList;

import dao.EditalDAO;
import dao.ExceptionDAO;
import dao.QuestaoDAO;
/**
 * Classe que representa uma questao do tipo Humanas, que herda da classe Questao.
 * 
 * <p>Esta classe representa uma questao do tipo Humanas que pode ser associada a um edital.
 * A classe herda da classe Questao e possui metodos para manipulacao de editais e questoes no banco de dados.</p>

 * 
 * @author Samuel
 * @version 1.0
 */
public class Humanas extends Questao {
	// atributo da classe humanas

	/**
	 * Construtor padrao da classe "Humanas".
	 * 
	 * <p>Cria uma instancia de "Humanas" com os atributos iniciais vazios.
	 */
	public Humanas() {
		super("", "", "", "");
		// t his.respostaDiscursiva = "";
	}
	/**
	 * Construtor da classe "Humanas" com parametros.
	 * 
	 * <p>Cria uma instancia de "Humanas" com os atributos fornecidos como parametros.
	 * 
	 * @param tipo O tipo da questao (objetiva, discursiva, etc.).
	 * @param enunciado O enunciado da questao.
	 * @param alternativa A alternativa da questao (caso seja objetiva).
	 * @param materia A materia a qual a questao pertence.
	 */
	public Humanas(String tipo, String enunciado, String alternativa, String materia) {
		super(tipo, enunciado, alternativa, materia);

	}
	/**
	 * Metodo para alterar um edital.
	 * 
	 * <p>Este metodo permite a alteracao de informacoes de um edital existente.
	 * 
	 * @param edital O objeto "Edital" com as informacoes a serem alteradas.
	 * @throws ExceptionDAO Se ocorrer um erro durante a operacao de alteracao do edital.
	 */
	public void mudarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().mudarEdital(edital);
	}
	/**
	 * Metodo para deletar um edital.
	 * 
	 * <p>Este metodo permite a exclusao de um edital existente do sistema.
	 * 
	 * @param edital O objeto "Edital" a ser deletado.
	 * @throws ExceptionDAO Se ocorrer um erro durante a operacao de exclusao do edital.
	 */
	public void deletarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().deletarEdital(edital);
	}
	/**
	 * Metodo para cadastrar um novo edital.
	 * 
	 * <p>Este metodo permite o cadastro de um novo edital no sistema.
	 * 
	 * @param edital O objeto "Edital" a ser cadastrado.
	 * @throws ExceptionDAO Se ocorrer um erro durante a operacao de cadastro do edital.
	 */
	public void CadastrarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().CadastrarEdital(edital);
	}
	/**
	 * Representacao em formato de string do objeto "Humanas".
	 * 
	 * @return Uma string contendo informacoes relevantes sobre a instancia de "Humanas".
	 */
	public String toString() {
		return "Humanas [Enunciado=" + enunciado + "][respostaDiscursiva=" + "]";
	}
	/**
	 * Metodo para listar questoes de uma determinada materia.
	 * 
	 * <p>Este metodo permite listar todas as questoes relacionadas a uma determinada materia.
	 * 
	 * @param materia A materia para a qual deseja-se listar as questoes.
	 * @return Uma lista contendo as questoes relacionadas a materia especificada.
	 * @throws ExceptionDAO Se ocorrer um erro durante a operacao de listagem das questoes.
	 */
	public ArrayList<Questao> listarQuestao(String materia) throws ExceptionDAO {
		return new QuestaoDAO().listarQuestao(materia);
	}
	/**
	 * Metodo para alterar uma questao.
	 * 
	 * <p>Este metodo permite a alteraçao de informacoes de uma questao existente.
	 * 
	 * @param questao O objeto "Exatas" com as informacoes a serem alteradas.
	 * @throws ExceptionDAO Se ocorrer um erro durante a operacao de alteracao da questao.
	 */

	public void mudarQuestao(Exatas questao) throws ExceptionDAO {
		new QuestaoDAO().mudarQuestao(questao);
	}
	/**
	 * Metodo para deletar uma questao.
	 * 
	 * <p>Este metodo permite a exclusao de uma questao existente do sistema.
	 * 
	 * @param questao O objeto "Exatas" a ser deletado.
	 * @throws ExceptionDAO Se ocorrer um erro durante a operacao de exclusao da questao.
	 */
	public void deletarQuestao(Exatas questao) throws ExceptionDAO {
		new QuestaoDAO().deletarQuestao(questao);
	}
}
