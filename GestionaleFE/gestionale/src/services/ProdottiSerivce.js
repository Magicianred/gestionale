const API_PRODOTTI = 'http://localhost:8080/gestionale-0.0.1-SNAPSHOT/prodotti';

function parse(res) {
    return res.json();
  }


class ProdottiService{

    

    getProdotti(){
        return fetch(`${API_PRODOTTI}/findAll`, {
            method: 'GET',
            headers: {
              'Content-Type': 'application/json'
            }
        })
        .then(parse);
    }
}

export default ProdottiService;