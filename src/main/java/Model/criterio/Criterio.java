package Model.criterio;

import Model.producto.Producto;
import java.util.ArrayList;

public interface Criterio {
    ArrayList<Producto> sort(ArrayList<Producto> lista);
}