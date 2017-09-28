package testesAutomatizados;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AvaliadorTest {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

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
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescenteComOutrosValores() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 1000.0));
		leilao.propoe(new Lance(joao, 2000.0));
		leilao.propoe(new Lance(jose, 3000.0));
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(3000, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);

	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Usuario joao = new Usuario("Joao");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(joao, 1000.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Usuario joao = new Usuario("Jo�o");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(300, maiores.get(1).getValor(), 0.00001);
		assertEquals(200, maiores.get(2).getValor(), 0.00001);

	}

}