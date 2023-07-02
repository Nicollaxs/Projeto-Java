package modelo;

import java.util.ArrayList;

import dao.EditalDAO;
import dao.ExceptionDAO;

/**
 * Representa um Edital para um concurso.
 * 
 * 
 * @see dao.EditalDAO
 * @see dao.ExceptionDAO
 * @author Samuel
 */

public class Edital {
	String nome;
	String dataInicio;
	String dataTermino;
	String localidade;
	Float salario;
	int qtdVagas;
	int codEdital;

	public Edital() {

	}

	/**
	 * Construtor com parametros para inicializar os atributos do Edital.
	 * 
	 * @param nome        O nome do edital.
	 * @param dataInicio  A data de inicio do edital.
	 * @param dataTermino A data de termino do edital.
	 * @param localidade  A localidade do edital.
	 * @param salario     O salario oferecido pelo edital.
	 * @param qtdVagas    A quantidade de vagas disponiveis no edital.
	 */
	public Edital(String nome, String dataInicio, String dataTermino, String localidade, Float salario, int qtdVagas) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.localidade = localidade;
		this.salario = salario;
		this.qtdVagas = qtdVagas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public int getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	public int getCodEdital() {
		return codEdital;
	}

	public void setCodEdital(int codEdital) {
		this.codEdital = codEdital;
	}

	/**
	 * Lista todos os editais que possuam o nome informado.
	 * 
	 * @param nome O nome dos editais a serem buscados.
	 * @return Uma lista contendo os editais encontrados.
	 * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
	 */
	public ArrayList<Edital> listarEditais(String nome) throws ExceptionDAO {
		return new EditalDAO().listarEditais(nome);

	}

	/**
	 * Altera os dados de um edital no banco de dados.
	 * 
	 * @param edital O edital com os novos dados a serem atualizados.
	 * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
	 */
	public void mudarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().mudarEdital(edital);
	}

	/**
	 * Deleta um edital do banco de dados com base no seu codigo de identificacao.
	 * 
	 * @param edital O edital a ser deletado.
	 * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
	 */
	public void deletarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().deletarEdital(edital);
	}

	/**
	 * Cadastra um novo edital no banco de dados.
	 * 
	 * @param edital O novo edital a ser cadastrado.
	 * @throws ExceptionDAO Se ocorrer algum erro durante a execucao da operacao.
	 */
	public void CadastrarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().CadastrarEdital(edital);
	}

}