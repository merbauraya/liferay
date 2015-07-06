package com.idetronic.subur;

import com.liferay.portal.kernel.exception.PortalException;

public class ExpertiseException extends PortalException {

	public static final int AT_LEAST_ONE_TAG = 1;

	public static final int INVALID_CHARACTER = 2;

	public ExpertiseException (int type) {
		_type = type;
	}

	public ExpertiseException(String message, int type) {
		super(message);

		_type = type;
	}

	public int getType() {
		return _type;
	}

	private int _type;
}
