package escenario3;

/**
 * Clase de la librería externa del proveedor LogísticaVeloz.
 * Esta es la clase "Adaptee" (la que necesita ser adaptada).
 */
public class ApiLogisticaVeloz {

    /**
     * Método incompatible: usa 'int' para CP y devuelve un objeto Cotizacion.
     */
    public Cotizacion cotizarEnvio(int cpDestino) {
        System.out.println("API Veloz: Cotizando para CP: " + cpDestino);
        // ... lógica interna compleja ... 
        // Simula la respuesta de la API
        return new Cotizacion(150.50f, 2); 
    }

    /**
     * Método incompatible: requiere un objeto DatosEnvio.
     */
    public String enviarPaquete(DatosEnvio datos) { 
        System.out.println("API Veloz: Procesando envío para " + datos.getDireccion());
        // ... lógica interna compleja para procesar el envío ... 
        // Devuelve un número de tracking 
        return "LV-987654321"; 
    }
}
