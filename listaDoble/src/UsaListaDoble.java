import java.util.Scanner;

public class UsaListaDoble {

    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();
        lista.insertaPrimerNodo("R");
        lista.imprimir();
        lista.insertaPrimerNodo("F");
        lista.imprimir();
        System.out.println(lista);
        lista.insertaAntesPrimerNodo("H");
        System.out.println(lista);
        lista.insertaAlFinal("Z");
        System.out.println(lista);
        lista.insertaEntreNodos("T", "R");
        System.out.println(lista);
        lista.insertaAntesPrimerNodo("K");
        System.out.println(lista);
        lista.insertaAlFinal("Ñ");
        System.out.println(lista);
//        lista.borrarPrimerNodo();
//        System.out.println(lista);
//        lista.borrarUltimoNodo();
//        System.out.println(lista);
//        lista.borrarCualquierNodo("R");
        System.out.println("Lista actual de contenido: ");
        System.out.println(lista);

        
        MenuExample menuExample = new MenuExample(lista);

        // Llamar al método para ejecutar el menú
        menuExample.ejecutarMenu();
    }
}

class MenuExample {
    Scanner scanner = new Scanner(System.in);
    char opcion;
    ListaDoble lista;

    // Constructor que recibe la referencia de la lista
    public MenuExample(ListaDoble lista) {
        this.lista = lista;
    }

    public void ejecutarMenu() {
        do {
            System.out.println("---------------------------------------------------------");
            System.out.println("a. Buscar un nodo por su posición.");
            System.out.println("b. Insertar un nuevo nodo antes del último");
            System.out.println("c. Intercambiar un nodo por otro buscado");
            System.out.println("d. Salir");
            System.out.println("Seleccione una opción:");

            try {
                opcion = scanner.next().charAt(0);
            } catch (Exception e) {
                System.out.println("Error al leer la opción. Intente de nuevo.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                continue; // Volver al inicio del bucle
            }

            switch (opcion) {
                case 'a':
                    System.out.println("Ingrese la posición del nodo que desea buscar:");
                    int posicionBusqueda = scanner.nextInt();

                    Node nodoEnPosicion = lista.buscarPorPosicion(posicionBusqueda);

                    if (nodoEnPosicion != null) {
                        System.out.println("Nodo encontrado en la posición " + posicionBusqueda + ": " + nodoEnPosicion.name);
                    } else {
                        System.out.println("No se encontró un nodo en la posición especificada.");
                    }
                    break;

                case 'b':
                    // Solicitar al usuario el contenido del nuevo nodo
                    System.out.println("Ingrese el contenido del nuevo nodo:");
                    scanner.nextLine(); // Consumir la línea en blanco después de nextInt
                    String contenidoNuevoNodo = scanner.nextLine();

                    // Insertar el nuevo nodo antes del último
                    lista.insertaNodoAntesUltimo(contenidoNuevoNodo);

                    // Imprimir la lista actualizada
                    lista.imprimir();
                    break;

                    
                case 'c':
                   // Solicitar al usuario los nombres de los nodos a intercambiar
                        System.out.println("Ingrese el contenido del primer nodo");
                        String nodo1 = scanner.next();

                        System.out.println("Ingrese el nombre del segundo nodo: ");
                        String nodo2 = scanner.next();

                        // Intercambiar los nodos
                        lista.intercambiarNodos(nodo1, nodo2);
                        
                        // Imprimir la lista actualizada
                        System.out.println("Lista actual de contenido:");
                        lista.imprimir();
                    break;

                case 'd':
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 'd');

        scanner.close();
    }
}

