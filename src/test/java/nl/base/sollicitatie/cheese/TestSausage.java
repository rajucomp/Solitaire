package nl.base.sollicitatie.cheese;

import junit.framework.Assert;
import nl.base.sollicitatie.cheese.entities.*;
import org.junit.Test;

public class TestSausage {
    @Test
    public void eatFrankfurtersSausage() {
        Frankfurters g = new Frankfurters();
        g.eatSausage();
        FrankfurtersWebRep web = g.getWeb();
        Assert.assertEquals("19 portions of Frankfurters after snacking once", 19, web.getAvailablePortions());
        g.eatSausage();
        Assert.assertEquals("18 portions of Frankfurters after snacking once", 18, web.getAvailablePortions());
    }

    @Test
    public void eatBratwurstSausage() {
        Bratwurst g = new Bratwurst();
        Assert.assertEquals("12 portions of Bratwurst before snacking once", 12, g.getPortions());
        g.eatSausage();
        BratwurstWebRep web = g.getWeb();
        Assert.assertEquals("11 portions of Bratwurst after snacking once", 11, web.getAvailablePortions());
    }

    @Test
    public void testFrankfurtersPrice() {
        Frankfurters g = new Frankfurters();
        FrankfurtersWebRep web = g.getWeb();
        Assert.assertEquals(1.50d, web.getPrice());
    }

    @Test
    public void testBratwurstPrice() {
        Bratwurst g = new Bratwurst();
        BratwurstWebRep web = g.getWeb();
        Assert.assertEquals(2.0d, web.getPrice());
    }

    public void eatToomuchFrankfurtersSausage() {
        Frankfurters g = new Frankfurters();
        System.out.println("Frankfurters Sausage");
        FrankfurtersWebRep web = g.getWeb();
        for (int i = 0; i < 22; i++) {
            g.eatSausage();
        }
        Assert.fail("cant eat more cheese then available (20)");
    }
}
