package co.edu.uniquindio.poo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        int []arreglo={1,3,2,3,4,5};
        int  repetido=masRepetido(arreglo);
        System.out.println(repetido);
        boolean hayRepetido=estaRepetido(arreglo);
        System.out.println(hayRepetido);
    }
    public static int masRepetido(int []arreglo) {
        int mayorCantidad = 0;
        int masRepetido = arreglo[0];
        for (int i = 0; i < arreglo.length; i++) {
            int cantidad = 0;
            for (int j = 0; j < arreglo.length; j++) {
                if (arreglo[i] == arreglo[j]) {
                    cantidad++;
                }
                if (cantidad > mayorCantidad) {
                    masRepetido = arreglo[i];
                    mayorCantidad = cantidad;
                }
            }

        }
        return masRepetido;
    }
    public static boolean estaRepetido(int[]arreglo){
        boolean repetido=false;
        for(int i=0;i< arreglo.length&& repetido==false;i++){
            for(int j=i+1;j< arreglo.length;j++) {
                if (arreglo[i] == arreglo[j]) {
                    repetido = true;
                    break;
                }
            }
        }
        return repetido;
    }
}
