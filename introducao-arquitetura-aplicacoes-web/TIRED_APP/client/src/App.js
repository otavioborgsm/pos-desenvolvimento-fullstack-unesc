import React, { useEffect, useState } from 'react'
import logo from './logo.svg';
import './App.css';

function App() {

  const [greeting, setGreeting] = useState("")


  async function fetchGreeting() {
    const response = await fetch('http://localhost:3001/')
    setGreeting(await response.json())
  }
  
  useEffect(() => {
    fetchGreeting();
  }, [greeting]);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>{ greeting } + React </p>
      </header>
    </div>
  );
}

export default App;
