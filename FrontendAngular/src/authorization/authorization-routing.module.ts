import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SiginComponent } from './sigin/sigin.component';

const routes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'sigin', component: SiginComponent}
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthorizationRoutingModule { }
