import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddpokemonsPage } from './addpokemons.page';

const routes: Routes = [
  {
    path: '',
    component: AddpokemonsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AddpokemonsPageRoutingModule {}
