import './App.css';
import React, {Component, useEffect} from 'react';
import Prodotti from '../src/Components/ProdottiComponent'
import DataContextProvider from './Context/DataContext';
import Header from './Components/Header';
import Footer from './Components/Footer';
import ProdottiService from './services/ProdottiSerivce';
import ProdottiFetch from './services/ProdottiSerivce';


class App extends Component {

  //   state = {
  //     prodotti: [],
  //     dipendenti: [],
  //     fornitori: [],
  //     movimenti: [],
  //     ordini: []
  // }


  //test fetch prodotti
  // componentDidMount(){
  //     fetch('http://localhost:8080/gestionale-0.0.1-SNAPSHOT/prodotti/findAll')
  //     .then(res => res.json())
  //     .then((data) =>{
  //         this.setState({prodotti: data})
  //     })
  //     .catch(console.log)
    
  // }

  
  
  

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
