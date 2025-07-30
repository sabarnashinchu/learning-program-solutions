// src/TrainerDetails.js
import React from 'react';
import { useParams } from 'react-router-dom';
import trainersMock from './TrainersMock';

function TrainerDetails() {
  const { id } = useParams();
  const trainer = trainersMock.find((t) => t.trainerId === id);

  if (!trainer) return <h3>Trainer not found</h3>;

  return (
    <div>
      <h2>Trainers Details</h2>
      <p><strong>{trainer.name} ({trainer.technology})</strong></p>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill, i) => (
          <li key={i}>{skill}</li>
        ))}
      </ul>
    </div>
  );
}

export default TrainerDetails;
