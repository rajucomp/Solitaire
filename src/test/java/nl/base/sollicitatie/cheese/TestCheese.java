package nl.base.sollicitatie.cheese;

import org.junit.Test;

import junit.framework.Assert;
import nl.base.sollicitatie.cheese.entities.Gouda;
import nl.base.sollicitatie.cheese.entities.GoudaWebRep;
import nl.base.sollicitatie.cheese.entities.Manchego;
import nl.base.sollicitatie.cheese.entities.ManchegoWebRep;


public class TestCheese {
	
	@Test
	public void eatcheese() {
		Gouda g = new Gouda();
		g.eatCheese();
		GoudaWebRep web = g.getWeb();
		Assert.assertEquals("19 portions of gouda after snacking once", 19, web.getAvailablePortions());
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
		Assert.assertEquals(25.12d, web.getPrice());
	}
	
	public void eatToomuchCheese() {
		Gouda g = new Gouda();
		System.out.println("Cheese");
		GoudaWebRep web = g.getWeb();
		for (int i = 0; i < 22; i++) {
			g.eatCheese();			
		}
		Assert.fail("cant eat more cheese then available (20)");
	}

}
