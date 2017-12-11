import producto.*;

import java.text.ParseException;

public class productos {
    /**
     * log: Wrapper de la funcion System.out.print
     * @param str para imprimir
     */
    private static void log(String str) {
        System.out.println(str);
    }
    public static void main(String[] args) throws ProductException, ParseException {
        producto[] caja = new producto[3];

        ProductoCongelado pollo = new ProductoCongelado("Pollo");
        ProductoFresco manzana = new ProductoFresco("Manzana");
        ProductoRefrigerado huevo = new ProductoRefrigerado("Huevo");


        try {
            pollo.setPrecio("19");
            pollo.setFechaCaducidad("2017-12-28");
            pollo.setTempCongelacionRecomendada(-12);
            caja[0] = pollo;
        } catch (Exception e) {
            log("Error al tratar de cargar "+ pollo.getNombre() + ": " + e.getMessage());
        }

        try {
            manzana.setPrecio(22.50);
            manzana.setFechaCaducidad("2017-12-15");
            manzana.setFechaEnvasado("2017-11-15");
            manzana.setPaisOrigen("México");
            caja[1] = manzana;
        } catch (Exception e) {
            log("Error al tratar de cargar "+ manzana.getNombre() + ": " + e.getMessage());
        }

        try {
            huevo.setPrecio("22");
            huevo.setFechaCaducidad("2017-12-28");
            huevo.setCodigoOrganismoSupAlim("SAGARPA");
            caja[2] = huevo;
        } catch (Exception e) {
            log("Error al tratar de cargar "+ huevo.getNombre() + ": " + e.getMessage());
        }


        for (int i = 0; i < caja.length; i++) {
            try {
                producto producto = caja[i];
                producto.comprar();
                log("Cuesta: "  + producto.getPrecio());
                log("Caduca en: "  + producto.getFechaCaducidad());
                log("Con número de lote: "  + producto.getNumeroLote());
                producto.informacionDeProducto();
                producto.vender();
                log("\n");
            } catch (Exception e) {}

        }
        ProductoFrescoTest.main();
        ProductoCongeladoTest.main();
        ProductoRefrigeradoTest.main();
    }
}
