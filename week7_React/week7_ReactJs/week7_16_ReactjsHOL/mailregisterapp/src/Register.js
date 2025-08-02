import React, { Component } from 'react';
import './Register.css';

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: ''
      }
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        errors.fullName = value.length < 5 ? 'Full Name must be 5 characters long!' : '';
        break;
      case 'email':
        const validEmailRegex = RegExp(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
        errors.email = validEmailRegex.test(value) ? '' : 'Email is not valid!';
        break;
      case 'password':
        errors.password = value.length < 8 ? 'Password must be 8 characters long!' : '';
        break;
      default:
        break;
    }

    this.setState({ errors, [name]: value });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    const { errors, fullName, email, password } = this.state;

    if (errors.fullName || errors.email || errors.password || !fullName || !email || !password) {
      if (errors.fullName) alert(errors.fullName);
      if (errors.email) alert(errors.email);
      if (errors.password) alert(errors.password);
    } else {
      alert('Valid Form');
    }
  }

  render() {
    return (
      <div className="container">
        <h2>Register Here!!!</h2>
        <form onSubmit={this.handleSubmit} noValidate>
          <div>
            Name: <input type="text" name="fullName" onChange={this.handleChange} />
          </div>
          <div>
            Email: <input type="text" name="email" onChange={this.handleChange} />
          </div>
          <div>
            Password: <input type="password" name="password" onChange={this.handleChange} />
          </div>
          <div>
            <button type="submit">Submit</button>
          </div>
        </form>
      </div>
    );
  }
}

export default Register;
