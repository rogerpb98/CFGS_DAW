import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { getStorage } from '../../../services/storage';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.page.html',
  styleUrls: ['./post.page.scss'],
})
export class PostPage implements OnInit {
  post_id;
  main_post;
  comments;
  api_key;
  post_title;
  post_body;

  isDataAvailable:boolean = false;

  constructor(
    public _apiService: ApiService,
    private router: Router,
    private route: ActivatedRoute
    ) {
    this.post_id = this.route.snapshot.paramMap.get("post_id");
    console.log(this.post_id);
  }

  async ngOnInit() {
    await this.getDataStorage();
    if (!!this.api_key) {
      this.getPostsById(this.post_id)
    } else {
      this.router.navigate(['/login'])
    }
  }

  upload() {
    let data = new FormData();
    data.append("api_key", this.api_key);
    data.append("post_title", this.post_title);
    data.append("post_body", this.post_body);
    data.append("post_parent", this.post_id);

    this._apiService.upload(data).subscribe((response) => {
      console.log(response);
    })
  }

  getPostsById(post_id) {
    this._apiService.getPostsById(post_id).subscribe((response) => {
      let posts = response;
      this.main_post=posts['parent'];
      this.comments=posts['children'];
      this.isDataAvailable=true;
    })
  }

  async getDataStorage(){
    this.api_key = await getStorage('api-key');
  }

}
