package escenario3;

/**
 * Clase auxiliar requerida por 'ApiLogisticaVeloz'.
 * Contiene la información necesaria para el método 'enviarPaquete'.
 * NO SE PUEDE MODIFICAR.
 */
public class DatosEnvio {
    private String direccion;
    private int cpDestino;
    private String idPedido;

    public DatosEnvio(String direccion, int cpDestino, String idPedido) {
        this.direccion = direccion;
        this.cpDestino = cpDestino;
        this.idPedido = idPedido;
    }

    public String getDireccion() {
        return direccion;
    }
    
    // Otros getters que la API interna podría necesitar...
    public int getCpDestino() { return cpDestino; }
    public String getIdPedido() { return idPedido; }
}
