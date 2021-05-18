import React,{ useContext } from 'react'
import  {DataContext} from '../Context/DataContext'
import '../index.css'

function Header(){
    return(
        <header>
            <div>
                <h1>Gestionale</h1>
                <nav>
                    <ul>
                        <a href='#'>Prodotti</a>
                        <a href='#'>Dipendenti</a>
                        <a href='#'>Fornitori</a>
                        <a href='#'>Movimenti</a>
                        <a href='#'>Ordini</a>
                    </ul>
                </nav>
            </div>      
        </header>
    )
}
export default Header