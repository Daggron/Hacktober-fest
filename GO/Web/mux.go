package main

import (
	"fmt"
	"net/http"
	"github.com/gorilla/mux"
)


func main(){
	r:= mux.NewRouter();

	r.HandleFunc("/",handleMain).Methods("GET");
	r.HandleFunc("/hello",HandleHello).Methods("GET");
	http.Handle("/",r);

	http.ListenAndServe(":8000",nil);

}


func handleMain(w http.ResponseWriter , r * http.Request){
	fmt.Fprint(w , "Yowie vowie Using mux");
} 

func HandleHello(w http.ResponseWriter , r * http.Request){
	fmt.Fprint(w,"Hello You are at hello route");
}