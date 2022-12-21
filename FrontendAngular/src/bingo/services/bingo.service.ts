import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BingoService {

  constructor(private http: HttpClient) { }

  getBingoList(): Observable<any> {
    return this.http.get(`http://localhost:9090/games`);
  }
  
  getUsersList(): Observable<any> {
    return this.http.get(`http://localhost:8080/lobby/users`);
  }

  getTableList(): Observable<any> {
    return this.http.get(`http://localhost:9090/tablasbingo`);
  }

  postBingoTable(usuarioId: any): Observable<any>{
    return this.http.post('http://localhost:9090/tablabingo',usuarioId)
  }


  patchStatusGame(estadoJuego: any, id: any): Observable<any>{
    return this.http.patch(`http://localhost:9090/juego/estadojuego/${id}`,estadoJuego)
  }

  getBallot(id:any):Observable<any>{
    return this.http.get(`http://localhost:9090/ballot/${id}`);
  }
  
  }




