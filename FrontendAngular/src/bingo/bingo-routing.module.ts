import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './userList/userList.component';
import { TimerComponent } from './timer/timer.component';
import { TableroComponent } from './tablero/tablero.component';

const routes: Routes = [
  { path: '', component: UserListComponent},
  { path: 'lobby', component: TimerComponent},
  { path: 'game', component: TableroComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BingoRoutingModule { }
