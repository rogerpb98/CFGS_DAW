import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    public http: HttpClient
  ) { }

  /*
  {
    "user_name": "user123", "password": "password123",
  }
  */
  login(data){
    console.log(data);
    return this.http.post('https://private-e4014-foromotos.apiary-mock.com/login', data);
  }

  /*
  {
    "user_name": "user123", "password": "password123",
  }
  */
  register(data){
    return this.http.post('https://private-e4014-foromotos.apiary-mock.com/register', data);
  }

  /*
  {
    "api_key": "30adf6f2-f395-4da8-b29c-48aa24f5b091",
  }
  */
  logout(data){
    return this.http.post('https://private-e4014-foromotos.apiary-mock.com/logout', data);
  }

  /*
  {
    "api_key": "30adf6f2-f395-4da8-b29c-48aa24f5b091",
    "category": "General",
    "post_title": "Post title",
    "post_body": "Post body",
  }
  */
  upload(data){
    return this.http.post('https://private-e4014-foromotos.apiary-mock.com/upload', data);
  }

  getPosts(){
    return this.http.get('https://private-e4014-foromotos.apiary-mock.com/getposts');
  }

  getPostsById(post_id){
    return this.http.get(`https://private-e4014-foromotos.apiary-mock.com/getpostsbyid/${post_id}`);
  }

  /*
  {
    "api_key": "30adf6f2-f395-4da8-b29c-48aa24f5b091",
    "post_id": "312"
  }
  */
  remove(data){
    return this.http.post('https://private-e4014-foromotos.apiary-mock.com/remove', data);
  }
}
