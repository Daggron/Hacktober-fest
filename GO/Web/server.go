package main

import (
	"fmt"
	"net/http"
)


func handlemain(w http.ResponseWriter , r *http.Request){
	fmt.Fprint(w,"Hello World Getting Started with go");
}


func main(){
	http.HandleFunc("/",handlemain);
	http.ListenAndServe(":8000",nil);
}