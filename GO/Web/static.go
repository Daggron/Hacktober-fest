package main

import(
	"net/http"
	"github.com/gorilla/mux"
	"html/template"
)

var templates  *template.Template

func main(){

	templates = template.Must(template.ParseGlob("templates/*.html"));

	r:= mux.NewRouter();
	r.HandleFunc("/",handle).Methods("GET");
	http.Handle("/",r);

	http.ListenAndServe(":8000",nil);
}

func handle(w http.ResponseWriter , r * http.Request){
	templates.ExecuteTemplate(w,"index.html",nil);
}