import React, { useState , createContext , useEffect} from 'react'
import Spinner from '../Components/Spinner'

export const DataContext = createContext()

const DataContextProvider = (props) => {

    const [datiJson , setDatiJson] = useState ([])
    const [isLoading,setIsLoading] = useState(true)

    const api='http://localhost:8080/gestionale-0.0.1-SNAPSHOT/prodotti/findAll'

    useEffect(() => {
      const getDati = async() =>{
        const res = await fetch(api)
        const data = await res.json()
        .then (data => setDatiJson(data) )
        .catch(error => alert(error='error loading the API, Controlla se hai fatto partire server backend'))
        setIsLoading(false)
      }
      getDati()
    },[])



   const gif ="https://media2.giphy.com/media/3oEjI6SIIHBdRxXI40/giphy.gif"
  
    return (
      
      (isLoading) ? (
        <Spinner style={{
            width:'40%',
            margin:'50px auto',
            textAlign:'center',
            padding:40,
        }}>
            <h2>Loading ...</h2>
            <img src={gif}/>
        </Spinner>
    ):(
      
      <DataContext.Provider value={datiJson}>
          {props.children}
      </DataContext.Provider>
    )
  
    )
  }
  export default DataContextProvider