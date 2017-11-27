import java.util.Arrays;
import java.util.Scanner;

public class calculadora {

    private static final int cantidadDeEnteros = 20;

    /**
     * log: Wrapper de la funcion System.out.print
     * @param str para imprimir
     */
    private static void log(String str) {
        System.out.println(str);
    }

    /**
     * ordenarNumeros: RECIBE PARÁMETROS Y REGRESA UN VALOR,
     * recibe un arreglo de enteros desordenado y lo ordena y al final lo retorna
     * @param listaDeEnteros
     * @return
     */
    public static int[] ordenarNumeros(int[] listaDeEnteros) {
        int[] enteros = listaDeEnteros.clone();
        for (int i = 0; i < enteros.length; i++) {
            for(int j = i ; j > 0 ; j--){
                boolean compare = enteros[j-1] > enteros[j];
                if (compare) {
                    int temp = enteros[j];
                    enteros[j] = enteros[j-1];
                    enteros[j-1] = temp;
                }
            }
        }
        return enteros;
    }

    /**
     * ingresaEnteros, REGRESA UN VALOR
     *  Permite al usuario ingresar numeros de forma consecutiva y los almacena en un arreglo que se redimensiona
     * @return arreglo de enteros
     */
    public static int[] ingresaEnteros() {
        int[] listaNumeros = new int[0];
        int[] listaNumerosAnterior = new int[0];
        Scanner sc = new Scanner(System.in);
        boolean hayNumero = true;
        int respuesta;
        do {
            System.out.println("Ingrese un número para continuar o la palabra \"no\" para terminar: ");
            try {
                respuesta = sc.nextInt();
                Integer numero = new Integer(respuesta);
                listaNumeros = Arrays.copyOf(listaNumerosAnterior, listaNumeros.length + 1);
                listaNumeros[listaNumeros.length - 1] = numero;
                listaNumerosAnterior = Arrays.copyOf(listaNumeros, listaNumeros.length);
            } catch (Exception e) {
                hayNumero = false;
                log("\nTerminando");

            }
        } while (hayNumero);
        return  listaNumeros;
    }

    /**
     * ingresa20Enteros: REGRESA UN VALOR
     * Obliga al usuario a ingresar una X cantidad de enteros, 20 en este caso, esos enteros se van almacenando en un arreglo
     * @return arreglo de enteros
     */
    public static int[] ingresa20Enteros() {
        int[] listaNumeros = new int[cantidadDeEnteros];

        Scanner sc = new Scanner(System.in);
        int respuesta;
        for ( int i = 0; i < cantidadDeEnteros; i++) {
            System.out.println("Ingrese un número hasta sumar 20 (actualmente ha ingresado "+i+" números): ");
            try {
                respuesta = sc.nextInt();
                Integer numero = new Integer(respuesta);
                listaNumeros[i] = numero;
            } catch (Exception e) {
                log("\nÉse es un número inválido.");

            }

        }

        return  listaNumeros;
    }

    /**
     * obtenerMediana: RECIBE PARÁMETROS Y REGRESA UN VALOR,
     *  recibe un arreglo de enteros (se asume que ya estan ordenados) y regresa la mediana de éstos.
     *  como pueden ser varias las regresa en un arreglo.
     * @param numeros
     * @return arreglo
     */
    public static int[] obtenerMediana(int[] numeros) {
        if ((numeros.length % 2) == 0) {
            int mitad = (numeros.length / 2) - 1;
            int[] mediana = { numeros[mitad], numeros[mitad + 1] };
            return mediana;
        } else {
            int indice = (int) Math.ceil( (double) numeros.length / 2 );
            int[] mediana = { numeros[indice] };
            return mediana;
        }
    }
    /**
     * obtenerModa: RECIBE PARÁMETROS Y REGRESA UN VALOR,
     *  recibe un arreglo de enteros (se asume que ya estan ordenados) y regresa la moda de éstos,
     *  como pueden ser varias las regresa en un arreglo.
     * @param numeros
     * @return arreglo
     */
    public static int[] obtenerModa(int[] numeros){
        int[] numerosModa = new int[1];
        int[] numerosModaTemporal= new int[1];
        boolean inR = false;
        boolean touched = false;
        int freq = 0;
        int maxFreq = 0;
        int[] moR = new int[1];
        for ( int i = 1 ; i < numeros.length; i++) {
            int enteroActual = numeros[i];
            int enteroAnterior = numeros[i - 1];
            if (enteroActual == enteroAnterior) {
                inR = true;
                touched = true;
                freq++;

                if (freq > maxFreq) {
                    maxFreq = freq;
                    moR[0] = enteroActual;
                    numerosModa = new int[1];
                    numerosModa[0] = enteroActual;
                } else if (freq == maxFreq) {
                    numerosModaTemporal = Arrays.copyOf(numerosModa, numerosModa.length + 1);
                    for ( int j = 1 ; j < numerosModa.length; j++) {
                        numerosModaTemporal[j] = numerosModa[j];
                    }
                    numerosModaTemporal[numerosModaTemporal.length - 1] = enteroActual;
                    numerosModa = Arrays.copyOf(numerosModaTemporal, numerosModaTemporal.length);
                }
            }  else {
                freq = 0;
                inR = false;
            }
        }
        int[] resultado = (touched) ? numerosModa : new int[0];
        return resultado;
    }

    /**
     * obtenerMedia: RECIBE PARÁMETROS Y REGRESA UN VALOR,
     *  recibe un arreglo de enteros (se asume que ya estan ordenados) y regresa la media de éstos.
     * @param numeros
     * @return int
     */
    public static double obtenerMedia (int[] numeros) {
        int sum = 0;

        for (int i = 0; i < numeros.length; i++) {
            sum += numeros[i];
        }

        double promedio = (double) sum /  (double) numeros.length;

        return promedio;

    }

    public static void main(String[] args) {

        int[] listaNumeros = ingresaEnteros();
        log("Enumerando elementos proporcionados: " + Arrays.toString(listaNumeros));
        int[] listaOrdenada = ordenarNumeros(listaNumeros);
        log("elementos ordenados" + Arrays.toString(listaOrdenada));
        int[] mediana = obtenerMediana(listaOrdenada);
        log("Mediana " + Arrays.toString(mediana));
        int[] moda = obtenerModa(listaOrdenada);
        log("Moda: " + Arrays.toString(moda));
        double media = obtenerMedia(listaOrdenada);
        log("Media: " + media);

        int[] listaNumeros20 = ingresa20Enteros();
        log("Enumerando elementos proporcionados: " + Arrays.toString(listaNumeros20));
        int[] listaOrdenada20 = ordenarNumeros(listaNumeros20);
        log("elementos ordenados" + Arrays.toString(listaOrdenada20));
        int[] mediana20 = obtenerMediana(listaOrdenada20);
        log("Mediana " + Arrays.toString(mediana20));
        int[] moda20 = obtenerModa(listaOrdenada20);
        log("Moda: " + Arrays.toString(moda20));
        double media20 = obtenerMedia(listaOrdenada20);
        log("Media: " + media20);

    }

}

