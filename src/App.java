import java.util.Scanner;
import java.util.InputMismatchException;

public class App {

    public static int tamv = 0;
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        // Se eliminó 'throws Exception' porque ahora se manejan las excepciones dentro de los métodos.

        boolean condicionSalida = true;

        do {
            try {
                // Se solicita al usuario ingresar el tamaño del arreglo con las condiciones dadas.
                System.out.println("Ingrese el tamaño del arreglo que no supere los 16 y sea mayor a 1 y que tampoco sea negativo ");
                tamv = leer.nextInt();
                // Se utiliza un operador ternario para determinar si el tamaño es válido y controlar el bucle.
                condicionSalida = (tamv >= 2 && tamv <= 16) ? false : true;
            } catch (InputMismatchException e) {
                // Se captura la excepción en caso de que no se ingrese un entero.
                System.out.println("Por favor, ingrese un número entero válido.");
                leer.nextLine(); // Limpiar el buffer del scanner
            }
        } while (condicionSalida);

        // Se llama al método llenado para obtener el arreglo lleno.
        int[] array = llenado();
        System.out.println("Arreglo original:");
        // Se muestra el arreglo original.
        mostrar(array);

        // Se invierte el arreglo y se almacena en una nueva variable.
        int[] arrayInvertido = invertirArreglo(array);
        System.out.println("Arreglo invertido:");
        // Se muestra el arreglo invertido.
        mostrar(arrayInvertido);
    }

    public static int[] llenado() {
        // Se crea un arreglo del tamaño especificado por el usuario.
        int[] arreglo = new int[tamv];
        for (int i = 0; i < arreglo.length; i++) {
            boolean entradaValida;
            do {
                entradaValida = true;
                try {
                    // Se solicita al usuario ingresar cada valor del arreglo.
                    System.out.println("Ingrese el valor [" + i + "]:");
                    arreglo[i] = leer.nextInt();
                } catch (InputMismatchException e) {
                    // Se captura la excepción en caso de que no se ingrese un entero.
                    System.out.println("Por favor, ingrese un número entero válido.");
                    leer.nextLine(); // Limpiar el buffer del scanner
                    entradaValida = false;
                }
            } while (!entradaValida); // Se repite hasta que se ingrese un valor válido.
        }
        return arreglo; // Se retorna el arreglo lleno.
    }

    public static int[] invertirArreglo(int[] arreglo) {
        // Se crea un nuevo arreglo para almacenar los valores invertidos.
        int[] arregloInvertido = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            // Se llena el nuevo arreglo con los elementos del original en orden inverso.
            arregloInvertido[i] = arreglo[arreglo.length - 1 - i];
        }
        return arregloInvertido; // Se retorna el arreglo invertido.
    }

    public static void mostrar(int[] arreglo) {
        // Se recorre el arreglo y se imprime cada valor.
        for (int valor : arreglo) {
            System.out.println(valor);
        }
    }
}
