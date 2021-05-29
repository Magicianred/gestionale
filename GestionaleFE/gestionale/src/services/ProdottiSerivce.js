import React, { useState, useEffect } from "react";
import Prodotti from '../../src/Components/ProdottiComponent'
import config from '../config';




function ProdottiFetch (){
  const [prodotti,setProdotti] = useState([])

  useEffect(() => {
    const getDatiAll = async() =>{
      const res = await fetch(`${config.api}prodotti/findAll`)
      const data = await res.json()
      .then (data => setProdotti(data))
      .catch(error => alert(error='error loading the API'))
    }
    //getDatiAll();
    //GetProdottiByNome("giacca").then(setProdotti)
    //GetProdottiById(1).then(setProdotti)
    //GetProdottiOrderByCres().then(setProdotti)
    GetProdottiOrderByDecre().then(setProdotti)
  },[]) 

  async function GetProdottiById(id){
    const res = await fetch(`${config.api}prodotti/findByID?id=${id}`,{
      method: 'GET'
    })
    const data = await res.json();
    if (res.status >= 400) {
      console.warn("ERROR api");
      throw new Error(data.message);
    }
    return data;
    
    
  };

  async function GetProdottiByNome(nome){
    const res = await fetch(`${config.api}prodotti/findByNome?nome=${nome}`,{
      method: 'GET'
    })
    const data = await res.json();
    if (res.status >= 400) {
      console.warn("ERROR api");
      throw new Error(data.message);
    }
    return data;   
    
  };

  async function GetProdottiOrderByCres(){
    const res = await fetch(`${config.api}prodotti/FindGiacCres`,{
      method: 'GET'
    })
    const data = await res.json();
    if (res.status >= 400) {
      console.warn("ERROR api");
      throw new Error(data.message);
    }
    return data;

  };

  async function GetProdottiOrderByDecre(){
    const res = await fetch(`${config.api}prodotti/FindGiacDecre`,{
      method: 'GET'
    })
    const data = await res.json();
    if (res.status >= 400) {
      console.warn("ERROR api");
      throw new Error(data.message);
    }
    return data;

  };



   return (
     prodotti ? <Prodotti prodotti={prodotti}/>  : <></>
    
 )
  }


export default ProdottiFetch