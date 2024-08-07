import Model.Inventario;
import Model.Producto;
import Model.exception.CategoriaExistenteException;
import Model.exception.CategoriaInexistenteException;
import Model.exception.ObjetoNoEncontradoEnInventarioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {

    @Test
    public void test01SeCargaUnProductoYLuegoSeConsultaPorID(){
        //Arrange
        String nombreCategoria = "Categoria 1";
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1, 1);
        inventario.crearCategoria(nombreCategoria);
        //Act
        inventario.cargarProducto(producto, nombreCategoria);
        //Assert
        assertEquals(inventario.buscarProducto(1), producto);
    }

    @Test
    public void test02SeCargaUnProductoYLuegoSeConsultaPorIDInvalido(){
        //Arrange
        String nombreCategoria = "Categoria 1";
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1, 1);
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

    @Test
    public void test04SeIntentaCargarProductoEnCategoriaInexistente(){
        //Arrange
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1, 1);
        //Act/Assert
        assertThrows(CategoriaInexistenteException.class, () -> inventario.cargarProducto(producto, "Categoria 1"));
    }

    @Test
    public void test05SeCargaUnProductoYLuegoSeLoElimina(){
        //Arrange
        String nombreCategoria = "Categoria 1";
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1, 1);
        inventario.crearCategoria(nombreCategoria);
        inventario.cargarProducto(producto, nombreCategoria);
        //Act
        inventario.eliminarProducto(1);
        //Assert
        assertThrows(ObjetoNoEncontradoEnInventarioException.class, () -> inventario.buscarProducto(1));
    }

    @Test
    public void test06SeIntentaEliminarProductoInexistente(){
        //Arrange
        String nombreCategoria = "Categoria 1";
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1, 1);
        inventario.crearCategoria(nombreCategoria);
        inventario.cargarProducto(producto, nombreCategoria);
        //Act/Assert
        assertThrows(ObjetoNoEncontradoEnInventarioException.class, () -> inventario.eliminarProducto(2));
    }
}
