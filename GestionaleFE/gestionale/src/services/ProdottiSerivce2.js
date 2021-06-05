// import config from '../config';


//     async function GetProdottiAll(){
//         const res = await fetch(`${config.api}prodotti/findAll`,{
//           method: 'GET'
//         })
//         const data = await res.json()
//         if (res.status >= 400) {
//           console.warn("ERROR api");
//           throw new Error(data.message);
//         }
//         return data;
//       }
    
//       async function GetProdottiById(id){
//         const res = await fetch(`${config.api}prodotti/findByID?id=${id}`,{
//           method: 'GET'
//         })
//         const data = await res.json()
//         console.log(data)
//         if (res.status >= 400) {
//           console.warn("ERROR api");
//           throw new Error(data.message);
//         }
//         return data;
     
//       };
    
//       async function GetProdottiByNome(nome){
//         const res = await fetch(`${config.api}prodotti/findByNome?nome=${nome}`,{
//           method: 'GET'
//         })
//         const data = await res.json()
//         if (res.status >= 400) {
//           console.warn("ERROR api");
//           throw new Error(data.message);
//         }
//         return data;   
        
//       };
    
//       async function GetProdottiOrderByCres(){
//         const res = await fetch(`${config.api}prodotti/FindGiacCres`,{
//           method: 'GET'
//         })
//         const data = await res.json()
//         if (res.status >= 400) {
//           console.warn("ERROR api");
//           throw new Error(data.message);
//         }
//         return data;
    
//       };
    
//       async function GetProdottiOrderByDecre(){
//         const res = await fetch(`${config.api}prodotti/FindGiacDecre`,{
//           method: 'GET'
//         })
//         const data = await res.json()
//         if (res.status >= 400) {
//           console.warn("ERROR api");
//           throw new Error(data.message);
//         }
//         return data;
    
//       };
    
    
//       function DeleteProdotto(id){
//         const a = fetch(`${config.api}prodotti/delete?id=${id}`,{method: 'DELETE'}).then(() => {
//             {console.log(a);}
//             if(a == 0){console.log('removed');}
//           else{alert("Non puoi eliminare un prodotto se ci sono movimenti")}
//         })};
    

