import React, { Component, useState } from 'react'



  

const Prodotti = ({ prodotti }) => {
    const [name, setName] = useState("")

    const handleSubmit = (e) =>{
        e.preventDefault();
        <a></a>
    }
    
    return (
        <div id='corpo'>
            <h1>Prodotti</h1>
            {/* {prodotti.id} */}
            <form onSubmit={handleSubmit}>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1"  >nome</span>
                    <input type="text" class="form-control" placeholder="Nome" aria-label="Nome" aria-describedby="basic-addon1" value={name} onChange={e => setName(e.target.value)}/>
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
                    </tr>
                </tbody>
                ))}
            </table>
        </div>

        
    )
    };
export default Prodotti;