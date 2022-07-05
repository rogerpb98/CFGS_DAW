import './MyCard.css';
import React from 'react';

function MyCard({name, img, isFat, isHappy, donuts}) {
    // const {name, img, price, color} = props

    return (
        <>
            <div className="card">
                <h2>{name}</h2>
                <img src={img} />
                <p>Is {isFat ? 'fat' : 'not fat'} and is {isHappy ? 'happy' : 'not happy'} eating {donuts} donuts</p>
            </div>
        </>
    )
}

export default MyCard