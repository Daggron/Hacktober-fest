package main

import (
	"errors"
	"fmt"
)

/*
 * Q. Given an array containing N integers and a number S denoting the target sum.
 * Find two distinct intgers that can pair up to form the target sum. Let's assume
 * there will be only one such pair
 */

// Solution one brute force approach time complexity is O(n^2)s
// func main() {
// 	array := [...]int{1,2,3,4,5,6,7}
// 	sum := 4
// 	flag := false

// 	pair := make([]int, 2)

// 	for i := 0; i <= len(array); i++ {
// 		for j := i + 1; j <= len(array); j++ {
// 			if array[i] + array[j] == sum {
// 				flag = true;
// 				pair[0] = array[i]
// 				pair[1] = array[j]
// 				break
// 			}
// 		}
// 		if flag == true {
// 			break
// 		}
// 	}

// 	fmt.Println(pair);
// }

func checkForElements(array [7]int, sum int) ([2]int, error) {

	unorderedMap := make(map[int]int);

	for _, v := range array {
		x := sum - v;

		if val, ok := unorderedMap[x]; ok {
			return [2]int{val, v}, nil
		}

		unorderedMap[v] = v
	}
	return [2]int{0,0}, errors.New("NO PAIR FOUND")
}

func main() {
	array := [...]int{10,2,3,-6,5,6,7}
	sum := 4
  pair, err := checkForElements(array, sum)

	if err != nil {
		fmt.Println("No Pair found")
	} else {
		fmt.Println(pair);
	}
}