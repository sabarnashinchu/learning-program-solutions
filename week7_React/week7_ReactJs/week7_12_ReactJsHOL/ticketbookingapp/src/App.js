import React, { useState } from "react";

// Guest Greeting Component
function GuestGreeting() {
  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h2>Please sign up.</h2>
    </div>
  );
}

// User Greeting Component
function UserGreeting() {
  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h2>Welcome back</h2>
    </div>
  );
}

// Greeting Component for conditional rendering
function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

// Login Button Component
function LoginButton(props) {
  return (
    <button onClick={props.onClick}>Login</button>
  );
}

// Logout Button Component
function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>Logout</button>
  );
}

// Main App Component
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogout} />;
  } else {
    button = <LoginButton onClick={handleLogin} />;
  }

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <Greeting isLoggedIn={isLoggedIn} />
      {button}
    </div>
  );
}

export default App;
