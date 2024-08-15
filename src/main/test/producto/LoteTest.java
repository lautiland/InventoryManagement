package producto;

import Model.exception.CantidadNegativaException;
import Model.producto.Fecha;
import Model.producto.Lote;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoteTest {

    @Test
    public void test01ProbadoDeCreacionDeLote(){
        //Arrange/Act
        Lote lote = new Lote(1, new Fecha(), new Fecha(), 5);
        //Assert
        assertEquals(lote.getClass(), Lote.class);
    }

    @Test
    public void test02ProbadoDeObtencionDeCantidad(){
        //Arrange
        Lote lote = new Lote(1, new Fecha(), new Fecha(), 5);
        //Act
        int cantidad = lote.getCantidad();
        //Assert
        assertEquals(5, cantidad);
    }

    @Test
    public void test03ProbadoDeQuitarCantidad(){
        //Arrange
        Lote lote = new Lote(1, new Fecha(), new Fecha(), 5);
        //Act
        lote.quitarCantidad(2);
        //Assert
        assertEquals(3, lote.getCantidad());
    }

    @Test
    public void test04ProbadoDeObtencionDeVencimiento(){
        //Arrange
        Fecha vencimiento = new Fecha();
        Lote lote = new Lote(1, new Fecha(), vencimiento, 5);
        //Act
        Fecha vencimientoObtenido = lote.getVencimiento();
        //Assert
        assertEquals(vencimiento, vencimientoObtenido);
    }

    @Test
    public void test05ProbadoDeObtencionDeIngreso(){
        //Arrange
        Fecha ingreso = new Fecha();
        Lote lote = new Lote(1, ingreso, new Fecha(), 5);
        //Act
        Fecha ingresoObtenido = lote.getIngreso();
        //Assert
        assertEquals(ingreso, ingresoObtenido);
    }

    @Test
    public void test06ProbadoDeObtencionDeCodigo(){
        //Arrange
        Lote lote = new Lote(1, new Fecha(), new Fecha(), 5);
        //Act
        int codigo = lote.getCodigo();
        //Assert
        assertEquals(1, codigo);
    }

    @Test
    public void test07ProbadoDeQuitarCantidadConCantidadNegativa(){
        //Arrange
        Lote lote = new Lote(1, new Fecha(), new Fecha(), 5);
        //Act/Assert
        assertThrows(CantidadNegativaException.class, () -> lote.quitarCantidad(6));
    }

    @Test
    public void test08ProbadoDeQuitarCantidadConCantidadNegativa(){
        //Arrange
        Lote lote = new Lote(1, new Fecha(), new Fecha(), 5);
        //Act/Assert
        assertThrows(CantidadNegativaException.class, () -> lote.quitarCantidad(-2));
    }

}
