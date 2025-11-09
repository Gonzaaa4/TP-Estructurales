package escenario3;

/**
 * Clase auxiliar requerida por 'ApiLogisticaVeloz'.
 * Representa el resultado de una cotización.
 * NO SE PUEDE MODIFICAR.
 */
public class Cotizacion {
    private float costo;
    private int dias;

    public Cotizacion(float costo, int dias) { 
        this.costo = costo;
        this.dias = dias;
    }

    public float getCosto() {
        return costo;
    }

    public int getDias() {
        return dias;
    }
}
