import React from 'react';
import ListOfPlayers from './ListOfPlayers';
import ScoreBelow70 from './ScoreBelow70';
import { OddPlayers, EvenPlayers, ListOfIndianPlayers } from './IndianPlayers';

function App() {
  const flag = true; // Toggle between true or false

  const players = [
    { name: 'Jack', score: 50 },
    { name: 'Michael', score: 70 },
    { name: 'John', score: 40 },
    { name: 'Ann', score: 61 },
    { name: 'Elisabeth', score: 61 },
    { name: 'Sachin', score: 95 },
    { name: 'Dhoni', score: 100 },
    { name: 'Virat', score: 84 },
    { name: 'Jadeja', score: 64 },
    { name: 'Raina', score: 75 },
    { name: 'Rohit', score: 80 }
  ];

  const T20Players = ['First Player', 'Second Player', 'Third Player'];
  const RanjiPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
  const IndianPlayers = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Yuvaraj5', 'Raina6'];
  const mergedPlayers = [...T20Players, ...RanjiPlayers];

  if (flag === true) {
    return (
      <div>
        <h1>List of Players</h1>
        <ListOfPlayers players={players} />

        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <ScoreBelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <h1>Indian Team</h1>

        <h2>Odd Players</h2>
        {OddPlayers(IndianPlayers)}

        <hr />
        <h2>Even Players</h2>
        {EvenPlayers(IndianPlayers)}

        <hr />
        <h2>List of Indian Players Merged:</h2>
        <ListOfIndianPlayers players={mergedPlayers} />
      </div>
    );
  }
}

export default App;
