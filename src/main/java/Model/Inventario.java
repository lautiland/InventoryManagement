package Model;

import Model.exception.CategoriaExistenteException;
import Model.exception.CategoriaInexistenteException;
import Model.exception.ObjetoNoEncontradoEnCategoriaException;
import Model.exception.ObjetoNoEncontradoEnInventarioException;

import java.util.ArrayList;

public class Inventario {
    private final ArrayList<Categoria> CATEGORIAS;

    public Inventario(){
        CATEGORIAS = new ArrayList<>();
    }

    public void crearCategoria(String nombre) {
        try {
            buscarCategoria(nombre);
            throw new CategoriaExistenteException();
        } catch (CategoriaInexistenteException e) {
            CATEGORIAS.add(new Categoria(nombre));
        }
    }

    public void cargarProducto(Producto producto, String nombreCategoria) {
        Categoria categoria = buscarCategoria(nombreCategoria);
        categoria.agregarProducto(producto);
    }

    public Producto buscarProducto(int ID) {
        for (Categoria categoria : CATEGORIAS) {
            try {
                return categoria.buscarProducto(ID);
            } catch (ObjetoNoEncontradoEnCategoriaException ignored) {

            }
        }
        throw new ObjetoNoEncontradoEnInventarioException();
    }

    private Categoria buscarCategoria(String nombre) {
        for (Categoria categoria : CATEGORIAS) {
            if (categoria.getNombre().equals(nombre)) {
                return categoria;
            }
        }
        throw new CategoriaInexistenteException();
    }
}
