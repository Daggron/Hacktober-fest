package main

import (
	"net/http"
	"github.com/gorilla/mux"
	"github.com/go-redis/redis"
	"html/template"
)

var client *redis.Client
var templates *template.Template

func main(){
	router:=mux.NewRouter()

	client = redis.NewClient(&redis.Options{
		Addr:"localhost:6379",
	})

	templates = template.Must(template.ParseGlob("templates/*.html"));



	router.HandleFunc("/",handle).Methods("Get")
	http.Handle("/",router)
	http.ListenAndServe(":8000",nil)
}


func handle(w http.ResponseWriter , r *http.Request){
	comments , err := client.LRange("cooments",0,10).Result();

	if err!=nil{
		return
	}

	templates.ExecuteTemplate(w,"data.html",comments)

}

