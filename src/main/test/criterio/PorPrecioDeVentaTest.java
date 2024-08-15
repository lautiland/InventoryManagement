package criterio;

import Model.Categoria;
import Model.criterio.PorPrecioDeVenta;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PorPrecioDeVentaTest {

    @Test
    public void test01PorPrecioDeVentaSeCreaCorrectamente(){
        PorPrecioDeVenta porPrecioDeVenta = new PorPrecioDeVenta();
        assertNotNull(porPrecioDeVenta);
    }

    @Test
    public void test02PorPrecioDeVentaOrdenaCorrectamente(){
        PorPrecioDeVenta porPrecioDeVenta = new PorPrecioDeVenta();
        Categoria categoria = new Categoria("Categoria", 0);
        Producto producto1 = new Producto("ProductoA", 11, 5);
        Producto producto2 = new Producto("ProductoC", 22, 5);
        Producto producto3 = new Producto("ProductoB", 3, 5);
        producto1.setPrecioDeVenta(0, 10);
        producto2.setPrecioDeVenta(0, 30);
        producto3.setPrecioDeVenta(0, 20);
        categoria.agregarIdentificable(producto1);
        categoria.agregarIdentificable(producto2);
        categoria.agregarIdentificable(producto3);

        assertEquals(producto1, porPrecioDeVenta.sort(categoria).get(0));
        assertEquals(producto2, porPrecioDeVenta.sort(categoria).get(2));
        assertEquals(producto3, porPrecioDeVenta.sort(categoria).get(1));
    }
}
