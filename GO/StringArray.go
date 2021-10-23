package main
  
import "fmt"
  
func main() {
  
// Shorthand declaration of array
arr:= [4]string{"geek", "gfg", "Geeks1231", "GeeksforGeeks"}
  
// Accessing the elements of 
// the array Using for loop
fmt.Println("Elements of the array:")
  
for i:= 0; i < 3; i++{
fmt.Println(arr[i])
}
  
}
