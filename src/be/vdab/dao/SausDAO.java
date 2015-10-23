package be.vdab.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import be.vdab.entities.Saus;

public class SausDAO {
	private static final Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();

	static {
		SAUZEN.put(12L, new Saus(12L, "cocktail", Arrays.asList("mayonaise", "ketchup", "whisky")));
		SAUZEN.put(14L, new Saus(14L, "mayonaise", Arrays.asList("ei", "mosterd")));
		SAUZEN.put(17L, new Saus(17L, "mosterd", Arrays.asList("mayonaise", "azijn", "whisky")));
		SAUZEN.put(23L, new Saus(23L, "tartare", Arrays.asList("mayonaise", "ketchup", "whisky", "azijn")));
		SAUZEN.put(24L, new Saus(24L, "vinaigrette", Arrays.asList("olijfolie", "mosterd", "azijn")));
	}

	public List<Saus> findAll() {
		return new ArrayList<>(SAUZEN.values());
	}

	public Saus read(long id) {
		return SAUZEN.get(id);
	}

	public void create(Saus saus) {

	}
	
	public void delete(long nummer){
		SAUZEN.remove(nummer);
	}

	public List<Saus> findSauzenMetIngredient(String ingredient) {
		List<Saus> gevondenSauzen = new ArrayList<>();
		for (Saus saus : findAll()) {
			for (String ingredientInSaus : saus.getIngredienten()) {
				if (ingredientInSaus.equalsIgnoreCase(ingredient)) {
					gevondenSauzen.add(saus);
				}
			}
		}
		return gevondenSauzen;
	}
}
