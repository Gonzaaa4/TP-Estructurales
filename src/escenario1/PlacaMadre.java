package escenario1;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un componente "Compuesto" (Composite).
 * Tiene un precio base y además contiene otros componentes.
 * Su precio total es la suma de su precio base más el de sus hijos.
 */
public class PlacaMadre implements Componente {

    private double precioBase;
    private List<Componente> componentesHijos;

    public PlacaMadre() {
        this.precioBase = 150; // Precio base de la Placa Madre 
        this.componentesHijos = new ArrayList<>();
    }

    /**
     * Añade un componente a la Placa Madre (ej. un CPU, una RAM) 
     */
    public void agregarComponente(Componente componente) {
        this.componentesHijos.add(componente);
    }

    @Override
    public double getPrecio() {
        // El precio total es el precio base de la placa...
        double precioTotal = this.precioBase;

        // ...más el precio de todos los componentes que tiene "pinchados"
        for (Componente hijo : componentesHijos) {
            precioTotal += hijo.getPrecio();
        }

        return precioTotal;
    }

    @Override
    public String getNombre() {
        return "Placa Madre";
    }
}