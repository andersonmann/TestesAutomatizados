package testesAutomatizados;

import org.junit.Test;
import org.junit.Assert;

public class AvaliadorTest {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

		// cenario: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao"); //
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));

		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a saída com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 250;

		// exibindo a saída
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescenteComOutrosValores() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 1000.0));
		leilao.propoe(new Lance(joao, 2000.0));
		leilao.propoe(new Lance(jose, 3000.0));
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		Assert.assertEquals(3000, leiloeiro.getMaiorLance(), 0.0001);
		Assert.assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);

	}

}
