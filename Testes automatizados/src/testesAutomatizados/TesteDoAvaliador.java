/**
 * 
 */
package testesAutomatizados;

/**
 * @author am55053
 *
 */
public class TesteDoAvaliador {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));
		

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// imprime 400.0
		System.out.println(leiloeiro.getMaiorLance());		
		// imprime 
		System.out.println(leiloeiro.getMenorLance());
		
		System.out.println("Quantidade de lances: " + leilao.getLances().size());
		
	}

}
