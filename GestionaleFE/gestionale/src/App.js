import './App.css';
import React, {Component, useEffect} from 'react';
import Prodotti from '../src/Components/ProdottiComponent'
import DataContextProvider from './Context/DataContext';
import Header from './Components/Header';
import Footer from './Components/Footer';
import ProdottiService from './services/ProdottiSerivce';
import ProdottiFetch from './services/ProdottiSerivce';


class App extends Component {

   
  

  render() {
    return (
      <>
     
      <DataContextProvider/>
      <Header/>
      <ProdottiFetch/>
      <Footer/>
      </>
      
    );
  }
}

export default App;
