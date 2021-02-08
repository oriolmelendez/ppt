//Consultar partides
window.onload = function(){
    consulta_partides();
}

function consulta_partides(){

    fetch('/graphql',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
        body: JSON.stringify({ query:"{consultarPartides {codiP} }" })
    })
    .then(r => r.json())
    .then(r => {
        document.getElementById('consulta').innerText = '';
        let i = 0;
        while(r.data.consultarPartides.length > i){
            document.getElementById('consulta').innerText += "Codi partida: "
            document.getElementById('consulta').innerText += r.data.consultarPartides[i].codiP
            document.getElementById('consulta').innerHTML += "<br>"
            i++;
        }
 
    });

}

//Iniciar partida

function iniciarPartida(){

    let codiPt = (document.getElementById("codiP").value)*1;

    fetch('/graphql',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
        body: JSON.stringify({
          query: `mutation {crearPartida(codiP: ${codiPt})}`
        })
    })
    .then(consulta_partides())
    .then(r => r.json())
    .then(r =>{
        sessionStorage.setItem('codiP', codiPt);
        sessionStorage.setItem('jugador', r.data.crearPartida[0])
        window.location.href = "http://localhost:4000/jugador.html";
    });
}