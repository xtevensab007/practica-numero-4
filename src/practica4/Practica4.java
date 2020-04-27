package practica4;

import static java.util.Objects.equals;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Practica4 {
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);//esta variable la usaremos para leer las teclas que el usuario oprime
        
        //pedimos al usuario el tamaño del arreglo y lo guardamos en una variable (lon)
        System.out.println("introduzca longitud del vector: ");
        int lon = sc.nextInt();
        int vector[] = new int[lon];

        // preguntamos al usuario si desea ingresar manualmente los datos 
        //si la respuesta es "no" se llena de manera aleatoria
        System.out.println("desea ingresar valores manualmente? \n [1] si \n [2] no ");
        int resp = sc.nextInt();

        switch (resp) {
            case 1:
                for (int i = 0; i < vector.length; i++) {
                    System.out.print("posicion[" + i + "]= ");
                    vector[i] = sc.nextInt();    //atravez de un ciclo le pedimos al usuario que ingrese un numero para cada posicion 

                }
                break;
            case 2:
                for (int i = 0; i <= lon - 1; i++) {
                    vector[i] = (int) (Math.random() * 100 + 0);//co un ciclo generamos un vector aleatorio entre el 0 y el 100
                    System.out.println("posicion[" + i + "]--->" + vector[i]);
                }
                break;
            default:
                System.out.print("ingrese una opcion valida");
                break;
        }

        //modificar valor de un campo
        System.out.println("\n desea modificar algun valor? \n [1] si \n [2] no ");
        int resp2 = sc.nextInt();

        if (resp2 == 1) {
            System.out.println("ingrese posicion a modificar");// solicitamos al usuario la posicion que desea modificar
            int resp3 = sc.nextInt(); //leemos la entrada de teclado y la almacenamos en una variable

            if (resp3 >= vector.length || resp3 < 0) {  //si la posicion es invalida se le indica al usuario 
                System.out.println("posicion invalida");

            } else {
                System.out.println("ingrese nuevo valor");// solicitamos al usuario un valor y reemplazamos en la posicion indicada 
                int valor = sc.nextInt();
                vector[resp3] = valor;

                for (int i = 0; i < vector.length; i++) { //imprimimos el vector resultante 
                    System.out.println("Posicion[" + i + "]--->" + vector[i]);
                }
            }

        }
        //preguntamos al usuario si quiere intercambiar all guna posicion del vector
        System.out.println("\n desea intercambiar alguna posicion? \n [1] si \n [2] no ");
        int resp4 = sc.nextInt();

        if (resp4 == 1) {
            //invocamos el metodo para intercambiar posiciones e imprimimos el vector 
            int[] vector3 = cambiarPosiciones(vector);
            for (int i = 0; i < vector3.length; i++) {
                System.out.println("Posicion[" + i + "]--->" + vector3[i]);
            }
        }

        //invocamos el metodo para invertir el vector e imprimimos el vector
        int[] vector2 = invertirVector(vector);

        for (int i = 0; i < vector2.length; i++) {
            System.out.println("Posicion[" + i + "]--->" + vector2[i]);
        }

    }
/**
 * 
 * @param vector es el valor que devuelve el metodo
 * @return 
 */
    private static int[] invertirVector(int[] vector) {

        System.out.println("\n los numeros en orden inverso son: \n");
        int j;
        for (j = 0; j < vector.length / 2; j++) {
            int aux = vector[j];
            vector[j] = vector[vector.length - 1 - j];
            vector[vector.length - 1 - j] = aux;
        }
        return vector;
    }

    private static int[] cambiarPosiciones(int[] vector) {

        Scanner sc = new Scanner(System.in);
        int dato;
        System.out.println("\n intercambiar posiciones : \n");

        System.out.println("primer posicion a cambiar: ");// solicitamos las dos posiciones a intercambiar 
        int p1 = sc.nextInt();
        System.out.println("segunda posicion a cambiar: ");
        int p2 = sc.nextInt();

        if (p1 <= vector.length && p2 <= vector.length && p1>=0 && p2>=0) {
            dato = vector[p1];          //guardamos el valor de una de las posiciones 
            vector[p1] = vector[p2];    //luego reemplazamos las segunda posicion en la primera
            vector[p2] = dato;          //por ultimo reemplazamos el valor guardado en la segunda posicion
        } else {
            System.out.println("\n ingrese un indice correcto\n ");

        }

        return vector;
    }
    

}
