package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {

	Gum juicyfruit;

	@Before
	public void setup() {

		juicyfruit = new Gum();
	}

	@Test
	public void testGetAndSetPrice() {
		juicyfruit.setPrice(7.00);
		Assert.assertEquals(7.00, juicyfruit.getPrice(), 0.0001d);

	}

	@Test
	public void testGetAndSetProductType() {
		juicyfruit.setProductName("Gum");
		Assert.assertEquals(juicyfruit.getProductType(), "Gum");
	}

	@Test
	public void testGetQuantity() {
		juicyfruit.getQuantity();
		Assert.assertEquals(5, juicyfruit.getQuantity());
	}

	@Test
	public void testconsume() {
		juicyfruit.consume();
		Assert.assertEquals("Chew Chew, Chew Chew Chew Yummy!", juicyfruit.consume());

	}

	@Test
	public void testGetAndSetslotID() {
		juicyfruit.setSlotID("B66");
		Assert.assertEquals(juicyfruit.getSlotID(), "B66");

	}

	@Test
	public void testPurchase() {
		juicyfruit.purchase();
		Assert.assertEquals(4, juicyfruit.getQuantity());

	}
	

}
