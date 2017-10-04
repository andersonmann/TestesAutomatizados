/**
 * 
 */
package testesAutomatizados;

/**
 * @author am55053
 *
 */
public class Lance {
	private int numero;
	private Usuario usuario;
	private double valor;

	/**
	 * @param usuario
	 * @param valor
	 */
	public Lance(Usuario usuario, double valor) {
		super();
		this.usuario = usuario;
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUsuario() {

		return usuario.getNome();
	}

}
