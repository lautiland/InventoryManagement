package criterio;

import Model.Inventario;
import Model.criterio.PorNombre;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PorNombreTest {
    @Test
    public void test01DadaUnaListaDeProductosDevuelveLaListaOrdenadaPorNombre(){
        //Arrange
        Producto producto1 = new Producto("Producto1a", 18, 100);
        Producto producto2 = new Producto("Producto4b", 82, 200);
        Producto producto3 = new Producto("Producto2b", 6, 300);
        Producto producto4 = new Producto("Producto4a", 45, 400);
        //creo la lista de productos con el orden correcto
        ArrayList<Producto> productosOrdenados = new ArrayList<>();
        productosOrdenados.add(producto1);
        productosOrdenados.add(producto3);
        productosOrdenados.add(producto4);
        productosOrdenados.add(producto2);
        //creo el inventario
        Inventario inventario = new Inventario();
        inventario.cargarProducto(producto1);
        inventario.cargarProducto(producto2);
        inventario.cargarProducto(producto3);
        inventario.cargarProducto(producto4);
        //Act
        ArrayList<Producto> productosOrdenadosPorNombre = inventario.obtenerProductosSegunCriterio(new PorNombre());
        //Assert
        assertEquals(productosOrdenados, productosOrdenadosPorNombre);
    }
}
