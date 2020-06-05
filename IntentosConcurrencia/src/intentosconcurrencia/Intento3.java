/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intentosconcurrencia;

/**
 *
 * @author KevinB
 */
public class Intento3 {

    /**
     * @param args the command line arguments
     */

    static boolean[] señal;
    public static void main(String[] args) {
        
        
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); 
        señal[0]=false;
        señal[1]=false;
        proceso1Caso3();
        proceso2Caso3();

        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo = TFin - TInicio;    
        System.out.println(tiempo);
        

    }
    public static void proceso1Caso3(){
        //Volvemos verdadero el proceso 1
        señal[0]=true;
        //Mientras este esté en ejecución
        while(señal[0]){
            //Si el proceso 2 esta activo, esperara a que termine
            while(señal[1]){
                System.out.println("P1 en pausa");
            }
            //A lo que el proceso 2 no esté más activo se iniciara el proceso 1
            System.out.println("Sección critica p1");
            //Se termina el proceso 1
            señal[0]=false;  
        }
    }
    public static void proceso2Caso3(){
        señal[1]=true;
        while(señal[1]){
            while(señal[0]){
                System.out.println("P2 en pausa");
            }
            System.out.println("Sección critica p2");
            señal[1]=false;  
        }
    }
}