import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss'],
})
export class CardComponent implements OnInit {

  constructor() { }

  @Input() img:string
  @Input() type1:string
  @Input() name:string

  ngOnInit() {}

}
