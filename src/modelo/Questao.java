package modelo;

import java.util.ArrayList;

import dao.QuestaoDAO;
import dao.ExceptionDAO;

public abstract class Questao {
	private String tipo;
	private String materia;
	protected String enunciado;
	private String resposta;

	private int codQuestao;

	public Questao() {

	}

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

	public void CadastrarQuestao(Questao questao) throws ExceptionDAO {
		new QuestaoDAO().CadastrarQuestao(questao);

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