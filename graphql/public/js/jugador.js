//Consultar punts
window.onload = function(){
    prepararVar();
    consultaPuntuacio();
}
var vars;

function consultaPuntuacio() {
    myVar = setInterval(consulta_punts, 1500);
}

function prepararVar(){
    
    document.getElementById("jugador").innerText = sessionStorage.getItem('jugador');
    document.getElementById("codiP").innerText = sessionStorage.getItem('codiP');
    
}

function realitzarMoviment(){
    var mov = document.getElementById("moviment").value;
    var codiPt = sessionStorage.getItem('codiP');
    var jugador = sessionStorage.getItem('jugador');

    console.log(typeof(mov));

   fetch('/graphql',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
        body: JSON.stringify({
          query: `mutation {movimentJugador(codiP: ${codiPt}, jugador: ${jugador}, moviment: "${mov}")}`
        })
    })
}

function consulta_punts(){

    var codiPt = sessionStorage.getItem('codiP');

    fetch('/graphql',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
        body: JSON.stringify({
          query: `{consultarPunts(codiP: ${codiPt})}`
        })
    })
    .then(r => r.json())
    .then(r => {
        if(r != undefined){
        if (r.data.consultarPunts == null){
            if(jugador == 1)
                alert("Jugador 2 ha guanyat la partida!");
            else 
                alert("Jugador 1 ha guanyat la partida!");
            window.location.href = "http://localhost:4000/client_ppt.html" 
        }
    }
        let punts = r.data.consultarPunts.split("-")
        document.getElementById("puntuacio1").innerHTML =  punts[0];
        document.getElementById("puntuacio2").innerHTML =  punts[1];

        if(punts[0] == 3 || punts[1] == 3){
            var codiPt = sessionStorage.getItem('codiP');
            fetch('/graphql',{
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json',
                },
                body: JSON.stringify({
                    query: `mutation {acabarPartida(codiP: ${codiPt})}`
                })
            })
            .then((r) => {
                if(punts[0] == 3){
                    alert("Jugador 1 ha guanyat la partida!");
                    punts[0] = 0;
                }else if(punts[1] == 3){
                    alert("Jugador 2 ha guanyat la partida!");
                    punts[1] = 0;
                }
                 window.location.href = "http://localhost:4000/client_ppt.html" 
                 
            });
            //acabarPartida();
            
        }
        
    });

}

function acabarPartida(){

    var codiPt = sessionStorage.getItem('codiP');
    console.log(codiPt);
    fetch('/graphql',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
        body: JSON.stringify({
            query: `mutation {acabarPartida(codiP: ${codiPt})}`
        })
    })
    .then( console.log("Redicreecio"));//window.location.href = "http://localhost:4000/client_ppt.html" );
}