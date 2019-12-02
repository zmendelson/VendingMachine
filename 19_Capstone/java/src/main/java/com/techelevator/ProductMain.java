package com.techelevator;

public interface ProductMain {

	public String getProductName();

	public void setProductName(String productName);

	public double getPrice();

	public void setPrice(double price);

	public String getSlotID();

	public void setSlotID(String slotID);

	public int getQuantity();

	public String consume(); // to make noise at end

	public int purchase(); // for change of quantity

	public String purchaseAndMessage(String getName);

	public String getProductType();
}
