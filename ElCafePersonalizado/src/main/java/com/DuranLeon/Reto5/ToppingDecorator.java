public abstract class ToppingDecorator implements Cafe {
    protected Cafe cafe;

    public ToppingDecorator(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public String descripcion() {
        return cafe.descripcion();
    }

    @Override
    public double precio() {
        return cafe.precio();
    }
}