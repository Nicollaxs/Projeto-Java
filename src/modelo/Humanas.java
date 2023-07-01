package modelo;

import java.util.ArrayList;

import dao.EditalDAO;
import dao.ExceptionDAO;
import dao.QuestaoDAO;

public class Humanas extends Questao {
	// atributo da classe humanas

	// herança
	public Humanas() {
		super("", "", "", "");
		// t his.respostaDiscursiva = "";
	}

	public Humanas(String tipo, String enunciado, String alternativa, String materia) {
		super(tipo, enunciado, alternativa, materia);

	}

	public void mudarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().mudarEdital(edital);
	}

	public void deletarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().deletarEdital(edital);
	}

	public void CadastrarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().CadastrarEdital(edital);
	}

	public String toString() {
		return "Humanas [Enunciado=" + enunciado + "][respostaDiscursiva=" + "]";
	}

	public ArrayList<Questao> listarQuestao(String materia) throws ExceptionDAO {
		return new QuestaoDAO().listarQuestao(materia);
	}

	public void mudarQuestao(Exatas questao) throws ExceptionDAO {
		new QuestaoDAO().mudarQuestao(questao);
	}

	public void deletarQuestao(Exatas questao) throws ExceptionDAO {
		new QuestaoDAO().deletarQuestao(questao);
	}
}
