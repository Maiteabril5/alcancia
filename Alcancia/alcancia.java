import java.util.ArrayList;
import java.util.List;

class Producto {
    private String nombre;
    private double precioBase;
    private String tipo;

    public Producto(String nombre, double precioBase, String tipo) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.tipo = tipo;
    }

    public double calcularPrecioFinal() {
        double tasaIVA = 0;
        switch (tipo) {
            case "supermercado": tasaIVA = 0.04; break;
            case "droguería": tasaIVA = 0.12; break;
            case "papelería": tasaIVA = 0.16; break;
        }
        return precioBase * (1 + tasaIVA);
    }

    public String getDescripcion() {
        return nombre + " con precio final de $" + calcularPrecioFinal();
    }
}

class Alcancia {
    private List<Producto> productos;

    public Alcancia() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularPrecioFinal();
        }
        return total;
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto.getDescripcion());
        }
    }
}

public class alcancia {
    public static void main(String[] args) {
        Alcancia alcancia = new Alcancia();

        Producto p1 = new Producto("Leche", 3000, "supermercado");
        Producto p2 = new Producto("LOratadina", 2000, "droguería");
        Producto p3 = new Producto("Cuadernos", 5000, "papelería");
        Producto p4 = new Producto("Yogurt", 2500, "supermercado");
        Producto p5 = new Producto("Fruta", 7500, "supermercado");

        alcancia.agregarProducto(p1);
        alcancia.agregarProducto(p2);
        alcancia.agregarProducto(p3);
        alcancia.agregarProducto(p4);
        alcancia.agregarProducto(p5);

        alcancia.mostrarProductos();
        System.out.println("Total de precios finales: $" + alcancia.calcularTotal());
    }
}
