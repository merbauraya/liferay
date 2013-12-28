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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Mazlan Mat
 * @generated
 */
public class staff_activeSoap implements Serializable {
	public static staff_activeSoap toSoapModel(staff_active model) {
		staff_activeSoap soapModel = new staff_activeSoap();

		soapModel.setBp_name(model.getBp_name());
		soapModel.setBp_no_pekerja(model.getBp_no_pekerja());
		soapModel.setBp_no_kp(model.getBp_no_kp());
		soapModel.setBk_jab_hakiki(model.getBk_jab_hakiki());
		soapModel.setBk_jab_hakiki_desc(model.getBk_jab_hakiki_desc());
		soapModel.setBk_jab_sekarang(model.getBk_jab_sekarang());
		soapModel.setBk_jab_sekarang_desc(model.getBk_jab_sekarang_desc());
		soapModel.setBk_jaw_jenis(model.getBk_jaw_jenis());
		soapModel.setAl_alamat1(model.getAl_alamat1());
		soapModel.setAl_alamat2(model.getAl_alamat2());
		soapModel.setAl_alamat3(model.getAl_alamat3());
		soapModel.setAl_poskod(model.getAl_poskod());
		soapModel.setAl_bandar(model.getAl_bandar());
		soapModel.setAl_negeri(model.getAl_negeri());
		soapModel.setAl_negara(model.getAl_negara());
		soapModel.setBp_telefon(model.getBp_telefon());
		soapModel.setBp_email(model.getBp_email());
		soapModel.setBp_tjangka_bsara(model.getBp_tjangka_bsara());
		soapModel.setBp_rekod_status(model.getBp_rekod_status());
		soapModel.setBk_jaw_hakiki(model.getBk_jaw_hakiki());
		soapModel.setBk_jaw_hakiki_desc(model.getBk_jaw_hakiki_desc());
		soapModel.setBk_jaw_sekarang(model.getBk_jaw_sekarang());
		soapModel.setBk_jaw_sekarang_desc(model.getBk_jaw_sekarang_desc());
		soapModel.setBk_tarikh_lahir(model.getBk_tarikh_lahir());
		soapModel.setBk_tarikh_masuk(model.getBk_tarikh_masuk());
		soapModel.setBk_rekod_status(model.getBk_rekod_status());

		return soapModel;
	}

	public static staff_activeSoap[] toSoapModels(staff_active[] models) {
		staff_activeSoap[] soapModels = new staff_activeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static staff_activeSoap[][] toSoapModels(staff_active[][] models) {
		staff_activeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new staff_activeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new staff_activeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static staff_activeSoap[] toSoapModels(List<staff_active> models) {
		List<staff_activeSoap> soapModels = new ArrayList<staff_activeSoap>(models.size());

		for (staff_active model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new staff_activeSoap[soapModels.size()]);
	}

	public staff_activeSoap() {
	}

	public String getPrimaryKey() {
		return _bp_no_kp;
	}

	public void setPrimaryKey(String pk) {
		setBp_no_kp(pk);
	}

	public String getBp_name() {
		return _bp_name;
	}

	public void setBp_name(String bp_name) {
		_bp_name = bp_name;
	}

	public String getBp_no_pekerja() {
		return _bp_no_pekerja;
	}

	public void setBp_no_pekerja(String bp_no_pekerja) {
		_bp_no_pekerja = bp_no_pekerja;
	}

	public String getBp_no_kp() {
		return _bp_no_kp;
	}

	public void setBp_no_kp(String bp_no_kp) {
		_bp_no_kp = bp_no_kp;
	}

	public String getBk_jab_hakiki() {
		return _bk_jab_hakiki;
	}

	public void setBk_jab_hakiki(String bk_jab_hakiki) {
		_bk_jab_hakiki = bk_jab_hakiki;
	}

	public String getBk_jab_hakiki_desc() {
		return _bk_jab_hakiki_desc;
	}

	public void setBk_jab_hakiki_desc(String bk_jab_hakiki_desc) {
		_bk_jab_hakiki_desc = bk_jab_hakiki_desc;
	}

	public String getBk_jab_sekarang() {
		return _bk_jab_sekarang;
	}

	public void setBk_jab_sekarang(String bk_jab_sekarang) {
		_bk_jab_sekarang = bk_jab_sekarang;
	}

	public String getBk_jab_sekarang_desc() {
		return _bk_jab_sekarang_desc;
	}

	public void setBk_jab_sekarang_desc(String bk_jab_sekarang_desc) {
		_bk_jab_sekarang_desc = bk_jab_sekarang_desc;
	}

	public String getBk_jaw_jenis() {
		return _bk_jaw_jenis;
	}

	public void setBk_jaw_jenis(String bk_jaw_jenis) {
		_bk_jaw_jenis = bk_jaw_jenis;
	}

	public String getAl_alamat1() {
		return _al_alamat1;
	}

	public void setAl_alamat1(String al_alamat1) {
		_al_alamat1 = al_alamat1;
	}

	public String getAl_alamat2() {
		return _al_alamat2;
	}

	public void setAl_alamat2(String al_alamat2) {
		_al_alamat2 = al_alamat2;
	}

	public String getAl_alamat3() {
		return _al_alamat3;
	}

	public void setAl_alamat3(String al_alamat3) {
		_al_alamat3 = al_alamat3;
	}

	public String getAl_poskod() {
		return _al_poskod;
	}

	public void setAl_poskod(String al_poskod) {
		_al_poskod = al_poskod;
	}

	public String getAl_bandar() {
		return _al_bandar;
	}

	public void setAl_bandar(String al_bandar) {
		_al_bandar = al_bandar;
	}

	public String getAl_negeri() {
		return _al_negeri;
	}

	public void setAl_negeri(String al_negeri) {
		_al_negeri = al_negeri;
	}

	public String getAl_negara() {
		return _al_negara;
	}

	public void setAl_negara(String al_negara) {
		_al_negara = al_negara;
	}

	public String getBp_telefon() {
		return _bp_telefon;
	}

	public void setBp_telefon(String bp_telefon) {
		_bp_telefon = bp_telefon;
	}

	public String getBp_email() {
		return _bp_email;
	}

	public void setBp_email(String bp_email) {
		_bp_email = bp_email;
	}

	public Date getBp_tjangka_bsara() {
		return _bp_tjangka_bsara;
	}

	public void setBp_tjangka_bsara(Date bp_tjangka_bsara) {
		_bp_tjangka_bsara = bp_tjangka_bsara;
	}

	public String getBp_rekod_status() {
		return _bp_rekod_status;
	}

	public void setBp_rekod_status(String bp_rekod_status) {
		_bp_rekod_status = bp_rekod_status;
	}

	public String getBk_jaw_hakiki() {
		return _bk_jaw_hakiki;
	}

	public void setBk_jaw_hakiki(String bk_jaw_hakiki) {
		_bk_jaw_hakiki = bk_jaw_hakiki;
	}

	public String getBk_jaw_hakiki_desc() {
		return _bk_jaw_hakiki_desc;
	}

	public void setBk_jaw_hakiki_desc(String bk_jaw_hakiki_desc) {
		_bk_jaw_hakiki_desc = bk_jaw_hakiki_desc;
	}

	public String getBk_jaw_sekarang() {
		return _bk_jaw_sekarang;
	}

	public void setBk_jaw_sekarang(String bk_jaw_sekarang) {
		_bk_jaw_sekarang = bk_jaw_sekarang;
	}

	public String getBk_jaw_sekarang_desc() {
		return _bk_jaw_sekarang_desc;
	}

	public void setBk_jaw_sekarang_desc(String bk_jaw_sekarang_desc) {
		_bk_jaw_sekarang_desc = bk_jaw_sekarang_desc;
	}

	public Date getBk_tarikh_lahir() {
		return _bk_tarikh_lahir;
	}

	public void setBk_tarikh_lahir(Date bk_tarikh_lahir) {
		_bk_tarikh_lahir = bk_tarikh_lahir;
	}

	public Date getBk_tarikh_masuk() {
		return _bk_tarikh_masuk;
	}

	public void setBk_tarikh_masuk(Date bk_tarikh_masuk) {
		_bk_tarikh_masuk = bk_tarikh_masuk;
	}

	public String getBk_rekod_status() {
		return _bk_rekod_status;
	}

	public void setBk_rekod_status(String bk_rekod_status) {
		_bk_rekod_status = bk_rekod_status;
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
}