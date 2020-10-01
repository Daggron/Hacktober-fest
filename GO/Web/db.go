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
	client = redis.NewClient(&redis.Options{
		Addr:"localhost:6379",
	})

	templates = template.Must(template.ParseGlob("templates/*.html"));

	router := mux.NewRouter();

	router.HandleFunc("/",getData).Methods("GET");

	http.Handle("/",router);

	http.ListenAndServe(":8000",nil);

}


func getData(w http.ResponseWriter , r *http.Request){

	comments , err := client.LRange("cooments",0,10).Result()
	
	if err != nil{
		return 
	}

	templates.ExecuteTemplate(w,"data.html",comments);


}