import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ModifPokemonPageRoutingModule } from './modif-pokemon-routing.module';

import { ModifPokemonPage } from './modif-pokemon.page';
import { ComponentsModule } from '../../components/components.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ModifPokemonPageRoutingModule,
    ComponentsModule,
    ReactiveFormsModule
  ],
  declarations: [ModifPokemonPage]
})
export class ModifPokemonPageModule {}
