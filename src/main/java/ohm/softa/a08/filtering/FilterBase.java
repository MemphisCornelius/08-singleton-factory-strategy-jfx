package ohm.softa.a08.filtering;

import ohm.softa.a08.model.Meal;

import java.util.ArrayList;
import java.util.List;

public abstract class FilterBase implements MealsFilter {
	protected String filter;

	protected FilterBase(String filter) {
		this.filter = filter;
	}

	@Override
	public List<Meal> filter(List<Meal> meals) {
		List<Meal> result = new ArrayList<>();
		meals.forEach(m -> {
				if (include(m))
					result.add(m);
			}
		);
		return result;
	}

	abstract boolean include(Meal m);
}
