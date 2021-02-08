//Consultar partides
window.onload = function(){
    consulta_partides();
}

function consulta_partides(){

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){
        if (this.readyState === 4) {
            document.getElementById("consulta").innerHTML =  this.response;
        }
    }

    xhr.open("GET","http://localhost:8888/ConsultarPartides",true);
    xhr.responseType = 'text';

    xhr.send();
}

//Iniciar partida
async function iniciarPartida(){

    await CrearPartida();
}

function CrearPartida() {
    return new Promise(resolve => {
      setTimeout(() => {
        let codiPt = (document.getElementById("codiP").value)*1;
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            if (this.readyState === 4) {
            if (this.response == 'Partida plena') {
                alert("Partida plena!");
            }else{
                console.log("Redirect");
                window.location.href = "http://localhost:8888/jugador.html";
            }
        }
        }
    
        xhr.open("POST","http://localhost:8888/iniciarJoc/" + codiPt,true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(codiPt);
      }, 0);
    })
}
