import java.util.*;

import reporte.*;

public class reportes {
    public static reporte.campaign[] campanas = new reporte.campaign[0];
    public static reporte.campaign[] campanasAnterior = new reporte.campaign[0];

    /**
     * agregarCampana: Redimensiona un arreglo de campañas y inserta la campaña que recibe como parámetro al final de ésta
     * @param campana
     */
    public static void agregarCampana(campaign campana) {
        campanas = Arrays.copyOf(campanasAnterior, campanas.length + 1);
        campanas[campanas.length - 1] = campana;
        campanasAnterior = Arrays.copyOf(campanas, campanas.length);
    }

    /**
     * sacarPrimeraCampana: Remueve el primer elemento del arreglo de campañas
     */
    public static void sacarPrimeraCampana() {
        if (campanas.length > 1 && campanasAnterior.length > 1) {
            campaign[] temporal = new campaign[campanas.length - 1];
            System.arraycopy(campanas, 1, temporal, 0, campanas.length - 1);
            campanas = Arrays.copyOf(temporal , temporal.length);
            campanasAnterior = Arrays.copyOf(temporal , temporal.length);
        } else if (campanas.length == 1 && campanasAnterior.length == 1) {
            campanas = new campaign[0];
            campanasAnterior = new campaign[0];
        }
    }

    /**
     * crearNcampanas: crea N campañas con valores randomizados y los agrega al arreglo de campañas
     * @param n
     */
    public static void crearNcampanas(int n) {

        Random randomGenerator = new Random();

        for (int idx = 1; idx <= n; ++idx){
            int impresiones = randomGenerator.nextInt(25000) + 10000;
            int clicks = (int) (impresiones * 0.05);
            int conversiones = (int) (clicks * 0.05);
            float CPI = randomGenerator.nextFloat();
            float VC = randomGenerator.nextFloat() * 10;
            agregarCampana(new campaign(CPI, VC, impresiones, clicks, conversiones));
        }

    }
    /**
     * log: Wrapper de la funcion System.out.print
     * @param str para imprimir
     */
    private static void log(String str) {
        System.out.println(str);
    }
    public static void main(String[] args) {

        reporteMarketingDigital nuevoReporte = new reporteMarketingDigital();
        crearNcampanas(5);
        while(campanas.length >= 1 ) {
            nuevoReporte.iniciarReporte(campanas[0]);
            log("\n Campañas: " + campanas.length);
            sacarPrimeraCampana();
        }
        reporteMarketingDigitalTest.main();
    }
}