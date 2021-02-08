//Consultar punts
window.onload = function () {
    prepararVar();
    consultaPuntuacio();
}
var vars;

function consultaPuntuacio() {
    myVar = setInterval(consulta_punts, 1500);
}

function prepararVar() {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (this.readyState === 4) {
            let variables = this.response;
            vars = variables.split(",");
            document.getElementById("jugador").innerText = vars[0];
            document.getElementById("codiP").innerText = vars[1];

        }
    }

    xhr.open("GET", "http://localhost:8888/ConsultarVar", true);

    xhr.send();
}

function realitzarMoviment() {
    var mov = document.getElementById("moviment").value;
    var xhr = new XMLHttpRequest();

    xhr.open("PUT", "http://localhost:8888/moureJugador/" + vars[1] + "/" + vars[0] + "/" + mov, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.send();
}

function consulta_punts() {

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (this.readyState === 4) {
            let punct = this.response.split(",");
            document.getElementById("puntuacio1").innerHTML = punct[0];
            document.getElementById("puntuacio2").innerHTML = punct[1];
            if (punct[0] == 3 || punct[1] == 3) {
                if (punct[0] == 3) {
                    alert("Jugador 1 ha guanyat la partida!")
                    punct[0] = 0;
                }
                if (punct[1] == 3) {
                    alert("Jugador 2 ha guanyat la partida!");
                    punct[1] = 0;
                }
                cridaDelete();
            }

        }
    }
    console.log("Consulta!");
    xhr.open("GET", "http://localhost:8888/ConsultarPunts/" + vars[1], true);
    xhr.responseType = 'text';

    xhr.send();
}

function cridaDelete() {
    var xxhr = new XMLHttpRequest();

    xxhr.onreadystatechange = function () {
        if (this.readyState == 4)
            window.location.href = "http://localhost:8888/client_ppt.html";
    }
    xxhr.open("DELETE", "http://localhost:8888/acabarJoc/" + vars[1], true);
    xxhr.responseType = 'text';

    xxhr.send();

}