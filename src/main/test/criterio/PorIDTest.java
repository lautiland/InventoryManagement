package criterio;

import Model.Inventario;
import Model.criterio.PorID;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PorIDTest {
    @Test
    public void test01DadaUnaListaDeProductosDevuelveLaListaOrdenadaPorID(){
        //Arrange
        Producto producto1 = new Producto("Producto1", 18, 100);
        Producto producto2 = new Producto("Producto2", 82, 200);
        Producto producto3 = new Producto("Producto3", 6, 300);
        Producto producto4 = new Producto("Producto4", 45, 400);
        //creo la lista de productos con el orden correcto
        ArrayList<Producto> productosOrdenados = new ArrayList<>();
        productosOrdenados.add(producto3);
        productosOrdenados.add(producto1);
        productosOrdenados.add(producto4);
        productosOrdenados.add(producto2);
        //creo el inventario
        Inventario inventario = new Inventario();
        inventario.cargarProducto(producto1);
        inventario.cargarProducto(producto2);
        inventario.cargarProducto(producto3);
        inventario.cargarProducto(producto4);
        //Act
        ArrayList<Producto> productosOrdenadosPorID = inventario.obtenerProductosSegunCriterio(new PorID());
        //Assert
        assertEquals(productosOrdenados, productosOrdenadosPorID);
    }
}
