import React, { useState, useEffect } from "react";
import Prodotti from '../../src/Components/ProdottiComponent'


function ProdottiFetch (){
  const [prodotti,setProdotti] = useState([])

  const api='http://localhost:8080/gestionale-0.0.1-SNAPSHOT/'

  useEffect(() => {
    const getDati = async() =>{
      const res = await fetch(api + "prodotti/findAll")
      const data = await res.json()
      .then (data => setProdotti(data))
      .catch(error => alert(error='error loading the API'))
    }
    getDati();
  },[])

   return (
    <Prodotti prodotti={prodotti}/>
 )
  }

export default ProdottiFetch