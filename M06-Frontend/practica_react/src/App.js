import './App.css';
import MyCard from './MyCard'
import img_homer from './img/homer.webp'
import img_bart from './img/bart.webp'
import img_marge from './img/marge.webp'
import img_lisa from './img/lisa.webp'
import img_maggie from './img/maggie.webp'
import img_unknown from './img/unknown.png'
import { useState } from 'react';

function App() {
  const simpsons = [
    {name: "Homer", img: img_homer, isFat: true, isHappy: true, donuts: 20},
    {name: "Bart", img: img_bart, isFat: false, isHappy: false, donuts: 10},
    {name: "Marge", img: img_marge, isFat: true, isHappy: false, donuts: 12},
    {name: "Lisa", img: img_lisa, isFat: false, isHappy: false, donuts: 2},
    {name: "Maggie", img: img_maggie, isFat: false, isHappy: true, donuts: 3},
  ]
  const familiaSimpson = simpsons.map((s) => 
    <MyCard key={s.name} name={s.name} img={s.img} isFat={s.isFat} isHappy={s.isHappy} donuts={s.donuts}/>
  )

  return (
    <>
      <div className="container">
        {familiaSimpson}
      </div>
    </>
  );
}

export default App;
