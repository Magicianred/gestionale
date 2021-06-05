import React, { Component, useState, useEffect  } from 'react'
import config from '../config';
import ProdottiFetch from '../services/ProdottiSerivce';




const Prodotti = ({ prodotti }) => {
    const [name, setName] = useState("")
    
    

    const handleSubmit = (e) =>{
        e.preventDefault();
        // <ProdottiFetch prodotti={GetProdottiByNome(name)}/>
        // GetProdottiByNome(name)
        // console.log(GetProdottiByNome(name))
        console.log(name)
        // this.props.prodotti(GetProdottiByNome(name));
    }

    // function DeleteProdotto(id){
    //     const a = fetch(`${config.api}prodotti/delete?id=${id}`,{method: 'DELETE'}).then(() => {
    //         {console.log(a);}
    //         if(a == 0){console.log('removed');}
    //       else{alert("Non puoi eliminare un prodotto se ci sono movimenti")}
    //     })};

    // async function GetProdottiByNome(name){
    //     const res = await fetch(`${config.api}prodotti/findByNome?nome=${name}`,{
    //         method: 'GET'
    //     })
    //     const data = await res.json()
    //     if (res.status >= 400) {
    //         console.warn("ERROR api");
    //         throw new Error(data.message);
    //     }
    //     return data;   
        
    //     };


    

   
    
    return (
        <div id='corpo'>
            <h1>Prodotti</h1>
            {/* {prodotti.id} */}
            <form onSubmit={handleSubmit}>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1"  >nome</span>
                    <input type="text" class="form-control" placeholder="Nome" aria-label="Nome" aria-describedby="basic-addon1" value={name} onChange={e => setName(e.target.value)}/>
                    <input type="submit" value="Submit" />
                </div>
            </form>
        
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Descrizione</th>
                        <th scope="col">Giacenza</th>
                    </tr>
                </thead>
                {prodotti.map((prodotto) => (
                <tbody key={prodotto.id}>
                    <tr>
                        <th scope="row">{prodotto.id}</th>
                        <td>{prodotto.nome}</td>
                        <td>{prodotto.descrizione}</td>
                        <td>{prodotto.giacenza}</td>
                        {/* <td><button onClick={() => DeleteProdotto(prodotto.id)}>rimuovi</button></td> */}
                    </tr>
                </tbody>
                ))}
            </table>
        </div>

        
    )
    };
export default Prodotti;