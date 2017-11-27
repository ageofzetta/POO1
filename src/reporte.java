import java.util.*;

class campaign {
    public float costoPorImpresion;
    public float valorConversion;

    public int clicks;
    public int impresiones;
    public int conversiones;

    /**
     * constructor
     */
    campaign(float CPI, float VC, int pimpresiones, int pclicks, int pconversiones) {
        costoPorImpresion = CPI; valorConversion = VC; clicks = pclicks;
        impresiones = pimpresiones; conversiones = pconversiones;
    }
}
public class reporte {

    public static campaign[] campanas = new campaign[0];
    public static campaign[] campanasAnterior = new campaign[0];

    private static float obtenerCostoMensual(float costoPorImpresion, int impresiones) {
        float costoMensual = costoPorImpresion * (float)impresiones;
        return costoMensual;
    }

    /**
     * Costo Diario Promedio:
     * Es el promedio del gasto diario de los anuncios
     * se calcula dividiendo el costoMensual entre 30
     */
    private static float obtenerCostoDiarioPromedio(float costoMensual) {
        float costoDiarioPromedio = costoMensual / (float) 30;
        return costoDiarioPromedio;
    }

    /**
     * Click trough rate
     * Es el porcentaje de impresiones que provocan un click
     * Se calcula dividiendo los clicks entre las impresiones
     * y multiplicándo el resultado por 100
     */
    private static float obtenerCTR(int clicks, int impresiones) {
        float CTR = ((float)clicks / (float)impresiones) * 100;
        return CTR;
    }

    /**
     * Porcentaje de Conversión
     * Es el porcentaje de impresiones que terminan en una venta
     * Se calcula dividiendo las conversiones entre las impresiones
     * y multiplicándo el resultado por 100
     */
    private static float obtenerPorcentajeDeConversion(int conversiones, int impresiones) {
        float porcentajeDeConversion = ((float)conversiones / (float)impresiones ) * 100;
        return porcentajeDeConversion;
    }

    /**
     * Costo Promedio de Conversión
     * Es el costo promedio de las conversiones.
     * Se calcula dividiendo el costo total de la campaña en un mes
     * y se divide entre el número de conversiones.
     */
    private static float obtenerCostoPromedioConversion(float costoMensual, int conversiones) {
        float costoPromedioConversion = (float)costoMensual / (float)conversiones;
        return costoPromedioConversion;
    }

    /**
     * Retorno de Inversión
     * Es la comparación entre el valor de las conversiones producidas por la campaña de publicidad y el costo de la campaña.
     * Se calcula dividiendo el valor de las conversiones entre el costo mensual.
     */
    private static float obtenerROI(float costoMensual, int conversiones, float valorConversion) {
        float ROI = ((float) conversiones * valorConversion ) / costoMensual;
        return ROI;
    }

    /**
     * Campaña Fallida:
     * Indica si una campaña fue fallida.
     * Se calcula tomando el número de conversiones y se multiplica por el valor de las conversiones
     * A ése cálculo se le resta el costo mensual y se evalua si el residuo es mayor a 0.
     * Para finalizar se niega la evaluación.
     */

    private static boolean campFallida(float costoMensual, int conversiones, float valorConversion) {
        boolean campFallida = ! ( ( (conversiones * valorConversion) - costoMensual ) > 0 );
        return campFallida;
    }
    /**
     * log: Wrapper de la funcion System.out.print
     * @param str para imprimir
     */
    private static void log(String str) {
        System.out.println(str);
    }

    public static void iniciarReporte(campaign campana){

        log("\n----- INICIANDO REPORTE -----");

        float costoMensual = obtenerCostoMensual(campana.costoPorImpresion, campana.impresiones);
        float costoDiarioPromedio = obtenerCostoDiarioPromedio(costoMensual);
        float CTR = obtenerCTR(campana.clicks, campana.impresiones);
        float porcentajeDeConversion = obtenerPorcentajeDeConversion(campana.conversiones, campana.impresiones);
        float costoPromedioConversion =obtenerCostoPromedioConversion(costoMensual, campana.conversiones);
        float ROI = obtenerROI(costoMensual, campana.conversiones, campana.valorConversion);
        boolean campFallida = campFallida(costoMensual, campana.conversiones, campana.valorConversion);


        log("\nValor de la conversión:");
        log("" + campana.valorConversion);

        log(" \nCosto mensual:");
        log("" + costoMensual);

        log("\nClicks");
        log("" + campana.clicks);

        log("\nImpresiones");
        log("" + campana.impresiones);

        log("\nConversiones");
        log("" + campana.conversiones);

        log("\nCosto por I:");
        log("" + campana.costoPorImpresion);


        log("\nCosto diario promedio:");
        log("" + costoDiarioPromedio);

        log("\nCosto promedio por conversión");
        log("" +  String.format("%.2f", costoPromedioConversion));

        log("\nCTR");
        log("" +  String.format("%.2f", CTR));

        log("\nPorcentaje de Conversión");
        log("" +  String.format("%.2f", porcentajeDeConversion));

        log("\nCampaña fallida ?");
        log("" + campFallida);

        log("\n----- TERMINA REPORTE -----");

        sacarPrimeraCampana();

    }

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
    public static void main(String[] args) {

        crearNcampanas(20);
        while(campanas.length >= 1 ) {
            iniciarReporte(campanas[0]);
            log("\n Campañas: " + campanas.length);
        }


    }
}
