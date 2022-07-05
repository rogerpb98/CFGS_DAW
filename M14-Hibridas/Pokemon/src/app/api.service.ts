import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    public http: HttpClient
  ) { }

  addPokemon(data){
    return this.http.post('http://localhost/Hibridas/Pokemon/backend/pokemons/insert-pokemon.php', data);
  }
  deletePokemon(data){
    return this.http.post('http://localhost/Hibridas/Pokemon/backend/pokemons/delete-pokemon.php', data);
  }
  listPokemons(){
    return this.http.get('http://localhost/Hibridas/Pokemon/backend/pokemons/read.php');
  }

}
