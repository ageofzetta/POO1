import java.util.Scanner;

public class reconstruccion {

    // Tasas de conversión de divisas
    private static final float usdMxn = 17.95F;
    private static final float euroMxn = 20.74F;

    // Distribución de donaciones
    private static final float porcentajeParaAulas = 0.35F;
    private static final float porcentajeParaComputo = 0.30F;
    private static final float porcentajeParaMedios = 0.25F;

    private static float dineroDonadoEnPesos = 0F;
    private static float donacionTotalEnPesos = 0F;

    /**
     * log: Wrapper de la funcion System.out.print
     * @param str para imprimir
     */
    private static void log(String str) {
        System.out.println(str);
    }

    /**
     * realizarDonacion PASA PARÁMETROS A OTRA FUNCIÓN
     * permite al usuario ingresar el monto y la divisa de su donación,
     * Éste método no recibe parámetros, invoca el método recibirDonaciones y le pasa los parámetros monto y divisa
     * @return
     */
    public static boolean realizarDonacion() {

        log("Ingrese la divisa en la que realizará su donación \"USD\" ó \"EURO\" (sin comillas):" );
        Scanner sc = new Scanner(System.in);
        String divisa = sc.nextLine();

        if (!divisa.toLowerCase().equals("usd") && !divisa.toLowerCase().equals("euro")) {
            log("Esa no es una divisa válida");
            realizarDonacion();
            return false;
        }

        log("Ingrese el monto que desea donar (sólo puede contener números y un punto decimal):" );
        Scanner sc2 = new Scanner(System.in);
        float monto = sc.nextFloat();
        recibirDonaciones(monto, divisa);
        return true;
    }

    /**
     * recibirDonaciones: recibe las donaciones que realiza el usuario, RECIBE PARÄMETROS, PASA PARÁMETROS A OTRA FUNCIÓN
     * recibe parámetros monto (float) y divisa (string)
     * invoca convertirDivisas y le pasa los parámetros monto y divisa
     * invoca distribuirRecursos
     * @param monto float
     * @param divisa string "USD" || "EURO"
     */
    public static void recibirDonaciones(float monto, String divisa) {

        // Primero convertimos la donación de una divisa a pesos
        float donacionEnPesos = convertirDivisas(monto, divisa);
        log("Su donación equivale a $" + donacionEnPesos + " pesos mexicanos");

        // Asígnamos entonces el resultado la variable dineroDonadoenPesos
        dineroDonadoEnPesos = donacionEnPesos;

        // Incrementamos el valor de donacionTotalEnPesos con la variable donacionEnPesos
        donacionTotalEnPesos += donacionEnPesos;

        log("Su donación se distribuirá de la siguiente forma");
        distribuirRecursos(dineroDonadoEnPesos);

        log("Se han recaudado en total: $" + donacionTotalEnPesos + " pesos mexicanos");
        log("Y se han distribuido de la siguiente forma:");
        distribuirRecursos(donacionTotalEnPesos);

        iniciarConversacion("otra");

    }

    /**
     * convertirDivisas: convierte una cantidad a pesos REGRESA UN VALOR, RECIBE PARÁMETROS
     * Recibe parámetros monto (el monto de la donación) y divisa ( la divisa en la que se realiza la donación)
     * regresa el monto de la donación en pesos
     * @param monto float
     * @param divisa string
     * @return el monto de la donación en pesos
     */
    private static float convertirDivisas(float monto, String divisa) {
        float paridad = (divisa.toLowerCase().equals("usd")) ? usdMxn : euroMxn;
        return ( monto * paridad);
    }

    /**
     * distribuirRecursos: RECIBE PARÁMETROS,
     * cálcula los montos para cada rubro y los imprime en pantalla , recibe como parámetro el monto de la donación
     * @param monto
     */
    private static void distribuirRecursos(float monto) {
        float montoParaAulas = monto * porcentajeParaAulas;
        float montoParaComputo = monto * porcentajeParaComputo;
        float montoParaMedios = monto * porcentajeParaMedios;

        log("$" + montoParaAulas + " pesos mexicanos para la reconstrucción de aulas" );
        log("$" + montoParaComputo + " pesos mexicanos para la reconstrucción de la sala de cómputo");
        log("$" + montoParaMedios + " pesos mexicanos para la reconstrucción de la sala de medios");
    }

    /**
     * iniciarConversacion: RECIBE PARÁMETROS, REGRESA UN VALOR, PASA PARÁMETROS A OTRA FUNCIÓN
     * inicia una conversación en la terminal / pantalla cono lo que inicia el programa de donaciones
     * regresa un booleano para interrumpir la ejecución.
     *
     * @param text
     * @return
     */
    public static boolean iniciarConversacion(String text) {
        log("Desea realizar " + text +" donación? (responda \"si\" o \"no\":");
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.nextLine();

        if (respuesta.toLowerCase().equals("si")) {
            log("Gracias por donar para la reconstrucción de la escuela primaria Benito Juárez García" );
            realizarDonacion();
            return true;
        } else if (respuesta.toLowerCase().equals("no")) {
            log("¡Hasta luego!");
        } else {
            log("Esa no es una respuesta válida!");
            iniciarConversacion(text);
        }
        return false;
    }
    public static void main(String[] args) {
        iniciarConversacion("una");
    }


}
