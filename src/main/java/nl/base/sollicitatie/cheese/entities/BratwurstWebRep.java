package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.cheese.model.WebWeergave;

public class BratwurstWebRep implements WebWeergave {

    private Bratwurst _bratwurst;

    public BratwurstWebRep(Bratwurst bratwurst) {

        this._bratwurst = bratwurst;
    }

    @Override
    public String getTitle() {
        return "Bratwurst Sausage";
    }

    @Override
    public double getPrice() {
        return this._bratwurst.getPrice();
    }

    @Override
    public int getAvailablePortions() {
        // TODO Auto-generated method stub
        return (int) this._bratwurst.get("portions");
    }

}


