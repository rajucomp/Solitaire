package nl.base.sollicitatie.cheese;

import nl.base.sollicitatie.cheese.entities.*;
import org.junit.Test;

import junit.framework.Assert;


public class TestCheese {
	
	@Test
	public void eatcheese() {
		Gouda g = new Gouda();
		g.eatCheese();
		GoudaWebRep web = g.getWeb();
		Assert.assertEquals("19 portions of gouda after snacking once", 19, web.getAvailablePortions());
	}

	@Test
	public void eatEmmentaler() {
		Emmentaler g = new Emmentaler();
		g.eatCheese();
		EmmentalerWebRep web = g.getWeb();
		Assert.assertEquals("47 portions of gouda after snacking once", 47, web.getAvailablePortions());
	}
	
	@Test
	public void eatManchego() {
		Manchego g = new Manchego();
		Assert.assertEquals("10 portions of manchego before snacking once", 10, g.getPortions());
		g.eatCheese();
		ManchegoWebRep web = g.getWeb();
		Assert.assertEquals("9 portions of manchego after snacking once", 9, web.getAvailablePortions());
	}
	
	@Test
	public void testManchegoPrice() {
		Manchego g = new Manchego();
		ManchegoWebRep web = g.getWeb();
		Assert.assertEquals(36.50d, web.getPrice());
	}

	@Test
	public void testEmmentalerPrice() {
		Emmentaler g = new Emmentaler();
		EmmentalerWebRep web = g.getWeb();
		Assert.assertEquals(34.50d, web.getPrice());
	}

	public void eatToomuchCheese() {
		Gouda g = new Gouda();
		System.out.println("Cheese");
		GoudaWebRep web = g.getWeb();
		for (int i = 0; i < 22; i++) {
			g.eatCheese();			
		}
		Assert.fail("cant eat more sausage then available (20)");
	}

}
