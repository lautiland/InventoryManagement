package Model.criterio;

import Model.Categoria;
import Model.producto.Producto;
import java.util.ArrayList;

public interface Criterio {
    ArrayList<Producto> sort(Categoria productos);
}