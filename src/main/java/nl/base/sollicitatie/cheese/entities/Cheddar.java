package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.cheese.Entity;
import nl.base.sollicitatie.cheese.model.Cheese;
import nl.base.sollicitatie.cheese.model.HasWebrep;
import nl.base.sollicitatie.cheese.model.WebWeergave;

public class Cheddar extends Entity implements Cheese, HasWebrep {

	public Cheddar() {
		super("cheddar");
		put("portions", 40);
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 1.24d;
	}

	@Override
	public String getFriendlyName() {
		// TODO Auto-generated method stub
		return "Proper Brittish cheddar";
	}

	@Override
	public int getPortions() {
		return (int) get("portions");
	}

	@Override
	public WebWeergave getWeb() {
		// TODO Auto-generated method stub
		return new DefaultWeb<Cheddar>(this);
	}



	@Override
	public void eatCheese() {
		// TODO Auto-generated method stub
		int portions = (int) get("portions");
		put("portions", portions -1 );
	}

}
