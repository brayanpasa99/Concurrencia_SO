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
public class IntentosConcurrencia {

    /**
     * @param args the command line arguments
     */
    HashMap<Integer, String> procesos;
    int turno = 0;

    public static void main(String[] args) {
        IntentosConcurrencia o = new IntentosConcurrencia();
        o.algoritmoIntento1(1);
    }

    public IntentosConcurrencia() {

        procesos = new HashMap<>();
        procesos.put(0, "p_0");
        procesos.put(1, "p_1");
        procesos.put(2, "p_2");
        procesos.put(3, "p_3");

    }

    public void algoritmoIntento1(int opc) {

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
                break;
            case 2:
                while (llaves.length > 0) {
                    turno = (int) llaves[0];
                    System.out.println("Turno: " + turno);
                    System.out.println("Ejecutando proceso: " + procesos.get(turno));
                    //procesos.remove(i);
                    System.out.println("Finalizó proceso");    
                    //i++;
                    //llaves = procesos.keySet().toArray();
                }
                break;
            case 3:
                break;

        }

    }

}
