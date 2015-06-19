package com.idetronic.subur.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.idetronic.subur.model.Author;

public class AuthorFirstNameComparator extends OrderByComparator{
	public static final String ORDER_BY_ASC = "Subur_Author.firstName ASC";

	public static final String ORDER_BY_DESC = "Subur_Author.firstName DESC";

	public static final String[] ORDER_BY_FIELDS = {"firstName"};
	
	public AuthorFirstNameComparator() {
		this(false);
	}

	public AuthorFirstNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	
	public int compare(Object author1, Object author2) {
		Author obj1 = (Author)author1;
		Author obj2 = (Author)author2;
		String name1 = obj1.getFirstName();
		String name2 = obj2.getFirstName();

		int value = name1.compareTo(name2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}
