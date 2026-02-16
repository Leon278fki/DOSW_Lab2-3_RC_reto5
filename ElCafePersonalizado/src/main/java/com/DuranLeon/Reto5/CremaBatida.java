public class CremaBatida extends ToppingDecorator {
    public CremaBatida(Cafe cafe) { 
        super(cafe); 
    }

    @Override
    public String descripcion() {
        return cafe.descripcion() + " + Crema Batida";
    }

    @Override
    public double precio() {
        return cafe.precio() + 2000;
    }
}