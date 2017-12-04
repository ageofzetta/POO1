package producto;

/**
 * Superclase o clase padre producto
 */
public abstract class producto {

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
    protected String fechaCaducidad;

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
    public void setPrecio(String precio) {

        this.precio = Double.parseDouble(precio);
    }

    /**
     * Getter de la propiedad fechaCaducidad
     * @return fechaCaducidad
     */
    public String getFechaCaducidad() {
        return this.fechaCaducidad;
    }

    /**
     * Setter de la propiedad fechaCaducidad
     * @param fechaCaducidad
     */
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
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