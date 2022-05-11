package nl.base.sollicitatie;

import java.util.ArrayList;
import java.util.List;

import nl.base.sollicitatie.cheese.Entity;
import nl.base.sollicitatie.cheese.entities.Cheddar;
import nl.base.sollicitatie.cheese.entities.Gouda;
import nl.base.sollicitatie.cheese.entities.Manchego;
import nl.base.sollicitatie.cheese.entities.Parmesan;
import nl.base.sollicitatie.cheese.model.Cheese;
import nl.base.sollicitatie.cheese.model.HasWebrep;
import nl.base.sollicitatie.cheese.model.WebWeergave;

/**
 * The most amazing webapp ever to taste cheese (actual web implementation pending)
 *
 * This represents the web facing part of the cheese tasting app
 *
 */
public class App {
	private static final Log log = new Log(App.class);
	private static final List<Class<? extends Cheese>> registeredCheeses = new ArrayList<Class<? extends Cheese>>();

	static {
		register(Cheddar.class);
		register(Parmesan.class);
		register(Gouda.class);
		register(Manchego.class);
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		App app = new App();

		System.out.println("--- init -- ");
		app.fillDb();
		System.out.println("--- main page -- ");
		app.showMain();
		System.out.println("--- cheese page -- ");
		app.clickEetCheese();
		System.out.println("--- back to main -- ");
		app.showMain();
		System.out.println("--- done -- ");


	}

	private void clickEetCheese() {
		//Assume the user clicked the first gouda
		Entity cheese= new Gouda().load(1);
		System.out.println("You selected: " + ((HasWebrep) cheese).getWeb().getTitle() );
		System.out.println("Eat this cheese? (Y/n)?");
		//Assume the user chose Yes
		System.out.println("\n You chose to eat the cheese, we hope you enjoyed the experience");
		((Cheese) cheese).eatCheese();
		cheese.save();

	}

	private void fillDb() {
		new Gouda().save();
		new Gouda().save();
		new Parmesan().save();
		new Cheddar().save();
		new Manchego().save();
		Manchego partial = new Manchego();
		partial.eatCheese();
		partial.eatCheese();
		partial.eatCheese();
		partial.eatCheese();
		partial.save();

	}

	private void showMain() throws InstantiationException, IllegalAccessException {
		List<Cheese> cheeses = new ArrayList<Cheese>();
		for (Class<? extends Cheese> class1 : registeredCheeses) {
			Cheese prototype = class1.newInstance();
			 cheeses.addAll(Entity.findAll(class1));
		}
		System.out.println(" Welcome to the magnificient cheese tasting web");
		System.out.println(" Taste all of the cheeses of the world*1");
		System.out.println("\n *1: only supported ccheese available)");

		System.out.println(" The following cheese is in stock:");



		for (Cheese cheese : cheeses) {
			if (cheese instanceof HasWebrep) {
				WebWeergave w = ((HasWebrep) cheese).getWeb();
				System.out.println("Try our: " + w.getTitle() + " there are only " + w.getAvailablePortions() + " Portions left! just: $" + w.getPrice() + " a portion");
			} else {
				log.warn("unwebified cheese!");
			}
		}
	}

	private static void register(Class<? extends Cheese> class1) {
		registeredCheeses.add(class1);

	}
}
