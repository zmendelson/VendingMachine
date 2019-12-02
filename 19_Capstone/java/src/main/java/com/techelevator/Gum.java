package com.techelevator;

public class Gum implements ProductMain {

	private String productType = "Gum";
	private double price;
	private String productName;
	private String slotID;
	private int quantity=5;

	 public String getProductType() {
	 return productType;
	 }

	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductName() {

		if (productName.length() <= 18) {
			return productName + "                 ";
		} else {

			return productName;
		}
	}

	public void setProductName(String productName) {

		this.productName = productName;
	}

	public String getSlotID() {
		return slotID;
	}

	public void setSlotID(String slotID) {

		this.slotID = slotID;

	}

	public int getQuantity() {
		return quantity;
	}
	
	
	@Override
	public String consume() {
		return "Chew Chew, Chew Chew Chew Yummy!";
	}

	@Override
	public int purchase() {
		if (this.quantity > 0) {
			this.quantity -= 1; 
			return this.quantity;
		}
		return this.quantity;
	}
	
	public String purchaseAndMessage(String getProductName) {
		
		String message ="";
		if (this.quantity == 0) {
			message += "This item is SOLD OUT";
		} else {
			message += "You selected " + getProductName;
			this.quantity -= 1; 
		}
		return message;
	}
	
	
	
	
	
	
	
	
	

}
