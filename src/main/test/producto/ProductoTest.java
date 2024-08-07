package producto;

import Model.producto.Fecha;
import Model.producto.Lote;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    public void test01ProbadoDeCreacionDeProducto(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1);
        //Assert
        assertEquals(producto.getClass(), Producto.class);
    }

    @Test
    public void test02SeCreaUnProductoYSePideElNombre(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1);
        //Assert
        assertEquals(producto.getNombre(), "Producto 1");
    }

    @Test
    public void test03SeCreaUnProductoYSePideElID(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1);
        //Assert
        assertEquals(producto.getID(), 1);
    }

    @Test
    public void test04SeCreaUnProductoYSePideElPrecioDeCompra(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1);
        //Assert
        assertEquals(producto.getPrecioDeCompra(), 1);
    }

    @Test
    public void test05SeCreaUnProductoYSeCambiaElPrecioDeCompra(){
        //Arrange
        Producto producto = new Producto("Producto 1", 1, 1);
        //Act
        producto.setPrecioDeCompra(2);
        //Assert
        assertEquals(producto.getPrecioDeCompra(), 2);
    }

    @Test
    public void test06SeCargaUnLoteYSeConsultaLaCantidad(){
        //Arrange
        Producto producto = new Producto("Producto 1", 1, 1);
        Lote lote1 = new Lote(1, new Fecha(), new Fecha(), 5, 1);
        //Act
        producto.cargarLote(lote1);
        //Assert
        assertEquals(producto.getCantidad(), 5);
    }

    @Test
    public void test07SeCargaUnProductoYSeConsultaElPrecioDeVenta(){
        //Arrange
        Producto producto = new Producto("Producto 1", 1, 1);
        //Act
        producto.setPrecioDeVenta(1, 50);
        //Assert
        assertEquals(producto.getPrecioDeVenta(), 4);
    }

}
