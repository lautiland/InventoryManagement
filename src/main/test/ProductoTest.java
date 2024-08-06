import Model.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    public void test01SeCreaUnProductoYSePideElNombre(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1);
        //Assert
        assertEquals(producto.getNombre(), "Producto 1");
    }

    @Test
    public void test01SeCreaUnProductoYSePideElID(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1", 1);
        //Assert
        assertEquals(producto.getID(), 1);
    }
}
