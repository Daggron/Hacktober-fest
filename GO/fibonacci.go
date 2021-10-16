package main

import "fmt"

// Programme to generate the 10 letters fibonnaci series recursively 
// Sample output will be 
// 0 1 1 2 3 5 8 13 21 34 

func fibonaci(i int) (ret int) {
   if i == 0 {
      return 0
   }
   if i == 1 {
      return 1
   }
   return fibonaci(i-1) + fibonaci(i-2)
}
func main() {
   var i int
   for i = 0; i < 10; i++ {
      fmt.Printf("%d ", fibonaci(i))
   }
}
