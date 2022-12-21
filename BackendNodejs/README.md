## SOFKA Taller caso práctico de una página dinámica.

## Descripcion:
En este proyecto se trata de dar solución al taller 5 de la Cantera Nivel II de Sofka Technologies donde se califica el uso de NodeJS con Express y la base de datos
MongoDB además del modelo MVC.
  
   
## Desarrollo:

### Se pide un request POST para la creacion del juego.  
* POST http://localhost:8080/createGame 
* Pagina donde se consume el POST http://localhost:8080/createGame
* Se recibe por Body los nombres de los jugadores
* Resultado guía a esperar
<pre>
{
    "id": "fffff-ggg-jjjjj",
    "gamers": {
        "5257b4d6-5c87-4871-93c3-b2b9ce04d706": {
            "id": "5257b4d6-5c87-4871-93c3-b2b9ce04d706",
            "name": "Raul Andres"
        },
        "8dda6205-f54c-4643-a017-71b6f0353319": {
            "id": "8dda6205-f54c-4643-a017-71b6f0353319",
            "name": "Juan"
        },
        "e5834d8e-5195-41fc-993e-c731dbce4fab": {
            "id": "e5834d8e-5195-41fc-993e-c731dbce4fab",
            "name": "Pedro"
        }
    },
    "inProgress": false,
    "winner": {
        "id": "e5834d8e-5195-41fc-993e-c731dbce4fab",
        "name": "Pedro"
    }
}


</pre>

### Request para consultar el juego y su estado  
* GET http://localhost:8080/game/:gameid (se envía el id del juego por parámetros en el consumo )
* Pagina donde se consume el GET http://localhost:8080/game
* Resultado guía a esperar
<pre>
{
    "id": "72e14c37-231c-46e8-9b26-fab879ca9992",
    "gamers": {
        "49e033a5-eadc-4085-a15b-ea3f374c5975": {
            "id": "49e033a5-eadc-4085-a15b-ea3f374c5975",
            "name": "Camilo"
        },
        "49e033a5-eadc-4085-a15b-ea3f374c5975": {
            "id": "49e033a5-eadc-4085-a15b-ea3f374c5975",
            "name": "Cristian"
        },
        "49e033a5-eadc-4085-a15b-ea3f374c5975": {
            "id": "49e033a5-eadc-4085-a15b-ea3f374c5975",
            "name": "Daniela"
        }
    },
    "inProgress": false,
    "winner": {
        "id": "49e033a5-eadc-4085-a15b-ea3f374c5975",
        "name": "Cristian"
    }
}
</pre>

### Request para determinar el ganador del juego  
* GET http://localhost:3000/game/:gameid/winner  (se envía el id del juego por parámetros en el consumo)
* Resultado guía a esperar
<pre>
  {
    "id": "e5834d8e-5195-41fc-993e-c731dbce4fab",
    "name": "Pedro"
}

 </pre>


### Request para iniciar el juego con la apuesta por cada jugador  
* POST http://localhost:3000/startGame  
* Se recibe por Body el id del juego y la apuesta de los 3 jugadores ya creados
* Resultado guía a esperar
<pre>
{
    "id": "fffff-ggg-jjjjj",
    "type": "",
    "gamerBet": {
        "5257b4d6-5c87-4871-93c3-b2b9ce04d706": 3,
        "8dda6205-f54c-4643-a017-71b6f0353319": 6,
        "e5834d8e-5195-41fc-993e-c731dbce4fab": 5
    }
}

</pre>
  
## Contribuidor:
* Michael Arango Nieto - michaelarango0531@gmail.com
