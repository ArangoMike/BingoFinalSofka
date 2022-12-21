import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  constructor(private http: HttpClient) { }

  validateUser(user: any): Observable<any> {
    return this.http.patch(`http://localhost:8080/login`, user);
  }
  createUser(user: any): Observable<any> {
    return this.http.post(`http://localhost:8080/createUser`, user);
  }

  // createBingo() {
  //   return this.http.get(`http://localhost:8080/lobby`);
  // }
}
