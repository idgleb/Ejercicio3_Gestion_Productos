
import javax.swing.*;

public class CarritoCompras {
    private String nombreCliente;
    private Producto[] productos;
    private int[] cantidadProductosEnCarrito;
    private Supermercado supermercado;

    public CarritoCompras(String nombreCliente, Supermercado supermercado) {
        this.nombreCliente = nombreCliente;
        this.productos = new Producto[0];
        this.cantidadProductosEnCarrito = new int[0];
        this.supermercado = supermercado;
    }

    public double calcularTotalCompra() {
        double total = 0;
        int totalCantidadProductos = 0;
        for (int i = 0; i < productos.length; i++) {
            total += productos[i].getPrecio()*cantidadProductosEnCarrito[i];
            totalCantidadProductos += cantidadProductosEnCarrito[i];
        }
        if (totalCantidadProductos >= this.getSupermercado().getCantidadDeProductosParaTenerDiscuento()) {
            total = total - total/this.getSupermercado().getPorcientosDiscuento();
        }
        return total;
    }

    public String imprimirCarrito() {
        String caritoString = "Productos en carrito:\n";
        caritoString += "_______________________\n";
        for (int i = 0; i < productos.length; i++) {
            caritoString += productos[i].imprimirProducto();
            caritoString += "Cantidad en carrito: " + cantidadProductosEnCarrito[i] + "\n";
            caritoString += "_______________________\n";
        }
        caritoString += "\n Total: " + calcularTotalCompra();
        return caritoString;
    }

    public boolean agregar_producto(String nombreProducto, int cantidad) {

        Producto[] inventario = this.getSupermercado().getInventario();

        int posicion = -1;
        for (int i = 0; i < inventario.length && posicion == -1; i++) {
            if (inventario[i].getNombre() != null) {
                if (inventario[i].getNombre().equals(nombreProducto)) posicion = i;
            }
        }

        if (posicion == -1) {
            JOptionPane.showMessageDialog(null, "El producto No existe en el Stock");
            return false;
        }

        if (cantidad > inventario[posicion].getCantidadEnStock()) {
            JOptionPane.showMessageDialog(null, "No suficiente productos en el Stock, elige menos");
            return false;
        }

        boolean agregado = false;
        for (int i = 0; i < productos.length && !agregado; i++) {
            if (nombreProducto.equals(productos[i].getNombre())) {
                cantidadProductosEnCarrito[i] += cantidad;
                inventario[posicion].desminuirCantidadEnStock(cantidad);
                agregado = true;
            }
        }

        if (agregado) {
            JOptionPane.showMessageDialog(null, "El producto fue agregado a CARRITO con exito");
        } else {
            Producto[] newProductos = new Producto[productos.length + 1];
            int[] newCantidadProductosEnCarrito = new int[cantidadProductosEnCarrito.length +1];
            for (int i = 0; i < productos.length; i++) {
                newProductos[i] = productos[i];
                newCantidadProductosEnCarrito[i] = cantidadProductosEnCarrito[i];
            }
            newProductos[productos.length] = inventario[posicion];
            newCantidadProductosEnCarrito[productos.length] = cantidad;
            inventario[posicion].desminuirCantidadEnStock(cantidad);
            productos = newProductos;
            cantidadProductosEnCarrito = newCantidadProductosEnCarrito;
            JOptionPane.showMessageDialog(null, "El producto fue agregado a CARRITO con exito");
        }

        return true;

    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }
}
