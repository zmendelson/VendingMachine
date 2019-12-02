package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionsForVendingMachine {
	 
	
	

	public Map<String, ProductMain> getMapOfItems() throws FileNotFoundException { 
		File vendingMachineOptions = new File("vendingmachine.csv"); 
		Map<String, ProductMain> foodOptions = new LinkedHashMap<String, ProductMain>();
			
		String options = ""; 	
			
		try(Scanner fileScanner = new Scanner(vendingMachineOptions)) {
		
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine(); 
				String[] temp = line.split("\\|"); 
				
					switch (temp[0].charAt(0)) {
					case 'A': 
						Chips chips = new Chips(); 
						chips.setProductName(temp[1]);
						chips.setSlotID(temp[0]);
						chips.setPrice(Double.parseDouble(temp[2]));
			      		chips.getProductType();
						foodOptions.put(temp[0], chips); 
						break; 
						
					case 'B': 
						Candy candy = new Candy(); 
						candy.setProductName(temp[1]);
						candy.setSlotID(temp[0]);
						candy.setPrice(Double.parseDouble(temp[2]));
						candy.getProductType();
						foodOptions.put(temp[0], candy); 
						break;
						
					case 'C': 
						Beverage drink = new Beverage(); 
						drink.setProductName(temp[1]);
						drink.setSlotID(temp[0]);
						drink.setPrice(Double.parseDouble(temp[2]));
						drink.getProductType();
						foodOptions.put(temp[0], drink); 
						break; 
						
					case 'D': 
						Gum gum = new Gum(); 
						gum.setProductName(temp[1]);
						gum.setSlotID(temp[0]);
						gum.setPrice(Double.parseDouble(temp[2]));
						gum.getProductType();
						foodOptions.put(temp[0], gum); 
						break;
						
					default: 
						System.out.println("Invalid source file!");
				}
			}
		}
		return foodOptions;
		}
	} 
