import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserListComponent } from './userList/userList.component';
import { BingoRoutingModule } from './bingo-routing.module';
import { TimerComponent } from './timer/timer.component';



@NgModule({
  declarations: [
    UserListComponent,
    TimerComponent
  ],
  imports: [
    CommonModule,
    BingoRoutingModule,
  ]
})
export class BingoModule { }
