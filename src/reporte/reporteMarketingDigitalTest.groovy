package reporte
import org.junit.Before;
import static org.junit.Assert.assertEquals;

class reporteMarketingDigitalTest extends GroovyTestCase {

    Object testReporte, testCampana;


    /**
     * log: Wrapper de la funcion System.out.print
     * @param str para imprimir
     */
    private static void log(String str) {
        System.out.println(str);
    }

    /**
     * Prueba que el cálculo del costo mensual sea correcto
     */
    void testObtenerCostoMensual() {
        log("Probando obtenerCostoMensual()");
        testReporte = new reporteMarketingDigital();
        testCampana = new campaign(0.5F, 12.5F, 30000, 300, 30);
        float costoMensual = testReporte.obtenerCostoMensual(testCampana);
        assertEquals((float) 15000, costoMensual, 0.0001);
    }

    /**
     * Prueba que el cálculo del Retorno de Inversión (ROI) sea correcto
     */
    void testObtenerROI() {
        log("Probando obtenerROI()")
        testReporte = new reporteMarketingDigital();
        testCampana = new campaign(0.5F, 12.5F, 30000, 300, 30);
        float costoMensual = testReporte.obtenerCostoMensual(testCampana);
        float ROI = testReporte.obtenerROI(costoMensual, testCampana);
        assertEquals(ROI, (float) 0.025, 0.0001);
    }

    public static void main() {
        log("\nCORRIENDO PRUEBAS reporteMarketingDigitalTest \n");
    }
}
