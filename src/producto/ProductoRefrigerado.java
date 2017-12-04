package producto;

/**
 * Subclase o clase hijo
 */
public class ProductoRefrigerado extends producto {

	/**
	 * Código del organismo supervisor de éste producto
	 */
	private String codigoOrganismoSupAlim;

	/**
	 * Getter de la propiedad codigoOrganismoSupAlim
	 * @return codigoOrganismoSupAlim
	 */
	public String getCodigoOrganismoSupAlim() {
		return codigoOrganismoSupAlim;
	}

	/**
	 * Setter de la propiedad codigoOrganismoSupAlim
	 * @param codigoOrganismoSupAlim
	 */
	public void setCodigoOrganismoSupAlim(String codigoOrganismoSupAlim) {
		this.codigoOrganismoSupAlim = codigoOrganismoSupAlim;
	}

	/**
	 * Implementación del método abstracto comprar
	 */
	@Override
	public void comprar(){
		log("Compra un producto refrigerado: 1 " + this.nombre + " en $" + this.precio);
	}

	/**
	 * Implementación del método abstracto vender
	 */
	@Override
	public void vender(){
		log("Vende un producto refrigerado: 1 " + this.nombre + " en $" + this.precio);
	}

	/**
	 * Implementación del método abstracto informacionDeProducto
	 */
	@Override
	public void informacionDeProducto() {

		log("Organismo Supervisor Alimenticio: " + this.codigoOrganismoSupAlim );

	}

	/**
	 * Default constructor
	 */
	public ProductoRefrigerado(String pNombre) {
		super(pNombre);
	}



}