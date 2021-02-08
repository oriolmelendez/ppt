package daw2.edu.fje;

import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "PPT")
public class PPT {

    public ArrayList<Partida> partides = new ArrayList<Partida>();
    private String punts;

    //Iniciar partida
    @WebMethod(operationName = "iniciarPartida")
    public void iniciarPartida(@WebParam(name = "codiP") int codiP) {
        partides.add(new Partida(codiP));
    }

    //Consultar partides actives
    @WebMethod(operationName = "ConsultarPartides")
    public String ConsultarPartides() {
        return partides.toString();
    }

    //Consulta punts
    @WebMethod(operationName = "ConsultarPunts")
    public String ConsultarPunts(@WebParam(name = "codiP") int codiP) {
        for (int i = 0; i < partides.size(); i++) {
            if (partides.get(i).getCodiP() == codiP) {
//                punts = "Punts J1: " + partides.get(i).getPuntsJ1() + ", Punts J2: " + partides.get(i).getPuntsJ2();
                punts = partides.get(i).getPuntsJ1() + ","+partides.get(i).getPuntsJ2();
            }
        }
        return punts;
    }

    //Moviments jugadors
    @WebMethod(operationName = "moureJugador")
    public void moureJugador(@WebParam(name = "codiP") int codiP, @WebParam(name = "jugador") String jugador, @WebParam(name = "tipusMoviment") String tipusMoviment) {
        int i;
        for (i = 0; i < partides.size(); i++) {
            if (partides.get(i).getCodiP() == codiP) {
                break;
            }
        }
        System.out.println(jugador);
        if (jugador.equals("1")) {
            partides.get(i).setMovJ1(tipusMoviment);
        } else if (jugador.equals("2")) {
            partides.get(i).setMovJ2(tipusMoviment);
        } else {
            System.out.println("Codi jugador incorrecte");
        }
        
        partides.get(i).getMovJ1();
        partides.get(i).getMovJ2();

        if (!partides.get(i).getMovJ1().equals("") && !partides.get(i).getMovJ2().equals("")) {
            System.out.println("Entra IF mov");
            if (partides.get(i).getMovJ1().equals(partides.get(i).getMovJ2())) {
                System.out.println("Empat");
            } else if (partides.get(i).getMovJ1().equals("tissores")) {
                if (partides.get(i).getMovJ2().equals("paper")) {
                    System.out.println("J1 guanya");
                    partides.get(i).setPuntsJ1(partides.get(i).getPuntsJ1() + 1);
                } else {
                    System.out.println("J2 guanya");
                    partides.get(i).setPuntsJ2(partides.get(i).getPuntsJ2() + 1);
                }

            } else if (partides.get(i).getMovJ1().equals("paper")) {
                if (partides.get(i).getMovJ2().equals("pedra")) {
                    System.out.println("J1 guanya");
                    partides.get(i).setPuntsJ1(partides.get(i).getPuntsJ1() + 1);
                } else {
                    System.out.println("J2 guanya");
                    partides.get(i).setPuntsJ2(partides.get(i).getPuntsJ2() + 1);
                }

            } else if (partides.get(i).getMovJ1().equals("pedra")) {
                if (partides.get(i).getMovJ2().equals("tissores")) {
                    System.out.println("J1 guanya");
                    partides.get(i).setPuntsJ1(partides.get(i).getPuntsJ1() + 1);
                } else {
                    System.out.println("J2 guanya");
                    partides.get(i).setPuntsJ2(partides.get(i).getPuntsJ2() + 1);
                }

            }

            /*if (partides.get(i).getPuntsJ1() == 3 || partides.get(i).getPuntsJ2() == 3) {
                System.out.println("Partida finalitzada");
                partides.remove(i);
            };*/
            
            partides.get(i).setMovJ1("");
            partides.get(i).setMovJ2("");
        }

    }

    //Acabar partida
    @WebMethod(operationName = "acabarJoc")
    public void acabarJoc(@WebParam(name = "codiP") int codiP) {
        for (int i = 0; i < partides.size(); i++) {
            if (partides.get(i).getCodiP() == codiP) {
                partides.remove(i);
            }
        }
    }
}
