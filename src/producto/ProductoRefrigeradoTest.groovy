package producto

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail
import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

class ProductoRefrigeradoTest extends GroovyTestCase {
    private static ProductoRefrigerado productoRefrigerado = new ProductoRefrigerado("productoRefrigerado");

    private static void log(String str) {
        System.out.println(str);
    }

    @Test
    static void testSetFechaCaducidad() {
        log("\nProbando setSetFechaCaducidad\n");
        shouldFail {
            productoRefrigerado.setFechaCaducidad("2017-10-28")
        }

        shouldFail {
            productoRefrigerado.setFechaCaducidad("AB");
        }

        productoRefrigerado.setFechaCaducidad("2017-12-28");
        assertThat(productoRefrigerado.getFechaCaducidad(), is("2017-12-28"));
    }

    @Test
    static void testSetPrecio() {
        log("\nProbando setPrecio\n");
        shouldFail {
            productoRefrigerado.setPrecio("ABC")
        }

        productoRefrigerado.setPrecio("22");
        assertThat(productoRefrigerado.getPrecio(), is((double) 22));

        productoRefrigerado.setPrecio(33);
        assertThat(productoRefrigerado.getPrecio(), is((double) 33));

        productoRefrigerado.setPrecio((double) 45.5);
        assertThat(productoRefrigerado.getPrecio(), is((double) 45.5));

    }

    public static void main() {
        log("\nCORRIENDO PRUEBAS ProductoRefrigeradoTest \n");
        testSetFechaCaducidad();
        testSetPrecio();
    }
}
