public class CafeBase implements Cafe {
    @Override
    public String descripcion() {
        return "Café base";
    }

    @Override
    public double precio() {
        return 3000;
    }
}