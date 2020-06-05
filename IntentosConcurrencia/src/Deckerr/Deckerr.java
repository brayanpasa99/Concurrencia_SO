/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Deckerr;

/**
 *
 * @author KevinB
 */
public class Deckerr {

    /**
     * @param args the command line arguments
     */

    static boolean[] señal= new boolean[2];
    
    public static void main(String[] args) {        
        
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); 
        Deckerr d = new Deckerr();
        señal[0]=false;
        señal[1]=false;
        d.proceso1();
        d.proceso2();

        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo = TFin - TInicio;    
        System.out.println(tiempo);
        

    }
    
    public void proceso1() {
        
        //Volvemos verdadero el proceso 1
        señal[0] = true;
        
        //Ponemos a "Dormir" el programa durante unos ms para simular 
        //el tiempo de proceso (de 2 a 10 segunods)
        /*try {
            Thread.sleep((long) (Math.random() * 10000 + 2000));
        } catch (Exception e) {
            System.out.println(e);
        }*/
          try {
            Thread.sleep((long) (Math.random() * 10000 + 2000));
        } catch (Exception e) {
            System.out.println(e);
        }

        while (señal[1]) {
            señal[0] = false;
            System.out.println("Estoy esperando en P1");
            
            señal[0] = true;
        }
        
        System.out.println("Sección critica P1");
        señal[0] = false;
        
    }
    
    public void proceso2(){
        
        señal[1]=true;
        
        /*try {
            Thread.sleep((long) (Math.random() * 10000 + 2000));
        } catch (Exception e) {
            System.out.println(e);
        }*/
        
        try {
                Thread.sleep((long) (Math.random() * 10000 + 2000));
            } catch (Exception e) {
                System.out.println(e);
            }
        
        while(señal[0]){
            
            señal[1] = false;
            System.out.println("Estoy esperando en P2");
            señal[1] = true;
        }
        System.out.println("Sección critica P2");
        señal[1] = false;
        
    }
}