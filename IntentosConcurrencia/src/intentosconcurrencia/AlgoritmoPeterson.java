/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intentosconcurrencia;

/**
 *
 * @author braya
 */
public class AlgoritmoPeterson {

    boolean[] señal = new boolean[2];
    int turno = 0;
    long Ttotal, Tinicio;

    public static void main(String[] args) {
        AlgoritmoPeterson ap = new AlgoritmoPeterson();
        //o.algoritmoIntento1(2);

        ap.calcTinicio();
        boolean[] señales = {false, false};
        ap.setSeñal(señales);
        ap.setTurno(1);
        ap.procedure_p1();
        ap.procedure_p0();
        ap.getTtotal();

        System.out.println("Algoritmo de Peterson tiempo: " + ap.getTtotal());

    }

    public void calcTinicio() {

        Tinicio = System.currentTimeMillis();

    }

    public void Ttotal() {

        Ttotal = System.currentTimeMillis() - Tinicio;

    }

    public long getTtotal() {
        return Ttotal;
    }

    public void setSeñal(boolean[] señal) {
        this.señal = señal;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public AlgoritmoPeterson() {

    }

    public void procedure_p0() {
        señal[0] = true;
        turno = 1;

        do {
        } while (señal[1] && turno == 1);

        System.out.println("Sección crítica proceso 0");
        señal[0] = false;
        System.out.println("Resto");

    }

    public void procedure_p1() {
        señal[1] = true;
        turno = 0;

        do {
        } while (señal[0] && turno == 0);

        System.out.println("Sección crítica proceso 1");
        señal[1] = false;
        System.out.println("Resto");

    }

}
