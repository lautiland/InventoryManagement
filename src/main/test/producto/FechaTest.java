package producto;

import Model.producto.Fecha;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FechaTest {

    @Test
    public void test01ProbadoDeCreacionDeFecha(){
        //Arrange/Act
        Fecha fecha = new Fecha();
        //Assert
        assertEquals(fecha.getClass(), Fecha.class);
    }

    @Test
    public void test02ProbadoDeCreacionDeFechaConParametros(){
        //Arrange/Act
        Fecha fecha = new Fecha(1, 1, 2021);
        //Assert
        assertEquals(fecha.getClass(), Fecha.class);
    }

    @Test
    public void test03SeCreaUnaFechaYSePideElDia(){
        //Arrange/Act
        Fecha fecha = new Fecha(1, 1, 2021);
        //Assert
        assertEquals(fecha.getDia(), 1);
    }

    @Test
    public void test04SeCreaUnaFechaYSePideElMes(){
        //Arrange/Act
        Fecha fecha = new Fecha(1, 1, 2021);
        //Assert
        assertEquals(fecha.getMes(), 1);
    }

    @Test
    public void test05SeCreaUnaFechaYSePideElAnio(){
        //Arrange/Act
        Fecha fecha = new Fecha(1, 1, 2021);
        //Assert
        assertEquals(fecha.getAnio(), 2021);
    }

    @Test
    public void test06SeCreaUnaFechaYSePideLaFechaCompleta(){
        //Arrange/Act
        Fecha fecha = new Fecha(1, 1, 2021);
        //Assert
        assertEquals(fecha.toString(), "1/1/2021");
    }

    @Test
    public void test07SeComparaUnaFechaConOtraYEsMayor(){
        //Arrange/Act
        Fecha fecha1 = new Fecha(1, 1, 2021);
        Fecha fecha2 = new Fecha(1, 2, 2021);
        //Assert
        assertFalse(fecha1.esMayor(fecha2));
    }

    @Test
    public void test08SeComparaUnaFechaConOtraYEsMenor(){
        //Arrange/Act
        Fecha fecha1 = new Fecha(1, 1, 2021);
        Fecha fecha2 = new Fecha(1, 2, 2021);
        //Assert
        assertTrue(fecha2.esMayor(fecha1));
    }

    @Test
    public void test09SeComparanDosFechasYSonIguales(){
        //Arrange/Act
        Fecha fecha1 = new Fecha(1, 1, 2021);
        Fecha fecha2 = new Fecha(1, 1, 2021);
        //Assert
        assertTrue(fecha1.equals(fecha2));
    }

    @Test
    public void test10SeComparanDosFechasMismoAnioYSonDistintas(){
        //Arrange/Act
        Fecha fecha1 = new Fecha(1, 2, 2021);
        Fecha fecha2 = new Fecha(4, 1, 2021);
        //Assert
        assertFalse(fecha1.equals(fecha2));
    }

    @Test
    public void test11SeComparanDosFechasMismoMesYSonDistintas(){
        //Arrange/Act
        Fecha fecha1 = new Fecha(1, 1, 2021);
        Fecha fecha2 = new Fecha(3, 1, 2021);
        //Assert
        assertFalse(fecha1.equals(fecha2));
    }

    @Test
    public void test12SeComparanDosFechasMismoDiaYSonDistintas(){
        //Arrange/Act
        Fecha fecha1 = new Fecha(1, 1, 2021);
        Fecha fecha2 = new Fecha(1, 2, 2022);
        //Assert
        assertFalse(fecha1.equals(fecha2));
    }

    @Test
    public void test13SeIntentaIgualarConOtroObjeto(){
        //Arrange/Act
        Fecha fecha = new Fecha(1, 1, 2021);
        //Assert
        assertFalse(fecha.equals(new Object()));
    }


}

