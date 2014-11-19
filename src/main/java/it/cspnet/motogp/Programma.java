/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.motogp;

/**
 *
 * @author corsojava
 */
public class Programma {
    public static void main(String[] args) throws InterruptedException {
        Tabellone tabellone= new Tabellone(new GiudiceDiGara());
        tabellone.gara();
    }
 
}
