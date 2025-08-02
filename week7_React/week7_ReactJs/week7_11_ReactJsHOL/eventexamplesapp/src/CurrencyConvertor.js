import React, { useState } from "react";

function CurrencyConvertor() {
  const [amount, setAmount] = useState("");
  const [currency, setCurrency] = useState("Euro");

  const handleSubmit = (e) => {
    e.preventDefault();
    const converted = amount * 80; // 1 Euro = 80 Rupees
    alert(`Converting to ${currency} Amount is ${converted}`);
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginTop: "10px" }}>
      <label>Amount:</label>
      <input
        type="number"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
        required
        style={{ marginLeft: "10px" }}
      />
      <br /><br />

      <label>Currency:</label>
      <input
        type="text"
        value={currency}
        onChange={(e) => setCurrency(e.target.value)}
        style={{ marginLeft: "5px" }}
      />
      <br /><br />

      <button type="submit">Submit</button>
    </form>
  );
}

export default CurrencyConvertor;
