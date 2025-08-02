import React from 'react';

function ScoreBelow70({ players }) {
  const filtered = players.filter(p => p.score < 70);

  return (
    <ul>
      {filtered.map((item, index) => (
        <li key={index}>Mr. {item.name} {item.score}</li>
      ))}
    </ul>
  );
}

export default ScoreBelow70;
