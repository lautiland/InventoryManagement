package Model;

import Model.exception.ObjetoNoEncontradoEnCategoriaException;

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

    public Producto buscarProducto(int ID){
        for (Producto producto : PRODUCTOS) {
            if(producto.getID() == ID){
                return producto;
            }
        }
        throw new ObjetoNoEncontradoEnCategoriaException();
    }

}
