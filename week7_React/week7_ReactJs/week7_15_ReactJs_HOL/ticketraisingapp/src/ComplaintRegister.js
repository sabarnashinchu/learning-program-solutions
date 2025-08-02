import React from 'react';
import './App.css';

class ComplaintRegister extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: '',
      complaint: '',
      numberHolder: Math.floor(Math.random() * 100) + 1
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    const msg = `Thanks ${this.state.ename}\nYour Complaint was Submitted.\nTransaction ID is: ${this.state.numberHolder}`;
    alert(msg);
  }

  render() {
    return (
      <div className="container">
        <div className="heading">Register your complaints here!!!</div>
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label>Name:</label>
            <input
              type="text"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
              required
            />
          </div>
          <div className="form-group">
            <label>Complaint:</label>
            <textarea
              name="complaint"
              value={this.state.complaint}
              onChange={this.handleChange}
              required
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
