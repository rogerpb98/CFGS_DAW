import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    public http: HttpClient
  ) { }

  addCharacter(data){
    return this.http.post('http://localhost/Hibridas/examen/src/back/insert.php', data);
  }
  deleteCharacter(data){
    return this.http.post('http://localhost/Hibridas/examen/src/back/delete.php', data);
  }
  updateFavs(data){
    return this.http.post('http://localhost/Hibridas/examen/src/back/updateFavs.php', data);
  }
  getCharacters(){
    return this.http.get('http://localhost/Hibridas/examen/src/back/read.php');
  }
  filterHouse(house){
    return this.http.get(`http://localhost/Hibridas/examen/src/back/filterHouse.php?house=${house}`);
  }
}
