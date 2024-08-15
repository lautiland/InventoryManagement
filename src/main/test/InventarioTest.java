import Model.Categoria;
import Model.Inventario;
import Model.criterio.Criterio;
import Model.criterio.PorID;
import Model.exception.*;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {

    @Test
    public void test01SeCargaUnProductoYLuegoSeConsultaPorID() throws IdentificableNoEncontradoException, IdentificableYaExisteException {
        //Arrange
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1, 1);
        //Act
        inventario.agregarIdentificable(producto);
        //Assert
        assertEquals(inventario.obtenerIdentificable(1), producto);
    }

    @Test
    public void test02SeCargaUnProductoYLuegoSeConsultaUnIDInvalido() throws IdentificableYaExisteException {
        //Arrange
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1, 1);
        //Act
        inventario.agregarIdentificable(producto);
        //Assert
        assertThrows(IdentificableNoEncontradoException.class, () -> inventario.obtenerIdentificable(2));
    }

    @Test
    public void test03SeIntentaCargarCategoriaConIDExistente() throws IdentificableYaExisteException {
        //Arrange
        Inventario inventario = new Inventario();
        Categoria categoria = new Categoria("Categoria 1", 1);
        Categoria categoria2 = new Categoria("Categoria 2", 1);
        inventario.agregarIdentificable(categoria);
        //Act/Assert
        assertThrows(IdentificableYaExisteException.class, () -> inventario.agregarIdentificable(categoria2));
    }

    @Test
    public void test04SeIntentaCargarProductoEnCategoriaInexistente(){
        //Arrange
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1, 1);
        //Act/Assert
        assertThrows(CategoriaInexistenteException.class, () -> inventario.agregarIdentificable(producto, 3));
    }

    @Test
    public void test05SeEliminaUnProductoYLuegoSeLoPide() throws IdentificableYaExisteException, IdentificableNoEncontradoException {
        //Arrange
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1, 1);
        inventario.agregarIdentificable(producto);
        //Act
        inventario.eliminarIdentificable(1);
        //Assert
        assertThrows(IdentificableNoEncontradoException.class, () -> inventario.obtenerIdentificable(1));
    }

    @Test
    public void test06SeIntentaEliminarProductoInexistente() throws IdentificableYaExisteException {
        //Arrange
        Inventario inventario = new Inventario();
        Producto producto = new Producto("Producto 1", 1, 1);
        inventario.agregarIdentificable(producto);
        //Act/Assert
        assertThrows(IdentificableNoEncontradoException.class, () -> inventario.eliminarIdentificable(2));
    }

    @Test
    public void test07SeCargaUnProductoEnSubCategoriaYLuegoSeConsultaPorID() throws IdentificableNoEncontradoException, IdentificableYaExisteException {
        //Arrange
        Inventario inventario = new Inventario();
        Categoria categoria = new Categoria("Categoria 1", 1);
        Categoria subCategoria = new Categoria("SubCategoria 1", 2);
        Producto producto = new Producto("Producto 1", 3, 1);
        //Act
        inventario.agregarIdentificable(categoria);
        inventario.agregarIdentificable(subCategoria, 1);
        inventario.agregarIdentificable(producto, 2);
        //Assert
        assertEquals(inventario.obtenerIdentificable(3), producto);
    }

    @Test
    public void test08SeCarganVariosProductosYSeConsultanSegunCriterioPorID() throws IdentificableYaExisteException {
        //Arrange
        Criterio criterio = new PorID();
        Inventario inventario = new Inventario();
        Producto producto1 = new Producto("Producto 1", 10, 1);
        Producto producto2 = new Producto("Producto 2", 3, 2);
        Producto producto3 = new Producto("Producto 3", 7, 3);
        //Act
        inventario.agregarIdentificable(producto1);
        inventario.agregarIdentificable(producto2);
        inventario.agregarIdentificable(producto3);
        //Assert
        assertEquals(inventario.obtenerProductosSegunCriterio(criterio).get(2), producto1);
        assertEquals(inventario.obtenerProductosSegunCriterio(criterio).get(0), producto2);
        assertEquals(inventario.obtenerProductosSegunCriterio(criterio).get(1), producto3);
    }
}
