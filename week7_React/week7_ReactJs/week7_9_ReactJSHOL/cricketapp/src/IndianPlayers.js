import React from 'react';

export function OddPlayers([first,, third,, fifth]) {
  return (
    <ul>
      <li>First : {first}</li>
      <li>Third : {third}</li>
      <li>Fifth : {fifth}</li>
    </ul>
  );
}

export function EvenPlayers([, second,, fourth,, sixth]) {
  return (
    <ul>
      <li>Second : {second}</li>
      <li>Fourth : {fourth}</li>
      <li>Sixth : {sixth}</li>
    </ul>
  );
}

export function ListOfIndianPlayers({ players }) {
  return (
    <ul>
      {players.map((player, index) => (
        <li key={index}>Mr. {player}</li>
      ))}
    </ul>
  );
}
