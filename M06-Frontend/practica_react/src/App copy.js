import './App.css';
import img_homer from './img/homer.webp'
import img_bart from './img/bart.webp'
import img_marge from './img/marge.webp'
import img_unknown from './img/unknown.png'

function App() {
  let names = ["Homer", "Bart", "Marge"];

  const changeImg = (e) => {
    if (e.target.src.includes(img_unknown)) {
      e.target.style.visibility='hidden'
      e.target.parentNode.style.border='none'
    }
    else {
      e.target.src=img_unknown
      e.target.parentNode.style.backgroundColor='white'
      console.log(e.target.nextElementSibling)
    }
  }
  const changeTxt = (e) => {
    if (e.target.innerHTML=='Clicked') {
      e.target.innerHTML=''
    }
    else {
      e.target.innerHTML='Clicked'
    }
  }
  return (
    <div className="App">
      <div className="box">
        <img onClick={changeImg} src={img_homer} alt={names[0]}/>
        <div onClick={changeTxt} className="name">{names[0]}</div>
      </div>
      <div className="box">
        <img onClick={changeImg} src={img_bart} alt={names[1]}/>
        <div onClick={changeTxt} className="name">{names[1]}</div>
      </div>
      <div className="box">
        <img onClick={changeImg} src={img_marge} alt={names[2]}/>
        <div onClick={changeTxt} className="name">{names[2]}</div>
      </div>
    </div>
  );
}

export default App;
