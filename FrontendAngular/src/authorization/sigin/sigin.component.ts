import { Component } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthorizationService } from '../services/authorization.service';


@Component({
  selector: 'app-sigin',
  templateUrl: './sigin.component.html',
  styleUrls: ['./sigin.component.scss']
})
export class SiginComponent {

  forma: FormGroup;

  constructor(private fb: FormBuilder,
    private authorizationService: AuthorizationService, private router: Router) {

    this.crearFormulario();
  }

  get nicknameNoValido() {
    return this.forma.get('nickname')?.invalid && this.forma.get('nickname')?.touched
  }

  get passNoValido() {
    return this.forma.get('password')?.invalid && this.forma.get('password')?.touched
  }
  get correoNoValido() {
    return this.forma.get('email')?.invalid && this.forma.get('email')?.touched
  }



  crearFormulario(): void {
    this.forma = this.fb.group({
      nickname: ['', [Validators.required, Validators.minLength(5)]],
      password: ['', [Validators.required, Validators.minLength(5)]],
      email: ['', [Validators.required, Validators.email]],

    });
  }

  guardar() {


    if (this.forma.invalid) {

       return Object.values(this.forma.controls).forEach( control => {
        control.markAllAsTouched();
      })

    } else {
      // Aquí hago el consumo del api post
      const user = this.forma.value;
      console.log(user);
     return this.authorizationService.createUser(user).subscribe(
        res => {
          alert('Registro Exitoso!  ')
          this.router.navigate(['/'])

        })
    }
  }
}
