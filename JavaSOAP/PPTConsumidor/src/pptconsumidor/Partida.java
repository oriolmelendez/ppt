/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pptconsumidor;

public class Partida {

    //Atributs
    private int codiP;
    private int puntsJ1;
    private int puntsJ2;
    private int jugadors;
    private String movJ1;
    private String movJ2;

    public Partida(int codiP) {
        this.codiP = codiP;
        this.puntsJ1 = 0;
        this.puntsJ2 = 0;
        this.jugadors = 0;
        this.movJ1 = "";
        this.movJ2 = "";
    }

    public int getCodiP() {
        return codiP;
    }

    public void setCodiP(int codiP) {
        this.codiP = codiP;
    }

    public int getPuntsJ1() {
        return puntsJ1;
    }

    public void setPuntsJ1(int puntsJ1) {
        this.puntsJ1 = puntsJ1;
    }

    public int getPuntsJ2() {
        return puntsJ2;
    }

    public void setPuntsJ2(int puntsJ2) {
        this.puntsJ2 = puntsJ2;
    }

    public int getJugadors() {
        return jugadors;
    }

    public void setJugadors(int jugadors) {
        this.jugadors = jugadors;
    }

    public String getMovJ1() {
        return movJ1;
    }

    public void setMovJ1(String movJ1) {
        this.movJ1 = movJ1;
    }

    public String getMovJ2() {
        return movJ2;
    }

    public void setMovJ2(String movJ2) {
        this.movJ2 = movJ2;
    }

    @Override
    public String toString() {
        return "Partida{" + "codiP=" + codiP + ", puntsJ1=" + puntsJ1 + ", puntsJ2=" + puntsJ2 + ", jugadors=" + jugadors + ", movJ1=" + movJ1 + ", movJ2=" + movJ2 + '}';
    }
    
    
    
}    
    

