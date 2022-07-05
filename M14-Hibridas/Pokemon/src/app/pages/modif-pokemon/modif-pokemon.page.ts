import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-modif-pokemon',
  templateUrl: './modif-pokemon.page.html',
  styleUrls: ['./modif-pokemon.page.scss'],
})
export class ModifPokemonPage implements OnInit {
  name: any;
  type1;
  type2;
  height;
  weight;
  image;
  constructor(private route: ActivatedRoute, public _apiService: ApiService) {
    this.name = this.route.snapshot.paramMap.get("name");
    console.log(this.name);
  }

  ngOnInit() {
  }

  selectedFile(event) {
    this.image = event.target.files[0]
  }
  updatePokemon() {
    let data = new FormData();
    data.append("name", this.name);
    data.append("type1", this.type1);
    data.append("type2", this.type2);
    data.append("height", this.height);
    data.append("weight", this.weight);
    data.append("image", this.image);
    
    console.log(data);

    var cosa = (document.getElementById("formulary") as HTMLFormElement);
    cosa.reset();
    this._apiService.updatePokemon(data).subscribe((response) => {
      console.log(response);
    })
    //mensajito
    document.getElementById("popUp").style.display="block";
    setTimeout(function() {
      if (document.getElementById("popUp").style.display=="block") {
        document.getElementById("popUp").style.display="none";
      }
      //location.reload();
    }, 3000);
  }
}
