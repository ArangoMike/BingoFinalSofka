import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', loadChildren: () => import('../authorization/authorization.module').then(m => m.AuthorizationModule) },
  { path: 'bingo', loadChildren: () => import('../bingo/bingo.module').then(m => m.BingoModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
