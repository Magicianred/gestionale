import React, { Component , useState} from 'react'





export default class ProdottiComponent2 extends Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.state = {name: ''};
      }
    
      handleChange(e) {
        this.setState({name: e.target.value});
        
      }

    
      render() {
        const name = this.state.name;
        {console.log(name)}
        return (
            <div id='corpo'>
            <h1>Prodotti</h1>
            
            {/* {prodotti.id} */}
            <form onSubmit={this.handleChange}>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1"  >nome</span>
                    <input type="text" class="form-control" placeholder="Nome" aria-label="Nome" aria-describedby="basic-addon1" value={name} onChange={this.handleChange}/>
                    <input type="submit" value="Submit" />
                </div>
            </form>

            <input
          value={name}
          onChange={this.handleChange} />
        
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Descrizione</th>
                        <th scope="col">Giacenza</th>
                    </tr>
                </thead>
                
            </table>
        </div>
        );
      }
}
