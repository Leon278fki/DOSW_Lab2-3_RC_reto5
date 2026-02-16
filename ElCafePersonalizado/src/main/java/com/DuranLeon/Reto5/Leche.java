public class Leche extends ToppingDecorator {
    public Leche(Cafe cafe) { super(cafe); }

    @Override
    public String descripcion() {
        return cafe.descripcion() + " + Leche";
    }

    @Override
    public double precio() {
        return cafe.precio() + 1000;
    }
}