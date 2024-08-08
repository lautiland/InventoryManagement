package Model;

import Model.criterio.Criterio;
import Model.exception.CategoriaExistenteException;
import Model.exception.CategoriaInexistenteException;
import Model.exception.ProductoNoEncontradoEnCategoriaException;
import Model.exception.ProductoNoEncontradoEnInventarioException;
import Model.producto.Producto;

import java.util.ArrayList;

public class Inventario {
    private final ArrayList<Categoria> CATEGORIAS;

    public Inventario(){
        CATEGORIAS = new ArrayList<>();
        CATEGORIAS.add(new Categoria("Sin Categoria"));
    }

    public void crearCategoria(String nombre) {
        try {
            obtenerCategoria(nombre);
            throw new CategoriaExistenteException();
        } catch (CategoriaInexistenteException e) {
            CATEGORIAS.add(new Categoria(nombre));
        }
    }

    public void cargarProducto(Producto producto, String nombreCategoria) {
        Categoria categoria = obtenerCategoria(nombreCategoria);
        categoria.agregarProducto(producto);
    }

    public void cargarProducto(Producto producto) {
        cargarProducto(producto, "Sin Categoria");
    }

    public void eliminarProducto(int ID) {
        for (Categoria categoria : CATEGORIAS) {
            try {
                categoria.eliminarProducto(ID);
                return;
            } catch (ProductoNoEncontradoEnCategoriaException ignored) {

            }
        }
        throw new ProductoNoEncontradoEnInventarioException();
    }

    public void eliminarCategoria(String nombre) {
        for (Categoria categoria : CATEGORIAS) {
            if (categoria.getNombre().equals(nombre)) {
                CATEGORIAS.remove(categoria);
                return;
            }
        }
        throw new CategoriaInexistenteException();
    }

    public Producto buscarProducto(int ID) {
        for (Categoria categoria : CATEGORIAS) {
            try {
                return categoria.buscarProducto(ID);
            } catch (ProductoNoEncontradoEnCategoriaException ignored) {

            }
        }
        throw new ProductoNoEncontradoEnInventarioException();
    }

    private Categoria obtenerCategoria(String nombre) {
        for (Categoria categoria : CATEGORIAS) {
            if (categoria.getNombre().equals(nombre)) {
                return categoria;
            }
        }
        throw new CategoriaInexistenteException();
    }

    public ArrayList<Producto> obtenerProductosSegunCriterio(Criterio criterio){
        ArrayList<Producto> productos = new ArrayList<>();
        for (Categoria categoria : CATEGORIAS) {
            productos.addAll(categoria.obtenerProductosSegunCriterio(criterio));
        }
        return criterio.sort(productos);
    }
}
