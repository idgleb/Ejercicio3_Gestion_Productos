

public class Producto {

    private String nombre;

    private double precio;

    private int cantidadEnStock;

    private Supermercado supermercado;

    public Producto(String nombre, double precio, int cantidadEnStock, Supermercado supermercado) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.supermercado = supermercado;
    }

    public String imprimirProducto() {
        String productoString = "";
        productoString = "Producto: " + nombre + "\n";
        productoString += "Precio: " + precio + "\n";
        productoString += "Cantidad En Stock: " + cantidadEnStock + "\n\n";
        return productoString;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public void aumentarCantidadEnStock(int cantidad) {
        this.cantidadEnStock += cantidad;
    }

    public void desminuirCantidadEnStock(int cantidad) {
        this.cantidadEnStock -= cantidad;
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }
}
