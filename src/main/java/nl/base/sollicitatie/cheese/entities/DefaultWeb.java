package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.cheese.model.Cheese;
import nl.base.sollicitatie.cheese.model.WebWeergave;

public class DefaultWeb<T extends Cheese> implements WebWeergave {
	
	private T cheese;

	public DefaultWeb(T cheese) {
		this.cheese = cheese;
	}

	@Override
	public String getTitle() {
		return cheese.getFriendlyName();
	}

	@Override
	public double getPrice() {
		return cheese.getPrice();
	}

	@Override
	public int getAvailablePortions() {
		// TODO Auto-generated method stub
		return cheese.getPortions();
	}

}
