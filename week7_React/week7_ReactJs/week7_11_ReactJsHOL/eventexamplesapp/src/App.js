import React, { useState } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {
  const [count, setCount] = useState(0);

  // Increment with multiple methods
  const increment = () => {
    setCount(count + 1);
    sayHello(); // Call second function
  };

  const decrement = () => {
    setCount(count - 1);
  };

  const sayHello = () => {
    alert("Hello! Member1");
  };

  // Say Welcome button
  const sayWelcome = (msg) => {
    alert(msg);
  };

  // Synthetic event
  const handlePress = () => {
    alert("I was clicked");
  };

  return (
    <div style={{ padding: "30px", textAlign: "center" }}>
      <h1>{count}</h1>
      <button onClick={increment}>Increment</button> &nbsp;
      <button onClick={decrement}>Decrement</button> <br /><br />
      
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button> &nbsp;
      <button onClick={handlePress}>Click on me</button>

      <h2 style={{ color: "green", marginTop: "20px" }}>Currency Convertor!!!</h2>
      <CurrencyConvertor />
    </div>
  );
}

export default App;
