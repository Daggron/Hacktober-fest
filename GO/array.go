package main
  
import "fmt"
  
func main() {
  
// Creating an array of string type 
// Using var keyword
var myarr[3]string
  
// Elements are assigned using index
myarr[0] = "GFG"
myarr[1] = "GeeksforGeeks"
myarr[2] = "Geek"
  
// Accessing the elements of the array 
// Using index value
fmt.Println("Elements of Array:")
fmt.Println("Element 1: ", myarr[0])
fmt.Println("Element 2: ", myarr[1])
fmt.Println("Element 3: ", myarr[2])
}
