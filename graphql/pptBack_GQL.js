const express  = require('express');
const { graphqlHTTP } = require('express-graphql');
const { buildSchema } = require('graphql');
const app = express();
app.use(express.static('public'));

const partides = [];

//Esquema
const esquema = buildSchema(`

    type partida {
        codiP: Int!
        puntsJ1: Int
        puntsJ2: Int
        jugadors: Int
        movJ1: String
        movJ2: String
    }

    type Query{
        consultarPartides: [partida]
        consultarPunts(codiP: Int): String
        consultarDades: String
    }

    type Mutation {
        crearPartida(codiP: Int): String
        acabarPartida(codiP: Int): Boolean
        movimentJugador(codiP: Int, jugador: Int, moviment: String): Boolean
    }

`);

const arrel = {
    crearPartida: ({codiP}) => {
        codiPP = codiP;
        if(partides.find(element => element.codiP == codiP) == undefined){
            partides.push(new Partida(codiP));
            partides[partides.length-1].jugadors += 1;
            jug = "1";
            return jug;
        }else{
            console.log("Entra");
            for (var i = 0; i < partides.length; i += 1) {
                if (partides[i].codiP == codiP) {
                    console.log("ENTRA PARTIDA");
                    console.log(partides[i].jugadors);
                    if (partides[i].jugadors < 2) {
                        partides[i].jugadors += 1;
                        jug = "2";
                        return jug;
                    
                    } else {
                        return res.send('Partida plena');
                    }
                }
            }
        }
        //return true;
    },

    consultarPartides(){
        //return JSON.parse({partidesActives: partides});
        return partides;
    },

    consultarPunts: ({codiP}) => {
        let p = partides.find(c => c.codiP == codiP);
        return p.puntsJ1 + "-" + p.puntsJ2;
    },

    acabarPartida: ({codiP}) => {
        let i = 0;
        console.log(codiP);
        for(; i < partides.length; i++){
            if(partides[i].codiP == codiP)
                break;
        }
        console.log("SPLICE")
        partides.splice(i,1);
        console.log("ESBORRAT");
        return true;
    },

    movimentJugador: ({codiP, jugador, moviment}) => {

    for (let i=0; i < partides.length; i += 1) {
        if (partides[i].codiP == codiP) {

                if(jugador == '1'){
                    partides[i].movJ1 = moviment;
                }else if(jugador == '2') {
                    partides[i].movJ2 = moviment;
                }else{
                    console.log("Jugador incorrecte");
                }

                let movJ1 = partides[i].movJ1;
                let movJ2 = partides[i].movJ2;

                console.log(movJ1);
                console.log(movJ2);

                if(movJ1 != "" && movJ2 != ""){
                    if(movJ1 == movJ2){
                        console.log("Empat");
                    } 
                    else if (movJ1 == "tissores") {
                        if (movJ2 == "paper") {
                            console.log("j1 guanya");
                            partides[i].puntsJ1 += 1;
                        } else {
                            console.log("j2 guanya");
                            partides[i].puntsJ2 += 1;
                        }
                    } 
                    else if (movJ1 == "paper") {
                        if (movJ2 == "pedra") {
                            console.log("j1 guanya");
                            partides[i].puntsJ1 += 1;
                        } else {
                            console.log("j2 guanya");
                            partides[i].puntsJ2 += 1;
                        }
                    } 
                    else if (movJ1 == "pedra") {
                        if (movJ2 == "tissores") {
                            console.log("j1 guanya");
                            partides[i].puntsJ1 += 1;
                        } else {
                            console.log("j2 guanya");
                            partides[i].puntsJ2 += 1;
                        }
                    }
                    partides[i].movJ1 = "";
                    partides[i].movJ2 = "";
                }
            }
            return true;
        }
    }
};

app.use('/graphql', graphqlHTTP({
    schema: esquema,
    rootValue: arrel,
    graphiql: true,
}));
app.listen(4000);
console.log('Executant servidor GraphQL API a http://localhost:4000/graphql');

//Classe partida
class Partida {
    constructor(codiP) {
        this.codiP = codiP;
        this.puntsJ1 = 0;
        this.puntsJ2 = 0;
        this.jugadors = 0;
        this.movJ1 = "";
        this.movJ2 = "";
    }
}