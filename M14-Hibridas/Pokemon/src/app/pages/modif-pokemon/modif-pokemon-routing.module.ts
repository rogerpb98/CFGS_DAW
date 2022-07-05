import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ModifPokemonPage } from './modif-pokemon.page';

const routes: Routes = [
  {
    path: '',
    component: ModifPokemonPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ModifPokemonPageRoutingModule {}
