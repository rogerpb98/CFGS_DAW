import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';
import { setStorage, getStorage } from '../../../services/storage';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  username;
  password;
  api_key;

  constructor(
    public _apiService: ApiService,
    private router: Router
  ) { }

  async ngOnInit() {
    await this.getDataStorage();
    if (!!this.api_key) {
      this.router.navigate(['/home'])
    }
  }

  login() {
    let data = {
      user_name : this.username,
      password : this.password,
    }

    var cosa = (document.getElementById("formulary") as HTMLFormElement);
    cosa.reset();
    this._apiService.login(data).subscribe((response) => {
      this.api_key = response['api_key'];
      console.log(this.api_key);

      if (!!this.api_key) {
        setStorage('api-key', this.api_key);
        this.router.navigate(['/home'])
      }
    })
  }

  register() {
    let data = {
      user_name : this.username,
      password : this.password,
    }

    var cosa = (document.getElementById("formulary") as HTMLFormElement);
    cosa.reset();
    this._apiService.register(data).subscribe((response) => {
      this.api_key = response['api_key'];
      console.log(this.api_key);

      if (!!this.api_key) {
        setStorage('api-key', this.api_key);
        this.router.navigate(['/home'])
      }
    })
  }

  async getDataStorage(){
    this.api_key = await getStorage('api-key');
  }
}
