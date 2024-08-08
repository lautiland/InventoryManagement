package criterio;

import Model.Inventario;
import Model.criterio.PorCantidad;
import Model.producto.Fecha;
import Model.producto.Lote;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class PorCantidadTest {
    @Test
    public void test01DadaUnaListaDeProductosDevuelveLaListaOrdenadaPorCantidad(){
        //Arrange
        Producto producto1 = new Producto("Producto1", 1, 100);
        Producto producto2 = new Producto("Producto2", 2, 200);
        Producto producto3 = new Producto("Producto3", 3, 300);
        Producto producto4 = new Producto("Producto4", 4, 400);
        //creo lotes a los productos
        Lote lote1 = new Lote(1, new Fecha(), new Fecha(), 5, 100);
        Lote lote2 = new Lote(2, new Fecha(), new Fecha(), 2, 200);
        Lote lote3 = new Lote(3, new Fecha(), new Fecha(), 3, 300);
        Lote lote4 = new Lote(4, new Fecha(), new Fecha(), 9, 400);
        //cargo los lotes
        producto1.cargarLote(lote1);
        producto2.cargarLote(lote2);
        producto3.cargarLote(lote3);
        producto4.cargarLote(lote4);
        //creo la lista de productos con el orden correcto
        ArrayList<Producto> productosOrdenados = new ArrayList<>();
        productosOrdenados.add(producto2);
        productosOrdenados.add(producto3);
        productosOrdenados.add(producto1);
        productosOrdenados.add(producto4);
        //creo el inventario
        Inventario inventario = new Inventario();
        inventario.cargarProducto(producto1);
        inventario.cargarProducto(producto2);
        inventario.cargarProducto(producto3);
        inventario.cargarProducto(producto4);
        //Act
        ArrayList<Producto> productosOrdenadosPorCantidad = inventario.obtenerProductosSegunCriterio(new PorCantidad());
        //Assert
        assertEquals(productosOrdenados, productosOrdenadosPorCantidad);
    }
}
