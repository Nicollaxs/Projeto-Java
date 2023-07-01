package modelo;

import java.util.ArrayList;

import dao.EditalDAO;
import dao.ExceptionDAO;
import dao.QuestaoDAO;

public class Exatas extends Questao {
	// atributo da classe exatas

	public Exatas() {
		super("", "", "", "");
		// this.respostaNumerica = "";
	}

	public Exatas(String tipo, String enunciado, String materia, String alternativa) {
		super(tipo, enunciado, alternativa, materia);
		// this.respostaNumerica = respostaNumerica;
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
		return "Exatas [Enunciado =" + enunciado + "][respostaNumerica=" + "]";
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
