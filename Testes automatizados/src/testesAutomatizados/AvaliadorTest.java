package testesAutomatizados;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals; 

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AvaliadorTest {

	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;

	@Before
	// novo método que cria o avaliador e usuarios
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario("João");
		this.jose = new Usuario("José");
		this.maria = new Usuario("Maria");

	}

	@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").constroi();
		leiloeiro.avalia(leilao);
		Assert.fail();
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 250).lance(jose, 300)
				.lance(maria, 400).constroi();
		
		leiloeiro.avalia(leilao);
		
		//assertThat(leiloeiro.getMenorLance(), equalTo(250.0)); 
		//assertThat(leiloeiro.getMaiorLance(), equalTo(400.0));



	}

	/*
	 * @Test public void deveEntenderLancesEmOrdemCrescente() { Leilao leilao = new
	 * Leilao("Playstation 3 Novo");
	 * 
	 * leilao.propoe(new Lance(maria, 250.0)); leilao.propoe(new Lance(joao,
	 * 300.0)); leilao.propoe(new Lance(jose, 400.0));
	 * 
	 * // parte 2: ação leiloeiro.avalia(leilao);
	 * 
	 * // comparando a saída com o esperado double maiorEsperado = 400; double
	 * menorEsperado = 250;
	 * 
	 * // parte 3: validacão assertEquals(400.0, leiloeiro.getMaiorLance(),
	 * 0.00001); assertEquals(250.0, leiloeiro.getMenorLance(), 0.00001);
	 * 
	 * }
	 */

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(joao, 1000.0));

		leiloeiro.avalia(leilao);

		assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescenteComOutrosValores() {

		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria, 1000.0));
		leilao.propoe(new Lance(joao, 2000.0));
		leilao.propoe(new Lance(jose, 3000.0));

		leiloeiro.avalia(leilao);

		assertEquals(3000, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
		
	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 100.0).lance(maria, 200.0)
				.lance(joao, 300.0).lance(maria, 400.0).constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(300, maiores.get(1).getValor(), 0.00001);
		assertEquals(200, maiores.get(2).getValor(), 0.00001);

	}

}
