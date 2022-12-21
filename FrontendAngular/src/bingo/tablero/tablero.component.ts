import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { BingoService } from '../services/bingo.service';


@Component({
  selector: 'app-tablero',
  templateUrl: './tablero.component.html',
  styleUrls: ['./tablero.component.scss']
})
export class TableroComponent implements OnInit {


  @ViewChild('numlist') numList: ElementRef;
  @ViewChild('numBallots') numBallots: ElementRef;
  user: any;
  e = 0;
  intervalId: any;
  i = 0;
  tableHere: any;
  ballots: String[] = [""];

  constructor(private bingoService: BingoService, private router: Router, private renderer2: Renderer2) { }


  ngOnInit(): void {

    const user = sessionStorage.getItem('user')
    if (user) {
      this.user = JSON.parse(user)
    }


    this.bingoTable();

    this.intervalId = setInterval(() => {
      this.i++;
      this.bingoBallot(this.i);

      if (this.i == 75) {
        clearInterval(this.intervalId);
      }
    }, 2000)

  }

  /*Método usado en el ngOninit en el cual haremos
  todas las validaciones y mostraremos la tabla
  */
  bingoTable() {

    JSON.stringify(this.user)

    const body = {
      usuarioId: { "id": this.user.usuarioId }
    }

    this.bingoService.getTableList().subscribe(
      res => {
        this.bingoTableTest(res, body)
      })

  }

  /*Método para traer el tablero de bingo del backend, ya sea que 
  haya sido creado antes o se cree por primera vez.
  */
  bingoTableTest(tables: any, body: any) {

    /* Recorremos y validamos las tablas del juego 
       si hay una ya con el usuario que entró
    */
    Object.keys(tables).map(key => {
      const table = tables[key]

      if (table.usuarioId.id == body.usuarioId.id) {
        this.e = this.e + 1;
        for (let i = 1; i < 6; i++) {
          this.showNumberTable(table, `${i}`)
        }
      }
    })

    /* sí nuestro recorrido anterior no encontro 
    tabla para este usuario aquí le creamos una 
    */
    if (this.e == 0) {
      this.bingoService.postBingoTable(body).subscribe(
        res => {
          for (let i = 1; i < 6; i++) {
            this.showNumberTable(res, `${i}`)
          }
        })
    }
  }

  /* Método para consumir Api y recibir una balota del "locutor"
  id= id de la balota que queremos traer del backend.
  */
  bingoBallot(id: any) {
    this.bingoService.getBallot(id).subscribe(
      res => {
        this.ballots.push(res.balota)
        this.showNumberBallot(res)


      }
    )
  }


  /* Método para pintar en pantalla la tabla generada al usuario 
  para jugar.
  tablero = toda la tabla recibida por el backend
  numeroFila = iterador que usaremos para pintar la tabla
  */

  showNumberTable(tablero: any, numeroFila: string) {

    const tBody = this.numList.nativeElement;

    const tr = this.renderer2.createElement('tr')

    for (let i in tablero) {

      if (i.includes(numeroFila)) {

        const td = this.renderer2.createElement('td');
        this.renderer2.addClass(td, 'icono')
        td.innerHTML = tablero[i];

        this.renderer2.appendChild(tr, td);

      }

      this.renderer2.appendChild(tBody, tr);
    }
  }

  /* Método para pintar en pantalla la balota que vamos sacando
  ballot = balota recibida por la Api
  */
  showNumberBallot(ballot: any) {

    const numBallots = this.numBallots.nativeElement;
    const p = this.renderer2.createElement('p')
    this.renderer2.addClass(p, 'tarea')

    p.innerHTML = ballot.balota;
    this.renderer2.appendChild(numBallots, p);

  }

  validateTable() {
    this.validationsToWin(this.ballots, this.tableHere)
  }


  /* Método para validar si el usuario Gano
  ballots = balotas que han salido hasta el momento
  t = tabla del usuario
  */
  validationsToWin(ballots: String[], t: any) {

    const b = ballots.join();

    if (b.includes(`${t.b1}`) &&
      b.includes(`${t.o1}`) &&
      b.includes(`${t.b5}`) &&
      b.includes(`${t.o5}`)) {

      console.log('Ganoo');
    } else if (b.includes(`${t.b1}`) &&
      b.includes(`${t.i2}`) &&
      b.includes(`${t.g4}`) &&
      b.includes(`${t.o5}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.o1}`) &&
      b.includes(`${t.g2}`) &&
      b.includes(`${t.i4}`) &&
      b.includes(`${t.b5}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.b1}`) &&
      b.includes(`${t.b2}`) &&
      b.includes(`${t.b3}`) &&
      b.includes(`${t.b4}`) &&
      b.includes(`${t.b5}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.i1}`) &&
      b.includes(`${t.i2}`) &&
      b.includes(`${t.i3}`) &&
      b.includes(`${t.i4}`) &&
      b.includes(`${t.i5}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.n1}`) &&
      b.includes(`${t.n2}`) &&
      b.includes(`${t.n4}`) &&
      b.includes(`${t.n5}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.g1}`) &&
      b.includes(`${t.g2}`) &&
      b.includes(`${t.g3}`) &&
      b.includes(`${t.g4}`) &&
      b.includes(`${t.g5}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.o1}`) &&
      b.includes(`${t.o2}`) &&
      b.includes(`${t.o3}`) &&
      b.includes(`${t.o4}`) &&
      b.includes(`${t.o5}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.b1}`) &&
      b.includes(`${t.i1}`) &&
      b.includes(`${t.n1}`) &&
      b.includes(`${t.g1}`) &&
      b.includes(`${t.o1}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.b2}`) &&
      b.includes(`${t.i2}`) &&
      b.includes(`${t.n2}`) &&
      b.includes(`${t.g2}`) &&
      b.includes(`${t.o2}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.b3}`) &&
      b.includes(`${t.i3}`) &&
      b.includes(`${t.g3}`) &&
      b.includes(`${t.o3}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.b4}`) &&
      b.includes(`${t.i4}`) &&
      b.includes(`${t.n4}`) &&
      b.includes(`${t.g4}`) &&
      b.includes(`${t.o4}`)) {

      console.log('Gano mijo!');
    } else if (b.includes(`${t.b5}`) &&
      b.includes(`${t.i5}`) &&
      b.includes(`${t.n5}`) &&
      b.includes(`${t.g5}`) &&
      b.includes(`${t.o5}`)) {

      console.log('Gano mijo!');
    } else {
      console.log('Intencion de fraude, DESCALIFICADO!');

    }


  }

}
