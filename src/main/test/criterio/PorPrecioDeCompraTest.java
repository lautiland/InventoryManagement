package criterio;

import Model.Categoria;
import Model.criterio.PorPrecioDeCompra;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PorPrecioDeCompraTest {

    @Test
    public void test01PorPrecioDeCompraSeCreaCorrectamente(){
        PorPrecioDeCompra porPrecioDeCompra = new PorPrecioDeCompra();
        assertNotNull(porPrecioDeCompra);
    }

    @Test
    public void test02PorPrecioDeCompraOrdenaCorrectamente(){
        PorPrecioDeCompra porPrecioDeCompra = new PorPrecioDeCompra();
        Categoria categoria = new Categoria("Categoria", 0);
        Producto producto1 = new Producto("Producto1", 11, 1);
        Producto producto2 = new Producto("Producto2", 22, 4);
        Producto producto3 = new Producto("Producto3", 3, 3);
        categoria.agregarIdentificable(producto1);
        categoria.agregarIdentificable(producto2);
        categoria.agregarIdentificable(producto3);

        assertEquals(producto1, porPrecioDeCompra.sort(categoria).get(0));
        assertEquals(producto2, porPrecioDeCompra.sort(categoria).get(2));
        assertEquals(producto3, porPrecioDeCompra.sort(categoria).get(1));
    }
}
