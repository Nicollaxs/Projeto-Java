package modelo;

import java.util.ArrayList;

import dao.EditalDAO;
import dao.ExceptionDAO;

public class Edital {
	String nome;
	String dataInicio;
	String dataTermino;
	String localidade;
	String salario;
	String qtdVagas;

	int codEdital;

	public Edital() {

	}

	public Edital(String nome, String dataInicio, String dataTermino, String local, String salario, String qtdVagas) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.localidade = local;
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

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(String qtdVagas) {
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
