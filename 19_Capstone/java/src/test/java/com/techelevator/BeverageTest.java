package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeverageTest {

	Beverage oringina;

	@Before
	public void setup() {
		oringina = new Beverage();
	}

	@Test
	public void testGetQuantity() {
		oringina.getQuantity();
		Assert.assertEquals(5, oringina.getQuantity());
	}

	@Test
	public void testGetAndSetSlotID() {
		oringina.setSlotID("Z6");
		Assert.assertEquals(oringina.getSlotID(), "Z6");
	}

	@Test
	public void testConsume() {
		oringina.consume();
		Assert.assertEquals("Glug Glug Glug Glug Glug, Yum!", oringina.consume());

	}

	@Test
	public void testPurchase() {
		oringina.purchase();
		Assert.assertEquals(4, oringina.getQuantity());
		
	}
	
	
	
	
	@Test
	public void testGetProductType() {
		oringina.setProductName("Beverage");
		Assert.assertEquals(oringina.getProductType(), "Beverage");
	}

	@Test
	public void testGetProductName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProductName() {
		fail("Not yet implemented");
	}


	@Test
	public void testPurchaseAndMessage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAndSetPrice() {
		oringina.setPrice(3.45);

		Assert.assertEquals(3.45, oringina.getPrice(), 0.0001d);
	}

}
