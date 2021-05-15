import React, { Component } from 'react'


const Prodotti = ({ prodotti }) => {
    return (
        <div>
        <center><h1>Prodotti List</h1></center>
        {prodotti.map((prodotto) => (
            <div class="card">
            <div class="card-body">
                <h5 class="card-title">{prodotto.id}</h5>
                <h6 class="card-subtitle mb-2 text-muted">{prodotto.nome}</h6>
                <p class="card-text">{prodotto.descrizione}</p>
                <p class="card-text">{prodotto.giacenza}</p>
            </div>
            </div>
        ))}
        </div>
    )
    };
export default Prodotti;