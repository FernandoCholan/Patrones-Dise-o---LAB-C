import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Mochila {
    
    public static void main(String[] args) {
        // Crear los objetos predefinidos
        Objeto[] objetos = {
            new Objeto("Botella de agua", "Cilíndrica", 1000, 500),
            new Objeto("Cuaderno", "Rectangular", 200, 200),
            new Objeto("Lápiz", "Cilíndrico", 10, 10),
            new Objeto("Mochila pequeña", "Rectangular", 3000, 800),
            new Objeto("Botiquín", "Rectangular", 2000, 300),
            new Objeto("Gafas de sol", "Rectangular", 100, 50),
            new Objeto("Laptop", "Rectangular", 2000, 1500),
            new Objeto("Teléfono móvil", "Rectangular", 100, 200),
            new Objeto("Bocadillo", "Rectangular", 100, 150),
            new Objeto("Paquete de pañuelos", "Rectangular", 100, 100),
            new Objeto("Linterna", "Cilíndrica", 100, 150),
            new Objeto("Cargador portátil", "Rectangular", 100, 300),
            new Objeto("Paraguas plegable", "Cilíndrico", 100, 400),
            new Objeto("Cartera", "Rectangular", 100, 100),
            new Objeto("Llaves", "Irregular", 100, 50),
            new Objeto("Cámara", "Rectangular", 100, 600),
            new Objeto("Protector solar", "Cilíndrico", 100, 200),
            new Objeto("Auriculares", "Irregular", 100, 100),
            new Objeto("Libro", "Rectangular", 100, 500),
            new Objeto("Estuche de lápices", "Rectangular", 100, 200)
        };

        // Mostrar los objetos disponibles con toda la información
        System.out.println("Objetos disponibles para colocar en la mochila:");
        for (int i = 0; i < objetos.length; i++) {
            Objeto objeto = objetos[i];
            System.out.println((i + 1) + ". Nombre: " + objeto.nombre + ", Forma: " + objeto.forma + ", Peso: " + objeto.peso + " kg, Precio: $" + objeto.precio);
        }

        // Solicitar al usuario el peso deseado de la mochila en gramos
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el peso deseado de la mochila (en gramos): ");
        int capacidadMochila = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        // Crear una mochila para almacenar los objetos seleccionados
        List<Objeto> mochila = new ArrayList<>();
        int pesoMochila = 0;
        int precioTotal = 0;

        // Permitir al usuario seleccionar objetos hasta que la mochila esté llena
        System.out.println("Seleccione al menos 15 objetos que desea colocar en la mochila separados por comas (0 para salir):");
        while (true) {
            System.out.print("Objetos seleccionados: ");
            String seleccion = scanner.nextLine().trim();
            String[] opciones = seleccion.split(",");
            if (opciones.length < 15) {
                System.out.println("Debe seleccionar al menos 15 objetos. Inténtelo de nuevo.");
                continue;
            }
            pesoMochila = 0; // Reiniciar el peso de la mochila
            precioTotal = 0; // Reiniciar el precio total
            mochila.clear(); // Limpiar la mochila
            for (String opcionString : opciones) {
                try {
                    int opcion = Integer.parseInt(opcionString.trim());
                    if (opcion == 0) {
                        break;
                    } else if (opcion < 1 || opcion > objetos.length) {
                        System.out.println("Opción inválida: " + opcion + ". Ignorada.");
                        continue;
                    }
                    Objeto objetoSeleccionado = objetos[opcion - 1];
                    if (pesoMochila + objetoSeleccionado.peso > capacidadMochila) {
                        System.out.println("La mochila está llena. No se puede agregar más.");
                        break;
                    }
                    mochila.add(objetoSeleccionado); // Agregar objeto a la mochila
                    pesoMochila += objetoSeleccionado.peso;
                    precioTotal += objetoSeleccionado.precio;
                } catch (NumberFormatException e) {
                    System.out.println("Formato de entrada inválido: " + opcionString + ". Ignorada.");
                }
            }
            if (pesoMochila <= capacidadMochila || opciones[0].equals("0")) {
                break;
            }
        }

        // Mostrar resumen de la mochila
        System.out.println("\nResumen de la mochila:");
        System.out.println("Peso total de la mochila: " + pesoMochila + " gramos");
        System.out.println("Precio total de los objetos: $" + precioTotal);

        // Mostrar información detallada de los objetos en la mochila
        System.out.println("\nObjetos en la mochila:");
        for (Objeto objeto : mochila) {
            System.out.println("Nombre: " + objeto.nombre + ", Forma: " + objeto.forma + ", Peso: " + objeto.peso + " gramos, Precio: $" + objeto.precio);
        }
    }
    }
    
