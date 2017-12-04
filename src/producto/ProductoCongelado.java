package producto;

/**
 * Subclase o clase hijo
 */
public class ProductoCongelado extends producto {

	/**
	 * Temperatura de congelación recomendada
	 */
	private int tempCongelacionRecomendada = 0;

	/**
	 * Getter de la propiedad tempCongelacionRecomendada
	 * @return tempCongelacionRecomendada
	 */
	public int getTempCongelacionRecomendada() {
		return tempCongelacionRecomendada;
	}

	/**
	 * Setter de la propiedad tempCongelacionRecomendada
	 * @param tempCongelacionRecomendada
	 */
	public void setTempCongelacionRecomendada(int tempCongelacionRecomendada) {
		this.tempCongelacionRecomendada = tempCongelacionRecomendada;
	}

	/**
	 * Implementación del método abstracto comprar
	 */
	@Override
	public void comprar(){
		log("Compra un producto congelado: 1 " + this.nombre + " en $" + this.precio);
	}

	/**
	 * Implementación del método abstracto vender
	 */
	@Override
	public void vender(){
		log("Vende un producto congelado: 1 " + this.nombre + " en $" + this.precio);
	}

	/**
	 * Implementación del método abstracto informacionDeProducto
	 */
	@Override
	public void informacionDeProducto() {

		log("Temperatura de congelamiento recomendada " + this.tempCongelacionRecomendada );
	}

	/**
	 * Constructor
	 * @param pNombre
	 */
	public ProductoCongelado( String pNombre) {
		super(pNombre);
	}

}