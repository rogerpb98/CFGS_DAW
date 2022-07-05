import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../api.service';

@Component({
  selector: 'app-addpokemons',
  templateUrl: './addpokemons.page.html',
  styleUrls: ['./addpokemons.page.scss'],
})
export class AddpokemonsPage implements OnInit {

  name;
  type1;
  type2;
  height;
  weight;
  image;

  constructor(
    public _apiService: ApiService
  ) { }

  ngOnInit() {
    
  }
  
  addPokemon() {
    let tipos = new Array();
    (this.type1!="") ? tipos.push(this.type1) : console.log();
    (this.type2!="") ? tipos.push(this.type2) : console.log();
    let data = {
      name: this.name,
      type: tipos,
      height: this.height,
      weight: this.weight,
      image: this.image
    }
    console.log(data);

    var cosa = (document.getElementById("formulary") as HTMLFormElement);
    cosa.reset();
    this._apiService.addPokemon(data).subscribe((response) => {
      console.log(response);
    })
    //mensajito
    document.getElementById("popUp").style.display="block";
    setTimeout(function() {
      if (document.getElementById("popUp").style.display=="block") {
        document.getElementById("popUp").style.display="none";
      }
      location.reload();
    }, 3000);
  }
}
