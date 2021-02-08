/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw2.fje.edu;

import java.util.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author oriol
 * public PPT() {
    }
 */
@Path("ppt")
public class PPT {

    @Context
    private UriInfo context;
    static public ArrayList<Partida> partides = new ArrayList<>();
    static private int i;
    static private String punts;

    public PPT() {
    }

    /* Crear partida */
    @Path("/iniciarPartida/{codiP}")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    static public Response iniciarPartida(@PathParam("codiP") int codiP) {
        partides.add(new Partida(codiP));
        return Response.status(200).entity("partida creada").build();
    }

    /* Consultar partides */
    @Path("/consultarPartides")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    static public String consultarTotesPartides() {
        return partides.toString();
    }

    /* Consultar punts */
    @Path("/consultarPunts/{codiP}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    static public String consultarPunts(@PathParam("codiP") int codiP) {
        for(int j = 0; j < partides.size(); j++){
            if(partides.get(j).getCodiP() == codiP){
                return partides.get(i).getPuntsJ1() + "," + partides.get(i).getPuntsJ2();
            }
        }
        return "Aquesta partida no existeix";
    }

    /* Realitzar moviment */
    @Path("/moureJugador/{codiP}/{jugador}/{tipusMoviment}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    static public void moureJugador(@PathParam("codiP") int codiP,
            @PathParam("jugador") String jugador, @PathParam("tipusMoviment") String tipusMoviment) {

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

            if (partides.get(i).getPuntsJ1() == 3 || partides.get(i).getPuntsJ2() == 3) {
                System.out.println("Partida finalitzada");
                partides.remove(i);
            };

            partides.get(i).setMovJ1("");
            partides.get(i).setMovJ1("");
        }

    }
    
    @Path("/consultarPunts/{codiP}")
    @POST
    //@Produces(MediaType.TEXT_PLAIN)
    static public void acabarJoc(@PathParam("codiP") int codiP) {
        for (int i = 0; i < partides.size(); i++) {
            if (partides.get(i).getCodiP() == codiP) {
                partides.remove(i);
            }
        }
    }
    
}
