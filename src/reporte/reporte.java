package reporte;

abstract class reporte {
    abstract void iniciarReporte(campaign campana);
    abstract float obtenerCostoMensual(campaign campana);
    abstract boolean campFallida(float costoMensual, campaign campana);
    abstract float obtenerROI(float costoMensual, campaign campana);
}