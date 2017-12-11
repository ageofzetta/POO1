package producto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Subclase o clase hijo
 */
public class ProductoFresco extends producto {

	/**
	 * Fecha de envasado del producto
	 */
	private Date fechaEnvasado;

	/**
	 * País de orígen del producto
	 */
	private String paisOrigen;

	/**
	 * Getter de la propiedad fechaEnvasado
	 * @return fechaEnvasado
	 */
	public String getFechaEnvasado() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(this.fechaEnvasado);
	}

	/**
	 * Setter de la propiedad fechaEnvasado
	 * @param fechaEnvasado
	 */
	public void setFechaEnvasado(String fechaEnvasado) throws ProductException, ParseException {
		try {
			Date fechaEnvasadoFECHA = convertStringToDate(fechaEnvasado);
			if(fechaEnvasadoFECHA.after(this.fechaActual())) {
				throw new ProductException("La fecha de envasado es inválida\n");
			} else {
				this.fechaEnvasado = fechaEnvasadoFECHA;
			}
		} catch (ParseException e) {
			throw new ProductException("La fecha de envasado es inválida\n");
		}
	}
	/**
	 * Getter de la propiedad paisOrigen
	 * @return paisOrigen
	 */
	public String getPaisOrigen() {
		return paisOrigen;
	}

	/**
	 * Setter de la propiedad paisOrigen
	 * @param paisOrigen
	 */
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	/**
	 * Implementación del método abstracto comprar
	 */
	@Override
	public void comprar(){
		log("Compra un producto fresco: 1 " + this.nombre + " en $" + this.precio);
	}

	/**
	 * Implementación del método abstracto vender
	 */
	@Override
	public void vender(){
		log("Vende un producto fresco: 1 " + this.nombre + " en $" + this.precio);
	}

	/**
	 * Implementación del método abstracto informacionDeProducto
	 */
	@Override
	public void informacionDeProducto() {
		log("Fecha envasado " + this.getFechaEnvasado() );
		log("País de orígen " + this.paisOrigen);
	}

	/**
	 * Default constructor
	 */
	public ProductoFresco( String pNombre) {
		super(pNombre);
	}
}