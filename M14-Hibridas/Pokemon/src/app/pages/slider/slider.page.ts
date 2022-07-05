import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.page.html',
  styleUrls: ['./slider.page.scss'],
})
export class SliderPage implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  imagenes = [
    'Image1.jpeg',
    'Image2.jpeg',
    'Image3.jpeg'
  ];
}
