package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.cheese.model.WebWeergave;

public class EmmentalerWebRep implements WebWeergave {

    final private Emmentaler _emmentaler;

    public EmmentalerWebRep(Emmentaler emmentaler) {
        this._emmentaler = emmentaler;
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return "Emmentaler!";
    }

    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        return 34.50d;
    }

    @Override
    public int getAvailablePortions() {
        // TODO Auto-generated method stub
        return _emmentaler.getPortions();
    }

}
