/**
 * 
 */
package testesAutomatizados;

/**
 * @author am55053
 *
 */
public class Avaliador {
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.NEGATIVE_INFINITY;

	public void avalia(Leilao leilao) {
		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			} else if (lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}

		}
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return maiorDeTodos;
	}

}
