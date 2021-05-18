import React, { Component } from 'react'


const Prodotti = ({ prodotti }) => {
    return (
        <div id='corpo'>
            <h1>Prodotti</h1>
        
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
                <tbody>
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