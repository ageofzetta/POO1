package producto

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail
import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

class ProductoCongeladoTest extends GroovyTestCase {
    private static ProductoCongelado productoCongelado = new ProductoCongelado("productoCongelado");

    private static void log(String str) {
        System.out.println(str);
    }

    @Test
    static void testSetTempCongelacionRecomendada() {
        log("\nProbando setTempCongelacionRecomendada\n");
        shouldFail {
            productoCongelado.setTempCongelacionRecomendada(20);
        }
        productoCongelado.setTempCongelacionRecomendada(-20);
        assertThat(productoCongelado.getTempCongelacionRecomendada(), is(-20));
    }

    @Test
    static void testSetFechaCaducidad() {
        log("\nProbando setSetFechaCaducidad\n");
        shouldFail {
            productoCongelado.setFechaCaducidad("2017-10-28")
        }

        shouldFail {
            productoCongelado.setFechaCaducidad("AB");
        }

        productoCongelado.setFechaCaducidad("2017-12-28");
        assertThat(productoCongelado.getFechaCaducidad(), is("2017-12-28"));
    }

    @Test
    static void testSetPrecio() {
        log("\nProbando setPrecio\n");
        shouldFail {
            productoCongelado.setPrecio("ABC")
        }

        productoCongelado.setPrecio("22");
        assertThat(productoCongelado.getPrecio(), is((double) 22));

        productoCongelado.setPrecio(33);
        assertThat(productoCongelado.getPrecio(), is((double) 33));

        productoCongelado.setPrecio((double) 45.5);
        assertThat(productoCongelado.getPrecio(), is((double) 45.5));

    }

    public static void main() {
        log("\nCORRIENDO PRUEBAS ProductoCongeladoTest \n");
        testSetTempCongelacionRecomendada();
        testSetFechaCaducidad();
        testSetPrecio();
    }
}
