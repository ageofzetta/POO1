package producto

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail
import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

class ProductoFrescoTest extends GroovyTestCase {

    private static ProductoFresco productoFresco = new ProductoFresco("productoFresco");

    private static void log(String str) {
        System.out.println(str);
    }

    @Test
    static void testSetFechaEnvasado() {
        log("\nProbando setFechaEnvasado\n");
        shouldFail {
            productoFresco.setFechaEnvasado("2017-12-28");
        }

        shouldFail {
            productoFresco.setFechaEnvasado("AB");
        }

        productoFresco.setFechaEnvasado("2017-11-28");
        assertThat(productoFresco.getFechaEnvasado(), is("2017-10-28"));
    }

    @Test
    static void testSetFechaCaducidad() {
        log("\nProbando setSetFechaCaducidad\n");
        shouldFail {
            productoFresco.setFechaCaducidad("2017-10-28")
        }

        shouldFail {
            productoFresco.setFechaCaducidad("AB");
        }

        productoFresco.setFechaCaducidad("2017-12-28");
        assertThat(productoFresco.getFechaCaducidad(), is("2017-12-28"));
    }

    @Test
    static void testSetPrecio() {
        log("\nProbando setPrecio\n");
        shouldFail {
            productoFresco.setPrecio("ABC")
        }

        productoFresco.setPrecio("22");
        assertThat(productoFresco.getPrecio(), is((double) 22));

        productoFresco.setPrecio(33);
        assertThat(productoFresco.getPrecio(), is((double) 33));

        productoFresco.setPrecio((double) 45.5);
        assertThat(productoFresco.getPrecio(), is((double) 45.5));

    }

    public static void main() {
        log("\nCORRIENDO PRUEBAS ProductoFrescoTest \n");
        testSetFechaEnvasado();
        testSetFechaCaducidad();
        testSetPrecio();
    }
}
