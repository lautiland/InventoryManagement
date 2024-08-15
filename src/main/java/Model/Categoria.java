package Model;

import Model.criterio.Criterio;
import Model.exception.IdentificableNoEncontradoException;
import Model.producto.Producto;

import java.util.ArrayList;

public class Categoria implements Identificable {

    private final int ID;
    private final String NOMBRE;
    private final ArrayList<Identificable> ELEMENTOS;

    public Categoria(String nombre, int id){ {
        NOMBRE = nombre;}
        ID = id;
        ELEMENTOS = new ArrayList<>();
    }

    @Override
    public String getNombre(){
        return NOMBRE;
    }

    @Override
    public int getID() {
        return ID;
    }

    public void agregarIdentificable(Identificable identificable){
        ELEMENTOS.add(identificable);
    }

    public void eliminarIdentificable(int ID) throws IdentificableNoEncontradoException {
        for (Identificable identificable : ELEMENTOS) {
            if (identificable.getID() == ID) {
                ELEMENTOS.remove(identificable);
                return;
            }
            if (identificable instanceof Categoria) {
                try {
                    ((Categoria) identificable).eliminarIdentificable(ID);
                    return;
                } catch (IdentificableNoEncontradoException ignored) {

                }
            }
        }
        throw new IdentificableNoEncontradoException();
    }

    public Identificable obtenerIdentificable(int ID) throws IdentificableNoEncontradoException {
        for (Identificable identificable : ELEMENTOS) {
            if (identificable.getID() == ID) {
                return identificable;
            }
            if (identificable instanceof Categoria) {
                try {
                    return ((Categoria) identificable).obtenerIdentificable(ID);
                } catch (IdentificableNoEncontradoException ignored) {

                }
            }
        }
        throw new IdentificableNoEncontradoException();
    }

    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        for (Identificable identificable : ELEMENTOS) {
            if (identificable instanceof Producto) {
                productos.add((Producto) identificable);
            } else if (identificable instanceof Categoria) {
                productos.addAll(((Categoria) identificable).getProductos());
            }
        }
        return productos;
    }

    public ArrayList<Producto> obtenerProductosSegunCriterio(Criterio criterio){
        return criterio.sort(this);
    }
}
