public class Menta extends ToppingDecorator {
    public Menta(Cafe cafe) { 
        super(cafe); 
    }

    @Override
    public String descripcion() {
        return cafe.descripcion() + " + Menta";
    }

    @Override
    public double precio() {
        return cafe.precio() + 1300;
    }
}