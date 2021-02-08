const express = require("express");
const bodyParser = require("body-parser");
const jwt = require("jsonwebtoken");
const app = express();
app.use(bodyParser.json());
app.use(express.static('public'));
var path = require('path');
const { access } = require("fs");
const PORT = 8888;

//Emmagatzemem les partides
var partides = [];
var jug;
var codiPP;

//Classe partides
class partida {
    constructor(codiP) {
        this.codiP = codiP;
        this.puntsJ1 = 0;
        this.puntsJ2 = 0;
        this.jugadors = 0;
        this.movJ1 = "";
        this.movJ2 = "";
    }
}

//Arrel
app.get("/", (req,res) =>{
    res.sendFile(path.join(__dirname + '/public/client_ppt.html'));
});

//Creació de la partida
app.post("/iniciarJoc/:CodiPartida", (req, res) => {
    let codiP = req.params.CodiPartida;
    codiPP = codiP;
    if(partides.find(element => element.codiP == codiP) == undefined){
        partides.push(new partida(codiP));
        partides[partides.length-1].jugadors += 1;
        jug = "1";
    }else{
        console.log("Entra");
        for (var i = 0; i < partides.length; i += 1) {
            if (partides[i].codiP == codiP) {
                //comprovar si ja n'hi ha dos jugadors en cas afirmatiu no deixar unir-se al nou jugador
                console.log("ENTRA PARTIDA");
                console.log(partides[i].jugadors);
                if (partides[i].jugadors < 2) {
                    partides[i].jugadors += 1;
                    jug = "2";
                
                } else {
                    return res.send('Partida plena');
                }
                break;
            }
        }
    }
    res.send();
});

//Comprovar partides
app.get("/ConsultarPartides", (req, res) => {
    res.send(partides);
});

app.get("/ConsultarVar", (req, res) => {
    res.send(jug+","+codiPP);
});

//Consulta punts
app.get("/ConsultarPunts/:CodiPartida", (req, res) => {
    let codiP = req.params.CodiPartida;
    for (let i = 0; i < partides.length; i += 1) {
        
        if (partides[i].codiP == codiP) {
            res.send(partides[i].puntsJ1 + "," + partides[i].puntsJ2);
        }
    }
    // res.send("Partida no trobada");
});

//Moviments jugadors
app.put("/moureJugador/:codiPartida/:jugador/:tipusMoviment", (req, res) => {

    //Emmagatzemar valor moviments

    var jugador = req.params.jugador;
    var codiP = req.params.codiPartida;
    let j = jugador.toString();
    var i = 0;
    for (; i < partides.length; i += 1) {
        if (partides[i].codiP == codiP) {
            if (j == '1') {
                movJ1 = req.params.tipusMoviment;
                partides[i].movJ1 = movJ1.toString();
                //res.send(movJ1);
            } else if (j == '2') {
                movJ2 = req.params.tipusMoviment;
                partides[i].movJ2 = movJ2.toString();
                //res.send(movJ2);
            } else {
                console.log("Codi jugador incorrecte");
            }
        
            var movJ1 = partides[i].movJ1;
            var movJ2 = partides[i].movJ2;

            if (movJ1 != "" && movJ2 != "") {
                if (movJ1 == movJ2) {
                } else if (movJ1 == "tissora") {
                    if (movJ2 == "paper") {
                        partides[i].puntsJ1 += 1;
                    } else {
                        partides[i].puntsJ2 += 1;
                    }
                } else if (movJ1 == "paper") {
                    if (movJ2 == "pedra") {
                        partides[i].puntsJ1 += 1;
                    } else {
                        partides[i].puntsJ2 += 1;
                    }
                } else if (movJ1 == "pedra") {
                    if (movJ2 == "tissora") {
                        partides[i].puntsJ1 += 1;
                    } else {
                        partides[i].puntsJ2 += 1;
                    }
                }
        
                partides[i].movJ1 = "";
                partides[i].movJ2 = "";
        
            }
        }
    }
    res.send();

});

//Acabar joc
app.delete("/acabarJoc/:codiPartida", (req, res) => {
    let i = 0;
    for(; i < partides.length; i++){
        if(partides[i].codiP == req.params.codiPartida)
            break;
    }
    partides.splice(i,1);
    res.send("Esborrat");
});

app.listen(PORT, () => {
    console.log(`Servidor execuntant-se en el port ${PORT}.`);
});