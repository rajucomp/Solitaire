package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.Log;
import nl.base.sollicitatie.cheese.Entity;
import nl.base.sollicitatie.cheese.model.Cheese;
import nl.base.sollicitatie.cheese.model.HasWebrep;

public class Manchego extends Entity implements HasWebrep, Cheese {

	private static final Log log  = new Log(Manchego.class);

	public Manchego() {
		super("manchego");
		put("portions", 10); // Manchego cheese has 10 portions
	}

	@Override
	public void eatCheese() {
		// TODO Auto-generated method stub
		int portions = (int) get("portions");
		put("portions", portions - 1);
		log.info("Ate some manchego");
	}

	@Override
	public ManchegoWebRep getWeb() {
		// TODO Auto-generated method stub
		return new ManchegoWebRep(this);
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
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
