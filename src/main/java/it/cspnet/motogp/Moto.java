/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.motogp;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author corsojava
 */

public class Moto  implements Runnable{
    private int giro;
    private GiudiceDiGara giudice;
    private int concorrente;
    private static int numeroPartecipanti=0;
    
    public Moto(GiudiceDiGara giudice) {
        this.giro=32;
        this.giudice=giudice;
        this.concorrente=numeroPartecipanti++;
    }

   
    
    
    
    @Override
    public void run() {
        
        int tempo=0;
        while(this.finito()){
            tempo=60000 + new Random().nextInt(4000);
            giudice.inserisciTempo(tempo, concorrente);
            this.conclusoGiro();
        }
    }

    private boolean finito() {
        return this.giro>0;
    }

    private void conclusoGiro() {
       this.giro--;
    }
    
}
