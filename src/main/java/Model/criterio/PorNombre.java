package Model.criterio;

import Model.producto.Producto;

import java.util.ArrayList;
import java.util.Comparator;

public class PorNombre extends Ordenar implements Criterio {

    @Override
    public ArrayList<Producto> sort(ArrayList<Producto> lista) {
        return copiarYOrdenar(lista, Comparator.comparing(Producto::getNombre));
    }
}
