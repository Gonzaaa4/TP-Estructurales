package escenario2;

/**
 * Clase principal (Cliente) que demuestra el uso del patrón Facade.
 * Observa lo simple que es para el cliente generar un reporte,
 * no necesita conocer las 5 clases del subsistema.
 */
public class Main {

    public static void main(String[] args) {
        
        // El cliente solo instancia el Facade
        ReporteFiscalFacade reporteador = new ReporteFiscalFacade();

        // Y llama a un único método simple
        String cuitCliente = "20-12345678-9";
        reporteador.generarReporte(cuitCliente);
    }
}
