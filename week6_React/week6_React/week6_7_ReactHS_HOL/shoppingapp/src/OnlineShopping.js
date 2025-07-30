// src/OnlineShopping.js
import React from 'react';
import Cart from './Cart';
import './App.css';

class OnlineShopping extends React.Component {
  render() {
    const CartInfo = [
      { itemname: "Laptop", price: 80000 },
      { itemname: "TV", price: 120000 },
      { itemname: "Washing Machine", price: 50000 },
      { itemname: "Mobile", price: 30000 },
      { itemname: "Fridge", price: 70000 }
    ];

    return (
      <div className="mydiv">
        <h1 className="heading">Items Ordered :</h1>
        <div className="table-container">
          <Cart item={CartInfo} />
        </div>
      </div>
    );
  }
}

export default OnlineShopping;
