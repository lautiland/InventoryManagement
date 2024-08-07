import Model.Categoria;
import Model.producto.Producto;
import Model.exception.ProductoNoEncontradoEnCategoriaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTest {

    @Test
    public void test01SeCreaUnaCategoriaYSePideElNombre(){
        //Arrange/Act
        Categoria categoria = new Categoria("Categoria 1");
        //Assert
        assertEquals(categoria.getNombre(), "Categoria 1");
    }

    @Test
    public void test02SeAgregaUnProductoYLuegoSeLoPide(){
        //Arrange
        Categoria categoria = new Categoria("Categoria 1");
        Producto producto = new Producto("Producto 1", 1, 1);
        //Act
        categoria.agregarProducto(producto);
        //Assert
        assertEquals(categoria.buscarProducto(1), producto);
    }

    @Test
    public void test03SePideUnProductoQueNoExisteEnLaCategoria(){
        //Arrange
        Categoria categoria = new Categoria("Categoria 1");
        Producto producto = new Producto("Producto 1", 1, 1);
        categoria.agregarProducto(producto);
        //Act/Assert
        assertThrows(ProductoNoEncontradoEnCategoriaException.class, () -> categoria.buscarProducto(2));
    }

    @Test
    public void test04SeEliminaUnProductoCorrectamente(){
        //Arrange
        Categoria categoria = new Categoria("Categoria 1");
        Producto producto = new Producto("Producto 1", 1, 1);
        //Act
        categoria.agregarProducto(producto);
        categoria.eliminarProducto(1);
        //Assert
        assertThrows(ProductoNoEncontradoEnCategoriaException.class, () -> categoria.buscarProducto(1));
    }

    @Test
    public void test04SeIntentaEliminarUnProductoQueNoExiste(){
        //Arrange
        Categoria categoria = new Categoria("Categoria 1");
        Producto producto = new Producto("Producto 1", 1, 1);
        categoria.agregarProducto(producto);
        //Act/Assert
        assertThrows(ProductoNoEncontradoEnCategoriaException.class, () -> categoria.eliminarProducto(2));
    }
}
