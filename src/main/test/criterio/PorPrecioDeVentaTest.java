package criterio;

import Model.Inventario;
import Model.criterio.PorPrecioDeVenta;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PorPrecioDeVentaTest {
    @Test
    public void test01DadaUnaListaDeProductosDevuelveLaListaOrdenadaPorPrecioDeVenta(){
        //Arrange
        Producto producto1 = new Producto("Producto1", 18, 200);
        Producto producto2 = new Producto("Producto2", 82, 300);
        Producto producto3 = new Producto("Producto3", 6, 200);
        Producto producto4 = new Producto("Producto4", 45, 500);
        //calculo el precio de venta de los productos
        producto1.setPrecioDeVenta(800, 10);
        producto2.setPrecioDeVenta(100, 10);
        producto3.setPrecioDeVenta(300, 10);
        producto4.setPrecioDeVenta(400, 10);
        //creo la lista de productos con el orden correcto
        ArrayList<Producto> productosOrdenados = new ArrayList<>();
        productosOrdenados.add(producto2);
        productosOrdenados.add(producto3);
        productosOrdenados.add(producto4);
        productosOrdenados.add(producto1);
        //creo el inventario
        Inventario inventario = new Inventario();
        inventario.cargarProducto(producto1);
        inventario.cargarProducto(producto2);
        inventario.cargarProducto(producto3);
        inventario.cargarProducto(producto4);
        //Act
        ArrayList<Producto> productosOrdenadosPorPrecioDeVenta = inventario.obtenerProductosSegunCriterio(new PorPrecioDeVenta());
        //Assert
        assertEquals(productosOrdenados, productosOrdenadosPorPrecioDeVenta);
    }
}
