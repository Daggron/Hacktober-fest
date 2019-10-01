package main

import "fmt"

func swap(a int , b int) (int,int){
	return b,a
}


func main(){
	var a , b int

	fmt.Scanf("%d\n%d",&a,&b)
	a,b = swap(a,b);
	fmt.Println("Swap",a,b);
}
