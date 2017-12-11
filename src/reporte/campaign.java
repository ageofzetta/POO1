package reporte;

public class campaign {
    float costoPorImpresion;
    float valorConversion;

    int clicks;
    int impresiones;
    int conversiones;

    /**
     * constructor
     */
    public campaign(float CPI, float VC, int pimpresiones, int pclicks, int pconversiones) {
        costoPorImpresion = CPI; valorConversion = VC; clicks = pclicks;
        impresiones = pimpresiones; conversiones = pconversiones;
    }
}