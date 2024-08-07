package Model;

public class Producto {

    private final int ID;
    private final Fecha INGRESO;
    private final String NOMBRE;
    private double precio;
    private int stock;

    public Producto(String nombre, int id, double precio, Fecha ingreso, int stock){
        this.NOMBRE = nombre;
        ID = id;
        this.precio = precio;
        this.INGRESO = ingreso;
        this.stock = stock;
    }
    public Producto(String nombre, int id, double precio){
        this.NOMBRE = nombre;
        ID = id;
        this.precio = precio;
        INGRESO = new Fecha();
        this.stock = 0;
    }

    public String getNombre(){
        return this.NOMBRE;
    }

    public int getID() {
        return ID;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public Fecha getIngreso(){
        return this.INGRESO;
    }

    public int getStock(){
        return this.stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

}
