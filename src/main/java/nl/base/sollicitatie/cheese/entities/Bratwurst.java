package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.Log;
import nl.base.sollicitatie.cheese.Entity;
import nl.base.sollicitatie.cheese.model.BratwurstSausage;
import nl.base.sollicitatie.cheese.model.FrankfurtersSausage;
import nl.base.sollicitatie.cheese.model.HasWebrep;

public class Bratwurst extends Entity implements HasWebrep, BratwurstSausage {

    private static final Log log  = new Log(Bratwurst.class);

    double price = 2.0d;

    public Bratwurst() {
        super("BratwurstSausage");
        put("portions", 12); // Bratwurst Sausage cheese has 12 portions
    }

    @Override
    public BratwurstWebRep getWeb() {
        // TODO Auto-generated method stub
        return new BratwurstWebRep(this);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getFriendlyName() {
        return "BratwurstSausage";
    }

    @Override
    public int getPortions() {
        return (int) get("portions");
    }

    @Override
    public void eatSausage() {
        int portions = (int) get("portions");
        put("portions", portions -1 );
    }

}

