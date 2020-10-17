// let p = new Promise((resolve,reject)=>{
//     setTimeout(()=>{
//         resolve("Hello")
//     },2000);
// })

// p.then(()=>{
//     console.log('Yowiew Vowiew');
// })

function getUserId(name){
   return new Promise((resolve,reject)=>{

    setTimeout(()=>{
       resolve(name)
    },2000);
      
   })
}


function getBal(id){
    
        return new Promise((resolve,reject)=>{
            resolve(id)
        })
}


getUserId("abhay")
.then(id=>{return getBal(id)})
.then(bal=>console.log(bal))
.catch(err=>console.log(err));
