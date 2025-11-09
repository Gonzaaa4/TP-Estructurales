package escenario1;

/**
 * Representa otro componente "Hoja" (Leaf).
 * Es un producto individual con un precio fijo.
 */
public class MemoriaRAM implements Componente {

    private double precio;

    public MemoriaRAM() {
        this.precio = 80; // Precio base de la Memoria RAM
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    @Override
    public String getNombre() {
        return "Memoria RAM";
    }
}
