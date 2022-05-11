package nl.base.sollicitatie.cheese;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import nl.base.sollicitatie.cheese.model.Cheese;
import nl.base.sollicitatie.cheese.model.Sausage;


/**
 *
 * @author goddijn
 *
 * 	Assume this is someframe work for persistence etc.
 *
 *  Assume a lot of other stuff using/extending this
 *
 */
public abstract class Entity extends HashMap<String, Object> {

	private static final AtomicInteger keygen = new AtomicInteger();

	private long key;

	private String entityname;

	protected Entity(String entityname) {
		this.entityname = entityname;
		this.key = keygen.getAndIncrement();
	}


	//Asssume this is an actual DB / Persistence system
	private static final Map<String,Entity> dataBase = new HashMap<>();


	public void save() {
		doSave();
	}


	protected final void doSave() {
		dataBase.put(entityname + ":" + key, this);
	}

	public <T extends Entity> T load(long key) {
		return (T) dataBase.get(entityname +":" + key);
	}

	public long getKey() {
		return key;
	}


	public static List<Cheese> findAll(Class<? extends Cheese> class1) {
		List<Cheese> out = new ArrayList<>();
		try {
			Cheese prototype = class1.newInstance();
			if(!(prototype instanceof Entity)) {
				throw new IllegalStateException("Unpossible");
			}
			Entity protoEntity = (Entity) prototype;
			for (java.util.Map.Entry<String, Entity> item : dataBase.entrySet()) {
				if (item.getKey().startsWith(protoEntity.entityname + ":")) {
					out.add((Cheese) item.getValue());
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;

	}

	public static List<Sausage> findAllSausage(Class<? extends Sausage> class1) {
		List<Sausage> out = new ArrayList<>();
		try {
			Sausage prototype = class1.newInstance();
			if(!(prototype instanceof Entity)) {
				throw new IllegalStateException("Unpossible");
			}
			Entity protoEntity = (Entity) prototype;
			for (java.util.Map.Entry<String, Entity> item : dataBase.entrySet()) {
				if (item.getKey().startsWith(protoEntity.entityname + ":")) {
					out.add((Sausage) item.getValue());
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;

	}

}
