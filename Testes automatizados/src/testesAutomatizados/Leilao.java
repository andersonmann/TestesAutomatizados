/**
 * 
 */
package testesAutomatizados;

import java.util.ArrayList;
import java.util.List;

/**
 * @author am55053
 *
 */
public class Leilao {
	private String nome;
	private List<Lance> lances = new ArrayList<>();

	public Leilao(String nome) {
		super();
		this.setNome(nome);
	}

	public void propoe(Lance lance) {
		lances.add(lance);

	}

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Leilao [nome=" + nome + "]";
	}

}
