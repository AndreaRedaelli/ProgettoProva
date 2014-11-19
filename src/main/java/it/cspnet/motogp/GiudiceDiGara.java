/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.motogp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author corsojava
 */
public class GiudiceDiGara implements Runnable {

    private Collection<Thread> moto;
    private int[] array;
    private int numeroMaxMoto;

    public GiudiceDiGara() {
        array = new int[20];
      
        numeroMaxMoto = 20;
        moto = new ArrayList<>(numeroMaxMoto);
    }

    public void inserisciTempo(int tempo, int concorrente) {

        synchronized (this) {
            this.array[concorrente] += tempo;

        }

    }

    @Override
    public void run() {
        try {
            inserisciMoto();
            via();
        } catch (InterruptedException ex) {
            Logger.getLogger(GiudiceDiGara.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void inserisciMoto() {
        for (int i = 0; i < numeroMaxMoto; i++) {
            moto.add(new Thread(new Moto(this)));
        }

    }

    private void via() throws InterruptedException {
        for (Thread m : moto) {
            m.start();
        }
        
        for (Thread t : moto) {
            t.join();
        }

    }

    public void stampaTabellone() {
        int[] arrayAppoggio = new int[20];
        for (int z = 0; z < array.length; z++) {
            arrayAppoggio[z] = array[z];
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < arrayAppoggio.length; j++) {
                if (array[i] == arrayAppoggio[j]) {
                    System.out.println("concorrente " + j + " " + " tempo : " + array[i]);
                    arrayAppoggio[j] = -1;
                }
            }

        }

    }
}
