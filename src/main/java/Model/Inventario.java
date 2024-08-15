package Model;
import Model.criterio.Criterio;
import Model.exception.*;
import Model.producto.Producto;

import java.util.ArrayList;

public class Inventario {
    private final Categoria productos;

    public Inventario(){
        productos = new Categoria("Productos", 0);
    }

    public void agregarIdentificable(Identificable identificable, int categoriaID) throws IdentificableYaExisteException, CategoriaInexistenteException {
        try {
            productos.obtenerIdentificable(identificable.getID());
            throw new IdentificableYaExisteException();
        } catch (IdentificableNoEncontradoException e) {
            try {
                Categoria categoria = (Categoria) obtenerIdentificable(categoriaID);
                categoria.agregarIdentificable(identificable);
            } catch (IdentificableNoEncontradoException e2) {
                throw new CategoriaInexistenteException();
            }
        }
    }

    public void agregarIdentificable(Identificable identificable) throws IdentificableYaExisteException {
        this.agregarIdentificable(identificable, 0);
    }

    public void eliminarIdentificable(int ID) throws IdentificableNoEncontradoException {
        productos.eliminarIdentificable(ID);
    }

    public Identificable obtenerIdentificable(int ID) throws IdentificableNoEncontradoException {
        if (ID == 0) {
            return productos;
        }
        return productos.obtenerIdentificable(ID);
    }

    public ArrayList<Producto> obtenerProductosSegunCriterio(Criterio criterio){
        return criterio.sort(productos);
    }

}
