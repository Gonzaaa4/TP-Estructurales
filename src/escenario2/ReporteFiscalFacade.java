package escenario2;


public class ReporteFiscalFacade {
    // El Facade "esconde" la complejidad del subsistema
    private ConectorDB conector = new ConectorDB();
    private LectorDeDatos lector = new LectorDeDatos();
    private ServicioWebAFIP afip = new ServicioWebAFIP();
    private ProcesadorDeImpuestos procesador = new ProcesadorDeImpuestos();
    private RenderizadorPDF renderizador = new RenderizadorPDF();

    // Método simple para el cliente
    public void generarReporte(String cuit) {
        System.out.println("Iniciando generación de reporte para CUIT: " + cuit);
        conector.conectar(); // Paso 1 
        lector.obtenerDatosCliente(cuit); // Paso 2 (simplificado)
        afip.autenticar(); // Paso 3 
        Object datosFiscales = afip.obtenerDatosFiscales(cuit); // Paso 4 
        Object montos = procesador.calcularImpuestos(datosFiscales); // Paso 5
        renderizador.generarPDF(montos); // Paso 6
        System.out.println("Reporte PDF generado exitosamente.");
    }
}
