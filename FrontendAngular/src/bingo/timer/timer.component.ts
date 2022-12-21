import { Component, OnInit } from '@angular/core';
import { BingoService } from '../services/bingo.service';
import { Router } from '@angular/router';

const countdown = require('countdown');


interface Time {
  minutes: number,
  seconds: number
}

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.scss']
})
export class TimerComponent implements OnInit {

  time: Time;
  timerId: any;
  intervalId: any;
  user: any;



  constructor(private bingoService: BingoService, private router: Router) { }


  ngOnInit(): void {

    const user = sessionStorage.getItem('user')
    if (user) {
      this.user = JSON.parse(user)
    }

    this.bingoStartDate()

    this.intervalId = setInterval(() => {

      this.listUsers()
    }, 4000)

  }

  /* Método que recibe los datos del juego que ya inicio 
  y crear la cuenta atras para comenzar el juego. 
  */
  bingoStartDate() {

    this.bingoService.getBingoList().subscribe(
      res => {
        for (const i of res) {
          if (i.estadoJuego == "iniciando") {
            console.log(i.fechaInicio);

            const date = new Date(i.fechaInicio);

            this.timerId = countdown(date, (ts: any) => {

              this.time = ts;
              if (this.time.minutes == 0 && this.time.seconds == 0) {
                clearInterval(this.timerId);
                clearInterval(this.intervalId);
                this.statusGame();
                this.router.navigate(['/bingo/game']);

              }
            });
          }
        }
      })
  }

  /* Método
  */
  listUsers() {
    const listado = document.querySelectorAll('div.tarea')
    listado.forEach((e) => {
      e.remove()
    })

    this.bingoService.getUsersList().subscribe(
      res => {
        Object.keys(res).map(key => {
          const usuarios = res[key]
          this.showUser(usuarios, res)
        })
      })
  }
  /*
  
  */
  showUser(usuario: any, db: any) {

    const listadoUsuarios = document.querySelector('.listado-usuarios')

    let divUsuario = document.createElement('div')
    let nombreUsuario = document.createElement('h3')
    let online = document.createElement('p')

    nombreUsuario.innerHTML = usuario.nickname
    online.innerHTML = 'En línea'

    divUsuario.classList.add('tarea')


    divUsuario.appendChild(nombreUsuario)
    divUsuario.appendChild(online)

    listadoUsuarios?.appendChild(divUsuario)
  }

  /*Método para cambiar el estado del Juego, en este
  caso, ponerlo "en curso"
  */
  statusGame() {

    const body = { estadoJuego: 'en curso' }

    const id = this.user.juegoId

    this.bingoService.patchStatusGame(body, id).subscribe(
      res => {
        console.log(res, 'empezo esto');

      })
  }

}

