import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-scroll',
  templateUrl: './scroll.page.html',
  styleUrls: ['./scroll.page.scss'],
})
export class ScrollPage implements OnInit {
  pokemons = [];

  constructor() {
    this.addMoreItems();
  }
  /*
  offset=offset+limit
  */


  ngOnInit() {
  }

  loadData(event) {
    setTimeout(() => {
      console.log('Done');
      this.addMoreItems()
      event.target.complete();
    }, 500);
  }
  addMoreItems(){
    for(let i=0;i<50;i++){
      this.pokemons.push(i);
    }
  }


}
