#include <iostream>
#include <queue> // Librería para recorrido BFS
using namespace std;

// ===============================
// ESTRUCTURA DEL NODO DEL ÁRBOL
// ===============================
struct Nodo {
    int dato;
    Nodo* izquierda;
    Nodo* derecha;

    // Constructor
    Nodo(int valor) {
        dato = valor;
        izquierda = NULL;
        derecha = NULL;
    }
};

// ===================================
// FUNCIÓN PARA INSERTAR EN EL BST
// ===================================
Nodo* insertar(Nodo* raiz, int valor) {

    // Si el árbol está vacío, se crea el nodo
    if (raiz == NULL) {
        return new Nodo(valor);
    }

    // Si el valor es menor, va a la izquierda
    if (valor < raiz->dato) {
        raiz->izquierda = insertar(raiz->izquierda, valor);
    }
    // Si es mayor, va a la derecha
    else {
        raiz->derecha = insertar(raiz->derecha, valor);
    }

    return raiz;
}

// ===================================
// RECORRIDO PREORDEN
// Raíz -> Izquierda -> Derecha
// ===================================
void preorden(Nodo* raiz) {
    if (raiz != NULL) {
        cout << raiz->dato << " ";
        preorden(raiz->izquierda);
        preorden(raiz->derecha);
    }
}

// ===================================
// RECORRIDO INORDEN
// Izquierda -> Raíz -> Derecha
// ===================================
void inorden(Nodo* raiz) {
    if (raiz != NULL) {
        inorden(raiz->izquierda);
        cout << raiz->dato << " ";
        inorden(raiz->derecha);
    }
}

// ===================================
// RECORRIDO POSTORDEN
// Izquierda -> Derecha -> Raíz
// ===================================
void postorden(Nodo* raiz) {
    if (raiz != NULL) {
        postorden(raiz->izquierda);
        postorden(raiz->derecha);
        cout << raiz->dato << " ";
    }
}

// ===================================
// RECORRIDO BFS (POR NIVELES)
// ===================================
void BFS(Nodo* raiz) {

    // Verifica si el árbol está vacío
    if (raiz == NULL) {
        return;
    }

    queue<Nodo*> cola;
    cola.push(raiz);

    while (!cola.empty()) {

        Nodo* actual = cola.front();
        cola.pop();

        cout << actual->dato << " ";

        // Insertar hijo izquierdo
        if (actual->izquierda != NULL) {
            cola.push(actual->izquierda);
        }

        // Insertar hijo derecho
        if (actual->derecha != NULL) {
            cola.push(actual->derecha);
        }
    }
}

// ===================================
// FUNCIÓN PARA CONTAR NODOS
// ===================================
int contarNodos(Nodo* raiz) {

    // Si está vacío
    if (raiz == NULL) {
        return 0;
    }

    // Cuenta:
    // 1 (nodo actual) +
    // nodos izquierda +
    // nodos derecha
    return 1 + contarNodos(raiz->izquierda)
             + contarNodos(raiz->derecha);
}

// ===================================
// FUNCIÓN PARA CONTAR HOJAS
// ===================================
int contarHojas(Nodo* raiz) {

    // Si está vacío
    if (raiz == NULL) {
        return 0;
    }

    // Si no tiene hijos, es hoja
    if (raiz->izquierda == NULL &&
        raiz->derecha == NULL) {
        return 1;
    }

    // Contar hojas izquierda y derecha
    return contarHojas(raiz->izquierda)
         + contarHojas(raiz->derecha);
}

// ===================================
// FUNCIÓN PRINCIPAL
// ===================================
int main() {

    Nodo* raiz = NULL;

    // ===================================
    // EJERCICIO 1
    // CREACIÓN DEL ÁRBOL ORIGINAL
    // ===================================

    raiz = insertar(raiz, 10);
    insertar(raiz, 5);
    insertar(raiz, 15);
    insertar(raiz, 2);
    insertar(raiz, 7);
    insertar(raiz, 12);
    insertar(raiz, 20);

    cout << "===== EJERCICIO 1 =====" << endl;

    cout << "Preorden: ";
    preorden(raiz);

    cout << "\nInorden: ";
    inorden(raiz);

    cout << "\nPostorden: ";
    postorden(raiz);

    cout << "\nBFS: ";
    BFS(raiz);

    // ===================================
    // EJERCICIO 2
    // AGREGAR NUEVOS NODOS
    // ===================================

    insertar(raiz, 1);
    insertar(raiz, 3);
    insertar(raiz, 18);
    insertar(raiz, 25);

    cout << "\n\n===== EJERCICIO 2 =====" << endl;

    cout << "Preorden: ";
    preorden(raiz);

    cout << "\nInorden: ";
    inorden(raiz);

    cout << "\nPostorden: ";
    postorden(raiz);

    cout << "\nBFS: ";
    BFS(raiz);

    // ===================================
    // EJERCICIO 3
    // CONTAR NODOS
    // ===================================

    cout << "\n\n===== EJERCICIO 3 =====" << endl;
    cout << "Cantidad total de nodos: "
         << contarNodos(raiz);

    // ===================================
    // EJERCICIO 4
    // CONTAR HOJAS
    // ===================================

    cout << "\n\n===== EJERCICIO 4 =====" << endl;
    cout << "Cantidad de hojas: "
         << contarHojas(raiz);

    // ===================================
    // EJERCICIO 5
    // EXPLICACIÓN TEÓRICA
    // ===================================

    cout << "\n\n===== EJERCICIO 5 =====" << endl;

    cout << "\n1. Mostrar el menu principal:" << endl;
    cout << "Se recomienda PREORDEN porque primero "
         << "muestra la raiz y luego los submodulos."
         << endl;

    cout << "\n2. Procesar primero los modulos internos:"
         << endl;
    cout << "Se recomienda POSTORDEN porque primero "
         << "procesa los hijos y despues el nodo principal."
         << endl;

    cout << "\n3. Mostrar modulos nivel por nivel:"
         << endl;
    cout << "Se recomienda BFS porque recorre el "
         << "arbol por niveles." << endl;

    return 0;
}
