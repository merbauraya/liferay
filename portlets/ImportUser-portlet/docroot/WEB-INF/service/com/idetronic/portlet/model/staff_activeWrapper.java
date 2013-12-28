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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link staff_active}.
 * </p>
 *
 * @author    Mazlan Mat
 * @see       staff_active
 * @generated
 */
public class staff_activeWrapper implements staff_active,
	ModelWrapper<staff_active> {
	public staff_activeWrapper(staff_active staff_active) {
		_staff_active = staff_active;
	}

	public Class<?> getModelClass() {
		return staff_active.class;
	}

	public String getModelClassName() {
		return staff_active.class.getName();
	}

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

	/**
	* Returns the primary key of this staff_active.
	*
	* @return the primary key of this staff_active
	*/
	public java.lang.String getPrimaryKey() {
		return _staff_active.getPrimaryKey();
	}

	/**
	* Sets the primary key of this staff_active.
	*
	* @param primaryKey the primary key of this staff_active
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_staff_active.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bp_name of this staff_active.
	*
	* @return the bp_name of this staff_active
	*/
	public java.lang.String getBp_name() {
		return _staff_active.getBp_name();
	}

	/**
	* Sets the bp_name of this staff_active.
	*
	* @param bp_name the bp_name of this staff_active
	*/
	public void setBp_name(java.lang.String bp_name) {
		_staff_active.setBp_name(bp_name);
	}

	/**
	* Returns the bp_no_pekerja of this staff_active.
	*
	* @return the bp_no_pekerja of this staff_active
	*/
	public java.lang.String getBp_no_pekerja() {
		return _staff_active.getBp_no_pekerja();
	}

	/**
	* Sets the bp_no_pekerja of this staff_active.
	*
	* @param bp_no_pekerja the bp_no_pekerja of this staff_active
	*/
	public void setBp_no_pekerja(java.lang.String bp_no_pekerja) {
		_staff_active.setBp_no_pekerja(bp_no_pekerja);
	}

	/**
	* Returns the bp_no_kp of this staff_active.
	*
	* @return the bp_no_kp of this staff_active
	*/
	public java.lang.String getBp_no_kp() {
		return _staff_active.getBp_no_kp();
	}

	/**
	* Sets the bp_no_kp of this staff_active.
	*
	* @param bp_no_kp the bp_no_kp of this staff_active
	*/
	public void setBp_no_kp(java.lang.String bp_no_kp) {
		_staff_active.setBp_no_kp(bp_no_kp);
	}

	/**
	* Returns the bk_jab_hakiki of this staff_active.
	*
	* @return the bk_jab_hakiki of this staff_active
	*/
	public java.lang.String getBk_jab_hakiki() {
		return _staff_active.getBk_jab_hakiki();
	}

	/**
	* Sets the bk_jab_hakiki of this staff_active.
	*
	* @param bk_jab_hakiki the bk_jab_hakiki of this staff_active
	*/
	public void setBk_jab_hakiki(java.lang.String bk_jab_hakiki) {
		_staff_active.setBk_jab_hakiki(bk_jab_hakiki);
	}

	/**
	* Returns the bk_jab_hakiki_desc of this staff_active.
	*
	* @return the bk_jab_hakiki_desc of this staff_active
	*/
	public java.lang.String getBk_jab_hakiki_desc() {
		return _staff_active.getBk_jab_hakiki_desc();
	}

	/**
	* Sets the bk_jab_hakiki_desc of this staff_active.
	*
	* @param bk_jab_hakiki_desc the bk_jab_hakiki_desc of this staff_active
	*/
	public void setBk_jab_hakiki_desc(java.lang.String bk_jab_hakiki_desc) {
		_staff_active.setBk_jab_hakiki_desc(bk_jab_hakiki_desc);
	}

	/**
	* Returns the bk_jab_sekarang of this staff_active.
	*
	* @return the bk_jab_sekarang of this staff_active
	*/
	public java.lang.String getBk_jab_sekarang() {
		return _staff_active.getBk_jab_sekarang();
	}

	/**
	* Sets the bk_jab_sekarang of this staff_active.
	*
	* @param bk_jab_sekarang the bk_jab_sekarang of this staff_active
	*/
	public void setBk_jab_sekarang(java.lang.String bk_jab_sekarang) {
		_staff_active.setBk_jab_sekarang(bk_jab_sekarang);
	}

	/**
	* Returns the bk_jab_sekarang_desc of this staff_active.
	*
	* @return the bk_jab_sekarang_desc of this staff_active
	*/
	public java.lang.String getBk_jab_sekarang_desc() {
		return _staff_active.getBk_jab_sekarang_desc();
	}

	/**
	* Sets the bk_jab_sekarang_desc of this staff_active.
	*
	* @param bk_jab_sekarang_desc the bk_jab_sekarang_desc of this staff_active
	*/
	public void setBk_jab_sekarang_desc(java.lang.String bk_jab_sekarang_desc) {
		_staff_active.setBk_jab_sekarang_desc(bk_jab_sekarang_desc);
	}

	/**
	* Returns the bk_jaw_jenis of this staff_active.
	*
	* @return the bk_jaw_jenis of this staff_active
	*/
	public java.lang.String getBk_jaw_jenis() {
		return _staff_active.getBk_jaw_jenis();
	}

	/**
	* Sets the bk_jaw_jenis of this staff_active.
	*
	* @param bk_jaw_jenis the bk_jaw_jenis of this staff_active
	*/
	public void setBk_jaw_jenis(java.lang.String bk_jaw_jenis) {
		_staff_active.setBk_jaw_jenis(bk_jaw_jenis);
	}

	/**
	* Returns the al_alamat1 of this staff_active.
	*
	* @return the al_alamat1 of this staff_active
	*/
	public java.lang.String getAl_alamat1() {
		return _staff_active.getAl_alamat1();
	}

	/**
	* Sets the al_alamat1 of this staff_active.
	*
	* @param al_alamat1 the al_alamat1 of this staff_active
	*/
	public void setAl_alamat1(java.lang.String al_alamat1) {
		_staff_active.setAl_alamat1(al_alamat1);
	}

	/**
	* Returns the al_alamat2 of this staff_active.
	*
	* @return the al_alamat2 of this staff_active
	*/
	public java.lang.String getAl_alamat2() {
		return _staff_active.getAl_alamat2();
	}

	/**
	* Sets the al_alamat2 of this staff_active.
	*
	* @param al_alamat2 the al_alamat2 of this staff_active
	*/
	public void setAl_alamat2(java.lang.String al_alamat2) {
		_staff_active.setAl_alamat2(al_alamat2);
	}

	/**
	* Returns the al_alamat3 of this staff_active.
	*
	* @return the al_alamat3 of this staff_active
	*/
	public java.lang.String getAl_alamat3() {
		return _staff_active.getAl_alamat3();
	}

	/**
	* Sets the al_alamat3 of this staff_active.
	*
	* @param al_alamat3 the al_alamat3 of this staff_active
	*/
	public void setAl_alamat3(java.lang.String al_alamat3) {
		_staff_active.setAl_alamat3(al_alamat3);
	}

	/**
	* Returns the al_poskod of this staff_active.
	*
	* @return the al_poskod of this staff_active
	*/
	public java.lang.String getAl_poskod() {
		return _staff_active.getAl_poskod();
	}

	/**
	* Sets the al_poskod of this staff_active.
	*
	* @param al_poskod the al_poskod of this staff_active
	*/
	public void setAl_poskod(java.lang.String al_poskod) {
		_staff_active.setAl_poskod(al_poskod);
	}

	/**
	* Returns the al_bandar of this staff_active.
	*
	* @return the al_bandar of this staff_active
	*/
	public java.lang.String getAl_bandar() {
		return _staff_active.getAl_bandar();
	}

	/**
	* Sets the al_bandar of this staff_active.
	*
	* @param al_bandar the al_bandar of this staff_active
	*/
	public void setAl_bandar(java.lang.String al_bandar) {
		_staff_active.setAl_bandar(al_bandar);
	}

	/**
	* Returns the al_negeri of this staff_active.
	*
	* @return the al_negeri of this staff_active
	*/
	public java.lang.String getAl_negeri() {
		return _staff_active.getAl_negeri();
	}

	/**
	* Sets the al_negeri of this staff_active.
	*
	* @param al_negeri the al_negeri of this staff_active
	*/
	public void setAl_negeri(java.lang.String al_negeri) {
		_staff_active.setAl_negeri(al_negeri);
	}

	/**
	* Returns the al_negara of this staff_active.
	*
	* @return the al_negara of this staff_active
	*/
	public java.lang.String getAl_negara() {
		return _staff_active.getAl_negara();
	}

	/**
	* Sets the al_negara of this staff_active.
	*
	* @param al_negara the al_negara of this staff_active
	*/
	public void setAl_negara(java.lang.String al_negara) {
		_staff_active.setAl_negara(al_negara);
	}

	/**
	* Returns the bp_telefon of this staff_active.
	*
	* @return the bp_telefon of this staff_active
	*/
	public java.lang.String getBp_telefon() {
		return _staff_active.getBp_telefon();
	}

	/**
	* Sets the bp_telefon of this staff_active.
	*
	* @param bp_telefon the bp_telefon of this staff_active
	*/
	public void setBp_telefon(java.lang.String bp_telefon) {
		_staff_active.setBp_telefon(bp_telefon);
	}

	/**
	* Returns the bp_email of this staff_active.
	*
	* @return the bp_email of this staff_active
	*/
	public java.lang.String getBp_email() {
		return _staff_active.getBp_email();
	}

	/**
	* Sets the bp_email of this staff_active.
	*
	* @param bp_email the bp_email of this staff_active
	*/
	public void setBp_email(java.lang.String bp_email) {
		_staff_active.setBp_email(bp_email);
	}

	/**
	* Returns the bp_tjangka_bsara of this staff_active.
	*
	* @return the bp_tjangka_bsara of this staff_active
	*/
	public java.util.Date getBp_tjangka_bsara() {
		return _staff_active.getBp_tjangka_bsara();
	}

	/**
	* Sets the bp_tjangka_bsara of this staff_active.
	*
	* @param bp_tjangka_bsara the bp_tjangka_bsara of this staff_active
	*/
	public void setBp_tjangka_bsara(java.util.Date bp_tjangka_bsara) {
		_staff_active.setBp_tjangka_bsara(bp_tjangka_bsara);
	}

	/**
	* Returns the bp_rekod_status of this staff_active.
	*
	* @return the bp_rekod_status of this staff_active
	*/
	public java.lang.String getBp_rekod_status() {
		return _staff_active.getBp_rekod_status();
	}

	/**
	* Sets the bp_rekod_status of this staff_active.
	*
	* @param bp_rekod_status the bp_rekod_status of this staff_active
	*/
	public void setBp_rekod_status(java.lang.String bp_rekod_status) {
		_staff_active.setBp_rekod_status(bp_rekod_status);
	}

	/**
	* Returns the bk_jaw_hakiki of this staff_active.
	*
	* @return the bk_jaw_hakiki of this staff_active
	*/
	public java.lang.String getBk_jaw_hakiki() {
		return _staff_active.getBk_jaw_hakiki();
	}

	/**
	* Sets the bk_jaw_hakiki of this staff_active.
	*
	* @param bk_jaw_hakiki the bk_jaw_hakiki of this staff_active
	*/
	public void setBk_jaw_hakiki(java.lang.String bk_jaw_hakiki) {
		_staff_active.setBk_jaw_hakiki(bk_jaw_hakiki);
	}

	/**
	* Returns the bk_jaw_hakiki_desc of this staff_active.
	*
	* @return the bk_jaw_hakiki_desc of this staff_active
	*/
	public java.lang.String getBk_jaw_hakiki_desc() {
		return _staff_active.getBk_jaw_hakiki_desc();
	}

	/**
	* Sets the bk_jaw_hakiki_desc of this staff_active.
	*
	* @param bk_jaw_hakiki_desc the bk_jaw_hakiki_desc of this staff_active
	*/
	public void setBk_jaw_hakiki_desc(java.lang.String bk_jaw_hakiki_desc) {
		_staff_active.setBk_jaw_hakiki_desc(bk_jaw_hakiki_desc);
	}

	/**
	* Returns the bk_jaw_sekarang of this staff_active.
	*
	* @return the bk_jaw_sekarang of this staff_active
	*/
	public java.lang.String getBk_jaw_sekarang() {
		return _staff_active.getBk_jaw_sekarang();
	}

	/**
	* Sets the bk_jaw_sekarang of this staff_active.
	*
	* @param bk_jaw_sekarang the bk_jaw_sekarang of this staff_active
	*/
	public void setBk_jaw_sekarang(java.lang.String bk_jaw_sekarang) {
		_staff_active.setBk_jaw_sekarang(bk_jaw_sekarang);
	}

	/**
	* Returns the bk_jaw_sekarang_desc of this staff_active.
	*
	* @return the bk_jaw_sekarang_desc of this staff_active
	*/
	public java.lang.String getBk_jaw_sekarang_desc() {
		return _staff_active.getBk_jaw_sekarang_desc();
	}

	/**
	* Sets the bk_jaw_sekarang_desc of this staff_active.
	*
	* @param bk_jaw_sekarang_desc the bk_jaw_sekarang_desc of this staff_active
	*/
	public void setBk_jaw_sekarang_desc(java.lang.String bk_jaw_sekarang_desc) {
		_staff_active.setBk_jaw_sekarang_desc(bk_jaw_sekarang_desc);
	}

	/**
	* Returns the bk_tarikh_lahir of this staff_active.
	*
	* @return the bk_tarikh_lahir of this staff_active
	*/
	public java.util.Date getBk_tarikh_lahir() {
		return _staff_active.getBk_tarikh_lahir();
	}

	/**
	* Sets the bk_tarikh_lahir of this staff_active.
	*
	* @param bk_tarikh_lahir the bk_tarikh_lahir of this staff_active
	*/
	public void setBk_tarikh_lahir(java.util.Date bk_tarikh_lahir) {
		_staff_active.setBk_tarikh_lahir(bk_tarikh_lahir);
	}

	/**
	* Returns the bk_tarikh_masuk of this staff_active.
	*
	* @return the bk_tarikh_masuk of this staff_active
	*/
	public java.util.Date getBk_tarikh_masuk() {
		return _staff_active.getBk_tarikh_masuk();
	}

	/**
	* Sets the bk_tarikh_masuk of this staff_active.
	*
	* @param bk_tarikh_masuk the bk_tarikh_masuk of this staff_active
	*/
	public void setBk_tarikh_masuk(java.util.Date bk_tarikh_masuk) {
		_staff_active.setBk_tarikh_masuk(bk_tarikh_masuk);
	}

	/**
	* Returns the bk_rekod_status of this staff_active.
	*
	* @return the bk_rekod_status of this staff_active
	*/
	public java.lang.String getBk_rekod_status() {
		return _staff_active.getBk_rekod_status();
	}

	/**
	* Sets the bk_rekod_status of this staff_active.
	*
	* @param bk_rekod_status the bk_rekod_status of this staff_active
	*/
	public void setBk_rekod_status(java.lang.String bk_rekod_status) {
		_staff_active.setBk_rekod_status(bk_rekod_status);
	}

	public boolean isNew() {
		return _staff_active.isNew();
	}

	public void setNew(boolean n) {
		_staff_active.setNew(n);
	}

	public boolean isCachedModel() {
		return _staff_active.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_staff_active.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _staff_active.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _staff_active.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_staff_active.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _staff_active.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_staff_active.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new staff_activeWrapper((staff_active)_staff_active.clone());
	}

	public int compareTo(com.idetronic.portlet.model.staff_active staff_active) {
		return _staff_active.compareTo(staff_active);
	}

	@Override
	public int hashCode() {
		return _staff_active.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.idetronic.portlet.model.staff_active> toCacheModel() {
		return _staff_active.toCacheModel();
	}

	public com.idetronic.portlet.model.staff_active toEscapedModel() {
		return new staff_activeWrapper(_staff_active.toEscapedModel());
	}

	public com.idetronic.portlet.model.staff_active toUnescapedModel() {
		return new staff_activeWrapper(_staff_active.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _staff_active.toString();
	}

	public java.lang.String toXmlString() {
		return _staff_active.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_staff_active.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof staff_activeWrapper)) {
			return false;
		}

		staff_activeWrapper staff_activeWrapper = (staff_activeWrapper)obj;

		if (Validator.equals(_staff_active, staff_activeWrapper._staff_active)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public staff_active getWrappedstaff_active() {
		return _staff_active;
	}

	public staff_active getWrappedModel() {
		return _staff_active;
	}

	public void resetOriginalValues() {
		_staff_active.resetOriginalValues();
	}

	private staff_active _staff_active;
}