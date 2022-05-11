package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.cheese.model.WebWeergave;

public class FrankfurtersWebRep implements WebWeergave {

    private Frankfurters _frankfurters;

    public FrankfurtersWebRep(Frankfurters frankfurters) {

        this._frankfurters = frankfurters;
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return "Frankfurters Sausage";
    }

    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        return this._frankfurters.getPrice();
    }

    @Override
    public int getAvailablePortions() {
        // TODO Auto-generated method stub
        return (int) this._frankfurters.get("portions");
    }

}

