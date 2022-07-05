import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../api.service';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.page.html',
  styleUrls: ['./pokedex.page.scss'],
})
export class PokedexPage implements OnInit {

  pokemons: any = [];

  constructor(
    public _apiService: ApiService
  ) { }

  ngOnInit() {
    this._apiService.listPokemons().subscribe((response) => {
      console.log(response);
     
      this.pokemons = response;
    })
  }
  deletePokemon(pkmnName) {
    let data = {
      name: pkmnName
    }
    console.log(data);

    this._apiService.deletePokemon(data).subscribe((response) => {
      console.log(response);
    })
    location.reload();
  }
 /* pokemons =  [
    {
      "name": "Hitmonchan",
      "type": ["fighting"],
      "height": 14,
      "weight": 502,
      "image": "hitmonchan.png"
    },
    {
      "name": "Hitmonlee",
      "type": ["fighting"],
      "height": 15,
      "weight": 498,
      "image": "hitmonlee.png"
    },
    {
      "name": "Hitmontop",
      "type": ["fighting"],
      "height": 14,
      "weight": 480,
      "image": "hitmontop.png"
    },
    {
      "name": "Torterra",
      "type": ["grass", "ground"],
      "height": 22,
      "weight": 3100,
      "image": "torterra.png"
    },
    {
      "name": "Seviper",
      "type": ["poison"],
      "height": 27,
      "weight": 525,
      "image": "seviper.png"
    },
  ];
  */
}
