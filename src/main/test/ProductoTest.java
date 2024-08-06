
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {
    @Test
    public void test01ProbadoDeCreacionDeProducto(){
        //Arrange/Act
        Producto producto = new Producto("Producto 1");
        //Assert
        assertEquals(producto.getClass(), Producto.class);
    }
}
