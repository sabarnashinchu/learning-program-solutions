import React from 'react';

function ListOfPlayers({ players }) {
  return (
    <ul>
      {players.map((item, index) => (
        <li key={index}>Mr. {item.name} {item.score}</li>
      ))}
    </ul>
  );
}

export default ListOfPlayers;
