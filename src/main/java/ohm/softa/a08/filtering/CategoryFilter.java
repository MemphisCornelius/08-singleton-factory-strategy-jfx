package ohm.softa.a08.filtering;

import ohm.softa.a08.model.Meal;

public class CategoryFilter extends FilterBase{
	public CategoryFilter(String filter) {
		super(filter);
	}

	@Override
	boolean include(Meal m) {
		return !m.getCategory().contains(filter);
	}
}
