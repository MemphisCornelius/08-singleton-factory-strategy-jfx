package ohm.softa.a08.filtering;

import ohm.softa.a08.model.Meal;

public class NotesFilter extends FilterBase {
	public NotesFilter(String filter) {
		super(filter);
	}

	@Override
	boolean include(Meal m) {
		return !m.getNotes().contains(filter);
	}
}
