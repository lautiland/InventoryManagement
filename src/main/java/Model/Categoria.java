package Model;

import Model.criterio.Criterio;
import Model.exception.ProductoNoEncontradoEnCategoriaException;
import Model.producto.Producto;

import java.util.ArrayList;

public class Categoria {
    private final String NOMBRE;
    private final ArrayList<Producto> PRODUCTOS;

    public Categoria(String nombre) {
        NOMBRE = nombre;
        PRODUCTOS = new ArrayList<>();
    }

    public String getNombre(){
        return NOMBRE;
    }

    public void agregarProducto(Producto producto){
        PRODUCTOS.add(producto);
    }

    public void eliminarProducto(int ID){
        for (Producto producto : PRODUCTOS) {
            if(producto.getID() == ID){
                PRODUCTOS.remove(producto);
                return;
            }
        }
        throw new ProductoNoEncontradoEnCategoriaException();
    }

    public Producto buscarProducto(int ID){
        for (Producto producto : PRODUCTOS) {
            if(producto.getID() == ID){
                return producto;
            }
        }
        throw new ProductoNoEncontradoEnCategoriaException();
    }

    public ArrayList<Producto> obtenerProductosSegunCriterio(Criterio criterio){
        return criterio.sort(PRODUCTOS);
    }

}
