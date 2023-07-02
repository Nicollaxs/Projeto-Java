package modelo;

import java.util.ArrayList;

import dao.EditalDAO;
import dao.ExceptionDAO;

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

	public ArrayList<Edital> listarEditais(String nome) throws ExceptionDAO {
		return new EditalDAO().listarEditais(nome);

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

}