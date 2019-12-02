package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipsTest {

	Chips funyuns;

	@Before
	public void setup() {
		funyuns = new Chips();
	}

	@Test
	public void testGetAndSetPrice() {
		funyuns.setPrice(2.00);
		Assert.assertEquals(2.00, funyuns.getPrice(), 0.0001d);

	}

	@Test
	public void testGetQuantity() {
		funyuns.getQuantity();
		Assert.assertEquals(5, funyuns.getQuantity());
	}

	@Test
	public void testConsume() {
		funyuns.consume();
		Assert.assertEquals("Crunch Crunch, Yum!", funyuns.consume());

	}

	@Test
	public void testPurchase() {
		funyuns.purchase();
		Assert.assertEquals(4, funyuns.getQuantity());

	}

	@Test
	public void testGetAndSetslotID() {
		funyuns.setSlotID("A4");
		Assert.assertEquals(funyuns.getSlotID(), "A4");

	}
	
	@Test
	public void testGetAndSetProductType() {
		funyuns.setProductName("Chips");
		Assert.assertEquals(funyuns.getProductType(), "Chips");
	}
	
	
	
	
	
	
	
	
	
}
