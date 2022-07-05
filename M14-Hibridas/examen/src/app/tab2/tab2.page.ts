import { Component } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {
  characters: any = [];

  casaH;

  constructor(
    public _apiService: ApiService
  ) { }
  ngOnInit() {
    this.omplirArray();
  }
  updateFavs(favs, id) {
    favs++;
    let data = {
      favs: favs,
      id: id
    };
    console.log(data.favs, data.id);
    this._apiService.updateFavs(data).subscribe((response) => {
      console.log(response);
    })
    setTimeout(function() {
      location.reload();
    }, 1000);
  }
  omplirArray() {
    this._apiService.getCharacters().subscribe((response) => {
      console.log(response);
     
      this.characters = response;
    })
  }
  deleteCharacter(id) {
    let data = {
      id: id
    };
    
    this._apiService.deleteCharacter(data).subscribe((response) => {
      console.log(response);
    })
    setTimeout(function() {
      location.reload();
    }, 1000);
    
  }
  filterHouse(){
    console.log(this.casaH);

    if (this.casaH==="sense") {
      this.omplirArray();
      return;
    }

    this._apiService.filterHouse(this.casaH).subscribe((response) => {
      console.log(response);
     
      this.characters = response;
    })

  }

}
