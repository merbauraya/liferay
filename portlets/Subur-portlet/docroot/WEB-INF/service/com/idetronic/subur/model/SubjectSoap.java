/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.idetronic.subur.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.subur.service.http.SubjectServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.http.SubjectServiceSoap
 * @generated
 */
public class SubjectSoap implements Serializable {
	public static SubjectSoap toSoapModel(Subject model) {
		SubjectSoap soapModel = new SubjectSoap();

		soapModel.setSubjectId(model.getSubjectId());
		soapModel.setParentId(model.getParentId());
		soapModel.setSubjectName(model.getSubjectName());
		soapModel.setLft(model.getLft());
		soapModel.setRgt(model.getRgt());
		soapModel.setDepositable(model.getDepositable());
		soapModel.setItemCount(model.getItemCount());

		return soapModel;
	}

	public static SubjectSoap[] toSoapModels(Subject[] models) {
		SubjectSoap[] soapModels = new SubjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubjectSoap[][] toSoapModels(Subject[][] models) {
		SubjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubjectSoap[] toSoapModels(List<Subject> models) {
		List<SubjectSoap> soapModels = new ArrayList<SubjectSoap>(models.size());

		for (Subject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubjectSoap[soapModels.size()]);
	}

	public SubjectSoap() {
	}

	public long getPrimaryKey() {
		return _subjectId;
	}

	public void setPrimaryKey(long pk) {
		setSubjectId(pk);
	}

	public long getSubjectId() {
		return _subjectId;
	}

	public void setSubjectId(long subjectId) {
		_subjectId = subjectId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getSubjectName() {
		return _subjectName;
	}

	public void setSubjectName(String subjectName) {
		_subjectName = subjectName;
	}

	public int getLft() {
		return _lft;
	}

	public void setLft(int lft) {
		_lft = lft;
	}

	public int getRgt() {
		return _rgt;
	}

	public void setRgt(int rgt) {
		_rgt = rgt;
	}

	public boolean getDepositable() {
		return _depositable;
	}

	public boolean isDepositable() {
		return _depositable;
	}

	public void setDepositable(boolean depositable) {
		_depositable = depositable;
	}

	public int getItemCount() {
		return _itemCount;
	}

	public void setItemCount(int itemCount) {
		_itemCount = itemCount;
	}

	private long _subjectId;
	private long _parentId;
	private String _subjectName;
	private int _lft;
	private int _rgt;
	private boolean _depositable;
	private int _itemCount;
}