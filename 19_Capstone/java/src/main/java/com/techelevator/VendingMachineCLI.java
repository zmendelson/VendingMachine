package com.techelevator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.change.GetChange;
import com.techelevator.view.Menu;

public class VendingMachineCLI {
	// Main Menu Options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_QUIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_QUIT };
	//Purchase Menu Options
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_ITEM = "Select a Product";
	private static final String PURCHASE_MENU_OPTION_FINISH = "Complete Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_ITEM, PURCHASE_MENU_OPTION_FINISH };
	// Feed Money Options
	private static final String PURCHASE_MENU_FEED_MONEY_ONE = "$1";
	private static final String PURCHASE_MENU_FEED_MONEY_TWO = "$2";
	private static final String PURCHASE_MENU_FEED_MONEY_FIVE = "$5";
	private static final String PURCHASE_MENU_FEED_MONEY_TEN = "$10";
	private static final String PURCHASE_MENU_FEED_MONEY_DONE = "Done";
	private static final String[] FEED_MONEY_OPTIONS = { PURCHASE_MENU_FEED_MONEY_ONE, PURCHASE_MENU_FEED_MONEY_TWO, PURCHASE_MENU_FEED_MONEY_FIVE, PURCHASE_MENU_FEED_MONEY_TEN, PURCHASE_MENU_FEED_MONEY_DONE};
	
	private double curBalance;
	private int curQuantity= 5;
	private SalesAuditLog vendingLog = new SalesAuditLog();
	private NumberFormat twoDecimals = new DecimalFormat("#.##");
	
	private Menu menu;
	private String[] displayItems = new String[16];

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {
		// This will be the input file once it is coded.
		OptionsForVendingMachine myItems = new OptionsForVendingMachine();
		File vendOptions = new File("vendingmachine.csv");
		Scanner fileReader = new Scanner(vendOptions.getAbsoluteFile());
		
		
		String fileContent = "";
		int counter = 0;
		
		while (fileReader.hasNextLine()) {
			fileContent = fileReader.nextLine();
		    displayItems[counter] = fileContent;
		    counter++;
		}
		
		
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			OptionsForVendingMachine vendingItems = new OptionsForVendingMachine();
			Map<String, ProductMain> foodChoices = vendingItems.getMapOfItems();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				menu.displayMenuOptions(displayItems);
			} 
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
			    String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			    if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
			    	String feedChoice = "";
			    	feedMoney(feedChoice, foodChoices);
			    }
			    else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_ITEM)) {
			    	
				    	dispenseItem(foodChoices);
			    	}
			    	
		    	
			    	// find the name, price, quantity
			    	      
			    else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH)) {
			    	finishPurchase();
			    }
			}
			else {
				break;
			}
		}
	}
	public void feedMoney(String myStr, Map<String, ProductMain> myMap) throws IOException {
	    myStr = (String) menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
		Scanner userInp = new Scanner(System.in);
			if (myStr.equals(PURCHASE_MENU_FEED_MONEY_ONE)) {
	    		curBalance+=1.00; 
	    	}
	    	else if (myStr.equals(PURCHASE_MENU_FEED_MONEY_TWO)) {
	    		curBalance+=2.00; 
	    	}
	    	else if (myStr.equals(PURCHASE_MENU_FEED_MONEY_FIVE)) {
	    		curBalance+=5.00; 
	    	}
	    	else if (myStr.equals(PURCHASE_MENU_FEED_MONEY_TEN)) {
	    		curBalance+=10.00; 
	    	}
			System.out.println("Your current balance is: " + curBalance);
			System.out.println("Would you like to add more money? (Y/N): ");
	    	String addMore = userInp.nextLine();
	    	if (addMore.equalsIgnoreCase("Y")) {
	    		feedMoney(myStr, myMap);
	    	}
	    	else {
	    		dispenseItem(myMap);
	    	}
		
	}
	public ProductMain selectItem(Map<String, ProductMain> myMap) {
		Scanner itemSlot = new Scanner(System.in);
		System.out.println("Please Enter the ID of your desired product: ");
		String itemID = itemSlot.nextLine();
		if (myMap.containsKey(itemID)) {
			return myMap.get(itemID);
		}
		else {
			System.out.println("ID Invalid");
			return null;
		}

	}
	public void dispenseItem(Map<String, ProductMain> myMap) throws IOException {
		menu.displayMenuOptions(displayItems);
    	ProductMain selected = selectItem(myMap);
    	String name = selected.getProductName();
    	BigDecimal bdPrice = new BigDecimal(selected.getPrice());
    	bdPrice = bdPrice.setScale(2, RoundingMode.HALF_UP);
    	String price = bdPrice.toString();
    	int quantity = selected.getQuantity();
    	if (selected.getPrice()>= curBalance) {
    		System.out.println("Insufficient Funds");
    	}
    	else if (quantity<=0) {
    		System.out.println("Item Out of Stock");
    		continousPurchase(myMap);
    	}
    	else {
	    	if (selected.getSlotID().contains("A") || selected.getSlotID().contains("a")) {
	    		curBalance-=selected.getPrice();
	    		quantity = selected.purchase();
	    		System.out.println(name + price);
	    		System.out.println("Crunch Crunch, Yum!");
	    	}
	    	else if (selected.getSlotID().contains("B") || selected.getSlotID().contains("b")) {
	    		curBalance-=selected.getPrice();
	    		quantity = selected.purchase();
	    		System.out.println(name + price);
	    		System.out.println("Munch Munch, Yum!");
	    	}
	    	else if (selected.getSlotID().contains("C") || selected.getSlotID().contains("c")) {
	    		curBalance-=selected.getPrice();
	    		quantity = selected.purchase();
	    		System.out.println(name + price);
	    		System.out.println("Glug Glug, Yum!");
	    	}
	    	else if (selected.getSlotID().contains("D") || selected.getSlotID().contains("d")){
	    		curBalance-=selected.getPrice();
	    		quantity = selected.purchase();
	    		System.out.println(name + price);
	    		System.out.println("Chew Chew, Yum!");
	    	}
	    	else {
	    		System.out.println("Product Key Unknown");
	    	}
	    	vendingLog.logMethod(selected.getProductName(), selected.getPrice(), curBalance);
	    	continousPurchase(myMap);
    	}
    	
	}
	public void continousPurchase (Map<String, ProductMain> myMap) throws IOException {
		Scanner keepBuying = new Scanner(System.in);
    	System.out.println("Would you like to purchase another item? (Y/N): ");
    	String yesOrNo = keepBuying.nextLine();
		if (yesOrNo.equalsIgnoreCase("Y")) {
			dispenseItem(myMap);		
		}
		else {
			finishPurchase();
		}
	}
	public void finishPurchase() {
		GetChange myChange = new GetChange();
    	String gettingChange = myChange.getChange(curBalance);
    	System.out.println("Your change: " + gettingChange);
    	curBalance =0.00;
    	System.out.println("Current Balance: " + curBalance);
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
