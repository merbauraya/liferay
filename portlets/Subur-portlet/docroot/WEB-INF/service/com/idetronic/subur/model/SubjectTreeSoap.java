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
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class SubjectTreeSoap implements Serializable {
	public static SubjectTreeSoap toSoapModel(SubjectTree model) {
		SubjectTreeSoap soapModel = new SubjectTreeSoap();

		soapModel.setSubjectId(model.getSubjectId());
		soapModel.setParentId(model.getParentId());
		soapModel.setSubjectName(model.getSubjectName());
		soapModel.setLft(model.getLft());
		soapModel.setRgt(model.getRgt());
		soapModel.setDepositable(model.getDepositable());
		soapModel.setItemCount(model.getItemCount());

		return soapModel;
	}

	public static SubjectTreeSoap[] toSoapModels(SubjectTree[] models) {
		SubjectTreeSoap[] soapModels = new SubjectTreeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubjectTreeSoap[][] toSoapModels(SubjectTree[][] models) {
		SubjectTreeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubjectTreeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubjectTreeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubjectTreeSoap[] toSoapModels(List<SubjectTree> models) {
		List<SubjectTreeSoap> soapModels = new ArrayList<SubjectTreeSoap>(models.size());

		for (SubjectTree model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubjectTreeSoap[soapModels.size()]);
	}

	public SubjectTreeSoap() {
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