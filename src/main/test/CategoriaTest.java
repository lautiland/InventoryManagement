import Model.Categoria;
import Model.Producto;
import Model.exception.ObjetoNoEncontradoEnCategoriaException;
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
        Producto producto = new Producto("Producto 1", 1);
        //Act
        categoria.agregarProducto(producto);
        //Assert
        assertEquals(categoria.buscarProducto(1), producto);
    }

    @Test
    public void test03SePideUnProductoQueNoExisteEnLaCategoria(){
        //Arrange
        Categoria categoria = new Categoria("Categoria 1");
        Producto producto = new Producto("Producto 1", 1);
        //Act
        categoria.agregarProducto(producto);
        //Assert
        assertThrows(ObjetoNoEncontradoEnCategoriaException.class, () -> categoria.buscarProducto(2));
    }
}
