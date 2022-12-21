import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { AuthorizationRoutingModule } from './authorization-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SiginComponent } from './sigin/sigin.component';



@NgModule({
  declarations: [
    LoginComponent,
    SiginComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    AuthorizationRoutingModule
  ]
})
export class AuthorizationModule { }
