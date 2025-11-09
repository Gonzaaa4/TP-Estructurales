package escenario3;

/**
 * Clase principal (Cliente) que demuestra el uso del patrón Adapter.
 */
public class Main {

    public static void main(String[] args) {

        // El cliente (nuestro Main) solo conoce y depende de la interfaz interna.
        IServicioEnvio servicioDeEnvio;

        // Gracias al patrón Adapter, podemos "enchufar" la implementación
        // de la API externa sin que el cliente lo sepa.
        servicioDeEnvio = new LogisticaVelozAdapter(); // Asume que LogisticaVelozAdapter.java existe

        System.out.println("--- Probando el Adaptador de Logística ---");

        // El cliente usa los métodos de la interfaz interna
        String cp = "3350";
        float costo = servicioDeEnvio.calcularCosto(cp); 
        System.out.println("Costo de envío para " + cp + ": $" + costo);

        String tiempo = servicioDeEnvio.obtenerTiempoEstimado(cp); 
        System.out.println("Tiempo estimado: " + tiempo);

        String tracking = servicioDeEnvio.despacharPedido("Av. Corrientes 123", cp, "P-001");
        System.out.println("Número de Seguimiento: " + tracking);
    }
}
