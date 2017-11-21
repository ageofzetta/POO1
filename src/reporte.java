public class reporte {

    private static float costoPorImpresion = 0.1F;
    private static float valorConversion = 112.5F;

    private static int clicks = 256;
    private static int impresiones = 3259;
    private static int conversiones = 19;

    private static float costoMensual = costoPorImpresion * (float)impresiones;

    /**
     * Costo Diario Promedio:
     * Es el promedio del gasto diario de los anuncios
     * se calcula dividiendo el costoMensual entre 30
     */
    public static float costoDiarioPromedio = (float)costoMensual / 30;

    /**
     * Click trough rate
     * Es el porcentaje de impresiones que provocan un click
     * Se calcula dividiendo los clicks entre las impresiones
     * y multiplicándo el resultado por 100
     */
    public static float CTR = ((float)clicks / (float)impresiones) * 100;

    /**
     * Porcentaje de Conversión
     * Es el porcentaje de impresiones que terminan en una venta
     * Se calcula dividiendo las conversiones entre las impresiones
     * y multiplicándo el resultado por 100
     */
    public static float porcentajeDeConversion = ((float)conversiones / (float)impresiones ) * 100;

    /**
     * Costo Promedio de Conversión
     * Es el costo promedio de las conversiones.
     * Se calcula dividiendo el costo total de la campaña en un mes
     * y se divide entre el número de conversiones.
     */
    public static float costoPromedioConversion = (float)costoMensual / (float)conversiones;

    /**
     * Retorno de Inversión
     * Es la comparación entre el valor de las conversiones producidas por la campaña de publicidad y el costo de la campaña.
     * Se calcula dividiendo el valor de las conversiones entre el costo mensual.
     */
    public static float ROI = (conversiones * valorConversion ) / costoMensual;

    /**
     * Campaña Fallida:
     * Indica si una campaña fue fallida.
     * Se calcula tomando el número de conversiones y se multiplica por el valor de las conversiones
     * A ése cálculo se le resta el costo mensual y se evalua si el residuo es mayor a 0.
     * Para finalizar se niega la evaluación.
     */
    public static boolean campFallida = ! ( ( (conversiones * valorConversion) - costoMensual ) > 0 );

    /**
     * log: Wrapper de la funcion System.out.print
     * @param str para imprimir
     */
    private static void log(String str) {
        System.out.println(str);
    }


    public static void main(String[] args) {
        log("\nValor de la conversión:");
        log("" + valorConversion);

        log(" \nCosto mensual:");
        log("" + costoMensual);

        log("\nClicks");
        log("" + clicks);

        log("\nImpresiones");
        log("" + impresiones);

        log("\nConversiones");
        log("" + conversiones);

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
    }
}
