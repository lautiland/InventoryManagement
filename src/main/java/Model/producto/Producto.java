package Model.producto;

import Model.Identificable;
import Model.exception.CantidadInsuficienteException;

import java.util.ArrayList;

public class Producto implements Identificable {

    private final int ID;
    private final String NOMBRE;
    private final ArrayList<Lote> LOTES = new ArrayList<>();
    private Precio costoDeProduccion;
    private Precio rentabilidad;
    private Precio compra;

    public Producto(String nombre, int id, double compra){
        NOMBRE = nombre;
        ID = id;
        this.compra = new Precio(compra);
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getNombre(){
        return this.NOMBRE;
    }

    public void setPrecioDeVenta(double costoDeProduccion, double rentabilidad){
        this.costoDeProduccion = new Precio(costoDeProduccion);
        this.rentabilidad = new Precio(rentabilidad);
    }

    public double getPrecioDeVenta(){
        return (costoDeProduccion.getValor() + compra.getValor()) * (100 / (100 - rentabilidad.getValor()));
    }

    public void setPrecioDeCompra(double compra){
        this.compra = new Precio(compra);
    }

    public double getPrecioDeCompra(){
        return compra.getValor();
    }

    public int getCantidad(){
        int stock = 0;
        for (Lote lote : LOTES) {
            stock += lote.getCantidad();
        }
        return stock;
    }

    public void cargarLote(Lote lote){
        LOTES.add(lote);
    }

    public void eliminarCantidad(int cantidad){
        int cantidadRestante = cantidad;
        LOTES.sort((lote1, lote2) -> lote1.getVencimiento().esMayor(lote2.getVencimiento()) ? 1 :
                                    lote2.getVencimiento().esMayor(lote1.getVencimiento()) ? -1 :
                                    0);
        for (Lote lote : LOTES) {
            if (cantidadRestante > 0) {
                int cantidadLote = lote.getCantidad();
                if (cantidadLote >= cantidadRestante) {
                    lote.quitarCantidad(cantidadRestante);
                    cantidadRestante = 0;
                } else {
                    lote.quitarCantidad(cantidadLote);
                    cantidadRestante -= cantidadLote;
                }
            }
        }
        if (cantidadRestante > 0) {
            throw new CantidadInsuficienteException();
        }
    }

}
