
import javax.swing.*;

public class Super {
    public static void main(String[] args) {

        Supermercado supermercado = new Supermercado("COTO", 10, 3);

        CarritoCompras carritoCompras = new CarritoCompras("Milei", supermercado);

        int seleccion = 0;
        do {
            String[] opciones = {"Agregar producto a Stock", "Inventario", "Agregar producto a Carrito", "Mostrar Carrito", "Salir"};
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Supermercado COTO\n"
                            + supermercado.imprimirInventario()
                            + carritoCompras.imprimirCarrito(),
                    "Ursol",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch (seleccion) {
                case 0:
                    //Agregar producto a Stock
                    String nombreProducto = JOptionPane.showInputDialog("Producto?");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("precio?"));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("cantidad?"));
                    supermercado.agregar_producto(nombreProducto, precio, cantidad);
                    break;
                case 1:
                    //Inventario
                    JOptionPane.showMessageDialog(null, supermercado.imprimirInventario());
                    break;
                case 2:
                    //Agregar producto a Carrito
                    String nombreProducto1 = JOptionPane.showInputDialog("Producto?");
                    int cantidad1 = Integer.parseInt(JOptionPane.showInputDialog("cantidad?"));
                    carritoCompras.agregar_producto(nombreProducto1, cantidad1);
                    break;
                case 3:
                    //Mostrar Carrito
                    JOptionPane.showMessageDialog(null,carritoCompras.imprimirCarrito());
                    break;
                case 4:
                    //Salir
                    break;
                default:
                    break;
            }
        } while (seleccion != 4);


    }
}