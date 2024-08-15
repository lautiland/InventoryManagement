package Model.producto;

import Model.Identificable;

import java.util.ArrayList;

public class Producto implements Identificable {

    private final int ID;
    private final String NOMBRE;
    private final ArrayList<Lote> LOTES = new ArrayList<>();
    private Precio venta;
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
        double costo = costoDeProduccion + compra.getValor();
        venta = new Precio(costo * (100 / (100 - rentabilidad)));
    }

    public double getPrecioDeVenta(){
        return venta.getValor();
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
        //TODO: Implementar el ponderado de precios de compra con varios strategy
        setPrecioDeCompra(lote.getPrecioDeCompra());
    }

}
