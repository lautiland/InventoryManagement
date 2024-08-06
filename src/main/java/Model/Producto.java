package Model;

public class Producto {

    private final int ID;
    private String nombre;

    public Producto(String nombre, int id){
        this.nombre = nombre;
        ID = id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getID() {
        return ID;
    }
}
