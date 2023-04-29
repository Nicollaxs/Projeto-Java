package pacote;

public class Edital {
	String nome;
	String dataInicio;
	String dataTermino;
	String local;
	float salario;
	int qtdVagas;
	boolean aberto;

	public Edital(String nome, String dataInicio, String dataTermino, String local, float salario, int qtdVagas,
			boolean aberto) {
		super();
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.local = local;
		this.salario = salario;
		this.qtdVagas = qtdVagas;
		this.aberto = aberto;
	}

	// gets e sets
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	@Override
	public String toString() { 
		return "Nome: " + nome + ", DataInicio: " + dataInicio + ", DataTermino: " + dataTermino + ", Local: " + local + ", Salario: " + salario + ", QtdVagas: " + qtdVagas + ", Aberto: " + aberto;
		
	}

}
