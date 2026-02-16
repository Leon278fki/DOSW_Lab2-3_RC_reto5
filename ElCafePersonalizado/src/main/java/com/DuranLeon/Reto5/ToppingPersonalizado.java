public class ToppingPersonalizado extends ToppingDecorator {
    private String nombre;
    private double costo;

    public ToppingPersonalizado(Cafe cafe, String nombre, double costo) {
        super(cafe);
        this.nombre = nombre;
        this.costo = costo;
    }

    @Override
    public String descripcion() {
        return cafe.descripcion() + " + " + nombre;
    }

    @Override
    public double precio() {
        return cafe.precio() + costo;
    }
}