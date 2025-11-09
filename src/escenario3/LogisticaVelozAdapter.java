package escenario3;

/**
 * Esta es la clase ADAPTER (Adaptador).
 * 1. Implementa la interfaz que tu sistema espera (IServicioEnvio).
 * 2. "Envuelve" (contiene) una instancia de la clase incompatible (ApiLogisticaVeloz).
 * 3. "Traduce" las llamadas de un sistema al otro.
 */
public class LogisticaVelozAdapter implements IServicioEnvio {

    // 2. Contiene la API que queremos adaptar
    private ApiLogisticaVeloz apiVeloz = new ApiLogisticaVeloz();

    @Override
    public float calcularCosto(String codigoPostal) {
        // 3. "Traduce" los tipos de datos
        int cpDestino = Integer.parseInt(codigoPostal);

        // Llama al método incompatible
        Cotizacion cotizacion = apiVeloz.cotizarEnvio(cpDestino); //

        // Devuelve el dato que tu interfaz espera
        return cotizacion.getCosto();
    }

    @Override
    public String obtenerTiempoEstimado(String codigoPostal) {
        int cpDestino = Integer.parseInt(codigoPostal);
        
        Cotizacion cotizacion = apiVeloz.cotizarEnvio(cpDestino); //
        
        return cotizacion.getDias() + " días";
    }

    @Override
    public String despacharPedido(String direccion, String codigoPostal, String idPedido) {
        // 3. "Traduce" los datos al objeto que la API espera
        int cp = Integer.parseInt(codigoPostal);
        

        DatosEnvio datos = new DatosEnvio(direccion, cp, idPedido); //
        
        // Llama al método incompatible
        return apiVeloz.enviarPaquete(datos);
    }
}
