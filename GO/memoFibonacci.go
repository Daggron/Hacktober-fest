// fibonacci implementation with Dynamic Programming
package main

import "fmt"

func main() {
	var num int
	fmt.Println("Enter the position number for fibonacci series")
	fmt.Scanln(&num)
	memoArr := make(map[int]int)
	res := fib(num, &memoArr)
	fmt.Printf("Fibanocci value for position %d is : %d\n", num, res)

}

func fib(n int, memo *map[int]int) int {
	if n == 0 {
		return 0
	} else if n <= 2 {
		return 1
	} else if val, ok := (*memo)[n]; ok { // checks if the key exists or not
		return val
	}
	val := fib(n-1, memo) + fib(n-2, memo)
	(*memo)[n] = val
	return val
}
