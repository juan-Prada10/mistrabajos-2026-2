package co.edu.uniquindio.poo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        int matriz[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        mostrarMatriz();
        int sumaMatriz = sumarMatriz(matriz);
        System.out.println("La suma de la matriz es " + sumaMatriz);

        int sumaDiagonal = sumaDiagonal(matriz);
        System.out.println("La suma de la diagonal es " + sumaDiagonal);

        espiral();

    }

    //1. Imprimir una matriz
    public static void mostrarMatriz() {
        int matriz[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

    //2. Sumar todos los numeros de una matriz
    public static int sumarMatriz(int matriz[][]) {
        int totalSuma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                totalSuma+=matriz[i][j];
            }
        }
        return totalSuma;
    }

    //3. Sumar los numero de la diagonal principal de la matriz
    public static int sumaDiagonal(int matriz[][]) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    suma += matriz[i][j];
                }
            }
        }
        return suma;
    }

    //4. Dibujar en una matriz un espiral de numeros
    public static void espiral() {
        int matriz[][] = {{0, 0, 0, 0},
                          {0, 0, 0, 0},
                          {0, 0, 0, 0},
                          {0, 0, 0, 0}};
        int tamanoMatriz = 4;
        int numero = 1;
        int filaInicial = 0;
        int finFila = tamanoMatriz - 1;
        int columnaInicial = 0;
        int finColumna = tamanoMatriz - 1;


        while (filaInicial <= finFila && columnaInicial <= finColumna) {
            //Mover a la derecha
            for (int j = columnaInicial; j <= finColumna; j++) {
                matriz[filaInicial][j] = numero;
                numero++;
            }
            filaInicial++;
            //Mover abajo
            for (int i = filaInicial; i <= finFila; i++) {
                matriz[i][finColumna] = numero;
                numero++;
            }
            finColumna--;
            //Mover a la Izquierda
            for (int j = finColumna; j >= columnaInicial; j--) {
                matriz[finFila][j] = numero;
                numero++;
            }
            finFila--;
            //Mover arriba
            for (int i = finFila; i >= filaInicial; i--) {
                matriz[i][columnaInicial] = numero;
                numero++;
            }
            columnaInicial++;

        }
        //Mostrar matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
}



