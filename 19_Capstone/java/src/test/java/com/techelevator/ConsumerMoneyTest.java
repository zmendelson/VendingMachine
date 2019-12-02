package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConsumerMoneyTest {

	ConsumerMoney wallet;

	@Before
	public void setup() {
		wallet = new ConsumerMoney();
	}

	@Test
	public void testGetAndAddToCurrent() {
		wallet.addToCurrent(5.00);
		wallet.addToCurrent(10.00);
		wallet.addToCurrent(5.00);
		wallet.addToCurrent(7.00);
		
		Assert.assertEquals(27, wallet.getCurrentMoney(), 0.000001d);
	}
	
	@Test
	public void testSubractFromCurrent() {
		wallet.addToCurrent(10.00);
		wallet.addToCurrent(7.00);
		wallet.subractFromCurrent(2.00);
		Assert.assertEquals(15, wallet.getCurrentMoney(), 0.001d);
	}
	
	
	
	@Test
	public void testGetAndAddToCurrentWithNegativeMoney() {
		wallet.addToCurrent(-5.00);
		wallet.addToCurrent(10.00);
		
		
		Assert.assertEquals(5, wallet.getCurrentMoney(), 0.000001d);
	}
	
	
	

}
