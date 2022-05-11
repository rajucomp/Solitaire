package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.cheese.Entity;
import nl.base.sollicitatie.Log;
import nl.base.sollicitatie.cheese.model.Cheese;
import nl.base.sollicitatie.cheese.model.HasWebrep;

public class Emmentaler extends Entity implements HasWebrep, Cheese {

	private static final Log log  = new Log(Emmentaler.class);

	double price = 34.50d;

	public Emmentaler() {
		super("Emmentaler");
		put("portions", 48); // Emmentaler cheese has 48 portions
	}

	@Override
	public void eatCheese() {
		// TODO Auto-generated method stub
		int portions = (int) get("portions");
		put("portions", portions - 1);
		log.info("Ate some Emmentaler");
	}

	@Override
	public EmmentalerWebRep getWeb() {
		// TODO Auto-generated method stub
		return new EmmentalerWebRep(this);
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public String getFriendlyName() {
		// TODO Auto-generated method stub
		return "Manchego";
	}

	@Override
	public int getPortions() {
		return (int) get("portions");
	}



}

