package com.idetronic.subur.util.comparator;

import java.util.Comparator;

import com.idetronic.subur.model.Expertise;

public class ExpertiseNameComparator implements Comparator<Expertise> {
	public ExpertiseNameComparator() {
		this(true, true);
	}

	public ExpertiseNameComparator(boolean ascending, boolean caseSensitive) {
		_ascending = ascending;
		_caseSensitive = caseSensitive;
	}

	@Override
	public int compare(Expertise expertise1, Expertise expertise2) {
		String name1 = expertise1.getExpertiseName();//  assetTag1.getName();
		String name2 = expertise2.getExpertiseName();

		int value = 0;

		if (_caseSensitive) {
			value = name1.compareTo(name2);
		}
		else {
			value = name1.compareToIgnoreCase(name2);
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	private boolean _ascending;
	private boolean _caseSensitive;

}
