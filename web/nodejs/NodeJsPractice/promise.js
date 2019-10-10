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
       resolve(20)
    },2000);
      
   })
}


function getBal(id){
    
        return new Promise((resolve,reject)=>{
            resolve(2000)
        })
}


getUserId("abhay")
.then(id=>{return getBal(20)})
.then(bal=>console.log(bal))
.catch(err=>console.log(err));