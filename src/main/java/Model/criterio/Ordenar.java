package Model.criterio;

import Model.producto.Producto;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Ordenar {
    public abstract ArrayList<Producto> sort(ArrayList<Producto> lista);
    protected ArrayList<Producto> copiarYOrdenar(ArrayList<Producto> lista, Comparator<Producto> comparador) {
        ArrayList<Producto> listaOrdenada = new ArrayList<>(lista);
        listaOrdenada.sort(comparador);
        return listaOrdenada;
    }
}
