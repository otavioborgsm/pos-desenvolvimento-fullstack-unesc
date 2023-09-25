import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.scss';
import Navbar from './components/Navbar';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <div>
      <Navbar />
      <h1>Teste 1</h1>
    </div>
  </React.StrictMode>
);