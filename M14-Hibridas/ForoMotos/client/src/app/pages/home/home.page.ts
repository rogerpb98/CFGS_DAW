import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';
import { getStorage } from '../../../services/storage';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage implements OnInit {

  posts;
  api_key;
  category;
  post_title;
  post_body;

  constructor(
    public _apiService: ApiService,
    private router: Router
  ) { }

  async ngOnInit() {
    await this.getDataStorage();
    if (!!this.api_key) {
      this.getPosts()
    } else {
      this.router.navigate(['/login'])
    }
  }

  getPosts() {
    this._apiService.getPosts().subscribe((response) => {
      this.posts = response;
      console.log(this.posts);
    })
  }

  remove(id) {
    console.log(id)
    let data = {
      api_key: this.api_key,
      post_id: id,
    };
    this._apiService.remove(data).subscribe((response) => {
      console.log(response);
    })
  }

  upload() {
    let data = new FormData();
    data.append("api_key", this.api_key);
    data.append("category", this.category);
    data.append("post_title", this.post_title);
    data.append("post_body", this.post_body);

    this._apiService.upload(data).subscribe((response) => {
      console.log(response);
    })
  }

  async getDataStorage(){
    this.api_key = await getStorage('api-key');
  }
}
