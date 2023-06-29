package modelo;

import java.util.Date;
import java.util.ArrayList;

import dao.EditalDAO;
import dao.ExceptionDAO;

public class Edital {
	String nome;
	Date dataInicio;
	Date dataTermino;
	String localidade;
	String salario;
	String qtdVagas;
	private int codEdital;

	public int getCodEdital() {
		return codEdital;
	}// boolean aberto;

	public Edital() {

	}

	public Edital(String nome, Date data, Date data2, String local, String salario, String qtdVagas) {
		this.nome = nome;
		this.dataInicio = data;
		this.dataTermino = data2;
		this.localidade = local;
		this.salario = salario;
		this.qtdVagas = qtdVagas;
	}

	public void CadastrarEdital(Edital edital) throws ExceptionDAO {
		new EditalDAO().CadastrarEdital(edital);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date string) {
		this.dataTermino = string;
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

	@Override
	public String toString() {
		return "Edital [nome=" + nome + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", local="
				+ localidade + ", salario=" + salario + ", qtdVagas=" + qtdVagas + ", aberto=" + "]";
	}

	public ArrayList<Edital> listarEditais(String nome) throws ExceptionDAO {
		return new EditalDAO().listarEditais(nome);

	}
}
