
import java.util.*;

public class Reto5Cafe {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("cafeteria creativa \n");
        
        System.out.print("Número de cafés a personalizar: ");
        int numCafes = scanner.nextInt();
        scanner.nextLine();
        
        List<Cafe> cafes = new ArrayList<>();
        
        for (int i = 1; i <= numCafes; i++) {
            System.out.println("\n- Café " + i + "-");
            Cafe cafe = crearCafePersonalizado();
            cafes.add(cafe);
        }
        
        System.out.println("\nresumen de cafe\n");
        
        for (int i = 0; i < cafes.size(); i++) {
            Cafe cafe = cafes.get(i);
            System.out.println("Café " + (i + 1) + ":");
            System.out.println("Ingredientes: " + cafe.descripcion());
            System.out.printf("Precio total: $%.0f%n", cafe.precio());
            System.out.println();
        }
        
        double totalGeneral = cafes.stream()
                                   .mapToDouble(Cafe::precio)
                                   .sum();
        
        System.out.printf("Total a pagar por todos los cafés: $%.0f%n", totalGeneral);
        System.out.println("disfrute su café");
    }
    
    private static Cafe crearCafePersonalizado() {
        Cafe cafe = new CafeBase();
        
        mostrarMenuToppings();
        
        System.out.print("\nSeleccione toppings (números separados por coma): ");
        String input = scanner.nextLine();
        
        if (input.trim().isEmpty()) {
            return cafe;
        }
        
        String[] selecciones = input.split(",");
        
        for (String seleccion : selecciones) {
            int opcion = Integer.parseInt(seleccion.trim());
            cafe = agregarTopping(cafe, opcion);
        }
        
        return cafe;
    }
    
    private static void mostrarMenuToppings() {
        System.out.println("\nLista de toppings disponibles:");
        System.out.println("Opción Topping Precio");
        System.out.println("1 Leche $1.000");
        System.out.println("2 Chocolate $1.500");
        System.out.println("3 Caramelo $1.200");
        System.out.println("4 Crema Batida $2.000");
        System.out.println("5 Menta $1.300");
        System.out.println("6 Agregar nuevo topping Precio personalizado");
    }
    
    private static Cafe agregarTopping(Cafe cafe, int opcion) {
        switch (opcion) {
            case 1:
                return new Leche(cafe);
            case 2:
                return new Chocolate(cafe);
            case 3:
                return new Caramelo(cafe);
            case 4:
                return new CremaBatida(cafe);
            case 5:
                return new Menta(cafe);
            case 6:
                System.out.print("Ingrese nombre del nuevo topping: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese precio del topping: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();
                return new ToppingPersonalizado(cafe, nombre, precio);
            default:
                System.out.println("Opción inválida, se omite este topping.");
                return cafe;
        }
    }

    public static void main(String[] args) {
        ejecutar();
    }
}