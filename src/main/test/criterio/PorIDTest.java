package criterio;

import Model.Categoria;
import Model.criterio.PorID;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PorIDTest {

    @Test
    public void test01PorIDSeCreaCorrectamente(){
        PorID porID = new PorID();
        assertNotNull(porID);
    }

    @Test
    public void test02PorIDOrdenaCorrectamente(){
        PorID porID = new PorID();
        Categoria categoria = new Categoria("Categoria", 0);
        Producto producto1 = new Producto("Producto1", 11, 1);
        Producto producto2 = new Producto("Producto2", 22, 2);
        Producto producto3 = new Producto("Producto3", 3, 3);
        categoria.agregarIdentificable(producto1);
        categoria.agregarIdentificable(producto2);
        categoria.agregarIdentificable(producto3);

        assertEquals(producto1, porID.sort(categoria).get(1));
        assertEquals(producto2, porID.sort(categoria).get(2));
        assertEquals(producto3, porID.sort(categoria).get(0));
    }
}
