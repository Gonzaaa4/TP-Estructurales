package escenario1;

public class GarantiaExtendida extends ExtraDecorator {
    public GarantiaExtendida(Componente componente) {
        super(componente);
    }

    @Override
    public double getPrecio() {
        // Añade un 10% al costo total 
        return super.getPrecio() * 1.10;
    }
}
