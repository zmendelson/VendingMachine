package com.techelevator;

public class Beverage implements ProductMain {
	private String productType = "Beverage";
	
	private double price;
	private String productName;
	private String slotID;
	private int quantity = 5;

	
	
	@Override
	public int getQuantity() {
		return quantity;
	}

	
	@Override
	public String getSlotID() {
		return slotID;
	}

	@Override
	public void setSlotID(String slotID) {
		this.slotID = slotID;
	}
	
	
	public String getProductType() {
		return productType;
	}
	

@Override
	public String getProductName() {
		if (productName.length() <= 18) {
			return productName + "                 ";
		} else {
		return productName;
		}
	}
	@Override
	public void setProductName(String productName) {
		this.productName = productName;
	}


	@Override
	public String consume() {
		return "Glug Glug Glug Glug Glug, Yum!";
	}

	@Override
	public int purchase() {
		
		if (this.quantity > 0) {
			this.quantity -= 1; 
			return this.quantity;
		}
		return this.quantity;
	}


	@Override
	public String purchaseAndMessage(String getProductName) {
		
		String message ="";
		if (this.quantity == 0) {
			message += "This item is SOLD OUT";
		} else {
			message += "You selected " + productName;
			this.quantity -= 1; 
		}
		return message;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	//public void setProductType(String string) {
	//	
	//}

	
	
}
