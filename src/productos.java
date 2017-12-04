import producto.*;

public class productos {
    /**
     * log: Wrapper de la funcion System.out.print
     * @param str para imprimir
     */
    private static void log(String str) {
        System.out.println(str);
    }
    public static void main(String[] args) {
        producto[] caja = new producto[3];
        ProductoCongelado pollo = new ProductoCongelado("Pollo");
        pollo.setPrecio("19");
        pollo.setFechaCaducidad("2017-12-28");
        pollo.setTempCongelacionRecomendada(-12);

        ProductoFresco manzana = new ProductoFresco("Manzana");
        manzana.setPrecio(22.50);
        manzana.setFechaCaducidad("2017-12-15");
        manzana.setFechaEnvasado("2017-11-15");
        manzana.setPaisOrigen("México");

        ProductoRefrigerado huevo = new ProductoRefrigerado("Huevo");
        huevo.setPrecio("19");
        huevo.setFechaCaducidad("2017-12-28");
        huevo.setCodigoOrganismoSupAlim("SAGARPA");

        caja[0] = pollo;
        caja[1] = manzana;
        caja[2] = huevo;

        for (int i = 0; i < caja.length; i++) {
            producto producto = caja[i];
            producto.comprar();
            log("cuesta: "  + producto.getPrecio());
            log("caduca en: "  + producto.getFechaCaducidad());
            log("tiene el número de lote: "  + producto.getNumeroLote());
            producto.informacionDeProducto();
            producto.vender();
            log("\n");
        }
    }
}
