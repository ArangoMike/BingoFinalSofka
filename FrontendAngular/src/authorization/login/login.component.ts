import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthorizationService } from '../services/authorization.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder,
    private authorizationService: AuthorizationService, private router: Router) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.loginForm = this.formBuilder.group({
      nickname: ['', Validators.required],
      password: ['', Validators.required,]
    });
  }

  validateUser() {
    if (this.loginForm.valid) {
      const user = this.loginForm.value;
      console.log(user);
      this.authorizationService.validateUser(user).subscribe(
        res => {

          if (res.juegoId && res.usuarioId) {
            sessionStorage.setItem('user', JSON.stringify(res))
            this.router.navigate(['/bingo/lobby'])

          }else{
            alert(JSON.stringify(res))
          }        


        })
    } else {
      alert('Ingresa datos correctos.')
    }
  }


  routerSigIn() {
    this.router.navigate(['/sigin'])
  }

}
