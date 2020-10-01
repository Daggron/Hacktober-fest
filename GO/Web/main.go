package main

import (
	"fmt"
	"net/http"
	"github.com/gorilla/mux"
)

func main(){
	r:=mux.NewRouter()

	r.HandleFunc("/hello",helloHandle).Methods("GET");
	http.Handle("/",r);
	http.ListenAndServe(":8000",nil);
}


func helloHandle(w http.ResponseWriter , r * http.Request){
	fmt.Fprint(w,"Hello World This is fun");
}

