package nl.base.sollicitatie.cheese.entities;


import nl.base.sollicitatie.Log;
import nl.base.sollicitatie.cheese.Entity;
import nl.base.sollicitatie.cheese.model.Cheese;
import nl.base.sollicitatie.cheese.model.HasWebrep;

public class Gouda extends Entity implements Cheese, HasWebrep {
	
	private static final Log log  = new Log(Gouda.class); 

	public Gouda() {
		super("gouda");
		put("portions", 20); // gouda cheese has 20 portions
	}
	
	

	public void eatCheese() {
		// TODO Auto-generated method stub
		int portions = (int) get("portions");
		put("portions", portions -1 );
		log.info("Ate some gouda");
	}

	public GoudaWebRep getWeb() {
		return new GoudaWebRep(this);
		
	}


	@Override
	public double getPrice() {
		return 0;
	}



	@Override
	public String getFriendlyName() {
		return "Royal dutch cheese";
	}



	@Override
	public int getPortions() {
		return (int) get("portions");
	}

}
