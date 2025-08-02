import React from "react";
import "./App.css";
import officeImg from './assets/office.jpg';


function App() {
  const office = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai",
    Image:  officeImg

  };

  const rentStyle = {
    color: office.Rent <= 60000 ? "red" : "green",
  };

  return (
    <div className="App">
      <h1>Office Space , at Affordable Range</h1>
      <img src={office.Image} alt="Office Space" width="25%" height="25%" />
      <h2>
        <strong>Name:</strong> {office.Name}
      </h2>
      <h3 style={rentStyle}>
        <strong>Rent:</strong> Rs. {office.Rent}
      </h3>
      <h3>
        <strong>Address:</strong> {office.Address}
      </h3>
    </div>
  );
}

export default App;
