// ajustar o tamanho da letra em: Opponent's Turn //
// alterar a cor dos botões //
// padding nos números dos countSlots //
// escrever o vencedor //
// atualizar corretamente o turno //
// o vencedor fica à espera do turno do oponente??? //

"use strict"

const serverURL = "http://twserver.alunos.dcc.fc.up.pt:8008/";
const group = "1235";

var loginForm;
var nickSlot;
var passSlot;
var logoutButton;

var lightCountSlot;
var emptyCountSlot;
var darkCountSlot;
var gameSlot;
var errorSlot;

var settingsPopUp;
var playerTurnPopUp;
var playPassButton;
var playPassButtonBlockerPopUp;

var gameRoot;
var panel;

var isLogged;

var game;
var board;
var nick;
var pass;
var turn;
var color;
var move;
var count;
var skip;
var winner;

window.onload = function() {
    loginForm    = document.getElementById("loginForm");
    nickSlot     = document.getElementById("nickSlot");
    passSlot     = document.getElementById("passSlot");
    logoutButton = document.getElementById("logoutButton");

    lightCountSlot = document.getElementById("lightCountSlot");
    emptyCountSlot = document.getElementById("emptyCountSlot");
    darkCountSlot  = document.getElementById("darkCountSlot");
    gameSlot       = document.getElementById("gameSlot");
    errorSlot      = document.getElementById("errorSlot");

    settingsPopUp              = document.getElementById("settingsPopUp");
    playerTurnPopUp            = document.getElementById("playerTurnPopUp");
    playPassButton             = document.getElementById("playPassButton");
    playPassButtonBlockerPopUp = document.getElementById("playPassButtonBlockerPopUp");

    gameRoot = document.getElementById("gameRoot");
    panel    = document.createElement("div");

    isLogged = false;

    resetGame();
}

function resetGame() {
    panel.remove();
    panel = document.createElement("div");
    panel.className = "panel";
    gameRoot.appendChild(panel);

    gameSlot.innerText = "";
    gameSlot.appendChild(document.createTextNode(""));

    errorSlot.innerText = "";
    errorSlot.appendChild(document.createTextNode(""));

    board = [
        ["empty","empty","empty","empty","empty","empty","empty","empty"],
        ["empty","empty","empty","empty","empty","empty","empty","empty"],
        ["empty","empty","empty","empty","empty","empty","empty","empty"],
        ["empty","empty","empty","light","dark" ,"empty","empty","empty"],
        ["empty","empty","empty","dark", "light","empty","empty","empty"],
        ["empty","empty","empty","empty","empty","empty","empty","empty"],
        ["empty","empty","empty","empty","empty","empty","empty","empty"],
        ["empty","empty","empty","empty","empty","empty","empty","empty"]
    ];
    skip = false;
    count = { dark: 2, light: 2, empty: 60 };
    // color = ? //
    // turn = ? //

    placeCells();
    placeDisks();
    countDisks();
    showSettingsPopUp();
}

function placeCells() {
    for (let r = 0; r < 8; r++) {
        for (let c = 0; c < 8; c++) {
            let cell = document.createElement("div");
            cell.className = "cell";

            cell.style.top = (100 + 5) * r + 5 + "px";
            cell.style.left = (100 + 5) * c + 5 + "px";

            cell.addEventListener("click", function() { notify(nick, pass, game, { row: r, column: c }); });

            panel.appendChild(cell);
        }
    }
}

function placeDisks() {
    for (let r = 0; r < 8; r++) {
        for (let c = 0; c < 8; c++) {
            if (board[r][c] != "empty") {
                let disk = document.createElement("div");
                disk.className = "disk";

                disk.style.top = (100 + 5) * r + 5 + "px";
                disk.style.left = (100 + 5) * c + 5 + "px";

                if (board[r][c] == "light") { disk.style.backgroundColor = "white"; }

                else if (board[r][c] == "dark") { disk.style.backgroundColor = "black"; }

                panel.appendChild(disk);
            }
        }
    }
}

function countDisks() {
    lightCountSlot.innerText = "";
    lightCountSlot.appendChild(document.createTextNode(count.light));

    emptyCountSlot.innerText = "";
    emptyCountSlot.appendChild(document.createTextNode(count.empty));

    darkCountSlot.innerText = "";
    darkCountSlot.appendChild(document.createTextNode(count.dark));
}

function prepareTurn() {
    showPlayerTurnPopUp();
    showPlayPassBlockerPopUp();
    playPassButton.innerText = "";
    playPassButton.appendChild(document.createTextNode("Opponent's Turn"));

    gameSlot.innerText = "";

    if (color == "light")     { gameSlot.appendChild(document.createTextNode("Light's Turn")); }

    else if (color == "dark") { gameSlot.appendChild(document.createTextNode("Dark's Turn")); }

    if (canPlay()) {
        closePlayPassBlockerPopUp();
        playPassButton.innerText = "";
        playPassButton.appendChild(document.createTextNode("Click To Play"));
    }

    else if (nick == turn) {
        closePlayPassBlockerPopUp();
        playPassButton.innerText = "";
        playPassButton.appendChild(document.createTextNode("Click To Pass"));

        skip = false;
        notify(nick, pass, game, null);
    }
}

function canPlay() {
    return !skip && nick == turn;
}

function declareWinner() {
    gameSlot.innerText = "";

    if (winner == null)      { gameSlot.appendChild(document.createTextNode("You Stall")); }

    else if (winner == nick) { gameSlot.appendChild(document.createTextNode("You Won")); }

    else if (winner != nick) { gameSlot.appendChild(document.createTextNode("You Lost")); }

    // reset ? //
}

function login() {
    nick = nickSlot.value;
    pass = passSlot.value;
    register(nick, pass);
}

function logout() {
    logoutButton.style.display = "none";
    loginForm.style.display = "block";
}





function showSettingsPopUp() {
    settingsPopUp.style.display = "block";
}

function closeSettingsPopUp() {
    if (!isLogged) {
        errorSlot.innerText = "";
        errorSlot.appendChild(document.createTextNode("Login So You Can Join"));
    }

    else {
        settingsPopUp.style.display = "none";

        errorSlot.innerText = "";
        errorSlot.appendChild(document.createTextNode(""));
        gameSlot.innerText = "";
        gameSlot.appendChild(document.createTextNode("Dark's Turn"));

         join(group, nick, pass);
        prepareTurn();
    }
}

function showPlayerTurnPopUp() {
    playerTurnPopUp.style.display = "block";
}

function closePlayerTurnPopUp() {
    playerTurnPopUp.style.display = "none";
}

function showPlayPassBlockerPopUp() {
    playPassButtonBlockerPopUp.style.display = "block";
}

function closePlayPassBlockerPopUp() {
    playPassButtonBlockerPopUp.style.display = "none";
}





async function register(nick, pass) {
    const data = JSON.stringify({ nick: nick, pass: pass });

    await fetch(serverURL + "register", { method: "POST", body: data })
    .then(response => {
        if (response.ok) {
            isLogged = true;

            loginForm.style.display = "none";
            logoutButton.style.display = "block";

            errorSlot.innerText = "";
            errorSlot.appendChild(document.createTextNode(""));
        }

        else {
            errorSlot.innerText = "";
            errorSlot.appendChild(document.createTextNode("Wrong PassWord"));
        }

        console.log(response);
    })
    .catch(console.log);  
}

async function join(group, nick, pass) {
    const data = JSON.stringify({ group: group, nick: nick, pass: pass });

    await fetch(serverURL + "join", { method: "POST", body: data })
    .then(response => { return response.json(); })
    .then(response => {
        game = response.game;
        color = response.color;
        console.log(response);
        update();
    })
    .catch(console.log);
}

async function leave(nick, pass, game) {
    const data = JSON.stringify({ nick: nick, pass: pass, game: game });

    await fetch(serverURL + "leave", { method: "POST", body: data })
    .then(() => {
        isLogged = false;
        nick = "";
        pass = "";
        skip = false;
        logout();
    })
    .catch(console.log);
}

async function notify(nick, pass, game, move) {
    const data = JSON.stringify({ nick: nick, pass: pass, game: game, move: move });

    await fetch(serverURL + "notify", { method: "POST", body: data })
    .then(response => { return response.json(); })
    .then(console.log)  
    .catch(console.log)
}

function update() {
    const eventSource = new EventSource(serverURL + "update?nick=" + nick + "&game=" + game);

    eventSource.onmessage = function(event) {
        const receivedData = JSON.parse(event.data);

        if (receivedData.skip != undefined)  { skip = receivedData.skip; }


        if (receivedData.turn != undefined)  { turn = receivedData.turn; }

        if (receivedData.board != undefined) { 
            board = receivedData.board;
            placeDisks();
        }

        if (receivedData.count != undefined) { 
            count = receivedData.count;
            countDisks(); 
        }

        if (receivedData.winner != undefined) {
            winner = receivedData.winner;
            leave(nick, pass, game);
            eventSource.close();
            declareWinner();
        }

        prepareTurn();

        console.log(event.data);
    }
}