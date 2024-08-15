import Model.Categoria;
import Model.criterio.Criterio;
import Model.criterio.PorID;
import Model.exception.IdentificableNoEncontradoException;
import Model.producto.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTest {

    @Test
    public void test01SeCreaUnaCategoriaYSePideElNombre(){
        //Arrange/Act
        Categoria categoria = new Categoria("Categoria 1", 1);
        //Assert
        assertEquals(categoria.getNombre(), "Categoria 1");
    }

    @Test
    public void test02SeAgregaUnProductoYLuegoSeLoPide() throws IdentificableNoEncontradoException {
        //Arrange
        Categoria categoria = new Categoria("Categoria 1", 1);
        Producto producto = new Producto("Producto 1", 2, 1);
        //Act
        categoria.agregarIdentificable(producto);
        //Assert
        assertEquals(categoria.obtenerIdentificable(2), producto);
    }

    @Test
    public void test03SePideUnProductoQueNoExisteEnLaCategoria(){
        //Arrange
        Categoria categoria = new Categoria("Categoria 1", 1);
        Producto producto = new Producto("Producto 1", 2, 1);
        categoria.agregarIdentificable(producto);
        //Act/Assert
        assertThrows(IdentificableNoEncontradoException.class, () -> categoria.obtenerIdentificable(3));
    }

    @Test
    public void test04SeEliminaUnProductoCorrectamente() throws IdentificableNoEncontradoException {
        //Arrange
        Categoria categoria = new Categoria("Categoria 1", 1);
        Producto producto = new Producto("Producto 1", 2, 1);
        //Act
        categoria.agregarIdentificable(producto);
        categoria.eliminarIdentificable(2);
        //Assert
        assertThrows(IdentificableNoEncontradoException.class, () -> categoria.obtenerIdentificable(2));
    }

    @Test
    public void test04SeIntentaEliminarUnProductoQueNoExiste(){
        //Arrange
        Categoria categoria = new Categoria("Categoria 1", 1);
        Producto producto = new Producto("Producto 1", 2, 1);
        categoria.agregarIdentificable(producto);
        //Act/Assert
        assertThrows(IdentificableNoEncontradoException.class, () -> categoria.eliminarIdentificable(3));
    }

    @Test
    public void test05SeAgregaUnaSubCategoriaYLuegoSeLaPide() throws IdentificableNoEncontradoException {
        //Arrange
        Categoria categoria = new Categoria("Categoria 1", 1);
        Categoria subCategoria = new Categoria("SubCategoria 1", 2);
        //Act
        categoria.agregarIdentificable(subCategoria);
        //Assert
        assertEquals(categoria.obtenerIdentificable(2), subCategoria);
    }

    @Test
    public void test06SeAgregaUnProductoEnUnaSubCategoriaYLuegoSeLoPide() throws IdentificableNoEncontradoException {
        //Arrange
        Categoria categoria = new Categoria("Categoria 1", 1);
        Categoria subCategoria = new Categoria("SubCategoria 1", 2);
        Producto producto = new Producto("Producto 1", 3, 1);
        //Act
        categoria.agregarIdentificable(subCategoria);
        subCategoria.agregarIdentificable(producto);
        //Assert
        assertEquals(subCategoria.obtenerIdentificable(3), producto);
    }

    @Test
    public void test07SeEliminaUnProductoDeUnaSubCategoria() throws IdentificableNoEncontradoException {
        //Arrange
        Categoria categoria = new Categoria("Categoria 1", 1);
        Categoria subCategoria = new Categoria("SubCategoria 1", 2);
        Producto producto = new Producto("Producto 1", 3, 1);
        //Act
        categoria.agregarIdentificable(subCategoria);
        subCategoria.agregarIdentificable(producto);
        subCategoria.eliminarIdentificable(3);
        //Assert
        assertThrows(IdentificableNoEncontradoException.class, () -> subCategoria.obtenerIdentificable(3));
    }

    @Test
    public void test08SeEliminaUnaSubCategoria() throws IdentificableNoEncontradoException {
        //Arrange
        Categoria categoria = new Categoria("Categoria 1", 1);
        Categoria subCategoria = new Categoria("SubCategoria 1", 2);
        //Act
        categoria.agregarIdentificable(subCategoria);
        categoria.eliminarIdentificable(2);
        //Assert
        assertThrows(IdentificableNoEncontradoException.class, () -> categoria.obtenerIdentificable(2));
    }

    @Test
    public void test09SeAgregaUnProductoEnUnaSubCategoriaYLuegoSeLoPideDesdeLaCategoriaPadre() throws IdentificableNoEncontradoException {
        //Arrange
        Categoria categoria = new Categoria("Categoria 1", 1);
        Categoria subCategoria = new Categoria("SubCategoria 1", 2);
        Producto producto = new Producto("Producto 1", 3, 1);
        //Act
        categoria.agregarIdentificable(subCategoria);
        subCategoria.agregarIdentificable(producto);
        //Assert
        assertEquals(categoria.obtenerIdentificable(3), producto);
    }

    @Test
    public void test08SeCarganVariosProductosYSeConsultanSegunCriterioPorID(){
        //Arrange
        Criterio criterio = new PorID();
        Categoria categoria = new Categoria("Categoria 1", 1);
        Producto producto1 = new Producto("Producto 1", 3, 1);
        Producto producto2 = new Producto("Producto 2", 1, 2);
        Producto producto3 = new Producto("Producto 3", 2, 3);
        //Act
        categoria.agregarIdentificable(producto1);
        categoria.agregarIdentificable(producto2);
        categoria.agregarIdentificable(producto3);
        //Assert
        assertEquals(categoria.obtenerProductosSegunCriterio(criterio).get(2), producto1);
        assertEquals(categoria.obtenerProductosSegunCriterio(criterio).get(0), producto2);
        assertEquals(categoria.obtenerProductosSegunCriterio(criterio).get(1), producto3);
    }
}
