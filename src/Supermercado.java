import javax.swing.*;

public class Supermercado {

    private String nombre;

    private Producto[] inventario;

    private int porcientosDiscuento = 10;
    private int cantidadDeProductosParaTenerDiscuento = 3;

    public Supermercado(String nombre, int porcientosDiscuento, int cantidadDeProductosParaTenerDiscuento) {
        this.nombre = nombre;
        this.porcientosDiscuento = porcientosDiscuento;
        this.cantidadDeProductosParaTenerDiscuento = cantidadDeProductosParaTenerDiscuento;
        this.inventario = new Producto[0];
    }

    public String imprimirInventario() {
        String inventarioString = "Inventario:\n\n";
        for (int i = 0; i < inventario.length; i++) {
            inventarioString += inventario[i].imprimirProducto() + "\n";
        }
        return inventarioString;
    }

    public void agregar_producto(String nombreProducto, double precio, int cantidad){

        boolean agregado = false;
        for (int i = 0; i < inventario.length && !agregado; i++) {
            if(inventario[i] == null){
                inventario[i] = new Producto(nombreProducto, precio, cantidad, this);
                agregado = true;
            }else if(inventario[i].getNombre() == nombreProducto){
                inventario[i].aumentarCantidadEnStock(cantidad);
                inventario[i].setPrecio(precio);
                agregado = true;
            }
        }

        if(agregado){
            JOptionPane.showMessageDialog(null, "El producto fue agregado a Stock con exito");
        }else {
            Producto[] newInventario = new Producto[inventario.length + 1];
            for (int i = 0; i < inventario.length; i++) {
                newInventario[i] = inventario[i];
            }
            newInventario[inventario.length] = new Producto(nombreProducto, precio, cantidad, this);
            inventario = newInventario;
            JOptionPane.showMessageDialog(null, "El producto fue agregado a Stock con exito");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto[] getInventario() {
        return inventario;
    }

    public void setInventario(Producto[] inventario) {
        this.inventario = inventario;
    }

    public int getPorcientosDiscuento() {
        return porcientosDiscuento;
    }

    public void setPorcientosDiscuento(int porcientosDiscuento) {
        this.porcientosDiscuento = porcientosDiscuento;
    }

    public int getCantidadDeProductosParaTenerDiscuento() {
        return cantidadDeProductosParaTenerDiscuento;
    }

    public void setCantidadDeProductosParaTenerDiscuento(int cantidadDeProductosParaTenerDiscuento) {
        this.cantidadDeProductosParaTenerDiscuento = cantidadDeProductosParaTenerDiscuento;
    }


}
