package ohm.softa.a08.filtering;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class MealsFilterFactory {

	private static Map<String, MealsFilter> strategies = new HashMap<>();;
	static {
		strategies.put("All", new NoFilter());
		strategies.put("No soy", new NotesFilter("mit Soja"));
		strategies.put("No pork", new CategoryFilter("Schwein"));
		strategies.put(null, new NoFilter());
	}

	public static MealsFilter getStrategy(String key) {
		return strategies.get(key);
	}

	public static Set<String> getStrategies() {
		return strategies.keySet();
	}
}
