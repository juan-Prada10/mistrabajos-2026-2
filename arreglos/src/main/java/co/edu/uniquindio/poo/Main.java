package co.edu.uniquindio.poo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //1. crear un arreglo e inicializarlo
        //2.realizar un metodo que sume todos los numeros del arreglo y retornar la suma

        int numeros []={1,4,5,7,8};
        int sumatoria=suma(numeros);
        System.out.println(sumatoria);

    }
    public static int suma (int [] numeros){
        int suma =0;
        for(int i=0;i<numeros.length;i++){
            suma+=numeros[i];
        }
        return suma;

    }
    //3. Realizar si existe un numero dado en el arreglo
    public static boolean numeroExiste(int [] numeros,int numero){
        boolean existe=false;
        for(int i=0;i<numeros.length;i++){
            if(numero==numeros[i]){
                existe=true;
                break;
            }
        }
        return existe;
    }
}

