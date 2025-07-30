import React, { Component } from 'react';
import './App.css';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <button 
          style={{ marginRight: '30px', backgroundColor: '#d4edda', border: '1px solid green', padding: '10px', borderRadius: '5px' }} 
          onClick={this.updateEntry}>
          <b>Login</b> {this.state.entrycount} People Entered!!!
        </button>

        <button 
          style={{ backgroundColor: '#d4edda', border: '1px solid green', padding: '10px', borderRadius: '5px' }} 
          onClick={this.updateExit}>
          <b>Exit</b> {this.state.exitcount} People Left!!!
        </button>
      </div>
    );
  }
}

function App() {
  return (
    <div className="App">
      <CountPeople />
    </div>
  );
}

export default App;
