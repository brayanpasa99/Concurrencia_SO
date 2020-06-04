/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckerintentoii;

/**
 *
 * @author KevinB
 */
public class DeckerIntentoII {

    /**
     * @param args the command line arguments
     * INTENTO 2
     */
    static boolean[] señal= new boolean[2];
    public static void main(String[] args) {
        
        
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); 
        señal[0]=false;
        señal[1]=false;
        //Caso particular que cada proceso tiene distinto timpo de ejecución
        casoComunP1();
        casoComunP2();
        //Caso ideal en que los 2 duran lo mismo
        //casoIdealP1();
        //casoIdealP2();
        //Peor caso en que uno se queda en 
        peorCasoP1();
        
//Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        TFin = System.currentTimeMillis(); 
        tiempo = TFin - TInicio;    
        System.out.println(tiempo);
        

    }
    public static void casoComunP1(){
        //Si el proceso 2 esta activo, esperara a que termine
        while(señal[1]){
                System.out.println("P1 en pausa");
            }
        try {
            //Ponemos a "Dormir" el programa durante unos ms para simular 
            //el tiempo de proceso (de 2 a 10 segunods)
            Thread.sleep((long) (Math.random()*10000 + 2000));
         } catch (Exception e) {
            System.out.println(e);
         }
        //Volvemos verdadero el proceso 1
        señal[0]=true;
        //Mientras este esté en ejecución
        while(señal[0]){
            //A lo que el proceso 2 no esté más activo se iniciara el proceso 1
            System.out.println("Sección critica p1");
            //Se termina el proceso 1
            señal[0]=false;  
        }
    }
    public static void casoComunP2(){
        while(señal[0]){
                System.out.println("P2 en pausa");
            }
        try {
            //Ponemos a "Dormir" el programa durante unos ms para simular 
            //el tiempo de proceso (de 2 a 10 segunods)
            Thread.sleep((long) (Math.random()*10000 + 2000));
         } catch (Exception e) {
            System.out.println(e);
         }
        
        señal[1]=true;
        while(señal[1]){
            System.out.println("Sección critica p2");
            señal[1]=false;  
        }
    }
    
    public static void casoIdealP1(){
        //Mientras el proceso 2 esté en marcha, este esperara
        while(señal[1]){
            System.out.println("P1 en pausa");
        }
        //Volvemos verdadero el proceso 1
        señal[0]=true;
        //Mientras este esté en ejecución
        while(señal[0]){            
            //A lo que el proceso 2 no esté más activo se iniciara la sección critica
            System.out.println("Sección critica p1");
            //Se termina el proceso 1
            señal[0]=false;  
        }
    }
    public static void casoIdealP2(){
    //Mientras el proceso 1 esté en marcha, este esperara
    while(señal[0]){
        System.out.println("P1 en pausa");
    }
    //Volvemos verdadero el proceso 1
    señal[1]=true;
    //Mientras este esté en ejecución
    while(señal[1]){            
        //A lo que el proceso 2 no esté más activo se iniciara la sección critica
        System.out.println("Sección critica p1");
        //Se termina el proceso 1
        señal[1]=false;  
    }
}

    public static void peorCasoP1(){
    while(señal[1]){
            System.out.println("P1 en pausa");
        }
    
    //Volvemos verdadero el proceso 1
    señal[0]=true;
    //Mientras este esté en ejecución
    while(señal[0]){
        //A lo que el proceso 2 no esté más activo se iniciara el proceso 1
        System.out.println("Sección critica p1");
        //Al haber una falla no puede cambiar su estado, por lo tanto nunca aparecera
        //el proceso 2
        System.out.println("Fallo en sección critica");
        }
    }
}

