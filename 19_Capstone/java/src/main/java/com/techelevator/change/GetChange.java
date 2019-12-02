package com.techelevator.change;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GetChange {

	public String getChange(double currentBalance) {
		Coins[] coins = new Coins[] { new Quarter(), new Dime(), new Nickel() };
		currentBalance *= 100;
		String result = "";

		Map<Coins, Integer> change = new HashMap<Coins, Integer>();

		for (Coins coin : coins) { // iterating through the coins Array

			if (currentBalance <= 0) {
				break;
			}
			int cnt = (int) currentBalance / coin.getValue();
			if (cnt > 0) {
				currentBalance = currentBalance % (coin.getValue() * cnt);
				change.put(coin, cnt);
			}
		}

		for (Coins coin : change.keySet()) {
			result += (change.get(coin) + " " + coin.getName() + "(s)" + " ");
			// result += (double)coin.getValue();
		}
		// result /= 10;

		return result;
	}
}