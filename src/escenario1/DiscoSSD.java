package escenario1;


/**
 * Representa un componente "Hoja" (Leaf) en el patrón Composite.
 * Es un producto individual con un precio fijo.
 */
public class DiscoSSD implements Componente {

    private double precio;

    public DiscoSSD() {
        this.precio = 100; // Precio base del DiscoSSD 
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    @Override
    public String getNombre() {
        return "Disco SSD";
    }
}
