/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.motogp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author corsojava
 */
public class Tabellone {
    private GiudiceDiGara giudice;

    Tabellone(GiudiceDiGara giudiceDiGara) {
       giudice= giudiceDiGara;
    }
    public void gara() {
        try {
            Thread t1=new Thread(giudice);
            t1.start();
            t1.join();
            giudice.stampaTabellone();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tabellone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
