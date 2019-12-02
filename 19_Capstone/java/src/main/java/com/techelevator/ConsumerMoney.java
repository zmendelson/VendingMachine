package com.techelevator;

public class ConsumerMoney {

	private double currentBalance = 0.00;

	
	public double getCurrentMoney() {
		return currentBalance;
	}

	public void addToCurrent(double addMoney) {
		this.currentBalance += addMoney;
	}
	
	public void subractFromCurrent(double subtractAmount) {
			 if (subtractAmount <= this.currentBalance) {
				 this.currentBalance -= subtractAmount;
		}
	}
	
	
}