package escenario1;

import java.util.ArrayList;
import java.util.List;

public class Gabinete implements Componente {
    private double precioBase = 120; 
    private List<Componente> componentes = new ArrayList<>();

    public void agregarComponente(Componente c) {
        componentes.add(c);
    }

    public double getPrecio() {
        double precioTotal = precioBase;
        for (Componente c : componentes) {
            precioTotal += c.getPrecio();
        }
        return precioTotal;
    }
    public String getNombre() { return "Gabinete"; }
}
