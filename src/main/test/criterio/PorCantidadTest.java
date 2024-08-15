package criterio;

import Model.Categoria;
import Model.criterio.PorCantidad;
import Model.producto.Fecha;
import Model.producto.Lote;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PorCantidadTest {

    @Test
    public void test01PorCantidadSeCreaCorrectamente(){
        PorCantidad porCantidad = new PorCantidad();
        assertNotNull(porCantidad);
    }

    @Test
    public void test02PorCantidadOrdenaCorrectamente(){
        PorCantidad porCantidad = new PorCantidad();
        Categoria categoria = new Categoria("Categoria", 0);
        Producto producto1 = new Producto("Producto1", 1, 1);
        Producto producto2 = new Producto("Producto2", 2, 2);
        Producto producto3 = new Producto("Producto3", 3, 3);
        Lote lote1 = new Lote(1, new Fecha(), new Fecha(), 3, 1);
        Lote lote2 = new Lote(2, new Fecha(), new Fecha(), 1, 2);
        Lote lote3 = new Lote(3, new Fecha(), new Fecha(), 2, 3);
        producto1.cargarLote(lote1);
        producto2.cargarLote(lote2);
        producto3.cargarLote(lote3);
        categoria.agregarIdentificable(producto1);
        categoria.agregarIdentificable(producto2);
        categoria.agregarIdentificable(producto3);

        assertEquals(producto1, porCantidad.sort(categoria).get(2));
        assertEquals(producto2, porCantidad.sort(categoria).get(0));
        assertEquals(producto3, porCantidad.sort(categoria).get(1));
    }
}
