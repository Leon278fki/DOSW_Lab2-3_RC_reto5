# Sistema de Personalización de Café - Patrón Decorator

## Escuela Colombiana de Ingeniería Julio Garavito
### Laboratorio 2 - Reto 5: Implementación del Patrón Decorator

---

## Autores
- **Camilo Alfonso Leon Acosta**
- **Roger Mauricio Duran Guacaneme**

**Fecha:** Febrero 2026  
**Asignatura:** Diseño y Organización de Sistemas de Software

---

## Descripción del Proyecto

El presente proyecto constituye una implementación práctica del **patrón de diseño Decorator** aplicado a un sistema de personalización de bebidas de café. El sistema permite a los usuarios crear configuraciones personalizadas de café mediante la adición dinámica de múltiples ingredientes (toppings), manteniendo la flexibilidad y extensibilidad del código sin recurrir a la herencia múltiple.

El patrón Decorator proporciona una alternativa flexible a la creación de subclases para extender funcionalidades, permitiendo agregar responsabilidades a objetos individuales de manera dinámica y transparente, sin afectar a otros objetos de la misma clase.

---

## Objetivos de Aprendizaje

1. Comprender e implementar el patrón de diseño estructural Decorator
2. Aplicar principios de diseño orientado a objetos (OOP)
3. Demostrar el uso de composición sobre herencia
4. Desarrollar un sistema extensible y mantenible
5. Implementar polimorfismo a través de interfaces

---

## Fundamentos Teóricos

### Patrón Decorator

El patrón Decorator pertenece a la categoría de patrones estructurales y tiene como propósito:

- **Intención:** Adjuntar responsabilidades adicionales a un objeto dinámicamente, proporcionando una alternativa flexible a la herencia para extender funcionalidades.

- **Problema que resuelve:** Cuando se requiere agregar funcionalidades a objetos individuales sin crear una explosión de subclases para cada combinación posible de características.

- **Estructura implementada:**
  - `Cafe` (Componente): Interfaz que define las operaciones base
  - `CafeBase` (Componente Concreto): Implementación básica del café
  - `ToppingDecorator` (Decorator): Clase abstracta que mantiene referencia al componente
  - Decoradores concretos: `Leche`, `Chocolate`, `Caramelo`, `CremaBatida`, `Menta`, `ToppingPersonalizado`

---

## Estructura del Proyecto

```
ElCafePersonalizado/
├── pom.xml                          # Configuración Maven
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── DuranLeon/
│   │               └── Reto5/
│   │                   ├── Cafe.java                    # Interfaz componente
│   │                   ├── CafeBase.java                # Componente concreto
│   │                   ├── ToppingDecorator.java        # Decorator abstracto
│   │                   ├── Leche.java                   # Decorator concreto
│   │                   ├── Chocolate.java               # Decorator concreto
│   │                   ├── Caramelo.java                # Decorator concreto
│   │                   ├── CremaBatida.java             # Decorator concreto
│   │                   ├── Menta.java                   # Decorator concreto
│   │                   ├── ToppingPersonalizado.java    # Decorator parametrizable
│   │                   └── Reto5Cafe.java               # Clase principal
│   └── test/
│       └── java/
│           └── com/
│               └── DuranLeon/
│                   └── Reto5/
│                       └── AppTest.java                 # Pruebas unitarias
└── README.md
```

---

## Descripción de Clases

### 1. `Cafe` (Interfaz)
Define el contrato para todos los objetos de café, especificando los métodos:
- `String descripcion()`: Retorna la descripción completa del café
- `double precio()`: Retorna el precio total del café

### 2. `CafeBase` (Componente Concreto)
Implementación básica de un café simple sin toppings.
- Precio base: $3.000
- Descripción: "Café base"

### 3. `ToppingDecorator` (Decorator Abstracto)
Clase abstracta que:
- Implementa la interfaz `Cafe`
- Mantiene una referencia al objeto `Cafe` que decora
- Delega las llamadas al componente envuelto
- Sirve como clase base para todos los decoradores concretos

### 4. Decoradores Concretos
Cada decorador extiende `ToppingDecorator` y añade:

| Topping | Precio Adicional | Clase |
|---------|------------------|-------|
| Leche | $1.000 | `Leche.java` |
| Chocolate | $1.500 | `Chocolate.java` |
| Caramelo | $1.200 | `Caramelo.java` |
| Crema Batida | $2.000 | `CremaBatida.java` |
| Menta | $1.300 | `Menta.java` |
| Personalizado | Variable | `ToppingPersonalizado.java` |

### 5. `ToppingPersonalizado`
Decorador especial que permite definir toppings dinámicos con:
- Nombre personalizado
- Precio configurable por el usuario

### 6. `Reto5Cafe` (Aplicación Principal)
Implementa la interfaz de usuario por consola permitiendo:
- Personalizar múltiples cafés en una sesión
- Seleccionar toppings de un menú
- Agregar toppings personalizados
- Calcular precios individuales y totales
- Generar resumen de pedidos

---

## Requisitos del Sistema

### Requisitos de Software
- **Java Development Kit (JDK):** 1.7 o superior
- **Apache Maven:** 3.6.0 o superior
- **Sistema Operativo:** Windows, Linux o macOS

### Dependencias
- JUnit 4.11 (para pruebas unitarias)

---

## Instalación y Ejecución

### 1. Clonar o Descargar el Proyecto
```bash
git clone <url-del-repositorio>
cd "reto 5/ElCafePersonalizado"
```

### 2. Compilar el Proyecto
```bash
mvn clean compile
```

### 3. Ejecutar la Aplicación
```bash
mvn exec:java -Dexec.mainClass="com.DuranLeon.Reto5.Reto5Cafe"
```

O alternativamente, compilar y empaquetar:
```bash
mvn package
java -cp target/ElCafePersonalizado-1.0.0.jar com.DuranLeon.Reto5.Reto5Cafe
```

### 4. Ejecutar Pruebas Unitarias
```bash
mvn test
```

---

## Ejemplo de Uso

### Interacción con el Sistema

```
cafeteria creativa 

Número de cafés a personalizar: 2

- Café 1-

Lista de toppings disponibles:
Opción Topping Precio
1 Leche $1.000
2 Chocolate $1.500
3 Caramelo $1.200
4 Crema Batida $2.000
5 Menta $1.300
6 Agregar nuevo topping Precio personalizado

Seleccione toppings (números separados por coma): 1,2,4

- Café 2-

Lista de toppings disponibles:
...

Seleccione toppings (números separados por coma): 3,5,6
Ingrese nombre del nuevo topping: Vainilla
Ingrese precio del topping: 1100

resumen de cafe

Café 1:
Ingredientes: Café base + Leche + Chocolate + Crema Batida
Precio total: $7500

Café 2:
Ingredientes: Café base + Caramelo + Menta + Vainilla
Precio total: $6800

Total a pagar por todos los cafés: $14300
disfrute su café
```

---

## Diagrama de Clases

```
┌─────────────┐
│   <<interface>>   │
│     Cafe    │
├─────────────┤
│+ descripcion(): String │
│+ precio(): double      │
└─────────────┘
       △
       │ implements
       ├──────────────────┬───────────────────┐
       │                  │                   │
┌──────────┐   ┌──────────────────┐   ┌──────────────────┐
│ CafeBase │   │ ToppingDecorator │   │                  │
├──────────┤   ├──────────────────┤   │                  │
│          │   │# cafe: Cafe      │   │                  │
│          │   │                  │   │                  │
└──────────┘   └──────────────────┘   │                  │
                       △               │                  │
                       │ extends       │                  │
        ┌──────────────┼───────────────┴──────┬───────────┤
        │              │              │       │           │
   ┌────────┐  ┌───────────┐  ┌──────────┐ ┌─────┐  ┌─────────────┐
   │ Leche  │  │ Chocolate │  │ Caramelo │ │ ... │  │ Topping     │
   │        │  │           │  │          │ │     │  │ Personalizado│
   └────────┘  └───────────┘  └──────────┘ └─────┘  └─────────────┘
```

---

## Principios de Diseño Aplicados

1. **Single Responsibility Principle (SRP):** Cada clase tiene una única responsabilidad bien definida.

2. **Open/Closed Principle (OCP):** El sistema está abierto para extensión (nuevos toppings) pero cerrado para modificación (no requiere cambios en código existente).

3. **Dependency Inversion Principle (DIP):** Las clases dependen de abstracciones (`Cafe` interface) no de implementaciones concretas.

4. **Composition over Inheritance:** Se utiliza composición para agregar funcionalidades dinámicamente.

5. **Interface Segregation:** La interfaz `Cafe` es simple y cohesiva, conteniendo solo los métodos necesarios.

---

## Ventajas de la Implementación

1. **Flexibilidad:** Permite combinar toppings en cualquier orden y cantidad
2. **Extensibilidad:** Agregar nuevos toppings no requiere modificar código existente
3. **Mantenibilidad:** Código organizado y fácil de entender
4. **Reutilización:** Los decoradores pueden aplicarse a cualquier implementación de `Cafe`
5. **Transparencia:** Los decoradores son transparentes para el cliente
6. **Granularidad:** Permite agregar funcionalidades de manera incremental

---

## Consideraciones Técnicas

### Complejidad Temporal
- Creación de café decorado: O(n), donde n es el número de toppings
- Cálculo de precio: O(n), debido a la cadena de delegación
- Generación de descripción: O(n)

### Aspectos de Mejora Potencial
1. Implementar persistencia de pedidos
2. Agregar validaciones de entrada más robustas
3. Implementar un sistema de descuentos o promociones
4. Crear interfaz gráfica (GUI)
5. Añadir más pruebas unitarias
6. Implementar logging para auditoría

---

## Conclusiones

La implementación del patrón Decorator en este sistema de personalización de café demuestra:

1. La efectividad del patrón para agregar funcionalidades de manera dinámica sin recurrir a herencia compleja
2. La importancia de diseñar sistemas extensibles y mantenibles
3. Cómo los patrones de diseño facilitan la resolución de problemas comunes en ingeniería de software
4. La aplicación práctica de principios SOLID en desarrollo de software
5. El valor de la composición como mecanismo de extensión de comportamiento

Este proyecto evidencia que el uso apropiado de patrones de diseño resulta en código más limpio, flexible y profesional, facilitando el mantenimiento y la evolución del sistema a largo plazo.

---

## Referencias

- Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
- Freeman, E., & Freeman, E. (2004). *Head First Design Patterns*. O'Reilly Media.
- Martin, R. C. (2017). *Clean Architecture: A Craftsman's Guide to Software Structure and Design*. Prentice Hall.
- Oracle. (2023). *The Java™ Tutorials - Design Patterns*. https://docs.oracle.com/javase/tutorial/

---
