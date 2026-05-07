import java.util.LinkedList;
import java.util.Queue;

// ====================================
// CLASE NODO DEL ÁRBOL
// ====================================
class Nodo {

    int dato;
    Nodo izquierda;
    Nodo derecha;

    // Constructor
    public Nodo(int valor) {
        dato = valor;
        izquierda = null;
        derecha = null;
    }
}

// =====================================
// CLASE PRINCIPAL
// =====================================
public class Main {

    // =====================================
    // FUNCIÓN PARA INSERTAR NODOS
    // =====================================
    public static Nodo insertar(Nodo raiz, int valor) {

        // Si el árbol está vacío
        if (raiz == null) {
            return new Nodo(valor);
        }

        // Insertar a la izquierda
        if (valor < raiz.dato) {
            raiz.izquierda = insertar(raiz.izquierda, valor);
        }
        // Insertar a la derecha
        else {
            raiz.derecha = insertar(raiz.derecha, valor);
        }

        return raiz;
    }

    // =====================================
    // RECORRIDO PREORDEN
    // Raíz -> Izquierda -> Derecha
    // =====================================
    public static void preorden(Nodo raiz) {

        if (raiz != null) {

            System.out.print(raiz.dato + " ");

            preorden(raiz.izquierda);

            preorden(raiz.derecha);
        }
    }

    // =====================================
    // RECORRIDO INORDEN
    // Izquierda -> Raíz -> Derecha
    // =====================================
    public static void inorden(Nodo raiz) {

        if (raiz != null) {

            inorden(raiz.izquierda);

            System.out.print(raiz.dato + " ");

            inorden(raiz.derecha);
        }
    }

    // =====================================
    // RECORRIDO POSTORDEN
    // Izquierda -> Derecha -> Raíz
    // =====================================
    public static void postorden(Nodo raiz) {

        if (raiz != null) {

            postorden(raiz.izquierda);

            postorden(raiz.derecha);

            System.out.print(raiz.dato + " ");
        }
    }

    // =====================================
    // RECORRIDO BFS (POR NIVELES)
    // =====================================
    public static void BFS(Nodo raiz) {

        // Verifica si el árbol está vacío
        if (raiz == null) {
            return;
        }

        Queue<Nodo> cola = new LinkedList<>();

        cola.add(raiz);

        while (!cola.isEmpty()) {

            Nodo actual = cola.poll();

            System.out.print(actual.dato + " ");

            // Agregar hijo izquierdo
            if (actual.izquierda != null) {
                cola.add(actual.izquierda);
            }

            // Agregar hijo derecho
            if (actual.derecha != null) {
                cola.add(actual.derecha);
            }
        }
    }

    // =====================================
    // CONTAR NODOS
    // =====================================
    public static int contarNodos(Nodo raiz) {

        // Árbol vacío
        if (raiz == null) {
            return 0;
        }

        // Cuenta:
        // 1 nodo actual +
        // nodos izquierda +
        // nodos derecha
        return 1 + contarNodos(raiz.izquierda)
                 + contarNodos(raiz.derecha);
    }

    // =====================================
    // CONTAR HOJAS
    // =====================================
    public static int contarHojas(Nodo raiz) {

        // Árbol vacío
        if (raiz == null) {
            return 0;
        }

        // Si no tiene hijos, es hoja
        if (raiz.izquierda == null &&
            raiz.derecha == null) {

            return 1;
        }

        // Contar hojas izquierda y derecha
        return contarHojas(raiz.izquierda)
             + contarHojas(raiz.derecha);
    }

    // =====================================
    // MÉTODO PRINCIPAL
    // =====================================
    public static void main(String[] args) {

        Nodo raiz = null;

        // =====================================
        // EJERCICIO 1
        // CREAR ÁRBOL ORIGINAL
        // =====================================

        raiz = insertar(raiz, 10);
        insertar(raiz, 5);
        insertar(raiz, 15);
        insertar(raiz, 2);
        insertar(raiz, 7);
        insertar(raiz, 12);
        insertar(raiz, 20);

        System.out.println("===== EJERCICIO 1 =====");

        System.out.print("Preorden: ");
        preorden(raiz);

        System.out.print("\nInorden: ");
        inorden(raiz);

        System.out.print("\nPostorden: ");
        postorden(raiz);

        System.out.print("\nBFS: ");
        BFS(raiz);

        // =====================================
        // EJERCICIO 2
        // AGREGAR NUEVOS NODOS
        // =====================================

        insertar(raiz, 1);
        insertar(raiz, 3);
        insertar(raiz, 18);
        insertar(raiz, 25);

        System.out.println("\n\n===== EJERCICIO 2 =====");

        System.out.print("Preorden: ");
        preorden(raiz);

        System.out.print("\nInorden: ");
        inorden(raiz);

        System.out.print("\nPostorden: ");
        postorden(raiz);

        System.out.print("\nBFS: ");
        BFS(raiz);

        // =====================================
        // EJERCICIO 3
        // CONTAR NODOS
        // =====================================

        System.out.println("\n\n===== EJERCICIO 3 =====");

        System.out.println("Cantidad total de nodos: "
                + contarNodos(raiz));

        // =====================================
        // EJERCICIO 4
        // CONTAR HOJAS
        // =====================================

        System.out.println("\n===== EJERCICIO 4 =====");

        System.out.println("Cantidad de hojas: "
                + contarHojas(raiz));

        // =====================================
        // EJERCICIO 5
        // EXPLICACIÓN TEÓRICA
        // =====================================

        System.out.println("\n===== EJERCICIO 5 =====");

        System.out.println("\n1. Mostrar el menú principal:");
        System.out.println("Se recomienda PREORDEN porque "
                + "primero muestra la raíz y luego "
                + "los submódulos.");

        System.out.println("\n2. Procesar primero "
                + "los módulos internos:");
        System.out.println("Se recomienda POSTORDEN "
                + "porque primero procesa los hijos "
                + "y después el nodo principal.");

        System.out.println("\n3. Mostrar módulos "
                + "nivel por nivel:");
        System.out.println("Se recomienda BFS porque "
                + "recorre el árbol por niveles.");
    }
}
