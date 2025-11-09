package escenario1;

public class ServicioInstalacion extends ExtraDecorator {
    public ServicioInstalacion(Componente componente) {
        super(componente);
    }

    @Override
    public double getPrecio() {
        // Añade un costo fijo de $50 
        return super.getPrecio() + 50;
    }
}
