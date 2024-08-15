package Model.producto;

import Model.exception.CantidadNegativaException;

public class Lote {

    private final int CODIGO;
    private final Fecha INGRESO;
    private final Fecha VENCIMIENTO;
    private int cantidad;

    public Lote(int codigo, Fecha ingreso, Fecha vencimiento, int cantidad) {
        CODIGO = codigo;
        INGRESO = ingreso;
        VENCIMIENTO = vencimiento;
        this.cantidad = cantidad;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void quitarCantidad(int cantidad){
        if (cantidad < 0 || this.cantidad - cantidad < 0){
            throw new CantidadNegativaException();
        }
        this.cantidad -= cantidad;
    }

    public Fecha getVencimiento() {
        return VENCIMIENTO;
    }

    public Fecha getIngreso() {
        return INGRESO;
    }

    public int getCodigo() {
        return CODIGO;
    }
}
