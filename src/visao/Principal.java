package visao;

import java.util.ArrayList;
import modelo.Aluno;
import modelo.Edital;
import modelo.Exatas;
import modelo.Humanas;
import modelo.Prova;
import modelo.Questao;

public class Principal {

	public static void main(String[] args) {

		// atributos são apenas testes
		Aluno aluno = new Aluno("Joao", 20, "PF");
		System.out.println(aluno.toString());

		Edital edital = new Edital("PF", "29/04/2023", "29/05/2023", "Brasilia", 5.356f, 20, true);
		System.out.println(edital.toString());

		Exatas qExatas = new Exatas("Multipla escolha", "Joao tinha 3 maças, vendeu 2. Quantas maças João tinha ? ",
				"A)2 B)1 C)3", null, 3);
		System.out.println(qExatas.toString());

		Humanas qHumanas = new Humanas("Dissertativa", "O que foi a revolução industrial ?", null, "Movimento operario",
				null);
		System.out.println(qHumanas.toString());

		ArrayList<Questao> questoes = new ArrayList<>();
		questoes.add(qHumanas);
		questoes.add(qExatas);

		Prova prova = new Prova("12:00", "18:00", questoes);

		System.out.println(prova.toString());
	}
}
