import './App.css';
import React, {Component} from 'react';
import Prodotti from '../src/Components/ProdottiComponent'
import DataContextProvider from './Context/DataContext';
import Header from './Components/Header';
import Footer from './Components/Footer';


class App extends Component {

    state = {
      prodotti: []
  }


  //test fetch prodotti
  componentDidMount(){
      fetch('http://localhost:8080/gestionale-0.0.1-SNAPSHOT/prodotti/findAll')
      .then(res => res.json())
      .then((data) =>{
          this.setState({prodotti: data})
      })
      .catch(console.log)
    
  }

  

  render() {
    return (
      <>
     
      <DataContextProvider/>
      <Header/>
      <Prodotti prodotti={this.state.prodotti} />
      <Footer/>
      </>
      
    );
  }
}

export default App;
