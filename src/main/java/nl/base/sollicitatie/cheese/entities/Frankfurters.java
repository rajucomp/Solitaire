

package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.cheese.Entity;
import nl.base.sollicitatie.Log;
import nl.base.sollicitatie.cheese.model.FrankfurtersSausage;
import nl.base.sollicitatie.cheese.model.HasWebrep;

public class Frankfurters extends Entity implements HasWebrep, FrankfurtersSausage {

    private static final Log log  = new Log(Frankfurters.class);

    double price = 1.50d;

    public Frankfurters() {
        super("FrankfurtersSausage");
        put("portions", 20); // FrankfurtersSausage cheese has 20 portions
    }

    @Override
    public FrankfurtersWebRep getWeb() {
        // TODO Auto-generated method stub
        return new FrankfurtersWebRep(this);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getFriendlyName() {
        return "FrankfurtersSausage";
    }

    @Override
    public int getPortions() {
        return (int) get("portions");
    }

    @Override
    public void eatSausage() {
        // TODO Auto-generated method stub
        int portions = (int) get("portions");
        put("portions", portions -1 );
    }

}

