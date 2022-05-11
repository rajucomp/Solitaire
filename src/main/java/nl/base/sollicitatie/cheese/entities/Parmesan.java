package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.cheese.Entity;
import nl.base.sollicitatie.cheese.model.Cheese;
import nl.base.sollicitatie.cheese.model.HasWebrep;
import nl.base.sollicitatie.cheese.model.WebWeergave;

public class Parmesan extends Entity implements Cheese, HasWebrep {

	public Parmesan() {
		super("parmesan");
		put("portions", 250);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrice() {
		return 5.0d;
	}

	@Override
	public String getFriendlyName() {
		return "Parmensan, grated for your pleasure";
	}

	@Override
	public int getPortions() {
		return (int) get("portions");
	}

	@Override
	public WebWeergave getWeb() {
		return new DefaultWeb<Parmesan>(this);
	}


	@Override
	public void eatCheese() {
		// TODO Auto-generated method stub
		int portions = (int) get("portions");
		put("portions", portions -1 );
	}

}
