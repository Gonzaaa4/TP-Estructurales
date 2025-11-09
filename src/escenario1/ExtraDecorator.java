package escenario1;


public abstract class ExtraDecorator implements Componente {
    protected Componente componenteDecorado;

    public ExtraDecorator(Componente componente) {
        this.componenteDecorado = componente;
    }

    public double getPrecio() {
        return componenteDecorado.getPrecio();
    }
    public String getNombre() {
        return componenteDecorado.getNombre();
    }
}
