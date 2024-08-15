package Model.criterio;

import Model.Categoria;
import Model.producto.Producto;

import java.util.ArrayList;
import java.util.Comparator;

public class PorPrecioDeCompra extends Ordenar implements Criterio {

    @Override
    public ArrayList<Producto> sort(Categoria productos) {
        return copiarYOrdenar(productos.getProductos(), Comparator.comparingDouble(Producto::getPrecioDeCompra));
    }
}
