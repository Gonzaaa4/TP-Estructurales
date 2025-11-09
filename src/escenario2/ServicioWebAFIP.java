package escenario2;

/**
 * Simula un componente del subsistema complejo.
 * Se encarga de conectarse a un servicio web externo (AFIP).
 */
public class ServicioWebAFIP {

    public void autenticar() {
        System.out.println("3. Autenticando con el Servicio Web de AFIP...");
    }

    public Object obtenerDatosFiscales(String cuit) {
        System.out.println("4. Obteniendo datos fiscales de AFIP para CUIT: " + cuit);
        // Devuelve un objeto simulado con la información fiscal
        return new Object(); // Simboliza "DatosFiscales"
    }
}
