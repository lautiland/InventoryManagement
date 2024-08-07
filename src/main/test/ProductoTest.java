import Model.Fecha;
import Model.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    public void test01ProbadoDeCreacionDeProductoSimple(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1);
        //Assert
        assertEquals(producto.getClass(), Producto.class);
    }

    @Test
    public void test02ProbadoDeCreacionDeProductoCompleto(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1, new Fecha(), 1);
        //Assert
        assertEquals(producto.getClass(), Producto.class);
    }

    @Test
    public void test03SeCreaUnProductoSimpleYSePideElNombre(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1);
        //Assert
        assertEquals(producto.getNombre(), "Producto 1");
    }

    @Test
    public void test04SeCreaUnProductoSimpleYSePideElID(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1);
        //Assert
        assertEquals(producto.getID(), 1);
    }

    @Test
    public void test05SeCreaUnProductoSimpleYSePideElPrecio(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1);
        //Assert
        assertEquals(producto.getPrecio(), 1);
    }

    @Test
    public void test06SeCreaUnProductoSimpleYSePideElStock(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1);
        //Assert
        assertEquals(producto.getStock(), 0);
    }

    @Test
    public void test07SeCreaUnProductoSimpleYSePideLaFechaDeIngreso(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1, 1);
        //Assert
        assertNotNull(producto.getIngreso());
    }


    @Test
    public void test08SeCreaUnProductoSimpleYSeCambiaElPrecio(){
        //Arrange
        Producto producto = new Producto("Producto 1", 1, 1);
        //Act
        producto.setPrecio(2);
        //Assert
        assertEquals(producto.getPrecio(), 2);
    }

    @Test
    public void test09SeCreaUnProductoSimpleYSeCambiaElStock(){
        //Arrange
        Producto producto = new Producto("Producto 1", 1, 1);
        //Act
        producto.setStock(2);
        //Assert
        assertEquals(producto.getStock(), 2);
    }
}
