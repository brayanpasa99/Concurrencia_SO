/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intentosconcurrencia;

import java.util.HashMap;

/**
 *
 * @author braya
 */
public class Intento1 {

    /**
     * @param args the command line arguments
     */
    HashMap<Integer, String> procesos;
    int turno = 0;
    long Ttotal = 0;

    public static void main(String[] args) {
        Intento1 o = new Intento1();
        //MODIFICAR SWITHC CASE PARA OBTENER DIFERENTES CASOS
        o.algoritmoIntento1(2);

    }

    public Intento1() {

        procesos = new HashMap<>();
        procesos.put(0, "p_0");
        procesos.put(1, "p_1");
        procesos.put(2, "p_2");
        procesos.put(3, "p_3");
    }

    public void algoritmoIntento1(int opc) {

        long Tinicio = System.currentTimeMillis();
        Object[] llaves = procesos.keySet().toArray();
        int i = 0;
        switch (opc) {
            case 0:
                while (llaves.length > 0) {
                    turno = (int) llaves[0];
                    System.out.println("Turno: " + turno);
                    System.out.println("Ejecutando proceso: " + procesos.get(turno));
                    procesos.remove(i);
                    System.out.println("Finalizó proceso");
                    i++;
                    llaves = procesos.keySet().toArray();
                }
                Ttotal = System.currentTimeMillis() - Tinicio;
                System.out.println("Tiempo total de ejecución: " + Ttotal);
                break;
            case 1:
                while (llaves.length > 0) {
                    turno = (int) llaves[0];
                    System.out.println("Turno: " + turno);
                    System.out.println("Ejecutando proceso: " + procesos.get(turno));
                    //procesos.remove(i);
                    System.out.println("Finalizó proceso");
                    //i++;
                    //llaves = procesos.keySet().toArray();
                }
                Ttotal = System.currentTimeMillis() - Tinicio;
                System.out.println("Tiempo total de ejecución: " + Ttotal);
                break;
            case 2:
                while (llaves.length > 0) {
                    turno = (int) llaves[0];
                    System.out.println("Turno: " + turno);
                    long TinicioP = System.currentTimeMillis();
                    System.out.println("Ejecutando proceso: " + procesos.get(turno));
                    try {
                        Thread.sleep((long) (Math.random() * 10000 + 2000));
                    } catch (InterruptedException e) {
                        System.out.println(e.toString());
                    }
                    procesos.remove(i);
                    System.out.println("Finalizó proceso");
                    long TProceso = System.currentTimeMillis() - TinicioP;
                    System.out.println("Tiempo: " + TProceso + " Proceso: " + i);
                    i++;
                    llaves = procesos.keySet().toArray();
                }
                Ttotal = System.currentTimeMillis() - Tinicio;
                System.out.println("Tiempo total de ejecución: " + Ttotal);
                break;
            default:
                break;
        }

    }

}
