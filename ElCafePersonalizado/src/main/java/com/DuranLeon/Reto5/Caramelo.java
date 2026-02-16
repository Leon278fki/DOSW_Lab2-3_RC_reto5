public class Caramelo extends ToppingDecorator {
    public Caramelo(Cafe cafe) { super(cafe); }

    @Override
    public String descripcion() {
        return cafe.descripcion() + " + Caramelo";
    }

    @Override
    public double precio() {
        return cafe.precio() + 1200;
    }
}