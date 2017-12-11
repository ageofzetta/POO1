package producto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Superclase o clase padre producto
 */
public abstract class producto {

    /**
     * fechaActual
     */
    protected Date fechaActual() {
         return new Date();
    }

    /**
     * inicioContador: es una constante, define un núkero apartir del cuál empezamos a contar para el número de lote
     */
    private static final int inicioContador = 1000;
    /**
     * contador: se inicializa con inicioContador y almacena el último número usado como número de lote
     */
    private static int contador = inicioContador;

    /**
     * número de lote
     */
    protected int numeroLote;

    /**
     * Fecha de caducidad
     */
    protected Date fechaCaducidad;

    /**
     * Nombre del producto
     */
    protected String nombre;

    /**
     * Precio del producto
     */
    protected double precio;

    /**
     * log: Wrapper de la funcion System.out.print
     * @param str para imprimir
     */
    public static void log(String str) {
        System.out.println(str);
    }


    public Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse ( dateString );
        return date;
    }

    /**
     * Getter de la propiedad nombre.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter de la propiedad nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la propiedad precio
     * @return precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Setter de la propiedad precio
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Otro setter de la propiedad precio,  SOBRECARGA AQUI
     * en éste caso acepta un entero
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = (double) precio;
    }

    /**
     * Otro setter de la propiedad precio,  SOBRECARGA AQUI
     * en éste caso acepta un string
     * @param precio
     */
    public void setPrecio(String precio) throws NumberFormatException, ProductException{
        try {
            this.precio = Double.parseDouble(precio);
        } catch (Exception e) {
            throw new ProductException("El precio es inválido");
        }
    }

    /**
     * Getter de la propiedad fechaCaducidad
     * @return fechaCaducidad
     */
    public String getFechaCaducidad() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(this.fechaCaducidad);
    }

    /**
     * Setter de la propiedad fechaCaducidad
     * @param fechaCaducidad
     */
    public void setFechaCaducidad(String fechaCaducidad) throws ProductException, ParseException {
        try {
            Date fechaCaducidadFECHA = convertStringToDate(fechaCaducidad);
            if(fechaCaducidadFECHA.before(this.fechaActual())) {
                throw new ProductException("La fecha de caducidad para éste producto ya pasó");
            } else {
                this.fechaCaducidad = fechaCaducidadFECHA;
            }
        } catch (ParseException e) {
            throw new ProductException("La fecha de caducidad es inválida");
        }
    }

    /**
     * Getter de la propiedad numeroLote
     * @return numeroLote
     */
    public final int getNumeroLote() {
        return this.numeroLote;
    }

    /**
     * Setter de la propiedad numeroLote
     */
    public final void setNumeroLote(int numero) {
        this.numeroLote = numero;
    }

    /** MÉTODO ABSTRACTO comprar
     */
    public abstract void comprar();

    /** MÉTODO ABSTRACTO vender
     */
    public abstract void vender();

    /** MÉTODO ABSTRACTO informacionDeProducto
     */
    public abstract void informacionDeProducto();

    /**
     * Constructor
     * @param pNombre
     */
    public producto(String pNombre) {
        this.contador++;
        this.setNumeroLote(this.contador);
        this.setNombre(pNombre);
    }

}