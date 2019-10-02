var numsquares = 6;
var colors = generaterandomcolor(numsquares);
var squares = document.querySelectorAll(".square");
var pickedcolor = pickcolor() 
var colordisplay = document.getElementById("colordisplay");
var messagedisplay = document.querySelector("#message");
var h1 = document.querySelector("h1");
var resetbutton = document.querySelector("#reset");
var easybutton = document.querySelector("#easybutton");
var hardbutton = document.querySelector("#hardbutton");

easybutton.addEventListener("click",function(){
  easybutton.classList.add("selected");
  hardbutton.classList.remove("selected");
    numsquares = 3;
  colors = generaterandomcolor(numsquares);
  pickedcolor = pickcolor();
  colordisplay.textContent = pickedcolor;
    for(var i = 0; i < squares.length ;i++){
    if(colors[i]){
       squares[i].style.background = colors[i];  
    }else{
       squares[i].style.display = "none";  
    }
    }
});
hardbutton.addEventListener("click",function(){
  easybutton.classList.remove("selected");
  hardbutton.classList.add("selected");
    numsquares = 6;
  colors = generaterandomcolor(numsquares);
  pickedcolor = pickcolor();
  colordisplay.textContent = pickedcolor;
    for(var i = 0; i < squares.length ;i++){
        squares[i].style.background = colors[i];
        squares[i].style.display = "block";
       
    }
});

resetbutton.addEventListener("click", function(){
     colors = generaterandomcolor(numsquares);
     pickedcolor = pickcolor();
     colordisplay.textContent = pickedcolor;
     this.textContent = "new color";
     messagedisplay.textContent = "";
     for(var i = 0; i < squares.length; i++){
        squares[i].style.background = colors[i];
     }
     h1.style.background = "steelblue"; 
})

colordisplay.textContent = pickedcolor;

for(var i = 0; i < squares.length; i++){
  squares[i].style.background = colors[i]


    squares[i].addEventListener("click",function(){
        var colorpicked =  this.style.background;
        console.log(colorpicked ,pickedcolor);
        if(colorpicked === pickedcolor){
          messagedisplay.textContent = "correct";
          changecolor(colorpicked);
          h1.style.background = pickedcolor;
          resetbutton.textContent = "Play Again??";
        } else{
          messagedisplay.textContent = "try again";
          this.style.background = "#232323";
          resetbutton.textContent = "new colors";
        }
    });

 }
 function changecolor(color){
  for(var i = 0; i< squares.length ; i++){
  squares[i].style.background = color;
  } 
 }

function pickcolor(){
  var random = Math.floor(Math.random() * colors.length);
  return colors[random];

}

function generaterandomcolor(num){
  var arr = []
    for(var i = 0; i < num; i++){
    arr.push(randomcolor())   
    }
  return arr;
    
}
function randomcolor(){
   var r = Math.floor(Math.random() * 256); 
   var g = Math.floor(Math.random() * 256); 
   var b = Math.floor(Math.random() * 256);
   return "rgb(" + r + ", " + g +", " + b + ")"; 
}




