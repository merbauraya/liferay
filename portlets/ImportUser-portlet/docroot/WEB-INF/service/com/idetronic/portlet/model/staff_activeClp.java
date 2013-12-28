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

package com.idetronic.portlet.model;

import com.idetronic.portlet.service.ClpSerializer;
import com.idetronic.portlet.service.staff_activeLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class staff_activeClp extends BaseModelImpl<staff_active>
	implements staff_active {
	public staff_activeClp() {
	}

	public Class<?> getModelClass() {
		return staff_active.class;
	}

	public String getModelClassName() {
		return staff_active.class.getName();
	}

	public String getPrimaryKey() {
		return _bp_no_kp;
	}

	public void setPrimaryKey(String primaryKey) {
		setBp_no_kp(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _bp_no_kp;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bp_name", getBp_name());
		attributes.put("bp_no_pekerja", getBp_no_pekerja());
		attributes.put("bp_no_kp", getBp_no_kp());
		attributes.put("bk_jab_hakiki", getBk_jab_hakiki());
		attributes.put("bk_jab_hakiki_desc", getBk_jab_hakiki_desc());
		attributes.put("bk_jab_sekarang", getBk_jab_sekarang());
		attributes.put("bk_jab_sekarang_desc", getBk_jab_sekarang_desc());
		attributes.put("bk_jaw_jenis", getBk_jaw_jenis());
		attributes.put("al_alamat1", getAl_alamat1());
		attributes.put("al_alamat2", getAl_alamat2());
		attributes.put("al_alamat3", getAl_alamat3());
		attributes.put("al_poskod", getAl_poskod());
		attributes.put("al_bandar", getAl_bandar());
		attributes.put("al_negeri", getAl_negeri());
		attributes.put("al_negara", getAl_negara());
		attributes.put("bp_telefon", getBp_telefon());
		attributes.put("bp_email", getBp_email());
		attributes.put("bp_tjangka_bsara", getBp_tjangka_bsara());
		attributes.put("bp_rekod_status", getBp_rekod_status());
		attributes.put("bk_jaw_hakiki", getBk_jaw_hakiki());
		attributes.put("bk_jaw_hakiki_desc", getBk_jaw_hakiki_desc());
		attributes.put("bk_jaw_sekarang", getBk_jaw_sekarang());
		attributes.put("bk_jaw_sekarang_desc", getBk_jaw_sekarang_desc());
		attributes.put("bk_tarikh_lahir", getBk_tarikh_lahir());
		attributes.put("bk_tarikh_masuk", getBk_tarikh_masuk());
		attributes.put("bk_rekod_status", getBk_rekod_status());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String bp_name = (String)attributes.get("bp_name");

		if (bp_name != null) {
			setBp_name(bp_name);
		}

		String bp_no_pekerja = (String)attributes.get("bp_no_pekerja");

		if (bp_no_pekerja != null) {
			setBp_no_pekerja(bp_no_pekerja);
		}

		String bp_no_kp = (String)attributes.get("bp_no_kp");

		if (bp_no_kp != null) {
			setBp_no_kp(bp_no_kp);
		}

		String bk_jab_hakiki = (String)attributes.get("bk_jab_hakiki");

		if (bk_jab_hakiki != null) {
			setBk_jab_hakiki(bk_jab_hakiki);
		}

		String bk_jab_hakiki_desc = (String)attributes.get("bk_jab_hakiki_desc");

		if (bk_jab_hakiki_desc != null) {
			setBk_jab_hakiki_desc(bk_jab_hakiki_desc);
		}

		String bk_jab_sekarang = (String)attributes.get("bk_jab_sekarang");

		if (bk_jab_sekarang != null) {
			setBk_jab_sekarang(bk_jab_sekarang);
		}

		String bk_jab_sekarang_desc = (String)attributes.get(
				"bk_jab_sekarang_desc");

		if (bk_jab_sekarang_desc != null) {
			setBk_jab_sekarang_desc(bk_jab_sekarang_desc);
		}

		String bk_jaw_jenis = (String)attributes.get("bk_jaw_jenis");

		if (bk_jaw_jenis != null) {
			setBk_jaw_jenis(bk_jaw_jenis);
		}

		String al_alamat1 = (String)attributes.get("al_alamat1");

		if (al_alamat1 != null) {
			setAl_alamat1(al_alamat1);
		}

		String al_alamat2 = (String)attributes.get("al_alamat2");

		if (al_alamat2 != null) {
			setAl_alamat2(al_alamat2);
		}

		String al_alamat3 = (String)attributes.get("al_alamat3");

		if (al_alamat3 != null) {
			setAl_alamat3(al_alamat3);
		}

		String al_poskod = (String)attributes.get("al_poskod");

		if (al_poskod != null) {
			setAl_poskod(al_poskod);
		}

		String al_bandar = (String)attributes.get("al_bandar");

		if (al_bandar != null) {
			setAl_bandar(al_bandar);
		}

		String al_negeri = (String)attributes.get("al_negeri");

		if (al_negeri != null) {
			setAl_negeri(al_negeri);
		}

		String al_negara = (String)attributes.get("al_negara");

		if (al_negara != null) {
			setAl_negara(al_negara);
		}

		String bp_telefon = (String)attributes.get("bp_telefon");

		if (bp_telefon != null) {
			setBp_telefon(bp_telefon);
		}

		String bp_email = (String)attributes.get("bp_email");

		if (bp_email != null) {
			setBp_email(bp_email);
		}

		Date bp_tjangka_bsara = (Date)attributes.get("bp_tjangka_bsara");

		if (bp_tjangka_bsara != null) {
			setBp_tjangka_bsara(bp_tjangka_bsara);
		}

		String bp_rekod_status = (String)attributes.get("bp_rekod_status");

		if (bp_rekod_status != null) {
			setBp_rekod_status(bp_rekod_status);
		}

		String bk_jaw_hakiki = (String)attributes.get("bk_jaw_hakiki");

		if (bk_jaw_hakiki != null) {
			setBk_jaw_hakiki(bk_jaw_hakiki);
		}

		String bk_jaw_hakiki_desc = (String)attributes.get("bk_jaw_hakiki_desc");

		if (bk_jaw_hakiki_desc != null) {
			setBk_jaw_hakiki_desc(bk_jaw_hakiki_desc);
		}

		String bk_jaw_sekarang = (String)attributes.get("bk_jaw_sekarang");

		if (bk_jaw_sekarang != null) {
			setBk_jaw_sekarang(bk_jaw_sekarang);
		}

		String bk_jaw_sekarang_desc = (String)attributes.get(
				"bk_jaw_sekarang_desc");

		if (bk_jaw_sekarang_desc != null) {
			setBk_jaw_sekarang_desc(bk_jaw_sekarang_desc);
		}

		Date bk_tarikh_lahir = (Date)attributes.get("bk_tarikh_lahir");

		if (bk_tarikh_lahir != null) {
			setBk_tarikh_lahir(bk_tarikh_lahir);
		}

		Date bk_tarikh_masuk = (Date)attributes.get("bk_tarikh_masuk");

		if (bk_tarikh_masuk != null) {
			setBk_tarikh_masuk(bk_tarikh_masuk);
		}

		String bk_rekod_status = (String)attributes.get("bk_rekod_status");

		if (bk_rekod_status != null) {
			setBk_rekod_status(bk_rekod_status);
		}
	}

	public String getBp_name() {
		return _bp_name;
	}

	public void setBp_name(String bp_name) {
		_bp_name = bp_name;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBp_name", String.class);

				method.invoke(_staff_activeRemoteModel, bp_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBp_no_pekerja() {
		return _bp_no_pekerja;
	}

	public void setBp_no_pekerja(String bp_no_pekerja) {
		_bp_no_pekerja = bp_no_pekerja;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBp_no_pekerja", String.class);

				method.invoke(_staff_activeRemoteModel, bp_no_pekerja);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBp_no_kp() {
		return _bp_no_kp;
	}

	public void setBp_no_kp(String bp_no_kp) {
		_bp_no_kp = bp_no_kp;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBp_no_kp", String.class);

				method.invoke(_staff_activeRemoteModel, bp_no_kp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBk_jab_hakiki() {
		return _bk_jab_hakiki;
	}

	public void setBk_jab_hakiki(String bk_jab_hakiki) {
		_bk_jab_hakiki = bk_jab_hakiki;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_jab_hakiki", String.class);

				method.invoke(_staff_activeRemoteModel, bk_jab_hakiki);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBk_jab_hakiki_desc() {
		return _bk_jab_hakiki_desc;
	}

	public void setBk_jab_hakiki_desc(String bk_jab_hakiki_desc) {
		_bk_jab_hakiki_desc = bk_jab_hakiki_desc;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_jab_hakiki_desc",
						String.class);

				method.invoke(_staff_activeRemoteModel, bk_jab_hakiki_desc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBk_jab_sekarang() {
		return _bk_jab_sekarang;
	}

	public void setBk_jab_sekarang(String bk_jab_sekarang) {
		_bk_jab_sekarang = bk_jab_sekarang;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_jab_sekarang",
						String.class);

				method.invoke(_staff_activeRemoteModel, bk_jab_sekarang);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBk_jab_sekarang_desc() {
		return _bk_jab_sekarang_desc;
	}

	public void setBk_jab_sekarang_desc(String bk_jab_sekarang_desc) {
		_bk_jab_sekarang_desc = bk_jab_sekarang_desc;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_jab_sekarang_desc",
						String.class);

				method.invoke(_staff_activeRemoteModel, bk_jab_sekarang_desc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBk_jaw_jenis() {
		return _bk_jaw_jenis;
	}

	public void setBk_jaw_jenis(String bk_jaw_jenis) {
		_bk_jaw_jenis = bk_jaw_jenis;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_jaw_jenis", String.class);

				method.invoke(_staff_activeRemoteModel, bk_jaw_jenis);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAl_alamat1() {
		return _al_alamat1;
	}

	public void setAl_alamat1(String al_alamat1) {
		_al_alamat1 = al_alamat1;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setAl_alamat1", String.class);

				method.invoke(_staff_activeRemoteModel, al_alamat1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAl_alamat2() {
		return _al_alamat2;
	}

	public void setAl_alamat2(String al_alamat2) {
		_al_alamat2 = al_alamat2;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setAl_alamat2", String.class);

				method.invoke(_staff_activeRemoteModel, al_alamat2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAl_alamat3() {
		return _al_alamat3;
	}

	public void setAl_alamat3(String al_alamat3) {
		_al_alamat3 = al_alamat3;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setAl_alamat3", String.class);

				method.invoke(_staff_activeRemoteModel, al_alamat3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAl_poskod() {
		return _al_poskod;
	}

	public void setAl_poskod(String al_poskod) {
		_al_poskod = al_poskod;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setAl_poskod", String.class);

				method.invoke(_staff_activeRemoteModel, al_poskod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAl_bandar() {
		return _al_bandar;
	}

	public void setAl_bandar(String al_bandar) {
		_al_bandar = al_bandar;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setAl_bandar", String.class);

				method.invoke(_staff_activeRemoteModel, al_bandar);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAl_negeri() {
		return _al_negeri;
	}

	public void setAl_negeri(String al_negeri) {
		_al_negeri = al_negeri;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setAl_negeri", String.class);

				method.invoke(_staff_activeRemoteModel, al_negeri);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAl_negara() {
		return _al_negara;
	}

	public void setAl_negara(String al_negara) {
		_al_negara = al_negara;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setAl_negara", String.class);

				method.invoke(_staff_activeRemoteModel, al_negara);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBp_telefon() {
		return _bp_telefon;
	}

	public void setBp_telefon(String bp_telefon) {
		_bp_telefon = bp_telefon;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBp_telefon", String.class);

				method.invoke(_staff_activeRemoteModel, bp_telefon);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBp_email() {
		return _bp_email;
	}

	public void setBp_email(String bp_email) {
		_bp_email = bp_email;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBp_email", String.class);

				method.invoke(_staff_activeRemoteModel, bp_email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getBp_tjangka_bsara() {
		return _bp_tjangka_bsara;
	}

	public void setBp_tjangka_bsara(Date bp_tjangka_bsara) {
		_bp_tjangka_bsara = bp_tjangka_bsara;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBp_tjangka_bsara",
						Date.class);

				method.invoke(_staff_activeRemoteModel, bp_tjangka_bsara);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBp_rekod_status() {
		return _bp_rekod_status;
	}

	public void setBp_rekod_status(String bp_rekod_status) {
		_bp_rekod_status = bp_rekod_status;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBp_rekod_status",
						String.class);

				method.invoke(_staff_activeRemoteModel, bp_rekod_status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBk_jaw_hakiki() {
		return _bk_jaw_hakiki;
	}

	public void setBk_jaw_hakiki(String bk_jaw_hakiki) {
		_bk_jaw_hakiki = bk_jaw_hakiki;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_jaw_hakiki", String.class);

				method.invoke(_staff_activeRemoteModel, bk_jaw_hakiki);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBk_jaw_hakiki_desc() {
		return _bk_jaw_hakiki_desc;
	}

	public void setBk_jaw_hakiki_desc(String bk_jaw_hakiki_desc) {
		_bk_jaw_hakiki_desc = bk_jaw_hakiki_desc;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_jaw_hakiki_desc",
						String.class);

				method.invoke(_staff_activeRemoteModel, bk_jaw_hakiki_desc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBk_jaw_sekarang() {
		return _bk_jaw_sekarang;
	}

	public void setBk_jaw_sekarang(String bk_jaw_sekarang) {
		_bk_jaw_sekarang = bk_jaw_sekarang;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_jaw_sekarang",
						String.class);

				method.invoke(_staff_activeRemoteModel, bk_jaw_sekarang);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBk_jaw_sekarang_desc() {
		return _bk_jaw_sekarang_desc;
	}

	public void setBk_jaw_sekarang_desc(String bk_jaw_sekarang_desc) {
		_bk_jaw_sekarang_desc = bk_jaw_sekarang_desc;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_jaw_sekarang_desc",
						String.class);

				method.invoke(_staff_activeRemoteModel, bk_jaw_sekarang_desc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getBk_tarikh_lahir() {
		return _bk_tarikh_lahir;
	}

	public void setBk_tarikh_lahir(Date bk_tarikh_lahir) {
		_bk_tarikh_lahir = bk_tarikh_lahir;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_tarikh_lahir", Date.class);

				method.invoke(_staff_activeRemoteModel, bk_tarikh_lahir);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getBk_tarikh_masuk() {
		return _bk_tarikh_masuk;
	}

	public void setBk_tarikh_masuk(Date bk_tarikh_masuk) {
		_bk_tarikh_masuk = bk_tarikh_masuk;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_tarikh_masuk", Date.class);

				method.invoke(_staff_activeRemoteModel, bk_tarikh_masuk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBk_rekod_status() {
		return _bk_rekod_status;
	}

	public void setBk_rekod_status(String bk_rekod_status) {
		_bk_rekod_status = bk_rekod_status;

		if (_staff_activeRemoteModel != null) {
			try {
				Class<?> clazz = _staff_activeRemoteModel.getClass();

				Method method = clazz.getMethod("setBk_rekod_status",
						String.class);

				method.invoke(_staff_activeRemoteModel, bk_rekod_status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getstaff_activeRemoteModel() {
		return _staff_activeRemoteModel;
	}

	public void setstaff_activeRemoteModel(BaseModel<?> staff_activeRemoteModel) {
		_staff_activeRemoteModel = staff_activeRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _staff_activeRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_staff_activeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			staff_activeLocalServiceUtil.addstaff_active(this);
		}
		else {
			staff_activeLocalServiceUtil.updatestaff_active(this);
		}
	}

	@Override
	public staff_active toEscapedModel() {
		return (staff_active)ProxyUtil.newProxyInstance(staff_active.class.getClassLoader(),
			new Class[] { staff_active.class }, new AutoEscapeBeanHandler(this));
	}

	public staff_active toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		staff_activeClp clone = new staff_activeClp();

		clone.setBp_name(getBp_name());
		clone.setBp_no_pekerja(getBp_no_pekerja());
		clone.setBp_no_kp(getBp_no_kp());
		clone.setBk_jab_hakiki(getBk_jab_hakiki());
		clone.setBk_jab_hakiki_desc(getBk_jab_hakiki_desc());
		clone.setBk_jab_sekarang(getBk_jab_sekarang());
		clone.setBk_jab_sekarang_desc(getBk_jab_sekarang_desc());
		clone.setBk_jaw_jenis(getBk_jaw_jenis());
		clone.setAl_alamat1(getAl_alamat1());
		clone.setAl_alamat2(getAl_alamat2());
		clone.setAl_alamat3(getAl_alamat3());
		clone.setAl_poskod(getAl_poskod());
		clone.setAl_bandar(getAl_bandar());
		clone.setAl_negeri(getAl_negeri());
		clone.setAl_negara(getAl_negara());
		clone.setBp_telefon(getBp_telefon());
		clone.setBp_email(getBp_email());
		clone.setBp_tjangka_bsara(getBp_tjangka_bsara());
		clone.setBp_rekod_status(getBp_rekod_status());
		clone.setBk_jaw_hakiki(getBk_jaw_hakiki());
		clone.setBk_jaw_hakiki_desc(getBk_jaw_hakiki_desc());
		clone.setBk_jaw_sekarang(getBk_jaw_sekarang());
		clone.setBk_jaw_sekarang_desc(getBk_jaw_sekarang_desc());
		clone.setBk_tarikh_lahir(getBk_tarikh_lahir());
		clone.setBk_tarikh_masuk(getBk_tarikh_masuk());
		clone.setBk_rekod_status(getBk_rekod_status());

		return clone;
	}

	public int compareTo(staff_active staff_active) {
		String primaryKey = staff_active.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof staff_activeClp)) {
			return false;
		}

		staff_activeClp staff_active = (staff_activeClp)obj;

		String primaryKey = staff_active.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{bp_name=");
		sb.append(getBp_name());
		sb.append(", bp_no_pekerja=");
		sb.append(getBp_no_pekerja());
		sb.append(", bp_no_kp=");
		sb.append(getBp_no_kp());
		sb.append(", bk_jab_hakiki=");
		sb.append(getBk_jab_hakiki());
		sb.append(", bk_jab_hakiki_desc=");
		sb.append(getBk_jab_hakiki_desc());
		sb.append(", bk_jab_sekarang=");
		sb.append(getBk_jab_sekarang());
		sb.append(", bk_jab_sekarang_desc=");
		sb.append(getBk_jab_sekarang_desc());
		sb.append(", bk_jaw_jenis=");
		sb.append(getBk_jaw_jenis());
		sb.append(", al_alamat1=");
		sb.append(getAl_alamat1());
		sb.append(", al_alamat2=");
		sb.append(getAl_alamat2());
		sb.append(", al_alamat3=");
		sb.append(getAl_alamat3());
		sb.append(", al_poskod=");
		sb.append(getAl_poskod());
		sb.append(", al_bandar=");
		sb.append(getAl_bandar());
		sb.append(", al_negeri=");
		sb.append(getAl_negeri());
		sb.append(", al_negara=");
		sb.append(getAl_negara());
		sb.append(", bp_telefon=");
		sb.append(getBp_telefon());
		sb.append(", bp_email=");
		sb.append(getBp_email());
		sb.append(", bp_tjangka_bsara=");
		sb.append(getBp_tjangka_bsara());
		sb.append(", bp_rekod_status=");
		sb.append(getBp_rekod_status());
		sb.append(", bk_jaw_hakiki=");
		sb.append(getBk_jaw_hakiki());
		sb.append(", bk_jaw_hakiki_desc=");
		sb.append(getBk_jaw_hakiki_desc());
		sb.append(", bk_jaw_sekarang=");
		sb.append(getBk_jaw_sekarang());
		sb.append(", bk_jaw_sekarang_desc=");
		sb.append(getBk_jaw_sekarang_desc());
		sb.append(", bk_tarikh_lahir=");
		sb.append(getBk_tarikh_lahir());
		sb.append(", bk_tarikh_masuk=");
		sb.append(getBk_tarikh_masuk());
		sb.append(", bk_rekod_status=");
		sb.append(getBk_rekod_status());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.portlet.model.staff_active");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bp_name</column-name><column-value><![CDATA[");
		sb.append(getBp_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bp_no_pekerja</column-name><column-value><![CDATA[");
		sb.append(getBp_no_pekerja());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bp_no_kp</column-name><column-value><![CDATA[");
		sb.append(getBp_no_kp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_jab_hakiki</column-name><column-value><![CDATA[");
		sb.append(getBk_jab_hakiki());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_jab_hakiki_desc</column-name><column-value><![CDATA[");
		sb.append(getBk_jab_hakiki_desc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_jab_sekarang</column-name><column-value><![CDATA[");
		sb.append(getBk_jab_sekarang());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_jab_sekarang_desc</column-name><column-value><![CDATA[");
		sb.append(getBk_jab_sekarang_desc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_jaw_jenis</column-name><column-value><![CDATA[");
		sb.append(getBk_jaw_jenis());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>al_alamat1</column-name><column-value><![CDATA[");
		sb.append(getAl_alamat1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>al_alamat2</column-name><column-value><![CDATA[");
		sb.append(getAl_alamat2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>al_alamat3</column-name><column-value><![CDATA[");
		sb.append(getAl_alamat3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>al_poskod</column-name><column-value><![CDATA[");
		sb.append(getAl_poskod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>al_bandar</column-name><column-value><![CDATA[");
		sb.append(getAl_bandar());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>al_negeri</column-name><column-value><![CDATA[");
		sb.append(getAl_negeri());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>al_negara</column-name><column-value><![CDATA[");
		sb.append(getAl_negara());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bp_telefon</column-name><column-value><![CDATA[");
		sb.append(getBp_telefon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bp_email</column-name><column-value><![CDATA[");
		sb.append(getBp_email());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bp_tjangka_bsara</column-name><column-value><![CDATA[");
		sb.append(getBp_tjangka_bsara());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bp_rekod_status</column-name><column-value><![CDATA[");
		sb.append(getBp_rekod_status());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_jaw_hakiki</column-name><column-value><![CDATA[");
		sb.append(getBk_jaw_hakiki());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_jaw_hakiki_desc</column-name><column-value><![CDATA[");
		sb.append(getBk_jaw_hakiki_desc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_jaw_sekarang</column-name><column-value><![CDATA[");
		sb.append(getBk_jaw_sekarang());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_jaw_sekarang_desc</column-name><column-value><![CDATA[");
		sb.append(getBk_jaw_sekarang_desc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_tarikh_lahir</column-name><column-value><![CDATA[");
		sb.append(getBk_tarikh_lahir());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_tarikh_masuk</column-name><column-value><![CDATA[");
		sb.append(getBk_tarikh_masuk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bk_rekod_status</column-name><column-value><![CDATA[");
		sb.append(getBk_rekod_status());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _bp_name;
	private String _bp_no_pekerja;
	private String _bp_no_kp;
	private String _bk_jab_hakiki;
	private String _bk_jab_hakiki_desc;
	private String _bk_jab_sekarang;
	private String _bk_jab_sekarang_desc;
	private String _bk_jaw_jenis;
	private String _al_alamat1;
	private String _al_alamat2;
	private String _al_alamat3;
	private String _al_poskod;
	private String _al_bandar;
	private String _al_negeri;
	private String _al_negara;
	private String _bp_telefon;
	private String _bp_email;
	private Date _bp_tjangka_bsara;
	private String _bp_rekod_status;
	private String _bk_jaw_hakiki;
	private String _bk_jaw_hakiki_desc;
	private String _bk_jaw_sekarang;
	private String _bk_jaw_sekarang_desc;
	private Date _bk_tarikh_lahir;
	private Date _bk_tarikh_masuk;
	private String _bk_rekod_status;
	private BaseModel<?> _staff_activeRemoteModel;
}