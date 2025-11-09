package escenario2;

/**
 * Simula un componente del subsistema complejo.
 * Se encarga de leer información de un cliente.
 */
public class LectorDeDatos {

    public String obtenerDatosCliente(String cuit) {
        System.out.println("2. Leyendo datos del cliente para CUIT: " + cuit);
        // Simula que encontró el CUIT y devuelve datos asociados
        return "Datos del Cliente (ID: 123)";
    }
}
