import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  return (
    <div>
      <h2 style={{ textAlign: 'center' }}>Cohorts Details</h2>
      <div style={{ display: 'flex', justifyContent: 'center' }}>
        <CohortDetails
          name="INTADMDF10 - .NET FSD"
          status="Scheduled"
          startDate="22-Feb-2022"
          coach="Aasthma"
          trainer="Jojo Jose"
        />
        <CohortDetails
          name="ADM21JF014 - Java FSD"
          status="Ongoing"
          startDate="10-Sep-2021"
          coach="Apoorv"
          trainer="Elisa Smith"
        />
        <CohortDetails
          name="CDBJF21025 - Java FSD"
          status="Ongoing"
          startDate="24-Dec-2021"
          coach="Aasthma"
          trainer="John Doe"
        />
      </div>
    </div>
  );
}

export default App;
