package criterio;

import Model.Categoria;
import Model.criterio.PorNombre;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PorNombreTest {

    @Test
    public void test01PorNombreSeCreaCorrectamente(){
        PorNombre porNombre = new PorNombre();
        assertNotNull(porNombre);
    }

    @Test
    public void test02PorNombreOrdenaCorrectamente(){
        PorNombre porNombre = new PorNombre();
        Categoria categoria = new Categoria("Categoria", 0);
        Producto producto1 = new Producto("ProductoA", 11, 1);
        Producto producto2 = new Producto("ProductoC", 22, 2);
        Producto producto3 = new Producto("ProductoB", 3, 3);
        categoria.agregarIdentificable(producto1);
        categoria.agregarIdentificable(producto2);
        categoria.agregarIdentificable(producto3);

        assertEquals(producto1, porNombre.sort(categoria).get(0));
        assertEquals(producto2, porNombre.sort(categoria).get(2));
        assertEquals(producto3, porNombre.sort(categoria).get(1));
    }
}
