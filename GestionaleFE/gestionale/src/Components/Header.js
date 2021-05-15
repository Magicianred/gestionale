import React,{ useContext } from 'react'
import  {DataContext} from '../Context/DataContext'
import '../index.css'

function Header(prop){
    const datiJson = useContext(DataContext)
    return(
        <>       
        <h1>{datiJson[0].nome}</h1>
        </>
    )
}
export default Header