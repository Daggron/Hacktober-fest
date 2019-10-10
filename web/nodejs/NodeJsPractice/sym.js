// let sym = Symbol('dododo')

// let ob ={
//     Name:"Abc",
//     data:[sym]
// }


// let sym1 = Symbol.for("Abc")
// let sym2 = Symbol.for("Abc")

// let obj = {
//     name:"Abc"
// }

// function makage(obj){
//     var sym2 = Symbol.for("Abc");
//     obj[sym2] = 27;
// }
// makage(obj)
// console.log(obj[sym2]);


// let sym=Symbol("abc");
// let sym1=Symbol("abc");
// console.log(sym==sym1);
// console.log(typeof(sym));
// console.log(sym1);
// const direction={LEFT:Symbol('LEFT'),RIGHT:Symbol('RIGHT'),UP:Symbol('UP'),DOWN:Symbol('DOWN')};
// console.log(direction);
// let sym2=Symbol.for("abc");
// let sym3=Symbol.for("abc");
// let obj={
//   name:"abc"
// }
// function makeage(obj)
// {
//   let sum3=Symbol.for("age");
//   obj[sym3]=27;
// }
// makeage(obj);
// console.log(obj[sym3]);
// console.log(Symbol.iterator);
// let sym=Symbol("abc");
// let sym1=Symbol("abc");
// console.log(sym==sym1);
// console.log(typeof(sym));
// console.log(sym1);
// const direction={LEFT:Symbol('LEFT'),RIGHT:Symbol('RIGHT'),UP:Symbol('UP'),DOWN:Symbol('DOWN')};
// console.log(direction);
// let sym2=Symbol.for("abc");
// let sym3=Symbol.for("abc");
// let obj={
//   name:"abc"
// }


// let obj={ar:[1,2,3],[Symbol.iterator]:function(){
//     let ar=this.ar;
//     let i=0;
//     return {
//         next:function(){
//             let value=ar[i];
//             i++;
//             return {
//             done:i>ar.length?true:false,value:value}
//          }
//     }
// }
// }





// function *abc()
// {
//   yield1;
//   yield2;
// }
// let o={
//   [Symbol.iterator]:abc
// }
// console.log(o);


let set = new Set();

set.add(1);
set.add(2);
set.add(1);

console.log(set);

console.log(set.has(5))