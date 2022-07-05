import { Component } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {
  nom;
  interpret;
  casa;

  constructor(
    public _apiService: ApiService
  ) { }


  addCharacter() {
    let data = new FormData();
    data.append("name", this.nom);
    data.append("interpret", this.interpret);
    data.append("casa", this.casa);
    
    this._apiService.addCharacter(data).subscribe((response) => {
      console.log(response);
    })
  }
}
