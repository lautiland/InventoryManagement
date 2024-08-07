package Model.producto;

import Model.exception.PrecioNegativoException;

public class Precio {
    private final double VALOR;

    public Precio(double valor){
        this.VALOR = valor;
        comprobarValor();
    }

    public double getValor(){
        return VALOR;
    }

    private void comprobarValor(){
        if (VALOR < 0){
            throw new PrecioNegativoException();
        }
    }

    @Override
    public String toString(){
        return String.valueOf(VALOR);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Precio){
            Precio precio = (Precio) obj;
            return this.toString().equals(precio.toString());
        }
        return false;
    }
}
