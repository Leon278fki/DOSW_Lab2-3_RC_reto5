public class Chocolate extends ToppingDecorator {
    public Chocolate(Cafe cafe) { super(cafe); }

    @Override
    public String descripcion() {
        return cafe.descripcion() + " + Chocolate";
    }

    @Override
    public double precio() {
        return cafe.precio() + 1500;
    }
}