package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {

	Candy jujubees;

	@Before
	public void setup() {
		jujubees = new Candy();
	}

	@Test
	public void testGetAndSetPrice() {
		jujubees.setPrice(10.00);
		Assert.assertEquals(10.00, jujubees.getPrice(), 0.0001d);

	}

	@Test
	public void testGetQuantity() {

		jujubees.getQuantity();
		Assert.assertEquals(5, jujubees.getQuantity());
	}

	@Test
	public void testConsume() {
		jujubees.consume();
		Assert.assertEquals("Crunch Chew, Yum!", jujubees.consume());

	}

	@Test
	public void testPurchaseWhenQuantityGreaterThanZero() {
		jujubees.purchase();
		Assert.assertEquals(4, jujubees.getQuantity());

	}
	
	
	@Test
	public void testGetAndSetProductType() {
		jujubees.setProductName("Candy");
		Assert.assertEquals(jujubees.getProductType(), "Candy");
	}
}
