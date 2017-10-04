/**
 * 
 */
package testesAutomatizados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author am55053
 *
 */
public class Leilao {
	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();

	}

	public void propoe(Lance lance) {
		lances.add(lance);

	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Leilao [descricao =" + descricao + "]";
	}

}
