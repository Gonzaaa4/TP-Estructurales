package escenario3;

/**
 * Interfaz interna de tu sistema de E-Commerce.
 * Define los métodos que tu aplicación espera para manejar envíos.
 */
public interface IServicioEnvio {

    /**
     * Calcula el costo de envío basado en un código postal.
     * @param codigoPostal El CP de destino.
     * @return El costo del envío.
     */
    float calcularCosto(String codigoPostal); 

    /**
     * Obtiene el tiempo estimado de entrega.
     * @param codigoPostal El CP de destino.
     * @return Una cadena de texto con la estimación (ej: "2 días").
     */
    String obtenerTiempoEstimado(String codigoPostal); 

    /**
     * Procesa y despacha un pedido.
     * @param direccion Dirección de entrega.
     * @param codigoPostal CP de destino.
     * @param idPedido ID único del pedido.
     * @return Un código de seguimiento (tracking).
     */
    String despacharPedido(String direccion, String codigoPostal, String idPedido); 
}
