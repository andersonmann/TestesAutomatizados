/**
 * 
 */
package testesAutomatizados;

/**
 * @author am55053
 *
 */
public class Usuario {
	private String nome;

	/**
	 * @param nome
	 */
	public Usuario(String nome) {
		super();
		this.nome = nome;
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
		return "Usuario [nome=" + nome + "]";
	}

}
