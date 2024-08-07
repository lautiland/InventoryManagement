package producto;

import Model.exception.PrecioNegativoException;
import Model.producto.Precio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrecioTest {

    @Test
    public void test01ProbadoDeCreacionDePrecio(){
        //Arrange/Act
        Precio precio = new Precio(2);
        //Assert
        assertEquals(precio.getClass(), Precio.class);
    }

    @Test
    public void test02SeCreaUnPrecioYSePideElValor(){
        //Arrange/Act
        Precio precio = new Precio(2);
        //Assert
        assertEquals(precio.getValor(), 2);
    }

    @Test
    public void test03SeIntentaCrearUnPrecioConValorNegativo(){
        //Arrange/Act/Assert
        assertThrows(PrecioNegativoException.class, () -> new Precio(-2));
    }

    @Test
    public void test04SeCreaUnPrecioYSeLoPasaAString(){
        //Arrange
        Precio precio = new Precio(2);
        //Act
        String precioString = precio.toString();
        //Assert
        assertEquals(precioString, "2.0");
    }

    @Test
    public void test05SeComparanDosPreciosIguales(){
        //Arrange
        Precio precio1 = new Precio(2);
        Precio precio2 = new Precio(2);
        //Act
        boolean sonIguales = precio1.equals(precio2);
        //Assert
        assertTrue(sonIguales);
    }

    @Test
    public void test06SeComparanDosPreciosDistintos(){
        //Arrange
        Precio precio1 = new Precio(2);
        Precio precio2 = new Precio(3);
        //Act
        boolean sonIguales = precio1.equals(precio2);
        //Assert
        assertFalse(sonIguales);
    }


}
