/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pptconsumidor;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author stilgar
 */
public class PPTConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean isTrue = false;

        String op = "0", Jugador = "0";
        int codiP = -1;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. Crear Partida");
            System.out.println("2. Unir-se a Partida");
            op = sc.nextLine();
            System.out.println(op);

        } while (!op.equals("1") && !op.equals("2"));
        boolean valida = true;
        do {
            System.out.println("Quin codi es el de la partida?");
            codiP = sc.nextInt();
            System.out.println(codiP);
            ArrayList<String> al1 = new ArrayList<>();
            if (op.equals("2")) {
                String ap1 = consultarPartides();
                boolean beforeDigit = false;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ap1.length(); i++) {
                    char c = ap1.charAt(i);
                    if (Character.isDigit(c)) {
                        System.out.println(c + "is a char");
                        if (!beforeDigit) {
                            if (sb.length() > 1) {
                                al1.add(sb.toString());
                            }
                            sb.setLength(0);
                        }
                        sb.append(c);
                        beforeDigit = true;
                    } else {
                        beforeDigit = false;
                    }
                }
                System.out.println(al1.size());
                for (int i = 0; al1.size() > i; i++) {
                    if (al1.get(i).equals(String.valueOf(codiP))) {
                        valida = true;
                        break;
                    } else {
                        valida = false;
                    }
                }
            }
            System.out.println(valida);
        } while ((codiP < 0 || codiP >= 99999) || valida == false);
        String ap1 = consultarPartides();

        System.out.println("ap1");
        System.out.println(ap1);
        System.out.println("ap1");
        if (op.equals("1")) {
            if (ap1.contains("codiP=" + String.valueOf(codiP) + ",")) {
                System.out.println("Aquesta partida ya existeix");
                exit(1);
            } else {
                iniciarPartida(codiP);
                Jugador = "1";
            }
        } else {
            Jugador = "2";
        }

        Partida p1 = new Partida(codiP);
        final int codiPP = codiP;
        String moviment;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String pp = consultarPunts(codiPP);
                String[] parts = pp.split(",");
                System.out.println("Jugador 1: " + parts[0] + ", Jugador 2: " + parts[1]);
                System.out.println(Integer.parseInt(parts[0]));
                System.out.println(Integer.parseInt(parts[1]));
                p1.setPuntsJ1(Integer.parseInt(parts[0]));
                p1.setPuntsJ2(Integer.parseInt(parts[1]));
                if (p1.getPuntsJ1() == 3 || p1.getPuntsJ2() == 3) {
                System.out.println("Partida acabada!");
                if (p1.getPuntsJ1() == 3) {
                    System.out.println("Jugador 1 Guanya");
                } else {
                    System.out.println("Jugador 2 Guanya");
                }
                timer.cancel();//stop the timer
                acabarJoc(codiPP);
                exit(0);
            }
            }
        }, 0, 1500);//wait 0 ms before doing the action and do it evry 1000ms (1second)
        do {
            
            do {
                System.out.println("Quin moviment vols fer? (Pedra, Paper o Tissores)");
                moviment = sc.next();

                System.out.println(moviment);
            } while (esCorrecte(moviment));
            moureJugador(codiP, Jugador, moviment);
        } while (true);
    }

    private static boolean esCorrecte(String moviment) {
        String m = moviment.toLowerCase();
        switch (m) {
            case "pedra":
            case "paper":
            case "tissores":
                return false;
            default:
                return true;
        }
    }

    private static void iniciarPartida(int codiP) {
        daw2.edu.fje.PPT_Service service = new daw2.edu.fje.PPT_Service();
        daw2.edu.fje.PPT port = service.getPPTPort();
        port.iniciarPartida(codiP);
    }

    private static String consultarPartides() {
        daw2.edu.fje.PPT_Service service = new daw2.edu.fje.PPT_Service();
        daw2.edu.fje.PPT port = service.getPPTPort();
        return port.consultarPartides();
    }

    private static String consultarPunts(int codiP) {
        daw2.edu.fje.PPT_Service service = new daw2.edu.fje.PPT_Service();
        daw2.edu.fje.PPT port = service.getPPTPort();
        return port.consultarPunts(codiP);
    }

    private static void moureJugador(int codiP, java.lang.String jugador, java.lang.String tipusMoviment) {
        daw2.edu.fje.PPT_Service service = new daw2.edu.fje.PPT_Service();
        daw2.edu.fje.PPT port = service.getPPTPort();
        port.moureJugador(codiP, jugador, tipusMoviment);
    }

    private static void acabarJoc(int codiP) {
        daw2.edu.fje.PPT_Service service = new daw2.edu.fje.PPT_Service();
        daw2.edu.fje.PPT port = service.getPPTPort();
        port.acabarJoc(codiP);
    }

}
