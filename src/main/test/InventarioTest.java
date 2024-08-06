import Model.Inventario;
import Model.Producto;
import Model.exception.CategoriaExistenteException;
import Model.exception.ObjetoNoEncontradoEnInventarioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {

    @Test
    public void test01SeCargaUnObjetoYLuegoSeConsultaPorID(){
        //Arrange
        String nombreCategoria = "Categoria 1";
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1);
        inventario.crearCategoria(nombreCategoria);
        //Act
        inventario.cargarProducto(producto, nombreCategoria);
        //Assert
        assertEquals(inventario.buscarProducto(1), producto);
    }

    @Test
    public void test02SeCargaUnObjetoYLuegoSeConsultaPorIDInvalido(){
        //Arrange
        String nombreCategoria = "Categoria 1";
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1);
        inventario.crearCategoria(nombreCategoria);
        //Act
        inventario.cargarProducto(producto, nombreCategoria);
        //Assert
        assertThrows(ObjetoNoEncontradoEnInventarioException.class, () -> inventario.buscarProducto(2));
    }

    @Test
    public void test03SeIntentaCrearCategoriaConNombreExistente(){
        //Arrange
        String nombreCategoria = "Categoria 1";
        Inventario inventario = new Inventario();
        inventario.crearCategoria(nombreCategoria);
        //Act/Assert
        assertThrows(CategoriaExistenteException.class, () -> inventario.crearCategoria(nombreCategoria));
    }
}
