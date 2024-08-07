package Model.producto;

public class Lote {

    private final int CODIGO;
    private final Fecha INGRESO;
    private final Fecha VENCIMIENTO;
    private final Precio PRECIO_DE_COMPRA;
    private int cantidad;

    public Lote(int codigo, Fecha ingreso, Fecha vencimiento, int cantidad, double precio) {
        CODIGO = codigo;
        INGRESO = ingreso;
        VENCIMIENTO = vencimiento;
        PRECIO_DE_COMPRA = new Precio(precio);
        this.cantidad = cantidad;
    }

    public double getPrecioDeCompra() {
        return PRECIO_DE_COMPRA.getValor();
    }

    public int getCantidad(){
        return cantidad;
    }
}
