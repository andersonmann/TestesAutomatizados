package testesAutomatizados;

public class Teste {

	public static void main(String[] args) {
		// cenario: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao"); //
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));

		// executando a a��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a sa�da com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 250;

		// exibindo a sa�da
		System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
		System.out.println(menorEsperado == leiloeiro.getMenorLance());

	}
}
