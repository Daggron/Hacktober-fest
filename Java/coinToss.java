package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class coinToss {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<String> res = coinTossCombinations(n);
		System.out.println(res);
		scn.close();
	}

	public static ArrayList<String> coinTossCombinations(int n) {
		ArrayList<String> lst = new ArrayList<>();
		coinTossCombinations("", n, lst);
		return lst;
	}

	public static void coinTossCombinations(String str, int n, ArrayList<String> lst) {
		if (n == 0) {
			lst.add(str);
			return;
		}

		coinTossCombinations(str + 'H', n - 1, lst);
		coinTossCombinations(str + 'T', n - 1, lst);
	}

}
