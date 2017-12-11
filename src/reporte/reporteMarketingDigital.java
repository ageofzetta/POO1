package reporte;


public class reporteMarketingDigital extends reporte {

    /**
     * IMPLEMENTACIÓN DE MÉTODO ABSTRACTO
     * Regresa el costo total de la campaña para un mes,
     * se obtiene multiplicando las impresiones por el costo por impresión
     * @param campana
     * @return
     */
    protected float obtenerCostoMensual(campaign campana) {
        float costoMensual = campana.costoPorImpresion * (float) campana.impresiones + 99F;
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
     * IMPLEMENTACIÓN DE MÉTODO ABSTRACTO
     * Retorno de Inversión
     * Es la comparación entre el valor de las conversiones producidas por la campaña de publicidad y el costo de la campaña.
     * Se calcula dividiendo el valor de las conversiones entre el costo mensual.
     */
    protected float obtenerROI(float costoMensual, campaign campana) {
        float ROI = ((float) campana.conversiones * (float) campana.valorConversion) / costoMensual;
        return ROI;
    }

    /**
     * IMPLEMENTACIÓN DE MÉTODO ABSTRACTO
     * Campaña Fallida:
     * Indica si una campaña fue fallida.
     * Se calcula tomando el número de conversiones y se multiplica por el valor de las conversiones
     * A ése cálculo se le resta el costo mensual y se evalua si el residuo es mayor a 0.
     * Para finalizar se niega la evaluación.
     */

    protected boolean campFallida(float costoMensual, campaign campana) {
        boolean campFallida = ! ( ( ((float) campana.conversiones * (float) campana.valorConversion) - costoMensual ) > 0 );
        return campFallida;
    }
    /**
     * log: Wrapper de la funcion System.out.print
     * @param str para imprimir
     */
    private static void log(String str) {
        System.out.println(str);
    }

    /**
     * IMPLEMENTACIÓN DE MÉTODO ABSTRACTO
     * Éste método inicia la impresión del reporte en pantalla
     * @param campana
     */
    @Override
    public void iniciarReporte(campaign campana){

        log("\n----- INICIANDO REPORTE -----");

        float costoMensual = obtenerCostoMensual(campana);
        float costoDiarioPromedio = obtenerCostoDiarioPromedio(costoMensual);
        float CTR = obtenerCTR(campana.clicks, campana.impresiones);
        float porcentajeDeConversion = obtenerPorcentajeDeConversion(campana.conversiones, campana.impresiones);
        float costoPromedioConversion =obtenerCostoPromedioConversion(costoMensual, campana.conversiones);
        float ROI = obtenerROI(costoMensual, campana);
        boolean campFallida = campFallida(costoMensual, campana);


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

    }

}